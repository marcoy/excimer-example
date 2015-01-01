package example;

import example.configuration.ExampleConfiguration;
import excimer.nrepl.NREPLServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        while (true) {
            Thread.sleep(10000);
        }
    }
}
