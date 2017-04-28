

package ru.example.checklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;



/*
            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:id="@+id/button_start_basic"
                android:onClick="onStartBasicActivity"
                android:text="@string/start_default" />

				 public void onStartBasicActivity(View view) {
        Log.d(mLogTag, "** starting BasicActivity");

        // Start an Activity with the default options in the 'singleTask' launch mode as defined in
        // the AndroidManifest.xml.
        startActivity(new Intent(this, BasicActivity.class));

    }

				     <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:id="@+id/start_unresizable"
                android:onClick="onStartUnresizableClick"
                android:text="@string/start_unresizable" />


				  public void onStartUnresizableClick(View view) {
        Log.d(mLogTag, "** starting UnresizableActivity");

         * This activity is marked as 'unresizable' in the AndroidManifest. We need to specify the
         * FLAG_ACTIVITY_NEW_TASK flag here to launch it into a new task stack, otherwise the
         * properties from the root activity would have been inherited (which was here marked as
         * resizable by default).
        Intent intent = new Intent(this, UnresizableActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        }

        */


public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    static final String TAG = "myLogs";
    //static int PAGE_COUNT ;
    static int PAGE_COUNT;

    private static final int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    private TabsFragmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationView();
        initTabs();
        DataBase dataBase = new DataBase(this);
    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new TabsFragmentAdapter(getApplicationContext(), getSupportFragmentManager(), new ArrayList<RemindDTO>());
        viewPager.setAdapter(adapter);

        //     new RemindMeTask().execute();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.actionNotificationItem:
                        showNotificationTab();
                }
                return true;
            }
        });
    }

    private void showNotificationTab() {

        viewPager.setCurrentItem(Constants.TAB_TWO);
    }

    public void onStartBasicActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityLight.class);
        startActivity(intent);

    }

		
		/*
    private class RemindMeTask extends AsyncTask<Void, Void, RemindDTO> {

        @Override
        protected RemindDTO doInBackground(Void... params) {
            RestTemplate template = new RestTemplate();
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            return template.getForObject(Constants.URL.GET_REMIND, RemindDTO.class);
        }

        @Override
        protected void onPostExecute(RemindDTO remindDTO) {
            List<RemindDTO> data = new ArrayList<>();
            data.add(remindDTO);

            adapter.setData(data);
        }
    }
		
		*/
}
