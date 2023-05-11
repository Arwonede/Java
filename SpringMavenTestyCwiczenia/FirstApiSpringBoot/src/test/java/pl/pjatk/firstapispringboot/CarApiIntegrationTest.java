package pl.pjatk.firstapispringboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pjatk.firstapispringboot.model.Car;
import pl.pjatk.firstapispringboot.service.CarManager;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarApiIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CarManager carManager;

    @Test
    public void getCars_returnsListOfCars() {
        List<Car> carList = Arrays.asList(new Car("Polo", "VW"), new Car("126p", "Fiat"));
        Mockito.when(carManager.getCarList()).thenReturn(carList);

        ResponseEntity<List<Car>> response = restTemplate.exchange("/test/model", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().size()).isEqualTo(carList.size());
        assertThat(response.getBody().get(0).getModel()).isEqualTo(carList.get(0).getModel());
        assertThat(response.getBody().get(0).getMark()).isEqualTo(carList.get(0).getMark());
        assertThat(response.getBody().get(1).getModel()).isEqualTo(carList.get(1).getModel());
        assertThat(response.getBody().get(1).getMark()).isEqualTo(carList.get(1).getMark());

        Mockito.verify(carManager, Mockito.times(1)).getCarList();
    }

    @Test
    public void helloSomeValue_returnsPathVariableValue() {
        ResponseEntity<String> response = restTemplate.exchange("/test/hello/{someValue}", HttpMethod.GET, null, String.class, "testValue");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("testValue");
    }

    @Test
    public void helloRequestParam_returnsRequestParamValue() {
        ResponseEntity<String> response = restTemplate.exchange("/test/hello?reqParam=testValue", HttpMethod.GET, null, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("testValue");
    }

    @Test
    public void createCar_returnsCreatedCar() {
        Car carToCreate = new Car("Polo", "VW");
        Car createdCar = new Car("Polo", "VW");
        Mockito.when(carManager.addCar(Mockito.any(Car.class))).thenReturn(true);

        ResponseEntity<Car> response = restTemplate.postForEntity("/test/model", carToCreate, Car.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getModel()).isEqualTo(createdCar.getModel());
        assertThat(response.getBody().getMark()).isEqualTo(createdCar.getMark());

        Mockito.verify(carManager, Mockito.times(1)).addCar(Mockito.any(Car.class));
    }

    @Test
    public void throwException_returnsBadRequest() {
        ResponseEntity<String> response = restTemplate.exchange("/test/exception", HttpMethod.GET, null, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("Exception occurred on request. Exception message: Example exception");
    }

}