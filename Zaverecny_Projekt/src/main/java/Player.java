import java.util.Scanner;

public class Player {

    String nickname;
    int x;
    int y;
    long timeElapsed;
    Direction currentStep;
    public Player(String nickname) {
        this.nickname = nickname;
        this.x = 0;
        this.y = 0;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void move(int[][] maze) { //method for player choice of movement through maze
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        while (!found) { //finding a possible next step by number in Maze (player's choice)
            System.out.println("\nChoose which way you want to go: (type up/down/left/right)"); //choice prompt
            String direction = sc.nextLine().trim().toUpperCase(); //choice input
            switch (direction) { //matches choice input with direction
                case "UP":
                    if (currentStep != null && currentStep.equals(Direction.DOWN)) { //condition controls that player isn't moving backwards
                        found = false;
                        System.out.println("You're going back the same way you came!");
                        continue;
                    }
                    found = step(Direction.UP, maze); //found new possible step (step method below)
                    if (found) {
                        currentStep = Direction.UP; //added new value to new step
                    }
                    break;
                case "DOWN":
                    if (currentStep != null && currentStep.equals(Direction.UP)) {
                        found = false;
                        System.out.println("You're going back the same way you came!");
                        continue;
                    }
                    found = step(Direction.DOWN, maze);
                    if (found) {
                        currentStep = Direction.DOWN;
                    }
                    break;
                case "LEFT":
                    if (currentStep != null && currentStep.equals(Direction.RIGHT)) {
                        found = false;
                        System.out.println("You're going back the same way you came!");
                        continue;
                    }
                    found = step(Direction.LEFT, maze);
                    if (found) {
                        currentStep = Direction.LEFT;
                    }
                    break;
                case "RIGHT":
                    if (currentStep != null && currentStep.equals(Direction.LEFT)) {
                        found = false;
                        System.out.println("You're going back the same way you came!");
                        continue;
                    }
                    found = step(Direction.RIGHT, maze);
                    if (found) {
                        currentStep = Direction.RIGHT;
                    }
                    break;
            }
        }
        System.out.println("   ...moving...\n");
    }

    private boolean step(Direction direction, int[][] maze) { //position and new position in maze by axis x/y
        int newX = x;
        int newY = y;
        switch (direction) { //chosen direction moves player along axis to new position
            case Direction.UP -> newX = x - 1;
            case Direction.DOWN -> newX = x + 1;
            case Direction.LEFT -> newY = y - 1;
            case Direction.RIGHT -> newY = y + 1;
        }
        if (newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length) { //set up of maze boundaries
            System.out.println("You can't move outside the maze. Try a different direction.");
            return false; //cannot move
        }
        int currentPosition = maze[newX][newY];
        if (currentPosition == -1) { //set up of "wall" in maze, path is 0 and higher
            System.out.println("You've hit a wall. Try a different way.");
            return false; //cannot move
        } else {
            x = newX;
            y = newY;
            return true; //can move to new x/y
        }
    }

    @Override //greets player at beginning of game with chosen nickname
    public String toString() {
        return "Hello " + nickname + "...";
    }
}
