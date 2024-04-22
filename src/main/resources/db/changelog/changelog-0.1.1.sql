-- CREATE SEQUENCE applicant_details;

CREATE TABLE applicant_detail
(
    id bigint NOT NULL PRIMARY KEY,
    applicant_name character varying(1000) COLLATE pg_catalog."default",
    applicant_age integer
)
