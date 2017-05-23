package ru.example.checklist;

import android.content.Intent;
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
import android.widget.ImageView;
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
    private ImageView background;
    private int backgrountCount = 0;
    private int[] backgrounds = {R.drawable.background1, R.drawable.background2, R.drawable.background3,
            R.drawable.background4, R.drawable.background5, R.drawable.background6, R.drawable.background7,
            R.drawable.background8, R.drawable.bordo, R.drawable.background10, R.drawable.background11};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDark);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark);


        initToolbar();

        PagerTitleStrip pts = (PagerTitleStrip) findViewById(R.id.titleStrip);
        //ptsTextSize = 24;

        background = (ImageView) findViewById(R.id.imageBackground);
        background.setImageDrawable(getResources().getDrawable(backgrounds[3]));


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
        pager.setPageTransformer(true, new FlipHorizontalTransformer());
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
                switch (menuItem.getItemId()) {
                    case R.id.restart:
                        restartActivity();
                        break;
                    case R.id.changetheme:
                        changeTheme();
                        break;


                }
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu_dark);
    }

    public void restartActivity() {

        Intent intent = new Intent(this, ActivityDark.class);
        startActivity(intent);
        finish();

    }

    public void changeTheme() {

        backgrountCount = backgrountCount +1;
        Toast.makeText(this, "backgrountCount "+backgrountCount
                , Toast.LENGTH_SHORT).show();
        if (backgrountCount> 10) backgrountCount = 0;
        background.setImageDrawable(getResources().getDrawable(backgrounds[backgrountCount]));

    }


    private void getChecketPositions() {

        Bundle bd = new Bundle();
        //		PageFragment pg = PageFragment.;

        for (int i = 0; i < MainActivity.PAGE_COUNT; i++) {

        }

    }

    private void setCheckedPositions() {
    }

}


