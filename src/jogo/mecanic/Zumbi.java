package jogo.mecanic;

import jplay.Window;

public class Zumbi extends Ator {

    private double velocidade = 1;
    private int direcao = 3;
    private boolean movendo;
    private int life = 1000;

    public Zumbi(int x, int y){
        super("src/recursos/sprites/zumbi.png", 20);
        this.x  = x;
        this.y = y;
        this.setTotalDuration(2000);
        this.velocidade = 0.1;
        this.movendo = false;
    }

    public void perseguir(double x, double y){

        if(this.x > x && this.y <= y + 50 && this.y >= y -50){
            moveTo(x, y, velocidade);
            if(direcao != 1){
                setSequence(5, 6);
                direcao = 1;
            }
            this.movendo = true;
        }

        else if(this.x < x && this.y <= y + 50 && this.y >= y - 50){
            moveTo(x, y, velocidade);
            if(direcao != 2){
                setSequence(10, 11);
                direcao = 2;
            }
            this.movendo = true;
        }

        else if(this.y > y){
            moveTo(x, y, velocidade);
            if(direcao != 4){
                setSequence(15, 16);
                direcao = 4;
            }
            this.movendo = true;
        }

        else if(this.y < y){
            moveTo(x, y, velocidade);
            if(direcao != 5){
                setSequence(3, 4);
                direcao = 5;
            }
            this.movendo = true;
        }
      
        if(this.movendo){
            update();
            this.movendo = false;
        }
    }

    public void destroy(){
        this.x = 1000000;
    }

    public int perderVida(){
        this.life -= 250;

        if(this.life <= 0){
            this.destroy();
        }

        return this.life;
    }
}
