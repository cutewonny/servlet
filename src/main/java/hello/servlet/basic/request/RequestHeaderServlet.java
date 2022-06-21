package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
//요청의 상태를 설정, 출력
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //요청 첫라인
        //요청의 상태를 확인
        printStartLine(req);

        //요청의 헤더 정보 확인
        printHeaders(req);
        
        printHeaderUtil(req);
    }

    private void printHeaderUtil(HttpServletRequest req) {
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("----------start");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName+": "+headerName);
        }
        System.out.println("----------end");

        System.out.println("----------start");
        req.getHeaderNames().asIterator().forEachRemaining(headerName-> System.out.println(headerName+": "+headerName));
        System.out.println("----------end");

        /*
        ----------start
host: host
connection: connection
cache-control: cache-control
sec-ch-ua: sec-ch-ua
sec-ch-ua-mobile: sec-ch-ua-mobile
sec-ch-ua-platform: sec-ch-ua-platform
upgrade-insecure-requests: upgrade-insecure-requests
user-agent: user-agent
accept: accept
sec-fetch-site: sec-fetch-site
sec-fetch-mode: sec-fetch-mode
sec-fetch-user: sec-fetch-user
sec-fetch-dest: sec-fetch-dest
accept-encoding: accept-encoding
accept-language: accept-language
cookie: cookie
----------end

         */

    }

    private void printStartLine(HttpServletRequest req) {//요청의 상태를 출력
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>start");
        System.out.println("req.getMethod()>> "+req.getMethod());
        System.out.println("req.getProtocol()>> "+req.getProtocol());
        System.out.println("req.getScheme()>> "+req.getScheme());
        System.out.println("req.getRequestURL()>> "+req.getRequestURL());
        System.out.println("req.getRequestURI()>> "+req.getRequestURI());
        System.out.println("req.getQueryString()>> "+req.getQueryString());
        System.out.println("req.isSecure()>> "+req.isSecure());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>end");
        /*
        >>>>>>>>>>>>>>>>>>>>>>start
req.getMethod()>> GET
req.getProtocol()>> HTTP/1.1
req.getScheme()>> http
req.getRequestURL()>> http://localhost:8080/request-header
req.getRequestURI()>> /request-header
req.getQueryString()>> a=a
req.isSecure()>> false
>>>>>>>>>>>>>>>>>>>>>>end
         */
    }
}
