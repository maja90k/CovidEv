package cl.sema.covidev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cl.sema.covidev.adapters.PacientesArrayAdapter;
import cl.sema.covidev.dao.PacientesDAO;
import cl.sema.covidev.dao.PacientesDAOSQLite;
import cl.sema.covidev.dto.Paciente;
import cl.sema.covidev.dao.PacientesDAOLista;

public class PrincipalActivity extends AppCompatActivity {

    private ListView paciLV;
    private List<Paciente> pacientes;
    private PacientesArrayAdapter adapter;
    private PacientesDAO paciDAO = new PacientesDAOSQLite(this);
    private FloatingActionButton regibtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Ir atras con Toolbar.
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Se redirecciona al RegistrarPacienteActivity con el button.
        this.regibtn = (FloatingActionButton) findViewById(R.id.registrobtn);
        this.regibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalActivity.this, RegistrarPacienteActivity.class));
            }
        });
    }

    protected void onResume() {
        super.onResume();
        pacientes = paciDAO.getAll();
        //tira error porque el adaptador esta vacio
        adapter = new PacientesArrayAdapter(this, R.layout.pacientes_list, pacientes);
        paciLV = findViewById(R.id.pacientes_Lv);
        //paciLV.setAdapter(adapter);
        paciLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PrincipalActivity.this, VerPacientesActivity.class);
                Paciente pacienteActual = pacientes.get(i);
                intent.putExtra("paciente", pacienteActual);
                startActivity(intent);
            }
        });
    }
}