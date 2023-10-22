package uni.fmi.Solaris.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category {
    int id;
    private String name;
    int vatPercent;
}
