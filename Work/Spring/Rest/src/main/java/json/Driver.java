package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class Driver {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream stream = new ClassPathResource("json/sample-full.json").getInputStream();

            Student student = mapper.readValue(stream, Student.class);

            System.out.println("First name =" + student.getFirstName());
            System.out.println("Last name =" + student.getLastName());

            Address temp = student.getAddress();
            System.out.println("Street = " + temp.getStreet());
            System.out.println("City = " + temp.getCity());

            for (String language : student.getLanguages()) {
                System.out.println(language);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
