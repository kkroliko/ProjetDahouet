-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Mer 08 Novembre 2017 à 08:54
-- Version du serveur :  5.7.20-0ubuntu0.17.04.1
-- Version de PHP :  7.0.22-0ubuntu0.17.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `Dahouet`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Procédure 1` (IN `challenge_id` INT(11))  SELECT c.challenge_nom , AVG(r.regate_distance) AS moyenne
FROM Regate r 
INNER JOIN Challenge c ON r.challenge_id = c.challenge_id
WHERE r.challenge_id = challenge_id
GROUP BY c.challenge_nom$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Procédure 2` (IN `regate_id` INT, IN `voilier_id` INT)  BEGIN

SELECT p.personne_prenom AS PRENOM, 
			p.personne_nom AS NOM 
  FROM personne p
        INNER JOIN participant pa
        ON pa.personne_id = p.personne_id
	    INNER JOIN forme f 
	    ON f.participant_id = pa.participant_id
	    INNER JOIN Equipage e 
	    ON e.equipage_id = f.equipage_id
        INNER JOIN Regate r
        ON r.regate_id = e.regate_id
        INNER JOIN Voilier v
	    ON v.voilier_id = e.voilier_id
       WHERE r.regate_id = regate_id
       AND v.voilier_id = voilier_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Procédure 3` (IN `challenge_datedebut` DATE, IN `challenge_datefin` DATE, IN `challenge_id` INT)  NO SQL
BEGIN

SELECT p.personne_nom AS Nom,
       com.comite_nom AS ComNom,
       r.regate_date AS Date
FROM Challenge c
INNER JOIN Regate r
ON r.challenge_id = c.challenge_id
INNER JOIN resultat re 
ON re.regate_id = r.regate_id
INNER JOIN verifie v 
ON v.resultat_id = re.resultat_id
INNER JOIN commissaire co 
ON co.commissaire_id = v.commissaire_id
INNER JOIN personne p 
ON p.personne_id = co.personne_id
INNER JOIN comité com
ON com.comite_id = co.comite_id
WHERE c.challenge_id = challenge_id
AND r.regate_date > challenge_datedebut
AND r.regate_date < challenge_datefin;

END$$

--
-- Fonctions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `Fonction1` (`challenge_id` INT, `regate_date` DATE) RETURNS VARCHAR(255) CHARSET utf8 NO SQL
BEGIN
DECLARE CodeChallenge VARCHAR(11);
DECLARE MoisRegate DATE;
DECLARE NumRegate INT(11) DEFAULT 0;

SELECT c.challenge_id , regate_date , COUNT(r.regate_id)+1
INTO CodeChallenge, MoisRegate, NumRegate
FROM Challenge c
INNER JOIN Regate r ON c.challenge_id = r.challenge_id
WHERE c.challenge_id = challenge_id

GROUP BY c.challenge_id;

RETURN CONCAT(CodeChallenge, '-' , MONTH(MoisRegate) , '-' , NumRegate);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `Challenge`
--

CREATE TABLE `Challenge` (
  `challenge_id` int(11) NOT NULL,
  `challenge_datedebut` date NOT NULL,
  `challenge_datefin` date NOT NULL,
  `challenge_nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Challenge`
--

INSERT INTO `Challenge` (`challenge_id`, `challenge_datedebut`, `challenge_datefin`, `challenge_nom`) VALUES
(2, '2017-10-01', '2017-10-04', 'le challenge d\'hiver');

-- --------------------------------------------------------

--
-- Structure de la table `Classe`
--

CREATE TABLE `Classe` (
  `classe_nom` varchar(25) NOT NULL,
  `classe_id` int(11) NOT NULL,
  `classe_coef` float NOT NULL,
  `serie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Classe`
--

INSERT INTO `Classe` (`classe_nom`, `classe_id`, `classe_coef`, `serie_id`) VALUES
('Flying Fifteen', 1, 1.1, 1),
('Soling', 2, 1.2, 1),
('Star', 3, 1.3, 1),
('Tempest', 4, 1.4, 1),
('Corsaire', 5, 1.1, 2),
('Maraudeur', 6, 1.2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `club`
--

CREATE TABLE `club` (
  `club_id` int(11) NOT NULL,
  `club_nom` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `club`
--

INSERT INTO `club` (`club_id`, `club_nom`) VALUES
(2, 'YC Val André');

-- --------------------------------------------------------

--
-- Structure de la table `comité`
--

CREATE TABLE `comité` (
  `comite_id` int(11) NOT NULL,
  `comite_nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `comité`
