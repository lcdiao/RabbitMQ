package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;        //交换器

    /**
     * 将内容发送到对应的Queue
     */
    public void send(){
        this.rabbitTemplate.convertAndSend(this.exchange,"order.log.debug","order.log.debug................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"order.log.info","order.log.info................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"order.log.warn","order.log.warn................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"order.log.error","order.log.error................0.0");
        //指定交换器、路由键、发送的内容
    }
}
