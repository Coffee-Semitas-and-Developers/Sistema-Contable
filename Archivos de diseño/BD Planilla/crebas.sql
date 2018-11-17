/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     10/11/2018 5:13:58 p. m.                     */
/*==============================================================*/


drop index ES_UN_FK;

drop table EMPLEADO;

drop index EXTRA_PK;

drop table EXTRA;

drop index EN_LISTADO_EN_FK;

drop index EN_LISTADO_EN2_FK;

drop index EN_LISTADO_EN_PK;

drop table LINEAPLANILLA;

drop index PERSONA_PK;

drop table PERSONA;

drop index PLANILLA_PK;

drop table PLANILLA;

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO (
   DUI                  VARCHAR(10)          not null,
   NOMBRE               VARCHAR(50)          not null,
   APELLIDO             VARCHAR(50)          not null,
   TEL                  VARCHAR(9)           not null,
   CARGO                VARCHAR(50)          not null,
   SALARIO              DECIMAL(10,2)        not null,
   DEPARTAMENTO         VARCHAR(50)          not null,
   FECHACONTRATO        DATE                 not null,
   FECHADESPIDO         DATE                 null,
   ESTADO               BOOL                 not null,
   constraint PK_EMPLEADO primary key (DUI)
);

/*==============================================================*/
/* Index: ES_UN_FK                                              */
/*==============================================================*/
create  index ES_UN_FK on EMPLEADO (
DUI
);

/*==============================================================*/
/* Table: EXTRA                                                 */
/*==============================================================*/
create table EXTRA (
   DUI                  VARCHAR(10)          not null,
   FECHAPAGO            DATE                 not null,
   SALARIOREAL          DECIMAL(10,2)        null,
   TIPO                 BOOL                 not null,
   DESCRIP              VARCHAR(100)         not null,
   PORCENTAJE           DECIMAL(1,2)         not null,
   MONTO                DECIMAL(10,2)        not null,
   constraint PK_EXTRA primary key (DUI, FECHAPAGO)
);

/*==============================================================*/
/* Index: EXTRA_PK                                              */
/*==============================================================*/
create unique index EXTRA_PK on EXTRA (
DUI,
FECHAPAGO
);

/*==============================================================*/
/* Table: LINEAPLANILLA                                         */
/*==============================================================*/
create table LINEAPLANILLA (
   DUI                  VARCHAR(10)          not null,
   FECHAPAGO            DATE                 not null,
   SALARIOREAL          DECIMAL(10,2)        not null,
   constraint PK_LINEAPLANILLA primary key (DUI, FECHAPAGO)
);

/*==============================================================*/
/* Index: EN_LISTADO_EN_PK                                      */
/*==============================================================*/
create unique index EN_LISTADO_EN_PK on LINEAPLANILLA (
DUI,
FECHAPAGO
);

/*==============================================================*/
/* Index: EN_LISTADO_EN2_FK                                     */
/*==============================================================*/
create  index EN_LISTADO_EN2_FK on LINEAPLANILLA (
DUI
);

/*==============================================================*/
/* Index: EN_LISTADO_EN_FK                                      */
/*==============================================================*/
create  index EN_LISTADO_EN_FK on LINEAPLANILLA (
FECHAPAGO
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   DUI                  VARCHAR(10)          not null,
   NOMBRE               VARCHAR(50)          not null,
   APELLIDO             VARCHAR(50)          not null,
   TEL                  VARCHAR(9)           not null,
   constraint PK_PERSONA primary key (DUI)
);

/*==============================================================*/
/* Index: PERSONA_PK                                            */
/*==============================================================*/
create unique index PERSONA_PK on PERSONA (
DUI
);

/*==============================================================*/
/* Table: PLANILLA                                              */
/*==============================================================*/
create table PLANILLA (
   FECHAPAGO            DATE                 not null,
   TIPO                 BOOL                 not null,
   OCASION              VARCHAR(25)          not null,
   constraint PK_PLANILLA primary key (FECHAPAGO)
);

/*==============================================================*/
/* Index: PLANILLA_PK                                           */
/*==============================================================*/
create unique index PLANILLA_PK on PLANILLA (
FECHAPAGO
);

alter table EMPLEADO
   add constraint FK_EMPLEADO_ES_UN_PERSONA foreign key (DUI)
      references PERSONA (DUI)
      on delete restrict on update restrict;

alter table EXTRA
   add constraint FK_EXTRA_SE_CONVIE_LINEAPLA foreign key (DUI, FECHAPAGO)
      references LINEAPLANILLA (DUI, FECHAPAGO)
      on delete restrict on update restrict;

alter table LINEAPLANILLA
   add constraint FK_LINEAPLA_EN_LISTAD_PLANILLA foreign key (FECHAPAGO)
      references PLANILLA (FECHAPAGO)
      on delete restrict on update restrict;

alter table LINEAPLANILLA
   add constraint FK_LINEAPLA_EN_LISTAD_EMPLEADO foreign key (DUI)
      references EMPLEADO (DUI)
      on delete restrict on update restrict;

