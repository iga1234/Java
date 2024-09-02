import org.junit.Test;

public class GeneralTests {

    @Test
    public void testBuySoldier(){
        Army army = Army.Factory.create(5);
        General general = General.Factory.create(100, army);
        Soldier soldier = new Major();
        general.buySoldier(soldier);

    }
}
