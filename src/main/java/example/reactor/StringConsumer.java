package example.reactor;

import reactor.bus.Event;
import reactor.fn.Consumer;

public class StringConsumer implements Consumer<Event<String>> {
    @Override
    public void accept(Event<String> ev) {
        System.out.println("Consumer received: " + ev.getData());
    }
}
