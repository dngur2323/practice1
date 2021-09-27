package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.HotelDAO;
import com.sist.dao.HotelVO;

public class MainClass {
	private HotelDAO dao;
	
	
	public void setDao(HotelDAO dao) {
		this.dao = dao;
	}


	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("�ּҸ� �Է��Ͻʽÿ�:");
		String address=scan.next();
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<HotelVO> list=mc.dao.hotelListData(address);
		for(HotelVO vo:list)
		{
			System.out.println("�ּ�:"+vo.getAddress());
			System.out.println("ȣ�ڸ�:"+vo.getName()+"("+vo.getScore()+")");
		}
	}
}
