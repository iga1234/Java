public class Discount30 implements Promotion {

    private double discount;
    private double newPrice = 0;
    private double free = 0;
    private double sum = 0;
    private int i = 0;
    private boolean flag = false;
    private Product product;


    public boolean canExecute(Basket basket) {
            return flag;
    }
    public void chooseProduct(Product product){
        this.product = product;
        flag = true;
    }

    public double execute(Basket basket) {
        sum = basket.sum();
        if (canExecute(basket)) {
            discount = product.getPrice() * 0.3;
            basket.discountSum += discount;
            newPrice = sum - discount;
            return (newPrice);
        }
        return sum;
    }
}


