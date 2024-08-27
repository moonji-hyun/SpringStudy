package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria { // pageNum과 amount값을 같이 전달하는 용도
	private int pageNum;
	private int amount;
	
	public Criteria() { // 생성자를 통해서 기본값을 1페이지, 10개로 지정
		this(1,10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}	
}
