ImageSliderView
===============
**ImageSliderView** is widget with `ViewPager` to add indicators to make ImageSlider. widget can be used it as Image Slider or set pages with custom indicators.

(Coming Soon)Try out the sample application InnovativeLibrary or visit [Android Market](https://play.google.com/store/apps/dev?id=6632338653706851847&hl=en).

![alt tag](https://github.com/theshivamlko/ImageSliderViewExample/blob/master/SlideShow.gif)


Usage
=====

*Working implementation of this project see the `app/` folder.*

  1.    Include one of the widgets in your view. This should usually be placed instead of `ViewPager`.
        
               
                   <com.shivam.library.imageslider.ImageSlider
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:id="@+id/pager"
                        /> 

  2.    In your `onCreate method` (or `onCreateView` for a fragment), bind the indicator and pages to the ImageSlide.
                
                    // set view with adpater
                    ImageSlider slider = (ImageSlider) findViewById(R.id.pager);
                    SectionsPagerAdapter  mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
                    slider.setAdapter(mSectionsPagerAdapter);

  3.    *Options*
        
- `custom:showIndicators=false` ,attribute layout xml, hide Indicators hence can be used as simple viewpager,
        by default  `true`. If any problem use :  `slider.showIndicators(false)`.
                
- `slider.setAdapter(mSectionsPagerAdapter)` , set adapter to `ImageSlide` , 
        automatic add number of indicators according to `mSectionsPagerAdapter` .
                
- ` ViewPager pager = slider.getViewPager(); `, get ViewPager from `ImageSlider` .
                
- set custom indicators ,by default circle indicators are set
   ```
   int[] indicators={R.mipmap.indicator1,R.mipmap.indicator2};
   slider.setCustomIndicators(indicators);

   ```
   
- ` setIndicatorsSize(20);   // in dp `

Update
======

- v1.1 Page Animation
    `slider.setPageAnimation(PageAnimation.CARD_STACK);`   // other: PARALLAX, FADE

- v1.0 ImageSlide indicators

Including In Your Project
-------------------------

- **Gradle**  
  `compile 'com.shivam.library:imageslider:1.1@aar'`
  
  <a href="http://www.methodscount.com/?lib=com.shivam.library%3Aimageslider%3A1.1"><img src="https://img.shields.io/badge/Methods and size-core: 83 | deps: 8611 | 15 KB-e91e63.svg"/></a>


Developed By
============

- Shivam Srivastava - <srishivam.9@gmail.com>

License
=======

    Copyright 2016 Shivam Srivastava

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
