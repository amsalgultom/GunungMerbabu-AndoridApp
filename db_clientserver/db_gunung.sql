-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2020 at 05:40 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_gunung`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_jalur`
--

CREATE TABLE `tb_jalur` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `jarak` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `wilayah` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `image` varchar(300) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_jalur`
--

INSERT INTO `tb_jalur` (`id`, `nama`, `jarak`, `wilayah`, `image`) VALUES
(10, 'Selo', '12 Km', 'Boyolali', ''),
(11, 'Suwanting', '15 Km', 'Magelang', ''),
(12, 'Wekas', '13 Km', 'Magelang', ''),
(13, 'Cunthel', '14 Km', 'Semarang', ''),
(14, 'Thekelan', '16 Km', 'Boyolali', 'http://192.168.1.10/aplikasigunung/uploads/image1594481442602.jpeg'),
(15, 'Selatan', '15 Km', 'Magelang', 'http://192.168.1.10/aplikasigunung/uploads/image1594481393720.jpeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_jalur`
--
ALTER TABLE `tb_jalur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_jalur`
--
ALTER TABLE `tb_jalur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
