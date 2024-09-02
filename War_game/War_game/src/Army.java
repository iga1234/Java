import java.util.NoSuchElementException;

public class Army {

    private Secretary secretary;

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    static class Factory {
        public static Army create(int privates) {
            Army army = new Army();
            for(int i = 0; i < privates; i++)
                army.addSoldier(new Private());
            return army;
        }
    }

    Soldier [] army = new Soldier[1000];
    private int i = 0;

    public void Army() {}


    public Soldier[] getArmy() {
        return army;
    }

    public int getStrenght(){
        int strenghtSum = 0;
        for(int i = 0; i < this.i; i++){
            strenghtSum = strenghtSum + army[i].getStrong();
        }
        return strenghtSum;
    }

    public int getExperience(){
        int experienceSum = 0;
        for(int i = 0; i < this.i; i++){
            experienceSum = experienceSum + army[i].getExperience();
        }
        return experienceSum;
    }

    public void incrementI(){
        this.i++;
    }

    public void addSoldier(Soldier soldier){
        army[i] = soldier;
        i++;
    }


    public void deleteSoldier(int x){
        if(army[x] == null) {
            throw new NoSuchElementException();
        }
        for(int i = x; i < this.i+1; i++){
            army[i] = army[i+1];
        }
        i--;
    }


    public void die() {
        for(i = 0; i < this.i; i++){
            if(army[i].getExperience() <= 0){
                secretary.log("Your soldier" + army[i].getRank() + "died");
                deleteSoldier(i);
            }
        }
    }

    public void promote(){
        for(int j = 0; j < this.i; j++){
            if(army[j].getExperience() >= 5 * army[j].getRank()){
                secretary.log("Soldier promoted from " + army[j].getRank() + " to " + army[j].promote().getRank());
                army[j] = army[j].promote();


            }
        }

    }
}
