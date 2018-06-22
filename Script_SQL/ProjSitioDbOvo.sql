drop table Ovos;
Create table Ovos (
	ID int not null,
    tipo_id int,
    data_embalagem date,
    qtd int,
    primary key (ID),
    foreign key (tipo_id) references Tipo_Ovos(ID)
);
drop table tipo_ovos;
Create table Tipo_Ovos (
	ID int not null,
    tipo varchar(30),
    preco double,
    primary key (ID)
);