package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.Window;

public class Main {
    public void main(String[] args) {
        
        Window janela = new Window(800, 600);
        GameImage plano = new GameImage("src/recursos/sprites/menu.png");
        Keyboard teclado = janela.getKeyboard();
        
        while(true){
            plano.draw();
            janela.update();

            if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                new Cenario1(janela);
            }
        }
    }
}