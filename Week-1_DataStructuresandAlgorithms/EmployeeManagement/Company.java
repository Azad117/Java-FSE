public class Company {
   private Employee[] employees;
   private int size;

   public Company(int capacity)
   {
        employees = new Employee[capacity];
        size = 0;
   }

   public void traverseEmp()
   {
        for(int i = 0;i<size;i++)
        {
            System.out.println(employees[i]);
        }
   }

   public void addEmployee(Employee employee)
   {
        if(size < employees.length)
        {
            employees[size++] = employee;
            System.out.println("Employee Added Successfully");
            return;
        }
        System.out.println("Company is at Full Capacity. Cannot Add More Employees.");
   }

   public void searchEmployee(int Id)
   {
        for(int i = 0;i<size;i++)
        {
            if(employees[i].getId() == Id)
            {
                System.out.println("Employee Found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee with ID " + Id + " not found.");
   }
   public void deleteEmp(int Id)
   {
        for(int i = 0;i<size;i++)
        {
            if(employees[i].getId() == Id)
            {
                for(int j = 1;j < size - 1; j++)
                {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                System.out.println("Employee with ID " + Id + " deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + Id + " not found.");
   }


}
