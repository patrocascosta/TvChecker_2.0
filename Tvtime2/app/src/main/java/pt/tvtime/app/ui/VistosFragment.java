package pt.tvtime.app.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.adapters.VistosAdapter;
import pt.tvtime.app.model.Visto;
import pt.tvtime.app.viewmodel.VistosViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class VistosFragment extends ListFragments {

    private VistosAdapter adapter;
    private VistosViewModel viewModel;


    public VistosFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vistos, container, false);

        this.adapter = new VistosAdapter(getActivity());
        GridView listView = view.findViewById(R.id.listViewVistos);
        listView.setAdapter(adapter);

        this.viewModel = ViewModelProviders.of(this).get(VistosViewModel.class);

        LiveData<List<Visto>> liveDataVistos = this.viewModel.getVistos(getActivity());
        liveDataVistos.observe(getActivity(), new Observer<List<Visto>>() {
            @Override
            public void onChanged(List<Visto> vistos) {
                adapter.updateVisto(vistos);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                VistosFragment.super.onItemClicked(ListFragments.ROUTE_FROM_VISTO, id);
            }
        });
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        this.viewModel.updateVistos(getActivity());
    }
}
