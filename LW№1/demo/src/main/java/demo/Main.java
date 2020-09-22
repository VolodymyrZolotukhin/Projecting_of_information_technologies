package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"ApplicationResources.xml");
		IHello hello = (IHello)ctx.getBean("hello");
		System.out.println(hello.sayHello());
	}

}
