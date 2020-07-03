package com.and.spring;

public class Cook {
	//프라이팬을 보유하자
	private Pan pan;
	
	//Has a관계에 있는
	//객체를 직접 생성하려고 하지말고, 외부로부터 객체를 주입받기 위해서는
	//생성자나 setter를 준비해놓아야 한다!!
	public Cook(Pan pan) {
		this.pan=pan;
	}
	//setter 주입!!
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	//요리사가 일한다!!
	public void work() {
		pan.heat();
	}
}
