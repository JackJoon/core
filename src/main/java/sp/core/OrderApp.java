package sp.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sp.core.member.Grade;
import sp.core.member.Member;
import sp.core.member.MemberService;
import sp.core.order.Order;
import sp.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        /*MemberSerivce memberSerivce = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();*/

        /*OrderService orderService = appConfig.orderService();
        MemberSerivce memberSerivce = appConfig.memberSerivce(); */

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberSerivce = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);


        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberSerivce.join(member);

        Order order = orderService.createOrder(memberId, "itemA",20000);

        System.out.println("order = " + order);
    }
}
