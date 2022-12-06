import java.util.Date;
import java.util.Calendar;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello %s, how are you?", name);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") > -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that";
        }
        else if(conversation.indexOf("Alfred") > -1){
            return "At your service. As you wish, naturally.";
        }
        else
            return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS

    // public String guestGreeting(String name, String dayPeriod){
    //     return String.format("Good %s %s, How are you?", dayPeriod, name);
    // }

    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!

    public String guestGreeting(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(calendar.HOUR_OF_DAY);

        if (hour > 4 && hour < 12){
            return "Good Morning, lovely to see you!!";
        }
        else if (hour >= 12 && hour < 16){
            return "Good afternoon, lovely to see you!!";
        }
        else if (hour >= 16 && hour < 21){
            return "Good evening, lovely to see you!!";
        }
        else{
            return "Good night, chatbot is not curruntly availble";
        }
    }
}
