package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 将内容发送到对应的Queue
     */
    public void send(){
        String msg = "hello"+new Date();
        this.rabbitTemplate.convertAndSend("hello-queue",msg);
    }
}
