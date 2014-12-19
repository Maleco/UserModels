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

	static String getAmount (int index)
	{
		return questions[index][1];
	}
	
	static String getDemand1 (int index)
	{
		return questions[index][2];
	}
	
	static String getDemand2 (int index)
	{
		return questions[index][3];
	}

	static String questions[][] =
		{
		// Intro Questions
		{
			"Intro_1",
			"Ik wil graag op 24 januari 2015, met 6 personen op wintersport naar Tignes",
			"Met WiFi inbegrepen",
			"Het verblijf met de beste waardering"
		},
		{
			"Intro_2",
			"Ik wil graag op 24 januari 2015, met 6 personen op wintersport. ",
			"Een vakantie in Oostenrijk", "Met all inclusive catering inbegrepen"
		},
		{
			"Intro_3",
			"Ik wil graag op 21 met 5 personen op wintersport.",
			"WiFi inbegrepen",
			"De laagst mogelijke reissom"
		},
		{
			"Intro_4",
			"Ik wil graag op 28 februari met 6 personen op wintersport.",
			"Met WiFi inbegrepen",
			"Zo dicht mogelijk bij het centrum"
		},
		{
			"Part1_1",
			"Ik wil graag op 20 februari 2015, met 4 personen op wintersport naar Alpe d’Huez. ",
			"De laagste reissom per persoon",
			"Niet de optie met de laagste waardering"
		},
		{
			"Part1_2",
			"Ik wil graag op 2 januari 2015, met 12 personen op wintersport naar Frankrijk",
			"Met WiFi inbegrepen",
			"De laagste reissom per persoon"
		},
		{
			"Part1_3",
			"Ik wil graag op 21 maart 2015, met 14 personen op wintersport.",
			"Met een sauna",
			"Zo dichtbij het centrum als mogelijk"
		},
		{
			"Part1_4",
			"Ik wil graag op 27 december 2014, met 2 personen op wintersport naar Les Deux Alpes. ",
			"De duurste optie ",
			"Een waardering van minimaal een 7.5"
		},
		{
			"Part1_5",
			"Ik wil graag op 21 februari 2015, met . personen op wintersport.",
			"Een vakantie in Oostenrijk",
			"Een sauna inbegrepen"
		},
		{
			"Part1_6",
			"Ik wil graag op 5 februari 2015, met 4 personen op wintersport. ",
			"De reissom onder €260,-",
			"Met een balkon of een terras"
		},
		{
			"Part1_7",
			"Ik wil graag op 20 december 2014, met 6 personen op wintersport naar Frankrijk.",
			"De laagste reissom",
			"Met een jacuzzi inbegrepen"
		},
		{
			"Part1_8",
			"Ik wil graag op 21 februari 2015, met 5 personen op wintersport naar Italië. ",
			"Met een skiberging inbegrepen",
			"Rustig gelegen"
		},
		{
			"Part1_9",
			"Ik wil graag op 31 januari 2015, met 1 persoon op wintersport. ",
			"WiFi aanwezig",
			"Een eigen staf "
		},
		{
			"Part1_10",
			"Ik wil graag op 31 januari 2015, met 1 persoon op wintersport. ",
			"Een beoordeling hoger dan 8",
			"Het dichtst bij de skilift"
		},
		{
			"Part1_11",
			"Ik wil graag op 21 februari 2015, met 2 personen op wintersport naar Serre Chevalier Vallée",
			"Met skilockers inbegrepen",
			"Aan de piste"
		},
		{
			"Part1_12",
			"Ik wil graag op 21 maart 2015, met 3 personen op wintersport.",
			"Met broodjesservice inbegrepen",
			"De laagste reissom"
		},
		{
			"Part1_13",
			"Ik wil graag op 7 februari 2015, met 4 personen op wintersport naar Méribel",
			"Met WiFi inbegrepen",
			"Met de hoogste beoordeling"
		},
		{
			"Part1_14",
			"Ik wil graag op 4 april 2015, met 4 personen op wintersport naar Les Deux Alpes",
			"Met een balkon of terras",
			"Met mogelijkheden tot een animatie en fakkelwandeling"
		},
		{
			"Part1_15",
			"Ik wil graag op 27 februari 2015, met 13 personen op wintersport.",
			"Een vakantie in Frankrijk",
			"Het dichtst bij het centrum en de piste"
		},
		{
			"Part1_16",
			"Ik wil graag op wintersport met 1 persoon. ",
			"Aan de piste",
			"Het verblijf met de hoogste beoordeling"
		},
		{
			"Part1_17",
			"Ik wil graag op 24 januari 2015, met 8 personen op wintersport naar Paradiski ",
			"Met een broodjesservice",
			"Met een panoramisch uitzicht"
		},
		{
			"Part1_18",
			"Ik wil graag op 14 februari 2015, met 4 personen op wintersport.",
			"Een vakantie in Les Portes du Soleil",
			"Een verblijf van privé-eigenaren"
		},
		{
			"Part1_19",
			"Ik wil graag op 31 januari, met 4 personen op wintersport naar Italië.",
			"Met een balkon of terras",
			"Met WiFi inbegrepen"
		},
		{
			"Part1_20",
			"Ik wil graag op 21 februari, met 5 personen op wintersport.",
			"Met een zwembad",
			"Vlakbij het centrum"
		},
		{
			"Part2_1:",
			"Ik wil graag op 20 februari 2015, met 4 personen op wintersport naar Flaine. ",
			"De laagste reissom per persoon",
			"Niet de optie met de laagste waardering"
		},
		{
			"Part2_2:",
			"Ik wil graag op 2 januari 2015, met 12 personen op wintersport naar Frankrijk. ",
			"Met WIFI inbegrepen",
			"De laagste reissom per persoon"
		},
		{
			"Part2_3:",
			"Ik wil graag op 21 maart 2015, met 14 personen op wintersport.",
			"Met een sauna",
			"Zo dichtbij het centrum als mogelijk"
		},
		{
			"Part2_4:",
			"Ik wil graag op 27 december 2014, met 2 personen op wintersport naar Paradiski. ",
			"Een waardering van minimaal een 7,5",
			"De duurste optie"
		},
		{
			"Part2_5:",
			"Ik wil graag op 21 februari, met 7 personen op wintersport.",
			"Een vakantie in Zwitserland",
			"Een sauna inbegrepen"
		},
		{
			"Part2_6:",
			"Ik wil graag op 30 januari, met 4 personen op wintersport.",
			"Een reissom onder €200",
			"Met een balkon inbegrepen"
		},
		{
			"Part2_7:",
			"Ik wil graag op 20 december, met 6 personen op wintersport naar Superdévoluy.",
			"De laagste reissom",
			"Met een broodjesservice inbegrepen"
		},
		{
			"Part2_8:",
			"Ik wil graag op 21 februari, met 5 personen op wintersport naar Italië.  ",
			"Met WiFI inbegrepen",
			"Rustig gelegen"
		},
		{
			"Part2_9:",
			"Ik wil graag op 31 januari 2015, met 1 persoon op wintersport. ",
			"WiFi aanwezig",
			"Crêperie aanwezig"
		},
		{
			"Part2_10:",
			"Ik wil graag op 31 januari 2015, met 1 persoon op wintersport. ",
			"Een beoordeling van een 7",
			"Dichtste bij het centrum"
		},
		{
			"Part2_11:",
			"Ik wil graag op 10 januari 2015 met 2 personen op wintersport naar Serre Chevalier Vallée. ",
			"Met sauna inbegrepen",
			"Aan de piste"
		},
		{
			"Part2_12:",
			"Ik wil graag op 21 maart met 3 personen op wintersport.",
			"Met wellness aanwezig",
			"De laagste reissom"
		},
		{
			"Part2_13:",
			"Ik wil graag op 7 februari met 4 personen op wintersport naar Risoul. ",
			"WiFi inbegrepen",
			"Met de hoogste beoordeling"
		},
		{
			"Part2_14:",
			"Ik wil graag op 4 april, met 4 personen op wintersport naar Chatel. ",
			"Met een een balkon",
			"Van privé eigenaren"
		},
		{
			"Part2_15:",
			"Ik wil graag op 27 februari met 13 personen op wintersport.",
			"Een vakantie in Frankrijk",
			"Het dichtst bij het centrum en de piste"
		},
		{
			"Part2_16:",
			"Ik wil graag op wintersport met 1 persoon. ",
			"Met wifi inbegrepen",
			"Het verblijf met de hoogste beoordeling"
		},
		{
			"Part2_17:",
			"Ik wil graag op 24 januari met 8 personen op wintersport naar Valfrejus. ",
			"500 meter van het centrum",
			"Met een Scandinavische kachel"
		},
		{
			"Part2_18:",
			"Ik wil graag op 14 februari met 4 personen op wintersport. ",
			"Een vakantie in Italië. ",
			"Inclusief handdoeken. "
		},
		{
			"Part2_19:",
			"Ik wil graag op 31 januari met 4 personen op wintersport naar Italië. ",
			"Een bar aanwezig",
			"Handdoeken inbegrepen"
		},
		{
			"Part2_20:",
			"Ik wil graag op 21 februari met 5 personen op wintersport.",
			"Aan de piste",
			"Een broodjesservice aanwizig"
		}
		};

	// Part 1 Questions

	// Part 2 Questions
	static String products[][] =
		{
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
