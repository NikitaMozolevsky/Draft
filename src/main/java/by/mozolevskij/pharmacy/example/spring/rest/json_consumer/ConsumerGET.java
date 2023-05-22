package by.mozolevskij.pharmacy.example.spring.rest.json_consumer;

import org.springframework.web.client.RestTemplate;

public class ConsumerGET {

    /**Что нужно получить
     *
     * {
     *     "data": {
     *         "id": 2,
     *         "email": "janet.weaver@reqres.in",
     *         "first_name": "Janet",
     *         "last_name": "Weaver",
     *         "avatar": "https://reqres.in/img/faces/2-image.jpg"
     *     },
     *     "support": {
     *         "url": "https://reqres.in/#support-heading",
     *         "text": "To keep ReqRes free, contributions
     *         towards server costs are appreciated!"
     *     }
     * }
     *
     * */

    public static void main(String[] args) {

        //https://reqres.in/ - сайт с данными
        RestTemplate restTemplate = new RestTemplate();

        //JSON Address
        String url = "https://reqres.in/api/users/2";

        //get т.к. это GET HTTP запрос
        //What object I expect to retrieve (String)
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);

    }

}
