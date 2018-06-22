drop table user;
create table user (
	login varchar(30) not null,
    senha varchar(30) not null,
    hierarquia tinyint(1) unsigned not null,
    nome_completo varchar(255),
    funcaoID int,
    primary key (login),
    foreign key (funcaoID) references funcao(ID)
);