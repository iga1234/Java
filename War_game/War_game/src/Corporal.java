public class Corporal extends Soldier{

    public Corporal(){
        this.rank = 2;
    }

    public Soldier promote(){
        return new Captain();
    }
}
