package pt.tvtime.app.ui;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.adapters.HomeAdapter;
import pt.tvtime.app.model.Serie;
import pt.tvtime.app.viewmodel.HomeViewModel;

public class HomeFragment extends ListFragments {

    HomeAdapter adapter;
    private HomeViewModel viewModelHome;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        this.adapter = new HomeAdapter(getActivity());
        GridView listViewSerie = view.findViewById(R.id.listViewHome);
        listViewSerie.setAdapter(adapter);

        viewModelHome = ViewModelProviders.of(this).get(HomeViewModel.class);

        LiveData<List<Serie>> listLiveData = this.viewModelHome.getHomeSeries(getActivity());
        listLiveData.observe(getActivity(), new Observer<List<Serie>>() {
            @Override
            public void onChanged(List<Serie> serieList) {
               adapter.updateHome(serieList);
            }
        });

        listViewSerie.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                HomeFragment.super.onItemClicked(HomeFragment.ROUTE_FROM_HOME, id);
            }
        });

        return view;
    }

}
