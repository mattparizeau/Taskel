package com.matt.taskel.logging;

public class Logger {
	
	private String name;
	
	public Logger()
	{
		this("");
	}
	
	public Logger(String name)
	{
		this.name = name;
	}
	
	public void log(Level level, String msg)
	{
		String name = "";
		if (!this.name.isEmpty())
			name = "|" + this.name;
		String text = "[Taskel" + name + "]-[" + level.name() + "]: " + msg;
		System.out.println(text);
	}
}
