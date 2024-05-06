INSERT INTO FUTOK (ID, AGE, GENDER, NAME)
VALUES
(100, 23, 'F', 'Laci'),
(200, 19, 'F', 'Imi'),
(300, 31, 'N', 'Viktoria'),
(400, 11, 'N', 'Mariann');

INSERT INTO VERSENYEK (ID, NAME, DISTANCE)
VALUES
(1, 'Nagy verseny', 42),
(2, 'Kis verseny', 5),
(3, 'Kozepes verseny', 21);

INSERT INTO EREDMENYEK (ID, RESZTVEVO_ID, VERSENY_ID, EREDMENY)
VALUES
(100, 100, 1, 98),
(200, 200, 1, 90),
(300, 300, 1, 100),
(400, 400, 1, 79),
(500, 100, 2, 22),
(600, 200, 2, 34),
(700, 300, 2, 47),
(800, 400, 1, 29),
(900, 100, 3, 72),
(1000, 200, 3, 64),
(1100, 300, 3, 87),
(1200, 400, 3, 95);