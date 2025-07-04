CREATE TABLE funcionario (
    id SERIAL PRIMARY KEY ,
    nome VARCHAR (50) NOT NULL ,
    idade INTEGER NOT NULL ,
    uf VARCHAR (20) NOT NULL ,
    cidade VARCHAR (20) NOT NULL,
    cargo_id INTEGER,
    constraint fk_funcionario_cargo FOREIGN KEY (cargo_id) REFERENCES cargo(id)

);