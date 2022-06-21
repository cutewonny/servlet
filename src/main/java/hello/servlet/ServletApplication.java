package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//1강 스프링 부트 서블릿 환경 구성
@ServletComponentScan //서블릿 자동등록: 내 패키지 + 하위 패키지를 뒤져서 서블릿을 찾는다 -> 서블릿 다 찾음
@SpringBootApplication
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

    @Bean
    ViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }
}
