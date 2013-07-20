# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table note (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  text                      varchar(255),
  date                      datetime,
  assigned_to_email         varchar(255),
  project_id                bigint,
  constraint pk_note primary key (id))
;

create table project (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  folder                    varchar(255),
  constraint pk_project primary key (id))
;

create table task (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  due_date                  datetime,
  assigned_to_email         varchar(255),
  folder                    varchar(255),
  project_id                bigint,
  constraint pk_task primary key (id))
;

create table account (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (email))
;


create table project_account (
  project_id                     bigint not null,
  account_email                  varchar(255) not null,
  constraint pk_project_account primary key (project_id, account_email))
;
alter table note add constraint fk_note_assignedTo_1 foreign key (assigned_to_email) references account (email) on delete restrict on update restrict;
create index ix_note_assignedTo_1 on note (assigned_to_email);
alter table note add constraint fk_note_project_2 foreign key (project_id) references project (id) on delete restrict on update restrict;
create index ix_note_project_2 on note (project_id);
alter table task add constraint fk_task_assignedTo_3 foreign key (assigned_to_email) references account (email) on delete restrict on update restrict;
create index ix_task_assignedTo_3 on task (assigned_to_email);
alter table task add constraint fk_task_project_4 foreign key (project_id) references project (id) on delete restrict on update restrict;
create index ix_task_project_4 on task (project_id);



alter table project_account add constraint fk_project_account_project_01 foreign key (project_id) references project (id) on delete restrict on update restrict;

alter table project_account add constraint fk_project_account_account_02 foreign key (account_email) references account (email) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table note;

drop table project;

drop table project_account;

drop table task;

drop table account;

SET FOREIGN_KEY_CHECKS=1;

