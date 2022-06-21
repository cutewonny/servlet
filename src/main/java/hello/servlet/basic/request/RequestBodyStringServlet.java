package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 포스트맨
        // http://localhost:8080/request-body-string
        // 바디에 값을 전달 해볼까
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("MessageBody>>> "+messageBody);
        resp.getWriter().write("/request-body-string           RequestBodyStringServlet done");
        resp.getWriter().write("요청시 바디에 전달된 값을 응답으로 보내보자: "+messageBody);
        ///request-body-string           RequestBodyStringServlet done??? ??? ??? ?? ???? ????: ??? ?? ?????
        //한국어가 깨진다
    }
}
