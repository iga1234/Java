import java.util.NoSuchElementException;

public class Basket {

        Product[] basket = new Product[1000];
        Promotion[] promotionArray = new Promotion[4];
        private int i = 0;
        private double min;
        private double max;
        private double sum = 0;
        private Product copy;
        public double discountSum;


        public Basket(){
            promotionArray[0] = new Discount30();
            promotionArray[1] = new FreeProduct();
            promotionArray[2] = new Discount5();
            promotionArray[3] = new FreeCup();
        }

        public int countProducts(){return i;}

        public double applyDiscount(){
            for(Promotion promotion: promotionArray){
                promotion.execute(this);
            }
            return sum() - discountSum;
        }


        public void addProduct(Product product) {
            basket[i] = product;
            i++;
        }

        public void deleteProduct(int x){
            if(basket[x] == null) {
                throw new NoSuchElementException();
            }
            for(int i = x; i < this.i+1; i++){
                basket[i] = basket[i+1];
            }
            i--;
        }

        public double theCheapest(){
            min = basket[0].getPrice();
            for(int i = 1; i < this.i;i++){
                if(min > basket[i].getPrice()){
                    min = basket[i].getPrice();
                }
            }
            return min;
        }

        public void nTheCheapest(int n) {
            sortBasket();
            for(int i = this.i; i > n; i --){
                deleteProduct(0);
            }
            this.i = n;
        }

        public double theMostExpensive(){
            max = basket[0].getPrice();
            for(int i = 1; i < this.i; i++){
                if(max< basket[i].getPrice()){
                    max = basket[i].getPrice();
                }
            }
            return max;
        }

        public void nTheMostExpensive(int n) {
            sortBasket();
            for(int i = n; i == this.i; i ++){
                deleteProduct(i+1);
            }
            this.i = n;
            }


        public double sum(){
            sum = 0;
            for(int i = 0; i < this.i; i++){
                sum = sum + basket[i].getPrice();
            }
            return sum;
        }

        public void showBasket() {
            sortBasket();
            for(int i = 0; i < this.i; i++)
               basket[i].printProduct();
        }



        public void sortBasket() {
            for(int j = 0; j < this.i; j++){
                for(int i = 0; i < this.i-1; i++) {
                    if (basket[i].getPrice() < basket[i + 1].getPrice()) {
                        copy = basket[i + 1];
                        basket[i + 1] = basket[i];
                        basket[i] = copy;
                    }
                    if (basket[i].getPrice() == basket[i + 1].getPrice()) {
                        if (basket[i].getName().compareTo(basket[i + 1].getName()) > 0) {
                            copy = basket[i + 1];
                            basket[i + 1] = basket[i];
                            basket[i] = copy;
                        }
                    }
                }

            }
        }


}



