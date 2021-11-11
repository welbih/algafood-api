insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

INSERT INTO estado (nome, uf) VALUES ('Minas Gerais', 'MG');
INSERT INTO estado (nome, uf) VALUES ('São Paulo', 'SP');
INSERT INTO estado (nome, uf) VALUES ('Ceará', 'CE');

INSERT INTO cidade (nome, estado_id) VALUES ('Uberlândia', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('Belo Horizonte', 1);
INSERT INTO cidade (nome, estado_id) VALUES ('São Paulo', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Campinas', 2);
INSERT INTO cidade (nome, estado_id) VALUES ('Fortaleza', 3);

INSERT INTO restaurante (nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, data_cadastro, data_atualizacao) VALUES ('Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro', utc_timestamp, utc_timestamp);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Tuk Tuk  Comida Indiana', 15, 2, utc_timestamp, utc_timestamp);

INSERT INTO forma_pagamento (descricao) VALUES ('Cartão de crédito');
INSERT INTO forma_pagamento (descricao) VALUES ('Cartão de débito');
INSERT INTO forma_pagamento (descricao) VALUES ('Dinheiro');
INSERT INTO forma_pagamento (descricao) VALUES ('Pix');

INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);