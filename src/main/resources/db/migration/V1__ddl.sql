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