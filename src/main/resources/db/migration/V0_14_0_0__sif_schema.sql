SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

-- -----------------------------------------------------

-- Table `SIF3_SESSION`

-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_SESSION` ;

CREATE  TABLE IF NOT EXISTS `SIF3_SESSION` (
  `SESSION_ID` INT NOT NULL AUTO_INCREMENT ,
  `CONSUMER_NAME` VARCHAR(100) NULL ,
  `SOLUTION_ID` VARCHAR(100) NULL ,
  `APPLICATION_KEY` VARCHAR(100) NOT NULL ,
  `USER_TOKEN` VARCHAR(200) NULL ,
  `INSTANCE_ID` VARCHAR(200) NULL ,
  `PASSWORD` VARCHAR(100) NULL ,
  `SESSION_TOKEN` VARCHAR(200) NULL ,
  `ENVIRONMENT_ID` VARCHAR(36) NULL ,
  `FINGERPRINT` VARCHAR(255) NULL ,
  `SECURITY_TOKEN` VARCHAR(500) NULL,
  `SECURITY_TOKEN_EXPIRY` DATETIME NULL,
  `ADAPTER_TYPE` VARCHAR(20) NULL COMMENT 'CONSUMER, PROVIDER, ENVIRONMENT_PROVIDER' ,
  `ENVIRONMENT_XML` TEXT NULL ,
  `QUEUE_STRATEGY` VARCHAR(20) NULL ,
  `CREATED` DATETIME NULL ,
  `LAST_ACCESSED` DATETIME NULL ,
  PRIMARY KEY (`SESSION_ID`) )
;

CREATE INDEX `SOL_APP_KEY_IDX` ON `SIF3_SESSION` (`SOLUTION_ID` ASC, `APPLICATION_KEY` ASC, `ADAPTER_TYPE` ASC) ;

CREATE INDEX `SESSION_TK_IDX` ON `SIF3_SESSION` (`SESSION_TOKEN` ASC) ;

CREATE INDEX `SEC_TOKEN_IDX` ON `SIF3_SESSION` (`SECURITY_TOKEN` ASC, `ADAPTER_TYPE` ASC) ;

CREATE INDEX `ENV_ID_IDX` ON `SIF3_SESSION` (`ENVIRONMENT_ID` ASC, `ADAPTER_TYPE` ASC) ;

CREATE INDEX `SOL_APP_USR_INST_IDX` ON `SIF3_SESSION` (`SOLUTION_ID` ASC, `APPLICATION_KEY` ASC, `USER_TOKEN` ASC, `INSTANCE_ID` ASC, `ADAPTER_TYPE` ASC) ;

-- The following is done this way to get around a warning/error in mysql where an index on a column is limited to 767 chars.
ALTER TABLE `SIF3_SESSION` MODIFY COLUMN `SECURITY_TOKEN` VARCHAR(1000);

-- -----------------------------------------------------
-- Table `SIF3_QUEUE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_QUEUE` ;

CREATE  TABLE IF NOT EXISTS `SIF3_QUEUE` (
  `QUEUE_ID` VARCHAR(36) NOT NULL ,
  `NAME` VARCHAR(100) NOT NULL ,
  `QUEUE_TYPE` VARCHAR(10) NOT NULL COMMENT 'LONG, IMMEDIATE, WAKE_UP' ,
  `ENVIRONMENT_ID` VARCHAR(36) NOT NULL ,
  `ADAPTER_TYPE` VARCHAR(20) NOT NULL COMMENT 'CONSUMER, PROVIDER, ENVIRONMENT_PROVIDER' ,
  `ZONE_ID` VARCHAR(256) NULL ,
  `CONTEXT_ID` VARCHAR(256) NULL ,
  `SERVICE_NAME` VARCHAR(256) NULL ,
  `SERVICE_TYPE` VARCHAR(20) NULL ,
  `MESSAGE_URI` VARCHAR(256) NOT NULL ,
  `WAKUP_URI` VARCHAR(256) NULL ,
  `LONGPOLLING_TIMEOUT` INT NULL COMMENT 'Vakue in seconds\n' ,
  `WAIT_TIME` INT NULL ,
  `MAX_CONSUMERS` INT NULL ,
  `MSG_COUNT` INT NULL ,
  `CREATED` DATETIME NULL ,
  `LAST_ACCESSED` DATETIME NULL ,
  `LAST_MODIFIED` DATETIME NULL ,
  PRIMARY KEY (`QUEUE_ID`) )
;

CREATE INDEX `IDX_QUEUE_ENVID` ON `SIF3_QUEUE` (`ENVIRONMENT_ID` ASC, `ADAPTER_TYPE` ASC) ;

CREATE INDEX `IDX_QUEUE_ZONE` ON `SIF3_QUEUE` (`ENVIRONMENT_ID` ASC, `ADAPTER_TYPE` ASC, `ZONE_ID` ASC) ;

CREATE INDEX `IDX_QUEUE_ZONE_CTX_SVC` ON `SIF3_QUEUE` (`ENVIRONMENT_ID` ASC, `ADAPTER_TYPE` ASC, `ZONE_ID` ASC, `CONTEXT_ID` ASC, `SERVICE_NAME` ASC, `SERVICE_TYPE` ASC) ;

-- -----------------------------------------------------
-- Table `SIF3_SUBSCRIPTION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_SUBSCRIPTION` ;

CREATE  TABLE IF NOT EXISTS `SIF3_SUBSCRIPTION` (
  `SUBSCRIPTION_ID` VARCHAR(36) NOT NULL ,
  `QUEUE_ID` VARCHAR(36) NOT NULL ,
  `ADAPTER_TYPE` VARCHAR(20) NOT NULL COMMENT 'CONSUMER, PROVIDER, ENVIRONMENT_PROVIDER' ,
  `ZONE_ID` VARCHAR(256) NULL ,
  `CONTEXT_ID` VARCHAR(256) NULL ,
  `SERVICE_NAME` VARCHAR(256) NOT NULL ,
  `SERVICE_TYPE` VARCHAR(20) NOT NULL ,
  `CREATED` DATETIME NULL ,
  `LAST_ACCESSED` DATETIME NULL ,
  PRIMARY KEY (`SUBSCRIPTION_ID`) ,
  CONSTRAINT `FK_SUBSCRIPTION_QUEUE`
    FOREIGN KEY (`QUEUE_ID` )
    REFERENCES `SIF3_QUEUE` (`QUEUE_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX `IDX_SUBSCR_QUEUEID` ON `SIF3_SUBSCRIPTION` (`QUEUE_ID` ASC, `ADAPTER_TYPE` ASC) ;

