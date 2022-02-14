package sp.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefuleServiceTest {

    @Test
    void statefulServiceSingelton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefuleService statefuleService1 = ac.getBean(StatefuleService.class);
        StatefuleService statefuleService2 = ac.getBean(StatefuleService.class);

        //ThreadA : A사용자 10000원 주문
        statefuleService1.order("userA", 10000);

        //ThreadA : B사용자 10000원 주문
        statefuleService2.order("userB", 20000);


        //ThreaA: 사용자 A 주문 금액 조회
        int price = statefuleService1.getPrice();

        System.out.println("price = " + price);


        System.out.println("statefuleService1 " + statefuleService1);
        System.out.println("statefuleService2 " + statefuleService2);

        Assertions.assertThat(statefuleService1.getPrice()).isEqualTo(20000);
    }


    static class  TestConfig {

        @Bean
        public StatefuleService statefuleService() {
            return new StatefuleService();
        }
    }
}
