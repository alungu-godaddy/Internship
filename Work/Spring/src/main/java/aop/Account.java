package aop;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Account {
    private String name;
    private String level;
}
