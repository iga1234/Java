import java.rmi.NoSuchObjectException;
import java.util.NoSuchElementException;

public class General {

    Army army;
    private double gold;
    private Secretary secretary;

    private General(int gold, Army army){
        this.gold = gold;
        this.army = army;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public double getGold(){return gold;}



    public void setGold(double gold){this.gold = gold;}

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
        this.getArmy().setSecretary(secretary);
    }

    static class Factory {
        public static General create(int gold, Army army) {
            return new General(gold, army);
        }
    }

    public void maneuvers(int soldiers[]) throws NoSuchObjectException {
        secretary.log("Maneuvers started");
        for(int i = 0; i < soldiers.length; i++){
            int pickedSoldierIndex = soldiers[i];
            Soldier pickedSoldier = this.army.getArmy()[pickedSoldierIndex];
            if(pickedSoldier == null){
                throw new NoSuchObjectException("No such soldier");
            }
            if(pickedSoldier.getRank() <= gold) {
                pickedSoldier.setExperience(pickedSoldier.getExperience() + 1);
                gold = gold - pickedSoldier.getRank();
            }
        }
        secretary.log("Maneuvers finished");
        getArmy().promote();
    }

    public void fight(General general) throws NoSuchElementException{
        this.gold = this.gold + general.gold * 0.1;
        general.setGold(general.getGold() * 0.9);
        secretary.log("Winner get 10% of gold from second player");
        for (Soldier soldier: this.getArmy().getArmy()) {
            if (soldier == null) {
                break;
            }

            secretary.log("Your all soldiers get experience");
            soldier.setExperience(soldier.getExperience() + 1);

        }
        for (Soldier soldier: general.getArmy().getArmy()) {
            if(soldier == null){
                break;
            }

            secretary.log("Your all soldiers lost experience");
            soldier.setExperience(soldier.getExperience() - 1);

        }
        getArmy().promote();
        getArmy().die();
    }

    public void attack(General general, int executeIndex, int executeIndex2){
        secretary.log("Attacked started");
        if(this.getArmy().getStrenght() > general.getArmy().getStrenght()){
            secretary.log("First general won");
            this.fight(general);
        }
        else if(this.getArmy().getStrenght() == general.getArmy().getStrenght()){
            secretary.log("Draw");
            this.getArmy().deleteSoldier(executeIndex);
            general.getArmy().deleteSoldier(executeIndex2);
        }
        else{
            secretary.log("Second general won");
            general.fight(this);
        }

    }
    public void buySoldier(Soldier soldier) {
        if (this.getGold() >= soldier.getRank() * 10) {
            this.setGold(this.getGold() - soldier.getRank() * 10);
            for (int i = 0; i < this.getArmy().getArmy().length; i++) {
                if (this.getArmy().getArmy()[i] == null) {
                    this.getArmy().getArmy()[i] = soldier;
                    break;
                }
                this.getArmy().incrementI();
            }
        }
        else{
            throw new IllegalStateException();
        }
    }

}
