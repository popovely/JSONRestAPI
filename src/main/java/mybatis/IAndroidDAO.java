package mybatis;

import java.util.ArrayList;

public interface IAndroidDAO {
	// 회원리스트
	public ArrayList<MemberVO> memberList();
	// 회원로그인정보
	public MemberVO memberLogin(MemberVO memberVO);
}
