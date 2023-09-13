package duke.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import duke.task.Task;
import duke.task.TaskList;

/**
 * Storage class that save the data
 */
public class Storage {
    private final String filePath;

    /**
     * Instantiates the Storage class
     *
     * @param directoryName the name of the directory
     * @param fileName the name of the file
     */
    public Storage(String directoryName, String fileName) {
        this.filePath = directoryName + "/" + fileName;
        // Make new file to store
        try {
            File directory = new File(directoryName);

            // Make the directory if not exist
            if (!directory.exists()) {
                directory.mkdir();
            }

            File file = new File(this.filePath);

            // Make the file if not exist
            if (file.exists()) {
                loadTasks();
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Failed to load tasks: " + e.getMessage());
        }
    }

    /**
     * Loads the tasks from the storage
     *
     * @return the tasks loaded
     * @throws IOException when the task stored is invalid (usually the date)
     */
    public ArrayList<Task> loadTasks() throws IOException {
        ArrayList<Task> loadedTasks = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
        String line = reader.readLine();

        // Adds each task
        while (line != null) {
            Task currentTask = Task.createFromStorage(line);
            loadedTasks.add(currentTask);
            line = reader.readLine();
        }

        reader.close();
        return loadedTasks;
    }

    /**
     * Adds new task to the storage
     *
     * @param task the new task added
     */
    public void addTask(Task task) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(task.storeInString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to add task: " + e.getMessage());
        }
    }

    /**
     * Updates the storage based on current tasks
     *
     */
    public void updateTask(TaskList tasks) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath));
            writer.write(tasks.storeInString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to update task: " + e.getMessage());
        }
    }
}
