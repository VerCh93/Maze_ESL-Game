import java.util.Scanner;
public class OddOneOut implements ITask {
    public String welcome() {
        return ITask.super.welcome();
    }

    public void taskInstructions() throws InterruptedException {
        try {
            Thread.sleep(3000);
            System.out.println("In this task you must choose which word doesn't belong in the group.\nThere are three groups. Select a group, then type the word you think is odd.\nGood luck!\n");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.err.println("Thread was interrupted");
        }
    }

    public boolean doTask() throws InterruptedException { //random choice of group, number input
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a group (type 1, 2, or 3):"); //selection of group number
        int groupChoice = Integer.parseInt(sc.nextLine());
        String wordGroup = switch (groupChoice) { //changeable groups of words, must be changed in 2nd part too
            case 1 -> "chair, table, nightstand, mug, couch";
            case 2 -> "banana, strawberry, cherry, blueberry, raspberry";
            case 3 -> "leg, arm, eyes, shirt, toes, knee";
            default -> "Invalid number";
        };
        try { //exception for thread sleep start
        if (groupChoice >= 1 && groupChoice <= 3) {
            System.out.println("You have chosen group " + groupChoice + ". Let's see the words...\n");
            Thread.sleep(1500);
            System.out.println(wordGroup); //prints chosen word group
        } else {
            System.out.println(wordGroup); //prints default
        }
        System.out.println();

            Thread.sleep(2000);
            System.out.println("Which word do you think is the odd one out?"); //2nd part of exercise - choosing the word

        } catch (InterruptedException e) { //exception end
            System.err.println("Thread was interrupted");
        }
        String oddWord = sc.nextLine().trim().toLowerCase(); //word input
        if (oddWord.equals("mug") || oddWord.equals("banana") || oddWord.equals("shirt")) { //odd words
            System.out.println(passMessage());
            return true;
        } else {
            System.out.println(failMessage());
        }
        return false;
    }

}
