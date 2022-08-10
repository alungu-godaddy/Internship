package json;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
