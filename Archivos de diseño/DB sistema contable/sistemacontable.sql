/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     18/11/2018 2:52:13 PM                        */
/*==============================================================*/


drop index INCURRE_FK;

drop index COSTOINDIRECTOFABRICACION_PK;

drop table COSTOINDIRECTOFABRICACION;

drop index POSEESUBCUENTAS_FK;

drop index CUENTA_PK;

drop table CUENTA;

drop index SOLICITAMTAERIA_FK;

drop index DETALLATIPO_FK;

drop index DETALLEKARDEX_PK;

drop table DETALLEKARDEX;

drop index DETALLA_FK;

drop index DETALLETARJETADETIEMPO_PK;

drop table DETALLETARJETADETIEMPO;

drop index UTILIZA_FK;

drop index SEDETALLA_FK;

drop index DETALLETRANSACCION_PK;

drop table DETALLETRANSACCION;

drop index EMPLEADO_PK;

drop table EMPLEADO;

drop index AGREGA_A_FK;

drop index EXTRA_PK;

drop table EXTRA;

drop index REGISTRA_FK;

drop index CONTROLA_FK;

drop index KARDEX_PK;

drop table KARDEX;

drop index EN_LISTADO_EN3_FK;

drop index EN_LISTADO_EN2_FK;

drop index LINEAPLANILLA_PK;

drop table LINEAPLANILLA;

drop index MATERIAPRIMA_PK;

drop table MATERIAPRIMA;

drop index PRODUCE_FK;

drop index ORDENFABRICACION_PK;

drop table ORDENFABRICACION;

drop index PERIODOCONTABLE_PK;

drop table PERIODOCONTABLE;

drop index PLANILLA_PK;

drop table PLANILLA;

drop index PRODUCTO_PK;

drop table PRODUCTO;

drop index PRESENTA_FK;

drop index PERTENECE_FK;

drop index UTILIZAMANODEOBRA_FK;

drop index TARJETADETIEMPO_PK;

drop table TARJETADETIEMPO;

drop index SECOMPOME_FK;

drop index TRANSACCION_PK;

drop table TRANSACCION;

drop index USUARIO_PK;

drop table USUARIO;

/*==============================================================*/
/* Table: COSTOINDIRECTOFABRICACION                             */
/*==============================================================*/
create table COSTOINDIRECTOFABRICACION (
   IDCOSTO              INT4                 not null,
   IDORDEN              INT4                 not null,
   NOMBRECOSTO          VARCHAR(20)          not null,
   TASAESTIMADA         DECIMAL(5,2)         not null,
   MONTOCIF             DECIMAL(10,2)        not null,
   constraint PK_COSTOINDIRECTOFABRICACION primary key (IDCOSTO, IDORDEN)
);

/*==============================================================*/
/* Index: COSTOINDIRECTOFABRICACION_PK                          */
/*==============================================================*/
create unique index COSTOINDIRECTOFABRICACION_PK on COSTOINDIRECTOFABRICACION (
IDCOSTO,
IDORDEN
);

/*==============================================================*/
/* Index: INCURRE_FK                                            */
/*==============================================================*/
create  index INCURRE_FK on COSTOINDIRECTOFABRICACION (
IDORDEN
);

/*==============================================================*/
/* Table: CUENTA                                                */
/*==============================================================*/
create table CUENTA (
   IDCUENTA             INT4                 not null,
   CUE_IDCUENTA         INT4                 null,
   NOMBRECUENTA         VARCHAR(30)          not null,
   DESCRICION           VARCHAR(100)         null,
   GRUPOCUENTA          VARCHAR(20)          not null,
   SALDODEUDOR          DECIMAL(10,2)        null,
   SALDOACREEDOR        DECIMAL(10,2)        null,
   SALDOFINAL           DECIMAL(10,2)        null,
   constraint PK_CUENTA primary key (IDCUENTA)
);

/*==============================================================*/
/* Index: CUENTA_PK                                             */
/*==============================================================*/
create unique index CUENTA_PK on CUENTA (
IDCUENTA
);

/*==============================================================*/
/* Index: POSEESUBCUENTAS_FK                                    */
/*==============================================================*/
create  index POSEESUBCUENTAS_FK on CUENTA (
CUE_IDCUENTA
);

