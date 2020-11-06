package cl.sema.covidev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText nombre;
    private EditText validadornmb;
    private EditText passwd;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nombre = (EditText) findViewById(R.id.usernombre);
        this.validadornmb = (EditText) findViewById(R.id.validador);
        this.passwd = (EditText) findViewById(R.id.psswd);

        this.loginbtn = (Button) findViewById(R.id.loginbutton);

        this.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores = new ArrayList<>();
                try {
                    String nmb = nombre.getText().toString().trim();

                    if (nmb.length() < 7 || nmb.length() > 8 ){
                        errores.add("El nombre debe ser de un max de 8 caracteres y un minimo de 7 ");
                    }if(nmb.isEmpty()){
                        nombre = ;
                        errores.add("Debe ingresar un nombre de usuario");
                    }
                }catch (Exception ex){

                }

            }
        });


    }
}