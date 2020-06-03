SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE public.application (
    id integer NOT NULL,
    application_type_id integer NOT NULL,
    headers character varying(800) NOT NULL,
    body character varying(1500) NOT NULL
);

ALTER TABLE public.application OWNER TO postgres;

CREATE SEQUENCE public.application_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.application_id_seq OWNER TO postgres;

ALTER SEQUENCE public.application_id_seq OWNED BY public.application.id;

CREATE TABLE public.application_type (
    id integer NOT NULL,
    name character varying(200) NOT NULL
);

ALTER TABLE public.application_type OWNER TO postgres;

CREATE SEQUENCE public.application_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.application_type_id_seq OWNER TO postgres;

ALTER SEQUENCE public.application_type_id_seq OWNED BY public.application_type.id;

CREATE TABLE public.specialization (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    speciality_id integer NOT NULL,
    faculty_id integer NOT NULL
);

ALTER TABLE public.specialization OWNER TO postgres;

CREATE SEQUENCE public.educational_programs_ep_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.educational_programs_ep_id_seq OWNER TO postgres;

ALTER SEQUENCE public.educational_programs_ep_id_seq OWNED BY public.specialization.id;

CREATE TABLE public.faculty (
    id integer NOT NULL,
    name text NOT NULL,
    dean_name character varying(50) NOT NULL
);

ALTER TABLE public.faculty OWNER TO postgres;

CREATE SEQUENCE public.faculties_faculty_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.faculties_faculty_id_seq OWNER TO postgres;

ALTER SEQUENCE public.faculties_faculty_id_seq OWNED BY public.faculty.id;

CREATE TABLE public.student_group (
    id integer NOT NULL,
    name character varying(12) NOT NULL,
    specialization_id integer NOT NULL
);

ALTER TABLE public.student_group OWNER TO postgres;

CREATE SEQUENCE public.groups_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.groups_id_seq OWNER TO postgres;

ALTER SEQUENCE public.groups_id_seq OWNED BY public.student_group.id;

CREATE TABLE public.speciality (
    id integer NOT NULL,
    code smallint NOT NULL,
    name character varying(60) NOT NULL
);

ALTER TABLE public.speciality OWNER TO postgres;

CREATE SEQUENCE public.speciality_speciality_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.speciality_speciality_id_seq OWNER TO postgres;

ALTER SEQUENCE public.speciality_speciality_id_seq OWNED BY public.speciality.id;

CREATE TABLE public.student (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    patronimic character varying(50) NOT NULL,
    sex character varying(6) DEFAULT 'MALE'::character varying NOT NULL
);

ALTER TABLE public.student OWNER TO postgres;

CREATE TABLE public.student_degree (
    id integer NOT NULL,
    payment character varying(8) DEFAULT 'BUDGET'::character varying NOT NULL,
    specialization_id integer NOT NULL,
    student_id integer NOT NULL,
    student_group_id integer NOT NULL,
    tuition_form character varying(10) NOT NULL
);

ALTER TABLE public.student_degree OWNER TO postgres;

CREATE SEQUENCE public.student_degree_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.student_degree_id_seq OWNER TO postgres;

ALTER SEQUENCE public.student_degree_id_seq OWNED BY public.student_degree.id;

CREATE SEQUENCE public.students_students_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.students_students_id_seq OWNER TO postgres;

ALTER SEQUENCE public.students_students_id_seq OWNED BY public.student.id;

ALTER TABLE ONLY public.application ALTER COLUMN id SET DEFAULT nextval('public.application_id_seq'::regclass);

ALTER TABLE ONLY public.application_type ALTER COLUMN id SET DEFAULT nextval('public.application_type_id_seq'::regclass);

ALTER TABLE ONLY public.faculty ALTER COLUMN id SET DEFAULT nextval('public.faculties_faculty_id_seq'::regclass);

ALTER TABLE ONLY public.speciality ALTER COLUMN id SET DEFAULT nextval('public.speciality_speciality_id_seq'::regclass);

ALTER TABLE ONLY public.specialization ALTER COLUMN id SET DEFAULT nextval('public.educational_programs_ep_id_seq'::regclass);

ALTER TABLE ONLY public.student ALTER COLUMN id SET DEFAULT nextval('public.students_students_id_seq'::regclass);

ALTER TABLE ONLY public.student_degree ALTER COLUMN id SET DEFAULT nextval('public.student_degree_id_seq'::regclass);

ALTER TABLE ONLY public.student_group ALTER COLUMN id SET DEFAULT nextval('public.groups_id_seq'::regclass);

SELECT pg_catalog.setval('public.application_id_seq', 1, false);

SELECT pg_catalog.setval('public.application_type_id_seq', 12, true);

SELECT pg_catalog.setval('public.educational_programs_ep_id_seq', 1, false);

SELECT pg_catalog.setval('public.faculties_faculty_id_seq', 1, false);

SELECT pg_catalog.setval('public.groups_id_seq', 1, false);

SELECT pg_catalog.setval('public.speciality_speciality_id_seq', 1, false);

SELECT pg_catalog.setval('public.student_degree_id_seq', 1, false);

SELECT pg_catalog.setval('public.students_students_id_seq', 1, false);

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.application_type
    ADD CONSTRAINT application_type_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.specialization
    ADD CONSTRAINT educational_programs_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.faculty
    ADD CONSTRAINT faculties_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.student_group
    ADD CONSTRAINT groups_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.speciality
    ADD CONSTRAINT speciality_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.student
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.faculty
    ADD CONSTRAINT uk_faculty_name UNIQUE (name);

ALTER TABLE ONLY public.specialization
    ADD CONSTRAINT educational_programs_faculty_id_fkey FOREIGN KEY (faculty_id) REFERENCES public.faculty(id);

ALTER TABLE ONLY public.specialization
    ADD CONSTRAINT educational_programs_speciality_id_fkey FOREIGN KEY (speciality_id) REFERENCES public.speciality(id);

ALTER TABLE ONLY public.application
    ADD CONSTRAINT fk_application_type FOREIGN KEY (application_type_id) REFERENCES public.application_type(id);

ALTER TABLE ONLY public.student_degree
    ADD CONSTRAINT fk_specialization FOREIGN KEY (specialization_id) REFERENCES public.specialization(id);

ALTER TABLE ONLY public.student_degree
    ADD CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES public.student(id);

ALTER TABLE ONLY public.student_degree
    ADD CONSTRAINT fk_student_group FOREIGN KEY (student_group_id) REFERENCES public.student_group(id);

ALTER TABLE ONLY public.student_group
    ADD CONSTRAINT groups_ep_id_fkey FOREIGN KEY (specialization_id) REFERENCES public.specialization(id);