/*==============================================================*/
/* Table: DETALLEKARDEX                                         */
/*==============================================================*/
create table DETALLEKARDEX (
   IDDETALLEKARDEX      INT4                 not null,
   IDKARDEX             INT4                 not null,
   IDORDEN              INT4                 not null,
   FECHAMOVIMIENTO      DATE                 not null,
   ENTRADA              BOOL                 not null,
   CANTIDAD             INT4                 not null,
   COSTOUNITARIO        DECIMAL(5,2)         not null,
   MONTODETALLEKARDEX   DECIMAL(10,2)        not null,
   constraint PK_DETALLEKARDEX primary key (IDDETALLEKARDEX, IDKARDEX, IDORDEN)
);

/*==============================================================*/
/* Index: DETALLEKARDEX_PK                                      */
/*==============================================================*/
create unique index DETALLEKARDEX_PK on DETALLEKARDEX (
IDDETALLEKARDEX,
IDKARDEX,
IDORDEN
);

/*==============================================================*/
/* Index: DETALLATIPO_FK                                        */
/*==============================================================*/
create  index DETALLATIPO_FK on DETALLEKARDEX (
IDKARDEX
);

/*==============================================================*/
/* Index: SOLICITAMTAERIA_FK                                    */
/*==============================================================*/
create  index SOLICITAMTAERIA_FK on DETALLEKARDEX (
IDORDEN
);

/*==============================================================*/
/* Table: DETALLETARJETADETIEMPO                                */
/*==============================================================*/
create table DETALLETARJETADETIEMPO (
   DIADETRABAJO         INT4                 not null,
   IDTARJETA            INT4                 not null,
   FECHATARJETA         DATE                 not null,
   HORASTRABAJADAS      INT4                 not null,
   HORASEXTRAS          INT4                 null,
   constraint PK_DETALLETARJETADETIEMPO primary key (DIADETRABAJO, IDTARJETA, FECHATARJETA)
);

/*==============================================================*/
/* Index: DETALLETARJETADETIEMPO_PK                             */
/*==============================================================*/
create unique index DETALLETARJETADETIEMPO_PK on DETALLETARJETADETIEMPO (
DIADETRABAJO,
IDTARJETA,
FECHATARJETA
);

/*==============================================================*/
/* Index: DETALLA_FK                                            */
/*==============================================================*/
create  index DETALLA_FK on DETALLETARJETADETIEMPO (
IDTARJETA,
FECHATARJETA
);

/*==============================================================*/
/* Table: DETALLETRANSACCION                                    */
/*==============================================================*/
create table DETALLETRANSACCION (
   IDDETALLE            INT4                 not null,
   IDTRANSACCION        INT4                 not null,
   IDCUENTA             INT4                 not null,
   DEBE                 DECIMAL(10,2)        not null,
   HABER                DECIMAL(10,2)        not null,
   constraint PK_DETALLETRANSACCION primary key (IDDETALLE)
);

/*==============================================================*/
/* Index: DETALLETRANSACCION_PK                                 */
/*==============================================================*/
create unique index DETALLETRANSACCION_PK on DETALLETRANSACCION (
IDDETALLE
);

/*==============================================================*/
/* Index: SEDETALLA_FK                                          */
/*==============================================================*/
create  index SEDETALLA_FK on DETALLETRANSACCION (
IDTRANSACCION
);

