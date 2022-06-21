<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%--
D:\servlet\src\main\java\hello\servlet\servlet\MemberSaveServlet.java
와 똑같이 만듦
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //req, res 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    //비지니스 로직
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    //parameter로 전달 받은 값을 회원으로 저장한다.
    Member member = new Member(username, age);
    memberRepository.save(member);
    System.out.println("member = " + member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <p>D:\servlet\src\main\webapp\jsp\members\save.jsp</p>
    <li>id=<%=member.getId()%>></li>
    <li>id=<%=member.getUsername()%>></li>
    <li>id=<%=member.getAge()%>></li>
</ul>
<a href="/index.html">메인으로~</a>
</body>
</html>
