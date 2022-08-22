package strategy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Builder
@Getter
public class Question {
    private long id;
    private String name;
    private String description;
    private List<Byte> images;

    private DisplayBehavior displayBehavior;
}
