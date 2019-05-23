package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
=======
import android.view.Gravity;
import android.widget.Toast;
>>>>>>> 7a35764fc07b0d95f973ab59de0adc257ed70f83

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

<<<<<<< HEAD
=======

        Toast toast1 = Toast.makeText(getApplicationContext(),
                " ULISES ALEGRIA \n MARCOS CEBALLOS \n ARLETTE CONCHAS", Toast.LENGTH_LONG);
        toast1.setGravity(Gravity.CENTER,30,500);

        toast1.show();

>>>>>>> 7a35764fc07b0d95f973ab59de0adc257ed70f83
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
