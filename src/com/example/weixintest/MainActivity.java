package com.example.weixintest;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
	// RadioButton控件
	private RadioButton mRadio_chats, mRadio_contacts, mRadio_discover,
			mRadio_me;
	private ArrayList<Fragment> mFragmentList;
	private RadioGroup mRadioGroup;

	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		super.onCreate(bundle);
		setContentView(R.layout.activity_main);
		initView();
		initViewPage();
	}

	private void initViewPage() {
		mViewPager = (ViewPager) this.findViewById(R.id.main_viewpager);
		mFragmentList = new ArrayList<Fragment>();
		mRadioGroup = (RadioGroup) findViewById(R.id.main_tab_radiogroup);
		Fragment chatsFragment = new ChatsFragment();
		Fragment contactsFragment = new ContactsFragment();
		Fragment discoverFragment = new DiscoverFragment();
		Fragment meFragment = new MeFragment();
		mFragmentList.add(chatsFragment);
		mFragmentList.add(contactsFragment);
		mFragmentList.add(discoverFragment);
		mFragmentList.add(meFragment);
		mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),
				mFragmentList));
		mViewPager.setCurrentItem(0);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					mRadioGroup.check(R.id.radio_chart);
					Log.i("sdadfasd", arg0 + "");
					break;
				case 1:
					mRadioGroup.check(R.id.radio_contacts);
					Log.i("sdadfasd", arg0 + "");
					break;
				case 2:
					mRadioGroup.check(R.id.radio_discover);
					Log.i("sdadfasd", arg0 + "");
					break;
				case 3:
					mRadioGroup.check(R.id.radio_me);
					Log.i("sdadfasd", arg0 + "");
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		mRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// 获取当前被选中的RadioButton的ID，用于改变ViewPager的当前页
				int current = 0;
				switch (checkedId) {
				case R.id.radio_chart:
					current = 0;
					break;
				case R.id.radio_contacts:
					current = 1;
					break;
				case R.id.radio_discover:
					current = 2;
					break;
				case R.id.radio_me:
					current = 3;
					break;
				default:
					break;
				}
				mViewPager.setCurrentItem(current);
			}
		});
	}

	private void initView() {

		mRadio_chats = (RadioButton) this.findViewById(R.id.radio_chart);
		mRadio_contacts = (RadioButton) this.findViewById(R.id.radio_contacts);
		mRadio_discover = (RadioButton) this.findViewById(R.id.radio_discover);
		mRadio_me = (RadioButton) this.findViewById(R.id.radio_me);
	}

	public class MyAdapter extends FragmentPagerAdapter {
		ArrayList<Fragment> list;

		public MyAdapter(FragmentManager fm, ArrayList<Fragment> list) {
			super(fm);
			this.list = list;
		}

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			return list.size();
		}
	}
}
