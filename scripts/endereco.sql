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
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `logradouro` varchar(50) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `complemento` varchar(50) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `pais` varchar(20) NOT NULL,
  `uf` char(2) NOT NULL,
  `cidade` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `logradouro`, `numero`, `complemento`, `cep`, `bairro`, `pais`, `uf`, `cidade`) VALUES
(1, 'Av. Maria Coelho Aguiar', '215', '', '05805000', 'Jd Sao Luis', 'Brasil', 'SP', 'SAO PAULO'),
(2, 'Estr. Kizaemon Takeuti', '1300', '', '06775000', 'Jd Clementino', 'Brasil', 'SP', 'TABOAO DA SERRA'),
(3, 'Av. Giovanni Gronchi', '5819', 'Shopping Jardim Sul', '05724003', 'Vila Andrade', 'Brasil', 'SP', 'SAO PAULO'),
(4, ' Rodovia Hélio Smidt', '', 'Aeroporto de Guarulhos', '07190100', 'Cumbica', 'Brasil', 'SP', 'GUARULHOS'),
(5, 'Rod. Raposo Tavares', '23500', 'Piso G1', '05577000', 'Lageadinho', 'Brasil', 'SP', 'COTIA'),
(6, 'Av. Gonçalo Madeira', '100 ', '', '05348000', 'Jaguare', 'Brasil', 'SP', 'SAO PAULO'),
(7, 'Estrada São Paulo-Mogi', '1709', '', '08573070', 'Vila Virginia', 'Brasil', 'SP', 'ITAQUAQUECETUBA'),
(8, 'Av. Lucas Nogueira Garcéz', '441', '', '09750670', 'Centro', 'Brasil', 'SP', 'SAO BERNARDO DO CAMPO'),
(9, 'Av. Dom Pedro II', '1909', '', '09080111', 'Campestre', 'Brasil', 'SP', 'SAO ANDRE'),
(10, 'R. Alagoas', '41', '', '09521060', 'Centro', 'Brasil', 'SP', 'SAO CAETANO DO SUL');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
