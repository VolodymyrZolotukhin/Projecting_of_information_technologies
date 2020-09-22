package demo;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demoTest {
	
	IHello hello;
	
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationResources.xml");
		hello = (IHello)ctx.getBean("hello");
	}
	
	@Test
	public void test() {
		String expected = "Say Hello World";
		String result = hello.sayHello();
		Assert.assertEquals(expected, result);
	}
}
