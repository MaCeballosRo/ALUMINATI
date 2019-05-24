package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.graphics.Canvas;
import android.graphics.Color;

import android.graphics.Paint;

public class Linea {
    int posXorigen,posYorigen,posXfinal,posYfinal;
    boolean valor;
    String origen,destino;

    public Linea(int initX,int initY,int endX,int endY){
        posXorigen=initX;
        posYorigen=initY;
        posXfinal=endX;
        posYfinal=endY;
    }

    public Linea(){}

    public void Dibujar(Canvas c, Paint p){
        p.setStrokeWidth(10);
        c.drawLine(posXorigen,posYorigen,posXfinal,posYfinal,p);
    }

    public void setValor(boolean v){
        valor = v;
    }
    public boolean getValor(){
        return valor;
    }

    public void setOrigen(String o){
        origen = o;
    }

    public String getOrigen(){
        return origen;
    }

    public void setDestino(String d){
        destino = d;
    }

    public String getDestino(){
        return destino;
    }

    public void BorrarLines(Canvas c,int toqueX, int toqueY,Paint p){
        if((toqueX >=posXorigen && toqueX<=posXfinal) || (toqueX <=posXorigen && toqueX>=posXfinal)){

            if((toqueY >=posYorigen && toqueY<=posYfinal) || (toqueY <=posYorigen && toqueY>=posYfinal)) {
                p.setColor(Color.argb(255, 255, 255, 255));
                Dibujar(c, p);
            }
        }

    }


}
