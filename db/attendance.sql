ALTER TABLE `CalendarSummary` 
ADD COLUMN `FirstInstructionDate` VARCHAR(200) NULL AFTER `EndDate`,
ADD COLUMN `LastInstructionDate` VARCHAR(200) NULL AFTER `FirstInstructionDate`,
ADD COLUMN `InstructionalMinutes` VARCHAR(200) NULL AFTER `LastInstructionDate`,
ADD COLUMN `MinutesPerDay` VARCHAR(200) NULL AFTER `InstructionalMinutes`;

CREATE TABLE `CalendarSummary_YearLevel` (
  `CalendarySummary_RefId` VARCHAR(200) NULL,
  `YearLevel` VARCHAR(200) NULL);

CREATE TABLE `SessionInfo` (
    `RefId` VARCHAR(200) NULL,
    `SchoolInfo_RefId` VARCHAR(200) NULL,
    `TimeTableCell_RefId` VARCHAR(200) NULL,
    `SchoolYear` VARCHAR(200) NULL,
    `LocalId` VARCHAR(200) NULL,
    `TimeTableSubjectLocalId` VARCHAR(200) NULL,
    `TeachingGroupLocalId` VARCHAR(200) NULL,
    `SchoolLocalId` VARCHAR(200) NULL,
    `StaffPersonalLocalId` VARCHAR(200) NULL,
    `RoomNumber` VARCHAR(200) NULL,
    `DayId` VARCHAR(200) NULL,
    `PeriodId` VARCHAR(200) NULL,
    `SessionDate` VARCHAR(200) NULL,
    `StartTime` VARCHAR(200) NULL,
    `FinishTime` VARCHAR(200) NULL,
    `RollMarked` VARCHAR(200) NULL,
    UNIQUE KEY `RefId` (`RefId`)
);

CREATE TABLE `StudentPeriodAttendance` (
    `RefId` VARCHAR(200) NULL,
    `StudentPersonal_RefId` VARCHAR(200) NULL,
    `SchoolInfo_RefId` VARCHAR(200) NULL,
    `CalendarDate` VARCHAR(200) NULL,
    `SessionInfo_RefId` VARCHAR(200) NULL,
    `TimetablePeriod` VARCHAR(200) NULL,
    `TimeIn` VARCHAR(200) NULL,
    `TimeOut` VARCHAR(200) NULL,
    `AttendanceCode` VARCHAR(200) NULL,
    `AttendanceStatus` VARCHAR(200) NULL,
    `SchoolYear` VARCHAR(200) NULL,
    `CreationUser_Type` VARCHAR(200) NULL,
    `AuditInfo_CreationUser_UserId` VARCHAR(200) NULL,
    `AuditInfo_CreationDateTime` VARCHAR(200) NULL,
    `AttendanceComment` VARCHAR(200) NULL,
    UNIQUE KEY `RefId` (`RefId`)
);