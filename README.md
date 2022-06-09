![alt tag](screen-porto-tech-center.jpg)

Jumia Porto Tech Center (PTC) is an Agile IT development center, with around 200 IT-specialists, 
where you will have the opportunity to participate in developing smart solutions for our group companies. 
We do e-commerce shops, logistics, business intelligence and mobile applications involving a wide range of high-end technologies for tens of millions customers.  

You can check our job opportunities at our site: https://group.jumia.com/careers.  

We are passionate about what we do, and we have fun while doing it. 

We will offer you second home where you will find the opportunity for growth and career development.
You will have the opportunity to earn the bonus based on your excellent results. 
The benefit list includes but is not limited to health insurance, parental bonus, snacks and fruits.

This repo represents the current admission test that is needed to apply for an Android Developer Position.

Android Challenge:
-

The idea is to create an app that is able to list products requested by a query.

The challenge Submission:

- Create a pull request using the base "development_mocklab"
- Title format "Challenge Admission Test - FIRST_NAME LAST_NAME"
- Write a description about your implementation

Required tech implementations:
-

- Android Architecture Components;
- Material Design Components;
- Kotlin;

We value the following implementations:
-

- Jetpack Compose or DataBinding for UI;
- Coroutines (Suspend/Flow/Channels);
- Image Loader (Glide/Volley/Picasso);
- Retrofit/OKHttp client for API communication;
- Animations;
- Unit tests;


Description:
-

The application should be composed by:

    - Splash screen 
    - Search page 
    - Result list page 
    - Item detail page

The following requirements need to be met:

The search must be able to list items from a query.

1. The splash screen:
    - It's a loading page to request and save some configurations to be used. 

2. The search page:
    - It's a page that allow the submission of a query to get a result, like Google Search.
    - It can be in the same page as the result list page

3. The result list page:
    - It's a page that shows the query and respective result, like Google Search.
    - For each result item, the following should be displayed:
        - Image;
        - Name and brand;
        - Price, old price and discount;
        - Rating;

4. The item detail page:
    - It's a page that shows the information about the selected item
    - The following should be displayed:
        - Image or image gallery;
        - Name and brand;
        - Price, old price and discount;
        - Rating;
        - Description;

Mock API: 
-

NOTE: The mocklab API is based in JSON mocks and only supports the following requests.

- Get configurations

    > http://nd7d1.mocklab.io/configurations/
    
    The currency should used to format the price and old price.

- Get list items with pagination

    > http://nd7d1.mocklab.io/search/phone/page/1/
    
    > http://nd7d1.mocklab.io/search/phone/page/2/

    Parameters:
    - *"phone"* - the query
    - *"1"* - the page number (pagination)

- Get detail item

    > http://nd7d1.mocklab.io/product/1/

    > http://nd7d1.mocklab.io/product/2/

    Parameters:
    - *"1"* - the product identifier "sku"
    
    
- Failure cases

    HTTP 200 - Success false:
    > http://nd7d1.mocklab.io/product/3/
    
    HTTP 404 - Not Found:
    > http://nd7d1.mocklab.io/search/phone/page/2/
    
    > http://nd7d1.mocklab.io/product/4/


Sample screens: (Phones List and Phone Detail)
-

<div><img src="https://github.com/bernardopinaptc/ptc_android_test/blob/development_mocklab/screen_1.jpg?raw=true" width="260" height="420"/><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAABCAYAAADeko4lAAAAEElEQVR42mNk+M9Qz0BFAAB1hgGA401i0gAAAABJRU5ErkJggg==" width="20">
<img src="https://github.com/bernardopinaptc/ptc_android_test/blob/development_mocklab/screen_2.jpg?raw=true" width="260" height="420"/>
    </div>
    
    
