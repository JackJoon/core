package sp.core.discount;

import sp.core.member.Grade;
import sp.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private  int discountFixAmount = 1000; // 100ㅇ0원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
