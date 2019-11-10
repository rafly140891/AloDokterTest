package com.example.alodoktertest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alodoktertest.data.SessionManager;
import com.example.alodoktertest.model.ItemCardAdapter;
import com.example.alodoktertest.model.ItemCards;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator2;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.buttonLogin)
    Button btnLogin;

    @BindView(R.id.txtInputUsername)
    TextInputEditText edtUsername;

    @BindView(R.id.txtInputPassword)
    TextInputEditText edtPassword;

    SessionManager sessi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        onBackPressed();

        sessi = new SessionManager(LoginActivity.this);

        if (sessi.getStatusLogin().equals("0")) {

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edtUsername.getText().toString().isEmpty()) {
                        Log.e("LoginActivity", "onClick: ini value nya = " + edtUsername.getText().toString());

                        Snackbar.make(v, "Please insert your username", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    } else if (edtPassword.getText().toString().isEmpty()) {
                        Log.e("LoginActivity", "onClick: ini value nya = " + edtPassword.getText().toString());

                        Snackbar.make(v, "Please insert your password", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    } else {
                        Log.e("LoginActivity", "onClick: ini value username = " + edtUsername.getText().toString() + " Ini value password = " + edtPassword.getText().toString());

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        sessi.setUsername(edtUsername.getText().toString());
                        sessi.setPassword(edtPassword.getText().toString());
                        sessi.setStatusLogin("1");
                    }
                }
            });
        } else {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
    }
}
