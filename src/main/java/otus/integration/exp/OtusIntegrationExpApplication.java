package otus.integration.exp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.*;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.scheduling.annotation.EnableScheduling;
import otus.integration.exp.entity.Car;
import otus.integration.exp.entity.OrderWash;
import otus.integration.exp.integrations.CarWashGateway;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

import static otus.integration.exp.entity.Kind.*;

@EnableScheduling
@SpringBootApplication
public class OtusIntegrationExpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OtusIntegrationExpApplication.class, args);
        CarWashGateway carWashGateway = ctx.getBean(CarWashGateway.class);
        carWashGateway.process(genOrderWash());
    }

//    @Bean(name = PollerMetadata.DEFAULT_POLLER)
//    public PollerSpec poller() {
//        return Pollers.fixedRate(1000);
//    }
//
//    @Bean
//    public QueueChannel carsChannel() {
//        return MessageChannels.queue( 5).get();
//    }
//
//    @Bean
//    public IntegrationFlow cafeFlow() {
//        return IntegrationFlows.from( "carsChannel" )
//                .split()
//                .handle( "carWashService", "washing")
//                .aggregate()
//                .get();
//    }

//    public static void main(String[] args) {
////       SpringApplication.run(OtusIntegrationExpApplication.class, args);
//        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(OtusIntegrationExpApplication.class);
//        CarWashGateway carWashGateway = ctx.getBean(CarWashGateway.class);
//        carWashGateway.process(genOrderWash());
//    }

    private static OrderWash genOrderWash() {
        return new OrderWash(new Car("BMW", "X3"), List.of(SHAMPOO, RINSING, WAX, POLISH));
    }
}


