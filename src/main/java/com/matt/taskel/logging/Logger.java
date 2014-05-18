package com.matt.taskel.logging;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

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
		text = getColor(getColorForLevel(level)) + text;
		System.out.println(text);
	}
	
	public String getColor(Color color)
	{
		return Ansi.ansi().fg(color).toString();
	}
	
	public Color getColorForLevel(Level level)
	{
		switch (level)
		{
			case INFO:
				return Color.WHITE;
			case WARNING:
				return Color.YELLOW;
			case SEVERE:
				return Color.RED;
		}
		return Color.DEFAULT;
	}
}
