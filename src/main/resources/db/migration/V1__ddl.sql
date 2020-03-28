CREATE TABLE Category(
	id INT PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);

CREATE TABLE Joke(
	id INT PRIMARY KEY,
	content VARCHAR(500) NOT NULL,
	likes INT DEFAULT 0,
	dislikes INT DEFAULT 0,
	category_id INT NOT NULL,
	CONSTRAINT fk_category
	FOREIGN KEY (category_id)
		REFERENCES Category(id)
);

insert into CATEGORY (ID, NAME) values (1, 'Crni');
insert into CATEGORY (ID, NAME) values (2, 'Doktori');
insert into CATEGORY (ID, NAME) values (3, 'Sport');
insert into CATEGORY (ID, NAME) values (4, 'Izreke');

insert into JOKE (ID, CONTENT, LIKES, DISLIKES, CATEGORY_ID) values (1, 'Na vozačkom ispitu upita vozač instruktora: I jesam li dobio dozvolu? Da, dopuštam vam da se vozite tramvajem.', 30, 80, 1);
insert into JOKE (ID, CONTENT, LIKES, DISLIKES, CATEGORY_ID) values (2, 'Peca Mujo na mostu ribu. Nailazi tv ekipa i kaže novinarka da bi željela napraviti intervju s Mujom. Zaustave se i novinarka postavlja Muji pitanje: Dobar dan, pecate li vi tako svaki dan? Mujo iskusni lisac, odgovori na pozdrav i kaže da svako jutro dolazi i obično ostane do kasno popodne. Na to će novinarka: I nije vam teško sjediti satima i čekati hoće li riba zagristi. Ama jok, što bi mi bilo dosadno, uvijek se nađe neka budala koja postavlja glupa pitanja.', 40, 70, 1);
insert into JOKE (ID, CONTENT, LIKES, DISLIKES, CATEGORY_ID) values (3, 'Pita zet doktora za taštino zdravlje: Doktore, što joj je? Ono najgore! - odgovara doktor. Pa recite mi! Nije joj ništa!', 50, 60, 2);
insert into JOKE (ID, CONTENT, LIKES, DISLIKES, CATEGORY_ID) values (4, 'Bacač koplja kaže klupskom kolegi: Danas se moram posebno potruditi, u gledalištu mi je punica. Kolega odgovara: Čovječe, to je preko sto metara, teško da ćeš ju pogoditi.', 60, 50, 3);
insert into JOKE (ID, CONTENT, LIKES, DISLIKES, CATEGORY_ID) values (5, 'Mujo i Haso otišli na nogometnu utakmicu i dogovore se da će piti pivo svaki put kad netko zabije gol. Prođe 90 minuta i utakmica završi 0:0. Razočaran Mujo kaže Hasi: Haso, ajmo mi gledati košarku!', 70, 40, 3);
insert into JOKE (ID, CONTENT, LIKES, DISLIKES, CATEGORY_ID) values (6, 'Od alkohola su mnogi umrli. Ali, budimo realni, da nije bilo alkohola mnogi se ne bi niti rodili.', 80, 30, 4);
insert into JOKE (ID, CONTENT, LIKES, DISLIKES, CATEGORY_ID) values (7, 'Žene imaju problem za svako rješenje.', 90, 20, 4);
