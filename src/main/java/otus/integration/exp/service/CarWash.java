package otus.integration.exp.service;

import otus.integration.exp.entity.Car;
import otus.integration.exp.entity.OrderWash;

public interface CarWash {
    OrderWash washing (OrderWash order) throws Exception;
}
