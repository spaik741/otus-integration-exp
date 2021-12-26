package otus.integration.exp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String brand;
    private String model;

    @Override
    public String toString() {
        return "Car: " +
                "brand='" + brand + '\'' +
                ", name='" + model + '\'' +
                '}';
    }
}
