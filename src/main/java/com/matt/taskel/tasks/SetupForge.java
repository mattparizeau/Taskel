package com.matt.taskel.tasks;

import com.matt.taskel.logging.Level;
import com.matt.taskel.util.FileUtil;


public class SetupForge extends Task {
	
	public SetupForge()
	{
		super("setupforge", "Creates a build.gradle file");
	}

	@Override
	public Task[] getDependencies()
	{
		return null;
	}
	
	@Override
	public void process(String... args)
	{
		String contents = FileUtil.readFileToEnd("/files/forge/build.gradle");
		if (!contents.isEmpty())
		{
			FileUtil.writeToFile("./build.gradle", contents);
			logger.log(Level.INFO, "Wrote default build.gradle");
		}
	}
	
}
