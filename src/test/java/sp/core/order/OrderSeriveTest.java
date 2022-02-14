package sp.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sp.core.AppConfig;
import sp.core.member.Grade;
import sp.core.member.Member;
import sp.core.member.MemberService;

public class OrderSeriveTest {

    /*MemberSerivce memberSerivce = new MemberServiceImpl();
    OrderService orderSerivice = new OrderServiceImpl();*/

    MemberService memberSerivce;
    OrderService orderSerivice;


    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        MemberService memberSerivce = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberSerivce.join(member);


        Order order = orderSerivice.createOrder(memberId,"itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000    );
    }
}
