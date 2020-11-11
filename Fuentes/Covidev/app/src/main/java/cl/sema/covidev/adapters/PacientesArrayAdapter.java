package cl.sema.covidev.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inf = this.activity.getLayoutInflater();
        View selector = inf.inflate(R.layout.pacientes_list,null,true);
        //atributos
        TextView rut = selector.findViewById(R.id.rutTxt_Lv);
        TextView nom = selector.findViewById(R.id.nombTxt_Lv);
        TextView ape  = selector.findViewById(R.id.apeTxt_Lv);
        TextView fecha = selector.findViewById(R.id.fec_Lv);

        Paciente actl = pacientes.get(position);

        rut.setText(actl.getRut());

        return selector;
    }


}
