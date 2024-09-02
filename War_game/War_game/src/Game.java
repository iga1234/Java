import java.util.ArrayList;
import java.util.List;

public class Game {


    public Game(General general1, General general2){
        this.general1 = general1;
        this.general2 = general2;
        Secretary secretary = new Secretary();
        this.general1.setSecretary(secretary);
        this.general2.setSecretary(secretary);
    }

    public General getGeneral1() {
        return general1;
    }

    public General getGeneral2() {
        return general2;
    }

    private General general1;
    private General general2;
}
