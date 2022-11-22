package com.anno;

import java.lang.reflect.Method;

public class AnnoTestMain {

	@MyAnnotation
	public static void print() {
		System.out.println("Printing.");
	}
	public static void main(String[] args) throws Exception {
		
//		AnnoTestMain at = new AnnoTestMain();
//		at.getClass();
		
		Method m = AnnoTestMain.class.getMethod("print");
		// 이 메소드가 없을수도 있으니 에러가 뜨는것임.
		// m : 저 메소드에 대한 정보만 가져온것임(메소드 자체가 아님)
		
		if(m.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation method = m.getAnnotation(MyAnnotation.class);
			for(int i = 0;i<method.count();i++) {
				print();
			}
//			System.out.println("Anno");
		}else {
			print();
		}
		// m이 저 메소드를 가지고 있느냐?
		
	}

}
