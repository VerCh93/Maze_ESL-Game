import java.util.Scanner;

public class FinalTask implements ITask {
    @Override
    public String welcome() { //welcome message, overridden for different final task welcome
        return "\nCONGRATULATIONS! YOU HAVE REACHED THE FINAL TASK AND ARE ALMOST OUT THE MAZE.\nTHE EXIT IS SO CLOSE...JUST ONE MORE OBSTACLE TO OVERCOME...\n";
    }

    public void taskInstructions() throws InterruptedException { //prints task instructions
        try {
            Thread.sleep(5000);
            System.out.println("Your final task is a riddle. There are three, so first you must choose a number, then you'll see your riddle.\nThe answer is always one simple word (without an article), which you have to enter to be allowed to finish. Here we go...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted");
        }
    }
    public boolean doTask() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect a riddle (type 1, 2, or 3):"); //selection of group number
        int riddleChoice = Integer.parseInt(sc.nextLine()); //input of number to match with switch
        String riddle = switch (riddleChoice) { //riddles with default for wrong number input
            case 1 -> "What do you have to break before you use it?";
            case 2 -> "What invention lets you look through a wall?";
            case 3 -> "What can you never eat before breakfast and lunch?";
            default -> "Invalid number";
        };
        try { //exception for thread sleep start
            if (riddleChoice >= 1 && riddleChoice <= 3) { //prints chosen riddle from switch
                Thread.sleep(1500);
                System.out.println(riddle);
            } else {
                System.out.println(riddle); //prints default
            }
            System.out.println();

            Thread.sleep(2000);
            System.out.println("What's the answer?"); //answer prompt

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted");
        }
        String answer = sc.nextLine().trim().toLowerCase(); //answer input
        if (answer.equals("egg") || answer.equals("window") || answer.equals("dinner")) { //correct answers to match with answer input
            System.out.println("\nYOU HAVE SUCCEEDED! FOLLOW THE LIGHT TO REACH THE EXIT...\n");
            return true;
        } else {
            System.out.println(failMessage());
        }
        return false;
    }
}
