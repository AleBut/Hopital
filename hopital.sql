-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 18 avr. 2018 à 21:27
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `hopital`
--

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

DROP TABLE IF EXISTS `chambre`;
CREATE TABLE IF NOT EXISTS `chambre` (
  `code_service` char(3) NOT NULL,
  `no_chambre` decimal(3,0) NOT NULL,
  `surveillant` decimal(4,0) DEFAULT NULL,
  `nb_lits` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`code_service`,`no_chambre`),
  KEY `surveillant` (`surveillant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`code_service`, `no_chambre`, `surveillant`, `nb_lits`) VALUES
('REA', '101', '12', '1'),
('REA', '102', '12', '1'),
('REA', '103', '22', '2'),
('REA', '104', '22', '2'),
('CHG', '201', '29', '4'),
('CHG', '202', '29', '4'),
('CHG', '301', '57', '2'),
('CHG', '302', '57', '2'),
('CHG', '303', '57', '1'),
('CAR', '101', '95', '3'),
('CAR', '102', '95', '2'),
('CAR', '103', '95', '1'),
('REA', '105', '49', '1'),
('REA', '106', '49', '1'),
('REA', '107', '49', '2'),
('REA', '108', '116', '2'),
('CHG', '401', '130', '4'),
('CHG', '402', '130', '4'),
('CHG', '403', '151', '2'),
('CHG', '404', '151', '2'),
('CHG', '405', '151', '1'),
('CAR', '104', '169', '3'),
('CAR', '105', '169', '2'),
('CAR', '106', '169', '1');

-- --------------------------------------------------------

--
-- Structure de la table `docteur`
--

DROP TABLE IF EXISTS `docteur`;
CREATE TABLE IF NOT EXISTS `docteur` (
  `numero` decimal(4,0) NOT NULL,
  `specialite` enum('Anesthesiste','Cardiologue','Generaliste','Orthopediste','Pneumologue','Radiologue','Traumatologue') NOT NULL DEFAULT 'Generaliste',
  PRIMARY KEY (`numero`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `docteur`
--

INSERT INTO `docteur` (`numero`, `specialite`) VALUES
('19', 'Traumatologue'),
('34', 'Pneumologue'),
('80', 'Cardiologue'),
('10', 'Cardiologue'),
('26', 'Orthopediste'),
('53', 'Traumatologue'),
('64', 'Radiologue'),
('85', 'Anesthesiste'),
('88', 'Cardiologue'),
('113', 'Pneumologue'),
('114', 'Traumatologue'),
('126', 'Radiologue'),
('135', 'Anesthesiste'),
('8', 'Cardiologue'),
('122', 'Pneumologue'),
('4', 'Orthopediste'),
('24', 'Orthopediste'),
('31', 'Anesthesiste'),
('54', 'Pneumologue'),
('82', 'Orthopediste'),
('89', 'Radiologue'),
('99', 'Anesthesiste'),
('140', 'Cardiologue'),
('141', 'Traumatologue'),
('144', 'Radiologue'),
('152', 'Cardiologue'),
('179', 'Anesthesiste'),
('180', 'Cardiologue'),
('196', 'Traumatologue'),
('7', 'Cardiologue'),
('50', 'Pneumologue'),
('27', 'Orthopediste');

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `numero_e` decimal(4,0) NOT NULL,
  `nom_employe` varchar(12) NOT NULL,
  `prenom_employe` varchar(12) NOT NULL,
  `adresse_employe` varchar(40) DEFAULT NULL,
  `telephone_employe` char(14) DEFAULT NULL,
  PRIMARY KEY (`numero_e`),
  UNIQUE KEY `nom` (`nom_employe`,`prenom_employe`,`telephone_employe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`numero_e`, `nom_employe`, `prenom_employe`, `adresse_employe`, `telephone_employe`) VALUES
