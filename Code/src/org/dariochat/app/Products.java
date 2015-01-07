package org.dariochat.app;

public class Products
{
	static int getSize ()
	{
		return questions.length;
	}

	static String getID (int i)
	{
		return "" + questions[i][0] + " / Vraag " + (i+1);
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
				"Ik wil graag op 21 februari met 5 personen op wintersport.",
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
				"Zo dichtbij piste als mogelijk"
			},
			{
				"Part1_4",
				"Ik wil graag op 27 december 2014, met 2 personen op wintersport naar Les Deux Alpes. ",
				"De duurste optie ",
				"Een waardering van minimaal een 7.5"
			},
			{
				"Part1_5",
				"Ik wil graag op 21 februari 2015, met 3 personen op wintersport.",
				"Een vakantie in Oostenrijk",
				"Een sauna inbegrepen"
			},
			{
				"Part1_6",
				"Ik wil graag op 5 februari 2015, met 4 personen op wintersport. ",
				"De reissom onder &#8364 260,-",
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
//			{
//				"Part1_9",
//				"Ik wil graag op 31 januari 2015, met 1 persoon op wintersport. ",
//				"WiFi aanwezig",
//				"Een eigen staf "
//			},
//			{
//				"Part1_10",
//				"Ik wil graag op 31 januari 2015, met 1 persoon op wintersport. ",
//				"Een beoordeling hoger dan 8",
//				"Het dichtst bij de skilift"
//			},
//			{
//				"Part1_11",
//				"Ik wil graag op 21 februari 2015, met 2 personen op wintersport naar Serre Chevalier Vall&#233e",
//				"Met skilockers inbegrepen",
//				"Aan de piste"
//			},
//			{
//				"Part1_12",
//				"Ik wil graag op 21 maart 2015, met 3 personen op wintersport.",
//				"Met broodjesservice inbegrepen",
//				"De laagste reissom"
//			},
//			{
//				"Part1_13",
//				"Ik wil graag op 7 februari 2015, met 4 personen op wintersport naar M&#233ribel",
//				"Met WiFi inbegrepen",
//				"Met de hoogste beoordeling"
//			},
//			{
//				"Part1_14",
//				"Ik wil graag op 4 april 2015, met 4 personen op wintersport naar Les Deux Alpes",
//				"In het centrum",
//				"Met mogelijkheden tot een animatie en fakkelwandeling"
//			},
//			{
//				"Part1_15",
//				"Ik wil graag op 27 februari 2015, met 13 personen op wintersport.",
//				"Een vakantie in Frankrijk",
//				"Het dichtst bij het centrum en de piste"
//			},
//			{
//				"Part1_16",
//				"Ik wil graag op wintersport met 1 persoon. ",
//				"Aan de piste",
//				"Het verblijf met de hoogste beoordeling"
//			},
//			{
//				"Part1_17",
//				"Ik wil graag op 24 januari 2015, met 8 personen op wintersport naar Paradiski ",
//				"Met een broodjesservice",
//				"Met een panoramisch uitzicht"
//			},
//			{
//				"Part1_18",
//				"Ik wil graag op 14 februari 2015, met 4 personen op wintersport.",
//				"Een vakantie in Les Portes du Soleil",
//				"Een verblijf van priv&#233-eigenaren"
//			},
//			{
//				"Part1_19",
//				"Ik wil graag op 31 januari, met 4 personen op wintersport naar Italië.",
//				"Met een balkon of terras",
//				"Met WiFi inbegrepen"
//			},
//			{
//				"Part1_20",
//				"Ik wil graag op 21 februari, met 5 personen op wintersport.",
//				"Met een zwembad",
//				"Met een openhaard"
//			},
			{
				"Part2_1:",
				"Ik wil graag op 20 februari 2015, met 4 personen op wintersport naar Flaine. ",
				"Niet de optie met de laagste waardering",
				"De laagste reissom per persoon"
				
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
				"Een reissom onder &#8364 200",
				"Met een balkon inbegrepen"
			},
			{
				"Part2_7:",
				"Ik wil graag op 20 december, met 6 personen op wintersport naar Superd&#233voluy.",
				"Een reissom onder de 300 euro",
				"Met een broodjesservice inbegrepen"
			},
			{
				"Part2_8:",
				"Ik wil graag op 21 februari, met 5 personen op wintersport naar Italië.  ",
				"Met WiFI inbegrepen",
				"Rustig gelegen"
			},
//			{
//				"Part2_9:",
//				"Ik wil graag op 31 januari 2015, met 1 persoon op wintersport. ",
//				"WiFi aanwezig",
//				"Cr&#234perie aanwezig"
//			},
//			{
//				"Part2_10:",
//				"Ik wil graag op 31 januari 2015, met 1 persoon op wintersport. ",
//				"Een beoordeling van een 7",
//				"Dichtste bij het centrum"
//			},
//			{
//				"Part2_11:",
//				"Ik wil graag op 10 januari 2015 met 2 personen op wintersport naar Serre Chevalier Vall&#233e. ",
//				"Met sauna inbegrepen",
//				"Aan de piste"
//			},
//			{
//				"Part2_12:",
//				"Ik wil graag op 21 maart met 3 personen op wintersport.",
//				"Met wellness aanwezig",
//				"De laagste reissom"
//			},
//			{
//				"Part2_13:",
//				"Ik wil graag op 7 februari met 4 personen op wintersport naar Risoul. ",
//				"WiFi inbegrepen",
//				"Met de hoogste beoordeling"
//			},
//			{
//				"Part2_14:",
//				"Ik wil graag op 4 april, met 4 personen op wintersport naar Chatel. ",
//				"Met een een balkon",
//				"Van priv&#233 eigenaren"
//			},
//			{
//				"Part2_15:",
//				"Ik wil graag op 27 februari met 13 personen op wintersport.",
//				"Een vakantie in Frankrijk",
//				"Het dichtst bij het centrum en de piste"
//			},
//			{
//				"Part2_16:",
//				"Ik wil graag op wintersport met 1 persoon. ",
//				"Met wifi inbegrepen",
//				"Het verblijf met de hoogste beoordeling"
//			},
//			{
//				"Part2_17:",
//				"Ik wil graag op 24 januari met 8 personen op wintersport naar Valfrejus. ",
//				"500 meter van het centrum",
//				"Met een Scandinavische kachel"
//			},
//			{
//				"Part2_18:",
//				"Ik wil graag op 14 februari met 4 personen op wintersport. ",
//				"Een vakantie in Italië. ",
//				"Inclusief handdoeken. "
//			},
//			{
//				"Part2_19:",
//				"Ik wil graag op 31 januari met 4 personen op wintersport naar Italië. ",
//				"Een bar aanwezig",
//				"Handdoeken inbegrepen"
//			},
//			{
//				"Part2_20:",
//				"Ik wil graag op 21 februari met 5 personen op wintersport.",
//				"Aan de piste",
//				"Een broodjesservice aanwizig"
//			}
		};
}
