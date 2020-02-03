package pt.tvtime.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.model.Serie;

public class HomeAdapter extends BaseAdapter {

    private List<Serie> serieList;
    private Context context;

    public HomeAdapter(Context context){
        this.context = context;
        this.serieList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return serieList.size();
    }

    @Override
    public Serie getItem(int position) {
        return serieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getIdSerie();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(this.context).inflate(R.layout.fragment_home_row, parent, false);
        }

        Serie serie = getItem(position);

        TextView textViewHome = convertView.findViewById(R.id.textViewHome);
        ImageView serieImage = convertView.findViewById(R.id.imageViewHome);

        textViewHome.setText(serie.getNomeSerie());
        Glide.with(this.context).load(serie.getImage()).into(serieImage);

        return convertView;
    }

    public void updateHome(List<Serie> serieList){
        this.serieList = serieList;
        notifyDataSetChanged();
    }
}