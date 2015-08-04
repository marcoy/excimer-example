package example.reactor;

import org.apache.commons.lang3.RandomStringUtils;
import reactor.bus.Event;
import reactor.bus.EventBus;

public class StringPublisher {

    private final EventBus eventBus;

    public StringPublisher(final EventBus eventBusArg) {
        eventBus = eventBusArg;
    }

    public void publishString() {
        eventBus.notify("str-data", Event.wrap(RandomStringUtils.randomAlphanumeric(10)));
    }
}
