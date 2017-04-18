-----------------START--------------------
CREATE TABLE complaintstatus (
    id bigint NOT NULL,
    name character varying(25),
    version bigint
);
CREATE SEQUENCE seq_complaintstatus
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ONLY complaintstatus
    ADD CONSTRAINT pk_complaintstatus PRIMARY KEY (id);

------------------END---------------------

-----------------START-------------------

CREATE SEQUENCE seq_complainttype_category;

CREATE TABLE complainttype_category(
	id numeric primary key,
	name varchar(100) unique,
	description varchar(250),
	version numeric default 0
);

------------------END---------------------
-----------------START--------------------
CREATE TABLE complainttype (
    id numeric NOT NULL,
    name character varying(150),
    department bigint,
    category bigint,
    code character varying(20),
    isactive boolean,
    description character varying(100),
    createddate timestamp without time zone,
    lastmodifieddate timestamp without time zone,
    createdby bigint,
    lastmodifiedby bigint,
    version bigint
);


CREATE SEQUENCE seq_complainttype
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY complainttype
    ADD CONSTRAINT pk_pgr_complainttype_id PRIMARY KEY (id);

ALTER TABLE ONLY complainttype
    ADD CONSTRAINT uk_complainttype_code UNIQUE (code);

ALTER TABLE ONLY complainttype
    ADD CONSTRAINT uk_pgr_complainttype_name UNIQUE (name);

CREATE INDEX idx_pgr_complainttype_department ON complainttype USING btree (department);

ALTER TABLE ONLY complainttype
    ADD CONSTRAINT fk_pgr_complainttype_deptid FOREIGN KEY (department) REFERENCES department(id);

ALTER TABLE ONLY complainttype
    ADD CONSTRAINT fk_pgr_complainttype_categoryid FOREIGN KEY (category) REFERENCES complainttype_category(id);

------------------END---------------------

-----------------START--------------------


CREATE TABLE complainant (
    id bigint NOT NULL,
    email character varying(100),
    mobile character varying(20),
    name character varying(150),
    address character varying(256),
    version bigint
);

CREATE SEQUENCE seq_complainant
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY complainant
    ADD CONSTRAINT pk_complainant PRIMARY KEY (id);

------------------END---------------------

-----------------START--------------------
CREATE TABLE complaint (
    id bigint NOT NULL,
    crn character varying(100),
    createddate timestamp without time zone,
    lastmodifieddate timestamp without time zone,
    createdby bigint,
    lastmodifiedby bigint,
    complainttype bigint NOT NULL,
    complainant bigint NOT NULL,
    assignee bigint,
    location bigint,
    details character varying(500) NOT NULL,
    landmarkdetails character varying(200),
    lat double precision,
    lng double precision,
    status bigint,
    department bigint,
    comments character varying(1024),
    version bigint
);


CREATE SEQUENCE seq_complaint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER TABLE ONLY complaint
    ADD CONSTRAINT pk_complaint PRIMARY KEY (id);

ALTER TABLE ONLY complaint
    ADD CONSTRAINT uk_complaint_crn UNIQUE (crn);


CREATE INDEX idx_pgr_complaint_boundary ON complaint USING btree (location);
CREATE INDEX idx_pgr_complaint_complainttype ON complaint USING btree (complainttype);
CREATE INDEX idx_pgr_complaint_user ON complaint USING btree (assignee);

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fk_complaint_ FOREIGN KEY (complainant) REFERENCES complainant(id);
ALTER TABLE ONLY complaint
    ADD CONSTRAINT fk_complaint_boundary FOREIGN KEY (location) REFERENCES boundary(id);
ALTER TABLE ONLY complaint
    ADD CONSTRAINT fk_complaint_complainttype FOREIGN KEY (complainttype) REFERENCES complainttype(id);

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fk_complaint_position FOREIGN KEY (assignee) REFERENCES employee(id);

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fk_complaint_status FOREIGN KEY (status) REFERENCES complaintstatus(id);

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fk_department FOREIGN KEY (department) REFERENCES department(id);

CREATE INDEX idx_pgr_complaint_complainant ON complaint USING btree (complainant);

------------------END---------------------



