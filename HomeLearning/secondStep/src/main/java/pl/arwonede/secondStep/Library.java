package pl.arwonede.secondStep;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Library {

    private List<Student> studentList;

    public Library() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("Dawid", "s25341"));
        studentList.add(new Student("Patryk", "s12345"));
    }

    public boolean addStudent (Student student){
        return studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
