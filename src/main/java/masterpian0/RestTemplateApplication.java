package masterpian0;

import masterpian0.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);

        User userJames = new User(3L,"James","Brown",(byte)29);
        User userThomas = new User(3L,"Thomas","Shelby",(byte)29);
        Connection connection = new Connection(getRestTemplate(), getHttp());
        connection.listUser();
        connection.addUser(userJames);
        connection.changeUser(userThomas);
        connection.deleteUser(3);

    }

    @Bean
    static public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    static public HttpHeaders getHttp() {
        return new HttpHeaders();
    }

}
