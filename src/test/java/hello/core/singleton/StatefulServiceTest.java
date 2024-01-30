package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService st1 = ac.getBean(StatefulService.class);
        StatefulService st2 = ac.getBean(StatefulService.class);

        int userAprice = st1.order("userA", 10000); // ThreadA : A사용자 10000원 주문
        int userBprice = st2.order("userB", 20000); // ThreadB : B사용자 20000원 주문

        // ThreadA : 사용자 A 주문 금액 조회
//        int price = st1.getPrice();

        System.out.println(userAprice);
        System.out.println(userBprice);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}