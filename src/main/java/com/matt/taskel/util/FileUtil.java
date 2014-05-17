package com.matt.taskel.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.matt.taskel.logging.Level;
import com.matt.taskel.logging.Logger;

public final class FileUtil {
	
	private static final Logger logger = new Logger("FileUtil");
	
	public static final String readFileToEnd(String file)
	{
		InputStream is = FileUtil.class.getResourceAsStream(file);
		if (is == null)
		{
			logger.log(Level.SEVERE, "File Not Found");
			return "";
		}
		String ret = FileUtil.readToEnd(is);
		try
		{
			is.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return ret;
	}
	
	public static final String readToEnd(InputStream reader)
	{
		StringBuilder sb = new StringBuilder();
		try {
			int c;
			while ((c = reader.read()) != -1)
			{
				sb.append((char)c);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static final void writeToFile(String file, String string)
	{
		try
		{
			OutputStream stream = new FileOutputStream(file);
			FileUtil.write(stream, string);
			stream.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static final void write(OutputStream out, String string)
	{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		try
		{
			writer.write(string);
			writer.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
