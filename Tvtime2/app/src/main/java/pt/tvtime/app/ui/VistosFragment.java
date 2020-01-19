package pt.tvtime.app.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.adapters.VistosAdapter;
import pt.tvtime.app.model.Visto;
import pt.tvtime.app.viewmodel.VistosViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class VistosFragment extends Fragment {

    private VistosAdapter adapter;
    private ListView listView;

    private VistosViewModel viewModel;


    public VistosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vistos, container, false);

        this.adapter = new VistosAdapter(this);
        listView = findViewById(R.id.listViewVistos);
        listView.setAdapter(adapter);

        this.viewModel = ViewModelProviders.of(this).get(VistosViewModel.class);

        LiveData<List<Visto>> liveDataVistos = this.viewModel.getVistos(this);
        liveDataVistos.observe(this, new Observer<List<Visto>>() {
            @Override
            public void onChanged(List<Visto> vistos) {
                VistosFragment.this.adapter.updateVisto(vistos);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        this.viewModel.updateVistos(this);
    }

}
