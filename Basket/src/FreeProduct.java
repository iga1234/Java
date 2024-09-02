public class FreeProduct implements Promotion {


    private double sum;
    private int n, i;
    private double free;

    public boolean canExecute(Basket basket) {
        n = basket.countProducts();
        if(n >= 3){
            return true;
        }
        return false;
    }

        public double execute(Basket basket){
            sum = basket.sum();
            if (canExecute(basket)) {
                free = basket.theCheapest();
                basket.discountSum += free;
                return (sum - free);
            }
            return sum;
    }
}