package sp.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * FilterType 옵션
 * 기본 값은 FilterType.ANNOTATION
 *
 * ASSIGNBABLE_TYPE 지정한 타입과 자식 타입을 인식해서 동작한다.
 * ASPECTJ AspectJ 패턴 사용
 * REGEX 정규 표현식
 * CUSTOM : TypeFilter이라는 인터페이스를 구현 해서 처리
 */

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();

        ac.getBean("beanB", BeanB.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("beanB", BeanA.class));

    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeCompent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeCompent.class)
    )
    static class ComponentFilterAppConfig{

    }
}
