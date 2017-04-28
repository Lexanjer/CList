package ru.example.checklist;


import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class ActivityLight extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    static final String TAG = "myLogs";
    //  static int PAGE_COUNT;

    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
				
				
				
				
        setTheme(R.style.AppLight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);


        DataBase dataBase = new DataBase(this);
        Toast.makeText(this, "здесь выводится база "
                , Toast.LENGTH_LONG).show();
        Log.d(TAG, "Vcem privet----------------- Activity Light ");  // + dataBase.getCheckList(1).toString());


        MainActivity.PAGE_COUNT = dataBase.getCount();
        //   System.out.println(dataBase.getCheckList1().toString());
        //   Log.d(TAG, "Vcem privet----------------- "+dataBase.getCheckList(1).toString() );

				pager = (ViewPager) findViewById(R.id.pager);
				pager.setBackgroundColor(0x7f7f7f);
				
				
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


    
}

