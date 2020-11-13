package cl.inacap.covidEv;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cl.inacap.covidEv.dao.PacientesDAO;
import cl.inacap.covidEv.dao.PacientesDAOSQLite;
import cl.inacap.covidEv.dto.Paciente;
import cl.sema.covidev.R;

public class RegistrarPacienteActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText veri;
    private EditText vali;
    private EditText nombre;
    private EditText apellido;
    private EditText fecha;
    private Spinner artra;
    private Switch sin;
    private EditText temp;
    private Switch tos;
    private EditText pres;
    private Button regbtn;
    private PacientesDAO paciDAO = new PacientesDAOSQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.veri =          findViewById(R.id.verificador);
        this.vali =          findViewById(R.id.validador);
        this.nombre =        findViewById(R.id.nombretxt);
        this.apellido =      findViewById(R.id.apellidotxt);
        this.fecha =         findViewById(R.id.calendario);

        this.fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dateFragment = new DatePickerFragment();
                dateFragment.show(getSupportFragmentManager(), "date picker");
            }

        });


        //
        this.artra =     findViewById(R.id.area);
        ArrayAdapter<CharSequence> opciones = ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_spinner_item);
        artra.setAdapter(opciones);
        ///
        this.sin =       findViewById(R.id.sintomas);
        sin.setChecked(false);
        this.sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.sintomas) {
                    if (sin.isChecked()) {
                        //aqui debe guardar el estado en la variable
                    } else {
                        //aqui debe dar el error al guardar el estado en la variable
                    }
                }
            }
        });

        this.temp =      findViewById(R.id.temperatura);
        this.tos =       findViewById(R.id.tos);
        tos.setChecked(false);
        this.tos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.tos) {
                    if (tos.isChecked()) {
                        //aqui debe guardar el estado en la variable
                    } else {
                        //aqui debe dar el error al guardar el estado en la variable
                    }
                }
            }
        });

        this.pres =     findViewById(R.id.presion);
        this.regbtn =   findViewById(R.id.registrarBtn);
        this.regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores = new ArrayList<>();


                //PacientesSQLiteHelper pct = new PacientesSQLiteHelper(null, "administracion", null, 1);
                //SQLiteDatabase bd = pct.getWritableDatabase();
                int vrn = veri.getText().length();
                int vdr = vali.getText().length();
                String nomb = nombre.getText().toString().trim();
                String ape = apellido.getText().toString().trim();
                int fha = fecha.getText().length();
                String art = artra.getSelectedItem().toString();
                int tma = temp.getText().length();
                int psna = pres.getText().length();


                if (vrn <= 1111111 || vrn >= 99999999) {
                    errores.add("El rut ingresado no es valido");
                }
                if (vdr < 0 || vdr > 9) {
                    errores.add("El numero verificador ingresado no es valido");
                }

                if (nomb.isEmpty()) {
                    errores.add("Debe ingresar un nombre valido");
                }
                if (ape.isEmpty()) {
                    errores.add("Debe ingresar un apellido valido");
                }
                if (fha >= 0 ){
                    errores.add("Debe indicar la fecha del examen");
                }
                if (art.isEmpty()) {
                    errores.add("Debe indicar su area de trabajo");
                }
                if (tma <= 20.0) {
                    errores.add("La temperatura debe ser mayor a 20.0°C");
                }
                if (psna < 90 || psna > 200) {
                    errores.add("Debe indicar su Presion arterial valida o por precaucion debe ir al centro medico cercano");
                }


                if (errores.isEmpty()) {

                    Paciente p = new Paciente();
                    p.setRut(vrn);
                    p.setValidadorRut(vdr);
                    p.setNombre(nomb);
                    p.setApellido(ape);
                    p.setFechaexamen(fha);
                    p.setArea(art);
                    p.setTemperatura(tma);
                    p.setPresion(psna);
                    paciDAO.save(p);

                    //3. Redirigir al MainActivity
                    startActivity(new Intent(RegistrarPacienteActivity.this, MainActivity.class));
                    Toast.makeText(getApplicationContext(), "Paciente registrado con exito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error al ingresar paciente." + errores, Toast.LENGTH_SHORT).show();
                }
            }

            });

        }


    @Override
    public void onDateSet(DatePicker view, int dayOfMonth, int month, int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        String currentDateString = DateFormat.getDateInstance(SimpleDateFormat.SHORT).format(c.getTime());
        EditText editText = (EditText) findViewById(R.id.calendario);
        editText.setText(currentDateString);

    }

}