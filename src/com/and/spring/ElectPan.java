package com.and.spring;

public class ElectPan implements Pan{

	@Override
	public void heat() {
		System.out.println("전기로 요리를 데워요~~");
	}

}
