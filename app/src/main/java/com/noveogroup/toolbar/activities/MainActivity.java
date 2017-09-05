package com.noveogroup.toolbar.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.noveogroup.toolbar.R;
import com.noveogroup.toolbar.adapters.DepartmentAdapter;
import com.noveogroup.toolbar.util.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.list_of_departments)
    protected RecyclerView listOfDepartments;

    @BindView(R.id.swipe_refresh_layout)
    protected SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.main_appbar)
    protected AppBarLayout appBarLayout;

    private DepartmentAdapter departmentAdapter;

    private List<String> list = new ArrayList<>();

    @Override
    protected void onPostCreated(final Bundle savedInstanceState) {
        Util.fillList(list);
        departmentAdapter = new DepartmentAdapter(list);
        listOfDepartments.setAdapter(departmentAdapter);
        listOfDepartments.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.add(0, getString(R.string.new_department_text));
                listOfDepartments.scrollToPosition(0);
                departmentAdapter.notifyItemInserted(0);
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int pos = listOfDepartments.getChildAdapterPosition(viewHolder.itemView);
                list.remove(pos);
                departmentAdapter.notifyItemRemoved(pos);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(listOfDepartments);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
