import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class BasketTest {

    @Test
    public void testAddAndDelete() {
        Basket basket = new Basket();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        basket.deleteProduct(2);
        basket.deleteProduct(0);
        double result = basket.sum();

        assertEquals(920.00, result, 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIndexDeleteNoExist(){
        Basket basket = new Basket();
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.deleteProduct(2);
    }

    @Test
    public void testSum(){
        Basket basket = new Basket();
        basket.addProduct(new Product("1", "dryer", 100.00, 80.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("4", "TV", 1500.00, 1425.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.50));
        basket.addProduct(new Product("7", "electric_toothbrush", 150.00, 142.50));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        double result = basket.sum();

        assertEquals(3470.00, result, 0);

    }

    @Test
    public void testTheCheapest(){
        Basket basket = new Basket();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("4", "TV", 1500.00, 1425.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("7", "electric_toothbrush", 150.00, 142.50));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        double result = basket.theCheapest();

        assertEquals(100.00, result, 0);

    }

    @Test
    public void testTheMostExpensive(){
        Basket basket = new Basket();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("4", "TV", 1500.00, 1425.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("7", "electric_toothbrush", 150.00, 142.50));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        double result = basket.theMostExpensive();

        assertEquals(1500, result, 0);

    }
    @Test
    public void testIfDiscount5(){
        Basket basket = new Basket();
        Promotion discount5 = new Discount5();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        boolean result  = discount5.canExecute(basket);

        assertTrue(result);
    }

    @Test
    public void testDiscount5(){
        Basket basket = new Basket();
        Promotion discount5 = new Discount5();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        discount5.canExecute(basket);
        double result = discount5.execute(basket);

        assertEquals("You get 5% discount.",446.5, result, 0);
    }

    @Test
    public void testIfIsFreeCup(){
        Basket basket = new Basket();
        Promotion cup = new FreeCup();
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        boolean result = cup.canExecute(basket);

        assertTrue(result);
    }

    @Test
    public void testIfNotFreeCup(){
        Basket basket = new Basket();
        Promotion cup = new FreeCup();
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        boolean result = cup.canExecute(basket);

        assertFalse(result);
    }

    @Test
    public void testFreeCup(){
        Basket basket = new Basket();
        Promotion cup = new FreeCup();
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        cup.canExecute(basket);
        double result = cup.execute(basket);

        assertEquals("You get free cup.", 1, result,0);
    }


    @Test
    public  void testIfIsFreeProduct() {
        Basket basket = new Basket();
        Promotion free = new FreeProduct();
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        boolean result = free.canExecute(basket);

        assertTrue(result);

    }

    @Test
    public  void testIfFreeProduct() {
        Basket basket = new Basket();
        Promotion free = new FreeProduct();
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        boolean result = free.canExecute(basket);

        assertFalse("You don't get free product.", result);

    }

    @Test
    public void testFreeProduct(){
        Basket basket = new Basket();
        Promotion free = new FreeProduct();
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        free.canExecute(basket);
        double result = free.execute(basket);

        assertEquals("You get free product.", 600.00, result, 0);

    }

    @Test
    public void testIfDiscount30(){
        Basket basket = new Basket();
        Promotion discount30 = new Discount30();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        ((Discount30)discount30).chooseProduct(basket.basket[1]);
        boolean result = discount30.canExecute(basket);

        assertTrue(result);
    }

    @Test
    public void testIfNotDiscount30(){
        Basket basket = new Basket();
        Promotion discount30 = new Discount30();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        boolean result = discount30.canExecute(basket);

        assertFalse(result);
    }

    @Test
    public void testDiscount30(){
        Basket basket = new Basket();
        Promotion discount30 = new Discount30();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        ((Discount30)discount30).chooseProduct(basket.basket[1]);
        discount30.canExecute(basket);
        double result = discount30.execute(basket);

        assertEquals(910, result,0);
    }

    @Test
    public void testTwoDiscount30() {
        Basket basket = new Basket();
        Promotion discount30 = new Discount30();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        ((Discount30) discount30).chooseProduct(basket.basket[2]);
        ((Discount30) discount30).chooseProduct(basket.basket[1]);
        discount30.canExecute(basket);
        double result = discount30.execute(basket);

        assertEquals(910.00, result, 0);
    }

    @Test
    public void testAddDeleteAndSum(){
        Basket basket = new Basket();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.5));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        basket.deleteProduct(2);
        double result = basket.sum();


        assertEquals(1020, result, 0);
    }

    @Test
    public void testSortBasket(){
        Basket basket = new Basket();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("4", "TV", 1500.00, 1425.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 100.00, 95.00));
        basket.sortBasket();
    }


    @Test
    public void testNTheMostExpensive(){
        Basket basket = new Basket();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("4", "TV", 1500.00, 1425.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.50));
        basket.addProduct(new Product("7", "electric_toothbrush", 150.00, 142.50));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        basket.nTheMostExpensive(4);
    }

    @Test
    public void testNTheCheapest(){
        Basket basket = new Basket();
        basket.addProduct(new Product("1", "dryer", 100.00, 95.00));
        basket.addProduct(new Product("2", "phone", 800.00, 760.00));
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("4", "TV", 1500.00, 1425.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.50));
        basket.addProduct(new Product("7", "electric_toothbrush", 150.00, 142.50));
        basket.addProduct(new Product("8", "blender", 120.00, 114.00));
        basket.nTheCheapest(3);
    }

    @Test
    public void testApplyDiscount(){
        Basket basket = new Basket();
        basket.addProduct(new Product("3", "radio", 200.00, 190.00));
        basket.addProduct(new Product("4", "TV", 1500.00, 1425.00));
        basket.addProduct(new Product("5", "smart_watch", 350.00, 332.50));
        basket.addProduct(new Product("6", "headphones", 250.00, 237.50));
        ((Discount30)basket.promotionArray[0]).chooseProduct(basket.basket[1]);
        double result = basket.applyDiscount();

        assertEquals(1535.00, result, 0);


    }

}
