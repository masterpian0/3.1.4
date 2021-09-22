package masterpian0;

import masterpian0.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Connection {

    private final RestTemplate restTemplate;
    private final HttpHeaders requestHeaders ;
    private String cookie = null;
    private final String URL = "http://91.241.64.178:7081/api/users";

    public Connection(RestTemplate restTemplate, HttpHeaders requestHeaders ) {
        this.restTemplate = restTemplate;
        this.requestHeaders  = requestHeaders ;
    }

    public void listUser() {
        ResponseEntity<String> response = restTemplate.getForEntity(URL,String.class);
        HttpHeaders headers = response.getHeaders();
        System.out.println("response list " + response);
        cookie = headers.getFirst("Set-Cookie");
        System.out.println("Cookie " + cookie);
    }

    public void addUser (User user) {
        requestHeaders.add("cookie",cookie);
        HttpEntity<User> requestBody = new HttpEntity<>(user,requestHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(URL,requestBody,String.class);
        System.out.println("response POST" + response);
    }

    public void changeUser(User user) {
        HttpEntity<User> requestBody = new HttpEntity<>(user,requestHeaders);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.PUT,requestBody,String.class);
        System.out.println("response PUT " + response);
    }

    public void deleteUser(long id) {
        HttpEntity<User> requestBody = new HttpEntity<>(requestHeaders);
        ResponseEntity<String> response = restTemplate.exchange(URL + "/" + id,HttpMethod.DELETE,requestBody,String.class);
        System.out.println("response DELETE " + response);
    }
}
