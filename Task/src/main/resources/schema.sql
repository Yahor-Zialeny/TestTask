create table if not exists companies (
    id int primary key,
    company_name varchar(255) unique not null
);

create table if not exists employees (
    id int primary key,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    company_id int not null,
    foreign key (company_id) references companies(id)
);
