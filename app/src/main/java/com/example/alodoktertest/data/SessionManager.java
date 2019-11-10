package com.example.alodoktertest.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    String PREF_NAME="SharedPref";
    int PRIVATE_MODE = 0;

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setUsername(String userName){
        editor.putString("userName", userName);
        editor.commit();
    }

    public String getUsername() {
        return pref.getString("userName", "");
    }

    public void setPassword(String password) {
        editor.putString("password", password);
        editor.commit();
    }

    public String getPassword() {
        return pref.getString("password", "");
    }

    public void setStatusLogin(String statusLogin) {
        editor.putString("statusLogin", statusLogin);
        editor.commit();
    }

    public String getStatusLogin() {
        return pref.getString("statusLogin", "");
    }

    public void setTypeImage(String typeImage) {
        editor.putString("typeImage", typeImage);
        editor.commit();
    }

    public String getTypeImage() {
        return pref.getString("typeImage", "");
    }
}
