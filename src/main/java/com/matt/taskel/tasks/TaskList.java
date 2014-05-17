package com.matt.taskel.tasks;

public class TaskList extends Task {
	
	public TaskList()
	{
		super("tasks", "Lists all available tasks");
	}

	@Override
	public Task[] getDependencies()
	{
		return null;
	}
	
	@Override
	public void process(String... args)
	{
		Task[] tasks = TaskManager.toArray();
		
		for (Task task : tasks)
		{
			System.out.println(task.name + "\t\t" + task.description);
		}
	}
	
}
