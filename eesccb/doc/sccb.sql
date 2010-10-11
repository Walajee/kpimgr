/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2010-10-6 13:50:50                           */
/*==============================================================*/


drop table if exists PPRT_APP_FLOW;

drop table if exists PPRT_APP_FLOW_HIS;

/*==============================================================*/
/* Table: PPRT_APP_FLOW                                         */
/*==============================================================*/
create table PPRT_APP_FLOW
(
   ID                   numeric(10,0) not null,
   FLOW                 varchar(30),
   STATS                varchar(10),
   PARTICIPE            varchar(30),
   LAST_UPDATE          timestamp,
   CREATOR              varchar(30),
   ENTITY               varchar(30),
   primary key (ID)
);

/*==============================================================*/
/* Table: PPRT_APP_FLOW_HIS                                     */
/*==============================================================*/
create table PPRT_APP_FLOW_HIS
(
   HID                  numeric(10,0) not null,
   ID                   numeric(10,0),
   ACTION_DATE          timestamp,
   USER                 varchar(30),
   CURR_STAT            varchar(10),
   NEXT_STAT            varchar(10),
   ACTION_RET           varchar(30),
   DESCT                varchar(200),
   PARTICIPATE          varchar(100),
   primary key (HID)
);

alter table PPRT_APP_FLOW_HIS add constraint FK_REF_FL_HIS foreign key (ID)
      references PPRT_APP_FLOW (ID) on delete restrict on update restrict;
      
      
      /*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2010-10-6 13:52:15                           */
/*==============================================================*/


drop table if exists PPRT_STD_ACTIVITY;

drop table if exists PPRT_STD_ACT_HIS;

drop table if exists PPRT_STD_CAT;

drop table if exists PPRT_STD_INFO;

drop table if exists PPRT_STD_INFO_EST;

drop table if exists PPRT_STD_TPL;

drop table if exists PPRT_STD_UPL;

/*==============================================================*/
/* Table: PPRT_STD_ACTIVITY                                     */
/*==============================================================*/
create table PPRT_STD_ACTIVITY
(
   ACTID                numeric(10,0) not null,
   CREATOR              varchar(30),
   EST_DATE             timestamp,
   ORG                  numeric(10,0),
   ORG_NAME             varchar(30),
   EST_STAT             char(1),
   primary key (ACTID)
);

/*==============================================================*/
/* Table: PPRT_STD_ACT_HIS                                      */
/*==============================================================*/
create table PPRT_STD_ACT_HIS
(
   ID                   numeric(10,0) not null,
   ACTID                numeric(10,0),
   INSID                numeric(10,0),
   TPLID                numeric(10,0),
   ACT_USER             varchar(30),
   ACT_RET              varchar(30),
   DESCT                varchar(200),
   primary key (ID)
);

/*==============================================================*/
/* Table: PPRT_STD_CAT                                          */
/*==============================================================*/
create table PPRT_STD_CAT
(
   CATID                numeric(10,0) not null,
   NAME                 varchar(30),
   DESCT                varchar(30),
   PARENT               numeric(10,0),
   primary key (CATID)
);

/*==============================================================*/
/* Table: PPRT_STD_INFO                                         */
/*==============================================================*/
create table PPRT_STD_INFO
(
   ID                   numeric(10,0) not null,
   CATID                numeric(10,0),
   NAME                 varchar(30),
   PROP                 varchar(30),
   UNIT                 varchar(30),
   MEAN                 varchar(100),
   VALUE                varchar(30),
   DESCT                varchar(200),
   CREATOR              varchar(30),
   CREATE_DATE          timestamp,
   UPD_DATE             timestamp,
   STATUS               char(1),
   primary key (ID)
);

/*==============================================================*/
/* Table: PPRT_STD_INFO_EST                                     */
/*==============================================================*/
create table PPRT_STD_INFO_EST
(
   INSID                numeric(10,0) not null,
   ID                   numeric(10,0),
   ACTID                numeric(10,0),
   VALUE                varchar(30),
   CREATOR              varchar(30),
   EST_DATE             timestamp,
   CATID                numeric(10,0),
   CATNAME              varchar(30),
   STAT                 CHAR(1),
   primary key (INSID)
);

/*==============================================================*/
/* Table: PPRT_STD_TPL                                          */
/*==============================================================*/
create table PPRT_STD_TPL
(
   TPLID                numeric(10,0) not null,
   ID                   numeric(10,0),
   NAME                 varchar(200),
   DEPLOY_DATE          timestamp,
   CREATOR              varchar(30),
   URL                  varchar(200),
   primary key (TPLID)
);

