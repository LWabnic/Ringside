DROP TABLE IF EXISTS record CASCADE;
CREATE TABLE record (
    id bigint not null auto_increment,
    contender1 varchar(255),
    contender2 varchar(255),
    fight_date date,
    winner varchar(255),
    PRIMARY KEY (id)
);