CREATE INDEX `IDX_SUBSCR_SERVICE` ON `SIF3_SUBSCRIPTION` (`SERVICE_NAME` ASC, `SERVICE_TYPE` ASC) ;

CREATE INDEX `FK_SUBSCR_QUEUE` ON `SIF3_SUBSCRIPTION` (`QUEUE_ID` ASC) ;

CREATE INDEX `IDK_SUBSCR_ZONE_CTX_SVC` ON `SIF3_SUBSCRIPTION` (`ZONE_ID` ASC, `CONTEXT_ID` ASC, `SERVICE_NAME` ASC, `SERVICE_TYPE` ASC) ;

-- -----------------------------------------------------
-- Table `SIF3_ENV_TEMPLATE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_ENV_TEMPLATE` ;

CREATE  TABLE IF NOT EXISTS `SIF3_ENV_TEMPLATE` (
  `ENV_TEMPLATE_ID` VARCHAR(50) NOT NULL ,
  `TEMPLATE_FILE_NAME` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`ENV_TEMPLATE_ID`) )
;


-- -----------------------------------------------------
-- Table `SIF3_APP_TEMPLATE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_APP_TEMPLATE` ;

CREATE  TABLE IF NOT EXISTS `SIF3_APP_TEMPLATE` (
  `APP_TEMPLATE_ID` INT NOT NULL ,
  `SOLUTION_ID` VARCHAR(100) NULL ,
  `APPLICATION_KEY` VARCHAR(100) NULL ,
  `PASSWORD` VARCHAR(100) NULL ,
  `USER_TOKEN` VARCHAR(200) NULL ,
  `INSTANCE_ID` VARCHAR(200) NULL ,
  `AUTH_METHOD` VARCHAR(20) NULL ,
  `ENV_TEMPLATE_ID` VARCHAR(50) NULL ,
  PRIMARY KEY (`APP_TEMPLATE_ID`) ,
  CONSTRAINT `FK_APP_TMPLT_TO_ENV_TMPLT`
    FOREIGN KEY (`ENV_TEMPLATE_ID` )
    REFERENCES `SIF3_ENV_TEMPLATE` (`ENV_TEMPLATE_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX `SOL_APPKEY_IDX` ON `SIF3_APP_TEMPLATE` (`SOLUTION_ID` ASC, `APPLICATION_KEY` ASC) ;

CREATE INDEX `APPKEY_IDX` ON `SIF3_APP_TEMPLATE` (`APPLICATION_KEY` ASC) ;

CREATE INDEX `SOL_APPKEY_USERTK_IDX` ON `SIF3_APP_TEMPLATE` (`SOLUTION_ID` ASC, `APPLICATION_KEY` ASC, `USER_TOKEN` ASC) ;

CREATE INDEX `APPKEY_USERTK_IDX` ON `SIF3_APP_TEMPLATE` (`APPLICATION_KEY` ASC, `USER_TOKEN` ASC) ;

CREATE INDEX `IDX_APP_TMPLT_TO_ENV_TMPLT` ON `SIF3_APP_TEMPLATE` (`ENV_TEMPLATE_ID` ASC) ;

-- -----------------------------------------------------
-- Table `SIF3_EXT_SECURITY_SERVICE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_EXT_SECURITY_SERVICE` ;

CREATE TABLE IF NOT EXISTS `SIF3_EXT_SECURITY_SERVICE` (
  `EXT_SECURITY_SERVICE_ID` INT NOT NULL,
  `AUTH_METHOD` VARCHAR(20) NULL,
  `ADAPTER_TYPE` VARCHAR(20) NULL,
  `HTTP_HEADER_VALUE` VARCHAR(20) NULL,
  `XML_VALUE` VARCHAR(20) NULL,
  `TWO_PHASE` INT(1) NOT NULL DEFAULT 0,
  `IMPLEMENTATION_CLASS` VARCHAR(256) NULL,
  PRIMARY KEY (`EXT_SECURITY_SERVICE_ID`))
;

CREATE UNIQUE INDEX `UQ_AUTH_METH_ADAP` ON `SIF3_EXT_SECURITY_SERVICE` (`AUTH_METHOD` ASC, `ADAPTER_TYPE` ASC);

-- -----------------------------------------------------
-- Table `SIF3_SEC_SERVICE_PARAM`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_SEC_SERVICE_PARAM` ;

CREATE TABLE IF NOT EXISTS `SIF3_SEC_SERVICE_PARAM` (
  `SEC_SERVICE_PARAM_ID` INT NOT NULL,
  `EXT_SECURITY_SERVICE_ID` INT NOT NULL,
  `PARAM_NAME` VARCHAR(45) NULL,
  `PARAM_VALUE` VARCHAR(256) NULL,
  PRIMARY KEY (`SEC_SERVICE_PARAM_ID`),
  CONSTRAINT `FK_SEC_SVC_PARAM_TO_SEC_SVC`
    FOREIGN KEY (`EXT_SECURITY_SERVICE_ID`)
    REFERENCES `SIF3_EXT_SECURITY_SERVICE` (`EXT_SECURITY_SERVICE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

CREATE INDEX `IDX_EXT_SEC_SVC` ON `SIF3_SEC_SERVICE_PARAM` (`EXT_SECURITY_SERVICE_ID` ASC);

-- -----------------------------------------------------
-- Table SIF3_JOB_TEMPLATE
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_JOB_TEMPLATE`;

CREATE TABLE IF NOT EXISTS `SIF3_JOB_TEMPLATE` (
  `JOB_TEMPLATE_ID` INT NOT NULL,
  `JOB_URL_NAME` VARCHAR(100) NOT NULL,
  `ADAPTER_TYPE` VARCHAR(20) NULL,
  `TEMPLATE_FILE_NAME` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`JOB_TEMPLATE_ID`))
;

CREATE UNIQUE INDEX `UQ_JOB_URL_NAME` ON `SIF3_JOB_TEMPLATE` (`JOB_URL_NAME` ASC, `ADAPTER_TYPE` ASC);


-- -----------------------------------------------------
-- Table `SIF3_JOB`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_JOB` ;

CREATE TABLE IF NOT EXISTS `SIF3_JOB` (
  `JOB_ID` INT NOT NULL AUTO_INCREMENT,
  `JOB_REFID` VARCHAR(36) NOT NULL,
  `SERVICE_NAME` VARCHAR(256) NULL,
  `CURRENT_JOB_STATE` VARCHAR(30) NULL,
  `ENVIRONMENT_REFID` VARCHAR(36) NULL,
  `ADAPTER_TYPE` VARCHAR(20) NOT NULL,
  `FINGERPRINT` VARCHAR(256) NULL,
  `ZONE_ID` VARCHAR(256) NULL,
  `CONTEXT_ID` VARCHAR(255) NULL,
  `CREATED` DATETIME NOT NULL,
  `TIMEOUT_PERIOD` VARCHAR(30) NULL,
  `LAST_MODIFIED` DATETIME NULL,
  `EXPIRE_DATETIME` DATETIME NULL,
  `JOB_XML` TEXT NULL,
  PRIMARY KEY (`JOB_ID`))
;

CREATE INDEX `JOB_JOBREFID_ADPTYPE_IDX` ON `SIF3_JOB` (`JOB_REFID` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOB_FINGERPRT_ADPTYPE_IDX` ON `SIF3_JOB` (`FINGERPRINT` ASC, `SERVICE_NAME` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOB_ENVREFID_ADPTYPE_IDX` ON `SIF3_JOB` (`FINGERPRINT` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOB_ZONEID_ADPTYPE_IDX` ON `SIF3_JOB` (`ZONE_ID` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOB_REFID_ENVREFID_ADPTYPE_IDX` ON `SIF3_JOB` (`JOB_REFID` ASC, `ENVIRONMENT_REFID` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOB_SVCNNAME_ADPTYPE_IDX` ON `SIF3_JOB` (`SERVICE_NAME` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOB_EXPIRE_IDX` ON `SIF3_JOB` (`EXPIRE_DATETIME` ASC);

-- -----------------------------------------------------
-- Table `SIF3_JOB_EVENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SIF3_JOB_EVENT` ;

CREATE TABLE IF NOT EXISTS `SIF3_JOB_EVENT` (
  `JOB_EVENT_ID` INT NOT NULL AUTO_INCREMENT,
  `JOB_EVENT_DATETIME` DATETIME NOT NULL,
  `JOB_REFID` VARCHAR(36) NOT NULL,
  `SERVICE_NAME` VARCHAR(256) NULL,
  `ENVIRONMENT_REFID` VARCHAR(36) NULL,
  `ADAPTER_TYPE` VARCHAR(20) NOT NULL,
  `FINGERPRINT` VARCHAR(256) NULL,
  `ZONE_ID` VARCHAR(256) NULL,
  `CONTEXT_ID` VARCHAR(256) NULL,
  `EVENT_TYPE` CHAR(1) NOT NULL,
  `FULL_UPDATE` TINYINT(1) NOT NULL DEFAULT 1,
  `TO_FINGERPRINT_ONLY` TINYINT(1) NOT NULL DEFAULT 1,
  `CONSUMER_REQUESTED` TINYINT(1) NOT NULL DEFAULT 1,
  `EVENT_PUBLISHED` TINYINT(1) NOT NULL DEFAULT 0,
  `PUBLISHED_DATETIME` DATETIME NULL,
  `JOB_XML` TEXT NULL,
  PRIMARY KEY (`JOB_EVENT_ID`))
;

CREATE INDEX `JOBEVT_DT_ADPTY_IDX` ON `SIF3_JOB_EVENT` (`JOB_EVENT_DATETIME` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOBEVT_JOBREFID_ADPTY_IDX` ON `SIF3_JOB_EVENT` (`JOB_REFID` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOBEVT_FINGERPRT_ADPTY_IDX` ON `SIF3_JOB_EVENT` (`FINGERPRINT` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOBEVT_ENVREFID_ADPTY_IDX` ON `SIF3_JOB_EVENT` (`ENVIRONMENT_REFID` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOBEVT_ZONEID_ADPTY_IDX` ON `SIF3_JOB_EVENT` (`ZONE_ID` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOBEVT_DT_EVTY_ADPTY_PUBL_IDX` ON `SIF3_JOB_EVENT` (`JOB_EVENT_DATETIME` ASC, `ADAPTER_TYPE` ASC, `EVENT_TYPE` ASC, `EVENT_PUBLISHED` ASC);

CREATE INDEX `JOBEVT_DT__ADPTY_PUBL_IDX` ON `SIF3_JOB_EVENT` (`JOB_EVENT_DATETIME` ASC, `ADAPTER_TYPE` ASC, `EVENT_PUBLISHED` ASC);

CREATE INDEX `JOBEVT_JOBID_ENVID_ADPTY_IDX` ON `SIF3_JOB_EVENT` (`JOB_REFID` ASC, `ENVIRONMENT_REFID` ASC, `ADAPTER_TYPE` ASC);

CREATE INDEX `JOBEVT_SVCNAME_ADPTYPE_IDX` ON `SIF3_JOB_EVENT` (`SERVICE_NAME` ASC, `ADAPTER_TYPE` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
