import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private File file;

    public Storage(String filepath) {
        file = new File(filepath);
    }

    public ArrayList<Task> load() throws FileNotFoundException, DukeException {
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            ArrayList<Task> tasks = new ArrayList<>();
            while (scanner.hasNext()) {
                tasks.add(getTask(scanner.nextLine()));
            }
            return tasks;
        } else {
            throw new DukeException("No file found");
        }
    }

    public void write(TaskList tasks) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(tasks.toString());
        writer.close();
    }

    private static Task getTask(String line) throws DukeException {
        String[] parsed = line.split("]", 3);
        String type = parsed[0].substring(1);
        String status = parsed[1].substring(1);
        boolean isDone = (status.equals("\u2713"));
        String body = parsed[2].substring(1);
        switch (type) {
        case "T":
            return new Todo(body, isDone);
        case "D":
            String[] dParsed = body.split(" - ", 2);
            String dDescription = dParsed[0];
            String deadline = dParsed[1];
            return new Deadline(dDescription, deadline, isDone);
        case "E":
            String[] eParsed = body.split(" - ", 2);
            String eDescription = eParsed[0];
            String eventTime = eParsed[1];
            return new Event(eDescription, eventTime, isDone);
        default:
            throw new DukeException("Error finding task");
        }
    }
}