--

INSERT INTO `comité` (`comite_id`, `comite_nom`) VALUES
(2, 'Comité de bretagne');

-- --------------------------------------------------------

--
-- Structure de la table `commissaire`
--

CREATE TABLE `commissaire` (
  `commissaire_id` int(11) NOT NULL,
  `personne_id` int(11) NOT NULL,
  `comite_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commissaire`
--

INSERT INTO `commissaire` (`commissaire_id`, `personne_id`, `comite_id`) VALUES
(1, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Equipage`
--

CREATE TABLE `Equipage` (
  `equipage_id` int(11) NOT NULL,
  `equipage_skipper` tinyint(1) NOT NULL,
  `voilier_id` int(11) DEFAULT NULL,
  `regate_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Equipage`
--

INSERT INTO `Equipage` (`equipage_id`, `equipage_skipper`, `voilier_id`, `regate_id`) VALUES
(1, 1, 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `forme`
--

CREATE TABLE `forme` (
  `participant_id` int(11) NOT NULL,
  `equipage_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `forme`
--

INSERT INTO `forme` (`participant_id`, `equipage_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

CREATE TABLE `participant` (
  `participant_id` int(11) NOT NULL,
  `participant_FFV` tinyint(1) NOT NULL,
  `participant_licence` varchar(25) NOT NULL,
  `participant_licencevalidation` varchar(25) NOT NULL,
  `personne_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `participant`
--

INSERT INTO `participant` (`participant_id`, `participant_FFV`, `participant_licence`, `participant_licencevalidation`, `personne_id`) VALUES
(1, 1, 'Course ifremer', 'Valide', 1);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `personne_id` int(11) NOT NULL,
  `personne_nom` varchar(50) NOT NULL,
  `personne_prenom` varchar(25) NOT NULL,
  `personne_naissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`personne_id`, `personne_nom`, `personne_prenom`, `personne_naissance`) VALUES
(1, 'Krolikowski', 'Konrad', '1994-12-27'),
(2, 'Letroc', 'Pierre', '1989-10-02');

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `proprietaire_id` int(11) NOT NULL,
  `proprietaire_nom` varchar(25) NOT NULL,
  `voilier_id` int(11) DEFAULT NULL,
  `club_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `proprietaire`
--

INSERT INTO `proprietaire` (`proprietaire_id`, `proprietaire_nom`, `voilier_id`, `club_id`) VALUES
(4, 'Marcel Martin', 1, 2),
(5, 'Konrad', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Regate`
--

CREATE TABLE `Regate` (
  `regate_id` int(11) NOT NULL,
  `regate_date` date NOT NULL,
  `regate_nom` varchar(25) NOT NULL,
  `regate_distance` float NOT NULL,
  `challenge_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Regate`
--

INSERT INTO `Regate` (`regate_id`, `regate_date`, `regate_nom`, `regate_distance`, `challenge_id`) VALUES
(4, '2017-10-03', 'fdgf', 250.4, 2),
(5, '2017-10-02', 'la regate test', 240.5, 2);

--
-- Déclencheurs `Regate`
--
DELIMITER $$
CREATE TRIGGER `Trigger de création` BEFORE INSERT ON `Regate` FOR EACH ROW BEGIN
DECLARE challengedebut DATE;
DECLARE challengefin DATE;
SELECT challenge_datedebut , challenge_datefin
INTO challengedebut, challengefin
FROM Challenge
WHERE challenge_id = NEW.challenge_id;
IF NEW.regate_date < challengedebut OR NEW.regate_date > challengefin THEN 
   SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La date nest pas bonne', MYSQL_ERRNO= '45000';
 
END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `Trigger de suppression` AFTER DELETE ON `Regate` FOR EACH ROW BEGIN
DECLARE challengefin DATE;
SELECT challenge_datefin
INTO challengefin
FROM Challenge
WHERE challenge_id = OLD.challenge_id;
IF OLD.regate_date < challengefin
THEN
SIGNAL SQLSTATE '45002' SET MESSAGE_TEXT = ' Le challenge nest pas terminé ' , MYSQL_ERRNO = '45002';
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `resultat`
--

CREATE TABLE `resultat` (
  `resultat_id` int(11) NOT NULL,
  `resultat_tempsreel` float NOT NULL,
  `resultat_tempscompose` float NOT NULL,
  `regate_id` int(11) DEFAULT NULL,
  `placement` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `resultat`
--

INSERT INTO `resultat` (`resultat_id`, `resultat_tempsreel`, `resultat_tempscompose`, `regate_id`, `placement`) VALUES
(2, 1.2, 1.1, 4, 1);

--
-- Déclencheurs `resultat`
--
DELIMITER $$
CREATE TRIGGER `Triggers de mise a jour` BEFORE UPDATE ON `resultat` FOR EACH ROW BEGIN
DECLARE totalparticipant INT;
SELECT COUNT(equipage_id)
INTO totalparticipant
FROM resultat
WHERE regate_id = NEW.regate_id;
IF NEW.placement > totalparticipant
THEN
    SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = 'Erreur, la place du voilier est supérieur au nombre de participants', 
    MYSQL_ERRNO= '45001';
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `serie`
--

CREATE TABLE `serie` (
  `serie_id` int(11) NOT NULL,
  `serie_nom` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `serie`
--

INSERT INTO `serie` (`serie_id`, `serie_nom`) VALUES
(1, 'Quillards de sport'),
(2, 'Habitables');

-- --------------------------------------------------------

--
-- Structure de la table `verifie`
--

CREATE TABLE `verifie` (
  `commissaire_id` int(11) NOT NULL,
  `resultat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `verifie`
--

INSERT INTO `verifie` (`commissaire_id`, `resultat_id`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Voilier`
--

CREATE TABLE `Voilier` (
  `voilier_id` int(11) NOT NULL,
  `voilier_numVoile` int(11) NOT NULL,
  `classe_id` int(11) DEFAULT NULL,
  `voilier_nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Voilier`
--

INSERT INTO `Voilier` (`voilier_id`, `voilier_numVoile`, `classe_id`, `voilier_nom`) VALUES
(1, 7, 4, 'Mauraudeur A'),
(2, 4, 5, 'Lesupervoilier'),
(3, 9, 4, 'Voilier A');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Challenge`
--
ALTER TABLE `Challenge`
  ADD PRIMARY KEY (`challenge_id`);

--
-- Index pour la table `Classe`
--
ALTER TABLE `Classe`
  ADD PRIMARY KEY (`classe_id`),
  ADD KEY `FK_Classe_serie_id` (`serie_id`);

--
-- Index pour la table `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`club_id`);

--
-- Index pour la table `comité`
--
ALTER TABLE `comité`
  ADD PRIMARY KEY (`comite_id`);

--
-- Index pour la table `commissaire`
--
ALTER TABLE `commissaire`
  ADD PRIMARY KEY (`commissaire_id`,`personne_id`),
  ADD KEY `FK_commissaire_personne_id` (`personne_id`),
  ADD KEY `FK_commissaire_comité_id` (`comite_id`);

--
-- Index pour la table `Equipage`
--
ALTER TABLE `Equipage`
  ADD PRIMARY KEY (`equipage_id`),
  ADD KEY `FK_Equipage_voilier_id` (`voilier_id`),
  ADD KEY `FK_Equipage_regate_id` (`regate_id`);

--
-- Index pour la table `forme`
--
ALTER TABLE `forme`
  ADD PRIMARY KEY (`participant_id`,`equipage_id`),
  ADD KEY `FK_forme_equipage_id` (`equipage_id`);

--
-- Index pour la table `participant`
--
ALTER TABLE `participant`
  ADD PRIMARY KEY (`participant_id`,`personne_id`),
  ADD KEY `FK_participant_personne_id` (`personne_id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`personne_id`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`proprietaire_id`),
  ADD KEY `FK_proprietaire_voilier_id` (`voilier_id`),
  ADD KEY `FK_proprietaire_club_id` (`club_id`);

--
-- Index pour la table `Regate`
--
ALTER TABLE `Regate`
  ADD PRIMARY KEY (`regate_id`),
  ADD KEY `FK_Regate_challenge_id` (`challenge_id`);

--
-- Index pour la table `resultat`
--
ALTER TABLE `resultat`
  ADD PRIMARY KEY (`resultat_id`),
  ADD KEY `FK_resultat_regate_id` (`regate_id`);

--
-- Index pour la table `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`serie_id`);

--
-- Index pour la table `verifie`
--
ALTER TABLE `verifie`
  ADD PRIMARY KEY (`commissaire_id`,`resultat_id`),
  ADD KEY `FK_verifie_resultat_id` (`resultat_id`);

--
-- Index pour la table `Voilier`
--
ALTER TABLE `Voilier`
  ADD PRIMARY KEY (`voilier_id`),
  ADD KEY `FK_Voilier_classe_id` (`classe_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Challenge`
--
ALTER TABLE `Challenge`
  MODIFY `challenge_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Classe`
--
ALTER TABLE `Classe`
  MODIFY `classe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `club`
--
ALTER TABLE `club`
  MODIFY `club_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `comité`
--
ALTER TABLE `comité`
  MODIFY `comite_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `commissaire`
--
ALTER TABLE `commissaire`
  MODIFY `commissaire_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Equipage`
--
ALTER TABLE `Equipage`
  MODIFY `equipage_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `participant`
--
ALTER TABLE `participant`
  MODIFY `participant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `personne_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `proprietaire_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `Regate`
--
ALTER TABLE `Regate`
  MODIFY `regate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `resultat`
--
ALTER TABLE `resultat`
  MODIFY `resultat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `serie`
--
ALTER TABLE `serie`
  MODIFY `serie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Voilier`
--
ALTER TABLE `Voilier`
  MODIFY `voilier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Classe`
--
ALTER TABLE `Classe`
  ADD CONSTRAINT `FK_Classe_serie_id` FOREIGN KEY (`serie_id`) REFERENCES `serie` (`serie_id`);

--
-- Contraintes pour la table `commissaire`
--
ALTER TABLE `commissaire`
  ADD CONSTRAINT `FK_commissaire_comité_id` FOREIGN KEY (`comite_id`) REFERENCES `comité` (`comite_id`),
  ADD CONSTRAINT `FK_commissaire_personne_id` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`);

--
-- Contraintes pour la table `Equipage`
--
ALTER TABLE `Equipage`
  ADD CONSTRAINT `FK_Equipage_regate_id` FOREIGN KEY (`regate_id`) REFERENCES `Regate` (`regate_id`),
  ADD CONSTRAINT `FK_Equipage_voilier_id` FOREIGN KEY (`voilier_id`) REFERENCES `Voilier` (`voilier_id`);

--
-- Contraintes pour la table `forme`
--
ALTER TABLE `forme`
  ADD CONSTRAINT `FK_forme_equipage_id` FOREIGN KEY (`equipage_id`) REFERENCES `Equipage` (`equipage_id`),
  ADD CONSTRAINT `FK_forme_participant_id` FOREIGN KEY (`participant_id`) REFERENCES `participant` (`participant_id`);

--
-- Contraintes pour la table `participant`
--
ALTER TABLE `participant`
  ADD CONSTRAINT `FK_participant_personne_id` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`);

--
-- Contraintes pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD CONSTRAINT `FK_proprietaire_club_id` FOREIGN KEY (`club_id`) REFERENCES `club` (`club_id`),
  ADD CONSTRAINT `FK_proprietaire_voilier_id` FOREIGN KEY (`voilier_id`) REFERENCES `Voilier` (`voilier_id`);

--
-- Contraintes pour la table `Regate`
--
ALTER TABLE `Regate`
  ADD CONSTRAINT `FK_Regate_challenge_id` FOREIGN KEY (`challenge_id`) REFERENCES `Challenge` (`challenge_id`);

--
-- Contraintes pour la table `resultat`
--
ALTER TABLE `resultat`
  ADD CONSTRAINT `FK_resultat_regate_id` FOREIGN KEY (`regate_id`) REFERENCES `Regate` (`regate_id`);

--
-- Contraintes pour la table `verifie`
--
ALTER TABLE `verifie`
  ADD CONSTRAINT `FK_verifie_commissaire_id` FOREIGN KEY (`commissaire_id`) REFERENCES `commissaire` (`commissaire_id`),
  ADD CONSTRAINT `FK_verifie_resultat_id` FOREIGN KEY (`resultat_id`) REFERENCES `resultat` (`resultat_id`);

--
-- Contraintes pour la table `Voilier`
--
ALTER TABLE `Voilier`
  ADD CONSTRAINT `FK_Voilier_classe_id` FOREIGN KEY (`classe_id`) REFERENCES `Classe` (`classe_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
