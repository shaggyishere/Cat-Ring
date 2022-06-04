-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.4.24-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dump della struttura di tabella catering.events
DROP TABLE IF EXISTS `events`;
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `date_start` date DEFAULT NULL,
  `date_end` date DEFAULT NULL,
  `expected_participants` int(11) DEFAULT NULL,
  `organizer_id` int(11) NOT NULL,
  `chef_id` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.events: ~3 rows (circa)
DELETE FROM `events`;
INSERT INTO `events` (`id`, `name`, `date_start`, `date_end`, `expected_participants`, `organizer_id`, `chef_id`) VALUES
	(1, 'Convegno Agile Community', '2020-09-25', '2020-09-25', 100, 2, 0),
	(2, 'Compleanno di Manuela', '2020-08-13', '2020-08-13', 25, 2, 2),
	(3, 'Fiera del Sedano Rapa', '2020-10-02', '2020-10-04', 400, 1, 0);

-- Dump della struttura di tabella catering.menufeatures
DROP TABLE IF EXISTS `menufeatures`;
CREATE TABLE IF NOT EXISTS `menufeatures` (
  `menu_id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL DEFAULT '',
  `value` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.menufeatures: ~20 rows (circa)
DELETE FROM `menufeatures`;
INSERT INTO `menufeatures` (`menu_id`, `name`, `value`) VALUES
	(80, 'Richiede cuoco', 0),
	(80, 'Buffet', 0),
	(80, 'Richiede cucina', 0),
	(80, 'Finger food', 0),
	(80, 'Piatti caldi', 0),
	(82, 'Richiede cuoco', 0),
	(82, 'Buffet', 0),
	(82, 'Richiede cucina', 0),
	(82, 'Finger food', 0),
	(82, 'Piatti caldi', 0),
	(86, 'Richiede cuoco', 0),
	(86, 'Buffet', 0),
	(86, 'Richiede cucina', 0),
	(86, 'Finger food', 0),
	(86, 'Piatti caldi', 0),
	(89, 'Richiede cuoco', 1),
	(89, 'Buffet', 0),
	(89, 'Richiede cucina', 1),
	(89, 'Finger food', 1),
	(89, 'Piatti caldi', 1);

-- Dump della struttura di tabella catering.menuitems
DROP TABLE IF EXISTS `menuitems`;
CREATE TABLE IF NOT EXISTS `menuitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `section_id` int(11) DEFAULT NULL,
  `description` tinytext DEFAULT NULL,
  `recipe_id` int(11) NOT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.menuitems: ~29 rows (circa)
DELETE FROM `menuitems`;
INSERT INTO `menuitems` (`id`, `menu_id`, `section_id`, `description`, `recipe_id`, `position`) VALUES
	(96, 80, 0, 'Croissant vuoti', 9, 0),
	(97, 80, 0, 'Croissant alla marmellata', 9, 1),
	(98, 80, 0, 'Pane al cioccolato mignon', 10, 2),
	(99, 80, 0, 'Panini al latte con prosciutto crudo', 12, 4),
	(100, 80, 0, 'Panini al latte con prosciutto cotto', 12, 5),
	(101, 80, 0, 'Panini al latte con formaggio spalmabile alle erbe', 12, 6),
	(102, 80, 0, 'Girelle all\'uvetta mignon', 11, 3),
	(103, 82, 0, 'Biscotti', 13, 1),
	(104, 82, 0, 'Lingue di gatto', 14, 2),
	(105, 82, 0, 'Bigné alla crema', 15, 3),
	(106, 82, 0, 'Bigné al caffè', 15, 4),
	(107, 82, 0, 'Pizzette', 16, 5),
	(108, 82, 0, 'Croissant al prosciutto crudo mignon', 9, 6),
	(109, 82, 0, 'Tramezzini tonno e carciofini mignon', 17, 7),
	(112, 86, 41, 'Vitello tonnato', 1, 0),
	(113, 86, 41, 'Carpaccio di spada', 2, 1),
	(114, 86, 41, 'Alici marinate', 3, 2),
	(115, 86, 42, 'Penne alla messinese', 5, 0),
	(116, 86, 42, 'Risotto alla zucca', 20, 1),
	(117, 86, 43, 'Salmone al forno', 8, 0),
	(118, 86, 44, 'Sorbetto al limone', 18, 0),
	(119, 86, 44, 'Torta Saint Honoré', 19, 1),
	(121, 89, 47, 'Vitello tonnato', 1, 0),
	(122, 89, 47, 'Carpaccio di spada', 2, 1),
	(123, 89, 47, 'Alici marinate', 3, 2),
	(124, 89, 49, 'Hamburger con bacon e cipolla caramellata', 7, 0),
	(125, 89, 49, 'Salmone al forno', 8, 1),
	(126, 89, 0, 'Insalata di riso', 4, 0),
	(127, 89, 0, 'Penne al sugo di baccalà', 5, 1);

-- Dump della struttura di tabella catering.menus
DROP TABLE IF EXISTS `menus`;
CREATE TABLE IF NOT EXISTS `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` tinytext DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `published` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.menus: ~5 rows (circa)
DELETE FROM `menus`;
INSERT INTO `menus` (`id`, `title`, `owner_id`, `published`) VALUES
	(80, 'Coffee break mattutino', 2, 1),
	(82, 'Coffee break pomeridiano', 2, 1),
	(86, 'Cena di compleanno pesce', 3, 1),
	(89, 'Cena coi parenti', 2, 1),
	(90, 'Menu Pinco Pallino', 2, 0);

-- Dump della struttura di tabella catering.menusections
DROP TABLE IF EXISTS `menusections`;
CREATE TABLE IF NOT EXISTS `menusections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `name` tinytext DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.menusections: ~8 rows (circa)
DELETE FROM `menusections`;
INSERT INTO `menusections` (`id`, `menu_id`, `name`, `position`) VALUES
	(41, 86, 'Antipasti', 0),
	(42, 86, 'Primi', 1),
	(43, 86, 'Secondi', 2),
	(44, 86, 'Dessert', 3),
	(45, 87, 'Antipasti', 0),
	(47, 89, 'Antipasti', 0),
	(48, 89, 'Primi', 1),
	(49, 89, 'Secondi', 2);

-- Dump della struttura di tabella catering.recipes
DROP TABLE IF EXISTS `recipes`;
CREATE TABLE IF NOT EXISTS `recipes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.recipes: ~20 rows (circa)
DELETE FROM `recipes`;
INSERT INTO `recipes` (`id`, `name`) VALUES
	(1, 'Vitello tonnato'),
	(2, 'Carpaccio di spada'),
	(3, 'Alici marinate'),
	(4, 'Insalata di riso'),
	(5, 'Penne al sugo di baccalà'),
	(6, 'Pappa al pomodoro'),
	(7, 'Hamburger con bacon e cipolla caramellata'),
	(8, 'Salmone al forno'),
	(9, 'Croissant'),
	(10, 'Pane al cioccolato'),
	(11, 'Girelle all\'uvetta'),
	(12, 'Panini al latte'),
	(13, 'Biscotti di pasta frolla'),
	(14, 'Lingue di gatto'),
	(15, 'Bigné farciti'),
	(16, 'Pizzette'),
	(17, 'Tramezzini'),
	(18, 'Sorbetto al limone'),
	(19, 'Torta Saint Honoré'),
	(20, 'Risotto alla zucca');

-- Dump della struttura di tabella catering.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` char(1) NOT NULL,
  `role` varchar(128) NOT NULL DEFAULT 'servizio',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.roles: ~4 rows (circa)
DELETE FROM `roles`;
INSERT INTO `roles` (`id`, `role`) VALUES
	('c', 'cuoco'),
	('h', 'chef'),
	('o', 'organizzatore'),
	('s', 'servizio');

-- Dump della struttura di tabella catering.services
DROP TABLE IF EXISTS `services`;
CREATE TABLE IF NOT EXISTS `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `proposed_menu_id` int(11) NOT NULL DEFAULT 0,
  `approved_menu_id` int(11) DEFAULT 0,
  `service_date` date DEFAULT NULL,
  `time_start` time DEFAULT NULL,
  `time_end` time DEFAULT NULL,
  `expected_participants` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.services: ~8 rows (circa)
DELETE FROM `services`;
INSERT INTO `services` (`id`, `event_id`, `name`, `proposed_menu_id`, `approved_menu_id`, `service_date`, `time_start`, `time_end`, `expected_participants`) VALUES
	(1, 2, 'Cena', 86, 86, '2020-08-13', '20:00:00', '23:30:00', 25),
	(2, 1, 'Coffee break mattino', 0, 80, '2020-09-25', '10:30:00', '11:30:00', 100),
	(3, 1, 'Colazione di lavoro', 0, 0, '2020-09-25', '13:00:00', '14:00:00', 80),
	(4, 1, 'Coffee break pomeriggio', 0, 82, '2020-09-25', '16:00:00', '16:30:00', 100),
	(5, 1, 'Cena sociale', 0, 0, '2020-09-25', '20:00:00', '22:30:00', 40),
	(6, 3, 'Pranzo giorno 1', 0, 0, '2020-10-02', '12:00:00', '15:00:00', 200),
	(7, 3, 'Pranzo giorno 2', 0, 0, '2020-10-03', '12:00:00', '15:00:00', 300),
	(8, 3, 'Pranzo giorno 3', 0, 0, '2020-10-04', '12:00:00', '15:00:00', 400);

-- Dump della struttura di tabella catering.userroles
DROP TABLE IF EXISTS `userroles`;
CREATE TABLE IF NOT EXISTS `userroles` (
  `user_id` int(11) NOT NULL,
  `role_id` char(1) NOT NULL DEFAULT 's'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.userroles: ~13 rows (circa)
DELETE FROM `userroles`;
INSERT INTO `userroles` (`user_id`, `role_id`) VALUES
	(1, 'o'),
	(2, 'o'),
	(2, 'h'),
	(3, 'h'),
	(4, 'h'),
	(4, 'c'),
	(5, 'c'),
	(6, 'c'),
	(7, 'c'),
	(8, 's'),
	(9, 's'),
	(10, 's'),
	(7, 's');

-- Dump della struttura di tabella catering.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dump dei dati della tabella catering.users: ~10 rows (circa)
DELETE FROM `users`;
INSERT INTO `users` (`id`, `username`) VALUES
	(1, 'Carlin'),
	(2, 'Lidia'),
	(3, 'Tony'),
	(4, 'Marinella'),
	(5, 'Guido'),
	(6, 'Antonietta'),
	(7, 'Paola'),
	(8, 'Silvia'),
	(9, 'Marco'),
	(10, 'Piergiorgio');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
