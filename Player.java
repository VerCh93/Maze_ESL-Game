import java.util.Scanner;

public class Player {

    String nickname;
    int x;
    int y;
    long timeElapsed;
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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int[][] maze) { //player input choice of direction
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        while (!found) {
            System.out.println("Choose which way you want to go: (type up/down/left/right)");
            String direction = sc.nextLine().trim().toUpperCase();
            switch (direction) {
                case "UP":
                    found = step(Direction.UP, maze);
                    break;
                case "DOWN":
                   found = step(Direction.DOWN, maze);
                    break;
                case "LEFT":
                    found = step(Direction.LEFT, maze);
                    break;
                case "RIGHT":
                    found = step(Direction.RIGHT, maze);
                    break;
            }
        }
        System.out.println("Moving...");
    }

    private boolean step(Direction direction, int[][] maze) { //moving in directions from enum to new x/y index in "maze"
        int newX = x;
        int newY = y;
        switch (direction) {
            case Direction.UP -> newX = x - 1;
            case Direction.DOWN -> newX = x + 1;
            case Direction.LEFT -> newY = y - 1;
            case Direction.RIGHT -> newY = y + 1;
        }
        if (newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length) {
            System.out.println("You can't move outside the maze. Try a different direction.");
            return false;
        }
        int currentPosition = maze[newX][newY];
        if (currentPosition == -1) {
            System.out.println("You've hit a wall. Try a different way.");
            return false;
        } else {
            x = newX;
            y = newY;
            return true;
        }
    }

    @Override
    public String toString() {
        return "Hello " + nickname + "...";
    }
}
