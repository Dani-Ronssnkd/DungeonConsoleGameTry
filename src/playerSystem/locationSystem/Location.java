package playerSystem.locationSystem;

import java.util.HashMap;
import java.util.Map;

public class Location{
    final String name;
    Map<Integer,Action> actions;
    public Location(String name){
        this.name=name;
        actions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Action> getActions() {
        return actions;
    }

    public void addAction(Action action){
        actions.put(actions.size()+1, action);
    }
    public String showActions(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Acciones: " + "\n\n");
        for (int i = 1; i <= actions.size(); i++) {
            stringBuilder.append(i + " -> " +  actions.get(i).name + "\n");
        }
        return stringBuilder.toString();
    }
}
