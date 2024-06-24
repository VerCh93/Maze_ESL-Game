import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, ITask> tasks = new HashMap<>(); //collection of tasks
        Maze maze = new Maze(); //maze instance
        List<Player> players = new ArrayList<>(); //log of player to keep track of nicknames and round times
        WarmUp task1 = new WarmUp(); //creating task instances
        Animals task2 = new Animals();
        OddOneOut task3 = new OddOneOut();
        PastVerbs task4 = new PastVerbs();
        SentenceScramble task5 = new SentenceScramble();
        CorrectSentence task6 = new CorrectSentence();
        FinalTask task7 = new FinalTask();

        tasks.put(1, task1); //inputting tasks into the hashmap by key and task 'value'
        tasks.put(2, task2);
        tasks.put(3, task3);
        tasks.put(4, task4);
        tasks.put(5, task5);
        tasks.put(6, task6);
        tasks.put(7, task7);


        while (true) { //game start
            Instant start = Instant.now(); //start of round timer
            System.out.println("Choose a nickname:\n"); //setting up player's name
            Scanner sc = new Scanner(System.in);
            Player player = new Player(sc.nextLine());
            players.add(player); //adding player to list
            Thread.sleep(2000);
            System.out.println(player); //prints "Hello + nickname" (override in Player)

            Thread.sleep(3000);

            boolean nextRound = true;
            while (nextRound) { //beginning of Maze, starting position 0 0
                System.out.printf("Current position: %d %d\n", player.x, player.y); //shows position on x/y axis
                int current = maze.maze[player.getX()][player.getY()]; //gets players current position in maze to determine action
                if (current > 0) {
                    ITask task = tasks.get(current); //matches position with task number
                    System.out.println(task.welcome()); //prints welcome message
                    task.taskInstructions(); //prints task instructions
                    int attempts = 3;
                    while (attempts > 0) { //loop for countdown of attempts to complete task before game over
                        if (task.doTask()) {
                            break; //exits while loop when task answer is correct
                        }
                        attempts--;
                        if (attempts > 0) {
                            System.out.println("Try again!"); //repeats 3x before reaching 0
                        }
                        System.out.println();
                    }
                    if (attempts == 0) {
                        System.out.println("GAME OVER...");
                        System.exit(0); //ends game and exits programme when attempts reach 0
                    }
                    if (current == tasks.size()) { //reaching the last task in Maze by highest task number
                        Instant end = Instant.now(); //ends round timer
                        Duration timeElapsed = Duration.between(start, end);
                        player.setTimeElapsed(timeElapsed.getSeconds()); //gets seconds from start of round to end
                        System.out.println("Well done " + player.nickname + ". It took you " + player.getTimeElapsed() + " seconds to get through the maze. You are free now!"); //výpis času
                        System.out.println("Do you want to play again? (yes/no)");
                        String newGame = sc.nextLine().trim().toLowerCase();
                        if (newGame.equals("no")) { // ends game and prints out all nicknames with round times
                            printScores(players);
                            System.exit(0);
                        } else { //prints nicknames and round times + sends back to game start (1st while cycle)
                            printScores(players);
                            nextRound = false; //makes sure game doesn't start at while(nextRound)
                        }
                    }
                }
                if (nextRound) { //moves player through maze as long as nextRound is true (when the player is in the maze)
                    player.move(maze.maze);
                }
            }
        }
    }

    private static void printScores(List<Player> players) { //gets players from ArrayList and prints them out with their round times
        System.out.println("\nPLAYER SCORES:");
        for (Player nameAndTime : players) {
            System.out.println("Player: " + nameAndTime.nickname + ", Time: " + nameAndTime.getTimeElapsed() + " seconds");
        }
    }
}
