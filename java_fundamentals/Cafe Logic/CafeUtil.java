import java.util.ArrayList;

public class CafeUtil {
    public String getStreakGoal(int numWeeks){
        int sum = 0;
        for (int i = 0; i <= numWeeks ; i++ ){
            sum += i;
        }
        return String.format("Purchases needed by week %s would be %s",numWeeks, sum);
    }

    public double getOrderTotal(double[] prices){
        double total = 0;

        for (int i = 0;i < prices.length; i++ ){
            total += prices[i];
        }
        return total;
    }
    public void displayMenu(ArrayList<String> menu){

        for (int i = 0; i < menu.size(); i++){
            System.out.printf("%s %s \n", i , menu.get(i));  
        }
    }
    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name");
        String userName = System.console().readLine();
        System.out.println(String.format("Hello, %s", userName));
        customers.add(userName);
        System.out.println (String.format("There are %s people in front of you",(customers.size ()-1)));
        // System.out.println(customers);



}
public void printPriceChart(String product, double price, int maxQuantity){
    double total = 0;
    double sum = 0;
    double discount = 0;
    System.out.printf("%s \n", product);
    for (int i = 1; i <= maxQuantity; i++ ){
        sum += price;
        if (i > 1){
            discount += .5;
            total = sum - discount;
        }
        else{
            total = sum;
        }
            System.out.printf("%s - $%.2f \n", i, total);
        }
    }

public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
    if (menuItems.size() != prices.size()){
    return false;
    };
    for (int i = 0; i < menuItems.size(); i++ ){
        System.out.printf("%s %s -- $%.2f \n",i, menuItems.get(i), prices.get(i));
    }
    return true;
}
}
