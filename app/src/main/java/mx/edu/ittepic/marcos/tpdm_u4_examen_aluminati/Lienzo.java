package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Compuertas not, or, and, xor, bombillaEncendida,bombillaApagada,botonApagado,botonEncendido, punteroCompuerta, punteroBoton,punteroBombilla;
    int nivel;
    int boton;
    int ancho = this.getResources().getDisplayMetrics().widthPixels;
    int alto = this.getResources().getDisplayMetrics().heightPixels;
    int area, aux,xInicial,yInicial, xFinal, yFinal;
    Paint p = new Paint();
    Linea[] lineas = new Linea[30];
    int[] coordenadas;
    int[] coordenadas1;
    String origen;

    public Lienzo (Context context){
        super(context);
        not = new Compuertas(this,R.drawable.not);
        and = new Compuertas(this,R.drawable.and);
        or = new Compuertas(this,R.drawable.or);
        xor = new Compuertas(this,R.drawable.xor);
        bombillaApagada = new Compuertas(this,R.drawable.bombilla2);
        bombillaEncendida = new Compuertas(this,R.drawable.bombilla1);
        botonApagado = new Compuertas(this,R.drawable.boton1);
        botonEncendido = new Compuertas (this,R.drawable.boton);
        boton = 0;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    protected void onDraw(Canvas c){
        Paint p = new Paint();
        if(boton == 0){
            punteroBoton = botonApagado;
        }
        else punteroBoton = botonEncendido;

        switch(nivel){
            case 1://nivel 1
                //bombillaApagada.pintar(c,p,ancho/2-30,115);
                //bombillaEncendida.pintar(c,p,50,50);
                bombillaApagada.pintar(c,p,ancho/2-50,115);
                not.pintar(c,p,ancho/2-50,alto/3);
                punteroBoton.pintar(c,p,ancho/2-50,2*alto/3);
                punteroCompuerta = not;
                punteroBombilla = bombillaApagada;

                for(int i = 0; i<aux; i++){
                    lineas[i].Dibujar(c,p);
                }
                break;
            case 2: //nivel 2
                bombillaApagada.pintar(c,p,ancho/2-50,115);
                and.pintar(c,p,ancho/2-50,alto/3);
                punteroBoton.pintar(c,p,ancho/2-50,2*alto/3);
                punteroCompuerta = and;
                punteroBombilla = bombillaEncendida;

                break;
            case 3://nivel 3
                bombillaApagada.pintar(c,p,ancho/2-50,115);
                or.pintar(c,p,ancho/2-50,alto/3);
                punteroBoton.pintar(c,p,ancho/2-50,2*alto/3);
                punteroCompuerta = or;
                punteroBombilla = bombillaEncendida;
                break;
            case 4: //nivel 4
                bombillaApagada.pintar(c,p,ancho/2-50,115);
                xor.pintar(c,p,ancho/2-50,alto/3);
                punteroBoton.pintar(c,p,ancho/2-50,2*alto/3);
                punteroCompuerta = xor;
                punteroBombilla = bombillaEncendida;
                break;
            case 5: //nivel 4
                break;

        }
    }

    public boolean onTouchEvent(MotionEvent me){
        int accion = me.getAction();
        int posx = (int)me.getX();
        int posy = (int)me.getY();
        int punteroAux = 0;
        coordenadas1 = null;

        switch(accion){
            case MotionEvent.ACTION_DOWN:
                if(punteroBoton.estaEnArea(posx,posy,punteroAux)!=0){
                    coordenadas1 = coordenadaSalida(punteroBoton);
                    origen ="boton";

                }
                if(punteroCompuerta.estaEnArea(posx,posy,punteroAux)==3){
                    coordenadas1 = coordenadaSalida(punteroCompuerta);
                    origen = "compuerta";
                }
                if(coordenadas1!=null){
                    xInicial = coordenadas1[0];
                    yInicial = coordenadas[1];
                }
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                if(punteroCompuerta == not){
                    punteroAux = 1;
                }
                if(punteroBoton.estaEnArea(posx,posy,punteroAux)!=0){
                    if(punteroBoton == botonEncendido){
                        boton = 0;
                    }else {
                        boton = 1;
                    }

                }
                area = punteroCompuerta.estaEnArea(posx,posy,punteroAux);
                if(area!=0 && origen.equals("boton")){
                    if(area == 4){
                        coordenadas1 = coordenada1Entrada(punteroCompuerta);

                    }else{
                        if(area !=3) {
                            coordenadas1 = coordenadas2Entradas(punteroCompuerta);
                        }
                    }
                }else{
                    if(punteroBombilla.estaEnArea(posx,posy,punteroAux) !=0 && origen.equals("compuerta")){
                        coordenadas1 = coordenada1Entrada(punteroBombilla);
                    }
                }

                if(coordenadas1 != null){
                    xFinal = coordenadas1[0];
                    yFinal = coordenadas1[1];
                    lineas[aux]= new Linea(xInicial,yInicial,xFinal,yFinal);
                    aux++;
                }

                break;
        }
        invalidate();
        return true;
    }

    private int[] coordenadas2Entradas(Compuertas puntero){
        int xiFinal = puntero.x + puntero.getWidth()/4 +10;
        int yiFinal = puntero.y + puntero.getHeight();
        int xdFinal = puntero.x + 3*puntero.getWidth()/4 -5;
        int ydFinal = puntero.y + puntero.getHeight();
        if(area == 1){
            coordenadas = new int[]{xiFinal,yiFinal};
        }else {
            coordenadas = new int[]{xdFinal,ydFinal};
        }
        return coordenadas;
    }

    private int[] coordenada1Entrada (Compuertas puntero){
        int xeFinal = puntero.x + puntero.getWidth()/2 +3;
        int yeFinal = puntero.y + puntero.getHeight() -1;
        //lineas[aux]= new Linea(xInicio,yInicio,xeFinal,yeFinal);
        //aux++;
        coordenadas = new int[]{xeFinal,yeFinal};
        return coordenadas;
    }

    private int[] coordenadaSalida (Compuertas puntero){
        int xsFinal = puntero.x + puntero.getWidth()/2 + 3;
        int ysFinal = puntero.y + 1;
        coordenadas = new int[]{xsFinal,ysFinal};
        return coordenadas;
    }
}
