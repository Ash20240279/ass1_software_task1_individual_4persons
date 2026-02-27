public class Account
{
    private String PIN;
    private double Balance;

    public Account()
    {
        PIN = "1234";
        Balance = 1000.0;
    }
    /**
     **Constructor takes parameters unused in this simple program
    **/
    public Account(String PIN, double Balance)
    {
        this.PIN = PIN;
        this.Balance = Balance;
    }
    public double GetBalance()
    {
        return Balance;
    }

    public void SetDeposit (double Amount)
    {
        if (Amount < 0)
        {
            System.out.println("Amount is negative!, It is impossible!");
        }
        Balance += Amount;
        System.out.println("Now, Your balance is: " + Balance);
    }

    public void SetWithdrawal (double Amount)
    {
        if (Amount < 0)
        {
            System.out.println("Amount is negative!, It is impossible!");
        }
        if (Balance < Amount)
        {
            System.out.println("Insufficient Balance!");
        }
        else
        {
            Balance -= Amount;
            System.out.println("Now, Your balance is: " + Balance);
        }
    }
}
