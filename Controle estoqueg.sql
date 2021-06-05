/**
 * Projeto 2: Controle de estoque
 * Versão 1.0
 * @author Professor Jose de Assis
 */

show databases;
create database dbestoqueg;
use dbestoqueg;
show tables;
drop table estoque;



/*
	unique -> impede valores duplicados no campo da tabela
    timestamp default current_timestamp -> data/hora automático
    date -> Data no formato (YYYYMMDD)
    decimal(10,2) (digitos, casas decimais) -> tipo numérico real    
*/


create table estoque (
	codigo int primary key auto_increment,
    barcode varchar(50) unique,
    produto varchar(100) not null,
    fabricante varchar(100) not null,
    datacad timestamp default current_timestamp,
    dataval date not null,
    quantidade int not null,
    estoquemin int not null,
    medida varchar(50) not null,
    valor decimal(10,2),
    localizacao varchar(100) 
);

describe estoque;

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,
estoquemin,medida,valor,localizacao)
values
('11111111','Régua 30cm','Faber',20230531,
50,20,'unidade',2.35,'Setor A');

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,
estoquemin,medida,valor,localizacao)
values
('22222222','Cola bastão cx 10','Bic','20220520',50,
5,'caixa',12.50,'Setor B');

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,
estoquemin,medida,valor,localizacao)
values
('33333333','Grampeador','Singer',20260531,20,5,'unidade',23.70,'Setor C');

insert into estoque
(barcode,produto,fabricante,dataval,quantidade,
estoquemin,medida,valor,localizacao)
values
('44444444','Caneta','Bic',20230623,40,8,'caixa',10.50,'Setor D');

select * from estoque;
/*
Formatando e realizando operações no banco de dados
Para formartar uma data usamos a função:
date_format(campo, formato)
Formato %d%m%y' (dia, mês e ano com 2 dígitos)
Formato %d%m%Y' (dia, mês e ano com 4 dígitos)
sum() -> função usada para somar valores numéricos
datediff(data,data2) -> função usada para obter a diferença em dias entre datas
curdate() -> função usada para obter a data atual
*/

-- executando operações matemáticas no select (inventário)
select sum(valor * quantidade) as Total from estoque;

-- relatório de reposição de estoque 1
select * from estoque where quantidade < estoquemin;

-- relatório de reposição de estoque 2
select codigo as código, produto,
date_format(dataval,'%d/%m/%Y') as data_validade,
quantidade,estoquemin as estoque_mínimo
from estoque where quantidade < estoquemin;


-- relatório de controle de validade 2
select codigo,produto,
date_format(dataval,'%d/%m/%Y') as validade,
datediff(dataval, curdate()) as dias_restantes
from estoque;


