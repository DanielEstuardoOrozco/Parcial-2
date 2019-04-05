package com.example.parcial2.Control;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parcial2.POJO.Tareas;
import com.example.parcial2.R;

import java.text.ParseException;
import java.time.LocalDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TareasAdapter extends ArrayAdapter<Tareas> {
    private List<Tareas> lista;
    private Context context;
    private int layout;

    public TareasAdapter(@NonNull Context context, @NonNull List<Tareas> objects) {
        super(context, R.layout.item_list ,objects);
        this.lista = objects;
        this.context = context;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item_list, null);
        }
        if (lista.get(position) != null){
            TextView fecha, descripcion, id;
            LinearLayout fondo;

            fecha = v.findViewById(R.id.lb_fecha);
            descripcion = v.findViewById(R.id.lb_descripcion);
            id = v.findViewById(R.id.lb_id);
            fondo = v.findViewById(R.id.ll_fondo);

            fecha.setText(lista.get(position).getFecha());
            descripcion.setText(lista.get(position).getDescripcion());
            id.setText(Integer.toString(lista.get(position).getId()));
            if (Integer.toString(lista.get(position).getEstado()).equals("1")){
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date actual = new Date(System.currentTimeMillis());
                    Date registro = sdf.parse(lista.get(position).getFecha());
                    if (actual.compareTo(registro) > 0){
                        fondo.setBackgroundColor(Color.parseColor("#7CFC00"));
                    } else{
                        fondo.setBackgroundColor(Color.parseColor("#FA8072"));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }

        }
        return v;
    }
}