/*==============================================================*/
/* Table: PPRT_STD_UPL                                          */
/*==============================================================*/
create table PPRT_STD_UPL
(
   TID                  numeric(10,0) not null,
   INSID                numeric(10,0),
   NAME                 varchar(200),
   DEPLOY_DATE          timestamp,
   CREATOR              varchar(30),
   URL                  varchar(200),
   primary key (TID)
);

alter table PPRT_STD_CAT add constraint FK_Reference_1 foreign key (PARENT)
      references PPRT_STD_CAT (CATID) on delete restrict on update restrict;

alter table PPRT_STD_INFO add constraint FK_REF_CAT foreign key (CATID)
      references PPRT_STD_CAT (CATID) on delete restrict on update restrict;

alter table PPRT_STD_INFO_EST add constraint FK_REF_STD_EST foreign key (ID)
      references PPRT_STD_INFO (ID) on delete restrict on update restrict;

alter table PPRT_STD_INFO_EST add constraint FK_REF_RES_ACT foreign key (ACTID)
      references PPRT_STD_ACTIVITY (ACTID) on delete restrict on update restrict;

alter table PPRT_STD_TPL add constraint FK_REF_STD_IN foreign key (ID)
      references PPRT_STD_INFO (ID) on delete restrict on update restrict;

alter table PPRT_STD_UPL add constraint FK_REF_TPL_EST foreign key (INSID)
      references PPRT_STD_INFO_EST (INSID) on delete restrict on update restrict;


      
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2010-10-6 13:52:52                           */
/*==============================================================*/


drop table if exists PPRT_PT_SYS_ORG;

drop table if exists PPRT_PT_SYS_ORGEXT;

drop table if exists PPRT_PT_SYS_ORGREL;

drop table if exists PPRT_PT_SYS_RESOURCE;

drop table if exists PPRT_PT_SYS_ROLE;

drop table if exists PPRT_PT_SYS_ROLERES;

drop table if exists PPRT_PT_SYS_USER;

drop table if exists PPRT_PT_SYS_USEREXT;

drop table if exists PPRT_RT_SYS_USERROLE;

drop table if exists pprt_base_counter;

/*==============================================================*/
/* Table: PPRT_PT_SYS_ORG                                       */
/*==============================================================*/
create table PPRT_PT_SYS_ORG
(
   ID                   numeric(10,0) not null,
   CODE                 varchar(30),
   LEV                  varchar(30),
   NAME                 varchar(30),
   CREATOR              varchar(30),
   TYPE                 char(1),
   STATS                char(1),
   DESCT                varchar(200),
   CRT_DATE             timestamp,
   UPD_DATE             timestamp,
   primary key (ID)
);

/*==============================================================*/
/* Table: PPRT_PT_SYS_ORGEXT                                    */
/*==============================================================*/
create table PPRT_PT_SYS_ORGEXT
(
   ID                   numeric(10,0) not null,
   CLMA                 varchar(30),
   CLMB                 varchar(30),
   primary key (ID)
);

alter table PPRT_PT_SYS_ORGEXT comment '备用，用于存储扩展信息';

/*==============================================================*/
/* Table: PPRT_PT_SYS_ORGREL                                    */
/*==============================================================*/
create table PPRT_PT_SYS_ORGREL
(
   ID                   numeric(10,0) not null,
   PRTORG_ID            numeric(10,0),
   ORG_ID               numeric(10,0),
   ODR                  int,
   primary key (ID)
);

/*==============================================================*/
/* Table: PPRT_PT_SYS_RESOURCE                                  */
/*==============================================================*/
create table PPRT_PT_SYS_RESOURCE
(
   RESID                numeric(10,0) not null,
   TYPE                 varchar(30),
   ENTITY               varchar(30),
   NAME                 varchar(100),
   primary key (RESID)
);

/*==============================================================*/
/* Table: PPRT_PT_SYS_ROLE                                      */
/*==============================================================*/
create table PPRT_PT_SYS_ROLE
(
   ID                   numeric(10,0) not null,
   NAME                 varchar(30),
   TYPE                 char(1),
   DESCT                varchar(200),
   primary key (ID)
);

