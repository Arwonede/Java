package pl.pjatk.firstapispringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.firstapispringboot.service.CarManager;
import pl.pjatk.firstapispringboot.model.Car;

@RestController
@RequestMapping("/test")
public class CarApi {

    private CarManager carManager;

    @Autowired
    public CarApi(CarManager carManager) {
        this.carManager = carManager;
    }

    @GetMapping("/model")
    public ResponseEntity<Car> getCars(){
        return ResponseEntity.ok(new Car("123", "abc"));
    }

    @GetMapping("/hello/{someValue}")
    public ResponseEntity<String> helloSomeValue(@PathVariable String someValue) {
        return ResponseEntity.ok(someValue);
    }

    @GetMapping("hello")
    public ResponseEntity<String> helloRequestParam(@RequestParam("reqParam") String someValue) {
        return ResponseEntity.ok(someValue);
    }

    @PostMapping("/model")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = new Car(car.getModel(), car.getMark());
        return ResponseEntity.ok(newCar);
    }

    @GetMapping("/exception")
    public ResponseEntity<Void> throwException() {
        throw new RuntimeException("Example exception");
    }

}
