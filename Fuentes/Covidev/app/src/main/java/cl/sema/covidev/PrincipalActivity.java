package cl.sema.covidev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {

//    private EditText rutE;
//    private EditText nombreE;
//    private EditText apellidoE;
//    private EditText fechaExamenE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Ir atras con Toolbar.
        this.setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Mostrar ListView



        //if(covid true/false) = excepciones distintas.Asi se cargan dos imagenes diferentes.

        //Ver paciente en caso de apretar un Item del ListView.

        //Se redirecciona al RegistrarPacienteActivity.
        Button registroButton = findViewById(R.id.registro_btn);
        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, RegistrarPacienteActivity.class);
                startActivity(i);
            }
        });


    }
}