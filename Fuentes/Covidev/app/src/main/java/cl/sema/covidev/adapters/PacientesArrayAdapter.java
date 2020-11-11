package cl.sema.covidev.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cl.sema.covidev.R;
import cl.sema.covidev.dto.Paciente;


public class PacientesArrayAdapter extends ArrayAdapter<Paciente> {

    private Activity activity;
    private List<Paciente> pacientes;

    public PacientesArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Paciente> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.pacientes = objects;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inf = this.activity.getLayoutInflater();
        View selector = inf.inflate(R.layout.pacientes_list,null,true);
        //atributos

        return null;
    }


}
