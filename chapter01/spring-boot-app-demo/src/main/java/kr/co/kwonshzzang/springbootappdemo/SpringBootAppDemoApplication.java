package kr.co.kwonshzzang.springbootappdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Date;

@SpringBootApplication
public class SpringBootAppDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootAppDemoApplication.class, args);

//        예제 1.3
//        SpringApplication springApplication = new SpringApplication(SpringBootAppDemoApplication.class);
//        springApplication.setWebApplicationType(WebApplicationType.REACTIVE);
//        springApplication.run(args);

//        예제 1.10
        SpringApplication springApplication = new SpringApplication(SpringBootAppDemoApplication.class);
        springApplication.addListeners(new ApplicationStartingEventListener());
        springApplication.run(args);
    }

    //예제 1.8
    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Application Ready Event generated at "
                + new Date(applicationReadyEvent.getTimestamp()));
    }

}
