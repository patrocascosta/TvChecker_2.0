package pt.tvtime.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pt.tvtime.app.session.SessionManager;
import pt.tvtime.app.ui.FavoritosFragment;
import pt.tvtime.app.ui.FavoritosFragmentDirections;
import pt.tvtime.app.ui.HomeFragment;
import pt.tvtime.app.ui.HomeFragmentDirections;
import pt.tvtime.app.ui.ListFragments;
import pt.tvtime.app.ui.VistosFragmentDirections;

public class MainActivity extends AppCompatActivity implements ListFragments.OnListFragmentItemClickedListener {

    BottomNavigationView bottomNavigationView;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setUpNavigation();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (SessionManager.getActiveSession(this) == -1) {
            SignInActivity.startActivity(this);
            finish();
        }
    }

    public void setUpNavigation(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());


        NavController navController = Navigation.findNavController(this, R.id.fragment);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationUI.setupWithNavController(toolbar, navController);
    }

    @Override
    public void onItemCliked(String from, long id) {
        if (from.equals(ListFragments.ROUTE_FROM_VISTO)){
            VistosFragmentDirections.actionVistosFragmentToSeriesDetails();
        }else if (from.equals(ListFragments.ROUTE_FROM_FAVORITOS)){
            FavoritosFragmentDirections.actionFavotirosFragmentToSeriesDetails();
        }else if (from.equals(HomeFragment.ROUTE_FROM_HOME)){
            HomeFragmentDirections.actionHomeFragmentToSerieDetails();
        }
    }
}
