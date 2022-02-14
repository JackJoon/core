package sp.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sp.core.discount.DiscountPolicy;
import sp.core.discount.FixDiscountPolicy;
import sp.core.member.Member;
import sp.core.member.MemberRepository;
import sp.core.member.MemoryMemberRepository;

@Component
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
    
    /**
     * 필드 주입
     * 외부에서 변경이 불가능(사용하지 말자 단 테스트 코드에서는 가능)
     */
    @Autowired private final MemberRepository memberRepository;
    @Autowired private final DiscountPolicy discountPolicy;


    /**
     * 수정자 주입
     * 생성자 호출 시점에 의존관계 주입한다.
     * 수정자 주입은 순서를 보장하지 않는다.(선택 변경 가능 성 이있는 )
     * @param discountPolicy
     */
    /*public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }

    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }*/

    /**
     * 생성자가 하나 있을 때는 AutoWired 어노테이션도 없어도, 스프링 빈 컨테이너에서 자동으로 의존 관계 주입 해 준다.(불변, 
     * 
     * @param memberRepository
     * @param discountPolicy
     */
    @Autowired
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
