package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Compuertas {
    Bitmap compuerta;
    int x,y;
    int linea;
    boolean conexion;

    public Compuertas(Lienzo lienzo,int compuerta){
        this.compuerta = BitmapFactory.decodeResource(lienzo.getResources(),compuerta);
        linea = -1;
        conexion = false;

    }

    public void pintar(Canvas c, Paint p, int posX, int posY){
        x = posX;
        y = posY;
        c.drawBitmap(compuerta,x,y,p);
    }

    public int estaEnArea(int dedoX, int dedoY, int puntero){
        // 0 = No está en area    1 = Entrada izquierda   2 = Entrada derecha  3 = Salida   4 = Hay una sola entrada (NOT)

        if( (y+compuerta.getHeight()/2) <= dedoY && dedoY <= (y+compuerta.getHeight()) ){

            if(puntero == 1){
                return 4;
            }
            if( x<=dedoX && dedoX <= (x+compuerta.getWidth()/2) ){
                return 1;
            }else return 2;
        }
        if( y <= dedoY && dedoY < (y+compuerta.getHeight()/2) ){
            return 3;
        }
        return 0;
    }

    public int entradas2 (){
        int xeI = x + compuerta.getWidth()/4 +10;
        int yeI = y + compuerta.getHeight();

        int xeD = x + 3*compuerta.getWidth()/4 -5;
        int yeD = y + compuerta.getHeight();
        return 0;
    }

    public int getWidth(){
       return compuerta.getWidth();
    }

    public int getHeight(){
        return compuerta.getHeight();
    }

    public void entrada1(Canvas c, Paint p){
        int xe = x + compuerta.getWidth()/2 + 3;
        int ye = y + compuerta.getHeight() -1;

    }

    public void salida (Canvas c, Paint p){
        int xe = x + compuerta.getWidth()/2 + 3;
        int ye = y + 1;

    }

    public boolean resultadoAnd (boolean entrada1,boolean entrada2){
        return entrada1 && entrada2;
    }

    public boolean resultadoOr (boolean entrada1,boolean entrada2){
        return entrada1 || entrada2;
    }

    public boolean resultadoXor (boolean entrada1,boolean entrada2){
        return entrada1 ^ entrada2;
        //return ((entrada1 && (!entrada2)) || ((!entrada1) && entrada2));
    }

    public boolean resultadoNot (boolean entrada){
        return !entrada;
    }

    public void setLinea(int linea){
        this.linea = linea;
    }

    public int getLinea(){
        return linea;
    }

    public void setConexion(boolean x){
        conexion = x;
    }

    public boolean getConexion(){
        return conexion;
    }
}
