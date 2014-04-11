drop database CDCollection;
create database CDCollection;
use CDCollection;

create table `Albums` (
	`albumKey` int(11) unsigned NOT NULL,
	`albumTitle` varbinary(255) NOT NULL,
	`albumYear` smallint(4) unsigned NOT NULL,
	PRIMARY KEY (`albumKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table `Songs` (
	`songKey` int(11) unsigned NOT NULL,
	`songTitle` varbinary(255) NOT NULL,
	PRIMARY KEY (`songKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table `SongsOnAlbums` (
	`albumKey` int(11) unsigned NOT NULL,
	`songKey` int(11) unsigned NOT NULL,
	`track` smallInt(3) unsigned NOT NULL,
	`timeInSeconds` mediumint(5) unsigned NOT NULL,
	PRIMARY KEY (`albumKey`, `songKey`, `track`),
	UNIQUE `second` (`songKey`, `track`),
	KEY `time` (`timeInSeconds`),
	CONSTRAINT `SOA_1` FOREIGN KEY (`songKey`) REFERENCES `Songs` (`songKey`),
	CONSTRAINT `SOA_2` FOREIGN KEY (`albumKey`) REFERENCES `Albums` (`albumKey`)
) ENGINE=InnoDB DEFAULT CHARSET= utf8 COLLATE=utf8_unicode_ci;

create table `Artists` (
	`artistKey` int(11) unsigned NOT NULL,
	`artistName` varbinary(255) NOT NULL,
	PRIMARY KEY (`artistKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table `SongsWrittenByArtists` (
	`artistKey` int(11) unsigned NOT NULL,
	`songKey` int(11) unsigned NOT NULL,
	PRIMARY KEY (`artistKey`, `songKey`),
	KEY `songs` (`songKey`),
	CONSTRAINT `SW_1` FOREIGN KEY (`artistKey`) REFERENCES `Artists` (`artistKey`),
	CONSTRAINT `SW_2` FOREIGN KEY (`songKey`) REFERENCES `Songs` (`songKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table `SongsPerformedByArtists` (
	`albumKey` int(11) unsigned NOT NULL,
	`songKey` int(11) unsigned NOT NULL,
	`track` smallint(3) unsigned NOT NULL,
	`artistKey` int(11) unsigned NOT NULL,
	PRIMARY KEY (`albumKey`, `songKey`, `track`, `artistKey`),
        KEY `second` (`songKey`, `track`, `artistKey`),
	KEY `third` (`artistKey`),
	CONSTRAINT `SPBA_1` FOREIGN KEY (`artistKey`) REFERENCES `Artists` (`artistKey`),
	CONSTRAINT `SPBA_2` FOREIGN KEY (`albumKey`, `songKey`, `track`) REFERENCES `SongsOnAlbums` (`albumKey`, `songKey`, `track`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
