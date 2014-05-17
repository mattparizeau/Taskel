package com.matt.taskel.tasks;

import com.matt.taskel.logging.Logger;

public abstract class Task {
	
	protected final Logger logger;
	
	public final String name;
	public final String description;
	
	public Task(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.logger = new Logger(name);
	}
	
	public abstract Task[] getDependencies();
	public abstract void process(String... args);
	
}
