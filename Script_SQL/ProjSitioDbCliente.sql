create table Cliente (
	ID int not null,
    nome varchar(30),
    sobrenome varchar(60),
    email varchar(30),
    telefone varchar(20),
    saldo double,
    primary key (ID)
);
create table Transferencia (
	ID int not null,
    cliente_cod int not null,
    valor double,
    data_transf date,
    primary key (ID),
    foreign key (cliente_cod) references cliente(ID)
);