package pl.pjatk.App;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {
    CarStorage carStorage = new CarStorage();
    RentalStorage rentalStorage = new RentalStorage();
    CarService carService = new CarService(carStorage,rentalStorage);
    @Test
    void checkCarExist() {
        //WHEN
        Car findCar = carStorage.findVim("1");
        //THEN
        assertThat(findCar.getVim()).isEqualTo("1");
    }
    @Test
    void checkCarStorageIsEmpty() {
        //WHEN
        Boolean isEmpty = carStorage.getCars() == null;
        //THEN
        assertThat(isEmpty).isEqualTo(false);
    }
    @Test
    void checkIfTheCarIsAlreadyRented()
    {
        //WHEN
        carService.rentACar(new User("aaa"),"1", LocalDate.of(2022,12,1),LocalDate.of(2022,12,3));
        Boolean isRental = null == carService.rentACar(new User("aaa"),"1", LocalDate.of(2022,12,1),LocalDate.of(2022,12,3));
        //THEN
        assertThat(isRental).isEqualTo(true);
    }
    @Test
    void checkIfTheEndDateIsLaterThanTheStartDate() {
        //WHEN
        Boolean isRental = null == carService.rentACar(new User("aaa"),"1", LocalDate.of(2022,12,10),LocalDate.of(2022,12,3));
        //THEN
        assertThat(isRental).isEqualTo(true);
    }
    @Test
    void checkHowMuchPremiumCosts() {
        //GIVEN
        double pricePremiumTest = 200+(1.5*100*2);
        //WHEN
        double pricePremium = carService.rentACar(new User("aaa"), "2", LocalDate.of(2022,11,28),LocalDate.of(2022,11,30)).getPrice();
        //THEN
        assertThat(pricePremium).isEqualTo(pricePremiumTest);
    }
    @Test
    void checkHowMuchPlatinumCosts() {
        //GIVEN
        double pricePlatinumTest = 200+(2*100*2);
        //WHEN
        double pricePlatinum = carService.rentACar(new User("aaa"), "3", LocalDate.of(2022,11,28),LocalDate.of(2022,11,30)).getPrice();
        //THEN
        assertThat(pricePlatinum).isEqualTo(pricePlatinumTest);
    }
    @Test
    void checkIfVimIsNull()
    {
        Boolean vimIsNull = null == carService.rentACar(new User("aaa"),null, LocalDate.of(2022,12,10),LocalDate.of(2022,12,3));
        //THEN
        assertThat(vimIsNull).isEqualTo(true);
    }
}