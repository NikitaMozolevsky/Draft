package by.mozolevskij.pharmacy.example.spring.rest.sensor_rest;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class SensorDTO {

    @Size(max = 30, message = "name should have less than 30 characters")
    @Size(min = 3, message = "name should have more than 3 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
