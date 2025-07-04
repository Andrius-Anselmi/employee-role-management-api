CREATE TABLE cargo (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    salario DOUBLE PRECISION NOT NULL ,
    descricao TEXT,
    nivel VARCHAR (20) NOT NULL
);