package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.graphics.Canvas;
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

    public int getPosXorigen() {
        return posXorigen;
    }

    public void setPosXorigen(int posXorigen) {
        this.posXorigen = posXorigen;
    }

    public int getPosYorigen() {
        return posYorigen;
    }

    public void setPosYorigen(int posYorigen) {
        this.posYorigen = posYorigen;
    }

    public int getPosXfinal() {
        return posXfinal;
    }

    public void setPosXfinal(int posXfinal) {
        this.posXfinal = posXfinal;
    }

    public int getPosYfinal() {
        return posYfinal;
    }

    public void setPosYfinal(int posYfinal) {
        this.posYfinal = posYfinal;
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
}
