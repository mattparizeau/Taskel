package com.matt.taskel;

import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

import com.matt.taskel.logging.Level;
import com.matt.taskel.logging.Logger;
import com.matt.taskel.tasks.Task;
import com.matt.taskel.tasks.TaskManager;

public class Taskel {

	public static final void main(String... args)
	{
		AnsiConsole.systemInstall();
		Taskel taskel = new Taskel(args);
		taskel.process();
	}

	private static Logger logger = new Logger();
	private Task task;
	private String[] args;

	public Taskel(String... args)
	{
		System.out.println(logger.getColor(Color.GREEN) + "============= " + logger.getColor(Color.YELLOW) + "Taskel" + logger.getColor(Color.WHITE) + logger.getColor(Color.GREEN) + " =============" + logger.getColor(Color.WHITE));
		System.out.println(logger.getColor(Color.GREEN) + "== " + logger.getColor(Color.YELLOW) + "Created by Matthieu Parizeau" + logger.getColor(Color.WHITE) + logger.getColor(Color.GREEN) + " ==" + logger.getColor(Color.WHITE));
		System.out.println(logger.getColor(Color.GREEN) + "==================================" + logger.getColor(Color.WHITE));
		System.out.println();
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
			this.args[i - 1] = args[i];
		}
		logger.log(Level.INFO, "Initialized");
	}

	public void process()
	{
		logger.log(Level.INFO, "Processing Task: " + this.task.name);
		System.out.println(logger.getColor(Color.GREEN) + "==================================" + logger.getColor(Color.WHITE));
		boolean success = this.task.process(this.args);
		System.out.println(logger.getColor(Color.GREEN) + "==================================" + logger.getColor(Color.WHITE));
		if (success)
			logger.log(Level.INFO, "All tasks completed successfully");
		else
			logger.log(Level.WARNING, "Not all tasks completed successfully");
	}

}
