package com.codename26.childanalysiscalculator;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ItemMainActivity> mItems;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mItems = initItems();
        mRecyclerView = findViewById(R.id.rvMainActivity);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainActivityAdapter adapter = new MainActivityAdapter(this, mItems);
        mRecyclerView.setAdapter(adapter);
    }


    private ArrayList<ItemMainActivity> initItems() {
        ArrayList<ItemMainActivity> items = new ArrayList<>();
        String[] titlesArray = getResources().getStringArray(R.array.titles_array);
        String[] iconsArray = getResources().getStringArray(R.array.icons_array);
        for (int i = 0; i < titlesArray.length; i++) {
            items.add(new ItemMainActivity(titlesArray[i], iconsArray[i]));
        }
        return items;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
// Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

}
