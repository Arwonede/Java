package pl.pjatk.firstapispringboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.firstapispringboot.model.Car;
import pl.pjatk.firstapispringboot.service.CarManager;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CarManagerTest {

    @Mock
    private List<Car> carListMock;

    @InjectMocks
    private CarManager carManager;

    @BeforeEach
    public void setUp() {
        carListMock = new ArrayList<>();
        carListMock.add(new Car("Polo", "VW"));
        carListMock.add(new Car("126p", "Fiat"));
        carManager = new CarManager();
        carManager.setCarList(carListMock);
    }

    @Test
    public void testAddCar() {
        Car car = new Car("Clio", "Renault");
        when(carListMock.add(car)).thenReturn(true);
        assertTrue(carManager.addCar(car));
    }

    @Test
    public void testGetCarList() {
        assertEquals(carListMock, carManager.getCarList());
    }

    @Test
    public void testSetCarList() {
        List<Car> newList = new ArrayList<>();
        newList.add(new Car("Golf", "VW"));
        newList.add(new Car("Astra", "Opel"));
        carManager.setCarList(newList);
        assertEquals(newList, carManager.getCarList());
    }
}