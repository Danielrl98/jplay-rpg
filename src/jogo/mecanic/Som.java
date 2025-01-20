package jogo.mecanic;

import jplay.Sound;

public class Som {
    private static Sound musica;

    public static void play(String caminhoArquivo) {
        musica = new Sound(caminhoArquivo);
        Som.musica.play();
        Som.musica.setVolume(-30f);
        Som.musica.setRepeat(true);
    }

    public static void stop() {
        if(Som.musica != null) {
            Som.musica.stop();
        }
    }
}
