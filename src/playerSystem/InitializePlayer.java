package playerSystem;

import utils.TextUtils;

import java.util.Scanner;

import static utils.TextUtils.*;


public class InitializePlayer {
    private final Scanner readFromUser = new Scanner(System.in);
    Player player;
    public InitializePlayer(){
        player = new Player(askForName());
    }

    public Player getPlayer() {
        return player;
    }

    public String askForName(){
        printSlowly("Hola viajero, Mi nombre es Dominic y soy el encargado de guiarte por estos lares\n" +
                "Pero antes de nada, ¿Como deberia referirme a ti? "+ doubleEndl,delayNormalText);
        String nombre = readString("Inserta tu nombre:"+ doubleEndl,"¿Estas segur@? (Si) (No) "+ doubleEndl);
        printSlowly("Encantado " + nombre + "! "+ doubleEndl,delayNormalText);
        return nombre;
    }
    public void showStatistics(){
        printSlowly("A continuacion te mostrare tus estadisticas: "+doubleEndl,delayNormalText);
        printSlowly(player.getCharacteristics().toString()+doubleEndl,delayNormalText);
    }
    public String readString(String msg,String comprobation){
        printSlowly(msg,delayNormalText);
        String name = readFromUser.nextLine();
        while (!yesOrNo(comprobation)){
            printSlowly(msg,delayNormalText);
            name = readFromUser.nextLine();
        }
        return name;
    }

    public boolean yesOrNo(String comp){
        printSlowly(comp,delayNormalText);
        String entry = readFromUser.nextLine();
        while (!(entry.equalsIgnoreCase("no"))&&!(entry.equalsIgnoreCase("si"))){
            printSlowly("Escriba solo (Si) o (No) " + comp,delayNormalText);
            entry = readFromUser.nextLine();
        }
        return entry.compareToIgnoreCase("si") == 0;
    }
}
