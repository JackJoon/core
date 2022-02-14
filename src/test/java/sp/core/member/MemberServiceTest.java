package sp.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sp.core.AppConfig;

public class MemberServiceTest {


    //MemberSerivce memberSerivce = new MemberServiceImpl();

    MemberService memberSerivce;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        MemberService memberSerivce = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when

        memberSerivce.join(member);
        Member finMdember = memberSerivce.finMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(finMdember);
    }
}
