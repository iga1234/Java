import org.junit.Test;

import java.rmi.NoSuchObjectException;

import static org.junit.Assert.*;

public class ArmyTests {

    @Test
    public void testPromote(){
        Army army = Army.Factory.create(2);
        army.setSecretary(new Secretary());
        army.getArmy()[0].setExperience(5);
        army.promote();

        assertEquals(army.getArmy()[0], new Corporal());


    }




}
