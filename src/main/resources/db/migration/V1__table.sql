
create table if not exists "Member"
(
    id     serial
        primary key,
    github varchar(40)
);

create table if not exists "Expenditure"
(
  id serial primary key ,
  expense integer,
  payer integer
);

create table if not exists "Group"
(
    id serial primary key,
    name varchar(40)
);

create table if not exists "Memberref"
(
    id integer,
    groupId integer,
    foreign key (groupId) references "Group"(id),
    primary key (id, groupId)
);

create table if not exists "Expenditureref"
(
    id integer,
    groupId integer,
     foreign key (groupId) references "Group"(id),
     primary key (id, groupId)
);

create table if not exists "Involved_Party"
(
    id integer,
    expenditureId integer,
    foreign key (expenditureId) references "Member"(id),
    primary key (id, expenditureId)
);





