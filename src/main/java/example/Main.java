package example;

import example.configuration.ExampleConfiguration;
import excimer.nrepl.NREPLServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(final String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ExampleConfiguration.class);
        ctx.refresh();

        final NREPLServer nreplServer = ctx.getBean("nreplServer", NREPLServer.class);
        System.out.println(nreplServer);
        System.out.println(nreplServer.isRunning());

        while (true) {
            Thread.sleep(10000);
        }
    }
}
