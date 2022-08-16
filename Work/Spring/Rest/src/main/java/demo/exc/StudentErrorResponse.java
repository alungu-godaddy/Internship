package demo.exc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
