package by.mozolevskij.pharmacy.example.spring.rest.sensor_rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class SensorREST {

    /**DON'T WORK!, NOT SPRING*/

    public static String sensorName = "New Sensor";
    public static String ADD_MEASUREMENT = "http://localhost:8088/measurement/add";
    public static String REGISTER_SENSOR = "http://localhost:8088/sensor/registration";
    public static String GET_MEASUREMENT = "http://localhost:8088/measurement";

    public static void main(String[] args) {

        SensorREST.registerSensor(sensorName);

    }

    public static void registerSensor(String sensorName) {

        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("name", sensorName);
        makePostRequestWithJSONData(jsonData);

    }

    public static void makePostRequestWithJSONData(Map<String, String> objectMap) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(objectMap, headers);

        String response = restTemplate.postForObject(REGISTER_SENSOR, request, String.class);
        System.out.println(response);

    }

}
