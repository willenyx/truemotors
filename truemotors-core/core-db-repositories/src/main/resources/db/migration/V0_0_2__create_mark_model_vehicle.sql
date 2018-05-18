create sequence seq_mark start 1 increment 50;
create sequence seq_model start 1 increment 50;
create sequence seq_vehicle start 1 increment 50;

create table mark (
  id        bigint       not null constraint pk_mark primary key,
  mark_name varchar(100) not null,
  created   timestamp    not null,
  updated   timestamp    not null,
  deleted   timestamp
);

create table model (
  id         bigint       not null constraint pk_model primary key,
  model_name varchar(100) not null,
  mark_id    bigint       not null constraint fk_model_mark references mark,
  body_type  varchar(50)  not null,
  created    timestamp    not null,
  updated    timestamp    not null,
  deleted    timestamp
);

create table vehicle (
  id              bigint           not null constraint pk_vehicle primary key,
  mark_id         bigint           not null constraint fk_vehicle_mark references mark,
  vehicle_date    timestamp        not null,
  mileage         integer          not null,
  gear_box        varchar(50)      not null,
  hand_drive      varchar(50)      not null,
  engine_type     varchar(50)      not null,
  condition       varchar(50)      not null,
  color           varchar(50)      not null,
  options         varchar(2000)    not null,
  additional_info varchar(2000)    not null,
  country         varchar(50)      not null,
  price           double precision not null,
  created         timestamp        not null,
  updated         timestamp        not null,
  deleted         timestamp
)