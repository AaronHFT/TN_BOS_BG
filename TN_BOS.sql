/*
SQLyog Ultimate v8.32 
MySQL - 5.5.55 : Database - tn_bos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tn_bos` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tn_bos`;

/*Table structure for table `act_evt_log` */

DROP TABLE IF EXISTS `act_evt_log`;

CREATE TABLE `act_evt_log` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_evt_log` */

/*Table structure for table `act_ge_bytearray` */

DROP TABLE IF EXISTS `act_ge_bytearray`;

CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_bytearray` */

/*Table structure for table `act_ge_property` */

DROP TABLE IF EXISTS `act_ge_property`;

CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ge_property` */

insert  into `act_ge_property`(`NAME_`,`VALUE_`,`REV_`) values ('next.dbid','1',1),('schema.history','create(5.21.0.0)',1),('schema.version','5.21.0.0',1);

/*Table structure for table `act_hi_actinst` */

DROP TABLE IF EXISTS `act_hi_actinst`;

CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_actinst` */

/*Table structure for table `act_hi_attachment` */

DROP TABLE IF EXISTS `act_hi_attachment`;

CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_attachment` */

/*Table structure for table `act_hi_comment` */

DROP TABLE IF EXISTS `act_hi_comment`;

CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_comment` */

/*Table structure for table `act_hi_detail` */

DROP TABLE IF EXISTS `act_hi_detail`;

CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_detail` */

/*Table structure for table `act_hi_identitylink` */

DROP TABLE IF EXISTS `act_hi_identitylink`;

CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_identitylink` */

/*Table structure for table `act_hi_procinst` */

DROP TABLE IF EXISTS `act_hi_procinst`;

CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime NOT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_procinst` */

/*Table structure for table `act_hi_taskinst` */

DROP TABLE IF EXISTS `act_hi_taskinst`;

CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime NOT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  `END_TIME_` datetime DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_taskinst` */

/*Table structure for table `act_hi_varinst` */

DROP TABLE IF EXISTS `act_hi_varinst`;

CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_hi_varinst` */

/*Table structure for table `act_id_group` */

DROP TABLE IF EXISTS `act_id_group`;

CREATE TABLE `act_id_group` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_group` */

/*Table structure for table `act_id_info` */

DROP TABLE IF EXISTS `act_id_info`;

CREATE TABLE `act_id_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VALUE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD_` longblob,
  `PARENT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_info` */

/*Table structure for table `act_id_membership` */

DROP TABLE IF EXISTS `act_id_membership`;

