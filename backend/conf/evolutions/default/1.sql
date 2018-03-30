# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table api (
  id                            bigint auto_increment not null,
  apiname                       varchar(255),
  apihomepage                   varchar(255),
  apiendpoint                   varchar(255),
  version                       varchar(255),
  scope                         varchar(255),
  apidescription                varchar(255),
  emailaddress                  varchar(255),
  object_type                   varchar(255),
  constraint pk_api primary key (id)
);

create table task (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  done                          tinyint(1) default 0 not null,
  due_date                      datetime(6),
  constraint pk_task primary key (id)
);

create table users (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  passwordhash                  varchar(255),
  securityquestion              varchar(255),
  answer                        varchar(255),
  usertype                      varchar(255),
  constraint pk_users primary key (id)
);


# --- !Downs

drop table if exists api;

drop table if exists task;

drop table if exists users;

