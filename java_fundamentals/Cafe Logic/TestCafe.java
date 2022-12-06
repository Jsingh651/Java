import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        
        CafeUtil appTest = new CafeUtil();


        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        // System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(20));
        String streak = appTest.getStreakGoal(20);
        System.out.println(streak);
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);




    
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 2; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

    
    System.out.println("----- Price Chart Test-----");
    appTest.printPriceChart("Chai Latte Mix",2, 10);
    // appTest.printPriceChart("Specialty Coaster", 2.0, 5);



    System.out.println("----- OVERLOAD TEST-----");
        ArrayList<String> menuItems = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();
        menuItems.add("Burger");
        menuItems.add("Pizza");
        prices.add(4.00);
        prices.add(2.00);
        prices.add(1.00);
        appTest.displayMenu(menuItems, prices);
    }

}