package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //응답 상태
        res.setStatus(HttpServletResponse.SC_OK);

        //응답 헤더
        res.setHeader("Content-Type", "text/plain;charset=utf-8");
        //캐시 사용안함
        res.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        res.setHeader("Pragma","no-cache");
        res.setHeader("my-header", "hello my header~");

        // 헤더 현의 메서드
        //content(res);
        //cookie(res);
        //redirect(res);

        // 요청자 body 출력 : 메시지 바디
        PrintWriter writer = res.getWriter();
        writer.println("/response-header            responseHeaderServlet");


    }

    private void redirect(HttpServletResponse res) throws IOException {
//        res.setStatus(HttpServletResponse.SC_FOUND);
//        res.setHeader("Location","/basic/hello-form.html");
        res.sendRedirect("/basic/hello-form.html");
    }

    private void cookie(HttpServletResponse res) {
//        res.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);//600초 = 10분

        res.addCookie(cookie);
    }

    private void content(HttpServletResponse res) {
        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
    }
}
