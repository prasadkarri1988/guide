DROP TABLE IF EXISTS trail;
  
create table trail (id bigint not null, end varchar(255), max_age integer, min_age integer, name varchar(255), price double, start varchar(255), primary key (id))