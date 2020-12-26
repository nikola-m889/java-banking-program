
import java.util.Scanner;

public class Bank_Account {
	
	private int defaultLength=10;
	private int balance;
	private int Transaction;
	private String name;
	private String lastname;
	private String password;
	private String customerName;
	private String customerID;
	
	
	Bank_Account(String cname, String pin) {
		customerName=cname;
		customerID=pin;
	}
	
	private String changePin(int length) {
		String newPasswordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int rand=(int) (Math.random()*newPasswordSet.length());
			password[i]=newPasswordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void payBills() {
		System.out.println("Your balance: "+balance);
		System.out.println("Enter your payment: ");
		Scanner in=new Scanner(System.in);
		int billPayment = in.nextInt();
		if(balance>=billPayment) {
			balance=balance-billPayment;
			System.out.println("Thank you for payment of "+billPayment);
			System.out.println("Your balance: "+balance);
		}else {
			System.out.println("Sorry, not enough money in account");
		}
	}
	
	void deposit(int amount) {
		if(amount!=0) {
			balance=balance+amount;
			Transaction=amount;
		} else if(amount==0 || amount < 0) {
			System.out.println("Deposit must be above zero");
		}
	}
	
	void withdraw(int amount) {
		if(amount<balance) {
			balance=balance-amount;
			Transaction=-amount;
		}else if(amount>balance) {
			System.out.println("Not enough balance in account");
		}else if(amount==0){
			System.out.println("Entered amount must be above zero");
		}
	}
	
	void getPreviousTransaction() {
		if(Transaction > 0) {
			System.out.println("Deposited: "+Transaction);
		}else if(Transaction < 0) {
			System.out.println("Withdraw: "+(Transaction));
		}else {
			System.out.println("No transaction occured");
		}
	}
	
	void calculateInterest(int years) {
		double interest=.0138;
		double newBalance=(balance*interest*years)+balance;
		System.out.println("The current interest rate is "+(100*interest));
		System.out.println("After "+years+"years, your balance will be "+newBalance);
	}
	
	void showMenu() {
		char option='\0';
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome, "+customerName + "!");
		System.out.println("Your ID is "+customerID);
		System.out.println();
		System.out.println("Chose your option:");
		System.out.println();
		System.out.println("1. Make a deposit");
		System.out.println("2. Make a withdrawal");
		System.out.println("3. Check balance");
		System.out.println("4. View previous transaction");
		System.out.println("5. Calculate interest");
		System.out.println("6. Pay your bills");
		System.out.println("7. Reset your pin:");
		System.out.println("Z. exit");
		
		do {
			
			System.out.println();
			System.out.println("Enter your option: ");;
			char option1=scanner.next().charAt(0);
			option=Character.toUpperCase((option1));
			System.out.println();
			
			switch(option) {
			case '1':
				System.out.println("Enter your amount for deposit: ");
				int amount=scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case '2':
				System.out.println("Enter your amount to withdraw: ");
				int amount2=scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			case '3':
				System.out.println("Check your balance");
				System.out.println("balance: "+balance);
				System.out.println();
				break;
			case '4':
				getPreviousTransaction();
				System.out.println();
				break;
			case '5':
				System.out.println("Enter how many years of accured interest: ");
				int years=scanner.nextInt();
				calculateInterest(years);
				break;
			case '6':
				payBills();
				break;	
			case '7':
				System.out.println("Your new PIN will be provided to you: ");
				this.password=changePin(defaultLength);
				System.out.println("Your new PIN is: "+password);
				break;			
			case 'Z':
				break;
			default:
				System.out.println("Please enter number from 1-7");
				break;
			}
			
		}while(option!='Z');
		
		System.out.println("Thank you for using our services");
		
	}
	
	
	
}
