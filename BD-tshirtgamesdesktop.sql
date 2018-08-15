create database crashsolutions_bd;
use crashsolutions_bd;

/*VISUALIZAR TABELAS*/
select*from produtos;
select*from funcionarios;
select*from administrador; 

/*TABELA DE PRODUTOS*/
create table produtos (
id int not null auto_increment,
produto varchar(150),
imagem varchar(400) not null,
modelo varchar(150),
tamanho char(3),
cor varchar(20),
valor_custo float(10, 2),
valor_venda float(10, 2),
quantidade int(10),
primary key(id)
);

/*TABELA FUNCIONÁRIOS*/
create table funcionarios (
idfunc int not null auto_increment,
nome varchar(50),
sobrenome varchar(50),
endereco varchar(50),
numero varchar(10),
datanasc varchar(20),
tel varchar(20),
cel varchar(20),
email varchar(50),
sexo varchar(20),
cpf varchar(20),
rg varchar(20),
dataadm varchar(11),
cargo varchar(30),
salario float(50),
usuario varchar(30),
senha varchar(30),
ativo varchar(30),
primary key(idfunc)
);

/*TABELA DE ADMINISTRADOR*/
create table administrador (
nome varchar(50),
usuario varchar(30),
senha varchar(30)
);