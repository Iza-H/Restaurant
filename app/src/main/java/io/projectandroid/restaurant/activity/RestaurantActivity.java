package io.projectandroid.restaurant.activity;




import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.projectandroid.restaurant.R;
import io.projectandroid.restaurant.fragment.TableListFragment;
import io.projectandroid.restaurant.fragment.TablePagerFragment;
import io.projectandroid.restaurant.model.Table;


public class RestaurantActivity extends AppCompatActivity implements TableListFragment.TableListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        FragmentManager fm  = getFragmentManager();
        if (findViewById(R.id.fragment_table_list)!=null) {
            if (fm.findFragmentById(R.id.fragment_table_list) == null) {
                Fragment tp = new TableListFragment();
                fm.beginTransaction().add(R.id.fragment_table_list, tp).commit();
            }
        }
        if (findViewById(R.id.fragment_table_pager)!=null){
            if (fm.findFragmentById(R.id.fragment_table_pager)==null){
                fm.beginTransaction().add(R.id.fragment_table_pager, TablePagerFragment.newInstance(0)).commit();
            }

        }
    }



    @Override
    public void onTableSelected(Table table, int position) {

        FragmentManager fm = getFragmentManager();
        TablePagerFragment tpF = (TablePagerFragment) fm.findFragmentById(R.id.fragment_table_pager);
        if (tpF!=null){
            tpF.showTable(position);
        }else {
            Intent intent = new Intent( this, TablePagerActivity.class);
            intent.putExtra(TablePagerActivity.EXTRA_TABLE_INDEX, position);
            startActivity(intent);
        }


    }
}
