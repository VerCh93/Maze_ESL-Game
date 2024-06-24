public interface ITask {
    default String welcome() { //introductory message for all tasks
        return """
                   ======================================================================================
                You've come across another task! Complete it to continue through the maze and find your way out.
                   ======================================================================================
                """;
    }
    void taskInstructions() throws InterruptedException; //instruction for what to do in each task

    boolean doTask() throws InterruptedException;
    public default String passMessage() { //message that appears when answer is correct
        return "Success! You may continue...";
    }
    public default String failMessage() { //message that appears when answer in wrong
        return "You have failed. How disappointing...";
    }
}
