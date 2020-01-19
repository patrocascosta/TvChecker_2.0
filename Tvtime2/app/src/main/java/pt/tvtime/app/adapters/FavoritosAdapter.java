package pt.tvtime.app.adapters;


import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.model.Favorito;
import pt.tvtime.app.model.Serie;

public class FavoritosAdapter extends BaseAdapter {

    private List<Favorito> favoritoList;
    private Context context;

    public FavoritosAdapter (Context context, List<Favorito> favoritos){
        this.context = context;
        this.favoritoList = favoritos;
    }


    @Override
    public int getCount() {
        return this.favoritoList.size();
    }

    @Override
    public Favorito getItem(int position) {
        return this.favoritoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            convertView = layoutInflater.inflate(R.layout.row, null);
        }

        Serie serie = getItem(position);

        ImageView serieImage1 = convertView.findViewById(R.id.serieImage1);
        Glide.with(this.context).load(serie.getImage()).into(serieImage1);

        ImageView serieImage2 = convertView.findViewById(R.id.serieImage2);
        Glide.with(this.context).load(serie.getImage()).into(serieImage2);

        return convertView;
    }

    public void updateFavoritos(List<Favorito> favoritos){
        this.favoritoList = favoritos;
        notifyDataSetChanged();
    }
}
