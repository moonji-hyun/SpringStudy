package net.kkwcloud.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {

	//필드
	private List<SampleDTO> list;
	
	//생성자
	public SampleDTOList() {
		list = new ArrayList<>();
		
		// SampleDTOList 객체를 생성하면 List<SampleDTO> list =  new ArrayList<SampleDTO>();
	}
	
	//메서드
}
