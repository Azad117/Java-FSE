public class Main {
    public static void main(String[] args) {

    Student model = new Student("John Doe", 12345, "A");

    StudentView view = new StudentView();

    StudentController controller = new StudentController(model, view);

    System.out.println("Initial Student Details:");

    controller.updateView();

    controller.setStudentName("Jane Smith");
    controller.setStudentId(54321);
    controller.setStudentGrade("B");

    controller.updateView();

    }
}
