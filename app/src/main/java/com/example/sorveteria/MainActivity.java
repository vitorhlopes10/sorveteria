package com.example.sorveteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final int CONSTANTE_RESULTADO = 1;

    Spinner ddlTipoSorvete;
    RadioButton radioBtnChocolate;
    RadioButton radioBtnCreme;
    RadioButton radioBtnPistache;
    RadioButton radioBtnChocoPimenta;
    RadioButton radioBtnFlocos;
    EditText txtQtd;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ddlTipoSorvete = findViewById(R.id.ddlTipoSorvete);
        radioBtnChocolate = findViewById(R.id.radioBtnChocolate);
        radioBtnCreme = findViewById(R.id.radioBtnCreme);
        radioBtnPistache = findViewById(R.id.radioBtnPistache);
        radioBtnChocoPimenta = findViewById(R.id.radioBtnChocoPimenta);
        radioBtnFlocos = findViewById(R.id.radioBtnFlocos);
        txtQtd = (EditText) findViewById(R.id.txtQtd);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        carregarTipoSorvete();

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double valorTipoSorvete = 0;
                double valorInicialSorverte = 5;
                String sabor = "Não foi escolhido nenhum sabor";
                String tipoSorveteSelecionado = ddlTipoSorvete.getSelectedItem().toString();

                if (radioBtnChocolate.isChecked()){
                    sabor = radioBtnChocolate.getText().toString();
                } else if (radioBtnCreme.isChecked()) {
                    sabor = radioBtnCreme.getText().toString();
                } else if (radioBtnPistache.isChecked()) {
                    sabor = radioBtnPistache.getText().toString();
                } else if (radioBtnChocoPimenta.isChecked()) {
                    sabor = radioBtnChocoPimenta.getText().toString();
                } else if (radioBtnFlocos.isChecked()){
                    sabor = radioBtnFlocos.getText().toString();
                }

                switch (tipoSorveteSelecionado){
                    case "Duplo":
                        valorTipoSorvete = 30;
                        break;
                    case "Sunday":
                        valorTipoSorvete = 20;
                        break;
                    case "Mega":
                        valorTipoSorvete = 50;
                        break;
                    case "Bomba":
                        valorTipoSorvete = 40;
                        break;
                    case "Picolé":
                        valorTipoSorvete = 10;
                        break;
                }

                double precoTotal = (valorInicialSorverte + valorTipoSorvete) * Integer.parseInt(txtQtd.getText().toString());

                chamarAtividade(sabor, precoTotal, tipoSorveteSelecionado);
            }
        });
    }

    private void carregarTipoSorvete()
    {
        String tipo[] = {"Duplo", "Sunday", "Mega", "Bomba", "Picolé"};

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                tipo);

        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ddlTipoSorvete.setAdapter(adp);
    }

    private void chamarAtividade(String sabor, double precoTotal, String tipoSorvete)
    {
        Bundle params = new Bundle();
        params.putString("quantidade", txtQtd.getText().toString());
        params.putString("sabor", sabor);
        params.putString("tipoSorvete", tipoSorvete);
        params.putString("precoTotal", String.valueOf(precoTotal));

        Intent intent = new Intent(this, DespesaTotal.class);
        intent.putExtras(params);

        startActivity(intent);
    }
}