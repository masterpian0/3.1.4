package masterpian0.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString

public class User {

    private Long id;
    private String name;
    private String lastName;
    private Byte age;


}
