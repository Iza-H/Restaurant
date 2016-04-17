package io.projectandroid.restaurant.fragment;


import android.os.Bundle;
import android.app.FragmentManager;

import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import io.projectandroid.restaurant.R;
import io.projectandroid.restaurant.model.Table;
import io.projectandroid.restaurant.model.Tables;

/**
 * A simple {@link Fragment} subclass.
 */
public class TablePagerFragment extends Fragment {

    public static final String ARG_TABLE_INDEX = "arg_table_index";

    private Integer mInitialTableIndex;
    private ViewPager mPager;
    private Tables mTables;


    public TablePagerFragment() {
        // Required empty public constructor
    }


    public static TablePagerFragment newInstance(int position) {
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_TABLE_INDEX, position);

        TablePagerFragment fragment = new TablePagerFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if(getArguments()!=null){
            mInitialTableIndex = getArguments().getInt(ARG_TABLE_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_table_pager, container, false);
        mTables = new Tables();
        mPager = (ViewPager) root.findViewById(R.id.view_pager);
        mPager.setAdapter(new TablePagerAdapter(getFragmentManager(), mTables));

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateTableInfo();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mPager.setCurrentItem(mInitialTableIndex);
        updateTableInfo();
        return root;
    }

    public void updateTableInfo(){
        int position = mPager.getCurrentItem();
        if (getActivity() instanceof AppCompatActivity){
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            ActionBar actionBar = activity.getSupportActionBar();
            //actionBar.setTitle(mTables.getTables().get(position).getName());
        }
    }

    public void showTable(int position){
        mPager.setCurrentItem(position);
        updateTableInfo();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_tool_bar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean value =  super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.prev){
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            updateTableInfo();
            return true;
        } else if (item.getItemId() == R.id.next){
            mPager.setCurrentItem(mPager.getCurrentItem() + 1);
            updateTableInfo();
            return true;
        }
        return value;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (mPager!=null){
            MenuItem prevItem = menu.findItem(R.id.prev);
            MenuItem nextItem = menu.findItem(R.id.next);
            nextItem.setEnabled(mPager.getCurrentItem()<mTables.getTables().size() - 1);
            prevItem.setEnabled(mPager.getCurrentItem()>0);

        }
    }
}

class TablePagerAdapter extends FragmentPagerAdapter {
    private Tables mTables;

    public TablePagerAdapter (FragmentManager fm, Tables tables){
        super(fm);
        mTables = tables;
    }


    @Override
    public  android.app.Fragment getItem(int position) {
         Table table = mTables .getTables().get(position);
         TableFragment fragment = new TableFragment().newInstance(table);
         return fragment;
    }

    @Override
    public int getCount() {
        return mTables.getTables().size();
    }




}
