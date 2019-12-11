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
import android.se.omapi.Session;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pt.tvtime.app.session.SessionManager;

public class MainActivity extends AppCompatActivity {

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
        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,
                navHostFragment.getNavController());

        NavController navController = Navigation.findNavController(this, R.id.fragment);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationUI.setupWithNavController(toolbar, navController);
    }
}
