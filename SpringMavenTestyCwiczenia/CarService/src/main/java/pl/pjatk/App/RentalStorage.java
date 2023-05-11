package pl.pjatk.App;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class RentalStorage {
    private List<Rental> rentalList =new ArrayList<>();
    public List<Rental> getRentalList() {
        return this.rentalList;
    }
}
