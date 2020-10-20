package com.Lab2;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"ApplicationResources.xml");
		StorageService db = (StorageService)ctx.getBean("StorageService");
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag)
		{
			switch(menu(sc))
			{
				case 1:
					db.create();
				break;
				case 2:
					db.read();
				break;
				case 3:
					db.add(createStudent(sc));
				break;
				case 4:
					db.del(sc.nextInt());
				break;
				case 5:
					db.save();
				break;
				case 6:
					db.printDb();
				break;
				case 7:
					flag = false;
				break;
				default:
					System.out.println("Invalid value");
				break;
			}
		}
		
		
	}
	
	public static int menu(Scanner sc)
	{
		
		System.out.println("1 Create db");
		System.out.println("2 Read db from file");
		System.out.println("3 Add to db");
		System.out.println("4 Delete from db");
		System.out.println("5 Save to file");
		System.out.println("6 Print db");
		System.out.println("7 Exit");
		System.out.println("Input Value :");
		
		int read = sc.nextInt();
		return read;
	}
	
	public static Student createStudent(Scanner sc)
	{
		sc.nextLine();
		Student st = new Student();
		System.out.println("Input ID: ");
		st.setID(Integer.parseInt(sc.nextLine()));
		System.out.println("Input name: ");
		st.setName(sc.nextLine());
		System.out.println("Input surname: ");
		st.setSurname(sc.nextLine());
		System.out.println("Input department: ");
		st.setDepartment(sc.nextLine());
		return st;
	}
}
