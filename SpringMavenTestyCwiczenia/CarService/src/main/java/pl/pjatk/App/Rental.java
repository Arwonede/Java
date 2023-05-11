package pl.pjatk.App;

public class Rental {
    private User user;
    private Car car;
    private RentalInfo rentalInfo;
    public Rental(User user, Car car,RentalInfo rentalInfo) {
        this.user = user;
        this.car = car;
        this.rentalInfo = rentalInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RentalInfo getRentalInfo() {
        return rentalInfo;
    }

    public void setRentalInfo(RentalInfo rentalInfo) {
        this.rentalInfo = rentalInfo;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Rental{" + "user=" + user + ", car=" + car + '}';
    }
}
