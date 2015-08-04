package example.configuration;

import example.reactor.StringConsumer;
import example.reactor.StringPublisher;
import excimer.nrepl.NREPLServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import reactor.Environment;
import reactor.bus.EventBus;
import reactor.spring.context.config.EnableReactor;

@Configuration
@EnableMBeanExport
@EnableReactor
public class ExampleConfiguration {
    @Bean
    public NREPLServer nreplServer() {
        return new NREPLServer();
    }

    @Bean
    public EventBus eventBus(final Environment env) {
        return EventBus.create(env, Environment.THREAD_POOL);
    }

    @Bean
    public StringPublisher stringPublisher(final EventBus eventBus) {
        return new StringPublisher(eventBus);
    }

    @Bean
    public StringConsumer stringConsumer() {
        return new StringConsumer();
    }
}
