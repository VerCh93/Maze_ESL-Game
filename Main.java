import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {
    public Map<Integer, ITask> tasks = new HashMap<>(); //collection of tasks

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        Maze maze = new Maze();
        List<Player> players = new ArrayList<>();
        WarmUp task1 = new WarmUp(); //creating task instances
        OddOneOut task2 = new OddOneOut();
        CorrectSentence task3 = new CorrectSentence();
        main.tasks.put(1, task1); //inputting tasks into the Maze by index number
        main.tasks.put(2, task2);
        main.tasks.put(3, task3);


        while (true) {
            System.out.println("Choose a nickname:\n"); //setting up player's name
            Scanner sc = new Scanner(System.in);
            Player player = new Player(sc.nextLine());
            players.add(player);
            Thread.sleep(2000);
            System.out.println(player); //vypíše Hello + nickname podle metody v Player

            Thread.sleep(3000);

            boolean nextRound = true;
            while (nextRound) {
                Instant start = Instant.now();
                System.out.printf("Current position: %d %d\n", player.x, player.y); //shows x/y index of position
                int current = maze.maze[player.getX()][player.getY()]; //gets players current position
                if (current > 0) { //matches position with task number
                    ITask task = main.tasks.get(current);
                    System.out.println(task.welcome());
                    task.taskInstructions();
                    int attempts = 3;
                    while (attempts > 0) {
                        if (task.doTask()) {
                            break;
                        }
                        attempts--;
                        if (attempts > 0) {
                            System.out.println("Try again!");
                        }
                        System.out.println();
                    }
                    if (attempts == 0) {
                        System.out.println("GAME OVER...");
                        System.exit(0);
                    }
                    if (current == main.tasks.size()) {
                        Instant end = Instant.now(); //ukončení intervalu
                        Duration timeElapsed = Duration.between(start, end);
                        System.out.println("Well done " + player.nickname + ". It took you " + timeElapsed.getSeconds() + " seconds to get through the maze. You are free now!"); //výpis času
                        player.setTimeElapsed(timeElapsed.getSeconds());
                        System.out.println("Do you want to play again? (yes/no)");
                        String newGame = sc.nextLine().trim().toLowerCase();
                        if (newGame.equals("no")) {
                            printScores(players);
                            System.exit(0);
                        } else {
                            printScores(players);
                            nextRound = false;
                        }
                    }
                }
                if (nextRound) {
                    player.move(maze.maze);
                }
            }
        }
    }

    private static void printScores(List<Player> players) {
        System.out.println("Player score");
        for (Player nameAndTime : players) {
            System.out.println("Player: " + nameAndTime.nickname + " Time: " + nameAndTime.getTimeElapsed());
        }
    }
}
