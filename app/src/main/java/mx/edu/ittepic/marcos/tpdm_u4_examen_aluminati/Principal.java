package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent otro = new Intent(Principal.this, Menu.class);
                Principal.this.startActivity(otro);
                Principal.this.finish();
            }
        },5000);

    }
}
