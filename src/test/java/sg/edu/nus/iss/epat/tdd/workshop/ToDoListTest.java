package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Collection;

public class ToDoListTest  {
    // Define Test Fixtures

    public ToDoListTest() {
        super();
    }

    private ToDoList toDoList;

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        toDoList = new ToDoList();

    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
    }

    @Test
    public void testAddTask() {
        // fail("Not implemented yet");
        // create mock task
        Task task = new Task("Do homework");
        toDoList.addTask(task);
        
        // Verify the task was added
        Task retrievedTask = toDoList.getTask("Do homework");
        assertNotNull(retrievedTask);
        assertEquals("Do homework", retrievedTask.getDescription());
    }

    @Test
    public void testGetStatus() {
        // fail("Not implemented yet");
        // create mock task
        // Task task = new Task("Do homework",true);
        // toDoList.addTask(task);
        
        testAddTask();
        
        toDoList.completeTask("Do homework");
        
        assertEquals(true,toDoList.getStatus("Do homework"));


    }

    @Test
    public void testRemoveTask() {
        // fail("Not implemented yet");
        testAddTask();

        Task removedTask = toDoList.removeTask("Do homework");
        assertNotNull(removedTask);
        assertEquals("Do homework", removedTask.getDescription());
        assertFalse(toDoList.getAllTasks().contains(removedTask));
    }

    @Test
    public void testGetCompletedTasks() {
        testAddTask();//add homework
        toDoList.completeTask("Do homework"); //complete homework
        Task task2 = new Task("Do housework",false); //add house work, uncompleted
        toDoList.addTask(task2);

        Collection<Task> completedCollection = toDoList.getCompletedTasks();
        assertEquals(1,completedCollection.size());
        // fail("Not implemented yet");
    }
}