/*==============================================================*/
/* Table: PPRT_PT_SYS_ROLERES                                   */
/*==============================================================*/
create table PPRT_PT_SYS_ROLERES
(
   RESID                numeric(10,0),
   ID                   numeric(10,0),
   TYPE                 varchar(30)
);

/*==============================================================*/
/* Table: PPRT_PT_SYS_USER                                      */
/*==============================================================*/
create table PPRT_PT_SYS_USER
(
   UID                  numeric(10,0) not null,
   ID                   numeric(10,0),
   NAME                 varchar(30),
   ACCOUNT              varchar(30),
   EMAIL                varchar(100),
   PHONE                varchar(30),
   STATS                char(1),
   CRT_TIME             timestamp,
   PWD                  varchar(30),
   primary key (UID)
);

/*==============================================================*/
/* Table: PPRT_PT_SYS_USEREXT                                   */
/*==============================================================*/
create table PPRT_PT_SYS_USEREXT
(
   ID                   numeric(10,0) not null,
   CLMA                 varchar(30),
   primary key (ID)
);

/*==============================================================*/
/* Table: PPRT_RT_SYS_USERROLE                                  */
/*==============================================================*/
create table PPRT_RT_SYS_USERROLE
(
   UID                  numeric(10,0),
   ID                   numeric(10,0)
);

/*==============================================================*/
/* Table: pprt_base_counter                                     */
/*==============================================================*/
create table pprt_base_counter
(
   code                 varchar(30) not null,
   value                decimal(10),
   primary key (code)
);

alter table PPRT_PT_SYS_ORGEXT add constraint FK_REF_SYS_EXT foreign key (ID)
      references PPRT_PT_SYS_ORG (ID) on delete restrict on update restrict;

alter table PPRT_PT_SYS_ORGREL add constraint FK_LEV_REF_ORG foreign key (ORG_ID)
      references PPRT_PT_SYS_ORG (ID) on delete restrict on update restrict;

alter table PPRT_PT_SYS_ORGREL add constraint FK_LEV_REF_ORGP foreign key (PRTORG_ID)
      references PPRT_PT_SYS_ORG (ID) on delete restrict on update restrict;

alter table PPRT_PT_SYS_ROLERES add constraint FK_Reference_10 foreign key (ID)
      references PPRT_PT_SYS_ROLE (ID) on delete restrict on update restrict;

alter table PPRT_PT_SYS_ROLERES add constraint FK_Reference_8 foreign key (RESID)
      references PPRT_PT_SYS_RESOURCE (RESID) on delete restrict on update restrict;

alter table PPRT_PT_SYS_USER add constraint FK_Reference_9 foreign key (ID)
      references PPRT_PT_SYS_ORG (ID) on delete restrict on update restrict;

alter table PPRT_PT_SYS_USEREXT add constraint FK_REF_EXT_U foreign key (ID)
      references PPRT_PT_SYS_USER (UID) on delete restrict on update restrict;

alter table PPRT_RT_SYS_USERROLE add constraint FK_Reference_6 foreign key (UID)
      references PPRT_PT_SYS_USER (UID) on delete restrict on update restrict;

alter table PPRT_RT_SYS_USERROLE add constraint FK_Reference_7 foreign key (ID)
      references PPRT_PT_SYS_ROLE (ID) on delete restrict on update restrict;


insert into PPRT_PT_SYS_RESOURCE values(1, 'func', 'daily', '日常工作管理')
insert into PPRT_PT_SYS_RESOURCE values(1, 'func', 'mark', '评标对标')
insert into PPRT_PT_SYS_RESOURCE values(1, 'func', 'stand', '标准维护')
insert into PPRT_PT_SYS_RESOURCE values(1, 'func', 'sys', '系统管理')

insert into PPRT_PT_SYS_ORG  values(1, '01', '1', '云南省',null, '1', '1', '云南省', '2010-10-03 22:50', '2010-10-03 22:50')
insert into PPRT_PT_SYS_ORG  values(2, '0101', '2', '红河州',null, '1', '1', '红河州', '2010-10-03 22:50', '2010-10-03 22:50')
insert into PPRT_PT_SYS_ORG  values(3, '010101', '3', '弥勒县',null, '1', '1', '弥勒县', '2010-10-03 22:50', '2010-10-03 22:50')


insert into PPRT_PT_SYS_ORGREL values(1, 1,2,1)
insert into PPRT_PT_SYS_ORGREL values(2, 2,3,1)

insert into PPRT_STD_CAT(1, '工作指标', '工作指标', null)