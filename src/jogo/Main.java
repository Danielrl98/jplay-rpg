package jogo;

import jogo.mecanic.Cenario1;
import jogo.mecanic.Menu;
import jplay.Keyboard;
import jplay.Window;

public class Main {
    public static void main(String[] args) {
        
        Window window = new Window(800, 600);

        Keyboard teclado = window.getKeyboard();
        
        while(true){
            new Menu().plano.draw();
            window.update();

            if(teclado.keyDown(Keyboard.ENTER_KEY)) {
                new Cenario1(window);
            }
        }
    }
}