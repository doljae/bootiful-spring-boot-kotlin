drop table if exists dog;
create table dog
(
    id          serial
        primary key,
    name        text not null,
    description text not null,
    dob         date not null,
    owner       text
);

alter table dog
    owner to postgres;

