import java.util.Scanner;
public class CorrectSentence implements ITask{
    public String welcome() {
        return ITask.super.welcome();
    } //prints welcome message from Itask

    public void taskInstructions() throws InterruptedException { //prints task instructions
        try {
            Thread.sleep(3000);
            System.out.println("In this task you must choose which sentence is grammatically correct.\nYou will see four sentences. Select a, b, c, or d for the sentence you think is correct.\nGood luck!\n");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.err.println("Thread was interrupted");
        }
    }
    public boolean doTask() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("a: I've lost my keys yesterday. My mom had to open the door for me.\nb: I visited Paris three times.\nc: She's played hockey at school, but she didn't like it.\nd: I've lived in London for four years now."); //prints sentences choices
        try {
            Thread.sleep(3000);
            System.out.println("Which is correct?"); //answer prompt
            String choice = sc.nextLine().trim().toLowerCase(); //answer input
            if (choice.equals("d")) { //match with correct letter choice
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
