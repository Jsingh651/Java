public class TestBank {
public static void main(String[] args) {
BankAccount account1 = new BankAccount();
BankAccount account2 = new BankAccount();
account1.deposit(200, "Checkings");
account1.deposit(1200, "Savings");
account2.deposit(122300, "Savings");
// account1.widthdraw(100, "Checkings");

// account1.widthdraw(1000, "Savings");
System.out.println("THIS IS USER 1\n");
System.out.println(account1.Accountnumber());
System.out.println(account1.total());
System.out.println(account1.deposit(200, "Savings"));
System.out.println(account1.deposit(1, "Checkings"));

System.out.println("THIS IS USER 2\n");
System.out.println(account2.Accountnumber());
System.out.println(account2.total());
System.out.println(account2.deposit(2100, "Savings"));
System.out.println(account2.deposit(10000, "Checkings"));
}
}
