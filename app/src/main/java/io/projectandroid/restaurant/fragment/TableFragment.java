package io.projectandroid.restaurant.fragment;



import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  android.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import io.projectandroid.restaurant.R;
import io.projectandroid.restaurant.activity.MealDeatailActivity;
import io.projectandroid.restaurant.activity.MenuListActivity;
import io.projectandroid.restaurant.model.Table;

/**
 * A simple {@link Fragment} subclass.
 */
public class TableFragment extends Fragment{

    public static final String ARG_TABLE = "table";
    public static final Integer RESULT_REQUEST = 1;
    private TextView mTableDescription;
    private TextView mTableTotalPrice;
    private Button mClearButton;
    private Button mAddMealButton;
    private Table mTable;


    public TableFragment() {
        // Required empty public constructor
    }

    public static TableFragment newInstance(Table table){
        TableFragment fragment = new TableFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(ARG_TABLE, table);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mTable = (Table) getArguments().getSerializable(ARG_TABLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_table, container, false);
        mTableDescription = (TextView) root.findViewById(R.id.table_description);
        mTableTotalPrice = (TextView) root.findViewById(R.id.table_price);
        mClearButton = (Button) root.findViewById(R.id.clear_btn);
        mAddMealButton = (Button) root.findViewById(R.id.add_meal_btn);

        mClearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mTable.clear();

            }
        });
        mAddMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuListActivity.class);
                intent.putExtra( MenuListActivity.EXTRA_TABLE  , mTable);
                startActivityForResult(intent, RESULT_REQUEST);
                //intent.putExtra(SettingsActivity.CURRENT_UNITS, showCel);
                //startActvity(intent); //gdy nie chcemy nic konkretnego
                //startActivityForResult(intent, REQUEST_UNITS);
            }
        });


        updateTableInfo();

        return root;

    }

    public void updateTableInfo(){
        mTableDescription.setText(String.format("Table nr %d", mTable.getNumber()));
        mTableTotalPrice.setText(String.format("Total price %.2f", mTable.getTotalPrice()));

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            mTable=(Table)data.getSerializableExtra(MenuListActivity.EXTRA_TABLE);
            updateTableInfo();
        }

    }



}
