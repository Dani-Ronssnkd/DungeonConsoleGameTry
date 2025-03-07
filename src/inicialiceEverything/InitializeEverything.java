package inicialiceEverything;

import gameLoop.GameLoop;
import musicSystem.Music;
import playerSystem.InitializePlayer;
import playerSystem.locationSystem.InitializeAllLocations;

public class InitializeEverything {
    public void inicializeEverything() {
        //inicializar musica
        Music music = new Music();
        music.playMusic();
        //inicializar jugador
        InitializePlayer initializePlayer = new InitializePlayer();
        //inicializar localizaciones
        InitializeAllLocations initializeAllLocations = new InitializeAllLocations(initializePlayer.getPlayer());
        initializeAllLocations.inicializeAllLocations();
        //seguir con la presentacion
        initializePlayer.showStatistics();
        //iniciar gameLoop
        GameLoop gameLoop = new GameLoop(initializePlayer.getPlayer(), initializeAllLocations);
        gameLoop.finishPresentation();
    }
}

