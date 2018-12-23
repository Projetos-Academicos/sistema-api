CREATE TABLE pessoa (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	ativo BOOLEAN NOT NULL,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(50),
	numero BIGINT(10),
	complemento VARCHAR(50),
	cep VARCHAR(50),
	bairro VARCHAR(50),
	cidade VARCHAR(50),
	estado VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (ativo, nome, logradouro, numero, complemento, cep, bairro, cidade, estado) values (true, "ricardo", "ibimirim", 32, "c", "54410680", "piedade", "jaboatao", "PE");
INSERT INTO pessoa (ativo, nome, logradouro, numero, complemento, cep, bairro, cidade, estado) values (true, "teste", "teste", 1, "t", "5441896", "piedade", "teste", "TE");
INSERT INTO pessoa (ativo, nome, logradouro, numero, complemento, cep, bairro, cidade, estado) values (true, "lucas", "aratu", 64, "a", "65986595", "piedade", "recife", "PE");
INSERT INTO pessoa (ativo, nome, logradouro, numero, complemento, cep, bairro, cidade, estado) values (true, "maik", "sao paulo", 10, "d", "65988740", "piedade", "olinda", "PE");
INSERT INTO pessoa (ativo, nome, logradouro, numero, complemento, cep, bairro, cidade, estado) values (true, "xd", "xd", 12, "xd", "xd", "piedade", "xd", "xd");
