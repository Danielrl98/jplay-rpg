package jogo.mecanic;

import jplay.Window;

public class Cenario {
 
    public Cenario() {}
  
    public void getCenario(int cenario){

        Window window = new Window(800, 600);

        Som.stop();

        switch (cenario) {
            case 0:
                new Menu().plano.draw();
                break;
            case 1:
                Som.play("src/recursos/audio/Only-The-Lonely-2.mid");
                new Cenario1(window).run();
                break;
            case 2:
                new Cenario1(window).run();
                break;
            default:
                break;
        }
    }
  
}
