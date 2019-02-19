package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;        //交换器

    /**
     * 将内容发送到对应的Queue
     */
    public void send(){
        String msg = "hello"+new Date();
        this.rabbitTemplate.convertAndSend(this.exchange,"log.info.routing.key",msg);
        this.rabbitTemplate.convertAndSend(this.exchange,"log.error.routing.key",msg);
        //指定交换器、路由键、发送的内容
    }
}
