

--
-- Banco de dados: `empresa251`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `empregado251`
--

CREATE TABLE `empregado251` (
  `id_empregado` int(11) NOT NULL,
  `nome_empregado` varchar(150) DEFAULT NULL,
  `datanasc_empregado` date DEFAULT NULL,
  `salario_empregado` double DEFAULT NULL,
  `filhos_empregado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `empregado251`
--

INSERT INTO `empregado251` (`id_empregado`, `nome_empregado`, `datanasc_empregado`, `salario_empregado`, `filhos_empregado`) VALUES
(1, 'Joao Da Silva', '2000-10-10', 3500.5, 1),
(2, 'Maria Tereza', '1999-12-12', 3521.2, 2),
(3, 'Joao da Silva', '2000-10-10', 3500.5, 1),
(5, 'Juliana Carla', '2001-10-13', 3525.5, 3),
(6, 'Carlos Alberto ', '1998-02-14', 3890.51, 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `empregado251`
--
ALTER TABLE `empregado251`
  ADD PRIMARY KEY (`id_empregado`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `empregado251`
--
ALTER TABLE `empregado251`
  MODIFY `id_empregado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
