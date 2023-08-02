INSERT INTO tstudents (name, surname, faculty, field, group_students, year)
VALUES ('Janusz', 'Kowalski', 'Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej', 'Informatyka', 'INF1','1');
INSERT INTO tstudents (name, surname, faculty, field, group_students, year)
VALUES ('Anna', 'Nowak', 'Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej', 'Informatyka', 'INF1','1');
INSERT INTO tstudents (name, surname, faculty, field, group_students, year)
VALUES ('Wiktor', 'Wysoki', 'Wydział Elektrotechniki, Automatyki, Informatyki i Inżynierii Biomedycznej', 'Informatyka', 'INF1','1');
INSERT INTO tstudents (name, surname, faculty, field, group_students, year)
VALUES ('Monika', 'Niska', 'Wydział Matematyki Stosowanej', 'Matematyka stosowana', 'MAT2','2');
INSERT INTO tstudents (name, surname, faculty, field, group_students, year)
VALUES ('Alicja', 'Nowakowska', 'Wydział Matematyki Stosowanej', 'Matematyka stosowana', 'MAT2','2');


INSERT INTO tsubjects (name) VALUES ('Matematyka');
INSERT INTO tsubjects (name) VALUES ('Fizyka');
INSERT INTO tsubjects (name) VALUES ('Chemia');
INSERT INTO tsubjects (name) VALUES ('Bazy danych');
INSERT INTO tsubjects (name) VALUES ('Algorytmy');

INSERT INTO tlecturers (name, surname)
VALUES ('Monika', 'Duda');
INSERT INTO tlecturers (name, surname)
VALUES ('Przemysław', 'Boniek');
INSERT INTO tlecturers (name, surname)
VALUES ('Alicja', 'Stręczyńska');

INSERT INTO tmeetings (subject_id, lecturer_id, group_students) VALUES (4,1,'INF1');
INSERT INTO tmeetings (subject_id, lecturer_id, group_students) VALUES (1,2,'MAT2');
INSERT INTO tmeetings (subject_id, lecturer_id, group_students) VALUES (3,3,'INF1');
INSERT INTO tmeetings (subject_id, lecturer_id, group_students) VALUES (4,1,'MAT2');
