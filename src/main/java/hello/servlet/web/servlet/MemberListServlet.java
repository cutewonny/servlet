package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// 전체 회원을 불러와서 보여주기
@WebServlet(name = "MemberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
    
    //싱글톤 객체 불러옴
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Member> all = memberRepository.findAll();//회원 전체 불러옴
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");

        PrintWriter writer = res.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "전체 회원 목록 조회 성공-- 서블릿이랑 값 바꾸기 귀찮아 값 고정\n" +
                "\n" +
                "<table>\n" +
                "    <thead>\n" +
                "    <th>id</th>\n" +
                "    <th>username</th>\n" +
                "    <th>age</th>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>1</td>\n" +
                "        <td>유저이름</td>\n" +
                "        <td>14</td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "\n" +
                "\n" +
                "<ul>\n" +
                "    <li>id=     member.getId()</li>\n" +
                "    <li>username=    member.getUsername() </li>\n" +
                "    <li>age= member.getAge()</li>\n" +
                "</ul>\n" +
                "\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }
}
