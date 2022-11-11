package com.ptc.challenge.presentation.view

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.ptc.challenge.R
import com.ptc.challenge.presentation.viewmodel.ConfigurationsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ConfigurationsViewModel>()
    private var configurationsLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl_repos, ProductsListFragment.newInstance(), "ProductsListFragment")
                .commit()
        }

        observeViewModel()
        viewModel.loadConfigurations()
        setupSplashScreen(splashScreen)
    }

    private fun observeViewModel() {

        lifecycleScope.launchWhenStarted {

            launch {

                viewModel.configurationsLiveData().collect {
                    if (it != null)
                        configurationsLoaded = true
                }
            }

            launch {

                viewModel.errorLiveData().collect {
                    if (it != null) {
                        it.printStackTrace()
                        configurationsLoaded = true
                    }
                }
            }
        }
    }

    private fun setupSplashScreen(splashScreen: SplashScreen) {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (configurationsLoaded) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else false
                }
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)

        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView
        searchView.queryHint = getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                val fragment =
                    supportFragmentManager.findFragmentByTag("ProductsListFragment") as ProductsListFragment

                if (fragment.isVisible)
                    fragment.search(query)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}