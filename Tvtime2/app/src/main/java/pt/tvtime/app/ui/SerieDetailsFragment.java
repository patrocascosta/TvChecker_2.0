package pt.tvtime.app.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pt.tvtime.app.R;
import pt.tvtime.app.model.Serie;
import pt.tvtime.app.repository.local.AppDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class SerieDetailsFragment extends Fragment {

    private ImageView imageViewSerie;
    private TextView textViewPontuacao;
    private TextView textViewName;
    private TextView textViewDescricao;
    Context context;

    public SerieDetailsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_serie_details, container, false);

        long serieId = getArguments().getLong("serieId");

        Serie serie = AppDatabase.getInstance(getContext()).getSeriesDAO().getSerieById(serieId);

        this.imageViewSerie = view.findViewById(R.id.imageViewHome);
        this.textViewDescricao = view.findViewById(R.id.textViewDescricao);
        this.textViewName = view.findViewById(R.id.textViewName);
        this.textViewPontuacao = view.findViewById(R.id.textViewPontuacao);

        Glide.with(this.context).load(serie.getImagem()).into(imageViewSerie);
        textViewPontuacao.setText(serie.getImdb());
        textViewName.setText(serie.getNomeSerie());
        textViewDescricao.setText(serie.getDescricao());

        return view;
    }

}
