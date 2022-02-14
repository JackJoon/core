package sp.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sp.core.discount.DiscountPolicy;
import sp.core.discount.RateDiscountPolicy;
import sp.core.member.MemberService;
import sp.core.member.MemberServiceImpl;
import sp.core.member.MemoryMemberRepository;
import sp.core.order.OrderService;
import sp.core.order.OrderServiceImpl;

/**
 * 정적인 클래스 관계
 */
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //생성자 주입(Injection)[Dependency Injection]
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());  //생성자 주입(Injection)[Dependency Injection]
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
