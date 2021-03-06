create table customer_account (id int4 generated by default as identity, account_status varchar(255), account_type varchar(255) not null, customer_id int4 not null, primary key (id));

alter table if exists customer drop constraint if exists UK_irnrrncatp2fvw52vp45j7rlw;
alter table if exists customer add constraint UK_irnrrncatp2fvw52vp45j7rlw unique (username);
alter table if exists customer_account add constraint FK6c5oqutth35p5vmw0svg56msa foreign key (customer_id) references customer on delete cascade;
alter table if exists customer_account add column account_balance varchar(255);
alter table if exists customer_account add column account_number varchar(255) not null;
alter table if exists customer_account add column branch_id int4;
alter table if exists customer_account add constraint FKj7imyo8lql03jcojqme74r4nq foreign key (branch_id) references branch;