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

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.model.Favorito;

public class FavoritosAdapter extends BaseAdapter {

    private List<Favorito> favoritoList;
    private Context context;

    public FavoritosAdapter (Context context){
        this.context = context;
        this.favoritoList = new ArrayList<>();
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

        Favorito favorito = getItem(position);

        ImageView serieImage1 = convertView.findViewById(R.id.serieImage1);
        Glide.with(this.context).load(favorito.getImage()).into(serieImage1);

        return convertView;
    }

    public void updateFavoritos(List<Favorito> favoritos){
        this.favoritoList = favoritos;
        notifyDataSetChanged();
    }
}
