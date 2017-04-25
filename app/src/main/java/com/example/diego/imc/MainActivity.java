package com.example.diego.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtEstatura, txtPeso;
    Button btnCalcular;
    TextView lblResultado, lblMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias
        txtEstatura = (EditText) findViewById(R.id.txtAltura);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        lblResultado = (TextView) findViewById(R.id.lblresultado);
        lblMensaje = (TextView) findViewById(R.id.lblmen);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CalculoIMC objeto = new CalculoIMC(Float.parseFloat(txtPeso.getText().toString()), Float.parseFloat(txtEstatura.getText().toString()));
                lblResultado.setText(String.valueOf(objeto.calcular()));
                if (objeto.calcular() < 16.00) {
                    lblMensaje.setText("Delgadez severa");
                }
                if (objeto.calcular() >= 160.00 && objeto.calcular() <= 160.99) {
                    lblMensaje.setText("Delgadez moderada");
                }

                if (objeto.calcular() >= 170.00 && objeto.calcular() <= 180.49) {
                    lblMensaje.setText("Delgadez aceptable");
                }

                if (objeto.calcular() >= 180.50 && objeto.calcular() <= 240.99) {
                    lblMensaje.setText("Peso normal");
                }

                if (objeto.calcular() >= 250.00 || objeto.calcular() <= 290.99) {
                    lblMensaje.setText("Sobrepeso");
                }

                if (objeto.calcular() >= 300.00 || objeto.calcular() <= 340.99) {
                    lblMensaje.setText("Obeso tipo I");
                }

                if (objeto.calcular() >= 350.00 || objeto.calcular() <= 400.00) {
                    lblMensaje.setText("Obeso tipo II");
                }

                if (objeto.calcular() >= 400.00) {
                    lblMensaje.setText("Obesidad tipo III");
                }
            }
        });
    }

}
