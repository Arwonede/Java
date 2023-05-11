package pl.pjatk.App;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class CarService {
    private final double standardPrice = 200;
    private final double standardPriceForDay = 100;
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;
    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }


    public RentalStorage getRentalStorage() {
        return rentalStorage;
    }

    public List<Car> getAllCars() {
        return carStorage.getCars();
    }

    private double rentalPrice(Car car,long dayBetween) {
        double carType;
        switch (car.getCarClass()) {
            case "premium": {
                carType = 1.5;
                break;
            }
            case "platinum": {
                carType = 2;
                break;
            }
            default:
                carType = 1;
        }
        return standardPrice + (carType * standardPriceForDay * dayBetween);
    }

    public RentalInfo rentACar(User user, String vim, LocalDate startDate, LocalDate finishDate) {
        if(vim == null)return null;
        Car findCar = carStorage.findVim(vim);
        if (findCar == null) {
            return null;
        }
        if (rentalStorage.getRentalList() != null) {
            for (Rental rental : rentalStorage.getRentalList()) {
                if (vim.equals(rental.getCar().getVim())) {
                    return null;
                }
            }
        }
        long dayBetween = DAYS.between(startDate, finishDate);
        if(dayBetween<=0)return null;
        double price = rentalPrice(findCar, dayBetween);
        RentalInfo rentalInfo = new RentalInfo(startDate, finishDate, price);
        Rental rental = new Rental(user, findCar, rentalInfo);
        rentalStorage.getRentalList().add(rental);
        return rentalInfo;
    }
}
