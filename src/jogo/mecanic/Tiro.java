package jogo.mecanic;

import jplay.Sprite;

public class Tiro extends Sprite {
    public static final int LEFT = 1, RIGHt = 2, STOP = 3, UP = 4, DOWN = 5;

    protected static final int VELOCIDADE_TIRO = 10;
    protected int caminho  = STOP;
    protected boolean movendo = false;
    protected int direcao = 3;

    public Tiro(double x, double y, int caminho){
        super("src/recursos/sprites/tiro.png", 12);

        this.caminho = caminho;
        this.x = x;
        this.y = y;
    }

    public void mover(){
        if(caminho == LEFT){
            this.x -= VELOCIDADE_TIRO;
            if(direcao != 1){
                setSequence(5, 8);
            }
            movendo = true;
        }
        if(caminho == RIGHt){
            this.x += VELOCIDADE_TIRO;
            if(direcao != 2){
                setSequence(8, 9);
            }
            movendo = true;
        }
        if(caminho == UP){
            this.y -= VELOCIDADE_TIRO;
            if(direcao != 4){
                setSequence(9, 10);
            }
            movendo = true;
        }
        if(caminho == DOWN || caminho == STOP){
            this.y += VELOCIDADE_TIRO;
            if(direcao != 5){
                setSequence(2, 3);
            }
            movendo = true;
        }
        if(movendo){
            update();
            movendo = false;
        }

    }
    
}