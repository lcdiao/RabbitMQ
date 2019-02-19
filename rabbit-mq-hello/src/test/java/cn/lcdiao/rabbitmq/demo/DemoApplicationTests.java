package cn.lcdiao.rabbitmq.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void send() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            this.sender.send();
        }
    }

}
