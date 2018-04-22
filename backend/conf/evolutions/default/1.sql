# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table apis (
  apitype                       varchar(31) not null,
  id                            bigint auto_increment not null,
  apiid                         bigint,
  name                          varchar(255),
  homepage                      varchar(255),
  endpoint                      varchar(255) default '',
  version                       varchar(255) default '',
  scope                         varchar(255) default '',
  description                   varchar(255) default '',
  email                         varchar(255) default '',
  submissionversion             varchar(255) default '' not null,
  state                         varchar(255) default '',
  user_id                       bigint,
  constraint ck_apis_state check ( state in (0,1)),
  constraint pk_apis primary key (id)
);

create table mashup_apis (
  mashup_id                     bigint not null,
  api_id                        bigint not null,
  constraint pk_mashup_apis primary key (mashup_id,api_id)
);

create table api_comments (
  id                            bigint auto_increment not null,
  apiid                         integer not null,
  comment                       varchar(255),
  api_id                        bigint,
  constraint pk_api_comments primary key (id)
);

create table donations (
  username                      varchar(255),
  cardnum                       varchar(255),
  month                         varchar(255),
  year                          varchar(255),
  cvv                           varchar(255),
  amount                        varchar(255),
  payid                         varchar(255)
);

create table log_message (
  id                            bigint auto_increment not null,
  date                          datetime(6),
  message                       varchar(255),
  constraint pk_log_message primary key (id)
);

create table messages (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  content                       varchar(255),
  sender_id                     bigint,
  receiver_id                   bigint,
  date                          datetime(6),
  constraint pk_messages primary key (id)
);

create table topics (
  id                            integer not null,
  apiname                       varchar(255),
  topicname                     varchar(255)
);

create table users (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  name                          varchar(255),
  passwordhash                  varchar(255),
  securityquestion              varchar(255),
  answer                        varchar(255),
  usertype                      integer,
  phonenumber                   varchar(255),
  email                         varchar(255),
  notificationmethod            varchar(255),
  constraint ck_users_usertype check ( userType in (0,1)),
  constraint pk_users primary key (id)
);

create table api_followers (
  user_id                       bigint not null,
  api_id                        bigint not null,
  constraint pk_api_followers primary key (user_id,api_id)
);

alter table apis add constraint fk_apis_user_id foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_apis_user_id on apis (user_id);

alter table mashup_apis add constraint fk_mashup_apis_apis_1 foreign key (mashup_id) references apis (id) on delete restrict on update restrict;
create index ix_mashup_apis_apis_1 on mashup_apis (mashup_id);

alter table mashup_apis add constraint fk_mashup_apis_apis_2 foreign key (api_id) references apis (id) on delete restrict on update restrict;
create index ix_mashup_apis_apis_2 on mashup_apis (api_id);

alter table api_comments add constraint fk_api_comments_api_id foreign key (api_id) references apis (id) on delete restrict on update restrict;
create index ix_api_comments_api_id on api_comments (api_id);

alter table messages add constraint fk_messages_sender_id foreign key (sender_id) references users (id) on delete restrict on update restrict;
create index ix_messages_sender_id on messages (sender_id);

alter table messages add constraint fk_messages_receiver_id foreign key (receiver_id) references users (id) on delete restrict on update restrict;
create index ix_messages_receiver_id on messages (receiver_id);

alter table api_followers add constraint fk_api_followers_users foreign key (user_id) references users (id) on delete restrict on update restrict;
create index ix_api_followers_users on api_followers (user_id);

alter table api_followers add constraint fk_api_followers_apis foreign key (api_id) references apis (id) on delete restrict on update restrict;
create index ix_api_followers_apis on api_followers (api_id);


# --- !Downs

alter table apis drop foreign key fk_apis_user_id;
drop index ix_apis_user_id on apis;

alter table mashup_apis drop foreign key fk_mashup_apis_apis_1;
drop index ix_mashup_apis_apis_1 on mashup_apis;

alter table mashup_apis drop foreign key fk_mashup_apis_apis_2;
drop index ix_mashup_apis_apis_2 on mashup_apis;

alter table api_comments drop foreign key fk_api_comments_api_id;
drop index ix_api_comments_api_id on api_comments;

alter table messages drop foreign key fk_messages_sender_id;
drop index ix_messages_sender_id on messages;

alter table messages drop foreign key fk_messages_receiver_id;
drop index ix_messages_receiver_id on messages;

alter table api_followers drop foreign key fk_api_followers_users;
drop index ix_api_followers_users on api_followers;

alter table api_followers drop foreign key fk_api_followers_apis;
drop index ix_api_followers_apis on api_followers;

drop table if exists apis;

drop table if exists mashup_apis;

drop table if exists api_comments;

drop table if exists donations;

drop table if exists log_message;

drop table if exists messages;

drop table if exists topics;

drop table if exists users;

drop table if exists api_followers;

