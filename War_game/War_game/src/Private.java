public class Private extends Soldier {

    public Private(){
        this.rank = 1;
    }

    public Soldier promote(){
        return new Corporal();
    }

}
