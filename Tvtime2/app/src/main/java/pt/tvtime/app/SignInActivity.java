package pt.tvtime.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pt.tvtime.app.model.User;
import pt.tvtime.app.repository.local.AppDatabase;
import pt.tvtime.app.session.SessionManager;
import pt.tvtime.app.ui.HomeFragment;
import pt.tvtime.app.ui.SignUpFragment;

public class SignInActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, SignInActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



    }


    public void signIn(long userId) {

        this.editTextEmail = findViewById(R.id.editTextEmail);
        this.editTextPassword = findViewById(R.id.editTextPassword);
        String email = this.editTextEmail.getText().toString();
        String password = this.editTextPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {

            Context context = getApplicationContext();
            CharSequence text = "Preencher todos os campos!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


            Log.i("MainActivity", "Preencher todos os campos!");
            return;
        }

        User user = AppDatabase.getInstance(this).getUserDAO().getUserByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {

                MainActivity.startActivity(this);
                SessionManager.saveSession(this, user.getUserId());
                finish();
            } else {

                Context context = getApplicationContext();
                CharSequence text = "Password Errada!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


                Log.i("MainActivity", "Password Errada!");
            }
        } else {

            Context context = getApplicationContext();
            CharSequence text = "Utilizador Não EXISTE!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Log.i("MainActivity", "Utilizador Não EXISTE!");
        }

        SessionManager.saveSession(this, userId);
        finish();
    }
}
