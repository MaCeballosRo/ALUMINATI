package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Gravity;
import android.widget.Toast;


public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);



        Toast toast1 = Toast.makeText(getApplicationContext(),
                " ULISES ALEGRIA \n MARCOS CEBALLOS \n ARLETTE CONCHAS", Toast.LENGTH_LONG);
        toast1.setGravity(Gravity.CENTER,30,500);

        toast1.show();

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
