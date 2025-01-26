package jogo.mecanic;

import java.util.ArrayList;
import java.util.LinkedList;

import jplay.Scene;
import jplay.Sound;

public class ControleTiros {
    LinkedList<Tiro> tiros = new LinkedList<>();

    public void adicionarTiro(double x, double y, int caminho, Scene cena){
        Tiro tiro = new Tiro(x, y, caminho);
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
        somDisparo();
    }
    public void run(ArrayList<Zumbi> inimigos){
        for(int i = 0; i < tiros.size(); i++){
            Tiro tiro = tiros.removeFirst();
            tiro.mover();
            tiros.addLast(tiro);

            for (Zumbi inimigo : inimigos) {
                if(tiro.collided(inimigo)){
                    tiro.x = 100000;
                    inimigo.perderVida();
                }
            }
            
        }
    }
    public void somDisparo(){
        Sound sound = new Sound("src/recursos/audio/tiro.WAV");
        sound.play();
        sound.setVolume(-20f);

    }
}
