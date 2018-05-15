create sequence seq_user start 1 increment 50;


create table truemotors_user (
  id           bigint       not null constraint pk_user primary key,
  first_name   varchar(100) not null,
  last_name    varchar(100) not null,
  phone_number varchar(20)  not null,
  email        varchar(50)  not null,
  password     varchar(20)  not null,
  created      timestamp    not null,
  updated      timestamp    not null,
  deleted      timestamp
)