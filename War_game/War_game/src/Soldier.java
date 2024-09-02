import java.util.Objects;

public abstract class Soldier {

    protected int rank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier soldier = (Soldier) o;
        return rank == soldier.rank && experience == soldier.experience;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, experience);
    }

    private int experience;

    public Soldier(){
        this.experience = 1;
    }

    public Soldier(int rank, int experience){
        this.rank = rank;
        this.experience = experience;
    }

    public int getRank(){return rank;}

    public void setRank(int rank){this.rank = rank;}

    public int getExperience(){return experience;}

    public void setExperience(int experience){this.experience = experience;}

    public int getStrong(){return rank * experience;}

    abstract Soldier promote();
}
