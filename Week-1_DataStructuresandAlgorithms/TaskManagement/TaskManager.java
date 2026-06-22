class Node
{
    Task task;
    Node next;

    Node(Task task) 
    {
        this.task = task;
        this.next = null;
    }
}

public class TaskManager 
{
    private Node head;
    
    public TaskManager() 
    {
        this.head = null;
    }

    public void addTask(Task task)
    {
        Node newnode = new Node(task);

        if(head == null)
        {
            head = newnode;
            System.out.println("Task Added Successfully");
            return;
        }

        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newnode;

        System.out.println("Task Added Successfully");
    }

    public void traversal()
    {
        if(head == null)
        {
            System.out.println("No Task Found");
            return;
        }

        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.task);
            temp = temp.next;
        }
    }

    public void searchTask(int taskId)
    {
        if(head == null)
        {
            System.out.println("No Task Found");
            return;
        }

        Node temp = head;
        while(temp != null)
        {
            if(temp.task.getTaskId() == taskId)
            {
                System.out.println(temp.task);
                return;
            }
            temp = temp.next;
        }
    }

    public void deleteTask(int taskId)
    {
        if(head == null)
        {
            System.out.println("No Task Found");
            return;
        }

        if(head.task.getTaskId() == taskId)
        {
            head = head.next;
            System.out.println("Task Deleted Successfully");
            return;
        }

        Node temp = head;
        while(temp.next != null)
        {
            if(temp.next.task.getTaskId() == taskId)
            {
                temp.next = temp.next.next;
                System.out.println("Task Deleted Successfully");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }
}
