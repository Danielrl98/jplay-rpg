package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Cenario1 {
    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;

    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario1.scn");

        if(teclado == null) {
            teclado = janela.getKeyboard();
        }

        jogador = new Jogador(640, 350);
        run();
    }

    private void run() {
        while(true) {

            jogador.controle(janela, teclado);
            jogador.caminho(cena);
            cena.moveScene(jogador);
            
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

            jogador.draw();
            janela.update();
       
        }
    }
}
