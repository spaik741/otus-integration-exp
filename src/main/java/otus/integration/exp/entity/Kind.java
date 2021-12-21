package otus.integration.exp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Kind {
    SHAMPOO(1, ""),
    RINSING(2, ""),
    WAX(3, ""),
    POLISH(4, "");

    @Getter
    private int number;
    @Getter
    private String description;

}
