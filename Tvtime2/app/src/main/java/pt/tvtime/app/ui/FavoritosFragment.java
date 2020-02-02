package pt.tvtime.app.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.adapters.FavoritosAdapter;
import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.viewmodel.FavoritosViewModel;


public class FavoritosFragment extends ListFragments {

    private FavoritosAdapter adapter;
    private FavoritosViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favotiros, container, false);

        this.adapter = new FavoritosAdapter(getActivity());
        ListView listView = view.findViewById(R.id.listViewFavoritos);
        listView.setAdapter(adapter);

        this.viewModel = ViewModelProviders.of(this).get(FavoritosViewModel.class);

        LiveData<List<Favorito>> liveDataFavoritos = this.viewModel.getFavoritos(getActivity());
        liveDataFavoritos.observe(this, new Observer<List<Favorito>>() {
            @Override
            public void onChanged(List<Favorito> favoritos) {
                FavoritosFragment.this.adapter.updateFavoritos(favoritos);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FavoritosFragment.super.onItemClicked(ListFragments.ROUTE_FROM_FAVORITOS, id);
            }
        });

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        this.viewModel.updateFavoritos(getActivity());
    }
}
