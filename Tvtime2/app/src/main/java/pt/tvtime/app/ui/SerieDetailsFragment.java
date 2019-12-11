package pt.tvtime.app.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pt.tvtime.app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SerieDetailsFragment extends Fragment {


    public SerieDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_serie_details, container, false);
    }

}
