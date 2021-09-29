package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.HotelDAO;
import com.sist.dao.HotelVO;
@Component("mc")
public class MainClass {
	@Autowired
	private HotelDAO hdao;
	


	public static void main(String[] args) {
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<HotelVO> list=mc.hdao.hotelListData();
		for(HotelVO vo:list)
		{
			System.out.println("주소:"+vo.getAddress());
			System.out.println("호텔명:"+vo.getName()+"("+vo.getScore()+")");
		}
		
	}
}
