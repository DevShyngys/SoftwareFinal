INSERT INTO directors (name, age) VALUES
                                      ('Christopher Nolan', 54),
                                      ('Quentin Tarantino', 61),
                                      ('James Cameron', 70);

INSERT INTO actors (name, age) VALUES
                                   ('Leonardo DiCaprio', 49),
                                   ('Matt Damon', 53),
                                   ('Kate Winslet', 48),
                                   ('Samuel L. Jackson', 75),
                                   ('Scarlett Johansson', 39),
                                   ('Tom Hanks', 67);

INSERT INTO movies (title, rating, director_id) VALUES
                                                    ('Inception', 8.8, 1),
                                                    ('Django Unchained', 8.4, 2),
                                                    ('Titanic', 7.9, 3);

INSERT INTO movie_actors (movie_id, actor_id) VALUES
                                                  (1, 1),
                                                  (1, 2),
                                                  (2, 1),
                                                  (2, 4),
                                                  (2, 5),
                                                  (3, 3),
                                                  (3, 6);