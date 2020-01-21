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
import android.widget.ListView;

import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.adapters.FavoritosAdapter;
import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.viewmodel.FavoritosViewModel;


public class FavoritosFragment extends Fragment {

    private FavoritosAdapter adapter;
    private ListView listView;

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
        listView = view.findViewById(R.id.listViewFavoritos);
        listView.setAdapter(adapter);

        this.viewModel = ViewModelProviders.of(this).get(FavoritosViewModel.class);

        LiveData<List<Favorito>> liveDataFavoritos = this.viewModel.getFavoritos(getActivity());
        liveDataFavoritos.observe(this, new Observer<List<Favorito>>() {
            @Override
            public void onChanged(List<Favorito> favoritos) {
                FavoritosFragment.this.adapter.updateFavoritos(favoritos);
            }
        });

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        this.viewModel.updateFavoritos(getActivity());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
