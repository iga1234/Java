import org.junit.Test;

import java.rmi.NoSuchObjectException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class GameTests {

    @Test
    public void testArmyCreation(){
        Game game = new Game(
                General.Factory.create(1000, Army.Factory.create(5)),
                General.Factory.create(1000, Army.Factory.create(5))
        );
        assertNotNull(game.getGeneral1().getArmy().army[0]);
        assertNotNull(game.getGeneral1().getArmy().army[1]);
        assertNotNull(game.getGeneral1().getArmy().army[2]);
        assertNotNull(game.getGeneral1().getArmy().army[3]);
        assertNotNull(game.getGeneral1().getArmy().army[4]);
        assertNotNull(game.getGeneral2().getArmy().army[0]);
        assertNotNull(game.getGeneral2().getArmy().army[1]);
        assertNotNull(game.getGeneral2().getArmy().army[2]);
        assertNotNull(game.getGeneral2().getArmy().army[3]);
        assertNotNull(game.getGeneral2().getArmy().army[4]);
    }


    @Test
    public void testManeuvers() throws NoSuchObjectException {
        Game game = new Game(General.Factory.create(1000, Army.Factory.create(5)),
                General.Factory.create(1000, Army.Factory.create(5)));
        game.getGeneral1().maneuvers(new int[]{0, 2, 4});
    assertEquals(game.getGeneral1().getGold(), 997, 0);
    }

    @Test(expected = NoSuchObjectException.class)
    public void testManeuvers2() throws NoSuchObjectException {
        Game game = new Game(General.Factory.create(1000, Army.Factory.create(5)),
                General.Factory.create(1000, Army.Factory.create(5)));
        game.getGeneral1().maneuvers(new int[]{0, 2, 4, 6});
    }
    @Test
    public void testAttackDraw() throws NoSuchObjectException {
        Game game = new Game(General.Factory.create(100, Army.Factory.create(5)),
                General.Factory.create(100, Army.Factory.create(5)));

        int result = game.getGeneral2().getArmy().getExperience();
        assertEquals(game.getGeneral1().getArmy().getExperience(), game.getGeneral2().getArmy().getExperience(),0);
        game.getGeneral1().attack(game.getGeneral2(), 3, 2);

        assertEquals(game.getGeneral1().getGold(), game.getGeneral2().getGold(),0);
        assertNotEquals(game.getGeneral1().getArmy().getExperience(), result,0);
    }




    @Test(expected = NoSuchElementException.class)
    public void testAttack2() throws NoSuchObjectException {
        Game game = new Game(General.Factory.create(100, Army.Factory.create(5)),
                General.Factory.create(100, Army.Factory.create(5)));
        game.getGeneral1().attack(game.getGeneral2(), 17, 12);
    }


}
