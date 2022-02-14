package sp.core.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sp.core.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        /* As-Is
        AppConfig appConfig = new AppConfig();
        MemberSerivce memberSerivce = appConfig.memberSerivce();
        */

        /**
         *ApplicationContext(스프링컨테이너)
         * 어노테이션으로 선언한 것들은 스프링 컨테이너에 관리 해준다.
         */

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberSerivce = ac.getBean("memberSerivce", MemberService.class);//"메서드 명", "반환 타입"

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberSerivce.join(member);

        Member findMember = memberSerivce.finMember(1L);

        System.out.println("member = " + member.getName() );
        System.out.println("find Member = " + findMember.getName());

    }
}
