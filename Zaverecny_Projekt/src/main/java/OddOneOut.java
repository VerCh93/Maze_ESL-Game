import java.util.Scanner;
public class OddOneOut implements ITask {
    public String welcome() {
        return ITask.super.welcome();
    } //prints welcome message

    public void taskInstructions() throws InterruptedException { //prints task instructions
        try {
            Thread.sleep(3000);
            System.out.println("In this task you must choose which word doesn't belong in the group.\nThere are three groups. Select a group, then type the word you think is odd.\nGood luck!\n");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.err.println("Thread was interrupted");
        }
    }

    public boolean doTask() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a group (type 1, 2, or 3):"); //selection of group number
        int groupChoice = Integer.parseInt(sc.nextLine()); //choice input
        String wordGroup = switch (groupChoice) { //matches player's chosen number with switch options
            case 1 -> "chair, table, nightstand, mug, couch";
            case 2 -> "banana, strawberry, cherry, blueberry, raspberry";
            case 3 -> "leg, arm, eyes, shirt, toes, knee";
            default -> "Invalid number"; //when player inputs incorrect number
        };
        try {
        if (groupChoice >= 1 && groupChoice <= 3) {
            System.out.println("You have chosen group " + groupChoice + ". Let's see the words...\n"); //prints chosen group number
            Thread.sleep(1500);
            System.out.println(wordGroup); //prints words from group
        } else {
            System.out.println(wordGroup); //prints default
        }
        System.out.println();

            Thread.sleep(2000);
            System.out.println("Which word do you think is the odd one out?"); //answer prompt

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted");
        }
        String oddWord = sc.nextLine().trim().toLowerCase(); //answer input
        if (oddWord.equals("mug") || oddWord.equals("banana") || oddWord.equals("shirt")) { //matches input answer with correct words
            System.out.println(passMessage());
            return true;
        } else {
            System.out.println(failMessage());
        }
        return false;
    }

}
