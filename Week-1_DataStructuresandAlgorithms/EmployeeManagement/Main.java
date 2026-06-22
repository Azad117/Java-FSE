public class Main {

    public static void main(String[] args)
    {
        Company company = new Company(5);

        company.addEmployee(new Employee(1,"John Doe","Software Engineer",50000));
        company.addEmployee(new Employee(2,"Jane Smith","Product Manager",60000));
        company.addEmployee(new Employee(3,"Alice Johnson","UX Designer",55000));
        company.addEmployee(new Employee(4,"Bob Brown","Data Scientist",70000));
        company.addEmployee(new Employee(5,"Charlie Davis","DevOps Engineer",65000));

        company.traverseEmp();

        System.out.println();

        company.searchEmployee(3);
        System.out.println();

        company.deleteEmp(2);
        company.traverseEmp();

    }
    
}
