import java.util.Random;

public class BankAccount {

private double checkingBalance;
private double savingBalance;
public int accountNumber;
public static int numOfAccounts;

public String Accountnumber(){
Random random = new Random();
long accountnum = random.nextInt(89999999) + 10000000;
return String.format("Your account number is %s",accountnum);
}
public BankAccount(){
    numOfAccounts++;
}
// Create a method to see the total money from the checking and saving.

public String total(){
    double totalBalance = 0.0;
    totalBalance = this.checkingBalance + this.savingBalance;
    return String.format("Your total balance is %.2f", totalBalance);
}

public String deposit(double money, String Accountype) {
    double newBalance = 0.0;
	if (Accountype == "Checkings") {
		checkingBalance += money;
        newBalance = checkingBalance;
	}
	else if(Accountype == "Savings") {
		savingBalance += money;
        newBalance = savingBalance;
	}
    return String.format("Your new balance for %s account is %.2f", Accountype, newBalance);
}

public String widthdraw(double money, String Accountype) {
    double newBalance = 0.0;
	if (Accountype == "Checkings" ){
        if (checkingBalance >= money){
		checkingBalance -= money;
            newBalance = checkingBalance;
        }
        else{
            System.out.printf("You don't have enough money in your checkings account");
        }
	}
    if(Accountype == "Savings"){
        if(savingBalance >= money){
		savingBalance -= money;
            newBalance = savingBalance;
        }
            else{
                System.out.println("You don't have enough money in your savings account");
            }
    }
    return String.format("Your new balance for %s account is %.2f", Accountype, newBalance);

}








public double getCheckingBalance() {
	return checkingBalance;
}

public void setCheckingBalance(int checkingBalance) {
	this.checkingBalance = checkingBalance;
}

public double getSavingBalance() {
	return savingBalance;
}

public void setSavingBalance(int savingBalance) {
	this.savingBalance = savingBalance;
}
}


