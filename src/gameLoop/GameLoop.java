package gameLoop;

import playerSystem.Player;
import playerSystem.locationSystem.InitializeAllLocations;
import static utils.TextUtils.*;
import java.util.Scanner;

public class GameLoop {
    Player player;
    InitializeAllLocations allLocations;
    final Scanner scanner = new Scanner(System.in);

    public GameLoop(Player player, InitializeAllLocations initializeAllLocations) {
        this.player = player;
        this.allLocations = initializeAllLocations;
    }

    String doubleEnd = "\n\n";

    public void finishPresentation() {
        printSlowly("A continuacion veras las acciones que puedes hacer en la aldea: " + doubleEnd +
                "Pero antes de eso vamos para alli..." + doubleEnd, delayNormalText);
        printSlowly("...\n", delayWait);
        waitTill();
        printSlowly("..." + doubleEnd, delayWait);
        askAction();
    }

    public void askAction() {
        while (true) {
            printSlowly(allLocations.getLocations().get(player.getCurrentLocation()).showActions() + '\n', delayNormalText);
            String entireResponse = respondAction();
            int numberResponse = entireResponse.charAt(0) - '0';
            if (numberResponse >= 1 && numberResponse <= allLocations.getLocations().get(player.getCurrentLocation()).getActions().size()) {
                allLocations.getLocations().get(player.getCurrentLocation()).getActions().get(numberResponse).getAction().execute();
            }
        }
    }
    private String respondAction(){
        String entireResponse = scanner.nextLine();
        while (entireResponse.isEmpty() || !isANumber(entireResponse.charAt(0))) {
            printSlowly("Escriba una accion válida" + doubleEnd, delayNormalText);
            entireResponse = scanner.nextLine();
        }
        return entireResponse;
    }
    private boolean isANumber(char c){
        return c > '0' && c <= '9';
    }
    public void waitTill(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
