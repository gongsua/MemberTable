package repository;
import domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    //id 회원을 찾는 함수
    //Optional 은 자바 파일 안에 들어 간것 자바안에 들어가 있는 기능
    Optional<Member> findById(long id);
    Optional<Member> findByName(String name);
    //지금까지 저장된 회원 정보를 다 반환한다.
    List<Member> findAll();
}
