package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HelloData {
    //json 으로 데이터를 외부에서 서버로 받기
    private String username;
    private int age;
}
