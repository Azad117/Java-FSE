public class Employee {
    private int Id;
    private String name;
    private String position;
    private int salary;

    public Employee(int id, String name, String position, int salary)
    {
        this.Id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }
    public int getId()
    {
        return Id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }
    public String getPosition()
    {
        return position;
    }
    public void setSalary(int salary)
    {
        this.salary = salary;
    }
    public int getSalary()
    {
        return salary;
    }

    @Override
    public String toString()
    {
        return String.format("%d | %s - %s - $%d", Id, name, position, salary);
    }
}
