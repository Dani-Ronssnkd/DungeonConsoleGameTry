package musicSystem;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    public void playMusic(){
        Thread musicThread = new Thread(new Runnable(){

            @Override
            public void run() {
                runMusic();
            }
        });
        musicThread.start();
    }
    private void runMusic(){
        try{
            File musicFile1 = new File("src/resources/music/Secunda.wav");
            AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(musicFile1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream1);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println("Error al cargar o reproducir la música: " + e.getMessage());
        }
    }
}