CREATE TABLE `act_id_membership` (
  `USER_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`USER_ID_`,`GROUP_ID_`),
  KEY `ACT_FK_MEMB_GROUP` (`GROUP_ID_`),
  CONSTRAINT `ACT_FK_MEMB_GROUP` FOREIGN KEY (`GROUP_ID_`) REFERENCES `act_id_group` (`ID_`),
  CONSTRAINT `ACT_FK_MEMB_USER` FOREIGN KEY (`USER_ID_`) REFERENCES `act_id_user` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_membership` */

/*Table structure for table `act_id_user` */

DROP TABLE IF EXISTS `act_id_user`;

CREATE TABLE `act_id_user` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_id_user` */

/*Table structure for table `act_procdef_info` */

DROP TABLE IF EXISTS `act_procdef_info`;

CREATE TABLE `act_procdef_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_procdef_info` */

/*Table structure for table `act_re_deployment` */

DROP TABLE IF EXISTS `act_re_deployment`;

CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_deployment` */

/*Table structure for table `act_re_model` */

DROP TABLE IF EXISTS `act_re_model`;

CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_model` */

/*Table structure for table `act_re_procdef` */

DROP TABLE IF EXISTS `act_re_procdef`;

CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_re_procdef` */

/*Table structure for table `act_ru_event_subscr` */

DROP TABLE IF EXISTS `act_ru_event_subscr`;

CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_event_subscr` */

/*Table structure for table `act_ru_execution` */

DROP TABLE IF EXISTS `act_ru_execution`;

CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_execution` */

/*Table structure for table `act_ru_identitylink` */

DROP TABLE IF EXISTS `act_ru_identitylink`;

CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_identitylink` */

/*Table structure for table `act_ru_job` */

DROP TABLE IF EXISTS `act_ru_job`;

CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_job` */

/*Table structure for table `act_ru_task` */

DROP TABLE IF EXISTS `act_ru_task`;

CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_task` */

/*Table structure for table `act_ru_variable` */

DROP TABLE IF EXISTS `act_ru_variable`;

CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `act_ru_variable` */

/*Table structure for table `billingtype` */

DROP TABLE IF EXISTS `billingtype`;

CREATE TABLE `billingtype` (
  `btypeid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(50) DEFAULT NULL,
  `btpyename` varchar(50) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`btypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `billingtype` */

insert  into `billingtype`(`btypeid`,`bname`,`btpyename`,`money`) values (1,'入库费','按重量10元1吨',10),(2,'入库费','按体积20元1米',20),(3,'仓储费','按月算1月120',120),(4,'仓储费','按日算1天4块',4),(5,'运输费','按重量20元1吨',20),(6,'运输费','按公里一公里20元',15),(7,'运输费','按时间一天6元',6);

/*Table structure for table `car_check` */

DROP TABLE IF EXISTS `car_check`;

CREATE TABLE `car_check` (
  `check_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` varchar(36) NOT NULL,
  `adaptability` int(11) DEFAULT '10',
  `timeliness` varchar(36) DEFAULT '良好',
  `Completeness` int(11) NOT NULL,
  `Vehicle_condition` varchar(36) DEFAULT '良好',
  `DelTag` int(11) DEFAULT '0',
  PRIMARY KEY (`check_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `car_check` */

insert  into `car_check`(`check_id`,`car_id`,`adaptability`,`timeliness`,`Completeness`,`Vehicle_condition`,`DelTag`) values (1,'201800001',8,'优秀',99,'良好',0),(2,'201800002',8,'良好',97,'良好',0),(3,'201800003',8,'良好',99,'良好',0),(4,'201800004',8,'良好',97,'良好',0),(5,'201800005',8,'良好',99,'良好',0),(6,'201800006',8,'优秀',100,'良好',0),(7,'201800007',8,'优秀',100,'良好',0),(8,'201800008',8,'良好',97,'良好',0),(9,'201800009',8,'优秀',99,'损坏',0);

/*Table structure for table `car_schedule` */

DROP TABLE IF EXISTS `car_schedule`;

CREATE TABLE `car_schedule` (
  `Schedule_id` varchar(36) NOT NULL,
  `car_id` varchar(36) NOT NULL,
  `context` varchar(200) NOT NULL,
  `resource` varchar(200) NOT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Schedule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car_schedule` */

/*Table structure for table `car_schedule_details` */

DROP TABLE IF EXISTS `car_schedule_details`;

CREATE TABLE `car_schedule_details` (
  `Schedule_details_id` varchar(36) NOT NULL,
  `tspt_id` varchar(36) NOT NULL,
  `line_id` varchar(36) NOT NULL,
  `car_id` varchar(36) NOT NULL,
  `driverid` varchar(36) NOT NULL,
  `vicedriverid` varchar(36) NOT NULL,
  `trafficState` varchar(10) NOT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `param` int(11) DEFAULT NULL,
  `spending` double DEFAULT NULL,
  PRIMARY KEY (`Schedule_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `car_schedule_details` */

/*Table structure for table `chargeoff` */

DROP TABLE IF EXISTS `chargeoff`;

CREATE TABLE `chargeoff` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '出账表id',
  `driverid` varchar(60) DEFAULT NULL COMMENT '驾驶员表id',
  `money` double DEFAULT NULL COMMENT '应付多少钱',
  `ispayment` int(11) DEFAULT NULL COMMENT '是否结账',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chargeoff` */

/*Table structure for table `checkgood` */

DROP TABLE IF EXISTS `checkgood`;

CREATE TABLE `checkgood` (
  `checkGood_id` int(11) NOT NULL AUTO_INCREMENT,
  `checkGood_goodLine` varchar(20) DEFAULT NULL,
  `checkGood_num` int(11) DEFAULT NULL,
  `checkGood_errorNum` int(11) DEFAULT NULL,
  `checkGood_date` datetime DEFAULT NULL,
  `checkGood_expectNum` int(11) DEFAULT NULL,
  `checkGood_state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`checkGood_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `checkgood` */

insert  into `checkgood`(`checkGood_id`,`checkGood_goodLine`,`checkGood_num`,`checkGood_errorNum`,`checkGood_date`,`checkGood_expectNum`,`checkGood_state`) values (1,'货物代码01入库编号01',200,0,'2018-10-10 00:00:00',200,'正常'),(2,'货物代码01入库编号01',210,10,'2018-10-11 00:00:00',200,'已处理'),(3,'货物代码01入库编号01',180,-20,'2018-10-12 00:00:00',200,'未处理'),(4,'货物代码01入库编号02',300,0,'2018-10-14 00:00:00',300,'正常'),(5,'货物代码01入库编号01',180,-20,'2018-10-13 00:00:00',200,'未处理'),(6,'20181061539501641499',100,0,'2018-10-14 00:00:00',100,'正常'),(7,'20181051539501617448',80,-20,'2018-10-14 00:00:00',100,'已处理'),(8,'20181051539500221351',100,0,'2018-10-14 00:00:00',100,'正常');

/*Table structure for table `contacts` */

DROP TABLE IF EXISTS `contacts`;

CREATE TABLE `contacts` (
  `con_id` int(11) NOT NULL AUTO_INCREMENT,
  `con_name` varchar(20) DEFAULT NULL,
  `con_phone` varchar(20) DEFAULT NULL,
  `con_address` varchar(20) DEFAULT NULL,
  `cus_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `contacts` */

insert  into `contacts`(`con_id`,`con_name`,`con_phone`,`con_address`,`cus_id`) values (1,'李四','12345678911','湖北省武汉市江岸区黄浦路75号','6f70718f-ce85-11e8-98ea-089e01e91d06'),(2,'王五','12345678922','湖北省武汉市武昌区中山路570','6f70718f-ce85-11e8-98ea-089e01e91d06'),(3,'赵六','12345678933','湖北省武汉市硚口区中山大道276号','6f70718f-ce85-11e8-98ea-089e01e91d06'),(4,'王九','12345678944','湖北省武汉市汉阳区琴台立交桥','6f70718f-ce85-11e8-98ea-089e01e91d06'),(5,'李四','12345678911','湖北省武汉市江岸区洞庭街2号','4f277457-cf61-11e8-98ea-089e01e91d06'),(6,'王十五','12345678955','湖北省武汉市武昌区中北路103-60号','6f70718f-ce85-11e8-98ea-089e01e91d06'),(7,'李四','12345678912','湖北省武汉市江岸区洞庭街2号','a0b8e954-d016-11e8-98ea-089e01e91d06');

/*Table structure for table `contract` */

DROP TABLE IF EXISTS `contract`;

CREATE TABLE `contract` (
  `cont_id` int(11) NOT NULL AUTO_INCREMENT,
  `conttype_id` int(11) DEFAULT NULL,
  `cont_price` double(20,2) DEFAULT NULL,
  `order_id` varchar(20) DEFAULT NULL,
  `cont_state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cont_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `contract` */

insert  into `contract`(`cont_id`,`conttype_id`,`cont_price`,`order_id`,`cont_state`) values (1,1,1.00,'15393941569512478567','已签订'),(2,2,1.00,'15393946171082823963','已签订'),(3,1,1.00,'15394212931006396984','已签订'),(4,1,2.00,'15394244388039365982','已签订'),(5,2,1.00,'15394345260639143652','已签订'),(6,3,100.00,'15394870978444356543','已签订'),(7,1,1.00,'15394891943869160830','已签订'),(8,1,1.00,'15394958584351151038','已签订'),(9,1,1.00,'15394997869527915044','已签订'),(10,1,12.00,'15395008372746126364','已签订'),(11,1,12.00,'15395009121364908371','已签订'),(12,2,1.00,'15395093814039099331','已签订'),(13,1,12.00,'15395239597875927430','已签订'),(15,1,2000.00,'15395686516424747310','已签订');

/*Table structure for table `contracttype` */

DROP TABLE IF EXISTS `contracttype`;

CREATE TABLE `contracttype` (
  `contT_id` int(11) NOT NULL AUTO_INCREMENT,
  `contT_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`contT_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `contracttype` */

insert  into `contracttype`(`contT_id`,`contT_name`) values (1,'入库合同'),(2,'出库合同'),(3,'运输合同');

/*Table structure for table `countmenty` */

DROP TABLE IF EXISTS `countmenty`;

CREATE TABLE `countmenty` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '结账表id',
  `storageid` int(11) DEFAULT NULL COMMENT '入库费id',
  `transportid` int(11) DEFAULT NULL COMMENT '仓储费id',
  `carriageid` int(11) DEFAULT NULL COMMENT '运输费id',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `ispayment` varchar(20) DEFAULT NULL COMMENT '是否结账',
  `carriagebid` varchar(60) DEFAULT NULL COMMENT '入库表id',
  `transportbid` varchar(60) DEFAULT NULL COMMENT '运输表id',
  `comebankbid` varchar(60) DEFAULT NULL COMMENT '出库表id',
  `ctype` varchar(60) DEFAULT NULL COMMENT '结算类型',
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `countmenty` */

insert  into `countmenty`(`id`,`storageid`,`transportid`,`carriageid`,`num`,`ispayment`,`carriagebid`,`transportbid`,`comebankbid`,`ctype`,`ctime`) values (1,NULL,NULL,NULL,NULL,'未结账',NULL,NULL,NULL,'15394212931006396984','2018-10-13 20:23:28'),(2,NULL,NULL,NULL,NULL,'未结账',NULL,NULL,NULL,'15394244388039365982','2018-10-13 20:23:34'),(3,NULL,NULL,NULL,NULL,'未结账',NULL,NULL,NULL,'15395093814039099331','2018-10-14 17:29:41'),(4,NULL,NULL,NULL,NULL,'未结账',NULL,NULL,NULL,'15395239597875927430','2018-10-14 21:32:40'),(5,NULL,NULL,NULL,NULL,'未结账',NULL,NULL,NULL,'15395686516424747310','2018-10-15 09:57:31');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cus_id` varchar(36) NOT NULL,
  `cus_pwd` varchar(16) DEFAULT NULL,
  `cus_name` varchar(10) DEFAULT NULL,
  `cus_short` varchar(10) DEFAULT NULL,
  `cus_industry` varchar(10) DEFAULT NULL,
  `cus_credit` int(2) DEFAULT NULL,
  `cus_email` varchar(50) DEFAULT NULL,
  `cus_adr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`cus_id`,`cus_pwd`,`cus_name`,`cus_short`,`cus_industry`,`cus_credit`,`cus_email`,`cus_adr`) values ('500c974c-d01e-11e8-98ea-089e01e91d06','qqq123','测试1','c1','IT',5,'123@sina.com','湖北省武汉市江岸区沿江大道146号'),('6f70718f-ce85-11e8-98ea-089e01e91d06','123','张三丰','zsf','IT',3,'1282130920@qq.com','湖北省武汉市江岸区胜利街254号'),('a0b8e954-d016-11e8-98ea-089e01e91d06','123','测试1','c2','IT',5,'123@sina.com','湖北省武汉市江岸区沿江大道146号');

/*Table structure for table `good` */

DROP TABLE IF EXISTS `good`;

CREATE TABLE `good` (
  `good_id` int(11) NOT NULL AUTO_INCREMENT,
  `store_position_id` varchar(20) DEFAULT NULL,
  `good_name` varchar(40) DEFAULT NULL,
  `good_code` varchar(20) DEFAULT NULL,
  `good_standard` varchar(50) DEFAULT NULL,
  `good_lotNum` varchar(50) DEFAULT NULL,
  `good_num` int(11) DEFAULT NULL,
  `good_minNum` int(11) DEFAULT NULL,
  `good_maxNum` int(11) DEFAULT NULL,
  `good_unit` varchar(10) DEFAULT NULL,
  `good_weight` double DEFAULT NULL,
  `good_volume` double DEFAULT NULL,
  `good_level` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `good` */

insert  into `good`(`good_id`,`store_position_id`,`good_name`,`good_code`,`good_standard`,`good_lotNum`,`good_num`,`good_minNum`,`good_maxNum`,`good_unit`,`good_weight`,`good_volume`,`good_level`) values (1,'鄂A01001QY0001CW001','九阴真经(下)','货物代码01','100本/箱','-',200,50,1000,'本',2000,0,'正品'),(2,'鄂A01001QY0001CW001','九阴真经(下)','货物代码01','100本/箱','-',500,50,1000,'箱',2000,0,'正品'),(3,'鄂A01001QY0001CW001','桦木','2018101','100','-',0,50,100,'根',0,0,'正品'),(7,'鄂A01001QY0001CW001','IphonePLus','2018105','100','-',0,50,100,'台',0,0,'正品'),(8,'鄂A01001QY0001CW001','三星NOTE','2018106','100','-',100,50,100,'台',100,100,'正品'),(9,'鄂A01001QY0001CW001','乾坤大挪移','2018109','100','-',100,50,100,'箱',100,100,'正品'),(10,'鄂A01001QY0001CW001','IphoneXS','2018108','100','-',100,50,100,'台',100,100,'正品');

/*Table structure for table `goodaccept` */

DROP TABLE IF EXISTS `goodaccept`;

CREATE TABLE `goodaccept` (
  `goodAccept_id` int(11) NOT NULL AUTO_INCREMENT,
  `goodAccept_code` varchar(50) DEFAULT NULL,
  `client_id` varchar(36) DEFAULT NULL,
  `truck_id` varchar(36) DEFAULT NULL,
  `pilot_id` int(11) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  `goodAccept_goodName` varchar(20) DEFAULT NULL,
  `goodAccept_goodCode` varchar(20) DEFAULT NULL,
  `goodAccept_standard` varchar(50) DEFAULT NULL,
  `goodAccept_level` varchar(20) DEFAULT NULL,
  `goodAccept_ExceptNum` int(11) DEFAULT NULL,
  `goodAccept_RealNum` int(11) DEFAULT NULL,
  `goodAccept_acceptNum` int(11) DEFAULT NULL,
  `goodAccept_destroyNum` int(11) DEFAULT NULL,
  `goodAccept_layNum` int(11) DEFAULT NULL,
  `goodAccept_handleNum` int(11) DEFAULT NULL,
  `goodAccept_producedDate` datetime DEFAULT NULL,
  `goodAccept_secureDate` datetime DEFAULT NULL,
  `goodAccept_weight` double DEFAULT NULL,
  `goodAccept_volume` double DEFAULT NULL,
  `goodAccept_unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`goodAccept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `goodaccept` */

insert  into `goodaccept`(`goodAccept_id`,`goodAccept_code`,`client_id`,`truck_id`,`pilot_id`,`order_id`,`goodAccept_goodName`,`goodAccept_goodCode`,`goodAccept_standard`,`goodAccept_level`,`goodAccept_ExceptNum`,`goodAccept_RealNum`,`goodAccept_acceptNum`,`goodAccept_destroyNum`,`goodAccept_layNum`,`goodAccept_handleNum`,`goodAccept_producedDate`,`goodAccept_secureDate`,`goodAccept_weight`,`goodAccept_volume`,`goodAccept_unit`) values (1,'SH2018092718162470500','货主ID01','货车ID01',1,'订单ID01','九阴真经(下)','货物代码01','100本/箱','正品',220,220,200,20,20,0,'2018-10-10 00:00:00','2999-01-01 00:00:00',2000,0,'箱'),(2,'f11221e3-cf54-11e8-8c7e-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800001',1,'15394212931006396984','桦木','201810131001','10.0 千克/箱','正品',100,100,10,10,0,10,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根'),(3,'317d9e15-cf66-11e8-aca1-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800001',1,'15394212931006396984','桦木','2018101','100','正品',100,100,100,10,0,0,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根'),(4,'4fb6bd37-cf66-11e8-aca1-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800001',1,'15394212931006396984','桦木','2018101','100','正品',100,100,100,10,0,0,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根'),(7,'42657295-cf78-11e8-8614-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800005',6,'15394958584351151038','IphoneXS','2018104','100','正品',100,100,100,10,0,10,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(9,'5054e515-cf7e-11e8-bef2-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800001',1,'15394997869527915044','IphonePLus','2018105','100','正品',100,100,100,10,0,10,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(10,'341062a9-cf81-11e8-b7ab-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800002',2,'15395008372746126364','IphonePLus','2018105','100','正品',100,100,100,10,0,10,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(11,'3b43307a-cf81-11e8-b7ab-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800003',3,'15395009121364908371','三星NOTE','2018106','100','正品',100,100,100,10,0,10,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(12,'84e41de7-cfb6-11e8-8e23-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800006',5,'15395239597875927430','乾坤大挪移','2018109','100','正品',100,100,100,10,0,10,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'箱'),(13,'cbb01bc7-d01f-11e8-8e70-005056c00008','6f70718f-ce85-11e8-98ea-089e01e91d06','201800003',1,'15395686516424747310','IphoneXS','2018108','100','正品',100,100,100,10,0,10,'2018-10-14 00:00:00','2018-12-14 00:00:00',100,100,'台');

/*Table structure for table `goodchange` */

DROP TABLE IF EXISTS `goodchange`;

CREATE TABLE `goodchange` (
  `goodChange_Code` varchar(60) NOT NULL,
  `good_line` varchar(20) DEFAULT NULL,
  `goodChange_id` varchar(50) DEFAULT NULL,
  `store_position_id` varchar(20) DEFAULT NULL,
  `goodChange_goodId` int(11) DEFAULT NULL,
  `truck_id` varchar(36) DEFAULT NULL,
  `pilot_id` int(11) DEFAULT NULL,
  `Order_id` varchar(36) DEFAULT NULL,
  `client_id` varchar(36) DEFAULT NULL,
  `goodChange_inTime` datetime DEFAULT NULL,
  `goodChange_producedDate` datetime DEFAULT NULL,
  `goodChange_secureDate` datetime DEFAULT NULL,
  `goodChange_num` int(11) DEFAULT NULL,
  `goodChange_unit` varchar(10) DEFAULT NULL,
  `goodChange_weight` double DEFAULT NULL,
  `goodChange_volume` double DEFAULT NULL,
  `goodChange_lv` varchar(10) DEFAULT NULL,
  `goodChange_type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodChange_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodchange` */

insert  into `goodchange`(`goodChange_Code`,`good_line`,`goodChange_id`,`store_position_id`,`goodChange_goodId`,`truck_id`,`pilot_id`,`Order_id`,`client_id`,`goodChange_inTime`,`goodChange_producedDate`,`goodChange_secureDate`,`goodChange_num`,`goodChange_unit`,`goodChange_weight`,`goodChange_volume`,`goodChange_lv`,`goodChange_type`,`state`) values ('1539483569006','20181011539483569006','f11221e3-cf54-11e8-8c7e-005056c00008','鄂A01001QY0001CW001',3,'201800001',1,'15394212931006396984','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','2018-10-10 00:00:00','2018-12-30 00:00:00',100,'根',100,100,'正品',2,0),('1539497648100','20181041539497648100','42657295-cf78-11e8-8614-005056c00008','鄂A01001QY0001CW001',4,'201800005',6,'15394958584351151038','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','2018-10-14 00:00:00','2020-12-14 00:00:00',100,'台',100,100,'正品',2,0),('1539500221351','20181051539500221351','5054e515-cf7e-11e8-bef2-005056c00008','鄂A01001QY0001CW001',7,'201800001',1,'15394997869527915044','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-15 00:00:00','2018-10-14 00:00:00','2020-12-14 00:00:00',100,'台',100,100,'正品',2,0),('1539501617448','20181051539501617448','341062a9-cf81-11e8-b7ab-005056c00008','鄂A01001QY0001CW001',7,'201800002',2,'15395008372746126364','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-15 00:00:00','2018-10-14 00:00:00','2020-12-14 00:00:00',100,'台',100,100,'正品',2,0),('1539501641499','20181061539501641499','3b43307a-cf81-11e8-b7ab-005056c00008','鄂A01001QY0001CW001',8,'201800003',3,'15395009121364908371','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-15 00:00:00','2018-10-14 00:00:00','2020-12-14 00:00:00',100,'台',100,100,'正品',2,0),('1539501907488','20181051539501617448','341062a9-cf81-11e8-b7ab-005056c00008','鄂A01001QY0001CW001',7,'201800002',2,'15395008372746126364','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','2018-10-14 00:00:00','2020-12-14 00:00:00',20,'台',10,10,'正品',8,1),('1539524366841','20181091539524366841','84e41de7-cfb6-11e8-8e23-005056c00008','鄂A01001QY0001CW001',9,'201800006',5,'15395239597875927430','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','2018-10-14 00:00:00','2020-12-14 00:00:00',100,'箱',100,100,'正品',2,0),('1539569659095','20181081539569659095','cbb01bc7-d01f-11e8-8e70-005056c00008','鄂A01001QY0001CW001',10,'201800003',1,'15395686516424747310','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-15 00:00:00','2018-10-14 00:00:00','2018-12-14 00:00:00',100,'台',100,100,'正品',2,0),('20181014032550','20181051539501617448','','鄂A01001QY0001CW001',7,'',0,'','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','2018-10-14 00:00:00','2020-12-14 00:00:00',80,'台',90,90,'正品',11,1),('20181015101555','20181051539500221351','','鄂A01001QY0001CW001',7,'',0,'','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-15 00:00:00','2018-10-14 00:00:00','2020-12-14 00:00:00',100,'台',100,100,'正品',11,1),('536','20181061539501641499','12','鄂A01001QY0001CW001',8,'201800003',3,'15395093814039099331','6f70718f-ce85-11e8-98ea-089e01e91d06','2018-10-15 10:37:23','2018-10-14 00:00:00','2020-12-14 00:00:00',100,'台',100,100,'正品',3,1);

/*Table structure for table `goodcheck` */

DROP TABLE IF EXISTS `goodcheck`;

CREATE TABLE `goodcheck` (
  `goodCheck_id` int(11) NOT NULL AUTO_INCREMENT,
  `goodCheck_code` varchar(50) DEFAULT NULL,
  `goodCheck_managerId` varchar(36) DEFAULT NULL,
  `goodCheck_managerDate` datetime DEFAULT NULL,
  `client_id` varchar(36) DEFAULT NULL,
  `truck_id` varchar(36) DEFAULT NULL,
  `pilot_id` int(11) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  `goodCheck_goodName` varchar(20) DEFAULT NULL,
  `goodCheck_goodCode` varchar(20) DEFAULT NULL,
  `goodCheck_standard` varchar(50) DEFAULT NULL,
  `goodCkeck_level` varchar(20) DEFAULT NULL,
  `goodCheck_ExceptNum` int(11) DEFAULT NULL,
  `goodCheck_RealNum` int(11) DEFAULT NULL,
  `goodCkeck_acceptNum` int(11) DEFAULT NULL,
  `goodCheck_destroyNum` int(11) DEFAULT NULL,
  `goodCheck_layNum` int(11) DEFAULT NULL,
  `goodCheck_producedDate` datetime DEFAULT NULL,
  `goodCheck_secureDate` datetime DEFAULT NULL,
  `goodCheck_weight` double DEFAULT NULL,
  `goodCheck_volume` double DEFAULT NULL,
  `goodCheck_unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`goodCheck_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `goodcheck` */

insert  into `goodcheck`(`goodCheck_id`,`goodCheck_code`,`goodCheck_managerId`,`goodCheck_managerDate`,`client_id`,`truck_id`,`pilot_id`,`order_id`,`goodCheck_goodName`,`goodCheck_goodCode`,`goodCheck_standard`,`goodCkeck_level`,`goodCheck_ExceptNum`,`goodCheck_RealNum`,`goodCkeck_acceptNum`,`goodCheck_destroyNum`,`goodCheck_layNum`,`goodCheck_producedDate`,`goodCheck_secureDate`,`goodCheck_weight`,`goodCheck_volume`,`goodCheck_unit`) values (1,'9695ead1-cf54-11e8-8c7e-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800001',1,'15394212931006396984','桦木','2018101','100','正品',100,100,100,10,0,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根'),(2,'cdc4cf32-cf54-11e8-8c7e-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800001',1,'15394212931006396984','桦木','2018101','100','正品',100,100,100,10,0,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根'),(3,'684d6f53-cf62-11e8-8999-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800003',3,'15394345260639143652','桦木','2018101','100','正品',100,100,100,10,0,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根'),(4,'829c34e4-cf62-11e8-8999-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800003',3,'15394345260639143652','桦木','2018101','100','正品',100,100,100,10,0,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根'),(5,'090b4ef3-cf66-11e8-aca1-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800004',5,'15394891943869160830','桦木','2018103','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2018-12-14 00:00:00',100,100,'根'),(6,'1cfc9814-cf66-11e8-aca1-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800004',5,'15394891943869160830','桦木','2018103','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2018-12-14 00:00:00',100,100,'根'),(11,'04a97643-cf78-11e8-8614-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800005',6,'15394958584351151038','IphoneXS','2018104','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(12,'166cbbd4-cf78-11e8-8614-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800005',6,'15394958584351151038','IphoneXS','2018104','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(15,'1c2cb103-cf7e-11e8-bef2-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800001',1,'15394997869527915044','IphonePLus','2018105','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(16,'27e295f4-cf7e-11e8-bef2-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800001',1,'15394997869527915044','IphonePLus','2018105','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(17,'e8f05c35-cf80-11e8-b7ab-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800002',2,'15395008372746126364','IphonePLus','2018105','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(18,'f3733f66-cf80-11e8-b7ab-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800003',3,'15395009121364908371','三星NOTE','2018106','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(19,'035086e7-cf81-11e8-b7ab-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800002',2,'15395008372746126364','IphonePLus','2018105','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(20,'08a8a148-cf81-11e8-b7ab-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800003',3,'15395009121364908371','三星NOTE','2018106','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台'),(23,'6e1b4ac5-cfb6-11e8-8e23-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800006',5,'15395239597875927430','乾坤大挪移','2018109','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'箱'),(24,'7b03e356-cfb6-11e8-8e23-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-14 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800006',5,'15395239597875927430','乾坤大挪移','2018109','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'箱'),(27,'ae1c3d55-d01f-11e8-8e70-005056c00008','5a579a7d-cf4f-11e8-98ea-089e01e91d06','2018-10-15 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800003',1,'15395686516424747310','IphoneXS','2018108','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2018-12-14 00:00:00',100,100,'台'),(28,'be73bde6-d01f-11e8-8e70-005056c00008','7d87ea39-cdfc-11e8-98ea-089e01e91d06','2018-10-15 00:00:00','6f70718f-ce85-11e8-98ea-089e01e91d06','201800003',1,'15395686516424747310','IphoneXS','2018108','100','正品',100,100,100,10,0,'2018-10-14 00:00:00','2018-12-14 00:00:00',100,100,'台');

/*Table structure for table `goodin` */

DROP TABLE IF EXISTS `goodin`;

CREATE TABLE `goodin` (
  `goodIn_Code` varchar(20) NOT NULL,
  `goodAccept_id` varchar(50) DEFAULT NULL,
  `truck_id` varchar(36) DEFAULT NULL,
  `pilot_id` int(11) DEFAULT NULL,
  `order_id` varchar(36) DEFAULT NULL,
  `client_id` varchar(36) DEFAULT NULL,
  `goodIn_inTime` datetime DEFAULT NULL,
  `goodIn_producedDate` datetime DEFAULT NULL,
  `goodIn_secureDate` datetime DEFAULT NULL,
  `goodIn_num` int(11) DEFAULT NULL,
  `goodIn_unit` varchar(10) DEFAULT NULL,
  `goodIn_weight` double DEFAULT NULL,
  `goodIn_volume` double DEFAULT NULL,
  `goodIn_lv` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`goodIn_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodin` */

/*Table structure for table `goodreach` */

DROP TABLE IF EXISTS `goodreach`;

CREATE TABLE `goodreach` (
  `goodReach_id` int(11) NOT NULL AUTO_INCREMENT,
  `goodReach_code` varchar(20) DEFAULT NULL,
  `order_id` varchar(20) DEFAULT NULL,
  `truck_id` varchar(36) DEFAULT NULL,
  `pilot_id` int(11) DEFAULT NULL,
  `goodReach_goodName` varchar(20) DEFAULT NULL,
  `goodReach_goodCode` varchar(20) DEFAULT NULL,
  `goodReach_standard` varchar(50) DEFAULT NULL,
  `goodReach_level` varchar(20) DEFAULT NULL,
  `goodReach_ExceptNum` int(11) DEFAULT NULL,
  `goodReach_producedDate` datetime DEFAULT NULL,
  `goodReach_secureDate` datetime DEFAULT NULL,
  `goodReach_weight` double DEFAULT NULL,
  `goodReach_volume` double DEFAULT NULL,
  `goodReach_unit` varchar(10) DEFAULT NULL,
  `goodReach_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodReach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `goodreach` */

insert  into `goodreach`(`goodReach_id`,`goodReach_code`,`order_id`,`truck_id`,`pilot_id`,`goodReach_goodName`,`goodReach_goodCode`,`goodReach_standard`,`goodReach_level`,`goodReach_ExceptNum`,`goodReach_producedDate`,`goodReach_secureDate`,`goodReach_weight`,`goodReach_volume`,`goodReach_unit`,`goodReach_state`) values (1,'02018101312345678911','15394212931006396984','201800001',1,'桦木','2018101','100','正品',100,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根',0),(3,'12018101312345678922','15394345260639143652','201800003',3,'桦木','2018101','100','正品',100,'2018-10-10 00:00:00','2018-12-30 00:00:00',100,100,'根',1),(4,'02018101412345678944','15394870978444356543','201800007',4,'桦木','2018102','100','正品',100,'2018-10-14 00:00:00','2018-12-14 00:00:00',100,100,'根',0),(5,'02018101412345678944','15394891943869160830','201800004',5,'桦木','2018103','100','正品',100,'2018-10-14 00:00:00','2018-12-14 00:00:00',100,100,'根',0),(8,'02018101412345678944','15394958584351151038','201800005',6,'IphoneXS','2018104','100','正品',100,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台',0),(9,'02018101412345678944','15394997869527915044','201800001',1,'IphonePLus','2018105','100','正品',100,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台',0),(10,'02018101412345678944','15395008372746126364','201800002',2,'IphonePLus','2018105','100','正品',100,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台',0),(11,'02018101412345678944','15395009121364908371','201800003',3,'三星NOTE','2018106','100','正品',100,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台',0),(12,'12018101412345678933','15395093814039099331','201800004',4,'三星NOTE','2018106','100','正品',100,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'台',1),(13,'02018101412345678944','15395239597875927430','201800006',5,'乾坤大挪移','2018109','100','正品',100,'2018-10-14 00:00:00','2020-12-14 00:00:00',100,100,'箱',0),(14,'02018101512345678955','15395686516424747310','201800003',1,'IphoneXS','2018108','100','正品',100,'2018-10-14 00:00:00','2018-12-14 00:00:00',100,100,'台',0);

/*Table structure for table `goodsendout` */

DROP TABLE IF EXISTS `goodsendout`;

CREATE TABLE `goodsendout` (
  `goodSendOut_id` varchar(20) NOT NULL,
  `client_id` varchar(36) DEFAULT NULL,
  `order_id` varchar(20) DEFAULT NULL,
  `driver_id` varchar(36) DEFAULT NULL,
  `truct_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`goodSendOut_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goodsendout` */

/*Table structure for table `illegal` */

DROP TABLE IF EXISTS `illegal`;

CREATE TABLE `illegal` (
  `Illegalreason_id` int(11) NOT NULL AUTO_INCREMENT,
  `Illegalreason` varchar(200) DEFAULT NULL,
  `site` varchar(200) DEFAULT NULL,
  `Illegal_pilotId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Illegalreason_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `illegal` */

insert  into `illegal`(`Illegalreason_id`,`Illegalreason`,`site`,`Illegal_pilotId`) values (1,'超速','湖北省荆门市武荆高速',4),(2,'违规停车','湖北省徐东大街',5),(3,'未系安全带','湖北省光谷大道',3);

/*Table structure for table `instoretype` */

DROP TABLE IF EXISTS `instoretype`;

CREATE TABLE `instoretype` (
  `inStoreType_id` int(11) NOT NULL AUTO_INCREMENT,
  `inStoreTYpe_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`inStoreType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `instoretype` */

insert  into `instoretype`(`inStoreType_id`,`inStoreTYpe_type`) values (1,'预定入库'),(2,'销售入库'),(3,'采购入库'),(4,'调整入库'),(5,'内拨入库'),(6,'盘点入库'),(7,'退货入库'),(8,'调换入库'),(9,'包装入库'),(10,'报费入库');

/*Table structure for table `jobposition` */

DROP TABLE IF EXISTS `jobposition`;

CREATE TABLE `jobposition` (
  `jobposition_id` int(11) NOT NULL AUTO_INCREMENT,
  `jobposition_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`jobposition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `jobposition` */

insert  into `jobposition`(`jobposition_id`,`jobposition_name`) values (1,'超级管理员'),(2,'仓库管理员');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `order_id` varchar(20) NOT NULL,
  `cus_id` varchar(36) DEFAULT NULL,
  `orderType_id` int(11) DEFAULT NULL,
  `order_time` date DEFAULT NULL,
  `con_id` int(11) DEFAULT NULL,
  `webnodes_id` int(11) DEFAULT NULL,
  `order_state` varchar(20) DEFAULT NULL,
  `store_id` varchar(20) DEFAULT NULL,
  `order_province` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`order_id`,`cus_id`,`orderType_id`,`order_time`,`con_id`,`webnodes_id`,`order_state`,`store_id`,`order_province`) values ('15394212931006396984','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-13',1,3,'质检完成','鄂A01001','湖北'),('15394345260639143652','6f70718f-ce85-11e8-98ea-089e01e91d06',3,'2018-10-13',2,3,'质检完成','鄂A01001','湖北'),('15394870978444356543','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-14',4,5,'质检完成','鄂A01001','湖北'),('15394891943869160830','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-14',4,5,'质检完成','鄂A01001','湖北'),('15394958584351151038','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-14',4,5,'质检完成','鄂A01001','湖北'),('15394997869527915044','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-14',4,5,'质检完成','鄂A01002','湖北'),('15395008372746126364','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-14',4,5,'质检完成','鄂A01002','湖北'),('15395009121364908371','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-14',4,5,'质检完成','鄂A01002','湖北'),('1539503712735','6f70718f-ce85-11e8-98ea-089e01e91d06',9,'2018-10-14',4,5,'调度运输','鄂A01002','暂无'),('1539505284592','6f70718f-ce85-11e8-98ea-089e01e91d06',9,'2018-10-14',4,5,'调度运输','鄂A01002','暂无'),('15395093814039099331','6f70718f-ce85-11e8-98ea-089e01e91d06',3,'2018-10-14',3,5,'调度运输完','鄂A01001','湖北'),('15395239597875927430','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-14',4,5,'质检完成','鄂A01001','湖北'),('1539534249952','6f70718f-ce85-11e8-98ea-089e01e91d06',9,'2018-10-14',4,5,'调度运输','鄂A01001','暂无'),('15395686516424747310','6f70718f-ce85-11e8-98ea-089e01e91d06',2,'2018-10-15',6,4,'质检完成','鄂A01002','湖北'),('1539572762662','6f70718f-ce85-11e8-98ea-089e01e91d06',9,'2018-10-15',6,4,'调度运输','鄂A01002','暂无');

/*Table structure for table `ordertype` */

DROP TABLE IF EXISTS `ordertype`;

CREATE TABLE `ordertype` (
  `orderType_id` int(11) NOT NULL AUTO_INCREMENT,
  `orderType_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`orderType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `ordertype` */

insert  into `ordertype`(`orderType_id`,`orderType_name`) values (1,'托运订单'),(2,'入库订单'),(3,'出库订单'),(4,'调拨订单');

/*Table structure for table `outstoretype` */

DROP TABLE IF EXISTS `outstoretype`;

CREATE TABLE `outstoretype` (
  `outStoreType_id` int(11) NOT NULL AUTO_INCREMENT,
  `outStoreType_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`outStoreType_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `outstoretype` */

insert  into `outstoretype`(`outStoreType_id`,`outStoreType_type`) values (1,'预定出库'),(2,'预拣出库'),(3,'销售出库'),(4,'领用出库'),(5,'抽样出库'),(6,'调整出库'),(7,'内拨出库'),(8,'盘点出库'),(9,'退货出库'),(10,'调换出库'),(11,'包装出库'),(12,'报废出库');

/*Table structure for table `pickuplist` */

DROP TABLE IF EXISTS `pickuplist`;

CREATE TABLE `pickuplist` (
  `pickUpListId` varchar(60) NOT NULL,
  `goodSendOut_id` varchar(20) DEFAULT NULL,
  `good_code` varchar(20) DEFAULT NULL,
  `pickUpList_num` int(11) DEFAULT NULL,
  `pickUpList_weight` double DEFAULT NULL,
  `pickUpList_volume` double DEFAULT NULL,
  `goodSendOut_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pickUpListId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pickuplist` */

insert  into `pickuplist`(`pickUpListId`,`goodSendOut_id`,`good_code`,`pickUpList_num`,`pickUpList_weight`,`pickUpList_volume`,`goodSendOut_date`) values ('29035','12','2018106',100,100,100,'2018-10-15 10:37:21');

/*Table structure for table `pilot` */

DROP TABLE IF EXISTS `pilot`;

CREATE TABLE `pilot` (
  `pilot_id` int(11) NOT NULL AUTO_INCREMENT,
  `pilot_name` varchar(22) NOT NULL,
  `drivinglicence` varchar(32) NOT NULL,
  `pilot_mark` int(11) DEFAULT '12',
  `privinglicenceimg` varchar(200) DEFAULT NULL,
  `pilot_delTag` int(11) DEFAULT '0',
  PRIMARY KEY (`pilot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `pilot` */

insert  into `pilot`(`pilot_id`,`pilot_name`,`drivinglicence`,`pilot_mark`,`privinglicenceimg`,`pilot_delTag`) values (1,'李国友','450821987090809614',12,'/transport/img/driving01.jpeg',2),(2,'侯恒光','441225197906112512',12,'/transport/img/driving02.jpeg',0),(3,'刘坤龙','210181820222061125',10,'/transport/img/driving03.jpg',0),(4,'叶荣操','440782197905741412',6,'/transport/img/driving04.jpg',0),(5,'赵革仁','150203196609253017',8,'/transport/img/driving05.jpg',0),(6,'郑享鸣','421302199009152346',12,'/transport/img/driving06.png',0);

/*Table structure for table `portfolio` */

DROP TABLE IF EXISTS `portfolio`;

CREATE TABLE `portfolio` (
  `portfolio_id` int(11) NOT NULL AUTO_INCREMENT,
  `mileage` int(11) DEFAULT '0',
  `month` int(11) DEFAULT NULL,
  `portfolio_pilotId` int(11) DEFAULT NULL,
  PRIMARY KEY (`portfolio_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `portfolio` */

insert  into `portfolio`(`portfolio_id`,`mileage`,`month`,`portfolio_pilotId`) values (1,4280,8,1),(2,6210,8,2),(3,3543,8,3),(4,4150,8,4),(5,3210,8,5),(6,1245,8,6);

/*Table structure for table `returnhistory` */

DROP TABLE IF EXISTS `returnhistory`;

CREATE TABLE `returnhistory` (
  `returnHistory_id` int(11) NOT NULL AUTO_INCREMENT,
  `returnHistory_orderId` varchar(20) DEFAULT NULL,
  `returnHistory_goodName` varchar(20) DEFAULT NULL,
  `returnHistory_goodCode` varchar(20) DEFAULT NULL,
  `returnHistory_standard` varchar(50) DEFAULT NULL,
  `returnHistory_level` varchar(20) DEFAULT NULL,
  `returnHistory_Num` int(11) DEFAULT NULL,
  `returnHistory_producedDate` datetime DEFAULT NULL,
  `returnHistory_secureDate` datetime DEFAULT NULL,
  `returnHistory_weight` double DEFAULT NULL,
  `returnHistory_volume` double DEFAULT NULL,
  `returnHistory_unit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`returnHistory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `returnhistory` */

insert  into `returnhistory`(`returnHistory_id`,`returnHistory_orderId`,`returnHistory_goodName`,`returnHistory_goodCode`,`returnHistory_standard`,`returnHistory_level`,`returnHistory_Num`,`returnHistory_producedDate`,`returnHistory_secureDate`,`returnHistory_weight`,`returnHistory_volume`,`returnHistory_unit`) values (1,'1539486555393','桦木','201810131001','100','正品',10,'2018-10-10 00:00:00','2018-12-30 00:00:00',10,10,'根'),(2,'1539495188038','慕华','2018104','100','正品',10,'2018-10-15 00:00:00','2018-12-15 00:00:00',20,20,'箱'),(3,'1539503094084','IphoneXS','2018104','100','正品',10,'2018-10-14 00:00:00','2020-12-14 00:00:00',10,10,'台'),(4,'1539505752891','二狗子','2018105','100','正品',10,'2018-10-15 00:00:00','2018-12-15 00:00:00',20,20,'箱'),(5,'1539505728991','IphonePLus','2018105','100','正品',10,'2018-10-14 00:00:00','2020-12-14 00:00:00',10,10,'台'),(6,'1539503712735','IphonePLus','2018105','100','正品',10,'2018-10-14 00:00:00','2020-12-14 00:00:00',10,10,'台'),(7,'1539505284592','三星NOTE','2018106','100','正品',10,'2018-10-14 00:00:00','2020-12-14 00:00:00',10,10,'台'),(8,'1539534249952','乾坤大挪移','2018109','100','正品',10,'2018-10-14 00:00:00','2020-12-14 00:00:00',10,10,'箱'),(9,'1539572762662','IphoneXS','2018108','100','正品',10,'2018-10-14 00:00:00','2018-12-14 00:00:00',10,10,'台');

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `store_id` varchar(20) NOT NULL,
  `store_name` varchar(20) DEFAULT NULL,
  `store_area` int(11) DEFAULT NULL,
  `store_type` varchar(20) DEFAULT NULL,
  `store_address` varchar(20) DEFAULT NULL,
  `store_buildDate` datetime DEFAULT NULL,
  `store_manager` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `store` */

insert  into `store`(`store_id`,`store_name`,`store_area`,`store_type`,`store_address`,`store_buildDate`,`store_manager`) values ('鄂A01001','湖北武汉北1号仓',5000,'普通仓库','湖北省武汉市汉阳区鹦鹉大道297','2015-10-10 00:00:00','d806b417-c1f1-11e8-ba45-54ab3a47eda7'),('鄂A01002','湖北武汉北2号仓',5000,'普通仓库','湖北省武汉市武昌区武珞路145号','2015-10-10 00:00:00','d806b417-c1f1-11e8-ba45-54ab3a47eda7'),('鄂A01003','湖北武汉北3号仓',5000,'普通仓库','湖北省武汉市江汉区友谊路12-315','2015-10-10 00:00:00','d806b417-c1f1-11e8-ba45-54ab3a47eda7');

/*Table structure for table `store_position` */

DROP TABLE IF EXISTS `store_position`;

CREATE TABLE `store_position` (
  `store_position_id` varchar(20) NOT NULL,
  `store_position_name` varchar(20) DEFAULT NULL,
  `store_position_area` int(11) DEFAULT NULL,
  `store_region_id` varchar(20) DEFAULT NULL,
  `store_position_buildDate` datetime DEFAULT NULL,
  PRIMARY KEY (`store_position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `store_position` */

insert  into `store_position`(`store_position_id`,`store_position_name`,`store_position_area`,`store_region_id`,`store_position_buildDate`) values ('鄂A01001QY0001CW001','001号仓位',25,'鄂A01001QY0001','2017-10-10 00:00:00');

/*Table structure for table `store_region` */

DROP TABLE IF EXISTS `store_region`;

CREATE TABLE `store_region` (
  `store_region_id` varchar(20) NOT NULL,
  `store_region_name` varchar(20) DEFAULT NULL,
  `store_region_area` int(11) DEFAULT NULL,
  `store_id` varchar(20) DEFAULT NULL,
  `store_region_buildDate` datetime DEFAULT NULL,
  PRIMARY KEY (`store_region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `store_region` */

insert  into `store_region`(`store_region_id`,`store_region_name`,`store_region_area`,`store_id`,`store_region_buildDate`) values ('鄂A01001QY0001','0001号仓库区域',100,'鄂A01001','2017-10-10 00:00:00');

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `sys_permission_id` varchar(20) NOT NULL,
  `sys_permission_name` varchar(128) DEFAULT NULL,
  `sys_permission_type` varchar(32) DEFAULT NULL,
  `sys_permission_url` varchar(128) DEFAULT NULL,
  `sys_permission_percode` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`sys_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `sys_role_id` varchar(20) NOT NULL,
  `sys_role_name` varchar(128) DEFAULT NULL,
  `sys_role_available` int(11) DEFAULT '1',
  PRIMARY KEY (`sys_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `sys_role_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_role_id` varchar(20) DEFAULT NULL,
  `sys_permission_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sys_role_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

/*Table structure for table `sys_role_user` */

DROP TABLE IF EXISTS `sys_role_user`;

CREATE TABLE `sys_role_user` (
  `sys_role_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_role_id` varchar(20) NOT NULL,
  `sys_user_id` varchar(36) NOT NULL,
  PRIMARY KEY (`sys_role_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_user` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `sys_user_id` varchar(36) NOT NULL,
  `sys_user_usercode` varchar(20) DEFAULT NULL,
  `sys_user_username` varchar(20) DEFAULT NULL,
  `sys_user_password` varchar(20) DEFAULT NULL,
  `jobposition_id` int(11) DEFAULT NULL,
  `sys_user_locked` int(11) DEFAULT '0',
  PRIMARY KEY (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`sys_user_id`,`sys_user_usercode`,`sys_user_username`,`sys_user_password`,`jobposition_id`,`sys_user_locked`) values ('5a579a7d-cf4f-11e8-98ea-089e01e91d06','lisi','李四','123',1,0),('7d87ea39-cdfc-11e8-98ea-089e01e91d06','zhangsan','张三','123',1,1);

/*Table structure for table `tarnsportation_plan` */

DROP TABLE IF EXISTS `tarnsportation_plan`;

CREATE TABLE `tarnsportation_plan` (
  `tspt_id` int(11) NOT NULL AUTO_INCREMENT,
  `tspt_date` date DEFAULT NULL,
  `load_num` datetime DEFAULT NULL,
  `tspt_type` varchar(36) NOT NULL,
  `tspt_starting` varchar(200) NOT NULL,
  `tspt_downtown` varchar(200) NOT NULL,
  `tspt_freight` double NOT NULL,
  `tspt_state` varchar(36) NOT NULL,
  `ountput_id` varchar(50) NOT NULL,
  `summileage` double NOT NULL,
  `delTag` int(11) DEFAULT '0',
  PRIMARY KEY (`tspt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `tarnsportation_plan` */

insert  into `tarnsportation_plan`(`tspt_id`,`tspt_date`,`load_num`,`tspt_type`,`tspt_starting`,`tspt_downtown`,`tspt_freight`,`tspt_state`,`ountput_id`,`summileage`,`delTag`) values (1,'2018-10-13','2018-10-13 19:27:18','路运','湖北省武汉市江岸区沿江大道254号','湖北省武汉市汉阳区鹦鹉大道297',41.099999999999994,'运输中','15394212931006396984',13.7,0),(2,'2018-10-13','2018-10-13 21:15:20','路运','湖北省武汉市汉阳区鹦鹉大道297','湖北省武汉市江岸区沿江大道254号',38.099999999999994,'运输中','15394345260639143652',12.7,0),(3,'2018-10-14','2018-10-14 11:54:38','路运','湖北省武汉市硚口区中山大道380-1号','湖北省武汉市汉阳区鹦鹉大道297',23.1,'运输中','15394870978444356543',7.7,0),(4,'2018-10-14','2018-10-14 12:15:20','路运','湖北省武汉市硚口区中山大道380-1号','湖北省武汉市汉阳区鹦鹉大道297',19.5,'运输中','15394891943869160830',6.5,0),(5,'2018-10-14','2018-10-14 14:28:44','路运','湖北省武汉市硚口区中山大道380-1号','湖北省武汉市汉阳区鹦鹉大道297',19.5,'运输中','15394958584351151038',6.5,0),(6,'2018-10-14','2018-10-14 15:18:35','路运','湖北省武汉市硚口区中山大道380-1号','湖北省武汉市武昌区武珞路145号',31.5,'运输中','15394997869527915044',10.5,0),(7,'2018-10-14','2018-10-14 15:34:52','路运','湖北省武汉市硚口区中山大道380-1号','湖北省武汉市武昌区武珞路145号',31.5,'运输中','15395008372746126364',10.5,0),(8,'2018-10-14','2018-10-14 15:37:05','路运','湖北省武汉市硚口区中山大道380-1号','湖北省武汉市武昌区武珞路145号',35.099999999999994,'运输中','15395009121364908371',11.7,0),(9,'2018-10-14','2018-10-14 18:17:48','路运','湖北省武汉市汉阳区鹦鹉大道297','湖北省武汉市硚口区中山大道380-1号',21.6,'运输中','15395093814039099331',7.2,0),(10,'2018-10-14','2018-10-14 21:55:22','路运','湖北省武汉市硚口区中山大道380-1号','湖北省武汉市汉阳区鹦鹉大道297',23.1,'运输中','15395239597875927430',7.7,0),(11,'2018-10-15','2018-10-15 10:28:35','路运','湖北省武汉市武昌区徐东大街5号','湖北省武汉市武昌区武珞路145号',27,'运输中','15395686516424747310',9,0);

/*Table structure for table `tn_bos_entryorder` */

DROP TABLE IF EXISTS `tn_bos_entryorder`;

CREATE TABLE `tn_bos_entryorder` (
  `ent_or_id` varchar(36) NOT NULL,
  `cus_or_id` varchar(36) DEFAULT NULL,
  `cus_id` varchar(36) DEFAULT NULL,
  `goodReach_id` varchar(20) DEFAULT NULL,
  `plan_time` date DEFAULT NULL,
  `inStoreType_id` int(11) DEFAULT NULL,
  `ent_method` varchar(20) NOT NULL,
  `ent_rep_id` varchar(36) NOT NULL,
  PRIMARY KEY (`ent_or_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tn_bos_entryorder` */

insert  into `tn_bos_entryorder`(`ent_or_id`,`cus_or_id`,`cus_id`,`goodReach_id`,`plan_time`,`inStoreType_id`,`ent_method`,`ent_rep_id`) values ('1502e3e1-cf7e-11e8-bef2-005056c00008','15394997869527915044','6f70718f-ce85-11e8-98ea-089e01e91d06','9','2018-10-15',3,'一次性入库','鄂A01002'),('154d8f41-cebf-11e8-8c4c-005056c00008','15393941569512478567','6f70718f-ce85-11e8-98ea-089e01e91d06','2','2018-10-13',3,'一次性入库','鄂A01001'),('3a374ba1-cfb6-11e8-8e23-005056c00008','15395239597875927430','6f70718f-ce85-11e8-98ea-089e01e91d06','13','2018-10-15',3,'一次性入库','鄂A01001'),('55d112f1-cf62-11e8-8999-005056c00008','15394870978444356543','6f70718f-ce85-11e8-98ea-089e01e91d06','4','2018-10-13',3,'一次性入库','鄂A01002'),('70e390f1-cf52-11e8-b3a5-005056c00008','15394345260639143652','6f70718f-ce85-11e8-98ea-089e01e91d06','3','2018-10-13',3,'一次性入库','鄂A01001'),('7445b891-d01f-11e8-8e70-005056c00008','15395686516424747310','6f70718f-ce85-11e8-98ea-089e01e91d06','14','2018-10-15',3,'一次性入库','鄂A01001'),('a2a07fe1-ceda-11e8-8fbd-005056c00008','15394212931006396984','6f70718f-ce85-11e8-98ea-089e01e91d06','1','2018-10-13',3,'一次性入库','鄂A01001'),('d3e4c971-cf80-11e8-b7ab-005056c00008','15395008372746126364','6f70718f-ce85-11e8-98ea-089e01e91d06','10','2018-10-15',3,'一次性入库','鄂A01001'),('e06ddce3-cf80-11e8-b7ab-005056c00008','15395009121364908371','6f70718f-ce85-11e8-98ea-089e01e91d06','11','2018-10-15',3,'一次性入库','鄂A01001'),('fd2e54d1-cf77-11e8-8614-005056c00008','15394958584351151038','6f70718f-ce85-11e8-98ea-089e01e91d06','8','2018-10-15',3,'一次性入库','鄂A01003'),('fe5db241-cf65-11e8-aca1-005056c00008','15394891943869160830','6f70718f-ce85-11e8-98ea-089e01e91d06','5','2018-10-13',3,'一次性入库','鄂A01002');

/*Table structure for table `transportationdetails` */

DROP TABLE IF EXISTS `transportationdetails`;

CREATE TABLE `transportationdetails` (
  `tdid` varchar(36) NOT NULL,
  `Schedule_details_id` varchar(36) NOT NULL,
  `mid` varchar(36) NOT NULL,
  `tdtime` date NOT NULL,
  `tdweight` decimal(10,2) DEFAULT NULL,
  `tdState` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`tdid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transportationdetails` */

/*Table structure for table `truck` */

DROP TABLE IF EXISTS `truck`;

CREATE TABLE `truck` (
  `truck_id` varchar(20) NOT NULL,
  `rid` varchar(36) NOT NULL,
  `plate_number` varchar(36) NOT NULL,
  `truck_type` varchar(36) NOT NULL,
  `truck_load` int(11) NOT NULL,
  `volumes` int(11) NOT NULL,
  `truckState` varchar(36) NOT NULL,
  `truckLength` double DEFAULT '0',
  `truckImage` varchar(36) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`truck_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `truck` */

insert  into `truck`(`truck_id`,`rid`,`plate_number`,`truck_type`,`truck_load`,`volumes`,`truckState`,`truckLength`,`truckImage`,`datetime`) values ('201800001','仓库1','鄂A000001','卡车',20,18,'出车',5632,'/transport/img/car01.jpg','2014-04-12 00:00:00'),('201800002','仓库1','鄂A000002','卡车',30,20,'出车',522,'/transport/img/car02.jpg','2014-04-12 00:00:00'),('201800003','仓库1','鄂A000003','卡车',40,18,'出车',4532,'/transport/img/car03.jpg','2016-04-25 00:00:00'),('201800004','仓库1','鄂A000004','货车',60,19,'空闲',6532,'/transport/img/car01.jpg','2014-04-12 00:00:00'),('201800005','仓库1','鄂A000005','货车',80,14,'空闲',4623,'/transport/img/car01.jpg','2016-04-12 00:00:00'),('201800006','仓库1','鄂A000006','货车',50,60,'空闲',15987,'/transport/img/car02.jpg','2016-04-12 00:00:00'),('201800007','仓库1','鄂A000007','平板车',40,21,'空闲',2134,'/transport/img/car01.jpg','2014-04-12 00:00:00'),('201800008','仓库1','鄂A000008','平板车',40,24,'空闲',8446,'/transport/img/car03.jpg','2014-10-12 00:00:00'),('201800009','仓库1','鄂A000009','平板车',60,30,'空闲',12456,'/transport/img/car04.jpg','2014-11-06 00:00:00'),('201800010','仓库1','鄂A000010','集装箱车',40,18,'空闲',46852,'/transport/img/car05.jpg','2014-06-12 00:00:00'),('201800011','仓库1','鄂A000011','集装箱车',50,18,'空闲',56465,'/transport/img/car06.jpg','2014-09-03 00:00:00'),('201800012','仓库1','鄂A000012','集装箱车',60,18,'空闲',12543,'/transport/img/car07.jpg','2013-02-12 00:00:00'),('201800013','仓库1','鄂A000013','面包车',10,8,'空闲',7851,'/transport/img/car06.jpg','2016-04-14 00:00:00'),('201800014','仓库1','鄂A000014','面包车',10,8,'维修',4622,'/transport/img/car02.jpg','2018-04-12 00:00:00'),('201800015','仓库1','鄂A000015','面包车',10,8,'空闲',532,'/transport/img/car04.jpg','2017-05-12 00:00:00'),('201800063','1','123','货车',20,20,'空闲',0,'/transport/img/a5.png','2018-10-15 00:00:00');

/*Table structure for table `truck_line` */

DROP TABLE IF EXISTS `truck_line`;

CREATE TABLE `truck_line` (
  `line_id` varchar(36) NOT NULL,
  `Schedule_details_id` varchar(36) NOT NULL,
  `mileage` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `freight` int(11) NOT NULL,
  `truck_line_DelTag` int(11) DEFAULT '0',
  `content` varchar(50) NOT NULL,
  `truck_Starting` varchar(200) NOT NULL,
  `truck_Downtown` varchar(200) NOT NULL,
  `truck_begin_time` date DEFAULT NULL,
  `truck_end_time` date DEFAULT NULL,
  PRIMARY KEY (`line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `truck_line` */

/*Table structure for table `webnodes` */

DROP TABLE IF EXISTS `webnodes`;

CREATE TABLE `webnodes` (
  `webNodes_id` int(11) NOT NULL AUTO_INCREMENT,
  `webNodes_name` varchar(20) DEFAULT NULL,
  `webNodes_tel` varchar(20) DEFAULT NULL,
  `webNodes_manager` varchar(20) DEFAULT NULL,
  `webNodes_phone` varchar(20) DEFAULT NULL,
  `webNodes_address` varchar(100) DEFAULT NULL,
  `webNodes_x` varchar(20) DEFAULT NULL,
  `webNodes_y` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`webNodes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `webnodes` */

insert  into `webnodes`(`webNodes_id`,`webNodes_name`,`webNodes_tel`,`webNodes_manager`,`webNodes_phone`,`webNodes_address`,`webNodes_x`,`webNodes_y`) values (3,'江滩网点','027-88888888','赵七','12345678911','湖北省武汉市江岸区沿江大道254号','114.322036','30.613456'),(4,'徐东网点','027-866666666','赵六','12345678922','湖北省武汉市武昌区徐东大街5号','114.352147','30.594853'),(5,'汉正街网点','027-7777777777','赵八','12345678933','湖北省武汉市硚口区中山大道380-1号','114.282295','30.577443'),(6,'理工大网点','027-7777777778','赵十八','12345678933','湖北省武汉市武昌区交通一路','114.363143','30.61313');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
