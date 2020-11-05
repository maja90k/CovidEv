package cl.sema.covidev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RegistrarPacienteActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText veri;
    private EditText vali;
    private EditText nombre;
    private EditText apellido;
    private EditText fecha;
    private Spinner  artra;
    private Switch   sin;
    private EditText temp;
    private Switch   tos;
    private EditText pres;
    private Button   regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente);
        this.veri = findViewById(R.id.verificador);
        this.vali = findViewById(R.id.validador);
        this.nombre  = findViewById(R.id.nombretxt);
        this.apellido  = findViewById(R.id.apellidotxt);

        this.fecha = (EditText) findViewById(R.id.calendario);
        this.fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dateFragment = new DatePickerFragment();
                dateFragment.show(getSupportFragmentManager(), "date picker");
            }

        });

        this.artra = (Spinner) findViewById(R.id.area);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_spinner_item);

        this.sin  = findViewById(R.id.sintomas);
        this.temp  = findViewById(R.id.temperatura);
        this.tos  = findViewById(R.id.tos);
        this.pres  = findViewById(R.id.presion);

        this.regbtn = findViewById(R.id.registrarBtn);

        this.regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List <String> errores = new ArrayList<>();

            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        String currentDateString = DateFormat.getDateInstance(SimpleDateFormat.SHORT).format(c.getTime());

        EditText editText = (EditText) findViewById(R.id.calendario);
        editText.setText(currentDateString);

    }
}