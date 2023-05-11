package pl.pjatk.App;

import java.time.LocalDate;

public class RentalInfo {
    private LocalDate startDate;
    private LocalDate finishDate;
    private double price;

    public RentalInfo(LocalDate startDate, LocalDate finishDate, double price) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "RentalInfo{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", price=" + price +
                '}';
    }
}
