import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        ATM LogIn = new ATM();
        if(LogIn.LogIn())
        {
            Menu();
            int Choice = input.nextInt();
            Process(Choice);

        }
        else
        {
            System.out.println("You have finished your tries, you are blocked!");
        }
    }
    public static void Menu()
    {
        System.out.println("**************************************");
        System.out.println("    Welcome to ATM program by Java     ");
        System.out.println("**************************************");
        System.out.println("    1- Check your balance.");
        System.out.println("    2- Deposit");
        System.out.println("    3- Withdraw");
        System.out.println("    4- Exit");
        System.out.println("Choose an option: ");
    }

    public static void Process(int Choice)
    {
        double Amount = 0.0;
        if (Choice == 2 || Choice == 3)
        {
            System.out.println("Please enter the amount: ");
            Amount = input.nextDouble();
        }
        Account MyAccout = new Account();
        switch(Choice)
        {
            case 1:
                System.out.println("Your Balance is " + MyAccout.GetBalance());
                break;
            case 2:
                MyAccout.SetDeposit(Amount);
                break;
            case 3:
                MyAccout.SetWithdrawal(Amount);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }
}


