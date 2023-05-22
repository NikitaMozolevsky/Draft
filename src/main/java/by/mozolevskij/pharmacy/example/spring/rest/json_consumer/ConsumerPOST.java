package by.mozolevskij.pharmacy.example.spring.rest.json_consumer;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ConsumerPOST {

    //POST request for creating new user
    /** REQUEST
     *{
     *     "name": "morpheus",
     *     "job": "leader"
     * }
     * */

    /** RESPONSE
     * {
     *     "name": "morpheus",
     *     "job": "leader",
     *     "id": "901",
     *     "createdAt": "2023-05-15T10:43:15.527Z"
     * }
     * */

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Name");
        jsonToSend.put("job", "Job");

        //объект для отправка на сайт
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(jsonToSend);

        //JSON Address
        String urlPOST = "https://reqres.in/api/users";

        //get т.к. это GET HTTP запрос
        //What object I expect to retrieve (String)
        String response = restTemplate.postForObject(urlPOST, httpEntity, String.class);
        System.out.println(response);
    }



}
