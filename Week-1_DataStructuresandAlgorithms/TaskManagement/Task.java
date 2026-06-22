public class Task 
{
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) 
    {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() 
    {
        return taskId;
    }

    public String getTaskName() 
    {
        return taskName;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public void setTaskId(int taskId) 
    {
        this.taskId = taskId;
    }

    @Override
    public String toString(){
        return String.format("%d | %s - %s", taskId, taskName, status);
    }

}
