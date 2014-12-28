package example.configuration;

import excimer.nrepl.NREPLServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@EnableMBeanExport
public class ExampleConfiguration {
    @Bean
    public NREPLServer nreplServer() {
        return new NREPLServer();
    }
}
