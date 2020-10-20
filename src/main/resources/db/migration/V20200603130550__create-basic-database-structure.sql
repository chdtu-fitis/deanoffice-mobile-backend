CREATE TABLE public.application (
    id integer NOT NULL,
    application_type_id integer NOT NULL,
    header character varying(800) NOT NULL,
    body character varying(1500) NOT NULL
);

ALTER TABLE public.application OWNER TO postgres;

CREATE SEQUENCE public.application_id_seq
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
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.application_type_id_seq OWNER TO postgres;

ALTER SEQUENCE public.application_type_id_seq OWNED BY public.application_type.id;

CREATE TABLE public.degree (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);

ALTER TABLE public.degree OWNER TO postgres;

CREATE SEQUENCE degree_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.degree_id_seq OWNED BY degree.id;

CREATE TABLE public.specialization (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    speciality_id integer NOT NULL,
    faculty_id integer NOT NULL,
    degree_id integer NOT NULL
);

ALTER TABLE public.specialization OWNER TO postgres;

CREATE SEQUENCE public.educational_programs_ep_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.educational_programs_ep_id_seq OWNER TO postgres;

ALTER SEQUENCE public.educational_programs_ep_id_seq OWNED BY public.specialization.id;

CREATE TABLE public.faculty (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    dean_name character varying(50) NOT NULL,
    abbr character varying(20) NOT NULL
);

ALTER TABLE public.faculty OWNER TO postgres;

CREATE SEQUENCE public.faculties_faculty_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.faculties_faculty_id_seq OWNER TO postgres;

ALTER SEQUENCE public.faculties_faculty_id_seq OWNED BY public.faculty.id;

CREATE TABLE public.application_user
(
    id integer NOT NULL,
    username character varying(30) COLLATE pg_catalog."default" NOT NULL,
    password character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT application_user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.application_user
    OWNER to postgres;

CREATE TABLE public.student_group (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    specialization_id integer NOT NULL
);

ALTER TABLE public.student_group OWNER TO postgres;

CREATE SEQUENCE public.groups_id_seq
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
    name character varying(100) NOT NULL
);

ALTER TABLE public.speciality OWNER TO postgres;

CREATE SEQUENCE public.speciality_speciality_id_seq
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
    payment character varying(25) DEFAULT 'BUDGET'::character varying NOT NULL,
    specialization_id integer NOT NULL,
    student_id integer NOT NULL,
    student_group_id integer NOT NULL,
    tuition_form character varying(10) NOT NULL,
    active boolean NOT NULL
);

ALTER TABLE public.student_degree OWNER TO postgres;

CREATE SEQUENCE public.student_degree_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.student_degree_id_seq OWNER TO postgres;

ALTER SEQUENCE public.student_degree_id_seq OWNED BY public.student_degree.id;

CREATE SEQUENCE public.students_students_id_seq
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

ALTER TABLE ONLY public.degree ALTER COLUMN id SET DEFAULT nextval('degree_id_seq'::regclass);

ALTER TABLE ONLY public.student ALTER COLUMN id SET DEFAULT nextval('public.students_students_id_seq'::regclass);

ALTER TABLE ONLY public.student_degree ALTER COLUMN id SET DEFAULT nextval('public.student_degree_id_seq'::regclass);

ALTER TABLE ONLY public.student_group ALTER COLUMN id SET DEFAULT nextval('public.groups_id_seq'::regclass);

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.application_type
    ADD CONSTRAINT application_type_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.degree
    ADD CONSTRAINT degree_pkey PRIMARY KEY (id);

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

ALTER TABLE ONLY public.degree
    ADD CONSTRAINT uk_degree_name UNIQUE (name);

ALTER TABLE ONLY public.specialization
    ADD CONSTRAINT fk_educational_programs_faculty_id FOREIGN KEY (faculty_id) REFERENCES public.faculty(id);

ALTER TABLE ONLY public.specialization
    ADD CONSTRAINT fk_educational_programs_speciality_id FOREIGN KEY (speciality_id) REFERENCES public.speciality(id);

ALTER TABLE ONLY public.application
    ADD CONSTRAINT fk_application_application_type FOREIGN KEY (application_type_id) REFERENCES public.application_type(id);

ALTER TABLE ONLY public.student_degree
    ADD CONSTRAINT fk_student_degree_specialization FOREIGN KEY (specialization_id) REFERENCES public.specialization(id);

ALTER TABLE ONLY public.student_degree
    ADD CONSTRAINT fk_student_degree_student FOREIGN KEY (student_id) REFERENCES public.student(id);

ALTER TABLE ONLY public.student_degree
    ADD CONSTRAINT fk_student_degree_student_group FOREIGN KEY (student_group_id) REFERENCES public.student_group(id);

ALTER TABLE ONLY public.student_group
    ADD CONSTRAINT fk_student_group_specialization FOREIGN KEY (specialization_id) REFERENCES public.specialization(id);

ALTER TABLE ONLY specialization
    ADD CONSTRAINT fk_specialization_degree FOREIGN KEY (degree_id) REFERENCES public.degree(id);



