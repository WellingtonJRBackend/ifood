CREATE TABLE estado (
	id serial PRIMARY KEY not null,
	nome VARCHAR(80) not null);

INSERT INTO estado (nome) SELECT DISTINCT nome_estado from cidade;

ALTER TABLE cidade ADD COLUMN estado_id BIGINT not null;

UPDATE cidade  set estado_id = (SELECT e.id FROM estado e WHERE e.nome = nome_estado);

ALTER TABLE cidade ADD CONSTRAINT fk_cidade_estado
FOREIGN KEY(estado_id) REFERENCES estado(id);

ALTER TABLE cidade DROP COLUMN nome_estado;

ALTER TABLE cidade RENAME COLUMN nome_cidade TO nome;