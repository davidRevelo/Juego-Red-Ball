CREATE DATABASE CAJA_CHICA
USE CAJA_CHICA

/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     25/07/2017 22:31:22                          */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CAJA') and o.name = 'FK_CAJA_MANEJAR_ENCARGAD')
alter table CAJA
   drop constraint FK_CAJA_MANEJAR_ENCARGAD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SOLICITUDES') and o.name = 'FK_SOLICITU_REALIZAR_USUARIOS')
alter table SOLICITUDES
   drop constraint FK_SOLICITU_REALIZAR_USUARIOS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('VALE_CAJA') and o.name = 'FK_VALE_CAJ_EMITIR_ENCARGAD')
alter table VALE_CAJA
   drop constraint FK_VALE_CAJ_EMITIR_ENCARGAD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('VALE_CAJA') and o.name = 'FK_VALE_CAJ_SOLICITAN_USUARIOS')
alter table VALE_CAJA
   drop constraint FK_VALE_CAJ_SOLICITAN_USUARIOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CAJA')
            and   name  = 'MANEJAR_FK'
            and   indid > 0
            and   indid < 255)
   drop index CAJA.MANEJAR_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CAJA')
            and   type = 'U')
   drop table CAJA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ENCARGADO')
            and   type = 'U')
   drop table ENCARGADO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SOLICITUDES')
            and   name  = 'REALIZAR_FK'
            and   indid > 0
            and   indid < 255)
   drop index SOLICITUDES.REALIZAR_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SOLICITUDES')
            and   type = 'U')
   drop table SOLICITUDES
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USUARIOS')
            and   type = 'U')
   drop table USUARIOS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('VALE_CAJA')
            and   name  = 'SOLICITAN_FK'
            and   indid > 0
            and   indid < 255)
   drop index VALE_CAJA.SOLICITAN_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('VALE_CAJA')
            and   name  = 'EMITIR_FK'
            and   indid > 0
            and   indid < 255)
   drop index VALE_CAJA.EMITIR_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('VALE_CAJA')
            and   type = 'U')
   drop table VALE_CAJA
go

/*==============================================================*/
/* Table: CAJA                                                  */
/*==============================================================*/
create table CAJA (
   IDCAJA               char(5)              not null,
   IDENCARG             char(5)              not null,
   DECRIPCAJA           char(50)             not null,
   FECHACAJA            datetime             not null,
   MONTOCAJA            money                not null,
   MONTOACTUALCAJA      money                not null,
   ESTADOCAJA           char(20)             not null,
   constraint PK_CAJA primary key (IDCAJA)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('CAJA') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'CAJA' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Registrar Caja', 
   'user', @CurrentUser, 'table', 'CAJA'
go

/*==============================================================*/
/* Index: MANEJAR_FK                                            */
/*==============================================================*/
create index MANEJAR_FK on CAJA (
IDENCARG ASC
)
go

/*==============================================================*/
/* Table: ENCARGADO                                             */
/*==============================================================*/
create table ENCARGADO (
   IDENCARG             char(5)              not null,
   NOMENCARG            char(50)             not null,
   APELENCARG           char(50)             not null,
   CIENCARG             char(10)             not null,
   TLFENCARG            char(10)             not null,
   constraint PK_ENCARGADO primary key (IDENCARG)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('ENCARGADO') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'ENCARGADO' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Registro de Encargado', 
   'user', @CurrentUser, 'table', 'ENCARGADO'
go

/*==============================================================*/
/* Table: SOLICITUDES                                           */
/*==============================================================*/
create table SOLICITUDES (
   IDDOCU               char(5)              not null,
   IDUSU                char(5)              not null,
   FECHADOCU            datetime             not null,
   constraint PK_SOLICITUDES primary key (IDDOCU)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('SOLICITUDES') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'SOLICITUDES' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Archivos de Documentos', 
   'user', @CurrentUser, 'table', 'SOLICITUDES'
go

/*==============================================================*/
/* Index: REALIZAR_FK                                           */
/*==============================================================*/
create index REALIZAR_FK on SOLICITUDES (
IDUSU ASC
)
go

/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
create table USUARIOS (
   IDUSU                char(5)              not null,
   NOMUSU               char(50)             not null,
   APELUSU              char(50)             not null,
   CIUSU                char(10)             not null,
   TLFUSU               char(10)             not null,
   DPTOUSU              char(50)             not null,
   constraint PK_USUARIOS primary key (IDUSU)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('USUARIOS') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'USUARIOS' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Registro de Usuarios', 
   'user', @CurrentUser, 'table', 'USUARIOS'
go

/*==============================================================*/
/* Table: VALE_CAJA                                             */
/*==============================================================*/
create table VALE_CAJA (
   IDVALE               char(5)              not null,
   IDENCARG             char(5)              not null,
   IDUSU                char(5)              not null,
   FECHAVALE            datetime             not null,
   MONTOVALE            money                not null,
   CONCEPTOVALE         char(50)             not null,
   constraint PK_VALE_CAJA primary key (IDVALE)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VALE_CAJA') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'VALE_CAJA' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Archivos para registrar Vale', 
   'user', @CurrentUser, 'table', 'VALE_CAJA'
go

/*==============================================================*/
/* Index: EMITIR_FK                                             */
/*==============================================================*/
create index EMITIR_FK on VALE_CAJA (
IDENCARG ASC
)
go

/*==============================================================*/
/* Index: SOLICITAN_FK                                          */
/*==============================================================*/
create index SOLICITAN_FK on VALE_CAJA (
IDUSU ASC
)
go

alter table CAJA
   add constraint FK_CAJA_MANEJAR_ENCARGAD foreign key (IDENCARG)
      references ENCARGADO (IDENCARG)
go

alter table SOLICITUDES
   add constraint FK_SOLICITU_REALIZAR_USUARIOS foreign key (IDUSU)
      references USUARIOS (IDUSU)
go

alter table VALE_CAJA
   add constraint FK_VALE_CAJ_EMITIR_ENCARGAD foreign key (IDENCARG)
      references ENCARGADO (IDENCARG)
go

alter table VALE_CAJA
   add constraint FK_VALE_CAJ_SOLICITAN_USUARIOS foreign key (IDUSU)
      references USUARIOS (IDUSU)
go


