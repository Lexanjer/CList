package ru.example.checklist;

import android.support.v4.app.*;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter
{


		

		MyFragmentPagerAdapter(FragmentManager fm) {
				super(fm);

		}

		
		@Override
		public Fragment getItem(int position) {
				return PageFragment.newInstance(position);
		}

		@Override
		public int getCount() {
				return MainActivity.PAGE_COUNT;
		}

		@Override
		public CharSequence getPageTitle(int position) {

				//  Log.d(TAG, "------------------------"+title);
				return DataBase.getCheckName(position);
		}

}

