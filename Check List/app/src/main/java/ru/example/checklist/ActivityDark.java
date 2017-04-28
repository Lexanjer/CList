package ru.example.checklist;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.Toast;


public class ActivityDark extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    static final String TAG = "myLogs";
    // static int PAGE_COUNT;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    private TabsFragmentAdapter adapter;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    static int ptsTextSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDark);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark);


   /*     DrawerLayout rootlayout = (DrawerLayout) findViewById(R.id.root_layout);
        rootlayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkAppDark));

        //	rootlayout.setTextC

        ImageView ramka = (ImageView) findViewById(R.id.imageView2);
        ramka.setBackground(getResources().getDrawable(R.drawable.roundrect_layout_dark));

        CoordinatorLayout coorlayout = (CoordinatorLayout) findViewById(R.id.coordl2);
        coorlayout.setBackground(getResources().getDrawable(R.drawable.roundrect));//_dark

        ImageView background = (ImageView) findViewById(R.id.imageBackground);
        background.setImageDrawable(getResources().getDrawable(R.drawable.bordo));

        PagerTitleStrip pts = (PagerTitleStrip) findViewById(R.id.titleStrip);
        //ptsTextSize = 24;
        pts.setBackgroundColor(R.drawable.roundrect_pager_dark);
        pts.setTextColor(0xffffffff); //(R.color.colorWhite);
        //	pts.setTextSize(ptsTextSize,);


        NavigationView navView = (NavigationView) findViewById(R.id.navigationView);
        navView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDarkAppDark));

*/
        initToolbar();

        PagerTitleStrip pts = (PagerTitleStrip) findViewById(R.id.titleStrip);
        //ptsTextSize = 24;

        pts.setTextColor(getResources().getColor(R.color.colorWhite)); //(R.color.colorWhite);
        	pts.setTextSize((TypedValue.COMPLEX_UNIT_DIP), 24);

        DataBase dataBase = new DataBase(this);
        Toast.makeText(this, "здесь выводится база "
                , Toast.LENGTH_LONG).show();
        Log.d(TAG, "Vcem privet---------   Activity Dark  -------- ");


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
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu_dark);
    }
}


