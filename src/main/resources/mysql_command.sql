-- To check all databases
show databases;

-- Create Database
create databases [database_name];

-- Perform action on specific database
use [database_name];

-- create table
create table [table_name]([column_name] [data_type](size));

-- descrive table
desc [table_name];


--modify table
-- add column
alter table [table_name] add [column_name][data_type(size)];

-- to modify existing column
alter table [table_name] modify [column_name][data_type(size)];

-- renmae column change
alter table [table_name] rename column [old_column_name] to [new_column_name];

-- delete column
alter table [table_name] drop column [column_name];

-- add data into table
insert into [table_name] values();

-- add multiple value
insert into [table_name] values(),(),();

-- update value of any column
update [table_name] set col_name=val_name, col2_name=val2_name where id=1;

-- delete all column
delete from [table_name];

-- delete specific column
delete from [table_name] where condition;
delete from student where id=1;

-- create foreign key
create table [table_name](column_name data_type(size), Foreign_key_name data_type, FOREIGN KEY(Foreign_key_name) REFERENCES [another_table_name][another_table_primary_key_id]);
