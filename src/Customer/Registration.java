package Customer;
//importing section
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Date;

import Account.BankAccount;
//super class registration
//Super class Registration
public class Registration {
    public boolean correctInput = false, ch, notLetter, pinn;
    public static boolean accountFound;
    public static boolean checkPin;
    public static String name, password, file, prevB;
    public static int pin, newPin;
    public static char c, a;
    public static int accountNumber;
    public boolean checkError = false;
    private static Date date;

    Scanner scanner = new Scanner(System.in);
    

    // Generates unique 7 digit account number for each new users
    
    public void accountNumberGenerator() {
        accountNumber = (int) (Math.random() * (9999999) + 1000000);
    }
    public static int getAccountnumber() {
        return accountNumber;
    }
    
    // Default Constructor
    public Registration(String userName, int userPassword) {
        name = userName;
        pin = userPassword;
    }
    // Overloading Constructor for new user
    public Registration(String userName, int userPassword, int confPassword) {

        name = userName;
        newPin = userPassword;
        pin = confPassword;
    }

    // A method that return the name of the user
    public static String getUserName() {
        return name;
    }

    void setPassword() throws IOException {
        
        System.out.println("Enter Your pin");
    }
    static int getPin() {
        return pin;
    }
    void setNewPassword() {
        System.out.print("Enter New pin: ");
    }
    static double getBalance() {
        return BankAccount.balance;
    }
    public static Date getDate() {
        date = new Date();
        return date;
    }

    // public class that use serialization
    public class customer implements java.io.Serializable {
        public String name;
        public char pin;
        public int accountNumber;
    }

    public class customerPin {

        public void setPassword(int intPass) {
            newPin = scanner.nextInt();
            newPin = intPass;
        }

        public boolean check() {
            // checks the input of the user
            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    ch = true;
                } else if (Character.isWhitespace(c)) {
                    ch = true;
                }

            }

            return ch;
        }

    }

    public static void createFile() throws IOException {

        try {
            // double balance = BankAccount.balance;
            date = new Date();
            String file = getUserName();
            FileWriter output = new FileWriter(file + ".txt", true);

            output.write("Name:-" + getUserName() + "\n");
            output.write("Account number:- 100" + getAccountnumber() + "\n");
            output.write(String.valueOf(pin));
            output.write("\n");
            output.close();

        } catch (IOException h) {

            System.out.println("\t\t Faild To Create File!!");
        }
    }

    public static void createDatabase() throws IOException {
        FileWriter data = new FileWriter("CustomerDatabase.txt", true);
        data.write("Name:-" + getUserName() + "\n");
        data.write("Account number:- 100" + getAccountnumber() + "\n");
        data.write("Date:-" + getDate());
        data.write("\n");
        data.close();
    }

    public static void searchFile(String s) {

        try {

            String file = getUserName();
            password = Files.readAllLines(Paths.get(file + ".txt")).get(2);
            

            if (Integer.valueOf(password) == pin) {
                accountFound = true;
                // System.out.print(prevB);
            } else {
                checkPin = false;
                System.out
                        .print("INcorrect pin or username. \nPlease check your user name or password and try again!!");
                System.exit(0);
            }

        } catch (IOException i) {

            System.out.println("\t\t File Not Found!!!");
            BankAccount.error();
        }

    }

    public static void deleteRecord(String delete) {

        File f = new File("C:\\Users\\DELL.DESKTOP-QSOJ7KD\\Desktop\\Bank-Managment_Group2\\" + delete + ".txt");

        if (f.delete()) {
            System.out.println("\t\t file deleted Successfully. ");
        } else {
            System.out.println("\t\t Failed to delete the file !!");
        }
    }
    public static String getPrevBalance() throws IOException, NumberFormatException{
        String file = getUserName();
        prevB = Files.readAllLines(Paths.get(file + ".txt")).get(3);
        System.out.print(prevB);
        return prevB;
    }
    // checks if the user has an account before
    public void checkNewUser() throws IOException, FileNotFoundException, ClassNotFoundException {
        try {

            Registration cus = new Registration(name, pin);
            customerPin check = new customerPin();
            for (; !correctInput;) {
                // getPrevBalance();
                System.out.println(
                        "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                System.out.println("WELCOME!!");
                System.out.println("Do You Have an Account? (y/n) ");
                System.out.println(
                        "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                c = scanner.next().charAt(0);
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);

                }
                correctInput = (c == 'y') || (c == 'n');

                if (c == 'y') {

                    System.out.println(
                            "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                    System.out.println("Login ");
                    System.out.println(
                            "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*= \n");

                    do {
                        
                        System.out.println("Enter Your Name");
                        name = scanner.next();
                        notLetter = check.check();
                        if (notLetter) {
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                            System.out.println("*           !!! Please Enter only Alphabet letter         \t  *");
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                        }
                        ch = false;
                    } while (notLetter);

                    cus.setPassword();
                    pin = scanner.nextInt();
                    searchFile(name);
                    getPrevBalance();

                } else if (c == 'n') {
                    System.out.println(
                            "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                    System.out.println("SingUp ");
                    do {
                        System.out.println("Enter Your Name");
                        name = scanner.next();

                        notLetter = check.check();
                        if (notLetter) {
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                            System.out.println("*           !!! Please Enter only Alphabet letter         \t  *");
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                        }
                        ch = false;
                    } while (notLetter);
                    do {
                        cus.setNewPassword();
                        newPin = scanner.nextInt();
                        cus.setPassword();
                        pin = scanner.nextInt();
                        pinn = newPin == pin;
                        if (pinn) {
                        } else {
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                            System.out.println("*           !!! Please Enter the same pin        \t  *");
                            System.out.println(
                                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                        }
                    } while (!pinn);
                    createFile();
                } else {
                    System.out.println("Please Enter only 'y' Or 'n' ");
                }
            }

        } catch (Exception e) {
            System.out.println(e + "Something went wrong!");
            System.exit(0);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Show Customer Database");
        System.out.println("2.Remove Customer from Database \n");
        System.out.println("Enter your choice:");

        int choice = sc.nextInt();
        if (choice == 1) {
            try {
                FileReader fr = new FileReader("CustomerDatabase.txt");
                int i;
                while ((i = fr.read()) != -1)
                    System.out.print((char) i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else if (choice == 2) {
            System.out.print("Enter the filename you want to delete: ");
            file = sc.next();
            deleteRecord(file);
        }
    }

}
