package ru.example.checklist;

import android.os.*;
import android.support.design.widget.*;
import android.support.v4.view.*;
import android.support.v4.widget.*;
import android.support.v7.app.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class ActivityDark extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    static final String TAG = "myLogs";
   // static int PAGE_COUNT;

    ViewPager pager;
    PagerAdapter pagerAdapter;
		static int ptsTextSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDark);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

				
					
				DrawerLayout rootlayout = (DrawerLayout) findViewById(R.id.root_layout);
				rootlayout.setBackgroundColor(R.color.colorPrimaryAppDark);
			//	rootlayout.setTextC
				
				ImageView ramka = (ImageView) findViewById(R.id.imageView2);
				ramka.setBackgroundColor(R.drawable.roundrect_layout_dark);
				
				CoordinatorLayout coorlayout = (CoordinatorLayout) findViewById(R.id.coordl2);
				coorlayout.setBackgroundColor(R.drawable.roundrect);//_dark
				
				ImageView background = (ImageView) findViewById(R.id.imageBackground);
				background.setBackgroundColor(R.drawable.bordo);
				
				PagerTitleStrip pts = (PagerTitleStrip) findViewById(R.id.titleStrip);
				//ptsTextSize = 24;
				pts.setBackgroundColor(R.drawable.roundrect_pager_dark);
				pts.setTextColor(0xffffffff); //(R.color.colorWhite);
			//	pts.setTextSize(ptsTextSize,);				
				
			
			NavigationView navView = (NavigationView) findViewById(R.id.navigationView);
			navView.setBackgroundColor(R.color.colorPrimaryAppDark);
			
			
			//	initToolbar();
			
        DataBase dataBase = new DataBase(this);
        Toast.makeText(this, "здесь выводится база "
                , Toast.LENGTH_LONG).show();
        Log.d(TAG, "Vcem privet---------   Activity Dark  -------- " );


        MainActivity.PAGE_COUNT = dataBase.getCount();
        //   System.out.println(dataBase.getCheckList1().toString());
        //   Log.d(TAG, "Vcem privet----------------- "+dataBase.getCheckList(1).toString() );

        pager = (ViewPager) findViewById(R.id.pager);
       
				pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
				
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

		private void initToolbar() {
      Toolbar  toolBar = (Toolbar) findViewById(R.id.toolBar);
        toolBar.setTitle(R.string.app_name);
		//		toolbar.setTextColor 
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
								@Override
								public boolean onMenuItemClick(MenuItem menuItem) {
										return false;
								}
						});

        toolBar.inflateMenu(R.menu.tb_menu);
    }
    
}


