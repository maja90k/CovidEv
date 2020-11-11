package cl.sema.covidev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import cl.sema.covidev.adapters.PacientesArrayAdapter;
import cl.sema.covidev.dao.PacientesDAO;
import cl.sema.covidev.dao.PacientesDAOSQLite;
import cl.sema.covidev.dto.Paciente;

public class PrincipalActivity extends AppCompatActivity {

//    private EditText rutE;
//    private EditText nombreE;
//    private EditText apellidoE;
//    private EditText fechaExamenE;
    private ListView paciLV;
    private List<Paciente> pacientes;
    private PacientesArrayAdapter adapter;
    private PacientesDAO paciDAO = new PacientesDAOSQLite(this);
    private Button regibtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Ir atras con Toolbar.
        this.setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.regibtn = (Button) findViewById(R.id.registrobtn);
        //Mostrar ListView con el adapters



        //if(covid true/false) = excepciones distintas.Asi se cargan dos imagenes diferentes.

        //Ver paciente en caso de apretar un Item del ListView.

        //Se redirecciona al RegistrarPacienteActivity.
        this.regibtn = (Button) findViewById(R.id.registrobtn);
        this.regibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalActivity.this, RegistrarPacienteActivity.class));
            }
        });
    }

    //protected void onResume(){
        //super.onResume();
        //pacientes = paciDAO.getAll();
        //adapter = new PacientesArrayAdapter(this, R.layout.pacientes_list, pacientes);
        //paciLV = (ListView) findViewById(R.id.listview);
        //paciLV.setAdapter(adapter);
        //paciLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //@Override
            //public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Intent intent = new Intent
                 //       (PrincipalActivity.this, VerPacientesActivity.class);
                //Paciente pacienteActual = pacientes.get(i);
                //intent.putExtra("paciente", pacienteActual);
                //startActivity(intent);
            //}
        //});
    //}
}