drop table if EXISTS films_proj;
create table films_proj (
  id int(8) NOT NULL,
  title varchar(100),
  year int(8),
  director varchar(100),
  duration int(8),
  credits varchar(100),
  review TEXT);