('19', 'Safin', 'Marat', '61 rue Fermee, 78430 Louveciennes', '01 06 70 38 90'),
('34', 'Dechy', 'Nathalie', '6 Bd. Aristide Briand, 78870 Bailly', '01 13 71 36 65'),
('80', 'Hewitt', 'Lleyton', '25 rue de Jouques, 78870 Bailly', '01 29 52 84 64'),
('10', 'Ferrer', 'David', '21 Bd. Jean Jaures, 78310 Maurepas', '01 03 71 38 64'),
('26', 'Hantuchova', 'Daniela', '28 rue Buscaille, 78000 Versailles', '01 10 70 09 57'),
('53', 'Hingis', 'Martina', '3 rue Gaston de Saporta, 78870 Bailly', '01 17 71 19 57'),
('64', 'Henin', 'Justine', '1 cours Gambetta, 78660 Ablis', '01 20 71 11 93'),
('85', 'Mathieu', 'Paul-Henri', '63 rue de l\'Opera, 78000 Versailles', '01 32 43 06 65'),
('88', 'Rochus', 'Olivier', '40 rue Marcel Guillaume, 78870 Bailly', '01 33 71 22 90'),
('113', 'Williams', 'Venus', '5 rue de l\'Annonciade, 78310 Maurepas', '01 52 53 35 74'),
('114', 'Monfils', 'Gael', '33 rue Littera, 78240 Chambourcy', '01 53 34 45 65'),
('126', 'Djokovic', 'Novak', '35 Av. des Thermes, 78990 Elancourt', '01 58 30 36 63'),
('135', 'Gasquet', 'Richard', '22 rue Boulegon, 78300 Poissy', '01 66 55 11 60'),
('12', 'Davenport', 'Lindsay', '56 rue des Muletiers, 78660 Ablis', '01 04 70 01 65'),
('15', 'Haas', 'Tommy', '68 Av. Pasteur, 78000 Versailles', '01 05 70 39 78'),
('22', 'Gicquel', 'Marc', '67 rue de la Fontaine, 78300 Poissy', '01 08 70 19 78'),
('25', 'Benneteau', 'Julien', '32 rue Signoret, 78430 Louveciennes', '01 09 70 24 85'),
('29', 'Pavel', 'Andrei', '5 rue du Plan, 78300 Poissy', '01 10 70 10 74'),
('45', 'Schnyder', 'Patty', '50 rue Villars, 78130 Les Mureaux', '01 15 71 25 67'),
('57', 'Pennetta', 'Flavia', '48 rue de l\'Ecole, 78120 Rambouillet', '01 18 60 41 33'),
('71', 'Berdych', 'Tomas', '29 rue Lieutaud, 78430 Louveciennes', '01 23 71 09 99'),
('73', 'Cornet', 'Alize', '24 rue des Bremondis, 78000 Versailles', '01 25 71 11 66'),
('95', 'Sugiyama', 'Ai', '34 rue des Carmes, 78000 Versailles', '01 38 62 11 31'),
('97', 'Canas', 'Guillermo', '51 rue Villevieille, 78120 Rambouillet', '01 38 71 12 60'),
('127', 'Clement', 'Arnaud', '10 rue Granet, 78000 Versailles', '01 61 47 28 67'),
('139', 'Molik', 'Alicia', '18 rue d\'Italie, 78870 Bailly', '01 67 36 09 91'),
('162', 'Williams', 'Serena', '27 rue Boueno Carriero, 78310 Maurepas', '01 89 53 35 89'),
('8', 'Grosjean', 'Sebastien', '57 Av. Napoleon Bonaparte, 78190 Trappes', '01 25 60 00 87'),
('122', 'Mauresmo', 'Amelie', '39 cours de la Trinite, 78000 Versailles', '01 22 47 75 89'),
('4', 'Nadal', 'Rafael', '18 place Bellegarde, 78990 Elancourt', '01 29 71 13 76'),
('82', 'Dementieva', 'Elena', '52 rue de la Molle, 78240 Chambourcy', '01 29 72 72 48'),
('99', 'Federer', 'Roger', '70 rue Paul Doumer, 78310 Maurepas', '01 39 71 39 66'),
('180', 'Nalbandian', 'David', '46 Rue Courteissade, 78310 Maurepas', '01 94 53 22 54'),
('24', 'Zvonareva', 'Vera', '11 place des Augustins, 78300 Poissy', '01 08 71 38 93'),
('31', 'Stepanek', 'Radek', '33 rue Cardinale, 78000 Versailles', '01 11 71 87 71'),
('54', 'Andreev', 'Igor', '2 rue Pierre et Marie Curie, 78530 Buc', '01 17 71 77 33'),
('89', 'Moya', 'Carlos', '21 rue Roux Alpheran, 78990 Elancourt', '01 34 71 09 56'),
('140', 'Dulko', 'Gisela', '22 rue des chapeliers, 78112 Fourqueux', '01 69 73 18 64'),
('141', 'Golovin', 'Tatiana', '8 place des Precheurs, 78300 Poissy', '01 70 73 51 79'),
('144', 'Ivanovic', 'Ana', '4 rue Gianotti, 78240 Chambourcy', '01 71 47 11 89'),
('152', 'Murray', 'Andy', '6 rue de la Glaciere, 78280 Guyancourt', '01 80 54 56 25'),
('179', 'Santoro', 'Fabrice', '52 rue des Epinaux, 78310 Maurepas', '01 93 70 51 41'),
('196', 'Kuznetsova', 'Svetlana', '12 rue du Griffon, 78300 Poissy', '01 99 70 13 51'),
('49', 'Kremer', 'Anne', '15 rue Baratanque, 78130 Les Mureaux', '01 17 37 09 65'),
('86', 'Vaidisova', 'Nicole', '69 rue Paul Bert, 78870 Bailly', '01 32 70 13 51'),
('98', 'Lopez', 'Feliciano', '39 rue Chastel, 78190 Trappes', '01 39 71 19 90'),
('116', 'Ancic', 'Mario', '47 rue des Menudieres, 78870 Bailly', '01 54 53 00 90'),
('130', 'Ljubicic', 'Ivan', '9 rue Goyrand, 78120 Rambouillet', '01 64 73 66 30'),
('131', 'Harkleroad', 'Ashley', '64 rue Finsonius, 78000 Versailles', '01 66 43 02 49'),
('151', 'Baghdatis', 'Marcos', '58 rue Fauchier, 78990 Elancourt', '01 80 43 39 73'),
('155', 'Simon', 'Gilles', '42 rue des Marseillais, 78190 Trappes', '01 82 53 18 73'),
('163', 'Bartoli', 'Marion', '8 rue Gontard, 78112 Fourqueux', '01 89 53 56 26'),
('169', 'Roddick', 'Andy', '62 rue Fernand Dol, 78530 Buc', '01 91 53 36 33'),
('176', 'Serra', 'Florent', '50 place Miollis, 78300 Poissy', '01 92 71 13 64'),
('189', 'Razzano', 'Virginie', '29 cours Saint Louis, 78660 Ablis', '01 96 37 14 82'),
('194', 'Blake', 'James', '33 rue Suffren, 78310 Maurepas', '01 98 53 39 89'),
('195', 'Mayer', 'Florian', '54 rue de Montigny, 78000 Versailles', '01 99 61 09 68'),
('7', 'Bjorkman', 'Jonas', '59 rue du Felibre Gault, 78310 Maurepas', '01 91 74 00 55'),
('50', 'Parmentier', 'Pauline', '4 place des Tanneurs, 78130 Les Mureaux', '01 80 53 13 30'),
('27', 'Spadea', 'Vincent', '32 place des Cardeurs, 78000 Versailles', '01 55 54 51 79');

