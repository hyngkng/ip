package duke.ui;

import duke.task.Task;

import java.util.Scanner;

/**
 * Keeps track of user input. A <code>Ui</code> object contains a <code>Scanner</code> object.
 */
public class Ui {
    private static final String BOT_NAME = "Duke: ";

    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads the user input and return it.
     * @return user input.
     */
    public String receiveUserInput() {
        return scanner.nextLine();
    }

    /**
     * Greets the user.
     */
    public String sayGreetings() {
        String message = BOT_NAME + "Hello! How may I help you? Type \"help\" for more info.";
        System.out.println(message);
        return message;
    }

    /**
     * Says goodbye to the user.
     */
    public String sayGoodbye() {
        String message = BOT_NAME + "Bye. Hope to see you again!";
        System.out.println(message);
        return message;
    }

    /**
     * Gives the user the list of available commands.
     */
    public String giveHelp() {
        String message = "Commands available:\n" +
                "todo <description> - add a todo eg. \"todo CS2103T quiz\".\n" +
                "deadline <description> - add a deadline eg. \"deadline CS2101 OP1 slides /by tomorrow\".\n" +
                "event <description> - add an event eg. \"event Duke's birthday party /at 2021-8-10\".\n" +
                "done <n> - mark task number 'n' as done eg. \"done 1\".\n" +
                "delete <n> - delete task with task number 'n' eg. \"delete 2\".\n" +
                "find - find tasks with matching descriptions eg. \"find CS2101\".\n" +
                "list - to list out current tasks, if any.\n" +
                "bye - to exit Duke.";
        System.out.println(message);
        return message;
    }

    /**
     * Informs the user the save file is not found.
     */
    public String informFileNotFound() {
        String message = BOT_NAME + "It seems like you have no saved files! Creating one now...";
        System.out.println(message);
        return message;
    }

    /**
     * Inform the user the error message.
     */
    public String sayErrorMessage(Exception e) {
        String errorMessage = BOT_NAME + "Error! " + e.getMessage();
        System.out.println(errorMessage);
        return errorMessage;
    }

    /**
     * Inform the user the current task list is empty.
     */
    public String sayCurrentListIsEmpty() {
        String message = BOT_NAME + "Your task list is currently empty.";
        System.out.println(message);
        return message;
    }

    /**
     * Lists down all tasks in the current task list.
     * @param currentList Current task list.
     */
    public String sayCurrentList(String currentList) {
        String message = BOT_NAME + "Here are your tasks:\n" + currentList;
        System.out.println(message);
        return message;
    }

    /**
     * Informs the user task has been marked done.
     * @param task The task marked as done.
     */
    public String sayMarkedAsDone(Task task) {
        String message = BOT_NAME + "I have marked it as done!\n" + task;
        System.out.println(message);
        return message;
    }

    /**
     * Informs the user task has been deleted, and inform new task list size.
     * @param task The task deleted.
     * @param listSize Current task list size.
     */
    public String sayDeletedTask(Task task, int listSize) {
        String message = BOT_NAME + "I have deleted this task!\n" + task;
        message += "\n" + "Current list size: " + listSize;
        System.out.println(message);
        return message;
    }

    /**
     * Inform the user task has been added, and inform new task list size.
     * @param task The task added.
     * @param listSize Current task list size.
     */
    public String sayAddedTask(Task task, int listSize) {
        String message = BOT_NAME + "I have added this task!\n" + task;
        message += "\n" + "Current list size: " + listSize;
        System.out.println(message);
        return message;
    }

    /**
     * Lists down all found tasks, if any.
     * @param foundTasks Found tasks.
     */
    public String sayFoundTasks(String foundTasks) {
        String message = BOT_NAME + "Here are the matching tasks found:\n" + foundTasks;
        System.out.println(message);
        return message;
    }

    /**
     * Inform the user no matching tasks found.
     */
    public String sayNoMatchingFileFound() {
        String message = BOT_NAME + "No matching file found!";
        System.out.println(message);
        return message;
    }

    /**
     * Inform the user task has been snoozed.
     * @param task The task snoozed.
     */
    public String sayTaskSnoozed(Task task) {
        String message = BOT_NAME + "I have snoozed this task!\n" + task;
        System.out.println(message);
        return message;
    }
}
