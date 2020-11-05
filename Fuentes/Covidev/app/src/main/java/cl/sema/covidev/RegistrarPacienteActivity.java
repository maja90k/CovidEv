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
import android.widget.Toast;

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
        this.veri       = (EditText) findViewById(R.id.verificador);
        this.vali       = (EditText) findViewById(R.id.validador);
        this.nombre     = (EditText) findViewById(R.id.nombretxt);
        this.apellido   = (EditText) findViewById(R.id.apellidotxt);

        this.fecha      = (EditText) findViewById(R.id.calendario);
        this.fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dateFragment = new DatePickerFragment();
                dateFragment.show(getSupportFragmentManager(), "date picker");
            }

        });

        this.artra   = (Spinner) findViewById(R.id.area);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_spinner_item);

        this.sin     = (Switch) findViewById(R.id.sintomas);
        this.sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.sintomas){
                    if (sin.isChecked()){
                        //aqui debe guardar el estado en la variable
                    }else{
                        //aqui debe dar el error al guardar el estado en la variable
                    }
                }
            }
        });
        this.temp    = (EditText) findViewById(R.id.temperatura);
        this.tos     = (Switch) findViewById(R.id.tos);
        this.tos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.tos){
                    if (tos.isChecked()){
                        //aqui debe guardar el estado en la variable
                    }else{
                        //aqui debe dar el error al guardar el estado en la variable
                    }
                }
            }
        });
        this.pres    = (EditText) findViewById(R.id.presion);


        this.regbtn  = (Button) findViewById(R.id.registrarBtn);

        this.regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores = new ArrayList<>();
                try {
                    int vrn         = veri ;
                    int vdr         = vali ;
                    String nomb     = nombre.getText().toString().trim();
                    String ape      = apellido.getText().toString().trim();
                    date fha        = fecha ;
                    String art      = artra.getSelectedItem().toString();
                    boolean sts     = sin ;
                    int tma         = temp ;
                    boolean ts      = tos ;
                    int psna        = pres ;


                    if(errores.isEmpty()){

                        Toast.makeText(getApplicationContext(), "Paciente registrado con exito", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), "error al ingresar al paciente" + errores , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onDateSet(DatePicker view, int dayOfMonth, int month,int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        String currentDateString = DateFormat.getDateInstance(SimpleDateFormat.SHORT).format(c.getTime());

        EditText editText = (EditText) findViewById(R.id.calendario);
        editText.setText(currentDateString);

    }

}