-- --------------------------------------------------------

--
-- Structure de la table `hospitalisation`
--

DROP TABLE IF EXISTS `hospitalisation`;
CREATE TABLE IF NOT EXISTS `hospitalisation` (
  `no_malade` decimal(4,0) NOT NULL,
  `code_service` char(3) NOT NULL,
  `no_chambre` decimal(3,0) NOT NULL,
  `lit` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`no_malade`),
  UNIQUE KEY `code_service` (`code_service`,`no_chambre`,`lit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hospitalisation`
--

INSERT INTO `hospitalisation` (`no_malade`, `code_service`, `no_chambre`, `lit`) VALUES
('1', 'REA', '101', '1'),
('3', 'REA', '102', '1'),
('6', 'REA', '103', '1'),
('21', 'REA', '103', '2'),
('33', 'REA', '104', '1'),
('36', 'REA', '104', '2'),
('37', 'CHG', '201', '1'),
('41', 'CHG', '201', '2'),
('43', 'CHG', '201', '3'),
('46', 'CHG', '202', '2'),
('52', 'CHG', '202', '3'),
('55', 'CHG', '202', '4'),
('56', 'CHG', '301', '1'),
('61', 'CHG', '301', '2'),
('65', 'CHG', '302', '1'),
('66', 'CHG', '302', '2'),
('67', 'CHG', '303', '1'),
('68', 'CAR', '101', '1'),
('72', 'CAR', '101', '3'),
('74', 'CAR', '102', '1'),
('76', 'CAR', '102', '2'),
('77', 'CAR', '103', '1'),
('103', 'REA', '105', '1'),
('105', 'REA', '107', '1'),
('108', 'REA', '107', '2'),
('117', 'REA', '108', '1'),
('120', 'CHG', '401', '1'),
('123', 'CHG', '401', '4'),
('137', 'CHG', '402', '1'),
('145', 'CHG', '402', '2'),
('147', 'CHG', '402', '3'),
('149', 'CHG', '403', '1'),
('154', 'CHG', '403', '2'),
('159', 'CHG', '404', '2'),
('167', 'CHG', '405', '1'),
('172', 'CAR', '104', '1'),
('182', 'CAR', '104', '3'),
('188', 'CAR', '105', '2'),
('192', 'CAR', '106', '1');

-- --------------------------------------------------------

--
-- Structure de la table `infirmier`
--

DROP TABLE IF EXISTS `infirmier`;
CREATE TABLE IF NOT EXISTS `infirmier` (
  `numero` decimal(4,0) NOT NULL,
  `code_service` char(3) DEFAULT NULL,
  `rotation` enum('JOUR','NUIT') NOT NULL DEFAULT 'JOUR',
  `salaire` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `code_service` (`code_service`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `infirmier`
--

INSERT INTO `infirmier` (`numero`, `code_service`, `rotation`, `salaire`) VALUES
('12', 'REA', 'JOUR', '1256.78'),
('15', 'CHG', 'JOUR', '1178.48'),
('22', 'REA', 'JOUR', '1498.21'),
('25', 'CAR', 'JOUR', '1574.25'),
('29', 'CHG', 'JOUR', '1358.45'),
('45', 'CAR', 'JOUR', '1465.25'),
('57', 'CHG', 'JOUR', '1765.21'),
('71', 'CAR', 'NUIT', '1335.86'),
('73', 'REA', 'NUIT', '1473.29'),
('95', 'CAR', 'NUIT', '1947.61'),
('97', 'CHG', 'NUIT', '1184.26'),
('127', 'REA', 'NUIT', '1267.38'),
('139', 'CHG', 'NUIT', '2034.82'),
('162', 'CHG', 'NUIT', '1381.29'),
('49', 'REA', 'JOUR', '1256.78'),
('86', 'CHG', 'JOUR', '1178.48'),
('98', 'CAR', 'JOUR', '1498.21'),
('116', 'REA', 'JOUR', '1574.25'),
('130', 'CHG', 'JOUR', '1358.45'),
('131', 'CAR', 'JOUR', '1465.25'),
('151', 'CHG', 'JOUR', '1765.21'),
('155', 'CHG', 'NUIT', '1335.86'),
('163', 'CAR', 'NUIT', '1473.29'),
('169', 'CAR', 'NUIT', '1947.61'),
('176', 'CHG', 'NUIT', '1184.26'),
('189', 'REA', 'NUIT', '1267.38'),
('194', 'CHG', 'NUIT', '2034.82'),
('195', 'CHG', 'NUIT', '1381.29');

-- --------------------------------------------------------

--
-- Structure de la table `malade`
--

DROP TABLE IF EXISTS `malade`;
CREATE TABLE IF NOT EXISTS `malade` (
  `numero_m` decimal(4,0) NOT NULL,
  `nom_malade` varchar(12) NOT NULL,
  `prenom_malade` varchar(12) NOT NULL,
  `adresse_malade` varchar(40) DEFAULT NULL,
  `tel_malade` char(14) DEFAULT NULL,
  `mutuelle` varchar(6) DEFAULT NULL,
  `date_arrive` date DEFAULT NULL,
  PRIMARY KEY (`numero_m`),
  UNIQUE KEY `nom` (`nom_malade`,`prenom_malade`,`tel_malade`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `malade`
--

INSERT INTO `malade` (`numero_m`, `nom_malade`, `prenom_malade`, `adresse_malade`, `tel_malade`, `mutuelle`, `date_arrive`) VALUES
('1', 'Querrey', 'Sam', '43 rue Vauvenargues, 78000 Versailles', '01 52 53 23 82', 'MNAM', '2018-03-01'),
('3', 'Paszek', 'Tamira', '66 impasse du Paradis, 78300 Poissy', '01 89 61 09 67', 'LMDE', '2018-03-01'),
('6', 'Osterloh', 'Lilia', '43 rue de la Masse, 78310 Maurepas', '01 66 55 77 29', 'MNH', '2018-03-01'),
('13', 'Gallovits', 'Edina', '9 rue du Puits Juif, 78130 Les Mureaux', '01 17 73 13 69', 'MAAF', '2018-03-02'),
('14', 'Rodionova', 'Anastasia', '50 Bd. Emile Zola, 78240 Chambourcy', '01 95 53 20 73', 'MGEN', '2018-03-02'),
('21', 'Sela', 'Dudi', '6 Bd. des Poilus, 78630 Orgeval', '01 04 71 42 63', 'MMA', '2018-03-03'),
('23', 'Bammer', 'Sybille', '35 rue Loubon, 78990 Elancourt', '01 96 37 35 60', 'CNAMTS', '2018-03-03'),
('33', 'Volandri', 'Filippo', '25 rue des Bretons, 78430 Louveciennes', '01 81 62 11 89', 'CCVRP', '2018-03-04'),
('35', 'Ventura', 'Santiago', '46 place de Verdun, 78990 Elancourt', '01 91 61 35 69', 'MNFTC', '2018-03-05'),
('36', 'Horna', 'Luis', '38 place des Chapeliers, 78530 Buc', '01 66 55 11 67', 'MAS', '2018-03-05'),
('37', 'Almagro', 'Nicolas', '22 place Jeanne d\'Arc, 78770 Auteuil', '01 29 70 14 85', 'AG2R', '2018-03-05'),
('41', 'Zabaleta', 'Mariano', '10 rue Aude, 78630 Orgeval', '01 77 58 10 55', 'MGSP', '2018-03-05'),
('43', 'Poutchek', 'Tatiana', '34 rue Loubet, 78000 Versailles', '01 48 71 72 65', 'MNAM', '2018-03-06'),
('44', 'Fish', 'Mardy', '63 place Ferreol, 78310 Maurepas', '01 21 47 03 27', 'LMDE', '2018-03-06'),
('46', 'Cilic', 'Marin', '26 Av. Jules Isaac, 78000 Versailles', '01 07 72 15 93', 'MNH', '2018-03-07'),
('52', 'Hanescu', 'Victor', '12 rue Vieille, 78000 Versailles', '01 04 70 13 38', 'MAAF', '2018-03-07'),
('55', 'Falla', 'Alejandro', '37 rue Tournefort, 78310 Maurepas', '01 55 54 12 55', 'MGEN', '2018-03-08'),
('56', 'Monaco', 'Juan', '16 place Richelme, 78530 Buc', '01 27 37 25 94', 'MMA', '2018-03-08'),
('60', 'Hernandez', 'Oscar', '2 rue Ganay, 78770 Auteuil', '01 96 53 11 31', 'CNAMTS', '2018-03-09'),
('61', 'Gonzalez', 'Fernando', '20 Bd. du Roi Rene, 78120 Rambouillet', '01 18 71 36 73', 'CCVRP', '2018-03-09'),
('63', 'Peer', 'Shahar', '41 place de L\'Universite, 78300 Poissy', '01 42 62 79 73', 'MNFTC', '2018-03-10'),
('65', 'Craybas', 'Jill', '49 rue Victor Leydet, 78000 Versailles', '01 13 71 28 05', 'MAS', '2018-03-10'),
('66', 'Cibulkova', 'Dominika', '42 rue Clovis Hugues, 78000 Versailles', '01 54 53 79 30', 'AG2R', '2018-03-11'),
('67', 'Errani', 'Sara', '53 rue Monclar, 78430 Louveciennes', '01 92 61 05 20', 'MGSP', '2018-03-11'),
('68', 'Sequera', 'Milagros', '8 rue d\'Arpille, 78300 Poissy', '01 92 31 76 31', 'MNAM', '2018-03-13'),
('70', 'Tipsarevic', 'Janko', '20 rue Jaubert, 78660 Ablis', '01 23 47 77 96', 'LMDE', '2018-03-13'),
('72', 'Peng', 'Shuai', '70 place Forbin, 78120 Rambouillet', '01 66 43 42 66', 'MNH', '2018-03-14'),
('74', 'Capdeville', 'Paul', '41 rue Clemenceau, 78120 Rambouillet', '01 20 72 05 93', 'MAAF', '2018-03-14'),
('75', 'Gulbis', 'Ernests', '46 rue Mejanes, 78000 Versailles', '01 96 37 01 55', 'MGEN', '2018-03-15'),
('76', 'Govortsova', 'Olga', '3 place Ganay, 78120 Rambouillet', '01 77 58 44 41', 'MMA', '2018-03-15'),
('77', 'Obziler', 'Tzipora', '19 Chemin Robert, 78310 Maurepas', '01 35 71 31 74', 'CNAMTS', '2018-03-15'),
('78', 'Kanepi', 'Kaia', '7 place d\'Armenie, 78990 Elancourt', '01 17 73 18 65', 'CCVRP', '2018-03-16'),
('79', 'Knapp', 'Karin', '37 rue des Magnans, 78310 Maurepas', '01 83 73 09 05', 'MNFTC', '2018-03-16'),
('81', 'Wozniacki', 'Caroline', '64 cours d\'Orbitelle, 78310 Maurepas', '01 77 58 00 64', 'MAS', '2018-03-17'),
('90', 'Meusburger', 'Yvonne', '13 rue des Guerriers, 78770 Auteuil', '01 43 62 13 66', 'AG2R', '2018-03-18'),
('91', 'Brzezicki', 'Juan Pablo', '17 Av. des Belges, 78300 Poissy', '01 28 51 35 65', 'MGSP', '2018-03-18'),
('92', 'Massu', 'Nicolas', '23 allee Rufinus, 78000 Versailles', '01 28 70 11 63', 'MNAM', '2018-03-20'),
('100', 'Verdasco', 'Fernando', '55 rue des Etuves, 78990 Elancourt', '01 64 47 37 26', 'LMDE', '2018-03-20'),
('101', 'Melzer', 'Jurgen', '44 rue Matheron, 78660 Ablis', '01 91 43 51 66', 'MNH', '2018-03-21'),
('102', 'Poutchkova', 'Olga', '7 rue des Gondraux, 78000 Versailles', '01 03 71 02 73', 'MAAF', '2018-03-21'),
('103', 'Mahut', 'Nicolas', '67 Av. du Parc, 78000 Versailles', '01 14 71 01 26', 'MNAM', '2018-03-22'),
('104', 'Davydenko', 'Nikolay', '34 rue des Tanneurs, 78770 Auteuil', '01 91 43 35 67', 'LMDE', '2018-03-23'),
('105', 'Tursunov', 'Dmitry', '58 rue Nazareth, 78870 Bailly', '01 15 45 22 98', 'MNH', '2018-03-24'),
('107', 'Azarenka', 'Victoria', '48 rue Merindol, 78990 Elancourt', '01 14 71 79 67', 'MAAF', '2018-03-24'),
('108', 'Muller', 'Martina', '5 rue Gibelin, 78112 Fourqueux', '01 16 71 12 54', 'MGEN', '2018-03-25'),
('109', 'Calleri', 'Agustin', '21 rue du Bon Pasteur, 78300 Poissy', '01 52 53 11 55', 'MMA', '2018-03-25'),
('117', 'Ascione', 'Thierry', '31 cours Sextius, 78240 Chambourcy', '01 57 31 38 89', 'CNAMTS', '2018-03-26'),
('119', 'Schiavone', 'Francesca', '28 rue Saint Joseph, 78310 Maurepas', '01 89 61 00 41', 'CCVRP', '2018-03-26'),
('120', 'Malek', 'Tatjana', '13 place Ramus, 78000 Versailles', '01 81 53 12 57', 'MNFTC', '2018-03-26'),
('121', 'Eschauer', 'Werner', '36 rue Thiers, 78430 Louveciennes', '01 23 47 11 54', 'MAS', '2018-03-27'),
('123', 'Vesnina', 'Elena', '51 cours Mirabeau, 78112 Fourqueux', '01 94 70 38 67', 'AG2R', '2018-03-27'),
('124', 'Russell', 'Michael', '31 rue du Cancel, 78112 Fourqueux', '01 14 71 09 56', 'MGSP', '2018-03-28'),
('128', 'Srebotnik', 'Katarina', '45 rue Venel, 78000 Versailles', '01 35 71 87 41', 'MNAM', '2018-03-28'),
('133', 'Jankovic', 'Jelena', '13 rue de l\'Aumonerie, 78990 Elancourt', '01 45 28 36 86', 'LMDE', '2018-03-28'),
('137', 'Berlocq', 'Carlos', '49 rue Mignet, 78310 Maurepas', '01 48 71 38 67', 'MNH', '2018-03-29'),
('138', 'Morigami', 'Akiko', '14 Av. Giuseppe Verdi, 78990 Elancourt', '01 28 47 97 93', 'MAAF', '2018-03-29'),
('145', 'Dushevina', 'Vera', '11 Av. Grassi, 78280 Guyancourt', '01 44 39 39 68', 'MGEN', '2018-03-30'),
('146', 'Mirza', 'Sania', '37 rue Chabrier, 78870 Bailly', '01 18 71 19 26', 'MMA', '2018-03-30'),
('147', 'Ditty', 'Julie', '71 rue Pavillon, 78990 Elancourt', '01 25 71 23 10', 'CNAMTS', '2018-03-31'),
('148', 'Dellacqua', 'Casey', '38 Av. Malherbe, 78530 Buc', '01 96 37 79 10', 'CCVRP', '2018-03-31'),
('149', 'Acasuso', 'Jose', '16 rue Bedarrides, 78660 Ablis', '01 01 70 79 73', 'MNFTC', '2018-04-01'),
('153', 'Youzhny', 'Mikhail', '48 Av. Victor Hugo, 78130 Les Mureaux', '01 72 59 02 57', 'MAS', '2018-04-01'),
('154', 'Seppi', 'Andreas', '62 rue du Onze Novembre, 78300 Poissy', '01 14 71 00 77', 'AG2R', '2018-04-02'),
('158', 'Shvedova', 'Yaroslava', '60 rue des Nobles, 78120 Rambouillet', '01 21 47 10 64', 'MGSP', '2018-04-03'),
('159', 'Vakulenko', 'Julia', '19 Av. Benjamin Abram, 78530 Buc', '01 19 71 12 10', 'MNAM', '2018-04-03'),
('164', 'Krajicek', 'Michaella', '25 rue Saint Henri, 78310 Maurepas', '01 25 71 10 92', 'LMDE', '2018-04-04'),
('166', 'Nakamura', 'Aiko', '45 rue Mazarine, 78430 Louveciennes', '01 08 70 56 87', 'MNH', '2018-04-04'),
('167', 'Santangelo', 'Mara', '15 impasse Reynaud, 78310 Maurepas', '01 03 70 01 25', 'MAAF', '2018-04-04'),
('168', 'Bondarenko', 'Kateryna', '36 rue Celony, 78630 Orgeval', '01 95 70 00 05', 'MGEN', '2018-04-05'),
('171', 'Pashanski', 'Boris', '30 rue Campra, 78630 Orgeval', '01 15 35 71 91', 'MMA', '2018-04-05'),
('172', 'Karlovic', 'Ivo', '17 rue Rifle Rafle, 78112 Fourqueux', '01 55 52 37 64', 'CNAMTS', '2018-04-06'),
('175', 'Dancevic', 'Frank', '27 rue de Lacepede, 78000 Versailles', '01 54 53 76 92', 'CCVRP', '2018-04-06'),
('181', 'Robredo', 'Tommy', '49 rue Emeric David, 78870 Bailly', '01 94 70 00 05', 'MNFTC', '2018-04-07'),
('182', 'Petrova', 'Nadia', '30 rue Sallier, 78000 Versailles', '01 28 51 33 93', 'MAS', '2018-04-08'),
('184', 'Bondarenko', 'Alona', '72 rue Peyresc, 78130 Les Mureaux', '01 71 47 72 26', 'AG2R', '2018-04-08'),
('187', 'Garbin', 'Tathiana', '66 rue de la Fonderie, 78630 Orgeval', '01 17 37 13 54', 'MGSP', '2018-04-09'),
('188', 'Vanek', 'Jiri', '14 rue des Bagniers, 78240 Chambourcy', '01 51 52 38 93', 'MNAM', '2018-04-10'),
('190', 'Petkovic', 'Andrea', '18 rue Riquier, 78190 Trappes', '01 55 52 39 65', 'LMDE', '2018-04-10'),
('191', 'Chan', 'Yung-Jan', '65 rue Papassaudi, 78190 Trappes', '01 82 53 39 63', 'MNH', '2018-04-11'),
('192', 'Luczak', 'Peter', '39 rue Manuel, 78000 Versailles', '01 96 37 48 73', 'MAAF', '2018-04-12');

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `code` char(3) NOT NULL,
  `nom_service` varchar(30) NOT NULL,
  `batiment` char(1) NOT NULL,
  `directeur` decimal(4,0) DEFAULT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `nom` (`nom_service`),
  KEY `directeur` (`directeur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`code`, `nom_service`, `batiment`, `directeur`) VALUES
('REA', 'Reanimation et Traumatologie', 'A', '19'),
('CHG', 'Chirurgie generale', 'A', '34'),
('CAR', 'Cardiologie', 'B', '80');

-- --------------------------------------------------------

--
-- Structure de la table `soigne`
--

DROP TABLE IF EXISTS `soigne`;
CREATE TABLE IF NOT EXISTS `soigne` (
  `no_docteur` decimal(4,0) NOT NULL,
  `no_malade` decimal(4,0) NOT NULL,
  PRIMARY KEY (`no_docteur`,`no_malade`),
  KEY `no_malade` (`no_malade`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `soigne`
--

INSERT INTO `soigne` (`no_docteur`, `no_malade`) VALUES
('4', '13'),
('4', '23'),
('4', '63'),
('4', '78'),
('4', '81'),
('4', '100'),
('7', '109'),
('7', '119'),
('7', '133'),
('7', '158'),
('7', '175'),
('7', '191'),
('8', '13'),
('8', '23'),
('8', '35'),
('8', '44'),
('10', '14'),
('10', '72'),
('10', '75'),
('10', '76'),
('10', '92'),
('19', '1'),
('19', '21'),
('19', '55'),
('24', '145'),
('24', '147'),
('26', '35'),
('26', '43'),
('26', '61'),
('26', '79'),
('26', '101'),
('27', '121'),
('27', '128'),
('27', '146'),
('27', '164'),
('27', '166'),
('27', '184'),
('31', '103'),
('31', '145'),
('31', '182'),
('34', '6'),
('34', '52'),
('34', '61'),
('34', '65'),
('34', '66'),
('50', '119'),
('50', '138'),
('50', '164'),
('50', '171'),
('50', '181'),
('53', '3'),
('53', '33'),
('53', '46'),
('53', '60'),
('53', '70'),
('53', '90'),
('54', '120'),
('54', '147'),
('64', '21'),
('64', '68'),
('64', '76'),
('80', '74'),
('80', '76'),
('82', '108'),
('82', '117'),
('82', '137'),
('82', '159'),
('85', '1'),
('85', '3'),
('85', '6'),
('85', '43'),
('85', '46'),
('85', '52'),
('85', '76'),
('88', '23'),
('88', '41'),
('88', '52'),
('88', '56'),
('88', '68'),
('88', '77'),
('88', '78'),
('88', '100'),
('89', '103'),
('89', '107'),
('89', '123'),
('89', '137'),
('89', '146'),
('89', '147'),
('89', '182'),
('99', '108'),
('99', '123'),
('99', '172'),
('113', '37'),
('113', '41'),
('113', '44'),
('113', '67'),
('113', '81'),
('113', '102'),
('114', '6'),
('114', '13'),
('114', '36'),
('114', '63'),
('114', '91'),
('122', '70'),
('122', '91'),
('122', '102'),
('126', '3'),
('126', '36'),
('126', '41'),
('126', '74'),
('126', '77'),
('135', '6'),
('135', '21'),
('135', '33'),
('135', '36'),
('135', '55'),
('135', '56'),
('135', '61'),
('135', '68'),
('140', '104'),
('140', '124'),
('140', '148'),
('140', '168'),
('140', '172'),
('140', '187'),
('140', '188'),
('140', '192'),
('141', '105'),
('141', '107'),
('141', '117'),
('141', '128'),
('141', '147'),
('141', '153'),
('141', '171'),
('141', '184'),
('141', '190'),
('144', '108'),
('144', '119'),
('144', '120'),
('144', '145'),
('144', '153'),
('144', '154'),
('144', '159'),
('144', '181'),
('144', '184'),
('144', '192'),
('152', '123'),
('152', '145'),
('152', '149'),
('152', '159'),
('152', '167'),
('179', '105'),
('179', '117'),
('179', '154'),
('179', '192'),
('180', '103'),
('180', '105'),
('180', '172'),
('180', '182'),
('196', '108'),
('196', '117'),
('196', '159'),
('196', '172');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
