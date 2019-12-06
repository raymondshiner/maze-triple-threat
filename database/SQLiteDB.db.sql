BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "TrueFalse" (
	"Question"	TEXT,
	"Answer"	TEXT,
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT
);
CREATE TABLE IF NOT EXISTS "ShortAnswer" (
	"Question"	TEXT,
	"Answer"	TEXT,
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT
);
CREATE TABLE IF NOT EXISTS "MultipleChoice" (
	"Question"	TEXT,
	"Answer"	TEXT,
	"a"	TEXT,
	"b"	TEXT,
	"c"	TEXT,
	"d"	TEXT,
	"id"	INTEGER PRIMARY KEY AUTOINCREMENT
);
INSERT INTO "TrueFalse" VALUES ('Albus Dumbledore''s full name is Albus Percival Wulfric Brian Dumbledore','TRUE',1);
INSERT INTO "TrueFalse" VALUES ('When the Death Eaters take over the Ministry of Magic, Yaxley''s title Head of the Department of International Magical Cooperation','FALSE',2);
INSERT INTO "TrueFalse" VALUES ('Mad-Eye Moody is killed during the escape from Privet Drive','TRUE',3);
INSERT INTO "TrueFalse" VALUES ('Harry''s second son is named Albus Sirius Potter','FALSE',4);
INSERT INTO "TrueFalse" VALUES ('Sirius called Severus Snape the nickname Snivellus during their years at Hogwarts','TRUE',5);
INSERT INTO "TrueFalse" VALUES ('Harry gets expelled by the Ministry of Magic after the Dementor attack in the underpass because of his use of underage sorcery','TRUE',6);
INSERT INTO "TrueFalse" VALUES ('Cornelius Fudge becomes the Minister for Magic after Rufus Scrimgeour''s death','FALSE',7);
INSERT INTO "TrueFalse" VALUES ('Madame Maxime is the headmistress of Beauxbatons Academy of Magic','TRUE',8);
INSERT INTO "TrueFalse" VALUES ('Xenophilius Lovegood is the author of The Life and Lies of Albus Dumbledore','FALSE',9);
INSERT INTO "TrueFalse" VALUES ('R.A.B. is Sirius Black''s brother','TRUE',10);
INSERT INTO "TrueFalse" VALUES ('The first name of Luna''s father is Augustus','FALSE',11);
INSERT INTO "TrueFalse" VALUES ('Professor Slughorn calls Ron ''Wallenby'' after inviting Harry and Hermione to join him for his supper club','TRUE',12);
INSERT INTO "TrueFalse" VALUES ('According to legend, a monster is inside the Chamber of Secrets','TRUE',13);
INSERT INTO "TrueFalse" VALUES ('One of the Triwizard Tournament champions abandons the second task without completing it','TRUE',14);
INSERT INTO "TrueFalse" VALUES ('The phrase ''A circle has no beginning'' appears on the Golden Snitch after Harry presses it against his lips','FALSE',15);
INSERT INTO "TrueFalse" VALUES ('Sirius Black is related to a previous headmaster at Hogwarts, Phineas Niggelus','TRUE',16);
INSERT INTO "TrueFalse" VALUES ('The sword of Gryffindor has the power to destroy Horcruxes because it imbibed Basilisk venom in the Chamber of Secrets','TRUE',17);
INSERT INTO "ShortAnswer" VALUES ('Who creates the slug club?','Slughorn',1);
INSERT INTO "ShortAnswer" VALUES ('What is the name of the group of students that practice Defence Against the Dark Arts under Harry''s guidance?','Dumbledore''s Army',2);
INSERT INTO "ShortAnswer" VALUES ('Which Weasley twin has his ear cursed off by the Death Eaters when transporting Harrry to The Burrow?','George',3);
INSERT INTO "ShortAnswer" VALUES ('What is the name of the driver of the Knight bus?','Ernie Prang',4);
INSERT INTO "ShortAnswer" VALUES ('Who has the first name Dolores?','Umbridge',5);
INSERT INTO "ShortAnswer" VALUES ('Luna''s father is editor of which newspaper?','The Quibbler',6);
INSERT INTO "ShortAnswer" VALUES ('Who is the editor of the Daily Prophet?','Barnabus Cuffe',7);
INSERT INTO "ShortAnswer" VALUES ('Who does Hermione impersonate using Polyjuice Potion when she, Ron, Harry, and Griphook break into Gringotts?','Bellatrix',8);
INSERT INTO "ShortAnswer" VALUES ('What is Grindelwald''s first name?','Gellert',9);
INSERT INTO "ShortAnswer" VALUES ('What is Mad-Eye Moody''s first name?','Alastor',10);
INSERT INTO "ShortAnswer" VALUES ('How many times has Gilderoy Lockhart won Witch Weekly''s Most-Charming-Smile Award?','Five',11);
INSERT INTO "ShortAnswer" VALUES ('What is Nicolas Flamel''s profession?','Alchemist',12);
INSERT INTO "ShortAnswer" VALUES ('What are Dark-wizard-catchers known as?','Aurors',13);
INSERT INTO "ShortAnswer" VALUES ('Whom was Snape in love with from childhood to the day of his death?','Lily',14);
INSERT INTO "ShortAnswer" VALUES ('What is Krum''s first name?','Viktor',15);
INSERT INTO "ShortAnswer" VALUES ('What is Gregorovitch''s profession?','Wandmaker',16);
INSERT INTO "ShortAnswer" VALUES ('Who was Katie Bell convinced she had to deliver the cursed necklace to?','Dumbledore',17);
INSERT INTO "ShortAnswer" VALUES ('What is the name of the landlord of the Leaky Cauldron?','Tom',18);
INSERT INTO "ShortAnswer" VALUES ('Who is the Half-Blood Prince?','Snape',19);
INSERT INTO "ShortAnswer" VALUES ('What is the only part of Peter Pettigrew''s body that was found after he was allegedly murdered?','Finger',20);
INSERT INTO "ShortAnswer" VALUES ('What is Tonk''s first name, which she hates?','Nymphadora',21);
INSERT INTO "ShortAnswer" VALUES ('How many brothers does Ron have?','Five',22);
INSERT INTO "ShortAnswer" VALUES ('What is Lupin''s middle initial?','J',23);
INSERT INTO "ShortAnswer" VALUES ('When Professor Trelawney predicts ''servant and master shall be reunited once more'', she is referring to which servant?','Peter Pettigrew',24);
INSERT INTO "ShortAnswer" VALUES ('What is Filch''s first name?','Argus',25);
INSERT INTO "ShortAnswer" VALUES ('For how many years has Sirius Black been in Azkaban prison?','Twelve',26);
INSERT INTO "ShortAnswer" VALUES ('What is Luna Lovegood''s nickname given to her by her peers?','Loony',27);
INSERT INTO "ShortAnswer" VALUES ('Who is Remus Lupin''s wife?','Tonks',28);
INSERT INTO "ShortAnswer" VALUES ('Who erases herself from family pictures to protect her parents from the Dark Forces?','Hermione',29);
INSERT INTO "ShortAnswer" VALUES ('Harry first apparates alongside whom?','Dumbledore',30);
INSERT INTO "ShortAnswer" VALUES ('What relation are Albus and Aberforth Dumbledore?','Brothers',31);
INSERT INTO "ShortAnswer" VALUES ('What is Professor Dumbledore''s first name?','Albus',32);
INSERT INTO "ShortAnswer" VALUES ('What is the name of Hermione''s cat?','Crookshanks',33);
INSERT INTO "ShortAnswer" VALUES ('Who frees Harry and his friends from the dungeons in Malfoy Manor?','Dobby',34);
INSERT INTO "ShortAnswer" VALUES ('What colour handbag does the Snape Boggart carry?','Red',35);
INSERT INTO "ShortAnswer" VALUES ('Which creature aids in the escape of Harry, Ron, and Hermione from Gringotts?','A dragon',36);
INSERT INTO "ShortAnswer" VALUES ('What do Harry and Hermione use to travel back in time?','A Timeturner',37);
INSERT INTO "ShortAnswer" VALUES ('What form does the Patronus take that leads Harry to the lake where he finds the sword of Gryffindor?','A doe',38);
INSERT INTO "ShortAnswer" VALUES ('Who kills Sirius Black during the battle at the Ministry of Magic?','Bellatrix',39);
INSERT INTO "ShortAnswer" VALUES ('Which Hogwarts student is harmed by a cursed necklace?','Katie Bell',40);
INSERT INTO "ShortAnswer" VALUES ('Who does Harry hear singing when he opens the golden egg under water?','Merpeople',41);
INSERT INTO "ShortAnswer" VALUES ('What does Dumbledore conjure to protect himself and Harry from the Inferi in the cave?','Fire',42);
INSERT INTO "ShortAnswer" VALUES ('What kind of creature attacks Hermione in the girls'' toilets?','A troll',43);
INSERT INTO "ShortAnswer" VALUES ('How many horcruxes did Lord Voldemort create?','Seven',44);
INSERT INTO "ShortAnswer" VALUES ('Who became master of the Elder Wand after Dumbledore?','Draco',45);
INSERT INTO "ShortAnswer" VALUES ('What magical creature do Harry and Draco find dead in the Forbidden Forest?','A unicorn',46);
INSERT INTO "ShortAnswer" VALUES ('What should you never do to a Hippogriff, as they are very proud creatures?','Insult them',47);
INSERT INTO "ShortAnswer" VALUES ('Which potion allows the drinker to temporarily assume the form of someone else?','Polyjuice Potion',48);
INSERT INTO "ShortAnswer" VALUES ('What is Professor Slughorn''s favourite treat, as discovered by Tom Riddle?','Crystallized Pineapple',49);
INSERT INTO "ShortAnswer" VALUES ('What is Horace Slughorn disguised as when Harry first meets him?','An armchair',50);
INSERT INTO "ShortAnswer" VALUES ('What is Tom Riddle''s middle name?','Marvolo',51);
INSERT INTO "ShortAnswer" VALUES ('Which professor stands up to Professor Snape before the Battle of Hogwarts?','McGonagall',52);
INSERT INTO "ShortAnswer" VALUES ('Who binds the Unbreakable Vow between Professor Snape and Narcisssa Malfoy?','Bellatrix',53);
INSERT INTO "MultipleChoice" VALUES ('Who kills Cedric Diggory on Lord Voldemort''s orders?','c','Draco Malfoy','Severus Snape','Peter Pettigrew','Sirius Black',1);
INSERT INTO "MultipleChoice" VALUES ('Who instructs the Hogwarts suits of armour to defend the castle, using the spell Piertotum Locomotor, during the battle of Hogwarts?','d','Professor Trelawney','Alastor Moody','Professor Filius Flitwick','Professor McGonagall',2);
INSERT INTO "MultipleChoice" VALUES ('Which one of the three shapes in the Deathly Hallows symbol represents the Invisibility Cloak?','a','Triangle','Circle','Line','Square',3);
INSERT INTO "MultipleChoice" VALUES ('Which creature threatens Harry, Ron, and Hermione at Gringotts?','b','Basilisk','Dragon','Blast-Ended Skrewt','Chimaera',4);
INSERT INTO "MultipleChoice" VALUES ('Which school textbook did Bathilda Bagshot write?','d','Numerology and Grammatica','Break with a Banshee','Flesh-Eating Trees of the World','A History of Magic',5);
INSERT INTO "MultipleChoice" VALUES ('Where did the Dumbledore family live when Albus was a boy?','a','Godric''s Hollow','Little Hangleton','Spinner''s End','Forest of Dean',6);
INSERT INTO "MultipleChoice" VALUES ('What position does Oliver Wood play for the Gryffindor Quidditch Team?','b','Chaser','Keeper','Seeker','Beater',7);
INSERT INTO "MultipleChoice" VALUES ('What department in the Ministry of Magic does Barty Crouch head up when the Triwizard Tournament occurs?','c','Department of Magical Law Enforcement','Department for the Regulation and Control of Magical Creatures','Department of International Magical Cooperation','Department of Magical Transportation',8);
INSERT INTO "MultipleChoice" VALUES ('Viktor Krum is selected by the Goblet of Fire as the Triwizard champion for which school?','d','Beauxbatons Academy of Magic','Ilvermorny','Castelobruxo','Durmstrang',9);
INSERT INTO "MultipleChoice" VALUES ('What member of Dumbledore''s Army goes to the Department of Mysteries with Harry, Ron, and Hermione?','d','Luna','Neville','Ginny','All of the above',10);
INSERT INTO "MultipleChoice" VALUES ('Which Weasley brother first owns Scabbers as a pet?','b','Ron','Percy','George','Bill',11);
INSERT INTO "MultipleChoice" VALUES ('Who escorts the real Harry during his escape from Privet Drive?','d','Mad-Eye Moody','Tonks','Sirius Black','Hagrid',12);
INSERT INTO "MultipleChoice" VALUES ('Who is speculated to be the informant leaking Dumbledore''s secrets in Rita Skeeter''s book?','d','Garrick Ollivander','Xenophilius Lovegood','Silvanus Kettleburn','Bathilda Bagshot',13);
INSERT INTO "MultipleChoice" VALUES ('Who sends a message during Bill and Fleur''s wedding to warn everyone that the ministry has fallen?','c','Mafalda Hopkirk','Lugo Bagman','Reginald Cattermole',NULL,14);
INSERT INTO "MultipleChoice" VALUES ('What are the initials of Harry''s oldest son?','a','J.S.P.','A.S.P.','L.L.P.','J.L.P.',15);
INSERT INTO "MultipleChoice" VALUES ('Which school champion scores the highest points in the second task of the Triwizard Tournament?','c','Harry Potter','Fleur Delacour','Cedric Diggory','Viktor Krum',16);
INSERT INTO "MultipleChoice" VALUES ('Which Death Eater kidnaps a hooded Ollivander from Diagon Alley?','b','Alecto Carrow','Fenrir Greyback','Waldin Macnair','Augustus Rookwood',17);
INSERT INTO "MultipleChoice" VALUES ('Whose home do Harry and Hermione visit in Godric''s Hollow?','b','Albus Dumbledore','Bathilda Bagshot','Gellert Grindelwald','Ignotus Peverell',18);
INSERT INTO "MultipleChoice" VALUES ('Who does Kingsley Shacklebolt act as a bodyguard for?','d','The Minister of Magic','The Hogwarts Headmaster','The Minister for Magic','The Muggle Prime Minister',19);
INSERT INTO "MultipleChoice" VALUES ('How are Sirius Black and Bellatrix Lestrange related?','c','They are siblings','They are step-siblings','They are cousins','They are not related',20);
INSERT INTO "MultipleChoice" VALUES ('Gwenog Jones is the captain of which Quidditch Team?','c','Kenmare Kestrels','Ballycastle Bats','Holyhead Harpies','Wimbourne Wasps',21);
INSERT INTO "MultipleChoice" VALUES ('Who is the Minister for Magic after Cornelius Fudge?','a','Rufus Scrimgeour','Pius Thicknesse','Millicent Bagnold','Ignatius Tuft',22);
INSERT INTO "MultipleChoice" VALUES ('On whose grave does Hermione see the symbol the Xenophilius Lovegood was wearing on a necklace?','c','James and Lily Potter''s','Godric Gryffindor''s','Ignotus Peverell''s','Charity Burbage',23);
INSERT INTO "MultipleChoice" VALUES ('What department in the Ministry of Magic does Arthur Weasley work in when Harry first meets him?','c','The Improper Use of Magic Office','The Muggle-Worthy Excuse Office','The Misuse of Muggle Artefacts Office','The Goblin Liaison Office',24);
INSERT INTO "MultipleChoice" VALUES ('Who saves Harry from drowning in the frozen lake in the Forest of Dean?','c','Neville','Luna','Ron','Hermione',25);
INSERT INTO "MultipleChoice" VALUES ('What is Hermione''s middle name?','a','Jean','Ann','Grace','Rose',26);
INSERT INTO "MultipleChoice" VALUES ('Which teams play in the 422nd Quidditch World Cup final?','d','Ireland and England','Scotland and Bulgaria','Bulgaria and England','Ireland and Bulgaria',27);
INSERT INTO "MultipleChoice" VALUES ('What is the name of Cedric Diggory''s father?','b','Lionel','Amos','Edward','Tom',28);
INSERT INTO "MultipleChoice" VALUES ('What color is the Beauxbatons school uniform?','a','Blue','Green','Pink','Violet',29);
INSERT INTO "MultipleChoice" VALUES ('Who finds Harry and Dudley in the underpass after the Dementor attack?','c','Petunia','Dumbledore','Mrs. Figg','Vernon',30);
INSERT INTO "MultipleChoice" VALUES ('Which Hogwarts student does Ariana Dumbledore bring to Harry, Ron, and Hermione through her portrait?','b','Ginny','Neville','Luna','Cho',31);
INSERT INTO "MultipleChoice" VALUES ('What position does Krum play on the Bulgarian Quidditch Team?','d','Keeper','Beater','Chaser','Seeker',32);
INSERT INTO "MultipleChoice" VALUES ('Which member of the Order of the Phoenix escorts Ron to The Burrow during the escape from Privet Drive?','b','Mad-Eye Moody','Tonks','Hagrid','Lupin',33);
INSERT INTO "MultipleChoice" VALUES ('Which member of the Order of the Phoenix has scars running down his face because of an encounter with Fenrir Greyback, the werewolf?','c','Remus Lupin','Kingsley Shacklebolt','Bill Weasley','Mundugus Fletcher',34);
INSERT INTO "MultipleChoice" VALUES ('According to Griphook, who put the fake sword of Gryffindor inside Bellatrix Lestrange''s vault?','b','Voldemort','Professor Snape','Bellatrix Lestrange','Regulus Black',35);
INSERT INTO "MultipleChoice" VALUES ('Sybill Trelawney''s first prophecy speaks of a boy born at the end of which month?','d','August','January','October','July',36);
INSERT INTO "MultipleChoice" VALUES ('What is the name of the Ministry of Magic employee that Ron impersonates using Polyjuice Potion?','c','Albert Runcorn','Pius Thicknesse','Reg Cattermole','Lugo Bagman',37);
INSERT INTO "MultipleChoice" VALUES ('The initials R.A.B. belong to whom?','b','Regina Amelia Bones','Regulus Arcturus Black','Reginald Albert Black','Ryan Argus Binns',38);
INSERT INTO "MultipleChoice" VALUES ('Who was forced to send his own son to Azkaban for being a Death Eater?','a','Barty Crouch','Alecto Carrow','Dedalus Diggle','Cornelius Fudge',39);
INSERT INTO "MultipleChoice" VALUES ('What is the name of Gilderoy Lockhart''s self-praising autobiography?','d','Who Am I?','Charm & Charms','Gilderoy Lockhart','Magical Me',40);
INSERT INTO "MultipleChoice" VALUES ('What is Madame Maxime''s first name?','c','Augusta','Mafalda','Olympe','Aurora',41);
INSERT INTO "MultipleChoice" VALUES ('Who does Tonks marry?','b','Bill Weasley','Remus Lupin','Charlie Weasley','Florean Fortescue',42);
INSERT INTO "MultipleChoice" VALUES ('Which of the three brothers from The Tale of the Three Brothers presents himself to Death during old age?','a','The youngest brother','The second brother','The eldest brother','None of the brothers',43);
INSERT INTO "MultipleChoice" VALUES ('Which of Ron''s brothers marries Fleur Delacour?','d','Charlie','Percy','Fred','Bill',44);
INSERT INTO "MultipleChoice" VALUES ('After Dumbledore''s death, who writes an unofficial autobiography on him?','b','Bathilda Bagshot','Rita Skeeter','Gilderoy Lockhart','Xenophilius Lovegood',45);
INSERT INTO "MultipleChoice" VALUES ('What is Ron Weasley''s middle name?','c','Oliver','Peter','Bilius','Frank',46);
INSERT INTO "MultipleChoice" VALUES ('What is the name of the Slytherin Quidditch captain during Harry''s second year at Hogwarts?','b','Blaise Zabini','Marcus Flint','Draco Malfoy','Theodore Nott',47);
INSERT INTO "MultipleChoice" VALUES ('Where does Charlie Weasley live when he is studying dragons?','c','Spain','Norway','Romania','Egypt',48);
INSERT INTO "MultipleChoice" VALUES ('Who wears the symbol of the Deathly Hallows around their neck at the wedding?','d','Emmeline Vance','Andromeda Tonks','Stan Shunpike','Xenophilius Lovegood',49);
INSERT INTO "MultipleChoice" VALUES ('Who founded the Order of the Phoenix when the fight against Lord Voldemort began?','b','Kingsley Shacklebolt','Dumbledore','Caradoc Dearborn','Benjy Fenwick',50);
INSERT INTO "MultipleChoice" VALUES ('Which former Hogwarts professor is the Head of the Muggle-born Registration Commission?','b','Horace Slughorn','Dolores Umbridge','Arthur Weasley','Elphias Doge',51);
INSERT INTO "MultipleChoice" VALUES ('What are the names of Neville Longbottom''s parents?','d','Anthony and Marge','Ludo and Amelia','Silvanus and Olympe','Frank and Alice',52);
INSERT INTO "MultipleChoice" VALUES ('What is the full name of the conductor on the Knight Bus?','b','Antonin Dolohov','Stan Shunpike','Florean Fortescue','Dirk Cresswell',53);
INSERT INTO "MultipleChoice" VALUES ('Who do Harry and Hermione run into in an elevator at the Ministry of Magic?','a','Dolores Umbridge','Arthur Weasley','Amos Diggory','Walden Macnair',54);
INSERT INTO "MultipleChoice" VALUES ('Why can only some people see Thestrals?','c','They choose to be seen by people they trust','No one knows','They can only be seen by people who have seen death','They can only be seen by half-bloods',55);
INSERT INTO "MultipleChoice" VALUES ('What spell does Hermione use to stop the rogue Bludger that targets Harry during a Quidditch match against Slytherin?','b','Accio','Finite Incantatem','Confundo','Protego',56);
INSERT INTO "MultipleChoice" VALUES ('What type of dragon does Cedric face in the first task of the Triwizard Tournament?','a','The Swedish Short-Snout','The Romanian Longhorn','The Hebridean Black','The Hungarian Horntail',57);
COMMIT;
