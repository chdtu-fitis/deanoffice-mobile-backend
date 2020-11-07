CREATE TABLE application (
    id serial PRIMARY KEY,
    application_type_id integer NOT NULL,
    header character varying(800) NOT NULL,
    body character varying(1500) NOT NULL
);

CREATE TABLE application_type (
    id serial PRIMARY KEY,
    name character varying(200) NOT NULL
);

CREATE TABLE degree (
    id serial PRIMARY KEY,
    name character varying(100) NOT NULL
);

CREATE TABLE specialization (
    id serial PRIMARY KEY,
    name character varying(100) NOT NULL,
    speciality_id integer NOT NULL,
    faculty_id integer NOT NULL,
    degree_id integer NOT NULL
);

CREATE TABLE faculty (
    id serial PRIMARY KEY,
    name character varying(100) NOT NULL,
    dean_name character varying(50) NOT NULL,
    abbr character varying(20) NOT NULL
);

CREATE TABLE application_user
(
    id serial PRIMARY KEY,
    username character varying(30) NOT NULL,
    password character varying(30) NOT NULL
);

CREATE TABLE student_group (
    id serial PRIMARY KEY,
    name character varying(30) NOT NULL,
    specialization_id integer NOT NULL
);

CREATE TABLE speciality (
    id serial PRIMARY KEY,
    code smallint NOT NULL,
    name character varying(100) NOT NULL
);

CREATE TABLE student (
    id serial PRIMARY KEY,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    patronimic character varying(50) NOT NULL,
    sex character varying(6) DEFAULT 'MALE'::character varying NOT NULL
);

CREATE TABLE student_degree (
    id serial PRIMARY KEY,
    payment character varying(25) DEFAULT 'BUDGET'::character varying NOT NULL,
    specialization_id integer NOT NULL,
    student_id integer NOT NULL,
    student_group_id integer NOT NULL,
    tuition_form character varying(10) NOT NULL,
    active boolean NOT NULL
);

ALTER TABLE ONLY faculty
    ADD CONSTRAINT uk_faculty_name UNIQUE (name);

ALTER TABLE ONLY faculty
    ADD CONSTRAINT uk_faculty_abbr UNIQUE (abbr);

ALTER TABLE ONLY application_user
    ADD CONSTRAINT uk_application_user_username UNIQUE (username);

ALTER TABLE ONLY degree
    ADD CONSTRAINT uk_degree_name UNIQUE (name);

ALTER TABLE ONLY application
    ADD CONSTRAINT uk_application_application_type_id UNIQUE (application_type_id);

ALTER TABLE ONLY application
    ADD CONSTRAINT uk_application_body UNIQUE (body);

ALTER TABLE ONLY application_type
    ADD CONSTRAINT uk_application_type_name UNIQUE (name);

ALTER TABLE ONLY specialization
    ADD CONSTRAINT uk_specialization_name UNIQUE (name);

ALTER TABLE ONLY student_group
    ADD CONSTRAINT uk_student_group_name UNIQUE (name);

ALTER TABLE ONLY speciality
    ADD CONSTRAINT uk_speciality_code UNIQUE (code);

ALTER TABLE ONLY speciality
    ADD CONSTRAINT uk_speciality_name UNIQUE (name);

ALTER TABLE ONLY specialization
    ADD CONSTRAINT fk_educational_programs_faculty_id FOREIGN KEY (faculty_id) REFERENCES faculty(id);

ALTER TABLE ONLY specialization
    ADD CONSTRAINT fk_educational_programs_speciality_id FOREIGN KEY (speciality_id) REFERENCES speciality(id);

ALTER TABLE ONLY specialization
    ADD CONSTRAINT fk_specialization_degree FOREIGN KEY (degree_id) REFERENCES degree(id);

ALTER TABLE ONLY application
    ADD CONSTRAINT fk_application_application_type FOREIGN KEY (application_type_id) REFERENCES application_type(id);

ALTER TABLE ONLY student_degree
    ADD CONSTRAINT fk_student_degree_specialization FOREIGN KEY (specialization_id) REFERENCES specialization(id);

ALTER TABLE ONLY student_degree
    ADD CONSTRAINT fk_student_degree_student FOREIGN KEY (student_id) REFERENCES student(id);

ALTER TABLE ONLY student_degree
    ADD CONSTRAINT fk_student_degree_student_group FOREIGN KEY (student_group_id) REFERENCES student_group(id);

ALTER TABLE ONLY student_group
    ADD CONSTRAINT fk_student_group_specialization FOREIGN KEY (specialization_id) REFERENCES specialization(id);





