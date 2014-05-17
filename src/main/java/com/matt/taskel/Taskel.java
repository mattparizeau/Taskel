package com.matt.taskel;

import com.matt.taskel.logging.Level;
import com.matt.taskel.logging.Logger;
import com.matt.taskel.tasks.Task;
import com.matt.taskel.tasks.TaskManager;

public class Taskel {
	
	public static final void main(String... args)
	{
		Taskel taskel = new Taskel(args);
		taskel.process();
	}
	
	private static Logger logger = new Logger();
	private Task task;
	private String[] args;
	
	public Taskel(String... args)
	{
		logger.log(Level.INFO, "Initializing...");
		TaskManager.initialize();
		if (args.length == 0)
		{
			logger.log(Level.SEVERE, "No tasks specified");
			System.exit(0);
		}
		String task = args[0];
		if (TaskManager.hasTask(task))
		{
			this.task = TaskManager.getTask(task);
		} else
		{
			logger.log(Level.SEVERE, "Failed to initialize - task '" + task + "' does not exist");
			System.exit(0);
		}
		this.args = new String[args.length - 1];
		for (int i = 1; i < args.length; i++)
		{
			this.args[i-1] = args[i];
		}
		logger.log(Level.INFO, "Initialized");
	}
	
	public void process()
	{
		logger.log(Level.INFO, "Processing Task: " + task.name);
		System.out.println("==================================");
		task.process(args);
		System.out.println("==================================");
		logger.log(Level.INFO, "All tasks completed successfully");
	}
	
}
