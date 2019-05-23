package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Compuertas not, or, and, xor, bombillaEncendida,bombillaApagada,botonApagado,botonEncendido, punteroCompuerta, punteroBoton,punteroBombilla;
    int nivel;
    int boton, bombillo;
    int ancho = this.getResources().getDisplayMetrics().widthPixels;
    int alto = this.getResources().getDisplayMetrics().heightPixels;
    int area, aux,xInicial,yInicial, xFinal, yFinal;
    Paint p = new Paint();
    Linea[] lineas = new Linea[30];
    int[] coordenadas;
    int[] coordenadas1;
    String origen,destino;
    boolean resultado;

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
        bombillo = 0;
        resultado = false;
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

        if(bombillo == 0){
            punteroBombilla = bombillaApagada;
        }else punteroBombilla = bombillaEncendida;

        switch(nivel){
            case 1://nivel 1
                if(punteroBombilla == bombillaApagada){
                    punteroBombilla.pintar(c,p,ancho/2-50,115);
                }else{
                    punteroBombilla.pintar(c,p,ancho/2-50,50);
                }

                not.pintar(c,p,ancho/2-50,alto/3);
                punteroBoton.pintar(c,p,ancho/2-50,2*alto/3);
                punteroCompuerta = not;

                for(int i = 0; i<aux; i++){
                    lineas[i].Dibujar(c,p);
                }
                break;
            case 2: //nivel 2
                break;
            case 3://nivel 3
                break;
            case 4: //nivel 4
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
                        if(punteroBoton.getLinea()!=-1){
                            lineas[punteroBoton.getLinea()].setValor(false);
                        }
                    }else {
                        boton = 1;
                        if(punteroBoton.getLinea()!=-1){
                            lineas[punteroBoton.getLinea()].setValor(true);

                        }
                    }
                    if(punteroCompuerta.getLinea()!=-1){
                        prenderBombillo();
                    }

                }
                area = punteroCompuerta.estaEnArea(posx,posy,punteroAux);
                if(area!=0 && origen.equals("boton")){
                    if(area == 4){
                        coordenadas1 = coordenada1Entrada(punteroCompuerta);
                        destino = "1entrada";

                    }else{
                        if(area !=3) {
                            coordenadas1 = coordenadas2Entradas(punteroCompuerta);
                        }
                    }
                }else{
                    if(punteroBombilla.estaEnArea(posx,posy,punteroAux) !=0 && origen.equals("compuerta")){
                        coordenadas1 = coordenada1Entrada(punteroBombilla);
                        destino = "bombilla";
                    }
                }

                if(coordenadas1 != null){
                    xFinal = coordenadas1[0];
                    yFinal = coordenadas1[1];

                    if(origen.equals("boton")){
                        if(!punteroBoton.getConexion()){
                            lineas[aux]= new Linea(xInicial,yInicial,xFinal,yFinal);
                            punteroBoton.setLinea(aux);
                            punteroBoton.setConexion(true);
                            if(punteroBoton==botonApagado){
                                lineas[aux].setValor(false);
                            }else{
                                lineas[aux].setValor(true);
                            }
                            prenderBombillo();
                            aux++;
                        }
                    }
                    if(destino.equals("bombilla")){
                        if(!punteroBombilla.getConexion()){
                            lineas[aux]= new Linea(xInicial,yInicial,xFinal,yFinal);
                            punteroBombilla.setLinea(aux);
                            punteroBombilla.setConexion(true);
                            prenderBombillo();
                            //lineas[aux].setValor(prenderBombillo());
                            aux++;
                        }
                    }
                    origen.equals("");
                    destino.equals("");
                }

                break;
        }
        invalidate();
        return true;
    }

    private void prenderBombillo(){
        if(punteroBombilla.getLinea()!=-1){
            resultado = punteroBombilla.resultadoNot(lineas[punteroBoton.getLinea()].getValor());
        }

        if(resultado){
            bombillo = 1;
        }else{
            bombillo = 0;
        }
    }

    private int[] coordenadas2Entradas(Compuertas puntero){
        int xiFinal = puntero.x + puntero.getWidth()/4 +10;
        int yiFinal = puntero.y + puntero.getHeight();
        int xdFinal = puntero.x + 3*puntero.getWidth()/4 -5;
        int ydFinal = puntero.y + puntero.getHeight();
        if(area == 1){
            coordenadas = new int[]{xiFinal,yiFinal};
            destino ="entradaI";
        }else {
            coordenadas = new int[]{xdFinal,ydFinal};
            destino = "entradaD";
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
