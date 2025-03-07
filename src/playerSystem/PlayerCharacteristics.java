package playerSystem;

import static utils.TextUtils.*;

public class PlayerCharacteristics {
    int maxMana;
    int health;
    int maxHealth;
    int mana;
    int strenth;
    boolean tiredness;
    int level;
    int xpNecessaryForNextLevel;
    int currentXp;
    public PlayerCharacteristics(){
        this.maxMana = 10;
        this.mana = 10;
        this.health=20;
        this.maxHealth=20;
        this.strenth=5;
        this.tiredness=false;
        this.level=1;
        this.xpNecessaryForNextLevel=20;
        this.currentXp=0;
        cycleTiredness();
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth += maxHealth;
    }

    public void setHealth(int health) {
        if (this.health+health>=maxHealth){
            this.health=maxHealth;
        }else {
            this.health=health;
        }
    }

    public void setMana(int mana) {
        if (this.mana+mana>=maxMana){
            this.mana=maxMana;
        }else {
            this.mana+=mana;
        }
    }

    public void setMaxMana(int maxMana) {
        this.maxMana+=maxMana;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getStrenth() {
        return strenth;
    }

    public void setStrenth(int strenth) {
        this.strenth += strenth;
    }

    public boolean isTired() {
        return tiredness;
    }

    public void cycleTiredness() {
        Thread tirednesstThread = new Thread(() -> {
            while (true) {
                    try {
                        synchronized (this) {
                            while (!tiredness) {
                                Thread.sleep(30000);
                                tiredness = true;
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
            }
        });
        tirednesstThread.setDaemon(true);
        tirednesstThread.start();
    }

    public void setTirednessFalse() {
        this.tiredness = false;
    }

    @Override
    public String toString() {
        String cansancio = tiredness ? "Cansado" : "Descansado";
        return  "[Nivel= "+level + " Siguiente nivel= "+currentXp+'/'+
                xpNecessaryForNextLevel+']' + doubleEndl +
                "Características: \n" +
                "[maxMana=" + maxMana + "]\n" +
                "[maxVida=" + maxHealth +"]\n" +
                "[fuerza=" + strenth +"]" + doubleEndl +
                "Estado: \n"+
                "[Cansancio= " + cansancio+']';
    }
}
