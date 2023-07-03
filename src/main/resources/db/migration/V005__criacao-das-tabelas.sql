create table forma_pagamento (
id bigserial not null,
descricao varchar(80), primary key (id));


create table grupo (id bigserial not null,
 nome varchar(80) not null,
 primary key (id));

 create table grupo_permissao (
 grupo_id bigint not null,
  permissao_id bigint not null);

  create table permissao (
  id bigserial not null,
  descricao varchar(80),
  nome varchar(65) not null,
  primary key (id));

  create table produto (
  id bigserial not null,
  ativo boolean not null,
  descricao varchar(255) not null,
  preco numeric(38,2) not null,
  restaurante_id bigint not null,
  primary key (id));

  create table restaurante (
  id bigserial not null,
  data_atualizacao timestamp(6),
  data_cadastro timestamp(6),
  endereco_bairro varchar(80),
  endereco_cep varchar(60),
  endereco_complemento varchar(60),
  endereco_logradouro varchar(80),
  endereco_numero varchar(25),
  nome varchar(80) not null,
  taxa_frente numeric(38,2) not null,
  cozinha_id bigint not null,
  endereco_cidade_id bigint,
  primary key (id));

  create table restaurante_forma_pagamento(
  restaurante_id bigint not null,
  forma_pagamento_id bigint not null);

  create table usuario (
  id bigserial not null,
  data_cadastro timestamp(6),
  email varchar(255) not null,
  nome varchar(255) not null,
  senha varchar(255) not null,
  primary key (id));

  create table usuario_grupo (
  usuario_id bigint not null,
  grupo_id bigint not null);