create table transaction (id int4 generated by default as identity, amount varchar(255), comment varchar(255), transection_status boolean, transection_on timestamp, customer_from_id int4, customer_to_id int4, primary key (id));alter table if exists transaction add column from_id int4;
alter table if exists transaction add column to_id int4;
alter table if exists transaction add constraint FKi6eayaejcnw538uag98rt3gb6 foreign key (from_id) references customer_account;
alter table if exists transaction add constraint FKcu4sxdj3huimwyw27uhi9b67i foreign key (to_id) references customer_account;
