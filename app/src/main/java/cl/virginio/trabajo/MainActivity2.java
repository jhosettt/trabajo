package cl.virginio.trabajo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {


    private EditText editTextNombre, editTextCorreo, editTextTelefono;
    private Button buttonRegistrarCliente;
    private Button buttonVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextNombre  = findViewById(R.id.editTextNombre);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        buttonRegistrarCliente = findViewById(R.id.buttonRegistrarCliente);
        buttonVolver = findViewById(R.id.buttonvolver);


        buttonRegistrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                String correo = editTextCorreo.getText().toString();
                String telefono = editTextTelefono.getText().toString();

                Toast.makeText(MainActivity2.this,
                        "Cliente registrado: " + nombre + ", " + correo + ", " + telefono,
                        Toast.LENGTH_SHORT).show();
            }
        });


        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}