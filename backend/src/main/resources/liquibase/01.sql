--liquibase formatted sql

--changeset Shipov:01.sql stripComments:false failOnError:true

create sequence if not exists seq_employee_pkey increment by 1 minvalue 1 no cycle;
create sequence if not exists seq_salary_pkey increment by 1 minvalue 1 no cycle;

create table if not exists employee
(
    id                     bigint default nextval('seq_employee_pkey') primary key, -- Первичный ключ
    name varchar -- Имя пользователя
);
comment on table employee is 'Сотрудник';
comment on column employee.id is 'Первичный ключ';
comment on column employee.name is 'ФИО';

create table if not exists salary
(
    id                     bigint default nextval('seq_salary_pkey') primary key, -- Первичный ключ
    amount decimal, -- Размер
    employee_id bigint references employee(id) -- Идентификатор сотрудника
    );
comment on table salary is 'Оклад';
comment on column salary.id is 'Первичный ключ';
comment on column salary.amount is 'Размер';
comment on column salary.employee_id is 'Идентификатор сотрудника';

--rollback ;
