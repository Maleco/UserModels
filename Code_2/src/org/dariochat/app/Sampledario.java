package org.dariochat.app;

public class Sampledario
{
	double time;
	String window;
	String event;
	String extra;
	
	Sampledario (double time, String window, String event, String extra)
	{
		this.time = time;
		this.window = window;
		this.event = event;
		this.extra = extra;
	}
	
	public String toString ()
	{
		return Utilities.df3.format(time) + "\t" + window + "\t" + event + "\t\"" + extra + "\"";
	}
}
