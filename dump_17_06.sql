-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2022 at 06:40 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `catering`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

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

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `name`, `date_start`, `date_end`, `expected_participants`, `organizer_id`, `chef_id`) VALUES
(1, 'Convegno Agile Community', '2020-09-25', '2020-09-25', 100, 2, 0),
(2, 'Compleanno di Manuela', '2020-08-13', '2020-08-13', 25, 2, 2),
(3, 'Fiera del Sedano Rapa', '2020-10-02', '2020-10-04', 400, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `kitchensheets`
--

CREATE TABLE IF NOT EXISTS `kitchensheets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` tinytext CHARACTER SET utf8 DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `service_id` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kitchensheets`
--

INSERT INTO `kitchensheets` (`id`, `title`, `service_id`) VALUES
(2, 'foglio per caffe', 2),
(3, 'foglio per colazione', 3),
(54, 'Primo foglio di prova', 1);

-- --------------------------------------------------------

--
-- Table structure for table `kitchentasks`
--

CREATE TABLE IF NOT EXISTS `kitchentasks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timing` tinytext DEFAULT NULL,
  `quantity` tinytext DEFAULT NULL,
  `completed` tinyint(1) NOT NULL,
  `kitchensheet_id` int(11) NOT NULL,
  `cook_id` int(11) DEFAULT NULL,
  `turn_when` varchar(20) DEFAULT NULL,
  `procedures_id` int(11) NOT NULL,
  `position` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=439 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kitchentasks`
--

INSERT INTO `kitchentasks` (`id`, `timing`, `quantity`, `completed`, `kitchensheet_id`, `cook_id`, `turn_when`, `procedures_id`, `position`) VALUES
(19, NULL, NULL, 0, 2, NULL, NULL, 1, 0),
(20, NULL, NULL, 0, 2, NULL, NULL, 2, 1),
(21, NULL, NULL, 0, 3, NULL, NULL, 3, 0),
(34, NULL, NULL, 0, 29, NULL, NULL, 1, 0),
(35, NULL, NULL, 0, 29, NULL, NULL, 2, 1),
(36, NULL, NULL, 0, 29, NULL, NULL, 3, 2),
(147, NULL, NULL, 0, 44, NULL, NULL, 1, 7),
(148, NULL, NULL, 0, 44, NULL, NULL, 2, 1),
(149, NULL, NULL, 0, 44, NULL, NULL, 3, 2),
(150, NULL, NULL, 0, 44, NULL, NULL, 5, 3),
(151, NULL, NULL, 0, 44, NULL, NULL, 20, 4),
(152, NULL, NULL, 0, 44, NULL, NULL, 8, 5),
(153, NULL, NULL, 0, 44, NULL, NULL, 18, 6),
(154, NULL, NULL, 0, 44, NULL, NULL, 19, 7),
(182, NULL, NULL, 0, 45, NULL, NULL, 1, 4),
(183, '50 minuti', '6 porzioni', 1, 45, 4, 'Giovedi ore 16:00', 2, 0),
(184, '50 minuti', '6 porzioni', 0, 45, NULL, 'Giovedi ore 16:00', 3, 1),
(185, '', '', 0, 45, NULL, 'Giovedi ore 16:00', 5, 2),
(186, NULL, NULL, 0, 45, NULL, NULL, 20, 3),
(187, NULL, NULL, 0, 45, NULL, NULL, 8, 5),
(188, NULL, NULL, 0, 45, NULL, NULL, 18, 6),
(189, NULL, NULL, 0, 45, NULL, NULL, 19, 7),
(277, NULL, NULL, 0, 45, NULL, NULL, 1, 8),
(316, NULL, NULL, 0, 46, NULL, NULL, 1, 4),
(317, '50 minuti', '6 porzioni', 1, 46, 4, 'Giovedi ore 16:00', 2, 0),
(318, '50 minuti', '6 porzioni', 0, 46, NULL, 'Giovedi ore 16:00', 3, 1),
(319, '', '', 0, 46, NULL, 'Giovedi ore 16:00', 5, 2),
(320, NULL, NULL, 0, 46, NULL, NULL, 20, 3),
(321, NULL, NULL, 0, 46, NULL, NULL, 8, 5),
(322, NULL, NULL, 0, 46, NULL, NULL, 18, 6),
(323, NULL, NULL, 0, 46, NULL, NULL, 19, 7),
(324, NULL, NULL, 0, 46, NULL, NULL, 1, 8),
(327, NULL, NULL, 0, 47, NULL, NULL, 1, 4),
(328, '50 minuti', '6 porzioni', 1, 47, 4, 'Giovedi ore 16:00', 2, 0),
(329, '50 minuti', '6 porzioni', 0, 47, NULL, 'Giovedi ore 16:00', 3, 1),
(330, '', '', 0, 47, NULL, 'Giovedi ore 16:00', 5, 2),
(331, NULL, NULL, 0, 47, NULL, NULL, 20, 3),
(332, NULL, NULL, 0, 47, NULL, NULL, 8, 5),
(333, NULL, NULL, 0, 47, NULL, NULL, 18, 6),
(334, NULL, NULL, 0, 47, NULL, NULL, 19, 7),
(335, NULL, NULL, 0, 47, NULL, NULL, 1, 8),
(338, NULL, NULL, 0, 48, NULL, NULL, 1, 4),
(339, '50 minuti', '6 porzioni', 1, 48, 4, 'Giovedi ore 16:00', 2, 0),
(340, '50 minuti', '6 porzioni', 0, 48, NULL, 'Giovedi ore 16:00', 3, 1),
(341, '', '', 0, 48, NULL, 'Giovedi ore 16:00', 5, 2),
(342, NULL, NULL, 0, 48, NULL, NULL, 20, 3),
(343, NULL, NULL, 0, 48, NULL, NULL, 8, 5),
(344, NULL, NULL, 0, 48, NULL, NULL, 18, 6),
(345, NULL, NULL, 0, 48, NULL, NULL, 19, 7),
(346, NULL, NULL, 0, 48, NULL, NULL, 1, 8),
(349, NULL, NULL, 0, 49, NULL, NULL, 1, 4),
(350, '50 minuti', '6 porzioni', 1, 49, 4, 'Giovedi ore 16:00', 2, 0),
(351, '50 minuti', '6 porzioni', 0, 49, NULL, 'Giovedi ore 16:00', 3, 1),
(352, '', '', 0, 49, NULL, 'Giovedi ore 16:00', 5, 2),
(353, NULL, NULL, 0, 49, NULL, NULL, 20, 3),
(354, NULL, NULL, 0, 49, NULL, NULL, 8, 5),
(355, NULL, NULL, 0, 49, NULL, NULL, 18, 6),
(356, NULL, NULL, 0, 49, NULL, NULL, 19, 7),
(357, NULL, NULL, 0, 49, NULL, NULL, 1, 8),
(360, NULL, NULL, 0, 50, NULL, NULL, 1, 4),
(361, '50 minuti', '6 porzioni', 1, 50, 4, 'Giovedi ore 16:00', 2, 0),
(362, '50 minuti', '6 porzioni', 0, 50, NULL, 'Giovedi ore 16:00', 3, 1),
(363, '', '', 0, 50, NULL, 'Giovedi ore 16:00', 5, 2),
(364, NULL, NULL, 0, 50, NULL, NULL, 20, 3),
(365, NULL, NULL, 0, 50, NULL, NULL, 8, 5),
(366, NULL, NULL, 0, 50, NULL, NULL, 18, 6),
(367, NULL, NULL, 0, 50, NULL, NULL, 19, 7),
(368, NULL, NULL, 0, 50, NULL, NULL, 1, 8),
(371, NULL, NULL, 0, 51, NULL, NULL, 1, 4),
(372, '50 minuti', '6 porzioni', 1, 51, 4, 'Giovedi ore 16:00', 2, 0),
(373, '50 minuti', '6 porzioni', 0, 51, NULL, 'Giovedi ore 16:00', 3, 1),
(374, '', '', 0, 51, NULL, 'Giovedi ore 16:00', 5, 2),
(375, NULL, NULL, 0, 51, NULL, NULL, 20, 3),
(376, NULL, NULL, 0, 51, NULL, NULL, 8, 5),
(377, NULL, NULL, 0, 51, NULL, NULL, 18, 6),
(378, NULL, NULL, 0, 51, NULL, NULL, 19, 7),
(379, NULL, NULL, 0, 51, NULL, NULL, 1, 8),
(382, NULL, NULL, 0, 52, NULL, NULL, 1, 4),
(383, '50 minuti', '6 porzioni', 1, 52, 4, 'Giovedi ore 16:00', 2, 0),
(384, '50 minuti', '6 porzioni', 0, 52, NULL, 'Giovedi ore 16:00', 3, 1),
(385, '', '', 0, 52, NULL, 'Giovedi ore 16:00', 5, 2),
(386, NULL, NULL, 0, 52, NULL, NULL, 20, 3),
(387, NULL, NULL, 0, 52, NULL, NULL, 8, 5),
(388, NULL, NULL, 0, 52, NULL, NULL, 18, 6),
(389, NULL, NULL, 0, 52, NULL, NULL, 19, 7),
(390, NULL, NULL, 0, 52, NULL, NULL, 1, 8),
(393, NULL, NULL, 0, 53, NULL, NULL, 1, 4),
(394, '50 minuti', '6 porzioni', 1, 53, 4, 'Giovedi ore 16:00', 2, 0),
(395, '50 minuti', '6 porzioni', 0, 53, NULL, 'Giovedi ore 16:00', 3, 1),
(396, '', '', 0, 53, NULL, 'Giovedi ore 16:00', 5, 2),
(397, NULL, NULL, 0, 53, NULL, NULL, 20, 3),
(398, NULL, NULL, 0, 53, NULL, NULL, 8, 5),
(399, NULL, NULL, 0, 53, NULL, NULL, 18, 6),
(400, NULL, NULL, 0, 53, NULL, NULL, 19, 7),
(414, NULL, NULL, 0, 53, NULL, NULL, 2, 8),
(416, NULL, NULL, 0, 54, NULL, NULL, 1, 4),
(417, '50 minuti', '6 porzioni', 1, 54, 4, 'Giovedi ore 16:00', 2, 0),
(418, '50 minuti', '6 porzioni', 0, 54, NULL, 'Giovedi ore 16:00', 3, 1),
(419, '', '', 0, 54, NULL, 'Giovedi ore 16:00', 5, 2),
(420, NULL, NULL, 0, 54, NULL, NULL, 20, 3),
(421, NULL, NULL, 0, 54, NULL, NULL, 8, 5),
(422, NULL, NULL, 0, 54, NULL, NULL, 18, 6),
(423, NULL, NULL, 0, 54, NULL, NULL, 19, 7);

-- --------------------------------------------------------

--
-- Table structure for table `menufeatures`
--

CREATE TABLE IF NOT EXISTS `menufeatures` (
  `menu_id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL DEFAULT '',
  `value` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menufeatures`
--

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
(91, 'Richiede cuoco', 0),
(91, 'Buffet', 0),
(91, 'Richiede cucina', 0),
(91, 'Finger food', 0),
(91, 'Piatti caldi', 0),
(92, 'Richiede cuoco', 0),
(92, 'Buffet', 0),
(92, 'Richiede cucina', 0),
(92, 'Finger food', 0),
(92, 'Piatti caldi', 0),
(93, 'Richiede cuoco', 0),
(93, 'Buffet', 0),
(93, 'Richiede cucina', 0),
(93, 'Finger food', 0),
(93, 'Piatti caldi', 0),
(95, 'Richiede cuoco', 0),
(95, 'Buffet', 0),
(95, 'Richiede cucina', 0),
(95, 'Finger food', 0),
(95, 'Piatti caldi', 0),
(96, 'Richiede cuoco', 0),
(96, 'Buffet', 0),
(96, 'Richiede cucina', 0),
(96, 'Finger food', 0),
(96, 'Piatti caldi', 0),
(97, 'Richiede cuoco', 0),
(97, 'Buffet', 0),
(97, 'Richiede cucina', 0),
(97, 'Finger food', 0),
(97, 'Piatti caldi', 0),
(98, 'Richiede cuoco', 0),
(98, 'Buffet', 0),
(98, 'Richiede cucina', 0),
(98, 'Finger food', 0),
(98, 'Piatti caldi', 0),
(99, 'Richiede cuoco', 0),
(99, 'Buffet', 0),
(99, 'Richiede cucina', 0),
(99, 'Finger food', 0),
(99, 'Piatti caldi', 0),
(100, 'Richiede cuoco', 0),
(100, 'Buffet', 0),
(100, 'Richiede cucina', 0),
(100, 'Finger food', 0),
(100, 'Piatti caldi', 0),
(101, 'Richiede cuoco', 0),
(101, 'Buffet', 0),
(101, 'Richiede cucina', 0),
(101, 'Finger food', 0),
(101, 'Piatti caldi', 0),
(102, 'Richiede cuoco', 0),
(102, 'Buffet', 0),
(102, 'Richiede cucina', 0),
(102, 'Finger food', 0),
(102, 'Piatti caldi', 0),
(103, 'Richiede cuoco', 0),
(103, 'Buffet', 0),
(103, 'Richiede cucina', 0),
(103, 'Finger food', 0),
(103, 'Piatti caldi', 0),
(104, 'Richiede cuoco', 1),
(104, 'Buffet', 1),
(104, 'Richiede cucina', 1),
(104, 'Finger food', 1),
(104, 'Piatti caldi', 1),
(106, 'Richiede cuoco', 0),
(106, 'Buffet', 0),
(106, 'Richiede cucina', 0),
(106, 'Finger food', 0),
(106, 'Piatti caldi', 0),
(107, 'Richiede cuoco', 0),
(107, 'Buffet', 0),
(107, 'Richiede cucina', 0),
(107, 'Finger food', 0),
(107, 'Piatti caldi', 0),
(108, 'Richiede cuoco', 0),
(108, 'Buffet', 0),
(108, 'Richiede cucina', 0),
(108, 'Finger food', 0),
(108, 'Piatti caldi', 0),
(109, 'Richiede cuoco', 0),
(109, 'Buffet', 0),
(109, 'Richiede cucina', 0),
(109, 'Finger food', 0),
(109, 'Piatti caldi', 0),
(110, 'Richiede cuoco', 0),
(110, 'Buffet', 0),
(110, 'Richiede cucina', 0),
(110, 'Finger food', 0),
(110, 'Piatti caldi', 0),
(111, 'Richiede cuoco', 0),
(111, 'Buffet', 0),
(111, 'Richiede cucina', 0),
(111, 'Finger food', 0),
(111, 'Piatti caldi', 0),
(112, 'Richiede cuoco', 0),
(112, 'Buffet', 0),
(112, 'Richiede cucina', 0),
(112, 'Finger food', 0),
(112, 'Piatti caldi', 0),
(113, 'Richiede cuoco', 0),
(113, 'Buffet', 0),
(113, 'Richiede cucina', 0),
(113, 'Finger food', 0),
(113, 'Piatti caldi', 0),
(114, 'Richiede cuoco', 0),
(114, 'Buffet', 0),
(114, 'Richiede cucina', 0),
(114, 'Finger food', 0),
(114, 'Piatti caldi', 0),
(115, 'Richiede cuoco', 0),
(115, 'Buffet', 0),
(115, 'Richiede cucina', 0),
(115, 'Finger food', 0),
(115, 'Piatti caldi', 0),
(116, 'Richiede cuoco', 0),
(116, 'Buffet', 0),
(116, 'Richiede cucina', 0),
(116, 'Finger food', 0),
(116, 'Piatti caldi', 0),
(117, 'Richiede cuoco', 0),
(117, 'Buffet', 0),
(117, 'Richiede cucina', 0),
(117, 'Finger food', 0),
(117, 'Piatti caldi', 0),
(118, 'Richiede cuoco', 0),
(118, 'Buffet', 0),
(118, 'Richiede cucina', 0),
(118, 'Finger food', 0),
(118, 'Piatti caldi', 0),
(119, 'Richiede cuoco', 0),
(119, 'Buffet', 0),
(119, 'Richiede cucina', 0),
(119, 'Finger food', 0),
(119, 'Piatti caldi', 0),
(120, 'Richiede cuoco', 0),
(120, 'Buffet', 0),
(120, 'Richiede cucina', 0),
(120, 'Finger food', 0),
(120, 'Piatti caldi', 0),
(121, 'Richiede cuoco', 0),
(121, 'Buffet', 0),
(121, 'Richiede cucina', 0),
(121, 'Finger food', 0),
(121, 'Piatti caldi', 0);

-- --------------------------------------------------------

--
-- Table structure for table `menuitems`
--

CREATE TABLE IF NOT EXISTS `menuitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `section_id` int(11) DEFAULT NULL,
  `description` tinytext DEFAULT NULL,
  `recipe_id` int(11) NOT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=338 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menuitems`
--

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
(129, 92, 54, 'Vitello tonnato', 1, 0),
(130, 92, 54, 'Carpaccio di spada', 2, 1),
(131, 92, 54, 'Alici marinate', 3, 2),
(132, 92, 56, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(133, 92, 56, 'Salmone al forno', 8, 1),
(134, 92, 0, 'Insalata di riso', 4, 0),
(135, 92, 0, 'Penne al sugo di baccala', 5, 1),
(136, 93, 57, 'Vitello tonnato', 1, 0),
(137, 93, 57, 'Carpaccio di spada', 2, 1),
(138, 93, 57, 'Alici marinate', 3, 2),
(139, 93, 59, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(140, 93, 59, 'Salmone al forno', 8, 1),
(141, 93, 0, 'Insalata di riso', 4, 0),
(142, 93, 0, 'Penne al sugo di baccala', 5, 1),
(153, 95, 65, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(154, 95, 65, 'Salmone al forno', 8, 1),
(155, 95, 0, 'Insalata di riso', 4, 0),
(156, 95, 0, 'Penne al sugo di baccala', 5, 1),
(160, 96, 68, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(161, 96, 68, 'Salmone al forno', 8, 1),
(162, 96, 0, 'Insalata di riso', 4, 0),
(163, 96, 0, 'Penne al sugo di baccala', 5, 1),
(164, 96, 0, 'Vitello tonnato', 1, 0),
(165, 96, 0, 'Carpaccio di spada', 2, 1),
(166, 96, 0, 'Alici marinate', 3, 2),
(167, 97, 69, 'Vitello tonnato', 1, 0),
(168, 97, 69, 'Carpaccio di spada', 2, 1),
(169, 97, 69, 'Alici marinate', 3, 2),
(170, 97, 71, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(171, 97, 71, 'Salmone al forno', 8, 1),
(172, 97, 0, 'Insalata di riso', 4, 0),
(173, 97, 0, 'Penne al sugo di baccala', 5, 1),
(174, 98, 72, 'Vitello tonnato', 1, 0),
(175, 98, 72, 'Carpaccio di spada', 2, 1),
(176, 98, 72, 'Alici marinate', 3, 2),
(177, 98, 74, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(178, 98, 74, 'Salmone al forno', 8, 1),
(179, 98, 0, 'Insalata di riso', 4, 0),
(180, 98, 0, 'Penne al sugo di baccala', 5, 1),
(181, 99, 75, 'Vitello tonnato', 1, 2),
(182, 99, 75, 'Carpaccio di spada', 2, 0),
(183, 99, 75, 'Alici marinate', 3, 1),
(184, 99, 77, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(185, 99, 77, 'Salmone al forno', 8, 1),
(186, 99, 0, 'Insalata di riso', 4, 1),
(187, 99, 0, 'Penne al sugo di baccala', 5, 0),
(188, 100, 80, 'Vitello tonnato', 1, 0),
(189, 100, 78, 'Carpaccio di spada', 2, 1),
(190, 100, 78, 'Alici marinate', 3, 2),
(191, 100, 79, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(192, 100, 0, 'Salmone al forno', 8, 1),
(193, 100, 0, 'Insalata di riso', 4, 0),
(194, 100, 78, 'Penne al sugo di baccala', 5, 1),
(195, 101, 81, 'Vitello tonnato', 1, 0),
(196, 101, 81, 'Carpaccio di spada', 2, 1),
(197, 101, 81, 'Alici marinate', 3, 2),
(198, 101, 83, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(199, 101, 83, 'Salmone al forno', 8, 1),
(200, 101, 0, 'Insalata di riso', 4, 0),
(201, 101, 0, 'Penne al sugo di baccala', 5, 1),
(203, 102, 84, 'Carpaccio di spada', 2, 0),
(204, 102, 84, 'Alici marinate', 3, 1),
(206, 102, 86, 'Salmone al forno', 8, 0),
(207, 102, 0, 'Insalata di riso', 4, 0),
(209, 104, 90, 'Vitello tonnato', 1, 0),
(210, 104, 90, 'Carpaccio di spada', 2, 1),
(211, 104, 90, 'Alici marinate', 3, 2),
(212, 104, 92, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(213, 104, 92, 'Salmone al forno', 8, 1),
(214, 104, 0, 'Insalata di riso', 4, 0),
(215, 104, 0, 'Penne al sugo di baccala', 5, 1),
(223, 106, 96, 'Vitello tonnato', 1, 0),
(224, 106, 96, 'Carpaccio di spada', 2, 1),
(225, 106, 96, 'Alici marinate', 3, 2),
(226, 106, 98, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(227, 106, 98, 'Salmone al forno', 8, 1),
(228, 106, 0, 'Insalata di riso', 4, 0),
(229, 106, 0, 'Penne al sugo di baccala', 5, 1),
(230, 107, 99, 'Vitello tonnato', 1, 0),
(231, 107, 99, 'Carpaccio di spada', 2, 1),
(232, 107, 99, 'Alici marinate', 3, 2),
(233, 107, 101, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(234, 107, 101, 'Salmone al forno', 8, 1),
(235, 107, 0, 'Insalata di riso', 4, 0),
(236, 107, 0, 'Penne al sugo di baccala', 5, 1),
(240, 108, 104, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(241, 108, 104, 'Salmone al forno', 8, 1),
(242, 108, 0, 'Insalata di riso', 4, 0),
(243, 108, 0, 'Penne al sugo di baccala', 5, 1),
(247, 109, 107, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(248, 109, 107, 'Salmone al forno', 8, 1),
(249, 109, 0, 'Insalata di riso', 4, 0),
(250, 109, 0, 'Penne al sugo di baccala', 5, 1),
(251, 109, 0, 'Vitello tonnato', 1, 0),
(252, 109, 0, 'Carpaccio di spada', 2, 1),
(253, 109, 0, 'Alici marinate', 3, 2),
(254, 110, 108, 'Vitello tonnato', 1, 0),
(255, 110, 108, 'Carpaccio di spada', 2, 1),
(256, 110, 108, 'Alici marinate', 3, 2),
(257, 110, 110, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(258, 110, 110, 'Salmone al forno', 8, 1),
(259, 110, 0, 'Insalata di riso', 4, 0),
(260, 110, 0, 'Penne al sugo di baccala', 5, 1),
(261, 111, 111, 'Vitello tonnato', 1, 0),
(262, 111, 111, 'Carpaccio di spada', 2, 1),
(263, 111, 111, 'Alici marinate', 3, 2),
(264, 111, 113, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(265, 111, 113, 'Salmone al forno', 8, 1),
(266, 111, 0, 'Insalata di riso', 4, 0),
(267, 111, 0, 'Penne al sugo di baccala', 5, 1),
(268, 112, 114, 'Vitello tonnato', 1, 2),
(269, 112, 114, 'Carpaccio di spada', 2, 0),
(270, 112, 114, 'Alici marinate', 3, 1),
(271, 112, 116, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(272, 112, 116, 'Salmone al forno', 8, 1),
(273, 112, 0, 'Insalata di riso', 4, 1),
(274, 112, 0, 'Penne al sugo di baccala', 5, 0),
(275, 113, 119, 'Vitello tonnato', 1, 0),
(276, 113, 117, 'Carpaccio di spada', 2, 1),
(277, 113, 117, 'Alici marinate', 3, 2),
(278, 113, 118, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(279, 113, 0, 'Salmone al forno', 8, 1),
(280, 113, 0, 'Insalata di riso', 4, 0),
(281, 113, 117, 'Penne al sugo di baccala', 5, 1),
(282, 114, 120, 'Vitello tonnato', 1, 0),
(283, 114, 120, 'Carpaccio di spada', 2, 1),
(284, 114, 120, 'Alici marinate', 3, 2),
(285, 114, 122, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(286, 114, 122, 'Salmone al forno', 8, 1),
(287, 114, 0, 'Insalata di riso', 4, 0),
(288, 114, 0, 'Penne al sugo di baccala', 5, 1),
(290, 115, 123, 'Carpaccio di spada', 2, 0),
(291, 115, 123, 'Alici marinate', 3, 1),
(293, 115, 125, 'Salmone al forno', 8, 0),
(294, 115, 0, 'Insalata di riso', 4, 0),
(296, 116, 126, 'Vitello tonnato', 1, 0),
(297, 116, 126, 'Carpaccio di spada', 2, 1),
(298, 116, 126, 'Alici marinate', 3, 2),
(299, 116, 128, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(300, 116, 128, 'Salmone al forno', 8, 1),
(301, 116, 0, 'Insalata di riso', 4, 0),
(302, 116, 0, 'Penne al sugo di baccala', 5, 1),
(303, 117, 129, 'Vitello tonnato', 1, 0),
(304, 117, 129, 'Carpaccio di spada', 2, 1),
(305, 117, 129, 'Alici marinate', 3, 2),
(306, 117, 131, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(307, 117, 131, 'Salmone al forno', 8, 1),
(308, 117, 0, 'Insalata di riso', 4, 0),
(309, 117, 0, 'Penne al sugo di baccala', 5, 1),
(310, 118, 132, 'Vitello tonnato', 1, 0),
(311, 118, 132, 'Carpaccio di spada', 2, 1),
(312, 118, 132, 'Alici marinate', 3, 2),
(313, 118, 134, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(314, 118, 134, 'Salmone al forno', 8, 1),
(315, 118, 0, 'Insalata di riso', 4, 0),
(316, 118, 0, 'Penne al sugo di baccala', 5, 1),
(317, 119, 135, 'Vitello tonnato', 1, 0),
(318, 119, 135, 'Carpaccio di spada', 2, 1),
(319, 119, 135, 'Alici marinate', 3, 2),
(320, 119, 137, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(321, 119, 137, 'Salmone al forno', 8, 1),
(322, 119, 0, 'Insalata di riso', 4, 0),
(323, 119, 0, 'Penne al sugo di baccala', 5, 1),
(324, 120, 138, 'Vitello tonnato', 1, 0),
(325, 120, 138, 'Carpaccio di spada', 2, 1),
(326, 120, 138, 'Alici marinate', 3, 2),
(327, 120, 140, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(328, 120, 140, 'Salmone al forno', 8, 1),
(329, 120, 0, 'Insalata di riso', 4, 0),
(330, 120, 0, 'Penne al sugo di baccala', 5, 1),
(331, 121, 141, 'Vitello tonnato', 1, 0),
(332, 121, 141, 'Carpaccio di spada', 2, 1),
(333, 121, 141, 'Alici marinate', 3, 2),
(334, 121, 143, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(335, 121, 143, 'Salmone al forno', 8, 1),
(336, 121, 0, 'Insalata di riso', 4, 0),
(337, 121, 0, 'Penne al sugo di baccala', 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `menus`
--

CREATE TABLE IF NOT EXISTS `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` tinytext DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `published` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menus`
--

INSERT INTO `menus` (`id`, `title`, `owner_id`, `published`) VALUES
(80, 'Coffee break mattutino', 2, 1),
(82, 'Coffee break pomeridiano', 2, 1),
(86, 'Cena di compleanno pesce', 3, 1),
(91, 'Menu Pinco Pallino', 2, 0),
(92, 'Menu da copiare', 2, 1),
(93, 'Menu da copiare', 2, 0),
(95, 'Menu Pinco Pallino', 2, 0),
(104, 'Titolo Nuovo', 2, 1),
(106, 'Menu da copiare', 2, 1),
(120, 'Menu Pinco Pallino', 2, 0),
(121, 'Menu Pinco Pallino', 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `menusections`
--

CREATE TABLE IF NOT EXISTS `menusections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `name` tinytext DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menusections`
--

INSERT INTO `menusections` (`id`, `menu_id`, `name`, `position`) VALUES
(41, 86, 'Antipasti', 0),
(42, 86, 'Primi', 1),
(43, 86, 'Secondi', 2),
(44, 86, 'Dessert', 3),
(51, 91, 'Antipasti', 0),
(52, 91, 'Primi', 1),
(53, 91, 'Secondi', 2),
(54, 92, 'Antipasti', 0),
(55, 92, 'Primi', 1),
(56, 92, 'Secondi', 2),
(57, 93, 'Antipasti', 0),
(58, 93, 'Primi', 1),
(59, 93, 'Secondi', 2),
(65, 95, 'Secondi', 2),
(67, 96, 'Primi', 1),
(68, 96, 'Secondi', 2),
(69, 97, 'Hors d\'Oeuvres', 0),
(70, 97, 'Primi', 1),
(71, 97, 'Secondi', 2),
(72, 98, 'Antipasti', 2),
(73, 98, 'Primi', 1),
(74, 98, 'Secondi', 0),
(75, 99, 'Antipasti', 0),
(76, 99, 'Primi', 1),
(77, 99, 'Secondi', 2),
(78, 100, 'Antipasti', 0),
(79, 100, 'Primi', 1),
(80, 100, 'Secondi', 2),
(81, 101, 'Antipasti', 0),
(82, 101, 'Primi', 1),
(83, 101, 'Secondi', 2),
(84, 102, 'Antipasti', 0),
(85, 102, 'Primi', 1),
(86, 102, 'Secondi', 2),
(87, 103, 'Antipasti', 0),
(88, 103, 'Primi', 1),
(89, 103, 'Secondi', 2),
(90, 104, 'Antipasti', 0),
(91, 104, 'Primi', 1),
(92, 104, 'Secondi', 2),
(96, 106, 'Antipasti', 0),
(97, 106, 'Primi', 1),
(98, 106, 'Secondi', 2),
(99, 107, 'Antipasti', 0),
(100, 107, 'Primi', 1),
(101, 107, 'Secondi', 2),
(104, 108, 'Secondi', 2),
(106, 109, 'Primi', 1),
(107, 109, 'Secondi', 2),
(108, 110, 'Hors d\'Oeuvres', 0),
(109, 110, 'Primi', 1),
(110, 110, 'Secondi', 2),
(111, 111, 'Antipasti', 2),
(112, 111, 'Primi', 1),
(113, 111, 'Secondi', 0),
(114, 112, 'Antipasti', 0),
(115, 112, 'Primi', 1),
(116, 112, 'Secondi', 2),
(117, 113, 'Antipasti', 0),
(118, 113, 'Primi', 1),
(119, 113, 'Secondi', 2),
(120, 114, 'Antipasti', 0),
(121, 114, 'Primi', 1),
(122, 114, 'Secondi', 2),
(123, 115, 'Antipasti', 0),
(124, 115, 'Primi', 1),
(125, 115, 'Secondi', 2),
(126, 116, 'Antipasti', 2),
(127, 116, 'Primi', 1),
(128, 116, 'Secondi', 0),
(129, 117, 'Antipasti', 0),
(130, 117, 'Primi', 1),
(131, 117, 'Secondi', 2),
(132, 118, 'Antipasti', 0),
(133, 118, 'Primi', 1),
(134, 118, 'Secondi', 2),
(135, 119, 'Antipasti', 1),
(136, 119, 'Primi', 2),
(137, 119, 'Secondi', 0),
(138, 120, 'Antipasti', 1),
(139, 120, 'Primi', 2),
(140, 120, 'Secondi', 0),
(141, 121, 'Antipasti', 1),
(142, 121, 'Primi', 2),
(143, 121, 'Secondi', 0);

-- --------------------------------------------------------

--
-- Table structure for table `recipes`
--

CREATE TABLE IF NOT EXISTS `recipes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recipes`
--

INSERT INTO `recipes` (`id`, `name`) VALUES
(1, 'Vitello tonnato'),
(2, 'Carpaccio di spada'),
(3, 'Alici marinate'),
(4, 'Insalata di riso'),
(5, 'Penne al sugo di baccala'),
(6, 'Pappa al pomodoro'),
(7, 'Hamburger con bacon e cipolla caramellata'),
(8, 'Salmone al forno'),
(9, 'Croissant'),
(10, 'Pane al cioccolato'),
(11, 'Girelle all\'uvetta'),
(12, 'Panini al latte'),
(13, 'Biscotti di pasta frolla'),
(14, 'Lingue di gatto'),
(15, 'Bigne farciti'),
(16, 'Pizzette'),
(17, 'Tramezzini'),
(18, 'Sorbetto al limone'),
(19, 'Torta Saint Honore'),
(20, 'Risotto alla zucca');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id` char(1) NOT NULL,
  `role` varchar(128) NOT NULL DEFAULT 'servizio',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `role`) VALUES
('c', 'cuoco'),
('h', 'chef'),
('o', 'organizzatore'),
('s', 'servizio');

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

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

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `event_id`, `name`, `proposed_menu_id`, `approved_menu_id`, `service_date`, `time_start`, `time_end`, `expected_participants`) VALUES
(1, 2, 'Cena', 86, 0, '2020-08-13', '20:00:00', '23:30:00', 25),
(2, 1, 'Coffee break mattino', 0, 80, '2020-09-25', '10:30:00', '11:30:00', 100),
(3, 1, 'Colazione di lavoro', 0, 0, '2020-09-25', '13:00:00', '14:00:00', 80),
(4, 1, 'Coffee break pomeriggio', 0, 82, '2020-09-25', '16:00:00', '16:30:00', 100),
(5, 1, 'Cena sociale', 0, 0, '2020-09-25', '20:00:00', '22:30:00', 40),
(6, 3, 'Pranzo giorno 1', 0, 0, '2020-10-02', '12:00:00', '15:00:00', 200),
(7, 3, 'Pranzo giorno 2', 0, 0, '2020-10-03', '12:00:00', '15:00:00', 300),
(8, 3, 'Pranzo giorno 3', 0, 0, '2020-10-04', '12:00:00', '15:00:00', 400);

-- --------------------------------------------------------

--
-- Table structure for table `turns`
--

CREATE TABLE IF NOT EXISTS `turns` (
  `when` varchar(20) NOT NULL,
  `completed` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`when`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `turns`
--

INSERT INTO `turns` (`when`, `completed`) VALUES
('Giovedi ore 15:00', 1),
('Giovedi ore 16:00', 0),
('Giovedi ore 17:00', 1),
('Martedi ore 15:00', 0),
('Martedi ore 16:00', 0),
('Martedi ore 17:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `userroles`
--

CREATE TABLE IF NOT EXISTS `userroles` (
  `user_id` int(11) NOT NULL,
  `role_id` char(1) NOT NULL DEFAULT 's'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userroles`
--

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

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
