package pl.pjatk.App;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CarStorage {
    private final List<Car> cars;
    public CarStorage()
    {
        cars = List.of(
               new Car("volkswagen","polo","standard","1"),
               new Car("Mercedes","S500","premium","2"),
               new Car("ferrari","F40","platinum","3")

        );
    }
    public List<Car> getCars()
    {
        return this.cars;
    }
    public Car findVim(String vim)
    {
        for (Car car : cars)
        {
            if (car.getVim().equals(vim)){
                return car;
            }
        }
        return null;
    }
}
