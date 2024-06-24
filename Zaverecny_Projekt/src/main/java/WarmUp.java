import java.util.Scanner;
public class WarmUp implements ITask {
    @Override
    public String welcome() { //prints first welcome message overridden for Introduction to maze
       return """
                                                  _________  ___   ___   ______              \s
                                                 /________/\\/__/\\ /__/\\ /_____/\\             \s
                                                 \\__.::.__\\/\\::\\ \\\\  \\ \\\\::::_\\/_            \s
                                                    \\::\\ \\   \\::\\/_\\ .\\ \\\\:\\/___/\\           \s
                                                     \\::\\ \\   \\:: ___::\\ \\\\::___\\/_          \s
                                                      \\::\\ \\   \\: \\ \\\\::\\ \\\\:\\____/\\         \s
                                                  ___ _\\__\\/  __\\__\\/_\\::\\/_\\_____\\/_____    \s
                                                 /__//_//_/\\ /_______/\\   /_____/\\/_____/\\   \s
                                                 \\::\\| \\| \\ \\\\::: _  \\ \\  \\:::__\\/\\::::_\\/_  \s
                                                  \\:.      \\ \\\\::(_)  \\ \\    /: /  \\:\\/___/\\ \s
                                                   \\:.\\-/\\  \\ \\\\:: __  \\ \\  /::/___ \\::___\\/_\s
                                                    \\. \\  \\  \\ \\\\:.\\ \\  \\ \\/_:/____/\\\\:\\____/\\
                                                     \\__\\/ \\__\\/ \\__\\/\\__\\/\\_______\\/ \\_____\\/
                                                             
                                                      
                                                      
                                                      ======== WELCOME TO THE MAZE! =======
                 To get through the maze, you must complete a set of tasks that will test your knowledge of the English language.
              Each successfully completed task will take you further into the maze and closer to its exit. Fail, and the game is over.
                                The tasks start simple, but beware! They will get harder as you move through the maze.
                                                                    GOOD LUCK!
                                                   
        """;
    }

    public void taskInstructions() throws InterruptedException { //prints task instructions
        try {
            Thread.sleep(5000);
            System.out.println("Your first task is a simple warm-up question. Answer it with 'yes' or 'no' to be allowed forward. Here we go...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted");
        }
    }
    public boolean doTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is English the best language in the world? Type your answer:"); //prints first task's simple question
        String answer = sc.nextLine().trim().toLowerCase(); //answer input
        if (answer.equals("yes")) { //matches answer input with correct answer
            System.out.println(passMessage());
            return true;
        } else {
            System.out.println(failMessage());
        }
        return false;

    }
}
