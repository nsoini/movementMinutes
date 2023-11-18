SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS movement; 
DROP TABLE IF EXISTS app_user; 
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS intensity;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE intensity(
int_id BIGINT NOT NULL AUTO_INCREMENT 
, name VARCHAR(50) NOT NULL
,PRIMARY KEY (int_id)
);

INSERT INTO intensity (name) 
VALUES ('Kevyt')
, ('Kohtalainen')
, ('Reipas')
, ('Raskas');

CREATE TABLE category (
cat_id BIGINT NOT NULL AUTO_INCREMENT
, name VARCHAR(50) NOT NULL
, PRIMARY KEY (cat_id)
);

INSERT INTO category (name) 
VALUES ('Kestävyysliikunta') 
, ('Arkiliikunta')
, ('Lihaskuntoharjoittelu');


CREATE TABLE app_user (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL,
password VARCHAR(250) NOT NULL,
role VARCHAR(50) NOT NULL);

INSERT INTO app_user (username, password, role) 
VALUES ('user1', '$2a$10$n92RNo7mvAtFHILGdzsA/Oa1fKuWdIT5pe2VZVSXSnUOsYy35mmr6', 'USER'), 
('user2', '$2a$10$aQqLKZGvhjzQrijtQxp2qeX.hNJiko26NCJ0/.nIC01eJR9tSo7BG', 'USER'), 
('admin', '$2a$10$45kuUqsr1dIvv.ViLupVEOKxSNdY07Ls4pYe1G8MZEK1To95ljQ.y', 'ADMIN');

CREATE TABLE movement (
 id BIGINT NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    start_time VARCHAR(10),
    exercise VARCHAR(100),
    minutes BIGINT,
    comment VARCHAR(250),
    cat_id BIGINT,
    int_id BIGINT,
    user_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (cat_id) REFERENCES category(cat_id),
    FOREIGN KEY (int_id) REFERENCES intensity(int_id),
    FOREIGN KEY (user_id) REFERENCES app_user(id));

INSERT INTO movement (date, start_time, exercise, minutes, comment, cat_id, int_id, user_id) 
VALUES ('2023-11-17', '10:00', 'Kävely', 15, 'Kiva', 2, 1, 1) 
, ('2023-11-16', '17:30', 'Kävely', 45, 'ok', 1, 2, 1)
, ('2023-11-15', '16:15', 'Tanssi', 40, 'Kiva', 1, 2, 1)
, ('2023-11-16', '18:00', 'Tennis', 30, 'Jee', 1, 3, 2);
