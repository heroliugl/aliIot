package com.chris;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chris.producer.MessageProducer;

/**
 * Created by wuxing on 2016/9/21.
 */
public class MessageTest {

    private Logger logger = LoggerFactory.getLogger(MessageTest.class);

    private ApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("application.xml");
    }

    @Test
    public void should_send_a_amq_message() throws Exception {
        MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");
        int a = 100;
        while (a > 0) {
        	// a--;
            messageProducer.sendMessage("Hello, I am amq sender num :" + a--);
/*            try {
                //暂停一下，好让消息消费者去取消息打印出来
            	Thread t = new Thread(  
                        new Thread(){  
                            @Override  
                            public void run() {  
                              
                              	MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer"); 
                            	 try {
								    messageProducer.sendMessage("Hello, I am amq sender num :");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}                       
                                  
                            }  
                        }  
                );  
                t.start();   
               // Thread.sleep(0);
            } catch (Exception e) {
                e.printStackTrace();
            }*/

        }
        
       // messageProducer.sendMessage("Hello, I am amq sender num : ======================= ");
        Thread.sleep(999999000);
    }
}
