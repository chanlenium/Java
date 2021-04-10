package CarRegistration;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private String owner;
    private double mileage;
    private String registration;

    public Car(String model, String owner, double mileage) {
        this.model = model;
        this.owner = owner;
        this.mileage = mileage;
        this.registration = "unregistered";
    }

    public String toString() {
        return "Model: " + model + " Owner: " + owner +
                " mileage: " +  mileage +
                " Registration: " + registration;
    }

    public void getRegistered(String plate) {
        registration = plate;
    }
}
