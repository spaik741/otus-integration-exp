package otus.integration.exp.integrations;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@IntegrationComponentScan
@ComponentScan
@Configuration
@EnableIntegration
public class IntegrationConfig {
}
