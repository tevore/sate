--liquibase formatted sql
--changeset tevore:1
create table restaurants(
    id bigint auto_increment primary key,
    name varchar(100) not null,
    cuisine varchar(50) not null,
    address1 varchar(200) not null,
    address2 varchar(200),
    city varchar(50) not null,
    state_code varchar(5) not null,
    postal_code varchar(20) not null
);