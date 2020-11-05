package cl.sema.covidev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegistrarPacienteActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText verificador;
    private EditText validador;
    private EditText nombretxt;
    private EditText apellidotxt;
    private EditText calendario;
    private Switch   area;
    private EditText temperatura;
    private Switch   tos;
    private EditText presion;
    private Button   registrarbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(SimpleDateFormat.SHORT).format(c.getTime());

        EditText editText = (EditText) findViewById(R.id.calendario);
        editText.setText(currentDateString);

    }
}