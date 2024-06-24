import java.util.Scanner;

public class SentenceScramble implements ITask {

    public String welcome() {
        return ITask.super.welcome();
    } //prints welcome message

    public void taskInstructions() throws InterruptedException { //prints task instructions
        try {
            Thread.sleep(3000);
            System.out.println("In this task you must put the scrambled sentence back in order.\nDon't forget to add a fullstop at the of the sentence!\nGood luck!\n");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.err.println("Thread was interrupted");
        }
    }

    public boolean doTask() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\ndown when Mary street the I walking saw was I\n"); //prints scrambled sentence
            Thread.sleep(3000);
            System.out.println("Now unscramble:"); //answer prompt
            String answer = sc.nextLine().trim().toLowerCase(); //answer input
            if (answer.equals("i was walking down the street when i saw mary.") || answer.equals("when i was walking down the street i saw mary.") || answer.equals("i saw mary when i was walking down the street.")) { //matches answer input with correct answer
                System.out.println(passMessage());
                return true;
            } else {
                System.out.println(failMessage());
            }
        } catch (InterruptedException e){
            System.err.println("Thread was interrupted");
        }
        return false;
    }
}
