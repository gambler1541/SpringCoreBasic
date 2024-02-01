package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// Test용으로 만든 Configuration Auto Scan 하는 것 제외
// @Configuration Annotation에도 Component가 붙어있기 때문에 AppConfig가 자동으로 빈으로 등록 됨
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


}
