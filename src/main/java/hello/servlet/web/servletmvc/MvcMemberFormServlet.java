package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//http://localhost:8080/servlet-mvc/members/new-form
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // /WEB-INF: 이 경로 안에 jsp가 있으면 외부에서 직접 jsp를 호출 할 수 없다. 컨트롤러를 통해서만 호출 가능.
        String viewPath = "/WEB-INF/views/new-form.jsp";
        
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        // 컨트롤러에서 뷰로 이동할때 쓴다: getRequestDispatcher : 경로로 이동할거야
        
        dispatcher.forward(req, res);//서블릿에서 jsp를 호출
        // 다른 서블릿이나 jsp로 이동할 수 있다. 서버 내부에서 다시 호출이 발생한다

        //redirect VS forward
        //리다이렉트: 실제 클라이언트에 응답을 줬다가, 클라이언트가 리다이렉트 경로로 다시 요청한다.
        //클라이언트가 인지 할수 있고, url경로도 변경된다.
        //포워드: 서버 내부에서 일어나는 호출, 클라이언트가 인지 못한다.

    }
}
