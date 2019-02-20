package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;        //交换器

    /**
     * 将内容发送到对应的Queue
     */
    public void send(){
        this.rabbitTemplate.convertAndSend(this.exchange,"user.log.debug","user.log.debug................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"user.log.info","user.log.info................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"user.log.warn","user.log.warn................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"user.log.error","user.log.error................0.0");
        //指定交换器、路由键、发送的内容
    }
}
