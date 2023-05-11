package pl.pjatk.App;

public class Car {
    private String make;
    private String model;
    private String carClass;
    private String vim;

    public Car(String make, String model, String carClass, String vim) {
        this.make = make;
        this.model = model;
        this.carClass = carClass;
        this.vim = vim;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getCarClass() {
        return carClass;
    }

    public String getVim() {
        return vim;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public void setVim(String vim) {
        this.vim = vim;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + make + '\'' +
                ", model='" + model + '\'' +
                ", carClass='" + carClass + '\'' +
                ", vim=" + vim +
                '}';
    }
}
