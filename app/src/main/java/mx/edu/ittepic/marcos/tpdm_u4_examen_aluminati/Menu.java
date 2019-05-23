package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button introduccion, nivel1, nivel2, nivel3, nivel4, nivel5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        introduccion = findViewById(R.id.intro);
        nivel1 = findViewById(R.id.n1);
        nivel2 = findViewById(R.id.n2);
        nivel3 = findViewById(R.id.n3);
        nivel4 = findViewById(R.id.n4);
        nivel5 = findViewById(R.id.n5);

        introduccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otro = new Intent(Menu.this, Introduccion.class);
                Menu.this.startActivity(otro);
                Menu.this.finish();
            }
        });

        nivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otro = new Intent(Menu.this,  MainActivity.class);
                otro.putExtra("nivel",1);
                Menu.this.startActivity(otro);
                Menu.this.finish();
            }
        });

        nivel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otro = new Intent(Menu.this,  MainActivity.class);
                otro.putExtra("nivel",2);
                Menu.this.startActivity(otro);
                Menu.this.finish();
            }
        });

        nivel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otro = new Intent(Menu.this,  MainActivity.class);
                otro.putExtra("nivel",3);
                Menu.this.startActivity(otro);
                Menu.this.finish();
            }
        });

        nivel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otro = new Intent(Menu.this,  MainActivity.class);
                otro.putExtra("nivel",4);
                Menu.this.startActivity(otro);
                Menu.this.finish();
            }
        });

        nivel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otro = new Intent(Menu.this,  MainActivity.class);
                otro.putExtra("nivel",5);
                Menu.this.startActivity(otro);
                Menu.this.finish();
            }
        });
    }
}
