package pl.pjatk.firstapispringboot.Homework;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
public class ZadanieDomowe {

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        Student entity = new Student(id, "Nowak");
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/search")
    public ResponseEntity<Student> search(@RequestParam String keyword) {
        Student entity = new Student(2, keyword);
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student entity) {
        entity.setId(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student entity) {
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }
}