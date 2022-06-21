<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--    <li>id=<%=member.getId()%>></li>--%>
<%--    <li>id=<%=member.getUsername()%>></li>--%>
<%--    <li>id=<%=member.getAge()%>></li>--%>
    <p>urlPatterns = "/servlet-mvc/members/new-form"</p>
    <p>urlPatterns = "/servlet-mvc/members/save"</p>

    <p>D:\servlet\src\main\webapp\WEB-INF\views\save-result.jsp</p>


    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
    <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
    <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
    <div>
        <h4>mvc 컨트롤러 단점</h4>
        <h5>포워드 중복</h5>
        <P>view로 이동하는 코드가 항상 중복 호출된다. 메서드로 공통화 해도 되지만,
        해당 메서드도 항상 직접 호출해야한다</P>

        <h5>viewPath 중복</h5>
        <p>prefix: /WEB-INF/views/</p>
        <p>suffix: .jsp</p>
        <p>jsp가 아니라면 suffix를 전체 코드를 다 변경해야 한다</p>

        <h5>사용하지 않는 코드</h5>
        <p>HttpServletRespose res 를 사용지 않는다. 그런데도 작성해야한다</p>

        <h5>공통처리가 어렵다</h5>
        <p>기능이 복합해질 수록 컨트롤러에서 공통으로 처리해야 하는 부분이 점점 증가한다</p>
        <p>단순히 공통 기능을 메서드로 뽑아도 매번 메서드를 항상 호출해야한다-> 호출 중복</p>

        <h4>공통 처리가 어렵다</h4>
        <p>해결법: 컨트롤러 호출 전에 먼저 공통 기능을 처리해야 한다.== 입구를 하나로!`</p>
        <p>프론트 컨트롤러 패턴을 도입하면 이런 문제를 깔끔하게 해결할 수 있다.</p>
    </div>
</ul>
<a href="/index.html">메인으로~</a>
</body>
</html>
