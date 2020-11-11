package cl.sema.covidev;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cl.sema.covidev.dto.Paciente;

public class VerPacientesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView rut;
    private TextView nombreTxt;
    private TextView apellidoTxt;
    private TextView fechaExamen;
    private TextView artra;
    private TextView sintomas;
    private TextView temp;
    private TextView tos;
    private TextView presion;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.toolbar = findViewById(R.id.toolbar);
        this.rut = findViewById(R.id.rut);
        this.nombreTxt = findViewById(R.id.nombretxt);
        this.apellidoTxt  = findViewById(R.id.apellidotxt);
        this.fechaExamen  = findViewById(R.id.calendario);
        this.artra  =  findViewById(R.id.area);
        this.sintomas  = findViewById(R.id.sintomas);
        this.temp  = findViewById(R.id.temperatura);
        this.tos  = findViewById(R.id.tos);
        this.presion  = findViewById(R.id.presion);

        this.setSupportActionBar((androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (getIntent() != null){
            Paciente paciente = (Paciente)getIntent().getSerializableExtra("paciente");
            this.rut.setText(paciente.getRut() + "-" + paciente.getValidadorRut());
            this.nombreTxt.setText(paciente.getNombre());
            this.apellidoTxt.setText(paciente.getApellido());
            this.fechaExamen.setText(paciente.getFechaexamen());
            this.artra.setText(paciente.getArea());
            //sintomas
            this.temp.setText(paciente.getTemperatura());
            //tos
            this.presion.setText(paciente.getPresion());

        }
    }
}
