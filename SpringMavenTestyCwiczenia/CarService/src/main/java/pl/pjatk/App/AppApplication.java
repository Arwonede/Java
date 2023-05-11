package pl.pjatk.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppApplication {
//    private final CarService carService;
//
//    public AppApplication(CarService carService) {
//        this.carService = carService;
//        System.out.println("==================================================");
//        System.out.println(carService.rentACar(new User("aaa"), "1", LocalDate.of(2022, 11, 28), LocalDate.of(2022, 11, 30)));
//        System.out.println(carService.rentACar(new User("aaa"), "2", LocalDate.of(2022, 11, 28), LocalDate.of(2022, 11, 30)));
//        System.out.println(carService.rentACar(new User("aaa"), "3", LocalDate.of(2022, 11, 28), LocalDate.of(2022, 11, 30)));
//    }

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
