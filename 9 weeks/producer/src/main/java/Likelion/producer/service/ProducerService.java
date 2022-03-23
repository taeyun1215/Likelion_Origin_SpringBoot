package Likelion.producer.service;

import Likelion.producer.model.JobRequest;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue rabbitQueue;
    private final Gson gson;

    public ProducerService(
            @Autowired RabbitTemplate rabbitTemplate,
            @Autowired Queue rabbitQueue,
            @Autowired Gson gson
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitQueue = rabbitQueue;
        this.gson = gson;
    }

    public String send() {
        JobRequest jobRequest = new JobRequest(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(rabbitQueue.getName(), gson.toJson(jobRequest));
        LOGGER.info("sent message: {}", gson.toJson(jobRequest));
        return jobRequest.getJobId();
    }


/*    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    public void send() {
        StringBuilder builder = new StringBuilder("Hello");
        if (dots.incrementAndGet() == 4) {
            dots.set(1);
        }
        builder.append(".".repeat(dots.get()));
        builder.append(count.incrementAndGet());
        String message = builder.toString();

        rabbitTemplate.convertAndSend(rabbitQueue.getName(), message);
        LOGGER.info("sent message: {}", message);
    }*/
}
