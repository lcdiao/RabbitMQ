package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;        //交换器

    /**
     * 将内容发送到对应的Queue
     */
    public void send(){
        this.rabbitTemplate.convertAndSend(this.exchange,"product.log.debug","product.log.debug................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"product.log.info","product.log.info................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"product.log.warn","product.log.warn................0.0");
        this.rabbitTemplate.convertAndSend(this.exchange,"product.log.error","product.log.error................0.0");
        //指定交换器、路由键、发送的内容
    }
}
