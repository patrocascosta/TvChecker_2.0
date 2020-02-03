package pt.tvtime.app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.tvtime.app.MainActivity;
import pt.tvtime.app.R;
import pt.tvtime.app.SignInActivity;
import pt.tvtime.app.model.User;
import pt.tvtime.app.repository.local.AppDatabase;
import pt.tvtime.app.session.SessionManager;


public class SignUpFragment extends Fragment {



        public static void startActivity(Context context) {
            context.startActivity(new Intent(context, SignInActivity.class));
        }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        Button button = view.findViewById(R.id.signUpButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextEmail = getView().findViewById(R.id.editTextEmail);
                EditText editTextPassword = getView().findViewById(R.id.editTextPassword);
                EditText editTextPasswordConfirmation = getView().findViewById(R.id.editTextPasswordConfirmation);
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String passwordConfirmation = editTextPasswordConfirmation.getText().toString();

                if (email.isEmpty() || password.isEmpty() || passwordConfirmation.isEmpty()) {
                    Context context = getActivity();
                    CharSequence text = "Tem de preencher os campos todos!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Log.i("SignUpActivity", "Tem de preencher os campos todos");
                    return;
                }else{
                    MainActivity.startActivity(getContext());
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
