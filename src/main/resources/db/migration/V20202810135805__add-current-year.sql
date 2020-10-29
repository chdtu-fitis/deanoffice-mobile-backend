CREATE TABLE current_year
(
    id SERIAL PRIMARY KEY,
    curr_year integer NOT NULL
);

INSERT INTO current_year(id, curr_year) VALUES (1, 2020);