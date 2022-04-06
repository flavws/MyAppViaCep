package br.com.local.myappviacepapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button btnBuscarCep;
    EditText txtCep;
    TextView lblLogradouro;
    TextView lblComplemento;
    TextView lblBairro;
    TextView lblLocalidade;
    TextView lblUF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCep = findViewById(R.id.txtCep);
        lblLogradouro = findViewById(R.id.lblLogradouro);
        lblComplemento = findViewById(R.id.lblComplemento);
        lblBairro = findViewById(R.id.lblBairro);
        lblLocalidade = findViewById(R.id.lblLocalidade);
        lblUF = findViewById(R.id.lblUF);
        btnBuscarCep = findViewById(R.id.btnBuscaCep);

        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // String endereco = txtCep.getText().toString().trim();

                try {
                    //preencher o cep no lblResposta do layout
                    CEP retorno = new HttpService(txtCep.getText().toString()).execute().get();
                    lblLogradouro.setText(retorno.getLogradouro());
                    lblComplemento.setText(retorno.getComplemento());
                    lblBairro.setText(retorno.getBairro());
                    lblLocalidade.setText(retorno.getLocalidade());
                    lblUF.setText(retorno.getUf());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}