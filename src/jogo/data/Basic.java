package jogo.data;

import jplay.Window;
import java.awt.Color;

public class Basic {

    private Window janela;

    public Basic(
        Window janela,
        double x,
        double y
        ){
       this.janela = janela;
       life();
       coord(x, y); 
    } 
    private void life(){
        this.janela.drawText("Vida: 0", 300, 300, Color.WHITE);
    }
    private void coord(double x, double y){
        this.janela.drawText("Coordenadas: X: " + (int) x + " Y: " + (int) y, 10, 30, Color.WHITE);
    }
}
