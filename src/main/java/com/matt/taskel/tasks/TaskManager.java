package com.matt.taskel.tasks;

import java.util.HashMap;

public final class TaskManager {
	
	private static final HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	public static final void addTask(Task task)
	{
		tasks.put(task.name, task);
	}
	
	public static final Task getTask(String task)
	{
		return tasks.get(task);
	}
	
	public static final boolean hasTask(String task)
	{
		return tasks.containsKey(task);
	}
	
	public static final int numTasks()
	{
		return tasks.size();
	}
	
	public static final Task[] toArray()
	{
		Task[] res = new Task[numTasks()];
		tasks.values().toArray(res);
		return res;
	}
	
	public static final void initialize()
	{
		TaskManager.addTask(new TaskList());
		TaskManager.addTask(new SetupForge());
	}
	
}
