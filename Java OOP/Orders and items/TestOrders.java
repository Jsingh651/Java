import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        

        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 3.25;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 4.25;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 5.25;

        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 6.25;

        // ORDERS

        Orders order1 = new Orders();
        order1.name = "Cindhuri";
        order1.ready = true;

        Orders order2 = new Orders();
        System.out.println(order2.total);
        order2.name = "Jimmy";
        order2.ready = true;


        Orders order3 = new Orders();
        order3.name = "Noah";

        Orders order4 = new Orders();
        order4.name = "Sam";

        

// Add item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
        order2.total += item1.price;

        order3.items.add(item4);
        order3.total += item4.price;

        order4.items.add(item2);
        order4.total += item2.price*3;

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}

