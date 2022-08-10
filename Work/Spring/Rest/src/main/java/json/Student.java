package json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // ignore any unwanted json fields
public class Student {
    private int id;

    private String firstName;

    private String lastName;

    private boolean active;

    private Address address;

    private String[] languages;
}