/*==============================================================*/
/* Index: UTILIZA_FK                                            */
/*==============================================================*/
create  index UTILIZA_FK on DETALLETRANSACCION (
IDCUENTA
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO (
   DUI                  VARCHAR(10)          not null,
   NOMBRE               VARCHAR(50)          not null,
   APELLIDO             VARCHAR(50)          not null,
   TEL                  VARCHAR(9)           not null,
   CARGO                VARCHAR(50)          null,
   FECHACONTRATO        DATE                 null,
   FECHADESPIDO         DATE                 null,
   NIT                  VARCHAR(17)          not null,
   NUP                  VARCHAR(12)          not null,
   NUMISSS              VARCHAR(9)           not null,
   constraint PK_EMPLEADO primary key (DUI)
);

/*==============================================================*/
/* Index: EMPLEADO_PK                                           */
/*==============================================================*/
create unique index EMPLEADO_PK on EMPLEADO (
DUI
);

/*==============================================================*/
/* Table: EXTRA                                                 */
/*==============================================================*/
create table EXTRA (
   IDLINEA              INT4                 not null,
   IDEXTRA              INT4                 not null,
   DESCRIP              VARCHAR(100)         not null,
   PORCENTAJE           DECIMAL(2,2)         null,
   MONTODETALLEKARDEX   DECIMAL(10,2)        null,
   DESCUENTO            BOOL                 not null,
   constraint PK_EXTRA primary key (IDLINEA, IDEXTRA)
);

/*==============================================================*/
/* Index: EXTRA_PK                                              */
/*==============================================================*/
create unique index EXTRA_PK on EXTRA (
IDLINEA,
IDEXTRA
);

/*==============================================================*/
/* Index: AGREGA_A_FK                                           */
/*==============================================================*/
create  index AGREGA_A_FK on EXTRA (
IDLINEA
);

/*==============================================================*/
/* Table: KARDEX                                                */
/*==============================================================*/
create table KARDEX (
   IDKARDEX             INT4                 not null,
   CODIGOMATERIA        INT4                 null,
   IDPRODUCTO           INT4                 null,
   PRODUCTOTERMINADO    BOOL                 not null,
   METODO               VARCHAR(15)          not null,
   FECHAAPERTURA        DATE                 not null,
   CANTIDADTOTAL        INT4                 null,
   COSTOUNITARIOTOTAL   DECIMAL(5,2)         null,
   MONTOTOTAL           DECIMAL(5,2)         null,
   constraint PK_KARDEX primary key (IDKARDEX)
);

/*==============================================================*/
/* Index: KARDEX_PK                                             */
/*==============================================================*/
create unique index KARDEX_PK on KARDEX (
IDKARDEX
);

/*==============================================================*/
/* Index: CONTROLA_FK                                           */
/*==============================================================*/
create  index CONTROLA_FK on KARDEX (
CODIGOMATERIA
);

/*==============================================================*/
/* Index: REGISTRA_FK                                           */
/*==============================================================*/
create  index REGISTRA_FK on KARDEX (
IDPRODUCTO
);

/*==============================================================*/
/* Table: LINEAPLANILLA                                         */
/*==============================================================*/
create table LINEAPLANILLA (
   IDPLANILLA           INT4                 not null,
   DUI                  VARCHAR(10)          not null,
   IDLINEA              INT4                 not null,
   constraint PK_LINEAPLANILLA primary key (IDLINEA)
);

/*==============================================================*/
/* Index: LINEAPLANILLA_PK                                      */
/*==============================================================*/
create unique index LINEAPLANILLA_PK on LINEAPLANILLA (
IDLINEA
);

/*==============================================================*/
/* Index: EN_LISTADO_EN2_FK                                     */
/*==============================================================*/
create  index EN_LISTADO_EN2_FK on LINEAPLANILLA (
DUI
);

/*==============================================================*/
/* Index: EN_LISTADO_EN3_FK                                     */
/*==============================================================*/
create  index EN_LISTADO_EN3_FK on LINEAPLANILLA (
IDPLANILLA
);

/*==============================================================*/
/* Table: MATERIAPRIMA                                          */
/*==============================================================*/
create table MATERIAPRIMA (
   CODIGOMATERIA        INT4                 not null,
   NOMBREMATERIA        VARCHAR(20)          not null,
   DIRECTA              BOOL                 not null,
   DESCRIPCIONMATERIA   VARCHAR(100)         null,
   UNIDADESMATERIA      INT4                 not null,
   PRECIOADQUISION      DECIMAL(10,2)        not null,
   constraint PK_MATERIAPRIMA primary key (CODIGOMATERIA)
);

/*==============================================================*/
/* Index: MATERIAPRIMA_PK                                       */
/*==============================================================*/
create unique index MATERIAPRIMA_PK on MATERIAPRIMA (
CODIGOMATERIA
);

/*==============================================================*/
/* Table: ORDENFABRICACION                                      */
/*==============================================================*/
create table ORDENFABRICACION (
   IDORDEN              INT4                 not null,
   IDPRODUCTO           INT4                 not null,
   ESPECIFICACION       VARCHAR(150)         null,
   FECHAEXPEDICION      DATE                 not null,
   FECHAREQUERIDA       DATE                 not null,
   INICIADA             DATE                 null,
   FINALIZADA           DATE                 null,
   TERMINADA            BOOL                 not null,
   COSTOTOTAL           DECIMAL(5,2)         null,
   UNIDADESPRODUCIDAS   INT4                 null,
   constraint PK_ORDENFABRICACION primary key (IDORDEN)
);

/*==============================================================*/
/* Index: ORDENFABRICACION_PK                                   */
/*==============================================================*/
create unique index ORDENFABRICACION_PK on ORDENFABRICACION (
IDORDEN
);

/*==============================================================*/
/* Index: PRODUCE_FK                                            */
/*==============================================================*/
create  index PRODUCE_FK on ORDENFABRICACION (
IDPRODUCTO
);

/*==============================================================*/
/* Table: PERIODOCONTABLE                                       */
/*==============================================================*/
create table PERIODOCONTABLE (
   IDPERIODOCONTABLE    INT4                 not null,
   FECHAINICIO          DATE                 null,
   FECHAFINAL           DATE                 null,
   constraint PK_PERIODOCONTABLE primary key (IDPERIODOCONTABLE)
);

/*==============================================================*/
/* Index: PERIODOCONTABLE_PK                                    */
/*==============================================================*/
create unique index PERIODOCONTABLE_PK on PERIODOCONTABLE (
IDPERIODOCONTABLE
);

/*==============================================================*/
/* Table: PLANILLA                                              */
/*==============================================================*/
create table PLANILLA (
   IDPLANILLA           INT4                 not null,
   FECHAPAGO            DATE                 not null,
   TIPO                 BOOL                 not null,
   OCASION              VARCHAR(25)          not null,
   TOTALPLANILLA        DECIMAL(10,2)        not null,
   constraint PK_PLANILLA primary key (IDPLANILLA)
);

/*==============================================================*/
/* Index: PLANILLA_PK                                           */
/*==============================================================*/
create unique index PLANILLA_PK on PLANILLA (
IDPLANILLA
);

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO (
   IDPRODUCTO           INT4                 not null,
   NOMBREPRODUCTO       VARCHAR(20)          not null,
   CANTIDAD             INT4                 not null,
   COSTOUNITARIO        DECIMAL(5,2)         not null,
   PRECIOVENTA          DECIMAL(5,2)         not null,
   constraint PK_PRODUCTO primary key (IDPRODUCTO)
);

/*==============================================================*/
/* Index: PRODUCTO_PK                                           */
/*==============================================================*/
create unique index PRODUCTO_PK on PRODUCTO (
IDPRODUCTO
);

/*==============================================================*/
/* Table: TARJETADETIEMPO                                       */
/*==============================================================*/
create table TARJETADETIEMPO (
   IDTARJETA            INT4                 not null,
   FECHATARJETA         DATE                 not null,
   IDORDEN              INT4                 not null,
   DUI                  VARCHAR(10)          not null,
   IDLINEA              INT4                 not null,
   TOTALHORASTRABAJADAS INT4                 null,
   TOTALHORASEXTRAS     INT4                 null,
   constraint PK_TARJETADETIEMPO primary key (IDTARJETA, FECHATARJETA)
);

/*==============================================================*/
/* Index: TARJETADETIEMPO_PK                                    */
/*==============================================================*/
create unique index TARJETADETIEMPO_PK on TARJETADETIEMPO (
IDTARJETA,
FECHATARJETA
);

/*==============================================================*/
/* Index: UTILIZAMANODEOBRA_FK                                  */
/*==============================================================*/
create  index UTILIZAMANODEOBRA_FK on TARJETADETIEMPO (
IDORDEN
);

/*==============================================================*/
/* Index: PERTENECE_FK                                          */
/*==============================================================*/
create  index PERTENECE_FK on TARJETADETIEMPO (
DUI
);

/*==============================================================*/
/* Index: PRESENTA_FK                                           */
/*==============================================================*/
create  index PRESENTA_FK on TARJETADETIEMPO (
IDLINEA
);

/*==============================================================*/
/* Table: TRANSACCION                                           */
/*==============================================================*/
create table TRANSACCION (
   IDTRANSACCION        INT4                 not null,
   IDPERIODOCONTABLE    INT4                 not null,
   DESCRIPCIONDETALLE   VARCHAR(100)         null,
   FECHATRANSACCION     DATE                 not null,
   constraint PK_TRANSACCION primary key (IDTRANSACCION)
);

/*==============================================================*/
/* Index: TRANSACCION_PK                                        */
/*==============================================================*/
create unique index TRANSACCION_PK on TRANSACCION (
IDTRANSACCION
);

/*==============================================================*/
/* Index: SECOMPOME_FK                                          */
/*==============================================================*/
create  index SECOMPOME_FK on TRANSACCION (
IDPERIODOCONTABLE
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   IDUSUARIO            INT4                 not null,
   NOMBREUSUARIO        TEXT                 not null,
   CONTRASENA           TEXT                 not null,
   ROL                  TEXT                 not null,
   constraint PK_USUARIO primary key (IDUSUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
IDUSUARIO
);

alter table COSTOINDIRECTOFABRICACION
   add constraint FK_COSTOIND_INCURRE_ORDENFAB foreign key (IDORDEN)
      references ORDENFABRICACION (IDORDEN)
      on delete restrict on update cascade;

alter table CUENTA
   add constraint FK_CUENTA_POSEESUBC_CUENTA foreign key (CUE_IDCUENTA)
      references CUENTA (IDCUENTA)
      on delete restrict on update cascade;

alter table DETALLEKARDEX
   add constraint FK_DETALLEK_DETALLATI_KARDEX foreign key (IDKARDEX)
      references KARDEX (IDKARDEX)
      on delete restrict on update cascade;

alter table DETALLEKARDEX
   add constraint FK_DETALLEK_SOLICITAM_ORDENFAB foreign key (IDORDEN)
      references ORDENFABRICACION (IDORDEN)
      on delete restrict on update cascade;

alter table DETALLETARJETADETIEMPO
   add constraint FK_DETALLET_DETALLA_TARJETAD foreign key (IDTARJETA, FECHATARJETA)
      references TARJETADETIEMPO (IDTARJETA, FECHATARJETA)
      on delete restrict on update cascade;

alter table DETALLETRANSACCION
   add constraint FK_DETALLET_SEDETALLA_TRANSACC foreign key (IDTRANSACCION)
      references TRANSACCION (IDTRANSACCION)
      on delete restrict on update cascade;

alter table DETALLETRANSACCION
   add constraint FK_DETALLET_UTILIZA_CUENTA foreign key (IDCUENTA)
      references CUENTA (IDCUENTA)
      on delete restrict on update cascade;

alter table EXTRA
   add constraint FK_EXTRA_AGREGA_A_LINEAPLA foreign key (IDLINEA)
      references LINEAPLANILLA (IDLINEA)
      on delete restrict on update cascade;

alter table KARDEX
   add constraint FK_KARDEX_CONTROLA_MATERIAP foreign key (CODIGOMATERIA)
      references MATERIAPRIMA (CODIGOMATERIA)
      on delete restrict on update cascade;

alter table KARDEX
   add constraint FK_KARDEX_REGISTRA_PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTO (IDPRODUCTO)
      on delete restrict on update cascade;

alter table LINEAPLANILLA
   add constraint FK_LINEAPLA_EN_LISTAD_EMPLEADO foreign key (DUI)
      references EMPLEADO (DUI)
      on delete restrict on update cascade;

alter table LINEAPLANILLA
   add constraint FK_LINEAPLA_EN_LISTAD_PLANILLA foreign key (IDPLANILLA)
      references PLANILLA (IDPLANILLA)
      on delete restrict on update cascade;

alter table ORDENFABRICACION
   add constraint FK_ORDENFAB_PRODUCE_PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTO (IDPRODUCTO)
      on delete restrict on update cascade;

alter table TARJETADETIEMPO
   add constraint FK_TARJETAD_PERTENECE_EMPLEADO foreign key (DUI)
      references EMPLEADO (DUI)
      on delete restrict on update cascade;

alter table TARJETADETIEMPO
   add constraint FK_TARJETAD_PRESENTA_LINEAPLA foreign key (IDLINEA)
      references LINEAPLANILLA (IDLINEA)
      on delete restrict on update cascade;

alter table TARJETADETIEMPO
   add constraint FK_TARJETAD_UTILIZAMA_ORDENFAB foreign key (IDORDEN)
      references ORDENFABRICACION (IDORDEN)
      on delete restrict on update cascade;

alter table TRANSACCION
   add constraint FK_TRANSACC_SECOMPOME_PERIODOC foreign key (IDPERIODOCONTABLE)
      references PERIODOCONTABLE (IDPERIODOCONTABLE)
      on delete restrict on update cascade;

