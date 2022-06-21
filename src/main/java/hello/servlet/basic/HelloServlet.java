package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//서블릿 컨테이너: 톰캣처럼 서블릿을 지원하는 was를 서블릿 컨테이너라고 한다.
//서블릿 컨테이너는 서블릿 객체를 생성, 초기화, 호출, 종료 -> 생명주기 관리
//서블릿 객체: 싱글톤 관리
// 고객의 요청이 올때마다 객체를 계속 생성 -> 비효율
// 최초 로딩 시점, 서블릿 객체 미리 만듦 -> 재활용
// 모든 고객 요청은 동일한 서블릿 객체 -> 인스턴스 접근
// 공유 변수 사용 주의
//jsp도 서블릿으로 변환된다
//멀티 쓰레드 처리 지원: 동시 요청
//http://localhost:8080/hello
//http://localhost:8080/hello?username=hungry
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//재사용한다
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);//req = org.apache.catalina.connector.RequestFacade@749e94c7
        System.out.println("resp = " + resp);//resp = org.apache.catalina.connector.ResponseFacade@4d23cbd8

        //url로 전달된 파라미터의 값 받기
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        
        //응답 메서지: 값 전달해주기
        resp.setContentType("text/plain");// response header : content Type
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello "+username);//httpbody에 값이 넘어간다
//        super.service(req, resp);
    }
}
