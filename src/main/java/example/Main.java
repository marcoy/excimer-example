package example;

import example.configuration.ExampleConfiguration;
import example.reactor.StringConsumer;
import example.reactor.StringPublisher;
import excimer.nrepl.NREPLServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reactor.bus.EventBus;
import reactor.fn.Consumer;

import static reactor.bus.selector.Selectors.$;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ExampleConfiguration.class);
        ctx.refresh();

        final NREPLServer nreplServer = ctx.getBean("nreplServer", NREPLServer.class);
        nreplServer.startServer();
        LOGGER.info("nREPL server instance: {}", nreplServer);
        LOGGER.info("nREPL isRunning: {}", nreplServer.isRunning());
        LOGGER.info("nREPL port: {}", nreplServer.getPort());

        final EventBus eventBus = ctx.getBean("eventBus", EventBus.class);
        final Consumer stringConsumer = ctx.getBean("stringConsumer", StringConsumer.class);
        final StringPublisher stringPublisher = ctx.getBean("stringPublisher", StringPublisher.class);

        eventBus.on($("str-data"), stringConsumer);

        while (true) {
            stringPublisher.publishString();
            Thread.sleep(2000);
        }
    }
}
