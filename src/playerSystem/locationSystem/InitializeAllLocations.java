package playerSystem.locationSystem;
import playerSystem.Player;
import static utils.TextUtils.*;
import java.util.HashMap;
import java.util.Map;

public class InitializeAllLocations {
    Map<String,Location> locations;
    Player player;
    final String nameAldea = "Aldea";
    final String nameCasa = "Casa";
    final String namePlaza = "Plaza";
    final String nameSendero = "Sendero";
    public InitializeAllLocations(Player player){
        locations=new HashMap<>();
        this.player = player;
    }
    public void inicializeAllLocations(){
        inicializeAldea();
        inicializeCasa();
        inicializePlaza();
    }

    public void inicializeAldea(){
        Location aldea = new Location(nameAldea);
        addLocation(aldea);
        newActionChangeLocation(nameAldea,"Ir a casa",nameCasa);
        newActionChangeLocation(nameAldea,"Hablar con alguien de la aldea",namePlaza);
        newActionChangeLocation(nameAldea,"Ir por el sendero",nameSendero);
        newActionShowStatistics(nameAldea);
    }
    public void inicializeCasa(){
        Location casa = new Location(nameCasa);
        addLocation(casa);
        newActionChangeLocation(nameCasa,"Salir a la aldea",nameAldea);
        newActionSleep(nameCasa,"Dormir");
        newActionShowStatistics(nameCasa);
        newActionLookWallet(nameCasa);
    }
    public void inicializePlaza(){
        Location plaza = new Location(namePlaza);
        addLocation(plaza);
        newActionChangeLocation(namePlaza,"Volver al centro de la aldea",nameAldea);
    }
    private void newActionChangeLocation(String actualLocation,String actionName, String newLocationName){
        locations.get(actualLocation).addAction(new Action(actionName, ()->{
            this.player.setCurrentLocation(newLocationName);
            printSlowly("Viajando a "+newLocationName+"..."+doubleEndl,delayNormalText);
        }));
    }
    private void newActionTalkWithNPC(String actualLocation,String actionName){

    }
    private void newActionSleep(String actualLocation,String actionName){
        locations.get(actualLocation).addAction(new Action(actionName,()->{
            if (!this.player.getCharacteristics().isTired()){
                printSlowly("No estás cansado" + doubleEndl,delayNormalText);
            }else {
                this.player.getCharacteristics().setTirednessFalse();
                printSlowly("Duermes y encuentras una moneda bajo la almohada +5 de oro!"+doubleEndl,delayNormalText);
                this.player.setGold(this.player.getGold()+5);
            }
        }));
    }
    private void newActionLookWallet(String actualLocation){
        locations.get(actualLocation).addAction(new Action("Mirar la cartera",()->{
            printSlowly("Cuentas con " + this.player.getGold() + " de ",delayNormalText);
            printSlowlyYellow("oro"+doubleEndl,delayNormalText);
        }));
    }
    private void newActionShowStatistics(String actualLocation){
        locations.get(actualLocation).addAction(new Action("Ver características",()->{
            printSlowly(player.getCharacteristics().toString()+doubleEndl,delayNormalText);
        }));
    }
    public void addLocation(Location location){
        locations.put(location.getName(), location);
    }
    public Map<String, Location> getLocations() {
        return locations;
    }
}
