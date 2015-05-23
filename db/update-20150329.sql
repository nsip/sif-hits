ALTER TABLE `TimeTableSubject` 
  ADD COLUMN `ProposedMaxClassSize` VARCHAR(100) NULL AFTER `ProposedMinClassSize`;

ALTER TABLE `RoomInfo` 
  ADD COLUMN `LocalId` VARCHAR(200) NULL AFTER `SchoolInfo_RefId`;

ALTER TABLE `SchoolInfo` 
  ADD COLUMN `CampusParentSchoolId` VARCHAR(200) NULL AFTER `CampusCampusType`;

ALTER TABLE `StaffPersonal` 
	ADD COLUMN `PreferredFamilyName` VARCHAR(200) NULL AFTER `MiddleName`,
	ADD COLUMN `BirthDate` VARCHAR(200) NULL AFTER `Salutation`;

CREATE TABLE `StaffPersonal_OtherId` (
  `StaffPersonalRefId` VARCHAR(36) NOT NULL,
  `OtherId` VARCHAR(200) NOT NULL,
  `OtherIdType` VARCHAR(200) NULL);
  
ALTER TABLE `StudentPersonal` 
  ADD COLUMN `FullName` VARCHAR(400) NULL AFTER `MiddleName`,
  ADD COLUMN `PreferredFamilyName` VARCHAR(200) NULL AFTER `FullName`,
  ADD COLUMN `Religion` VARCHAR(4) NULL AFTER `Email`;  
  
CREATE TABLE `StudentPersonal_OtherId` (
  `StudentPersonalRefId` VARCHAR(36) NOT NULL,
  `OtherId` VARCHAR(200) NOT NULL,
  `OtherIdType` VARCHAR(200) NULL);
  
ALTER TABLE `StudentSchoolEnrollment` 
  ADD COLUMN `ExitDate` VARCHAR(25) NULL AFTER `EntryDate`;