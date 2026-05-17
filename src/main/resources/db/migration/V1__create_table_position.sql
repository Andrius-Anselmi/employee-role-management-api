CREATE TABLE positions (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    salary DOUBLE PRECISION NOT NULL ,
    description TEXT NOT NULL ,
    seniority VARCHAR (20) NOT NULL
);