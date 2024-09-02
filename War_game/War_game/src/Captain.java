public class Captain extends Soldier{

    public Captain(){
        this.rank = 3;
    }

    public Soldier promote(){
        return new Major();
    }
}
