
CREATE TABLE public.speciality (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    name_eng character varying(100),
    active boolean NOT NULL,
    code character varying(20) NOT NULL,
    field_of_study character varying(150),
    field_of_study_code character varying(20),
    field_of_study_eng character varying(150)
);


CREATE SEQUENCE public.speciality_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.speciality ALTER COLUMN id SET DEFAULT nextval('public.speciality_id_seq'::regclass);

COPY public.speciality (id, name, name_eng, active, code, field_of_study, field_of_study_code, field_of_study_eng) FROM stdin;
13	Системи і методи прийняття рішень		t	8.04030302	\N	\N	\N
15	Інформаційні управляючі системи та технології		t	8.05010101	\N	\N	\N
17	Інформаційні технології проектування		t	8.05010201	\N	\N	\N
18	Економіка і підприємництво		f	6.050100	\N	\N	\N
19	Економічна кібернетика		f	7.050102	\N	\N	\N
23	Системне програмування		t	8.05010202	\N	\N	\N
25	Спеціалізовані комп'ютерні системи		t	8.05010203	\N	\N	\N
28	Програмне забезпечення систем		t	8.05010301	\N	\N	\N
32	Управління інформаційною безпекою		t	7.17010301	\N	\N	\N
33	Управління інформаційною безпекою		t	8.170103	\N	\N	\N
71	Дизайн	Design	t	022	Культура і мистецтво	02	Culture and Arts
72	Історія та археологія	History and Archeology	t	032	Гуманітарні науки	03	Humanities
42	Електротехнічні системи електроспоживання		t	7.05070103	\N	\N	\N
50	Прилади і системи точної механіки		t	7.05100302	\N	\N	\N
51	Прилади і системи точної механіки		t	8.05100302	\N	\N	\N
52	Медичні прилади і системи		t	7.05100307	\N	\N	\N
53	Медичні прилади і системи		t	8.05100307	\N	\N	\N
57	Системи технічного захисту інформації		t	6.170102	\N	\N	\N
58	Системи технічного захисту інформації, автоматизація її обробки		t	7.17010201	\N	\N	\N
59	Управління проектами		t	8.18010013	\N	\N	\N
73	Філософія	Philosophy	t	033	Гуманітарні науки	03	Humanities
74	Філологія	Philology	t	035	Гуманітарні науки	03	Humanities
75	Економіка	Economics	t	051	Соціальні та поведінкові науки	05	Social and Behavioral Studies
76	Облік і оподаткування	Accounting and Taxation	t	071	Управління та адміністрування	07	Management and Administration
77	Фінанси, банківська справа та страхування	Finance, Banking and Insurance	t	072	Управління та адміністрування	07	Management and Administration
78	Менеджмент	Management	t	073	Управління та адміністрування	07	Management and Administration
79	Маркетинг	Marketing	t	075	Управління та адміністрування	07	Management and Administration
81	Право	Law	t	081	Право	08	Law
82	Екологія	Environmental  Studies	t	101	Природничі науки	10	Natural Sciences
83	Прикладна механіка	Applied Mechanics	t	131	Механічна інженерія	13	Mechanical Engineering
84	Галузеве машинобудування	Industrial Machinery Engineering	t	133	Механічна інженерія	13	Mechanical Engineering
40	Телекомунікації та радіотехніка	Telecommunications and Radio Engineering	t	172	Електроніка та телекомунікації	17	Electronics and Telecommunications
36	Електроенергетика, електротехніка та електромеханіка	Electrical Energetics, Electrical Engineering and Electromechanics	t	141	Електрична інженерія	14	Electrical Engineering
47	Телекомунікаційні системи та мережі		t	7.05090302	Радіотехніка, радіоелектронні апарати та зв'язок	0509	Radio Engineering, Radio Electronic Equipment and Communications
86	Хімічні технології та інженерія	Chemical Technology and Engineering	t	161	Хімічна та біоінженерія	16	Chemical and Bioengineering
87	Харчові технології	Food Technology	t	181	Виробництво та технології	18	Manufacturing and Technology
88	Видавництво та поліграфія	Publishing and Printing	t	186	Виробництво та технології	18	Manufacturing and Technology
89	Будівництво та цивільна інженерія	Building and Civil Engineering	t	192	Архітектура та будівництво	19	Architecture and Construction
90	Геодезія та землеустрій	Geodesy and Land Management	t	193	Архітектура та будівництво	19	Architecture and Construction
20	Комп'ютерна інженерія	Computer Engineering	t	6.050102	Інформатика та обчислювальна техніка	0501	Computer Literacy and Information Technology
22	Системне програмування		f	7.05010202	\N	\N	\N
14	Інформаційні управляючі системи та технології		f	7.05010101	\N	\N	\N
16	Інформаційні технології проектування		f	7.05010102	\N	\N	\N
21	Комп'ютерні системи та мережі		f	7.05010201	\N	\N	\N
80	Підприємництво, торгівля та біржова діяльність	Business, Trade and Exchange Activities	t	076	Управління та адміністрування	07	Management and Administration
29	Системна інженерія	System Engineering	t	6.050201	Автоматика та управління	0502	Automation and Management
43	Радіотехніка	Radio Engineering	t	6.050901	Радіотехніка, радіоелектронні апарати та зв'язок	0509	Radioengineering, Radioelectronic Technologies and Communications
85	Теплоенергетика	Thermal Power Engineering	t	144	Електрична інженерія	14	Electrical Engineering
91	Соціальне забезпечення	Social Welfare	t	232	Соціальна робота	23	Social Work
95	Публічне управління та адміністрування	Public Administration	t	281	Публічне управління та адміністрування	28	Public Administration
96	Дизайн	Design	t	6.020207	Мистецтво	0202	Arts
97	Філологія	Philology	t	6.020303	Гуманітарні науки	0203	Humanities
98	Економічна кібернетика	Economic Cybernetics	t	6.030502	Економіка та підприємництво	0305	Economics and Entrepreneurship
99	Міжнародна економіка	International Economics	t	6.030503	Економіка та підприємництво	0305	Economics and Entrepreneurship
100	Економіка підприємства	Economics of Enterprise	t	6.030504	Економіка та підприємництво	0305	Economics and Entrepreneurship
101	Маркетинг	Marketing	t	6.030507	Економіка та підприємництво	0305	Economics and Entrepreneurship
102	Фінанси і кредит	Finance and Credit	t	6.030508	Економіка та підприємництво	0305	Economics and Entrepreneurship
103	Облік і аудит	Accounting and Audit	t	6.030509	Економіка та підприємництво	0305	Economics and Entrepreneurship
104	Менеджмент	Management	t	6.030601	Менеджмент і адміністрування	0306	Management and Administration
109	Хімічна технологія	Chemical Technologies	t	6.051301	Хімічна технологія та інженерія	0515	Chemical Technologies and Enginnering
110	Видавничо-поліграфічна справа	Printing and Publishing	t	6.051501	Видавничо-поліграфічна справа	0515	Printing and Publishing
112	Будівництво	Construction	t	6.060101	Будівництво та архітектура	0601	Construction and Architecture
115	Геодезія, картографія та землеустрій	Geodesy, Cartography and Land Management	t	6.080101	Геодезія  та  землеустрій	0801	Geodesy and Land Management
10	Системний аналіз	System Analysis	t	8.040303	\N	\N	\N
9	Системний аналіз	System Analysis	t	7.040303	\N	\N	\N
39	Мікро- та наносистемна техніка	Micro- and Nano-System Technology	t	153	Автоматизація та приладобудування	15	Automation and Instrumentation
38	Метрологія та інформаційно-вимірювальна техніка	Metrology and Information-Measuring Technology	t	152	Автоматизація та приладобудування	15	Automation and Instrumentation
106	Інженерна механіка	Mechanical Engineering	t	6.050502	Машинобудування та матеріалообробка	0505	Mechanical Engineering and Machining
105	Екологія, охорона навколишнього середовища та збалансоване природокористування	Ecology, Environmental Protection and Conservation of Nature	t	6.040106	Природничі науки	0401	Natural Sciences
114	Автомобільний транспорт	Motor Vehicle Transport	t	6.070106	Транспорт і транспортна інфраструктура	0701	Transport and Transport Infrastructure
111	Харчові технології та інженерія	Food Industry Technologies and \nEngineering	t	6.051701	Харчова промисловість та переробка сільськогосподарської продукції	0517	Food Industry and Produce Processing
116	Готельно-ресторанна справа	Hotel, Restaurant and Catering	t	6.140101	Сфера обслуговування	1401	Services
117	Туризм	Tourism	t	6.140103	Сфера обслуговування	1401	Personal Services
4	Системний аналіз	System Analysis	t	124	Інформаційні технології	12	Information Technologies
11	Комп'ютерні науки	Computer Science	t	6.050101	Інформатика та обчислювальна техніка	0501	Computer Literacy and Information Technology
113	Транспортні технології	Transport Technology	t	6.070101	Транспорт	0701	Transport
7	Автоматизація та комп'ютерно-інтегровані технології	Automation and Computer-Integrated Technologies	t	151	Автоматизація та приладобудування	15	Automation and Instrumentation
2	Комп'ютерні науки	Computer Sciences	t	122	Інформаційні технології	12	Information Technologies
5	Кібербезпека	Cyber Security	t	125	Інформаційні технології	12	Information Technologies
1	Інженерія програмного забезпечення	Software Engineering	t	121	Інформаційні технології	12	Information Technologies
3	Комп'ютерна інженерія	Computer Engineering	t	123	Інформаційні технології	12	Information Technologies
8	Системний аналіз	System Analysis	t	6.040303	Системні науки та кібернетика	0403	System Sciences and Cybernetics
92	Готельно-ресторанна справа	Hotel, Restaurant and Catering	t	241	Сфера обслуговування	24	Services
107	Машинобудування	Machine Engineering	t	6.050503	Машинобудування та матеріалообробка	0505	Mechanical Engineering and Machining
108	Теплоенергетика	Heat and Power Engineering	t	6.050601	Енергетика та енергетичне машинобудування	0506	Power Engineering and Power Mechanical Engineering
34	Автомобільний транспорт	Motor Vehicle Transport	t	274	Транспорт	27	Transport Services
45	Радіотехніка	Radio Engineering	t	8.05090101	Радіотехніка, радіоелектронні апарати та зв'язок	0509	Radio Engineering, Radio Electronic Equipment and Communications
44	Радіотехніка	Radio Engineering	t	7.05090101	Радіотехніка, радіоелектронні апарати та зв'язок	0509	Radio Engineering, Radio Electronic Equipment and Communications
48	Телекомунікаційні системи та мережі		t	8.05090302	Радіотехніка, радіоелектронні апарати та зв'язок	0509	Radio Engineering, Radio Electronic Equipment and Communications
41	Електротехніка та електротехнології	Electrical Engineering and Electrotechnics	t	6.050701	Електротехніка та електромеханіка	0507	Electrical Engineering and Electromechanics
55	Безпека інформаційних і комунікаційних систем	Information and Communications Systems Security	t	7.17010101	Інформаційна безпека	1701	Information Security
56	Безпека інформаційних і комунікаційних систем	Information and Communications Systems Security	t	8.17010101	Інформаційна безпека	1701	Information Security
31	Управління інформаційною безпекою	Information Security Management	t	6.170103	Інформаційна безпека	1701	Information Security
54	Безпека інформаційних і комунікаційних систем	Information and Communications Systems Security	t	6.170101	Інформаційна безпека	1701	Information Security
27	Програмне забезпечення систем		f	7.05010301	\N	\N	\N
30	Системна інженерія		f	7.050201	\N	\N	\N
24	Спеціалізовані комп'ютерні системи		f	7.05010203	\N	\N	\N
12	Системи і методи прийняття рішень		f	7.04030302	\N	\N	\N
120	Автомобілі та автомобільне господарство	Automobiless and Automobile Economy	t	7.07010601	Транспорт	0701	Transport
121	Хімічна технологія неорганічних речовин	Chemical Technology of Inorganic Substances	t	7.091603	Хімічна технологія та інженерія	\N	Chemical Technologies and Engineering
119	Комп'ютерні науки та інформаційні технології	Computer Science and Information Technology	t	122	Інформаційні технології	12	Information Technologies
6	Інформаційні системи та технології	Information Systems and Technology	t	126	Інформаційні технології	12	Information Technologies
26	Програмна інженерія	Software Engineering	t	6.050103	Інформатика та обчислювальна техніка	0501	Computer Literacy and Information Technology
49	Приладобудування	Instrument Engineering	t	6.051003	Метрологія, вимірювальна техніка та інформаційно-вимірювальні технології	0510	Metrology, Measuring Instruments and Information-Measuring Technologies
46	Телекомунікації	Telecommunications	t	6.050903	Радіотехніка, радіоелектронні апарати та зв'язок	0509	Radioengineering, Radioelectronic Technologies and Communications
93	Туризм	Tourism	t	242	Сфера обслуговування	24	Personal Services
94	Транспортні технології	Transport Technology	t	275	Транспорт	27	Transport Services
122	Статистика	Statistics	t	112	Математика та статистика	11	Mathematics and Statistics
123	Матеріалознавство	\N	t	132	Механічна інженерія	13	Mechanical Engineering
118	Дизайн	Design	t	8.02020701	\N	\N	\N
124	Лісове господарство	Forestry	t	205	Аграрні науки та продовольство	20	Agrarian Science and Food
\.

SELECT pg_catalog.setval('public.speciality_id_seq', 124, true);

ALTER TABLE ONLY public.speciality
    ADD CONSTRAINT speciality_pkey PRIMARY KEY (id);

ALTER TABLE speciality ADD CONSTRAINT uk_speciality_name_and_code UNIQUE (name, code);
