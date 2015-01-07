package org.dariochat.app;

import java.io.*;
import java.util.*;

public class Data
{
	Vector<Sample> samples;
	PrintStream outfile;
	
	Data ()
	{
		samples = new Vector<Sample>();
		outfile = Utilities.uniqueOutputFile ("output");
	}

	int size ()
	{ 
		return samples.size();
	}
	
	Sample get (int i)
	{
		return samples.elementAt(i);
	}

	void add (Sample s)
	{
		samples.add (s);
		outfile.println (s);
		System.out.println (s);
	}
}
