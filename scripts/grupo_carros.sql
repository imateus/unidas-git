-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04-Nov-2018 às 23:45
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
-- Estrutura da tabela `grupo_carros`
--

CREATE TABLE `grupo_carros` (
  `id` int(10) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `descricao` varchar(150) NOT NULL,
  `grupo` varchar(50) NOT NULL,
  `carros` varchar(150) NOT NULL,
  `motor` varchar(50) NOT NULL,
  `qtd_portas` int(10) NOT NULL,
  `arcondicionado` tinyint(1) NOT NULL,
  `qtd_lugares` int(10) NOT NULL,
  `airbag` tinyint(1) NOT NULL,
  `transmissao_automatica` tinyint(1) NOT NULL,
  `observacao` varchar(300) NOT NULL,
  `foto` varchar(300) NOT NULL,
  `direcao_hidraulica` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `grupo_carros`
--

INSERT INTO `grupo_carros` (`id`, `categoria`, `descricao`, `grupo`, `carros`, `motor`, `qtd_portas`, `arcondicionado`, `qtd_lugares`, `airbag`, `transmissao_automatica`, `observacao`, `foto`, `direcao_hidraulica`) VALUES
(0, '1', 'Hatch Médio Plus 1.2', 'BM', 'Peugeot 208 | Toyota Etios | Citroën C3 | ou similares', '1.2', 5, 1, 5, 1, 0, 'Se você procura uma ótima relação custo-benefício, esse é seu grupo. Opções como Toyota Etios, Peugeot 208 e o Citroën C3 vão deixar suas viagens muito mais tranquilas e confortáveis. Ideal para quem não abre mão de dirigir com conforto, mas preza pela economia.', 'https://www.unidas.com.br/media/2065/aluguel-de-carros-grupo-bm-peugeot208.png0', 1),
(0, '1', 'Hatch Compacto 1.0', 'AM', 'Renault KWID | Fiat Mobi | ou similares', '1.0', 5, 1, 5, 1, 0, 'Os carros Hatch Compacto são práticos, econômicos e conectados com seu dia a dia. Como o Renault KWID, por exemplo, um carro completo, motor 1.0, com ar-condicionado, cheio de personalidade para você explorar a cidade ou fugir dela.', 'https://www.unidas.com.br/media/2062/aluguel-de-carros-grupo-am-renault-kwid.png', 1),
(0, '1', 'Hatch Médio 1.0', 'B', 'Fiat Argo | Chevrolet Onix | Renault Sandero | ou similares', '1.0', 5, 1, 5, 1, 0, 'Aqui economia com conforto é item de série. Nesse grupo, você encontra opções de veículos confortáveis e econômicos. Como o Chevrolet Onix, Fiat Argo. Ideal para quem procura um carro moderno e cheio de estilo para suas aventuras, ou praticidade e conforto para uma viagem rápida de negócios.', 'https://www.unidas.com.br/media/2064/aluguel-de-carros-grupo-b-fiat-argo.png', 1),
(0, '1', 'Sedan Médio 1.0', 'BS', 'Nissan Versa | Renault Logan | Ford KA+ | ou similares', '1.0', 5, 1, 5, 1, 0, 'O grupo é composto por veículos sedã com motorização 1.0, ideias para quem busca espaço e conforto, aliado a economia. Vai viajar com sua família ou em um grupo de amigos? O porta-malas tem espaço de sobra para vocês!', 'https://www.unidas.com.br/media/2059/aluguel-de-carro-grupo-bs-nissan-versa.png', 1),
(0, '2', 'Sedan Médio 1.4', 'C', 'Chevrolet Prisma | Toyota Etios Sedan | Hyundai HB20 Sedan | ou similares', '1.4', 5, 1, 5, 1, 0, 'Se você procura mais performance nas suas viagens, com mais espaço, aqui tem ótimas opções de sedans compactos, como o Ford Ka Sedan e o Chevrolet Prisma. Veículos a partir de 1.4 e porta-malas com mais espaço. Os fãs de conforto e tecnologia vão amar.', 'https://www.unidas.com.br/media/2066/aluguel-de-carros-grupo-c-chevrolet-prisma.png', 1),
(0, '2', 'Hatch Médio 1.4', 'E', 'Hyundai HB20 | Ford Ka | Chevrolet Onix | ou similares', '1.4', 5, 1, 5, 1, 0, 'Aqui você vai encontrar opções de carros com design moderno e refinado, como o HB20 e o Ford Ka. Veículos com motorização a partir de 1.4, eles encaram qualquer desafio da cidade e não deixam a desejar em nada nas suas viagens.', 'https://www.unidas.com.br/media/2061/aluguel-de-carro-grupo-e-hyundai-hb20.png', 1),
(0, '2', 'Sedan Médio AT', 'CA', 'Nissan Versa | Toyota Etios Sedan | ou similares', '1.4', 5, 1, 5, 1, 1, 'Quer mais performance sem gastos excessivos? Carros com motorização a partir de 1.4, nesse grupo você encontra opções de sedans automáticos com muita tecnologia, espaço interno e performance. Com o Nissan Versa e o Etios Sedan, suas viagens vão ser muito mais tranquilas.', 'https://www.unidas.com.br/media/2060/aluguel-de-carro-grupo-ca-nissan-versa.png', 1),
(0, '3', 'Sedan Luxo AT', 'SL', 'Audi A4 | Audi A5', '1.8', 5, 1, 5, 1, 1, 'Nesse grupo, você encontra de tudo: esportividade, conforto, tecnologia, luxo, sendo o design o principal atrativo. Alugue o Audi A4 e A5 com motorização a partir de 1.8 e tenha uma sensação inesquecível ao dirigir.', 'https://www.unidas.com.br/media/2073/aluguel-de-carros-grupo-sl-audia4-min.png', 1),
(0, '3', 'Sedan Executivo AT', 'AT', 'Toyota Corolla | Nissan Sentra | ou similares', '1.8', 5, 1, 5, 1, 1, 'São muitos motivos para alugar um carro desse grupo. Ótima dirigibilidade, desempenho, segurança, conforto, tecnologia e muitos mais. Carros como o Nissan Sentra, Toyota Corolla, com motorização a partir de 1.8, vão fazer das suas viagens uma experiência única em conforto.', 'https://www.unidas.com.br/media/2063/aluguel-de-carros-grupo-at-toyotaocorolla.png', 1),
(0, '3', 'Luxo AT', 'LX', 'Ford Fusion Ecoboost', '2.0', 5, 1, 5, 1, 1, '', 'https://www.unidas.com.br/media/2071/aluguel-de-carros-grupo-lx-ford-fusion.png', 1),
(0, '4', 'SUV Manual', 'SM', 'Jeep Renegade | Nissan Kicks | Renault Duster | ou similares', '1.6', 5, 1, 5, 1, 0, 'Aqui você encontra eficiência e desempenho para qualquer desafio. Esportivos luxuosos como Jeep Renegade, Renault Duster e Ford Ecosport, com motorização a partir de 1.6, estão nesse grupo esperando você para uma aventura emocionante.', 'https://www.unidas.com.br/media/2074/aluguel-de-carros-grupo-sm-jeep-renegade.png', 1),
(0, '4', 'SUV AT', 'SV', 'Nissan Kicks | Renault Captur | Ford Ecosport | ou similares', '1.6', 5, 1, 5, 1, 1, 'Espaço, conforto e inovação. Desbrave a cidade com um SUV automático perfeito para otimizar o conforto em suas viagens mais longas. Aqui você encontra opções como o Nissan Kicks, Renault Duster e Ford Ecosport, com motorização a partir de 2.0 e amplo espaço no porta-malas.', 'https://www.unidas.com.br/media/2076/aluguel-de-carros-grupo-sv-nissan-kicks.png', 1),
(0, '4', 'SUV Luxo AT', 'SG', 'Jeep Compass', '2.0', 5, 1, 5, 1, 1, '', 'https://www.unidas.com.br/media/2085/aluguel-de-carros-grupo-sg-jeep-compass.png', 1),
(0, '4', 'SUV Premium', 'SP', 'Audi Q3', '1.4', 5, 1, 5, 1, 1, 'O conforto de um modelo espaçoso bom para qualquer viagem. O SUV automático moderno, ágil que oferece mais potência e eficiência para você dirigir. Alugue o Audi Q3 com motor 1.4 turbo, perfeito para você.', 'https://www.unidas.com.br/media/2086/aluguel-de-carros-grupo-sp-suv-premium-audiq3.png', 1),
(0, '5', 'Picape Luxo AT C.Dupla', 'T', 'Fiat Toro | Renault Duster Oroch | ou similares', '1.8', 5, 1, 5, 1, 1, 'Procura um carro para infinitas possibilidades? Aqui você encontra a Fiat Toro, uma picape utilitária esportiva de luxo, motores a partir de 1.8, com transmissão automática para curtir sua viagem com mais liberdade.', 'https://www.unidas.com.br/media/2077/aluguel-de-carros-grupo-t-fiat-toro.png', 1),
(0, '5', 'Furgão', 'CG', 'Fiat Fiorino | Renault Kangoo', '1.4', 5, 1, 5, 1, 0, 'Aqui você encontra opções de furgões com mais robustez e versatilidade. Alugue o Fiat Fiorino e o Renault Kangoo com motor a partir de 1.4 e porta traseira, e leve muito mais carga.', 'https://www.unidas.com.br/media/2067/aluguel-de-carros-grupo-cg-fiat-fiorino.png', 1),
(0, '5', 'Picape Compacta', 'G1', 'Fiat Strada | Volkswagen Saveiro | Chevrolet Montana | ou similares', '1.4', 5, 1, 5, 1, 0, 'Tudo que você espera de uma picape: potência, robustez, praticidade e muito mais. Alugue aqui a Fiat Strada ou Volkswagen Saveiro com motor 1.4. E esteja preparado para tudo!', 'https://www.unidas.com.br/media/2068/aluguel-de-carros-grupo-g1-fiat-strada.png', 1),
(0, '5', 'Minivan 7 lugares', 'I', 'Fiat Doblo | Chevrolet Spin | ou similares', '1.8', 5, 1, 7, 1, 0, 'Funcionais, versáteis e seguros. Com lugares para até 7 pessoas, as Multivans não deixam ninguém de fora. Alugue o Fiat Doblò ou o Chevrolet Spin, motor a partir de 1.4, e curta sua viagem com toda a família.', 'https://www.unidas.com.br/media/2069/aluguel-de-carros-grupo-i-fiat-doblo.png', 1),
(0, '5', 'Picape Grande 4x4 C.Dupla', 'J', 'Nissan Frontier | Chevrolet S10 | Volkswagen Amarok | ou similares', '2.0', 5, 1, 5, 1, 0, 'Garanta fortes emoções com as picapes 4x4 desse grupo. Com a Nissan Frontier, Volkswagen Amarok e Ford Ranger, você tem mais potência e conforto na mesma viagem. Chegue a qualquer lugar com elas, com a motorização a partir de 2.0.', 'https://www.unidas.com.br/media/2070/aluguel-de-carros-grupo-j-nissan-frontier.png', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
