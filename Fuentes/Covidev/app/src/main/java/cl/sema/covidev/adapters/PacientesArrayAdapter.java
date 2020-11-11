package cl.sema.covidev.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        LayoutInflater inf      = this.activity.getLayoutInflater();
        View selector           = inf.inflate(R.layout.pacientes_list,null,true);
        TextView rut            = selector.findViewById(R.id.rutTxt_Lv);
        TextView nombre         = selector.findViewById(R.id.nombreTxt_Lv);
        TextView apellido       = selector.findViewById(R.id.apellidoTxt_Lv);
        TextView fecha          = selector.findViewById(R.id.fecha_Lv);
        ImageView secorono      = selector.findViewById(R.id.coronavirus);
        ImageView taok          = selector.findViewById(R.id.taokmicompa);
        Paciente now            = pacientes.get(position);

        rut.setText(now.getRut());
        //insertar la foto dependiendo si tiene o no coronao
        //habra que insertar 2, luego en el principalActivity
        //se decidira si es true or false, para insertar una imagen
        //que diga si tiene o no coronavirus, lo demas se conserva

        return selector;
    }


}
