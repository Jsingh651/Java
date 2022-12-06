public class Cafe {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffePrice = 4.5;
        double lattePrice = 5.5;
        double cappucinoPrice = 5.5;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting +  customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        System.out.println(pendingMessage+" "+customer1); // Displays "Welcome to Cafe Java, Cindhuri"

        if(isReadyOrder4 == false)
            System.out.println(pendingMessage+" "+customer4); // Displays "Welcome to Cafe Java, Cindhuri"
        else
            System.out.println(readyMessage+" "+customer4 + displayTotalMessage + cappucinoPrice); // Displays "Welcome to Cafe Java, Cindhuri"

        System.out.println(displayTotalMessage+ lattePrice*2 ); // Displays "Welcome to Cafe Java, Cindhuri"
        
        if (isReadyOrder2)
            System.out.println(readyMessage+" "+customer2); // Displays "Welcome to Cafe Java, Cindhuri"
        else
            System.out.println(pendingMessage+" "+customer2); // Displays "Welcome to Cafe Java, Cindhuri"

        System.out.println(customer3 + " you owe $" + ( lattePrice - dripCoffePrice)); // Displays "Welcome to Cafe Java, Cindhuri"

    }
}