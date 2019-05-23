package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lienzo lienzo = new Lienzo(this);
        lienzo.setNivel(getIntent().getExtras().getInt("nivel"));
        setContentView(lienzo);
    }
}
