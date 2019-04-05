package com.example.parcial2.Utilities;

import android.app.Application;

public class App extends Application {
    private DBUtility conn;

    @Override
    public void onCreate(){
        super.onCreate();
        conn = new DBUtility(this);
    }

    public DBUtility getConn(){
        if (conn == null){
            conn = new DBUtility(this);
        }
        return conn;
    }
}

