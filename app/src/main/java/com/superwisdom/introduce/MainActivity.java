package com.superwisdom.introduce;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ViewPager viewPager;
    private List<View> viewList_one;
    private  View view0,view1,view2,view3,view4;
    private ImageView[] dots;
    private int[] ids = {R.id.iv_dot_01,R.id.iv_dot_02,R.id.iv_dot_03,R.id.iv_dot_04,R.id.iv_dot_05};

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPaper();
    }

    private void ViewPaper() {
        viewPager = (ViewPager)this.findViewById(R.id.viewPager);
        LayoutInflater inflater = getLayoutInflater();
        view0 = inflater.inflate(R.layout.frist,null);
        view1 = inflater.inflate(R.layout.second,null);
        view2 = inflater.inflate(R.layout.thrid,null);
        view3 = inflater.inflate(R.layout.fourth,null);
        view4 = inflater.inflate(R.layout.fifth,null);
        viewList_one = new ArrayList<>();
        viewList_one.add(view0);
        viewList_one.add(view1);
        viewList_one.add(view2);
        viewList_one.add(view3);
        viewList_one.add(view4);

         PagerAdapter pagerAdapter_one = new PagerAdapter() {
             @Override
            public int getCount() {
                return viewList_one.size();
            }
            @Override
            public boolean isViewFromObject(View arg0, Object arg1)
            {
                return arg0 == arg1;
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView(viewList_one.get(position));
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                container.addView(viewList_one.get(position));
                return viewList_one.get(position);
            }
        };
        viewPager.setAdapter(pagerAdapter_one);

        dots = new ImageView[viewList_one.size()];
        for (int i = 0 ; i < viewList_one.size() ; i ++ ) {
            dots[i] = (ImageView) this.findViewById(ids [i]);
        }

        ViewPager.OnPageChangeListener mListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0)
            {

            }
            @Override
            public void onPageSelected(int arg0)
            {

            }
            @Override
            public void onPageScrolled(int arg0, float v, int t)
            {
                for (int i = 0 ; i < ids.length ; i ++)
                {
                    if (arg0 == i)
                    {
                        dots[i].setImageResource(R.drawable.iv_dot_01);
                    }else
                    {
                        dots[i].setImageResource(R.drawable.iv_dot_02);
                    }
                }
            }
        };
        viewPager.addOnPageChangeListener(mListener);
    }
}
