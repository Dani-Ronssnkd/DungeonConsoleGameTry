package playerSystem;

public class Player {
    String name;
    String currentLocation;
    PlayerCharacteristics characteristics;
    int gold;


    public Player(String name){
        this.name=name;
        this.characteristics=new PlayerCharacteristics();
        this.gold=100;
        currentLocation = "Aldea";
    }

    public String getName() {
        return name;
    }

    public PlayerCharacteristics getCharacteristics() {
        return characteristics;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public int getGold() {
        return gold;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}