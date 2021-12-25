package otus.integration.exp.integrations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.*;
import org.springframework.integration.scheduling.PollerMetadata;
import otus.integration.exp.service.CarWash;

import java.util.concurrent.Executors;

@IntegrationComponentScan
@ComponentScan
@Configuration
@EnableIntegration
public class IntegrationConfig {

    @Autowired
    private CarWash carWash;

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerSpec poller() {
        return Pollers.fixedRate(1000);
    }

    @Bean
    public IntegrationFlow carsFlow() {
        return flow -> flow.channel(c -> c.executor(Executors.newCachedThreadPool()))
                .split()
                .handle(carWash, "washing")
                .aggregate();
    }

}
