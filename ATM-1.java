import java.util.Scanner;

public class ATM
{
    String ReadPIN()
    {
        String PIN = "";
        System.out.println("Please enter PIN code:");
        Scanner input = new Scanner(System.in);
        PIN = input.nextLine();

        return PIN;
    }

    boolean LogIn()
    {
        String PINCode;
        int Counter = 3;
        do
        {
            PINCode = ReadPIN();
            Counter--;
            if (PINCode.equals("1234"))
                return true;
            else
            {
                System.out.println("Wrong PIN!, you have " + Counter + " more Tries!");
//                System("color 4F");
            }
        } while (!(PINCode.equals("1234")) && Counter >= 1);

        return false;
    }

}

