package cn.vector.jms.producer;

import org.springframework.stereotype.Component;

public interface ProducerService {
    void sendMessage( String message);
}
