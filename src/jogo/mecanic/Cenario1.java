package jogo.mecanic;

import java.util.ArrayList;

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
    }
    public void run() {
        cena = new Scene();
        cena.loadFromFile("src/recursos/scn/Cenario1.scn");
     
        Cenario cenario = new Cenario();

        if(teclado == null) {
            teclado = janela.getKeyboard();
        }

        jogador = new Jogador(0, 0);

        Zumbi zumbi = new Zumbi(300, 300);
        Zumbi zumbi2 = new Zumbi(400, 100);
        Zumbi zumbi3 = new Zumbi(500, 200);
        Zumbi zumbi4 = new Zumbi(100, 400);
        Zumbi zumbi5 = new Zumbi(300, 300);
        Zumbi zumbi6 = new Zumbi(200, 150);

        ArrayList<Zumbi> inimigos = new ArrayList<>();

        inimigos.add(zumbi);
        inimigos.add(zumbi2);
        inimigos.add(zumbi3);
        inimigos.add(zumbi4);
        inimigos.add(zumbi5);
        inimigos.add(zumbi6);

        while(true) {

            jogador.controle(janela, teclado);
            jogador.caminho(cena);

            cena.moveScene(jogador);

            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

            for (Zumbi inimigo : inimigos) {

                inimigo.caminho(cena);

                if(inimigo.x > jogador.x - 100 || inimigo.y > jogador.y - 100){
                    inimigo.perseguir(jogador.x, jogador.y);
                }
                

                inimigo.x += cena.getXOffset();
                inimigo.y += cena.getYOffset();

                inimigo.draw();

                if(jogador.collided(inimigo)){
                    jogador.x = 10000;
                    cenario.getCenario(1);
                }
            }

            jogador.atirar(janela, cena, teclado, inimigos);

            jogador.draw();

            janela.update();

        }
    }

    
}
