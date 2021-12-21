package otus.integration.exp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderWash {
    private Car car;
    private List<Kind> kinds;
}
