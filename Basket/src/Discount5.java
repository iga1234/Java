public class Discount5 implements Promotion {

    private double sum;
    private double discount;

    public boolean canExecute(Basket basket) {
        sum = basket.sum();
        if (sum > 300.00) {
            return true;
        }
        return false;
    }

    public double execute(Basket basket) {
        if (canExecute(basket)) {
            discount = sum * 0.05;
            basket.discountSum += discount;
            return sum - discount;
        }
        return sum;
    }
}

