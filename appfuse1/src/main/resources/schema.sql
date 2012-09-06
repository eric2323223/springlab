    drop table ss_role if exists;


    create table ss_role (
        id bigint,
        name varchar(255) not null,
        primary key (id)
    );