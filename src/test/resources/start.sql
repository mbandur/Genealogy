INSERT INTO persons (id, first_nane, second_nane, last_nane, maiden_nane, sex, comments, created_on, updated_on)
VALUES
    (1, 'Cezaryy', 'Dawid', 'Nowak', 'Sgeer', 'M', 'person 1 comments', null, null),
    (2, 'Elżbieta', 'Maria', 'Nowak', 'Kuchta', 'F', 'person 2 comments', null, null),
    (3, 'Mariusz', null, 'Nowak', null, 'M', 'person 3 comments', null, null),
    (4, 'Damian', null, 'Nowak', null, 'M', 'person 4 comments', null, null),
    (5, 'Szczepan', null, 'Nowak', null, 'M', 'person 5 comments', null, null),
    (6, 'Wiesława', null, 'Nowak', 'Krud', 'F', 'person 6 comments', null, null),
    (7, 'Agnieszka', null, 'Dron', 'Nowak', 'F', 'person 7 comments', null, null),
    (8, 'Zofia', 'Ewa', 'Krus', 'Malek', 'F', 'person 8 comments', null, null),
    (9, 'Leon', 'Jan', 'Krus', null, 'M', 'person 9 comments', null, null),
    (10, 'Adam', null, 'Malek', null, 'M', 'person 10 comments', null, null),
    (11, 'Janina', null, 'Malek', 'Kazik', 'F', 'person 11 comments', null, null),
    (12, 'Mirosław', 'Tomasz', 'Krus', null, 'M', 'person 12 comments', null, null),
    (13, 'Władysława', 'Anna', 'Krus', 'Zych', 'F', 'person 13 comments', null, null)
;
INSERT INTO relations (id, person1_id, person2_id, relation_type_1, relation_type_2, comments, created_on, updated_on)
VALUES (1, 1, 2, 'husband', 'wife', 'relation 1 comments', null, null),
       (2, 1, 3, 'siblings', 'siblings', 'relation 2 comments', null, null),
       (3, 1, 4, 'father', 'children', 'relation 3 comments', null, null),
       (4, 1, 5, 'children', 'father', 'relation 4 comments', null, null),
       (5, 1, 6, 'children', 'mother', 'relation 5 comments', null, null),
       (6, 1, 7, 'siblings', 'siblings', 'relation 6 comments', null, null),
       (7, 7, 6, 'children', 'mother', 'relation 7 comments', null, null),
       (8, 2, 4, 'mother', 'children', 'relation 8 comments', null, null),
       (9, 8, 2, 'mother', 'children', 'relation 9 comments', null, null),
       (10, 9, 2, 'father', 'children', 'relation 10 comments', null, null),
       (11, 10, 8, 'father', 'children', 'relation 11 comments', null, null),
       (12, 11, 8, 'mother', 'children', 'relation 12 comments', null, null),
       (13, 12, 9, 'father', 'children', 'relation 13 comments', null, null),
       (14, 13, 9, 'mother', 'children', 'relation 14 comments', null, null)
;