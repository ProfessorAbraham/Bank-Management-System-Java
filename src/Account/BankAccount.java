package Account;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Customer.*;

interface Account {
	public void BankAccount();

	public void setDeposite();

	public void withdraw();

	public void getPreviousTransaction();

	public void showMenu() throws IOException;

}

public class BankAccount implements Account {
	public static double balance, prevBalance;
	public static int amount;
	public double amount3;
	public int accnum;
	public double previousTransaction;
	public String customerName = Registration.name;
	public boolean checkWhiteSpace = true, success = true;
	private static Date date;
	static String file = Registration.getUserName();
	static Path path = Paths.get(file + ".txt");
	
	
	


	Scanner scanner = new Scanner(System.in);

	public class UserAccount extends Registration {

		public UserAccount(String userName, char userPassword) {
			super(userName, userPassword);
			name = userName;

		}

		public void setUserName() {
			System.out.println("Welcome " + name);
		}

		public void setAccountnumber() {
			System.out.println("Your Account Number Is 100" + Registration.accountNumber);
		}

	}

	public void setDeposite(int amount) throws IOException {
		
		if (amount != 0 && amount > 0) {
			balance = prevBalance+ balance + amount;
			previousTransaction = amount;
		} else {
			System.out.println("Invalid amount!");
			error();
		}
	}

	public void withdraw(Double amount2) throws IOException {
		
		if (amount2 != 0 && balance > amount2) {
			balance = prevBalance + balance - amount2;
			previousTransaction = -amount2;
		} else if (amount3 != 0 && prevBalance > amount3) {
			balance = prevBalance + balance - amount2;
			previousTransaction = -amount2;
		} else {
			System.out.println("Sorry you don't have enough money!");
			error();
		}
	}

	public void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		}

		else {
			System.out.println("No Transaction Occured");
		}
	}

	public void getRecipet() {
		System.out.println(
				"\t\t\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("\t\t\t*\tUser Name: " + customerName);
		System.out.println("\t\t\t*\tAccount Number: 100" + Registration.accountNumber);
		System.out.print("\t\t\t*\t");
		getPreviousTransaction();
		System.out.println("\t\t\t*\tBalance: " + balance);

		System.out.println(
				"\t\t\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
	}

	public void getTransferReceipt() {

		date = new Date();
		System.out.println(
				"\t\t\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("\t\t\t*\tFrom Acount: 100" + Registration.accountNumber);
		System.out.println("\t\t\t*\tTo Acount: " + accnum);
		System.out.println("\t\t\t*\tAmount: " + amount3);
		System.out.println("\t\t\t*\tDATE: " + date);
		System.out.println("\t\t\t*\tYou Transfered Successfully!!!");
		System.out.println(
				"\t\t\t=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");

	}

	public void conf() throws IOException {
		System.out.println("Do you want to continue?(y/n) ");
		char ans = scanner.next().charAt(0);
		if (Character.isUpperCase(ans)) {
			ans = Character.toLowerCase(ans);

		}
		if (ans == 'y') {

		} else if (ans == 'n') {
			if (Registration.accountFound) {

				setVariable(4, balance + prevBalance);
			} else {
				createFile();
			}
			error();
			Registration.createDatabase();
		} else {
			System.out.println("Invalid Input!");
			error();
		}

	}

	public static void error() {
		System.out.println(
				"=========================================================================================================");
		System.out.println("Thank You for Using our Services.....!!");
		System.exit(0);
	}

	public void showMenu() throws IOException {
		char option = '\0';

		System.out.println(
				"=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*= \n");

		UserAccount num = new UserAccount(customerName, option);
		num.setUserName();
		num.setAccountnumber();
		System.out.println("\n");

		do {
			System.out.println("A : Check Your Balance");
			System.out.println("B : Deposit");
			System.out.println("C : Withdraw");
			System.out.println("D : Send Money");
			System.out.println("E : Previous Transaction");
			System.out.println("F : Exit The System");

			System.out.println(
					"=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			System.out.println("Enter Your Option");
			System.out.println(
					"=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
			option = scanner.next().charAt(0);
			if (Character.isLowerCase(option)) {
				option = Character.toUpperCase(option);

			}
			System.out.println("\n");
			try {
				switch (option) {

					case 'A':

						System.out.println("-------------------------------------------------------");
						System.out.println("Your Balance is " + balance);
						System.out.println("-------------------------------------------------------");
						System.out.println("\n");
						conf();
						break;

					case 'B':

						System.out.println("-------------------------------------------------------");
						System.out.println("Enter an amount to deposit ");
						System.out.println("-------------------------------------------------------");

						amount = scanner.nextInt();
						if (Character.isWhitespace(amount)) {
							System.out.print("Invalid Input");
							checkWhiteSpace = false;
						}
						setDeposite(amount);

						getRecipet();
						System.out.println(" \t\t\t\t DONE!, Successfully Deposited");
						System.out.println("-------------------------------------------------------");

						conf();
						break;

					case 'C':
						System.out.println("-------------------------------------------------------");
						System.out.println("Enter an amount to withdraw ");
						System.out.println("-------------------------------------------------------");

						Double amount2 = (double) scanner.nextInt();
						withdraw(amount2);
						System.out.println("\n");
						conf();
						break;

					case 'D':
						System.out.println("-------------------------------------------------------");
						System.out.println("Enter account number of the receiver ");
						System.out.println("-------------------------------------------------------\n");
						accnum = scanner.nextInt();

						System.out.println("-------------------------------------------------------");
						System.out.println("Enter an amount ");
						System.out.println("-------------------------------------------------------");
						amount3 = scanner.nextInt();
						withdraw(amount3);
						System.out.println("\n");
						getTransferReceipt();
						System.out.println("\n");

						conf();

						break;

					case 'E':
						System.out.println("-------------------------------------------------------");
						getPreviousTransaction();
						System.out.println("-------------------------------------------------------");
						System.out.println("\n");
						conf();
						break;

					case 'F':
						System.out.println(
								"=========================================================================================================");
						error();
						break;

					default:
						System.out.println("Invalid Option!! Please Enter Correct Option...");
						System.out.println("-------------------------------------------------------");
						break;
				}
			} catch (Exception e) {
				System.out.println(e + "Someting went Wrong!! \nPlease try again");
				error();
			}

		} while (option != 'F');
		System.out.println("Thank You for Using our Services.....!!");

	}

	public static double getBalance() {
		return balance;
	}

	@Override
	public void BankAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDeposite() {
		// TODO Auto-generated method stub

	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub

	}

	public static void createFile() throws IOException {

		try {
			date = new Date();
			String file = Registration.getUserName();
			FileWriter output = new FileWriter(file + ".txt", true);
			output.write("Balance: " + BankAccount.getBalance() + "\n");
			output.write("Date:-" + date + "\n");
			output.write("\n");
			output.close();

		} catch (IOException h) {

			System.out.println("\t\t Faild To Create File!!");
		}
	}

	public static void setVariable(int lineNumber, Double data) throws IOException {
		List<String> lines = Files.readAllLines(path);
		lines.set(lineNumber - 1, String.valueOf(data));
		Files.write(path, lines);
	}

}
