public class FreeCup implements Promotion {

    public double sum;

    public boolean canExecute(Basket basket){
        sum = basket.sum();
        if (sum > 200.00) {
            return true;
        }
        return false;
    }
    public double execute(Basket basket){
        if (canExecute(basket)) {
            return 1;
        }
        return 0;
    }
}