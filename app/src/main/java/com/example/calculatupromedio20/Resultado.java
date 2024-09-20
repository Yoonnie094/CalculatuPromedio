package com.example.calculatupromedio20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resultado extends AppCompatActivity {

    TextView r;
    Button v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        r= (TextView) findViewById(R.id.txtr);
        v= (Button) findViewById(R.id.volver);

        String resultado = getIntent().getStringExtra("resultado");
        String asignatura= getIntent().getStringExtra("asignatura");
        float promedio= getIntent().getFloatExtra("promedio", 0.0f);

        r.setText("La asignatura " + asignatura + " fue " + resultado + " con un promedio de " + promedio);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}