
create table if not exists Member
(
    id     serial
        primary key,
    github varchar(4000)
);

create table if not exists Expenditure
(
  id serial primary key ,
  expense integer,
  payer integer
);

create table if not exists Groups
(
    id serial primary key,
    name varchar(40)
);

create table if not exists Memberref
(
    id integer,
    groups integer,
    foreign key (groups) references Groups(id),
    primary key (id, groups)
);

create table if not exists Expenditureref
(
    id integer,
    groups integer,
     foreign key (groups) references Groups(id),
     primary key (id, groups)
);

create table if not exists Involved_Party
(
    id integer,
    expenditure integer,
    foreign key (expenditure) references Member(id),
    primary key (id, expenditure)
);





