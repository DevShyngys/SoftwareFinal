CREATE TABLE directors (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255),
                           age INTEGER
);

CREATE TABLE actors (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255),
                        age INTEGER
);

CREATE TABLE movies (
                        id BIGSERIAL PRIMARY KEY,
                        title VARCHAR(255),
                        rating DOUBLE PRECISION,
                        director_id BIGINT,
                        CONSTRAINT fk_director FOREIGN KEY (director_id) REFERENCES directors(id)
);

CREATE TABLE movie_actors (
                              movie_id BIGINT NOT NULL,
                              actor_id BIGINT NOT NULL,
                              CONSTRAINT pk_movie_actors PRIMARY KEY (movie_id, actor_id),
                              CONSTRAINT fk_movie FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
                              CONSTRAINT fk_actor FOREIGN KEY (actor_id) REFERENCES actors(id) ON DELETE CASCADE
);