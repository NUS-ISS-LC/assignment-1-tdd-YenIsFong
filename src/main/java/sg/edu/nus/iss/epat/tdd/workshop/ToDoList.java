package sg.edu.nus.iss.epat.tdd.workshop;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ToDoList {
   private HashMap<String, Task> tasks = new HashMap<String, Task>();

   public void addTask(Task task) {
      // Add code here
      tasks.put(task.getDescription(),task);
   }

   public void completeTask(String description) {
      // Add code here
      this.getTask(description).setComplete(true);
   }

   public boolean getStatus(String description) {
      // Add code here
      return this.getTask(description).isComplete(); 
   }

   public Task getTask(String description) {
      // Add code here

      return this.tasks.get(description);// .get(key) returns the value pair for the specified key which is our task object
   }

   public Task removeTask(String description) {
      // Add code here

      return this.tasks.remove(description);
   }

   public Collection<Task> getAllTasks() {
      return tasks.values();
   }

   public Collection<Task> getCompletedTasks() {
      // Add code here
      List<Task> tempList = new ArrayList<>(); // Fixed: was "tasks templist = new tasks()"
      for (Task t : tasks.values()) { // Fixed: was "tasks.values(){"
         if (t.isComplete()) { // Fixed: was "t.isComplete{" - missing parentheses
               tempList.add(t); // Fixed: was "templist.add(t);"
         }
      }
      return tempList; // Fixed: was "return null;"
   }
}
