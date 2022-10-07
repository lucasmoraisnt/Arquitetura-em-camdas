create table t_cliente(
    id int primary key,
    nome varchar(50) not null,
    idade int not null,
    email varchar(120) not null
);

create table t_conta_banca(
    id int primary key,
    agencia varchar(4) not null,
    numero varchar(10) not null,
    saldo numeric(5,2) not null
);

alter table t_conta_banca add constraint fk_cliente_conta foreign key (id) references t_cliente (id);

select * from t_cliente order by id;
select * from t_conta_banca order by id;

drop table t_cliente cascade constraints;
drop table t_conta_banca cascade constraints;