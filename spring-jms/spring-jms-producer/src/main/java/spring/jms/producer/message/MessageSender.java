package spring.jms.producer.message;

import java.util.Map;

public interface MessageSender {

    void send(final Map map);
}
