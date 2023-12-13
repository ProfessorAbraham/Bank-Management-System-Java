import java.io.FileNotFoundException;
import java.io.IOException;

import Account.*;
import Customer.*;

public class BankingApplication {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		Registration obj2 = new Registration(Registration.name, Registration.pin);
		obj2.accountNumberGenerator();
		obj2.checkNewUser();
		
		BankAccount obj = new BankAccount();
		obj.showMenu();
		// Registration.createFile();

	}

}
