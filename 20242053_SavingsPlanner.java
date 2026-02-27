//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;
 class Goal {
    private String goalName;
    private double targetAmount;
    private int numberOfAvailableMonths;
    public Goal(String name, double target, int months) {
        goalName = name;
        targetAmount = target;
        numberOfAvailableMonths = months;
    }

    public String getName() {
        return goalName;
    }

    public double getTarget() {
        return targetAmount;
    }

    public double calculateMonthlySaving() {
        if (numberOfAvailableMonths == 0) {
            return 0;
        }
        return targetAmount / numberOfAvailableMonths;
    }
}
 class SavingsPlanner {

    private ArrayList<Goal> goals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addGoal() {

        scanner.nextLine();

        System.out.println("Enter Goal Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Target Amount:");
        double target = scanner.nextDouble();

        System.out.println("Enter Available Months:");
        int months = scanner.nextInt();

        Goal goal = new Goal(name, target, months);
        goals.add(goal);

        System.out.println("Goal Added Successfully!!");
    }

    public void showGoals() {

        if (goals.isEmpty()) {
            System.out.println("No Goals Yet");
        } else {
            for (Goal g : goals) {
                System.out.println("---------------");
                System.out.println("Name: " + g.getName());
                System.out.println("Target: " + g.getTarget());
                System.out.println("Monthly Saving: " + g.calculateMonthlySaving());
            }
        }
    }

    public void Menu() {

        int choice;

        do {
            System.out.println("Enter Your Choice:");
            System.out.println("1. Add Goal");
            System.out.println("2. Show All Goals");
            System.out.println("3. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addGoal();
                    break;
                case 2:
                    showGoals();
                    break;
                case 3:
                    System.out.println("I hope to achieve all your goals inshaallah...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);
    }
}
public class Main {

    public static void main(String[] args) {

        SavingsPlanner planner = new SavingsPlanner();
        planner.Menu();

    }
}