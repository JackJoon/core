package sp.core.order;

import sp.core.discount.DiscountPolicy;
import sp.core.discount.FixDiscountPolicy;
import sp.core.member.Member;
import sp.core.member.MemberRepository;
import sp.core.member.MemoryMemberRepository;

public class OrderServiceImpl  implements  OrderService{

    /*
    private final MemberRepository memberRepository = new MemoryMemberRepository();   //의존 관계 주입
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();            //의존 관계 주입
    */

    /**
     * 인터페이스에만 의존
     * IoC 컨테이너
     * DI 컨테이너
     */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);


        return new Order(memberId,itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
