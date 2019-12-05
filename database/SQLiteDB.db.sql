BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "TrueFalse" (
	"field1"	TEXT,
	"field2"	TEXT
);
CREATE TABLE IF NOT EXISTS "MultipleChoice" (
	"Question"	TEXT,
	"Answer"	TEXT,
	"a"	TEXT,
	"b"	TEXT,
	"c"	TEXT,
	"d"	TEXT
);
CREATE TABLE IF NOT EXISTS "ShortAnswer" (
	"Question"	TEXT,
	"Answer"	TEXT
);
INSERT INTO "TrueFalse" VALUES ('Question','Answer');
INSERT INTO "TrueFalse" VALUES ('Albus Dumbledore''s full name is Albus Percival Wulfric Brian Dumbledore','TRUE');
INSERT INTO "TrueFalse" VALUES ('When the Death Eaters take over the Ministry of Magic, Yaxley''s title Head of the Department of International Magical Cooperation','FALSE');
INSERT INTO "TrueFalse" VALUES ('Mad-Eye Moody is killed during the escape from Privet Drive','TRUE');
INSERT INTO "TrueFalse" VALUES ('Harry''s second son is named Albus Sirius Potter','FALSE');
INSERT INTO "MultipleChoice" VALUES ('Question','Answer','a','b','c','d');
INSERT INTO "MultipleChoice" VALUES ('Who kills Cedric Diggory on Lord Voldemort''s orders?','c','Draco Malfoy','Severus Snape','Peter Pettigrew','Sirius Black');
INSERT INTO "MultipleChoice" VALUES ('Who instructs the Hogwarts suits of armour to defend the castle, using the spell Piertotum Locomotor, during the battle of Hogwarts?','d','Professor Trelawney','Alastor Moody','Professor Filius Flitwick','Professor McGonagall');
INSERT INTO "MultipleChoice" VALUES ('Which one of the three shapes in the Deathly Hallows symbol represents the Invisibility Cloak?','a','Triangle','Circle','Line','Square');
INSERT INTO "MultipleChoice" VALUES ('Which creature threatens Harry, Ron, and Hermione at Gringotts?','b','Basilisk','Dragon','Blast-Ended Skrewt','Chimaera');
INSERT INTO "MultipleChoice" VALUES ('Which school textbook did Bathilda Bagshot write?','d','Numerology and Grammatica','Break with a Banshee','Flesh-Eating Trees of the World','A History of Magic');
INSERT INTO "MultipleChoice" VALUES ('Where did the Dumbledore family live when Albus was a boy?','a','Godric''s Hollow','Little Hangleton','Spinner''s End','Forest of Dean');
INSERT INTO "MultipleChoice" VALUES ('What position does Oliver Wood play for the Gryffindor Quidditch Team?','b','Chaser','Keeper','Seeker','Beater');
INSERT INTO "MultipleChoice" VALUES ('What department in the Ministry of Magic does Barty Crouch head up when the Triwizard Tournament occurs?','c','Department of Magical Law Enforcement','Department for the Regulation and Control of Magical Creatures','Department of International Magical Cooperation','Department of Magical Transportation');
INSERT INTO "MultipleChoice" VALUES ('Viktor Krum is selected by the Goblet of Fire as the Triwizard champion for which school?','d','Beauxbatons Academy of Magic','Ilvermorny','Castelobruxo','Durmstrang');
INSERT INTO "MultipleChoice" VALUES ('What member of Dumbledore''s Army goes to the Department of Mysteries with Harry, Ron, and Hermione?','d','Luna','Neville','Ginny','All of the above');
INSERT INTO "MultipleChoice" VALUES ('Which Weasley brother first owns Scabbers as a pet?','b','Ron','Percy','George','Bill');
INSERT INTO "MultipleChoice" VALUES ('Who escorts the real Harry during his escape from Privet Drive?','d','Mad-Eye Moody','Tonks','Sirius Black','Hagrid');
INSERT INTO "MultipleChoice" VALUES ('Who is speculated to be the informant leaking Dumbledore''s secrets in Rita Skeeter''s book?','d','Garrick Ollivander','Xenophilius Lovegood','Silvanus Kettleburn','Bathilda Bagshot');
INSERT INTO "MultipleChoice" VALUES ('Who sends a message during Bill and Fleur''s wedding to warn everyone that the ministry has fallen?','c','Mafalda Hopkirk','Lugo Bagman','Reginald Cattermole',NULL);
INSERT INTO "MultipleChoice" VALUES ('What are the initials of Harry''s oldest son?','a','J.S.P.','A.S.P.','L.L.P.','J.L.P.');
INSERT INTO "MultipleChoice" VALUES ('Which school champion scores the highest points in the second task of the Triwizard Tournament?','c','Harry Potter','Fleur Delacour','Cedric Diggory','Viktor Krum');
INSERT INTO "MultipleChoice" VALUES ('Which Death Eater kidnaps a hooded Ollivander from Diagon Alley?','b','Alecto Carrow','Fenrir Greyback','Waldin Macnair','Augustus Rookwood');
INSERT INTO "MultipleChoice" VALUES ('Whose home do Harry and Hermione visit in Godric''s Hollow?','b','Albus Dumbledore','Bathilda Bagshot','Gellert Grindelwald','Ignotus Peverell');
INSERT INTO "MultipleChoice" VALUES ('Who does Kingsley Shacklebolt act as a bodyguard for?','d','The Minister of Magic','The Hogwarts Headmaster','The Minister for Magic','The Muggle Prime Minister');
INSERT INTO "MultipleChoice" VALUES ('How are Sirius Black and Bellatrix Lestrange related?','c','They are siblings','They are step-siblings','They are cousins','They are not related');
INSERT INTO "MultipleChoice" VALUES ('Gwenog Jones is the captain of which Quidditch Team?','c','Kenmare Kestrels','Ballycastle Bats','Holyhead Harpies','Wimbourne Wasps');
INSERT INTO "MultipleChoice" VALUES ('Who is the Minister for Magic after Cornelius Fudge?','a','Rufus Scrimgeour','Pius Thicknesse','Millicent Bagnold','Ignatius Tuft');
INSERT INTO "MultipleChoice" VALUES ('On whose grave does Hermione see the symbol the Xenophilius Lovegood was wearing on a necklace?','c','James and Lily Potter''s','Godric Gryffindor''s','Ignotus Peverell''s','Charity Burbage');
INSERT INTO "MultipleChoice" VALUES ('What department in the Ministry of Magic does Arthur Weasley work in when Harry first meets him?','c','The Improper Use of Magic Office','The Muggle-Worthy Excuse Office','The Misuse of Muggle Artefacts Office','The Goblin Liaison Office');
INSERT INTO "ShortAnswer" VALUES ('Question','Answer');
INSERT INTO "ShortAnswer" VALUES ('Who creates the slug club?','Slughorn');
INSERT INTO "ShortAnswer" VALUES ('What is the name of the group of students that practice Defence Against the Dark Arts under Harry''s guidance?','Dumbledore''s Army');
INSERT INTO "ShortAnswer" VALUES ('Which Weasley twin has his ear cursed off by the Death Eaters when transporting Harrry to The Burrow?','George');
INSERT INTO "ShortAnswer" VALUES ('What is the name of the driver of the Knight bus?','Ernie Prang');
INSERT INTO "ShortAnswer" VALUES ('Who has the first name Dolores?','Umbridge');
INSERT INTO "ShortAnswer" VALUES ('Luna''s father is editor of which newspaper?','The Quibbler');
INSERT INTO "ShortAnswer" VALUES ('Who is the editor of the Daily Prophet?','Barnabus Cuffe');
INSERT INTO "ShortAnswer" VALUES ('Who does Hermione impersonate using Polyjuice Potion when she, Ron, Harry, and Griphook break into Gringotts?','Bellatrix');
INSERT INTO "ShortAnswer" VALUES ('What is Grindelwald''s first name?','Gellert');
INSERT INTO "ShortAnswer" VALUES ('What is Mad-Eye Moody''s first name?','Alastor');
INSERT INTO "ShortAnswer" VALUES ('How many times has Gilderoy Lockhart won Witch Weekly''s Most-Charming-Smile Award?','Five');
INSERT INTO "ShortAnswer" VALUES ('What is Nicolas Flamel''s profession?','Alchemist');
INSERT INTO "ShortAnswer" VALUES ('What are Dark-wizard-catchers known as?','Aurors');
INSERT INTO "ShortAnswer" VALUES ('Whom was Snape in love with from childhood to the day of his death?','Lily');
INSERT INTO "ShortAnswer" VALUES ('What is Krum''s first name?','Viktor');
INSERT INTO "ShortAnswer" VALUES ('What is Gregorovitch''s profession?','Wandmaker');
INSERT INTO "ShortAnswer" VALUES ('Who was Katie Bell convinced she had to deliver the cursed necklace to?','Dumbledore');
INSERT INTO "ShortAnswer" VALUES ('What is the name of the landlord of the Leaky Cauldron?','Tom');
COMMIT;
