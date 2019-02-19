package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SenderConfig {

    /**
     * 队列---中转站
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("hello-queue");
    }

}
