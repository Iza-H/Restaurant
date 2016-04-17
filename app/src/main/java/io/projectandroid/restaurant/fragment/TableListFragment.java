package io.projectandroid.restaurant.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import io.projectandroid.restaurant.R;
import io.projectandroid.restaurant.model.Table;
import io.projectandroid.restaurant.model.Tables;

/**
 * A simple {@link Fragment} subclass.
 */
public class TableListFragment extends Fragment {
    private TableListListener mTableListListener;


    public TableListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_table_list, container, false);
        ListView list = (ListView) root.findViewById(android.R.id.list);
        final Tables tables = new Tables();
        ArrayAdapter<Table> adapter = new ArrayAdapter<Table>(getActivity(), android.R.layout.simple_list_item_1, tables.getTables());
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mTableListListener != null) {
                    Table tableSelected = tables.getTables().get(i);
                    mTableListListener.onTableSelected(tableSelected, i);
                }
            }
        });
        return root;

    }

    public interface TableListListener{
        void onTableSelected(Table table, int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mTableListListener = (TableListListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mTableListListener=null;
    }
}
