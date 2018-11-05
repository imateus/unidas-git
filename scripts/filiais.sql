-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Nov-2018 às 01:01
-- Versão do servidor: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dblea`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `filiais`
--

CREATE TABLE `filiais` (
  `id` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  `aeroporto` tinyint(1) NOT NULL,
  `codigo_unidade` varchar(3) DEFAULT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `filiais`
--

INSERT INTO `filiais` (`id`, `id_endereco`, `aeroporto`, `codigo_unidade`, `nome`) VALUES
(1, 1, 0, '001', 'FILIAL SAO LUIS'),
(2, 2, 0, '002', 'FILIAL CLEMENTINO'),
(3, 3, 0, '003', 'FILIAL SHOP JD SUL'),
(4, 4, 1, '004', 'FILIAL AEROPORTO GUARULHOS'),
(5, 5, 0, '005', 'FILIAL COTIA'),
(6, 6, 0, '006', 'FILIAL JAGUARE'),
(7, 7, 0, '007', 'FILIAL ITAQUAQUECETUBA'),
(8, 8, 0, '008', 'FILIAL SAO BERNARDO DO CAMPO'),
(9, 9, 0, '009', 'FILIAL SAO ANDRE'),
(10, 10, 0, '010', 'FILIAL SAO CAETANO DO SUL');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
