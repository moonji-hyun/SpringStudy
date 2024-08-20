package org.zerock.mapper; 		// db와 영속성을 가진 패키지

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	// interface로 선언하는 이유는 추상메서드와 xml을 결합하여 구현 클래스를 사용하는 마이바티스이기 때문에
	// xml을 생성할 때는 resources안에 폴더를 계층별로 만들고 파일명을 인터페이스와 같은 xml을 생성해야 함.
	
	// 인터페이스에 자체적인 추상메서드를 활용
//	@Select("select * from tbl_board where bno > 0")  // where bno > 0 조건을 거는 이유 -> bno가 pk라서 인덱싱이 되어 있어 빠름.
	public List<BoardVO> getList();  // 인터페이스안에는 추상메서드임. -> getlist()을 호출하면 select문이 돈다.
	// 리턴은 List<BoardVO> 임으로 배열 안쪽에 객체가 BoardVO로 완성 됨.
	
	
	// board 삽입용 코드
	public void insert(BoardVO board);  // mapper xml을 (insert에)갔다가 옴
	
	// 삽입할 번호를 먼저 파악후 게시물을 등록
	public void insertSelectKey(BoardVO board); // mapper xml을 (insertSelectKey에)갔다가 옴
	
	
	// 게시물의 번호를 받아 객체를 출력한다.
	public BoardVO read(Long bno);  // 게시물의 번호를 받아 객체로 출력, 게시물의 제목은 read
	
	// 게시물의 번호를 받아 객체를 수정한다.
	public int update(BoardVO boardVO);
	
	// 게시물의 번호를 받아 객체를 삭제한다.
	public int delete(Long bno);
	
	
}
