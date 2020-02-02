package pt.tvtime.app.ui;

import android.content.Context;

import androidx.fragment.app.Fragment;

public class ListFragments extends Fragment {

    private OnListFragmentItemClickedListener listener;
    public static final String ROUTE_FROM_VISTO = "visto";
    public static final String ROUTE_FROM_FAVORITOS = "favoritos";
    public static final String ROUTE_FROM_HOME = "home";

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if (context instanceof OnListFragmentItemClickedListener){
            this.listener = (OnListFragmentItemClickedListener) context;
        }else {
            throw new RuntimeException("Activity must implement OnListFragmentitemClickedListener");
        }
    }

    public void onItemClicked(String from, long id){
        if (listener != null) listener.onItemCliked(from, id);
    }

    public interface OnListFragmentItemClickedListener{
        void onItemCliked(String from, long id);
    }
}
