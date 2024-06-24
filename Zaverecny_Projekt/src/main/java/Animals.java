import java.util.Scanner;
import java.util.Random;
public class Animals implements ITask{

    public String welcome() {
        return ITask.super.welcome();
    } //welcome message from Itask

    public void taskInstructions() throws InterruptedException { //prints task instructions
        try {
            Thread.sleep(3000);
            System.out.println("A guessing game!\nYou will see a picture. Type the name of the animal you see in the picture.\nMind your spelling!\n");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.err.println("Thread was interrupted");
        }
    }
    public boolean doTask() throws InterruptedException { //prints ASCII animals
        String[] animals = {
        "  __         __\n" +
        " /  \\.-'''-./  \\\n" +
        " \\    -   -    /\n" +
        "  |   o   o   |\n" +
        "  \\  .-'''-.  /\n" +
        "   '-\\__Y__/-'\n" +
        "      `---`",

        "               __,__\n" +
        "      .--.  .-'     '-.  .--.\n" +
        "    / .. \\/  .-. .-.  \\/ .. \\\n" +
        "   | |  '|  /   Y   \\  |'  | |\n" +
        "   | \\   \\  \\ 0 | 0 /  /   / |\n" +
        "   \\ '- ,\\.-''`` ``''-./, -' /\n" +
        "     `'-' /_   ^ ^   _\\ '-'`\n" +
        "         |  \\._   _./  |\n" +
        "         \\   \\ `~` /   /\n" +
        "          '._ '-=-' _.'\n" +
        "             '~---~'\n",

        "     _.-- ,.--.\n" +
        "   .'   .'    /\n" +
        "  | @       |'..--------._\n" +
        "  /      \\._/              '.\n" +
        " /  .-.-                     \\\n" +
        "(  /    \\                     \\\n" +
        " \\\\      '.                  | #\n" +
        "  \\\\       \\   -.           /\n" +
        "   :\\       |    )._____.'   \\\n" +
        "   ''       |   /  \\  |  \\    )\n" +
        "            |   |./'  :__ \\.-'\n" +
        "            '--'\n",
        };

        Random random = new Random();
        int randomIndex = random.nextInt(animals.length); //chooses animal from array by random index number
        System.out.println(animals[randomIndex]); //prints animal
        System.out.println("\nWhat's this animal?"); //answer prompt
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine().trim().toLowerCase(); //input of player guess
        if (answer.equals("bear") || answer.equals("elephant") || answer.equals("monkey")) { //correct answers match
            System.out.println(passMessage());
            return true;
        } else {
            System.out.println(failMessage());
        }
        return false;
    }
}
