package pt.tvtime.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import pt.tvtime.app.session.SessionManager;

public class SignInActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, SignInActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void signIn(long userId) {
        SessionManager.saveSession(this, userId);
        MainActivity.startActivity(this);
        finish();
    }
}
