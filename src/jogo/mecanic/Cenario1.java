package jogo.mecanic;

import jogo.data.Basic;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;

public class Cenario1 {
    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;
    private Zumbi zumbi;

    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario1.scn");

        if(teclado == null) {
            teclado = janela.getKeyboard();
        }

        Som.play("src/recursos/audio/Only-The-Lonely-2.mid");
        jogador = new Jogador(540, 350);
        zumbi = new Zumbi(300, 300);
        run();
    }
    private void run() {

        while(true) {
            new Basic(janela, jogador.x, jogador.y);

            jogador.controle(janela, teclado);
            jogador.caminho(cena);

            zumbi.caminho(cena);
            zumbi.perseguir(jogador.x, jogador.y);

            cena.moveScene(jogador);

            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

            zumbi.x += cena.getXOffset();
            zumbi.y += cena.getYOffset();

            jogador.draw();
            zumbi.draw();

            janela.update();
       
        }
    }
}
