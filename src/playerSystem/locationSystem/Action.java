package playerSystem.locationSystem;

public class Action{
    String name;
    ActionSystem actionSystem;
    public Action (String name,ActionSystem action){
        this.name=name;
        this.actionSystem=action;
    }

    public ActionSystem getAction() {
        return actionSystem;
    }
}
