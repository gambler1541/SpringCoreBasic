package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTon {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();

        // 요청이 올때마다 새로운 객체를 생성
        // 트래픽의 양에 따라 객체가 생성되고 소멸되는 문제점
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberservice1 = " + memberService1);
        System.out.println("memberservice2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2); // 객체 두개가 다름
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singleTonServiceTest(){

        SingleTonService singleTonService1 = SingleTonService.getInstance();
        SingleTonService singleTonService2 = SingleTonService.getInstance();

        System.out.println("singletonservice1 = " + singleTonService1);
        System.out.println("singletonservice2 = " + singleTonService2);

        Assertions.assertThat(singleTonService1).isSameAs(singleTonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 요청이 올때마다 새로운 객체를 생성
        // 트래픽의 양에 따라 객체가 생성되고 소멸되는 문제점
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberservice1 = " + memberService1);
        System.out.println("memberservice2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2); // 객체 두개가 다름
    }
}
