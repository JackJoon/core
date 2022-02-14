package sp.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * CompentScan : @Componet 어노케이션 붙은 클래스를 자동으로 Bean 등록
 *  exludeFilters = @ComponentScan.Filter type으로 지정된 타입을 컴포넌트 스캔 대상에서 제외 시킨다.
 *  basePackages = 탐색할 패키지의 시작 위치를 지정. 이 패키지를 포함해서 하위 패키지를 모두 탐색
 *  basePAckageClass = 지정한 클래스의 패키지를 탐색 시작 위로 지정한다.
 *      만약 지정하지 않으면 @CompentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
 *      프로젝트 시작 루트 sp.core에 지정한다.
 *
 * 컴포넌트 스캔은 @cCompent 뿐만 아니라 아래의 추가로 대상에 포함된다.
 * @Compent
 * @Controller 스프링 MVC 컨트롤러로 인식
 * @Service 특별한 처리를 하지 않는다. 대신 개발자들이 핵심 비지니스 로직이 여기에 있겠구나 라고 비지느시 계층을 인식하는데 도움
 * @Repository 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다.
 * @Configuration 스프링 정보를 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리를 한다.
 */
@Configuration
@ComponentScan(
        basePackages = "sp.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
