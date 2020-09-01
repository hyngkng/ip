import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        tasks = taskList;
    }

    @Override
    public String toString() {
        String listString = "";
        for (Task task : tasks) {
            listString += task + "\n";
        }
        return listString;
    }

    public void printList(Ui ui) {
        if (tasks.size() == 0) ui.say("Your task list is currently empty.");
        else {
            ui.say("Here is your task list.");
            int count = 1;
            for (Task task : tasks) {
                System.out.println(count + ". " + task);
                count++;
            }
        }
    }

    public void markTaskDone(int number, Ui ui) {
        Task task = tasks.get(number - 1);
        task.markDone();
        ui.say("I have marked it as done!");
        System.out.println(task);
    }

    public void deleteTask(int number, Ui ui) {
        Task task = tasks.get(number - 1);
        tasks.remove(number - 1);
        ui.say("I have deleted this task!");
        System.out.println(task);
        ui.say("You have " + getListSize() + " items in your task list now.");
    }

    public void addTask(Task task, Ui ui) {
        tasks.add(task);
        ui.say("You have " + getListSize() + " items in your task list now.");
    }

    public void findTask(String body, Ui ui) {
        if (tasks.size() > 0) {
            ui.say("Here are the matching tasks in your list:");
            boolean noneFound = true;
            for (Task task : tasks) {
                if (task.toString().contains(body)) {
                    System.out.println(task);
                    noneFound = false;
                }
            }
            if (noneFound) ui.say("No matching tasks.");
        } else {
            ui.say("You have no tasks yet.");
        }
    }

    public int getListSize() {
        return tasks.size();
    }
}