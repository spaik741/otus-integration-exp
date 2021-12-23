package otus.integration.exp.integrations;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import otus.integration.exp.entity.Car;
import otus.integration.exp.entity.OrderWash;

@MessagingGateway
public interface CarWashGateway {
    @Gateway(requestChannel = "carsFlow.input")
    Car process(OrderWash orderWash);
}
