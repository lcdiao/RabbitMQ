package cn.lcdiao.rabbitmq.demo;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.info}",autoDelete = "true"),              //绑定队列
        exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),   //绑定交换器的名字和类型
        key = "*.log.info"                                         //绑定路由键---模糊匹配
        )
        )
public class InfoReceiver {

    /**
     * 从队列中接收消息
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("-----------------info日志:"+msg);
    }

}
