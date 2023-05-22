package pl.arwonede.secondStep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryApi {

    private Library library;

    @Autowired
    public LibraryApi(Library library){
        this.library = library;
    }

    @GetMapping("/getrentbook")
    public List<Student> getRentBook(){
        return library.getStudentList();
    }

    @PostMapping("/addrentbook")
    public boolean addRentBook(@RequestBody Student student){
        return library.addStudent(student);
    }


}




