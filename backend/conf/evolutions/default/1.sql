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
  user_id                       bigint,
  object_type                   varchar(255),
  constraint pk_api primary key (id)
);

create table mashups (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  url                           varchar(255),
  description                   varchar(255),
  user_id                       bigint,
  constraint pk_mashups primary key (id)
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

alter table api add constraint fk_api_user_id foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_api_user_id on api (user_id);

alter table mashups add constraint fk_mashups_user_id foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_mashups_user_id on mashups (user_id);


# --- !Downs

alter table api drop foreign key fk_api_user_id;
drop index ix_api_user_id on api;

alter table mashups drop foreign key fk_mashups_user_id;
drop index ix_mashups_user_id on mashups;

drop table if exists api;

drop table if exists mashups;

drop table if exists task;

drop table if exists users;

