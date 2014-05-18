package com.matt.taskel.tasks;

import com.matt.taskel.logging.Level;
import com.matt.taskel.util.FileUtil;

public class SetupForge extends Task {

	public SetupForge()
	{
		super("setupforge", "Creates a build.gradle file");
	}
	
	@Override
	public String[] getDependencies()
	{
		return null;
	}

	@Override
	public boolean process(String... args)
	{
		String contents = FileUtil.readFileToEnd("/files/forge/build.gradle");
		if (!contents.isEmpty())
		{
			FileUtil.writeToFile("./build.gradle", contents);
			this.logger.log(Level.INFO, "Wrote default build.gradle");
			return true;
		} else {
			return false;
		}
	}

}
