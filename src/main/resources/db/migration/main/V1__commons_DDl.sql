-----------------START--------------------

CREATE TABLE department (
    id bigint NOT NULL,
    name character varying(25),
    code character varying(25),
    description character varying(256),
    createddate timestamp without time zone,
    lastmodifieddate timestamp without time zone,
    createdby bigint,
    lastmodifiedby bigint,
    version bigint
);
CREATE SEQUENCE seq_department
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ONLY department
    ADD CONSTRAINT pk_department PRIMARY KEY (id);

------------------END---------------------

-----------------START--------------------

CREATE TABLE employee (
    id bigint NOT NULL,
    email character varying(100),
    mobile character varying(20),
    name character varying(150),
    address character varying(256),
    createddate timestamp without time zone,
    lastmodifieddate timestamp without time zone,
    createdby bigint,
    lastmodifiedby bigint,
    version bigint
);

CREATE SEQUENCE seq_employee
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY employee
    ADD CONSTRAINT pk_employee PRIMARY KEY (id);

------------------END---------------------

-----------------START--------------------

CREATE TABLE boundary (
    id bigint NOT NULL,
    name character varying(25),
    code character varying(25),
    description character varying(256),
    lat double precision,
    lng double precision,
    createddate timestamp without time zone,
    lastmodifieddate timestamp without time zone,
    createdby bigint,
    lastmodifiedby bigint,
    version bigint
);
CREATE SEQUENCE seq_boundary
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ONLY boundary
    ADD CONSTRAINT pk_boundary PRIMARY KEY (id);

------------------END---------------------
