package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 * 전달 받은 Member객체를 저장, 조회 한다 == DB에 접근한다
 */
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();//static이라 하나만 생성됨
    private static long sequece =0L;//아이디가 하나씩 증가

    //싱글톤 : 객체 하나만을 보장한다 : 객체 생성
    private static final MemberRepository instance = new MemberRepository();
    
    //싱글톤 : 생성자 막기-> private 생성자 : 아무나 생성 못하게 함
    private MemberRepository(){

    }

    //무조건 이걸로 조회함 -> 싱글톤 객체 불러옴
    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member){
        member.setId(++sequece);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();;
    }
}
