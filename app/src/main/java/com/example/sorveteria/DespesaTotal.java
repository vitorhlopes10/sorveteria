package com.example.sorveteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DespesaTotal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesa_total);

        Intent intent = getIntent();

        if (intent != null) {
            Bundle params = intent.getExtras();
            String sabor = params.getString("sabor");
            String tipoSorvete = params.getString("tipoSorvete");
            String quantidade = params.getString("quantidade");
            String precoTotal = params.getString("precoTotal");

            TextView resultLabelSabor = (TextView) findViewById(R.id.resultLabelSabor);
            TextView resultLabelTipoSorvete = (TextView) findViewById(R.id.resultLabelTipoSorvete);
            TextView resultLabelQuantidade = (TextView) findViewById(R.id.resultLabelQuantidade);
            TextView resultLabelPrecoTotal = (TextView) findViewById(R.id.resultLabelPrecoTotal);

            resultLabelSabor.setText(resultLabelSabor.getText().toString() + sabor);
            resultLabelTipoSorvete.setText(resultLabelTipoSorvete.getText().toString() + tipoSorvete);
            resultLabelQuantidade.setText(resultLabelQuantidade.getText().toString() + quantidade);
            resultLabelPrecoTotal.setText(resultLabelPrecoTotal.getText().toString() + "R$ " + precoTotal);
        }
    }
}