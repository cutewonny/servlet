<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%--
  D:\servlet\src\main\java\hello\servlet\servlet\MemberListServlet.java
  서블릿과 jsp의 한계
  두개를 동시에 하는 기분.. 유지보수가 어렵다
  1) 서블릿
  java에 html을 직접 한줄 입력하다보니 귀찮고 지저분하고 복잡하다.

  2)jsp : 뷰 템플릿
  jsp는 뷰를 생성한s html을 깔끔하지만. 중간에 자바를 적용한다.
  상위: (회원 저장)비지니스 코드의 노출
  하위: html

  3) mvc 패턴 등장
  비지니스 로직은 다른 곳에서 처리
  jsp는 view만 그린다
  C: http 요청을 받아서 파라미터를 검증하고, 비즈니스 로직을 실행.
     뷰에 전달할 결과 데이터를 조회해서 모델에 담는다.
  S: 컨트롤에 몰리는 것을 방지.
     비지니스 로직이 있는 서비스를 호출하는 담당
  M: 뷰에 출력할 데이터를 담는다.
  V: 화면 랜더링에 집중.
     모델에 담겨있는 데이터를 가지고 화면을 그린다. html을 생성한다.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> all = memberRepository.findAll();//회원 전체 불러옴
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for(Member member: all){
            out.write("<tr>");
            out.write("<td>"+member.getId()+"</td>");
            out.write("<td>"+member.getUsername()+"</td>");
            out.write("<td>"+member.getAge()+"</td>");
            out.write("</tr>");
        }
    %>
    </tbody>
</table>


</body>
</html>
