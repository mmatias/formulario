CREATE TABLE IF NOT EXISTS `comercial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone` varchar(50) NOT NULL,
  `produto` varchar(50) DEFAULT NULL,
  `valor` varchar(50) DEFAULT NULL,
  `quantidade` varchar(50) DEFAULT NULL,
  `data` varchar(50) DEFAULT NULL,
  `produto1` varchar(50) DEFAULT NULL,
  `valor1` varchar(50) DEFAULT NULL,
  `quantidade1` varchar(50) DEFAULT NULL,
  `data1` varchar(50) DEFAULT NULL,
  `produto2` varchar(50) DEFAULT NULL,
  `valor2` varchar(50) DEFAULT NULL,
  `quantidade2` varchar(50) DEFAULT NULL,
  `data2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `financeiro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone` varchar(50) NOT NULL,
  `fatura` varchar(50) DEFAULT NULL,
  `fatura1` varchar(50) DEFAULT NULL,
  `fatura2` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
); 

CREATE TABLE IF NOT EXISTS `suporte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone` varchar(50) NOT NULL,
  `produto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
