public class StudentController {

    Student model;
    StudentView view;

    StudentController(Student model, StudentView view)
    {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name)
    {
        model.setName(name);
    }

    public String getName()
    {
        return model.getName();
    }
    public void setStudentId(int id)
    {
        model.setId(id);
    }
    public int getId()
    {
        return model.getId();
    }

    public void setStudentGrade(String grade)
    {
        model.setGrade(grade);
    }

    public String getGrade()
    {
        return model.getGrade();
    }

    public void updateView()
    {
        view.displayDetails(model.getName(), model.getId(), model.getGrade());
    }
}
