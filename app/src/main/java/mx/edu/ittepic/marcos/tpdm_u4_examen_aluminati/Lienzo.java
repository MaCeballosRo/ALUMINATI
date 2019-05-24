package mx.edu.ittepic.marcos.tpdm_u4_examen_aluminati;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Lienzo extends View {
    Compuertas not, or, and, xor;
    Compuertas bombillaEncendida,bombillaApagada,botonApagado,botonEncendido,botonApagado1,botonEncendido1;
    Compuertas punteroCompuerta, punteroBoton,punteroBoton1, punteroBombilla;
    int nivel;
    int boton, boton1, bombillo;
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
        botonApagado1 = new Compuertas(this,R.drawable.boton1);
        botonEncendido1 = new Compuertas (this,R.drawable.boton);

        boton = 0;
        boton1 = 0;
        bombillo = 0;
        resultado = false;
        aux = 1;
        punteroBoton = botonApagado;
        punteroBoton1 = botonApagado1;
        punteroBombilla = bombillaApagada;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    protected void onDraw(Canvas c){
        Paint p = new Paint();
        if(boton == 0){
            botonApagado.setLinea(punteroBoton.getLinea());
            botonApagado.setConexion(punteroBoton.getConexion());
            punteroBoton = botonApagado;
        }else {
            botonEncendido.setLinea(punteroBoton.getLinea());
            botonEncendido.setConexion(punteroBoton.getConexion());
            punteroBoton = botonEncendido;
        }

        if(boton1 == 0){
            botonApagado1.setLinea(punteroBoton1.getLinea());
            botonApagado1.setConexion(punteroBoton1.getConexion());
            punteroBoton1 = botonApagado1;
        }else{
            botonEncendido1.setLinea(punteroBoton1.getLinea());
            botonEncendido1.setConexion(punteroBoton1.getConexion());
            punteroBoton1 = botonEncendido1;
        }

        if(bombillo == 0){
            bombillaApagada.setLinea(punteroBombilla.getLinea());
            bombillaApagada.setConexion(punteroBombilla.getConexion());
            punteroBombilla = bombillaApagada;
        }else {
            bombillaEncendida.setLinea(punteroBombilla.getLinea());
            bombillaEncendida.setConexion(punteroBombilla.getConexion());
            punteroBombilla = bombillaEncendida;
        }



        switch(nivel){
            case 1://nivel 1
                if(punteroBombilla == bombillaApagada){//diferencia de x de 50
                    punteroBombilla.pintar(c,p,ancho/2-(bombillaApagada.getWidth())/2,115);
                }else{
                    punteroBombilla.pintar(c,p,ancho/2-((bombillaApagada.getWidth())/2)-50,50);
                }

                not.pintar(c,p,ancho/2-(not.getWidth())/2,alto/3);
                punteroBoton.pintar(c,p,ancho/2-(punteroBoton.getWidth())/2,2*alto/3);
                punteroCompuerta = not;

                for(int i = 1; i<aux; i++){
                    lineas[i].Dibujar(c,p);
                }
                break;

            case 2: //nivel 2
                if(punteroBombilla == bombillaApagada){//diferencia de x de 50
                    punteroBombilla.pintar(c,p,ancho/2-(bombillaApagada.getWidth())/2,115);
                }else{
                    punteroBombilla.pintar(c,p,ancho/2-((bombillaApagada.getWidth())/2)-50,50);
                }
                and.pintar(c,p,ancho/2-(not.getWidth())/2,alto/3);
                punteroBoton.pintar(c,p,ancho/3-(punteroBoton.getWidth())/2,2*alto/3);
                punteroBoton1.pintar(c,p,2*ancho/3-(punteroBoton1.getWidth())/2,2*alto/3);
                punteroCompuerta = and;

                for(int i = 1; i<aux; i++){
                    lineas[i].Dibujar(c,p);
                }

                break;

            case 3://nivel 3
                if(punteroBombilla == bombillaApagada){//diferencia de x de 50
                    punteroBombilla.pintar(c,p,ancho/2-(bombillaApagada.getWidth())/2,115);
                }else{
                    punteroBombilla.pintar(c,p,ancho/2-((bombillaApagada.getWidth())/2)-50,50);
                }
                or.pintar(c,p,ancho/2-(not.getWidth())/2,alto/3);
                punteroBoton.pintar(c,p,ancho/3-(punteroBoton.getWidth())/2,2*alto/3);
                punteroBoton1.pintar(c,p,2*ancho/3-(punteroBoton1.getWidth())/2,2*alto/3);
                punteroCompuerta = or;

                for(int i = 1; i<aux; i++){
                    lineas[i].Dibujar(c,p);
                }
                break;
            case 4: //nivel 4
                if(punteroBombilla == bombillaApagada){//diferencia de x de 50
                    punteroBombilla.pintar(c,p,ancho/2-(bombillaApagada.getWidth())/2,115);
                }else{
                    punteroBombilla.pintar(c,p,ancho/2-((bombillaApagada.getWidth())/2)-50,50);
                }
                xor.pintar(c,p,ancho/2-(not.getWidth())/2,alto/3);
                punteroBoton.pintar(c,p,ancho/3-(punteroBoton.getWidth())/2,2*alto/3);
                punteroBoton1.pintar(c,p,2*ancho/3-(punteroBoton1.getWidth())/2,2*alto/3);
                punteroCompuerta = xor;

                for(int i = 1; i<aux; i++){
                    lineas[i].Dibujar(c,p);
                }

                break;

            case 5: //nivel 5
                break;

        }

        p.setColor(Color.GRAY);
        c.drawRect(0, 0, 270, 70, p);
        p.setColor(Color.BLACK);
        p.setTextSize(60);
        c.drawText("Siguiente", 10, 50, p);

        p.setColor(Color.GRAY);
        c.drawRect(0, 80, 160, 150, p);
        p.setColor(Color.BLACK);
        p.setTextSize(60);
        c.drawText("Atrás", 10, 130, p);
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

                if(punteroBoton1.estaEnArea(posx,posy,punteroAux)!=0){
                    coordenadas1 = coordenadaSalida(punteroBoton1);
                    origen ="boton1";
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
                        if(punteroBoton.getLinea()!=0){
                            lineas[punteroBoton.getLinea()].setValor(false);
                        }
                    }else {
                        boton = 1;
                        if(punteroBoton.getLinea()!=0){
                            lineas[punteroBoton.getLinea()].setValor(true);

                        }
                    }

                    prenderBombillo();
                }

                if(punteroBoton1.estaEnArea(posx,posy,punteroAux)!=0){

                    if(punteroBoton1 == botonEncendido1){
                        boton1 = 0;
                        if(punteroBoton1.getLinea()!=0){
                            lineas[punteroBoton1.getLinea()].setValor(false);
                        }
                    }else {
                        boton1 = 1;
                        if(punteroBoton1.getLinea()!=0){
                            lineas[punteroBoton1.getLinea()].setValor(true);

                        }
                    }
                    prenderBombillo();
                }

                area = punteroCompuerta.estaEnArea(posx,posy,punteroAux);
                if(area!=0 && (origen.equals("boton") || origen.equals("boton1"))){
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
                            aux++;
                        }
                        prenderBombillo();
                    }

                    if(origen.equals("boton1")){
                        if(!punteroBoton1.getConexion()){
                            lineas[aux]= new Linea(xInicial,yInicial,xFinal,yFinal);
                            punteroBoton1.setLinea(aux);
                            punteroBoton1.setConexion(true);
                            if(punteroBoton1==botonApagado1){
                                lineas[aux].setValor(false);
                            }else{
                                lineas[aux].setValor(true);
                            }
                            aux++;
                        }
                        prenderBombillo();
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
                siguiente(posx,posy);
                anterior(posx,posy);
                break;
        }
        invalidate();


        return true;
    }

    private void siguiente(int posx, int posy){
        if(0<=posx && posx<=270){
            if(0<=posy && posy <=70){
                bombillaApagada = new Compuertas(this,R.drawable.bombilla2);
                bombillaEncendida = new Compuertas(this,R.drawable.bombilla1);
                botonApagado = new Compuertas(this,R.drawable.boton1);
                botonEncendido = new Compuertas (this,R.drawable.boton);
                botonApagado1 = new Compuertas(this,R.drawable.boton1);
                botonEncendido1 = new Compuertas (this,R.drawable.boton);

                boton = 0;
                boton1 = 0;
                bombillo = 0;
                resultado = false;
                aux = 1;
                punteroBoton = botonApagado;
                punteroBoton1 = botonApagado1;
                punteroBombilla = bombillaApagada;
                if(nivel<4){
                    nivel++;
                }
            }
        }
    }

    private void anterior(int posx,int posy){
        if(0<=posx && posx<=160){
            if(80<=posy && posy <=150){
                bombillaApagada = new Compuertas(this,R.drawable.bombilla2);
                bombillaEncendida = new Compuertas(this,R.drawable.bombilla1);
                botonApagado = new Compuertas(this,R.drawable.boton1);
                botonEncendido = new Compuertas (this,R.drawable.boton);
                botonApagado1 = new Compuertas(this,R.drawable.boton1);
                botonEncendido1 = new Compuertas (this,R.drawable.boton);

                boton = 0;
                boton1 = 0;
                bombillo = 0;
                resultado = false;
                aux = 1;
                punteroBoton = botonApagado;
                punteroBoton1 = botonApagado1;
                punteroBombilla = bombillaApagada;
                if(nivel>1){
                    nivel--;
                }
            }
        }
    }

    private void prenderBombillo(){
        //Toast.makeText(getContext(),"Boton: "+punteroBombilla.getLinea(),Toast.LENGTH_SHORT).show();

        if(punteroBombilla.getLinea()!=0){
            if(punteroCompuerta==not && punteroBoton.getLinea()!=0){
                    resultado = punteroBombilla.resultadoNot(lineas[punteroBoton.getLinea()].getValor());
            }
            if(punteroBoton.getLinea()!=0 && punteroBoton1.getLinea()!=0) {
                if(punteroCompuerta==and){
                    resultado = punteroBombilla.resultadoAnd(lineas[punteroBoton.getLinea()].getValor(),lineas[punteroBoton1.getLinea()].getValor());
                }
                if(punteroCompuerta==or){
                    resultado = punteroBombilla.resultadoOr(lineas[punteroBoton.getLinea()].getValor(),lineas[punteroBoton1.getLinea()].getValor());
                }

                if(punteroCompuerta==xor){
                    resultado = punteroBombilla.resultadoXor(lineas[punteroBoton.getLinea()].getValor(),lineas[punteroBoton1.getLinea()].getValor());
                }

            }
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
