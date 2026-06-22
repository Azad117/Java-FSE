public class Main {
    public static void main(String[] args)
    {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask(new Task(1,"Week - 1 - Design Patterns and Principles","in progress"));
        taskManager.addTask(new Task(2,"Week - 1 - Data Structures and Algorithms","in progress"));
        taskManager.addTask(new Task(3,"Week - 2 - Sql","Not Started"));
        taskManager.addTask(new Task(4,"Week - 2 - Spring Boot","Not Started"));
        taskManager.addTask(new Task(5,"Week - 3 - Spring Boot","Not Started"));

        System.out.println();
        taskManager.traversal();

        System.out.println();
        
        taskManager.searchTask(2);
        System.out.println();


        taskManager.deleteTask(3);
        taskManager.traversal();
    }
}
