package com.ptc.challenge.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ptc.challenge.R
import com.ptc.challenge.presentation.uimodel.ProductUiModel
import com.squareup.picasso.Picasso

class ProductsAdapter : ListAdapter<ProductUiModel, ProductsAdapter.DataViewHolder>(DiffCallback) {

    private var onItemClickListener: OnItemClickListener? = null

    companion object DiffCallback : DiffUtil.ItemCallback<ProductUiModel>() {
        override fun areItemsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductUiModel, newItem: ProductUiModel): Boolean {
            return oldItem.name == newItem.name
        }
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val llProduct: ConstraintLayout = itemView.findViewById(R.id.ll_product)
        private val ivImage: AppCompatImageView = itemView.findViewById(R.id.iv_product_image)
        private val tvBrand: AppCompatTextView = itemView.findViewById(R.id.tv_product_brand)
        private val tvName: AppCompatTextView = itemView.findViewById(R.id.tv_product_name)
        private val tvSpecialPrice: AppCompatTextView =
            itemView.findViewById(R.id.tv_product_special_price)
        private val tvPrice: AppCompatTextView = itemView.findViewById(R.id.tv_product_price)
        private val tvDiscount: AppCompatTextView = itemView.findViewById(R.id.tv_product_discount)
        private val rbRating: RatingBar = itemView.findViewById(R.id.rb_product_rating)

        fun bind(productUiModel: ProductUiModel) {
            Picasso.get()
                .load(productUiModel.imageUrl)
                .into(ivImage)
            tvBrand.text = productUiModel.brand
            tvName.text = productUiModel.name
            tvPrice.text = productUiModel.price
            tvDiscount.text = productUiModel.maxSavingPercentage.toString() + " %"
            tvSpecialPrice.text = productUiModel.specialPrice
            rbRating.rating = productUiModel.averageRating?.toFloat() ?: 0f
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        holder.bind(getItem(position))
        holder.llProduct.setOnClickListener {
            onItemClickListener?.onItemClicked(getItem(position))
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClicked(productUiModel: ProductUiModel)
    }
}