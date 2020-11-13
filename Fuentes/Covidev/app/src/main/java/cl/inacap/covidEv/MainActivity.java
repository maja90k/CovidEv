package cl.inacap.covidEv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.covidEv.dao.UserDAO;
import cl.inacap.covidEv.dao.UserDAOSQLite;
import cl.inacap.covidEv.dto.User;
import cl.sema.covidev.R;

public class MainActivity extends AppCompatActivity {


    private EditText nombre;
    private EditText validadornmb;
    private EditText passwd;
    private Button loginbtn;
    private UserDAO usDAO = new UserDAOSQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.usDAO = new UserDAOSQLite(this);
        this.nombre = (EditText) findViewById(R.id.usernombre);
        this.validadornmb = (EditText) findViewById(R.id.verificador);
        this.passwd = (EditText) findViewById(R.id.psswd);
        this.loginbtn = (Button) findViewById(R.id.loginbutton);
        this.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores = new ArrayList<>();

                String nmb = nombre.getText().toString().trim();
                String vrnb = validadornmb.getText().toString().trim();
                String pwd = passwd.getText().toString().trim();

                if (nmb.length() < 7 || nmb.length() > 8) {
                    errores.add("-- El nombre debe ser de un max de 8 caracteres y un minimo de 7 ");
                }
                if (nmb.isEmpty()) {
                    errores.add("-- Debe ingresar un nombre de usuario ");
                }
                if (vrnb.length() != 1) {
                    errores.add(" Debe ingresar una letra de su nombre ");
                }
                if (pwd.isEmpty() || pwd.length() > 4) {
                    errores.add(" Debe ingresar su contraseña,los ultimos 4 digitos del nombre ingresado con la letra verificadora ");
                }

                if (errores.isEmpty()) {
                    User u = new User();
                    u.setNombre(nmb);
                    u.setValidadorNom(vrnb);
                    u.setPassword(pwd);
                    usDAO.save(u);
                    startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
                    finish();
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Error al inciar sesion" + " "
                            + errores, Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}