public class Major extends Soldier{

    public Major(){
        this.rank = 4;
    }

    public Soldier promote(){
        this.setExperience(getExperience()+1);
        return this;
    }
}
