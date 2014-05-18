package com.matt.taskel.logging;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

public class Logger {

	public void log(Level level, String msg)
	{
		String text = "[" + this.getColor(this.getColorForLevel(level)) + level.name() + this.getColor(Color.WHITE) + "]: " + this.getColor(Color.WHITE) + msg;
		System.out.println(text);
		System.out.print(this.getColor(Color.WHITE));
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
				return Color.GREEN;
			case WARNING:
				return Color.YELLOW;
			case SEVERE:
				return Color.RED;
		}
		return Color.DEFAULT;
	}
}
