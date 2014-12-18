package org.dariochat.app;

public class Products
{
	static String getBrandModel (int index)
	{
		return products[index][0] + " " + products[index][1] + " " + products[index][2];
	}
	
	static String getPrice (int index)
	{
		return products[index][3];
	}
	
	static String getFullString (int index)
	{
		//return products[index][0] + " " + products[index][1] + " " + products[index][2] + " " + products[index][3];
		return "Question" + 1;
	}
	
	static String products[][] =
	{
		// Intro Questions
		
		// Part 1 Questions
		
		// Part 2 Questions
		{"photocamera", "Woksan", "B-40", "$91.99"},
		{"photocamera", "Woksan", "C-78", "$70.99"},
		{"photocamera", "Woksan", "H-44", "$80.99"},
		{"photocamera", "Woksan", "K-44", "$67.99"},
		{"photocamera", "Woksan", "N-29", "$97.99"},
		{"photocamera", "Woksan", "P-70", "$62.99"},
		{"photocamera", "Woksan", "P-75", "$72.99"},
		{"photocamera", "Woksan", "V-68", "$65.99"},
		{"photocamera", "Woksan", "W-40", "$63.99"},
		{"photocamera", "Woksan", "Z-85", "$84.99"},
		{"photocamera", "Okidan", "A-70", "$65.99"},
		{"photocamera", "Okidan", "G-92", "$61.99"},
		{"photocamera", "Okidan", "J-21", "$91.99"},
		{"photocamera", "Okidan", "J-59", "$73.99"},
		{"photocamera", "Okidan", "K-68", "$52.99"},
		{"photocamera", "Okidan", "N-98", "$63.99"},
		{"photocamera", "Okidan", "O-60", "$96.99"},
		{"photocamera", "Okidan", "S-91", "$77.99"},
		{"photocamera", "Okidan", "U-23", "$71.99"},
		{"photocamera", "Okidan", "W-40", "$63.99"},
		{"photocamera", "Beta", "B-58", "$77.99"},
		{"photocamera", "Beta", "D-65", "$84.99"},
		{"photocamera", "Beta", "D-78", "$75.99"},
		{"photocamera", "Beta", "G-52", "$61.99"},
		{"photocamera", "Beta", "J-83", "$65.99"},
		{"photocamera", "Beta", "K-23", "$71.99"},
		{"photocamera", "Beta", "Q-20", "$56.99"},
		{"photocamera", "Beta", "S-30", "$88.99"},
		{"photocamera", "Beta", "W-54", "$83.99"},
		{"photocamera", "Beta", "X-11", "$65.99"},
		{"mp3-player", "Inkel", "D-86", "$59.99"},
		{"mp3-player", "Inkel", "E-64", "$61.99"},
		{"mp3-player", "Inkel", "F-86", "$97.99"},
		{"mp3-player", "Inkel", "G-13", "$68.99"},
		{"mp3-player", "Inkel", "K-72", "$79.99"},
		{"mp3-player", "Inkel", "L-69", "$60.99"},
		{"mp3-player", "Inkel", "M-61", "$52.99"},
		{"mp3-player", "Inkel", "O-70", "$97.99"},
		{"mp3-player", "Inkel", "R-69", "$58.99"},
		{"mp3-player", "Inkel", "W-44", "$89.99"},
		{"mp3-player", "Huma", "G-73", "$75.99"},
		{"mp3-player", "Huma", "I-80", "$64.99"},
		{"mp3-player", "Huma", "I-86", "$78.99"},
		{"mp3-player", "Huma", "J-14", "$85.99"},
		{"mp3-player", "Huma", "K-52", "$62.99"},
		{"mp3-player", "Huma", "O-80", "$75.99"},
		{"mp3-player", "Huma", "O-91", "$60.99"},
		{"mp3-player", "Huma", "V-99", "$63.99"},
		{"mp3-player", "Huma", "X-46", "$81.99"},
		{"mp3-player", "Huma", "Y-21", "$99.99"},
		{"mp3-player", "Killor", "G-32", "$71.99"},
		{"mp3-player", "Killor", "L-16", "$74.99"},
		{"mp3-player", "Killor", "M-75", "$85.99"},
		{"mp3-player", "Killor", "N-21", "$87.99"},
		{"mp3-player", "Killor", "O-10", "$51.99"},
		{"mp3-player", "Killor", "O-66", "$58.99"},
		{"mp3-player", "Killor", "O-73", "$87.99"},
		{"mp3-player", "Killor", "U-32", "$64.99"},
		{"mp3-player", "Killor", "X-50", "$93.99"},
		{"laptop", "Rinox", "C-50", "$57.99"},
		{"laptop", "Rinox", "F-18", "$57.99"},
		{"laptop", "Rinox", "F-71", "$82.99"},
		{"laptop", "Rinox", "G-39", "$72.99"},
		{"laptop", "Rinox", "O-10", "$85.99"},
		{"laptop", "Rinox", "R-85", "$99.99"},
		{"laptop", "Rinox", "T-16", "$60.99"},
		{"laptop", "Rinox", "U-36", "$55.99"},
		{"laptop", "Rinox", "W-22", "$95.99"},
		{"laptop", "Rinox", "X-91", "$72.99"},
		{"laptop", "Mallsoft", "A-27", "$77.99"},
		{"laptop", "Mallsoft", "E-59", "$50.99"},
		{"laptop", "Mallsoft", "F-89", "$86.99"},
		{"laptop", "Mallsoft", "G-93", "$97.99"},
		{"laptop", "Mallsoft", "I-80", "$77.99"},
		{"laptop", "Mallsoft", "I-86", "$92.99"},
		{"laptop", "Mallsoft", "R-91", "$88.99"},
		{"laptop", "Mallsoft", "S-88", "$86.99"},
		{"laptop", "Mallsoft", "U-41", "$55.99"},
		{"laptop", "Mallsoft", "Y-78", "$89.99"},
		{"laptop", "Leviti", "B-30", "$82.99"},
		{"laptop", "Leviti", "B-64", "$85.99"},
		{"laptop", "Leviti", "C-78", "$63.99"},
		{"laptop", "Leviti", "E-71", "$75.99"},
		{"laptop", "Leviti", "F-93", "$76.99"},
		{"laptop", "Leviti", "H-33", "$57.99"},
		{"laptop", "Leviti", "K-49", "$72.99"},
		{"laptop", "Leviti", "L-24", "$58.99"},
		{"laptop", "Leviti", "L-71", "$61.99"},
		{"laptop", "Leviti", "M-76", "$95.99"},
		{"laptop", "Zanium", "A-63", "$97.99"},
		{"laptop", "Zanium", "B-25", "$62.99"},
		{"laptop", "Zanium", "F-22", "$74.99"},
		{"laptop", "Zanium", "I-38", "$74.99"},
		{"laptop", "Zanium", "J-34", "$57.99"},
		{"laptop", "Zanium", "P-29", "$55.99"},
		{"laptop", "Zanium", "R-81", "$68.99"},
		{"laptop", "Zanium", "T-49", "$90.99"},
		{"laptop", "Zanium", "V-76", "$96.99"},
		{"laptop", "Zanium", "X-64", "$64.99"}
	};
}
