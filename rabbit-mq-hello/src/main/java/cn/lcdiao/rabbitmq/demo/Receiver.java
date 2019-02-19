package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    /**
     * 从队列中接收消息
     * @param msg
     */
    @RabbitListener(queues = "hello-queue")
    public void process(String msg){
        System.out.println("receiver:"+msg);
    }

}
