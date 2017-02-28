package com.example.subeksha.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.subeksha.myapplication.model.Brand;
import com.example.subeksha.myapplication.R;
import com.example.subeksha.myapplication.View.MyAdapter;

import java.util.ArrayList;

/**
 * Created by Subeksha on 2/27/17.
 */

public class CategoriesFragment extends Fragment implements SearchView.OnQueryTextListener  {
    String[] b_name = {"Check Point","Current Day","Forecast","Weather Info"};

    int[] b_image = {R.drawable.checkpoint, R.drawable.currentday, R.drawable.main,
            R.drawable.weather};
    String[] textView;
    int [] Image_id = {R.drawable.weather, R.drawable.main,R.drawable.currentday,
            R.drawable.checkpoint};

    Toolbar my_toolbar;
    RecyclerView recyclerView;
    MyAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Brand> arrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.categories_fragment, container, false);



        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.my_recyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        textView = getResources().getStringArray(R.array.s_name);
        int count = 0;
        for(String Name: b_name)
        {
            Brand Brand = new Brand(b_image[count], Name, Image_id[count], textView[count]);
            arrayList.add(Brand);
            count++;
        }

        adapter = new MyAdapter(arrayList, getContext());
        recyclerView.setAdapter(adapter);
        setHasOptionsMenu(true);


        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        //inflater.inflate(R.menu.menu_main,menu);
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        newText = newText.toLowerCase();
        ArrayList<Brand> newList = new ArrayList<>();
        for (Brand brand : arrayList)
        {
            String name = brand.getB_name().toLowerCase();
            if(name.contains(newText))
                newList.add(brand);


        }

        adapter.setFilter(newList);
        return true;
    }



}

