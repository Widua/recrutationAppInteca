CREATE TABLE IF NOT EXISTS family (
 id INT AUTO_INCREMENT,
 familyName VARCHAR(20),
 nrOfAdults INT,
 nrOfChildren INT,
 nrOfInfants INT,
 PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS familyMember(
 id INT AUTO_INCREMENT,
 familyId INT,
 givenName VARCHAR(20),
 age INT,
 PRIMARY KEY (id)
);

ALTER TABLE familyMember
    ADD FOREIGN KEY (familyId) REFERENCES family(id) ;