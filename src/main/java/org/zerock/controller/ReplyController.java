package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController  // Rest로 응답 함!! -> view(jsp)가 아닌 json or xml로 나옴
@RequestMapping("/replies")    // http://localhost:80/replies//????
@Log4j2
@AllArgsConstructor				// new ReplyController(ReplyService);
public class ReplyController { // Rest방식의 컨트롤러로 구현 + Ajax(프론트) 처리 함.
	
	// private BoardService bServices;
	private ReplyService service;
	
	@PostMapping(value = "/new", consumes="application/json", produces = MediaType.TEXT_PLAIN_VALUE) // 입력값은 json으로							 
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		
		log.info("ReplyVO 객체 json 입력 값  : " + vo);  // 파라미터로 넘어온 값 출력 테스트
		
		int insertCount = service.register(vo); // sql처리 후에 결과값이 1 또는 0이 나옴
		
		log.info("서비스 + 매퍼 처리 결과 : " + insertCount);
		
		return insertCount==1? new ResponseEntity<>("success", HttpStatus.OK)  // 200 정상
							:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500서버 오류
				//삼항 연산자나 if로 리턴을 할 때 정상 처리인지 오류값인지를 전달 해야 한다.
	}
	
	// http://localhost:80/replies/pages/11/1 -> xml
	// http://localhost:80/replies/pages/11/1.json -> json으로 출력
	@GetMapping(value = "/pages/{bno}/{page}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno){
		
		log.info("ReplyController.getList()메서드 실행");
		log.info("페이지 번호 : " + page);
		log.info("찾을 번호 : " + bno);
		Criteria cri = new Criteria(page, 10);  // 현재페이지와 리스트 개수를 전달.
		log.info("Criteria : " + cri);
				
		return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
	}// 200 정상
		//[{"rno":3,"bno":11,"reply":"댓글9","replyer":" kkw","replyDate":1724723568000,"updateDate":1724723568000},{"rno":4,"bno":11,"reply":"댓글8","replyer":" kkw","replyDate":1724723569000,"updateDate":1724723569000},{"rno":5,"bno":11,"reply":"댓글7","replyer":" kkw","replyDate":1724723570000,"updateDate":1724723570000},{"rno":6,"bno":11,"reply":"댓글6","replyer":" kkw","replyDate":1724723571000,"updateDate":1724723571000},{"rno":7,"bno":11,"reply":"댓글9","replyer":" kkw","replyDate":1724723579000,"updateDate":1724723579000},{"rno":8,"bno":11,"reply":"댓글6","replyer":" kkw","replyDate":1724723581000,"updateDate":1724723581000},{"rno":9,"bno":11,"reply":"댓글10","replyer":" kkw","replyDate":1724723584000,"updateDate":1724723584000},{"rno":10,"bno":11,"reply":"매퍼로 수정 테스트","replyer":" kkw","replyDate":1724723587000,"updateDate":1724728039000},{"rno":11,"bno":11,"reply":"댓글11","replyer":" kkw","replyDate":1724723590000,"updateDate":1724723590000},{"rno":12,"bno":11,"reply":"댓글8","replyer":" kkw","replyDate":1724723593000,"updateDate":1724723593000},{"rno":13,"bno":11,"reply":"댓글11","replyer":" kkw","replyDate":1724723661000,"updateDate":1724723661000},{"rno":22,"bno":11,"reply":"매퍼댓글테스트","replyer":"매퍼 kkw","replyDate":1724725010000,"updateDate":1724725010000},{"rno":23,"bno":11,"reply":"postmanTest","replyer":"kkw","replyDate":1724732593000,"updateDate":1724732593000}]
		
		// http://localhost:80/replies/4
	@GetMapping(value="/{rno}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
			
		log.info("ReplyController.get()메서드 실행./ 찾을 rno : " + rno);
			
			return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
		
	}
	
	// http://localhost:80/repies/4
	@DeleteMapping(value="/{rno}", produces= {MediaType.TEXT_PLAIN_VALUE})  // Json으로 나올 필요가 없음
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		
		log.info("ReplyController.remove()메서드 실행/ 삭제할 rno : " + rno);
		
		return service.remove(rno)==1? new ResponseEntity<>("success", HttpStatus.OK)  // 200 정상
									:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500서버 오류
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, 
								value="/{rno}",
								consumes ="application/json", produces=MediaType.TEXT_PLAIN_VALUE
			)
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
								//		이미 폼(form)에 있는 값,      수정할 번호
		
		
		vo.setRno(rno);   // 이미 가지고 있는 객체의 rno 값을 넣음.
		
		log.info("ReplyController.modify()메서드 실행/ 수정할 rno : " + rno);
		
		log.info("수정할 객체 : " + vo);
		
		return service.modify(vo)== 1
				? new ResponseEntity<>("success", HttpStatus.OK)  // 200 정상
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500서버 오류
	}
	
	
	
}
