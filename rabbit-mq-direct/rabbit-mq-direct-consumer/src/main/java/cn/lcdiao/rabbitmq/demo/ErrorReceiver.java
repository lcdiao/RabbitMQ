package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.error}",autoDelete = "true"),              //绑定队列
        exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),   //绑定交换器的名字和类型
        key = "${mq.config.queue.error.routing.key}"                                         //绑定路由键
        )
        )
public class ErrorReceiver {

    /**
     * 从队列中接收消息
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("接收到ERROR日志:"+msg);
    }

}
