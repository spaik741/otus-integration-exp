package otus.integration.exp.integrations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.*;
import org.springframework.integration.scheduling.PollerMetadata;

@IntegrationComponentScan
@ComponentScan
@Configuration
@EnableIntegration
public class IntegrationConfig {


    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerSpec poller() {
        return Pollers.fixedRate(1000);
    }

    @Bean
    public QueueChannel carsChannel() {
        return MessageChannels.queue(5).get();
    }

    @Bean
    public IntegrationFlow carsFlow() {
        return flow -> flow
                .split()
                .handle("carWashService", "washing")
                .aggregate();

    }

}
