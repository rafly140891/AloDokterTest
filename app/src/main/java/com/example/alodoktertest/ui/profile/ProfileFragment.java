package com.example.alodoktertest.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.alodoktertest.LoginActivity;
import com.example.alodoktertest.MainActivity;
import com.example.alodoktertest.R;
import com.example.alodoktertest.data.SessionManager;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    SessionManager session;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        final Button btnLogout = root.findViewById(R.id.btnLogout);

        session = new SessionManager(getActivity());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                session.setUsername("");
                session.setPassword("");
                session.setStatusLogin("0");
            }
        });
        return root;
    }
}
