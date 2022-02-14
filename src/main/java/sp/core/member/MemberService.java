package sp.core.member;

public interface MemberService {

    void join(Member member);

    Member finMember(Long memberId);
}
