public interface Promotion {

    boolean canExecute(Basket basket);
    double execute(Basket basket);

}
