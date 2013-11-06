CREATE TABLE IF NOT EXISTS imp (
  `BidId`            VARCHAR(50),
  `Timestamp`        BIGINT,
  `LogType`          SMALLINT,
  `UserId`           VARCHAR(50),
  `UserAgent`        VARCHAR(200),
  `IP`               VARCHAR(15),
  `Region`           BIGINT,
  `City`             BIGINT,
  `AdExchange`       SMALLINT,
  `Domain`           VARCHAR(50),
  `URL`              VARCHAR(50),
  `AnonymousURL`    VARCHAR(50),
  `AdSlotId`         BIGINT,
  `AdSlotWidth`      VARCHAR(50),
  `AdSlotHeight`     VARCHAR(50),
  `AdSlotVisibility` INT,
  `AdSlotFormat`     SMALLINT,
  `AdSlotFloorPrice` INT,
  `CreativeId`       BIGINT,
  `BiddingPrice`     INT,
  `PayingPrice`      INT,
  `KeyPageURL`       VARCHAR(50),
  `AdvertiserID`     BIGINT,
  `UserTag`          VARCHAR(50),
  UNIQUE KEY `uid_user_slot` (`BidId`, `UserId`, `AdSlotId`),
  KEY `key_cid_aid` (`AdvertiserID`, `CreativeId`)
);
