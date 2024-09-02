import java.util.Comparator;


class PriceComparator implements Comparator<Product>{
    public int compare(Product a, Product b){
        return Double.compare(a.getPrice(), b.getPrice());
    }
}

class NameComparator implements Comparator<Product>{
    public int compare(Product a, Product b){
        return a.getName().compareToIgnoreCase(b.getName());
    }
}

class DefaultProductComparator implements Comparator<Product>{
    public int compare(Product a, Product b){
        if(a == null){
            return -1;
        }
        if(b == null){
            return 1;
        }
        int result = -Double.compare(a.getPrice(), b.getPrice());
        if (result != 0){
            return result;
        }
        return a.getName().compareToIgnoreCase(b.getName());
    }
}

public class Product {

        private String code;
        private String name;
        private double price;
        private double discountPrice;


        public Product(String code, String name, double price, double discountPrice){
            this.code = code;
            this.name = name;
            this.price = price;
            this.discountPrice = discountPrice;
        }


        public String getCode() {
            return code;
        }

        public void setCode(double price){
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(double price){
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price){
            this.price = price;
        }

        public double getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(double price){
            this.discountPrice = discountPrice;
        }


        public void printProduct(){
            System.out.println("code: " + code + " name: " + name + " price: "  + price + " discount price: " + discountPrice);

        }
}

