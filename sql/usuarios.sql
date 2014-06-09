
-- ----------------------------
--  Table structure for `usuarios`
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `tipo` tinyint(1) NOT NULL,
  `username` varchar(20) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `usuarios` VALUES ('1', '1', 'henrique', '12345', 'Henrique Rieger');
INSERT INTO `usuarios` VALUES ('2', '2', 'roberto', '12345', 'Roberto Matte');
