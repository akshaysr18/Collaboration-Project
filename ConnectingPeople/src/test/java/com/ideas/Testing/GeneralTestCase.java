package com.ideas.Testing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ideas");
		context.refresh();
		
	}

}
