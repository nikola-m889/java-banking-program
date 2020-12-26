
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner info=new Scanner(System.in);
		System.out.println("Please enter your name:");
		String name=info.next();
		System.out.println("Please enter your PIN:");
		String id=info.next();
	
		Bank_Account acc=new Bank_Account(name,id);
		acc.showMenu();
			
			
		}
	}