create table if not exists companies (
    id int primary key,
    company_name varchar(255) not null
);
create table if not exists employees (
    id int primary key,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    company varchar(255) not null,
    foreign key company references companies(id)
);