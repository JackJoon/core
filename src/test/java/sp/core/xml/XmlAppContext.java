package sp.core.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import sp.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    @Test
    void xmlAppContext(){
    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    MemberService memberSerivce = ac.getBean("memberSerivce", MemberService.class);

    assertThat(memberSerivce).isInstanceOf(MemberService.class);
    }

}
