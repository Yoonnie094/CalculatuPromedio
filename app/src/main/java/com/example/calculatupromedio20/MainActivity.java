package com.example.calculatupromedio20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView alp;
    EditText n1, n2, n3, n4, p1, p2, p3, p4;
    Button c;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.spinner);
        alp = (TextView) findViewById(R.id.alertap);
        n1 = (EditText) findViewById(R.id.edtn1);
        n2 = (EditText) findViewById(R.id.edtn2);
        n3 = (EditText) findViewById(R.id.edtn3);
        n4 = (EditText) findViewById(R.id.edtn4);
        p1 = (EditText) findViewById(R.id.edtp1);
        p2 = (EditText) findViewById(R.id.edtp2);
        p3 = (EditText) findViewById(R.id.edtp3);
        p4 = (EditText) findViewById(R.id.edtp4);
        c = (Button) findViewById(R.id.btnc);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,
                R.array.ramos, android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ops= parent.getItemAtPosition(position).toString();
                switch (ops){
                    default:
                        p1.setText("0");
                        p2.setText("0");
                        p3.setText("0");
                        p4.setText("0");
                        break;

                    case "Aplicaciones Moviles para IoT":
                        p1.setText("15");
                        p2.setText("25");
                        p3.setText("30");
                        p4.setText("30");
                        break;

                    case "Desarrollo de Videojuegos":
                        p1.setText("20");
                        p2.setText("40");
                        p3.setText("40");
                        p4.setText("0");
                        alp.setText("Atencion: Esta asignatura solo tiene 3 notas");
                        break;

                    case "Ingenieria de Software":
                        p1.setText("20");
                        p2.setText("25");
                        p3.setText("25");
                        p4.setText("30");
                        break;

                    case "Programacion Back End":
                        p1.setText("15");
                        p2.setText("25");
                        p3.setText("30");
                        p4.setText("30");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n1.getText().toString().isEmpty() ||
                        n2.getText().toString().isEmpty() ||
                        n3.getText().toString().isEmpty() ||
                        n4.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Debes ingresar todas las notas",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float po1= Float.parseFloat(p1.getText().toString());
                float po2= Float.parseFloat(p2.getText().toString());
                float po3= Float.parseFloat(p3.getText().toString());
                float po4= Float.parseFloat(p4.getText().toString());
                float pon= po1 + po2 + po3 + po4;

                float no1= Float.parseFloat(n1.getText().toString());
                float no2= Float.parseFloat(n2.getText().toString());
                float no3= Float.parseFloat(n3.getText().toString());
                float no4= Float.parseFloat(n4.getText().toString());
                float prom= ((no1*po1)/100) + ((no2*po2)/100) + ((no3*po3)/100) + ((no4*po4)/100);

                if (pon > 100) {
                    Toast.makeText(MainActivity.this,
                            "La suma de las ponderaciones no puede ser mayor a 100",
                            Toast.LENGTH_LONG).show();
                } else if (pon < 100) {
                    Toast.makeText(MainActivity.this,
                            "La suma de las ponderaciones no puede ser menor a 100",
                            Toast.LENGTH_LONG).show();
                } else {
                    String resultado = prom > 4.0 ? "aprovada" : "reprovada";
                    Intent intent = new Intent(MainActivity.this, Resultado.class);
                    intent.putExtra("asignatura", sp.getSelectedItem().toString());
                    intent.putExtra("promedio", prom);
                    intent.putExtra("resultado", resultado);
                    startActivity(intent);
                }

            }
        });
    }
}
