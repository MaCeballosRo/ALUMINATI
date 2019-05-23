package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Introduccion extends AppCompatActivity {
    Button and, or, not, xor, regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion);
        and = findViewById(R.id.idand);
        or = findViewById(R.id.idor);
        not = findViewById(R.id.idnot);
        xor = findViewById(R.id.idxor);
        regresar = findViewById(R.id.atras);

        and.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                andOperacion();
            }
        });

        or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orOperacion();
            }
        });

        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notOperacion();
            }
        });

        xor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xorOperacion();
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otro = new Intent(Introduccion.this,  Menu.class);
                startActivity(otro);
                finish();
            }
        });
    }

    private void andOperacion(){

    }

    private void orOperacion(){

    }

    private void notOperacion(){

    }

    private void xorOperacion(){

    }
}
