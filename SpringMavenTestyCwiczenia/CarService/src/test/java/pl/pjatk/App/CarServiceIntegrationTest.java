package pl.pjatk.App;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CarServiceIntegrationTest {

    @MockBean
    private CarStorage carStorage;

    @MockBean
    private RentalStorage rentalStorage;

    @Autowired
    private CarService carService;

    @Test
    void shoulPass() {
        when(carStorage.findVim(any())).thenReturn(new Car("qeqer", "aaaa", "standard", "56226"));
        List<Car> allCars = carService.getAllCars();

        assertThat(allCars).isNotEmpty();
    }

    @Test
    void checkIfTheCarIsAlreadyRented() {
        //WHEN
        carService.rentACar(new User("aaa"), "1", LocalDate.of(2022, 12, 1), LocalDate.of(2022, 12, 3));
        Boolean isRental = null == carService.rentACar(new User("aaa"), "1", LocalDate.of(2022, 12, 1), LocalDate.of(2022, 12, 3));
        //THEN
        assertThat(isRental).isEqualTo(true);
    }

    @Test
    void checkIfTheEndDateIsLaterThanTheStartDate() {
        //WHEN
        Boolean isRental = null == carService.rentACar(new User("aaa"), "1", LocalDate.of(2022, 12, 10), LocalDate.of(2022, 12, 3));
        //THEN
        assertThat(isRental).isEqualTo(true);
    }

    @Test
    void checkHowMuchPremiumCosts() {
        when(carStorage.findVim(any())).thenReturn(new Car("skoda", "octavia", "premium", "123"));
        //GIVEN
        double pricePremiumTest = 200 + (1.5 * 100 * 2);
        //WHEN
        double pricePremium = carService.rentACar(new User("aaa"), "2", LocalDate.of(2022, 11, 28), LocalDate.of(2022, 11, 30)).getPrice();
        //THEN
        assertThat(pricePremium).isEqualTo(pricePremiumTest);
    }

    @Test
    void checkHowMuchPlatinumCosts() {
        when(carStorage.findVim(any())).thenReturn(new Car("Ferrari", "Enzo", "platinum", "166"));
        //GIVEN
        double pricePlatinumTest = 200 + (2 * 100 * 2);
        //WHEN
        double pricePlatinum = carService.rentACar(new User("aaa"), "3", LocalDate.of(2022, 11, 28), LocalDate.of(2022, 11, 30)).getPrice();
        //THEN
        assertThat(pricePlatinum).isEqualTo(pricePlatinumTest);
    }

    @Test
    void checkIfVimIsNull() {
        Boolean vimIsNull = null == carService.rentACar(new User("aaa"), null, LocalDate.of(2022, 12, 10), LocalDate.of(2022, 12, 3));
        //THEN
        assertThat(vimIsNull).isEqualTo(true);
    }

}
