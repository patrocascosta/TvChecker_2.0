package pt.tvtime.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import pt.tvtime.app.R;
import pt.tvtime.app.model.Serie;
import pt.tvtime.app.model.Visto;

public class VistosAdapter extends BaseAdapter {

    private List<Visto> vistoList;
    private Context context;

    public VistosAdapter(Context context, List<Visto> vistos){
        this.context = context;
        this.vistoList = vistos;
    }

    @Override
    public int getCount() {
        return this.vistoList.size();
    }

    @Override
    public Visto getItem(int position) {
        return this.vistoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        if (convertview == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            convertview = layoutInflater.inflate(R.layout.row, null);
        }

        Serie serie = getItem(position);

        ImageView serieImage1 = convertview.findViewById(R.id.serieImage1);
        Glide.with(this.context).load(serie.getImage()).into(serieImage1);

        ImageView serieImage2 = convertview.findViewById(R.id.serieImage2);
        Glide.with(this.context).load(serie.getImage()).into(serieImage2);

        return convertview;
    }

    public void updateVisto(List<Visto> vistos){
        this.vistoList = vistos;
        notifyDataSetChanged();
    }
}
