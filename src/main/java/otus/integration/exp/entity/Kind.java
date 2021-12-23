package otus.integration.exp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Kind {
    SHAMPOO(1, "foam wash"),
    RINSING(2, "rinsing"),
    WAX(3, "waxing"),
    POLISH(4, "polished");

    @Getter
    private int number;
    @Getter
    private String description;

}
