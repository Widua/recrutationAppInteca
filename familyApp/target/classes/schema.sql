
CREATE TABLE IF NOT EXISTS family (
`id` INT unsigned AUTO_INCREMENT,
`familyName` VARCHAR(20),
`nrOfAdults` INT,
`nrOfChildrens` INT,
`nrOfInfants` INT,
 PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS familyMember(
 `id` INT unsigned AUTO_INCREMENT,
`familyId` INT unsigned,
`familyName` VARCHAR(20),
`givenName` VARCHAR(20),
 PRIMARY KEY (`id`)
);

ALTER TABLE familyMember
    ADD FOREIGN KEY (familyId) REFERENCES family(id) ;