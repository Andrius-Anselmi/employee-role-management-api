CREATE TABLE employee (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL,
    age INTEGER NOT NULL,
    state VARCHAR (20) NOT NULL,
    city VARCHAR (20) NOT NULL,
    position_id BIGINT,
    CONSTRAINT fk_employee_position FOREIGN KEY (position_id) REFERENCES positions(id)

);