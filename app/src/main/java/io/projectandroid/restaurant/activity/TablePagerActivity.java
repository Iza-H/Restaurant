package io.projectandroid.restaurant.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import io.projectandroid.restaurant.R;
import io.projectandroid.restaurant.fragment.TablePagerFragment;

/**
 * Created by izabela on 16/04/16.
 */
public class TablePagerActivity extends AppCompatActivity{

    public static final String EXTRA_TABLE_INDEX = "table_index";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_pager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int initTableIndex=getIntent().getIntExtra(EXTRA_TABLE_INDEX, 0);


        FragmentManager fm  = getFragmentManager();
        if (fm.findFragmentById(R.id.fragment_table_pager)==null){
            Fragment tp = TablePagerFragment.newInstance(initTableIndex);
            fm.beginTransaction().add(R.id.fragment_table_pager, tp).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean value = super.onOptionsItemSelected(item);
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return value;
    }
}
