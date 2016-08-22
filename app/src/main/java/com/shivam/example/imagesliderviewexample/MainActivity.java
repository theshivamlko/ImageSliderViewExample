package com.shivam.example.imagesliderviewexample;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.shivam.library.imageslider.ImageSlider;
import com.shivam.library.imageslider.ImageSlider.PageAnimation;

public class MainActivity extends AppCompatActivity {

    // custom indicators ids
    private int[] images={R.drawable.pic,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageSlider slider = (ImageSlider) findViewById(R.id.pager);
      SectionsPagerAdapter  mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        slider.setAdapter(mSectionsPagerAdapter);

        Bundle bundle=getIntent().getExtras();

        if(bundle.getBoolean("button1"));    // ImageSlide by default set only adapter

        else if(bundle.getBoolean("button2",false))
            slider.setCustomIndicators(bundle.getIntArray("indicator"));   // set custom indicator type 1


        else if(bundle.getBoolean("button3",false))
            slider.setCustomIndicators(bundle.getIntArray("indicator"));   // set custom indicator type 2


        else if(bundle.getBoolean("button4",false))
          slider.showIndicators(false);                                // show/hide indicator

        int size=bundle.getInt("size",10);

        if(size!=0)
      slider.setIndicatorsSize(size);      // set indicator size, set 10 it by default (dp)

        ViewPager pager = slider.getViewPager();   // perform other operations on pager

        // set animation
     switch (bundle.getString("anim")) {
         case "Card Stack":slider.setPageAnimation(PageAnimation.CARD_STACK); break;
         case "Parallax":slider.setPageAnimation(PageAnimation.PARALLAX); break;
         case "Fade":slider.setPageAnimation(PageAnimation.FADE); break;
     }

    }

    // dummy fragment
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {

        }

        public static PlaceholderFragment newInstance(Integer pic) {

            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt("index", pic);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main3, container, false);
            Bundle args = getArguments();
            int index = args.getInt("index", 0);
            ImageView imageView=(ImageView)rootView.findViewById(R.id.image);
            imageView.setImageResource(index);
            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {   // adapter to set in ImageSlider

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return PlaceholderFragment.newInstance(images[position]);
        }

        @Override
        public int getCount() {

            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return null;
        }
    }
}
