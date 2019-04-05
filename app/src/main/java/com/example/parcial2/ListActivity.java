package com.example.parcial2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.parcial2.Control.TareasAdapter;
import com.example.parcial2.POJO.Tareas;
import com.example.parcial2.Utilities.App;
import com.example.parcial2.Utilities.DBUtility;

import java.util.List;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;
    private List<Tareas> lista_tipos;
    private DBUtility conn;
    private TextView codigo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lista = findViewById(R.id.l_lista);
        codigo = findViewById(R.id.lb_id);
        conn =((App)(getApplication())).getConn();
        lista.setAdapter(new TareasAdapter(this, conn.getTareas()));
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tmp = view.findViewById(R.id.lb_id);
        conn.actualizaTarea(tmp.getText().toString());
        lista.setAdapter(new TareasAdapter(this, conn.getTareas()));
    }
}
