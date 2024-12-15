-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2024 at 10:54 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnik_id` int(11) NOT NULL,
  `ime_i_prezime` varchar(64) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `datum_rodjenja` varchar(45) NOT NULL,
  `stanje_racuna` bigint(20) DEFAULT NULL,
  `kolicina_potrosenog_novca` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnik_id`, `ime_i_prezime`, `username`, `password`, `email`, `datum_rodjenja`, `stanje_racuna`, `kolicina_potrosenog_novca`) VALUES
(1, 'danilo radosavljevic', 'danilor', '1234', 'radosavljevicdanilo333@gmail.com', '13.01.2002.', 500, 0),
(15, 'Petar Petrovic', 'pera', 'sifra123', 'pera@example.com', '1990-05-15', 3500, 6700),
(16, 'Petar Petrovic', 'perayy', 'sifra123', 'pera@example.com', '1990-05-15', 5000, 200),
(17, 'Petar Petrovic', 'peraasdsadyy', 'sifra123', 'pera@example.com', '1990-05-15', 5000, 200),
(21, 'neko drugi', 'dadsadsanilor', 'sasdasdas', 'nekodrugi@gmail.com', '13.01.2002.', 500, 0),
(22, 'Test Testovic', 'testovic', 'sifra123445', 'test@example.com', '1994-05-15', 2000, 0),
(23, 'test testovic', 'testuser1', 'testpassword', 'test@testmail.com', '1.1.2001.', 3500, 1500);

-- --------------------------------------------------------

--
-- Table structure for table `kupovina`
--

CREATE TABLE `kupovina` (
  `kupovina_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `proizvod_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `kupovina`
--

INSERT INTO `kupovina` (`kupovina_id`, `korisnik_id`, `proizvod_id`) VALUES
(1, 15, 1),
(2, 15, 2),
(3, 23, 2);

-- --------------------------------------------------------

--
-- Table structure for table `podesavanje_pretrage`
--

CREATE TABLE `podesavanje_pretrage` (
  `podesavanje_pretrage_id` int(11) NOT NULL,
  `donja_granica_obima_cene` bigint(20) DEFAULT NULL,
  `gornja_granica_obima_cene` bigint(20) DEFAULT NULL,
  `vrsta_opreme` varchar(64) DEFAULT NULL,
  `kljucna_rec` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pretraga`
--

CREATE TABLE `pretraga` (
  `pretraga_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `podesevanje_pretrage_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `proizvod`
--

CREATE TABLE `proizvod` (
  `proizvod_id` int(11) NOT NULL,
  `naziv` varchar(88) NOT NULL,
  `cena` bigint(20) NOT NULL,
  `vrsta_opreme` varchar(64) NOT NULL,
  `stanje_na_lageru` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `proizvod`
--

INSERT INTO `proizvod` (`proizvod_id`, `naziv`, `cena`, `vrsta_opreme`, `stanje_na_lageru`) VALUES
(1, 'GTX 1650TI', 5000, 'Graficka kartica', 2),
(2, 'AMD Athlon II X3', 1500, 'Procesor', 1),
(3, 'Gembird JPD-Wireless-Thrillershock ', 10000, 'dzojstik', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`korisnik_id`);

--
-- Indexes for table `kupovina`
--
ALTER TABLE `kupovina`
  ADD PRIMARY KEY (`kupovina_id`),
  ADD KEY `korisnik_id_idx` (`korisnik_id`),
  ADD KEY `proizvod_id_idx` (`proizvod_id`);

--
-- Indexes for table `podesavanje_pretrage`
--
ALTER TABLE `podesavanje_pretrage`
  ADD PRIMARY KEY (`podesavanje_pretrage_id`);

--
-- Indexes for table `pretraga`
--
ALTER TABLE `pretraga`
  ADD PRIMARY KEY (`pretraga_id`),
  ADD KEY `podesavanje_pretrage_id_idx` (`podesevanje_pretrage_id`),
  ADD KEY `korisnik_id_idx` (`korisnik_id`);

--
-- Indexes for table `proizvod`
--
ALTER TABLE `proizvod`
  ADD PRIMARY KEY (`proizvod_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `korisnik_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `kupovina`
--
ALTER TABLE `kupovina`
  MODIFY `kupovina_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `podesavanje_pretrage`
--
ALTER TABLE `podesavanje_pretrage`
  MODIFY `podesavanje_pretrage_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pretraga`
--
ALTER TABLE `pretraga`
  MODIFY `pretraga_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `proizvod`
--
ALTER TABLE `proizvod`
  MODIFY `proizvod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kupovina`
--
ALTER TABLE `kupovina`
  ADD CONSTRAINT `fk_kupovina_korisnik` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_kupovina_proizvod` FOREIGN KEY (`proizvod_id`) REFERENCES `proizvod` (`proizvod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pretraga`
--
ALTER TABLE `pretraga`
  ADD CONSTRAINT `fk_pretraga_korisnik` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pretraga_podesavanje_pretrage` FOREIGN KEY (`podesevanje_pretrage_id`) REFERENCES `podesavanje_pretrage` (`podesavanje_pretrage_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
