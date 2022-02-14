package sp.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sp.core.AppConfig;
import sp.core.member.MemberService;
import sp.core.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFIndTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberSerivce = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanBytype() {
        MemberService memberSerivce = ac.getBean(MemberService.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberSerivce = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByNameX() {
        //MemberSerivce memberSerivce = ac.getBean("xxxxx", MemberServiceImpl.class);
        //Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
        /*assertThrows(NullPointerException.class,()
                -> ac.getBean("xxxxx", MemberSerivce.class));*/
        assertThrows(NoSuchBeanDefinitionException.class,()
                -> ac.getBean("xxxxx", MemberService.class));
    }

}
