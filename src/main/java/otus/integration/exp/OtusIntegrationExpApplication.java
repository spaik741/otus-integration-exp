package otus.integration.exp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import otus.integration.exp.entity.Car;
import otus.integration.exp.entity.OrderWash;
import otus.integration.exp.integrations.CarWashGateway;

import java.util.List;

import static otus.integration.exp.entity.Kind.*;

@EnableScheduling
@SpringBootApplication
public class OtusIntegrationExpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OtusIntegrationExpApplication.class, args);
        CarWashGateway carWashGateway = ctx.getBean(CarWashGateway.class);
        carWashGateway.process(genOrderWash());
    }

    private static OrderWash genOrderWash() {
        return new OrderWash(new Car("BMW", "X3"), List.of(SHAMPOO, RINSING, WAX, POLISH), false);
    }
}


