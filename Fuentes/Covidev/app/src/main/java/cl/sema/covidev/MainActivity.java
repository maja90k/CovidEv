package cl.sema.covidev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText user_nameTxt;
    private EditText user_passTxt;
    private Button iniciarsesionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.user_nameTxt = findViewById(R.id.user_name);
        this.user_passTxt = findViewById(R.id.user_pass);
        this.iniciarsesionButton = findViewById(R.id.iniciarsesionBtn);
    }
}