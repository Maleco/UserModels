package org.dariochat.app;

import java.io.*;
import java.util.*;

public class Data
{
	Vector<Sampledario> samples;
	PrintStream outfile;
	
	Data ()
	{
		samples = new Vector<Sampledario>();
		outfile = Utilities.uniqueOutputFile ("output");
	}

	int size ()
	{ 
		return samples.size();
	}
	
	Sampledario get (int i)
	{
		return samples.elementAt(i);
	}

	void add (Sampledario s)
	{
		samples.add (s);
		outfile.println (s);
		System.out.println (s);
	}
}
