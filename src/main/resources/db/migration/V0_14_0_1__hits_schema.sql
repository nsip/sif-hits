CREATE TABLE `APPKEY_DB_URL_MAPPER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `applicationKey` varchar(100) DEFAULT NULL,
  `databaseUrl` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `PSISequence` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `XMLAudit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `requestTime` datetime DEFAULT NULL,
  `responseTime` datetime DEFAULT NULL,
  `clientIp` varchar(45) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `solutionId` varchar(255) DEFAULT NULL,
  `appKey` varchar(255) DEFAULT NULL,
  `userToken` varchar(255) DEFAULT NULL,
  `context` varchar(255) DEFAULT NULL,
  `instanceId` varchar(45) DEFAULT NULL,
  `zone` varchar(255) DEFAULT NULL,
  `environmentToken` varchar(255) DEFAULT NULL,
  `sessionToken` varchar(255) DEFAULT NULL,
  `method` varchar(45) DEFAULT NULL,
  `queryParameters` varchar(2000) DEFAULT NULL,
  `requestHeaders` varchar(2000) DEFAULT NULL,
  `request` text,
  `httpStatus` int(11) DEFAULT NULL,
  `responseHeaders` varchar(2000) DEFAULT NULL,
  `response` text,
  `requestMediaType` varchar(255) DEFAULT NULL,
  `responseMediaType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

