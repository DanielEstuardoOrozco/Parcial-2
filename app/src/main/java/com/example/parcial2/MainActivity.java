package com.example.parcial2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.parcial2.POJO.Tareas;
import com.example.parcial2.Utilities.App;
import com.example.parcial2.Utilities.DBUtility;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText fecha, descripcion;
    private Button guardar, listado;
    private List<Tareas> lista_tipos;
    private DBUtility conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn = new DBUtility(getApplicationContext());

        fecha = findViewById(R.id.txt_fecha);
        descripcion = findViewById(R.id.txt_descripcion);
        guardar = findViewById(R.id.bt_guardar);
        listado = findViewById(R.id.bt_listado);

        guardar.setOnClickListener(this);
        listado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() ==  R.id.bt_guardar){
            Tareas tmp = new Tareas();
            tmp.setFecha(fecha.getText().toString());
            tmp.setDescripcion(descripcion.getText().toString());
            tmp.setEstado(0);
            conn =((App)(getApplication())).getConn();
            conn.insertaTarea(tmp);
        }
        else if (v.getId() ==  R.id.bt_listado){
            Intent intent = new Intent(this, ListActivity.class );
            startActivity(intent);
        }
    }
}
