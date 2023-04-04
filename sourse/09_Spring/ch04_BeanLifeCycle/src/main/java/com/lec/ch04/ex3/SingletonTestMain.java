package com.lec.ch04.ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingletonTestMain {

	public static void main(String[] args) {
		String location = "classpath:META-INF/ex3/applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		Friend friend1 = ctx.getBean("friend", Friend.class);
		Friend friend2 = ctx.getBean("friend", Friend.class);
		friend1.setFriendNo(100);
		friend1.setName("순신");
		friend1.setTel("0");
		System.out.println("friend1 : " + friend1);
		System.out.println("friend2 : " + friend2);
		Friend friendProto1 = ctx.getBean("friendPrototype", Friend.class);
		Friend friendProto2 = ctx.getBean("friendPrototype", Friend.class);
		friendProto1.setFriendNo(1);
		friendProto1.setName("잭");
		friendProto1.setTel("080");
		System.out.println("friendProto1 : " + friendProto1);
		System.out.println("friendProto2 : " + friendProto2);
	}
}
