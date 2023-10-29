-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2023 a las 01:40:39
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `skynet`
--
USE skynet;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cod_cliente` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET latin1 NOT NULL,
  `telefono` varchar(50) CHARACTER SET latin1 NOT NULL,
  `correo` varchar(50) CHARACTER SET latin1 NOT NULL,
  `direccion` varchar(50) CHARACTER SET latin1 NOT NULL,
  `coordenadas` varchar(50) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cod_cliente`, `nombre`, `telefono`, `correo`, `direccion`, `coordenadas`) VALUES
(1, 'Alex Tremo', '78311675', 'portalesguate2020@gmail.com', 'La Antigua Guatemala Sacatepequez', '14.5560977,-90.731145'),
(2, 'Fernando Sitamul', '50508038', 'fernandok0807@gmail.com', 'La Antigua Guatemala Sacatepequez', '14.5755512,-90.7448564'),
(3, 'Oliveiro ', '12121212', 'over12@hotmail.com', 'Guatemala, Guatemala', '14.558657, -90.716635'),
(4, 'aa', 'bb', 'cc', 'Calle Principal No. 25', '14.659171702636394,-90.51635350793457'),
(16, 'Rodrigo Saravia', '11223344', 'fsitamul@miumg.edu.gt', '12 calle finca el zapote', ' 14.658569685325103,-90.51319923013305'),
(17, 'Rocio Coronado', '14714714', 'fernandok2908@gmail.com', '13 Calle  No 25', '14.660360162988162,-90.51523770898437');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `supervisor`
--

CREATE TABLE `supervisor` (
  `cod_supervisor` int(11) NOT NULL,
  `nombres` varchar(50) CHARACTER SET latin1 NOT NULL,
  `apellidos` varchar(50) CHARACTER SET latin1 NOT NULL,
  `telefono` varchar(15) CHARACTER SET latin1 NOT NULL,
  `coreo` varchar(50) CHARACTER SET latin1 NOT NULL,
  `usuario` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `clave` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `supervisor`
--

INSERT INTO `supervisor` (`cod_supervisor`, `nombres`, `apellidos`, `telefono`, `coreo`, `usuario`, `clave`) VALUES
(1, 'Administrador', 'General', '50508038', 'fsitamul@gmail.com', 'fsitamul', '123te'),
(3, 'Julio Alberto', 'Manrriques', '12312312', 'jmanr@gmail.com', 'jalberto', 'abcd'),
(5, 'Rosenda ', 'Rosales', '99998888', 'rsales90@gmail.com', 'rrosales20', '1234'),
(10, 'Armando Josue', 'Cardona', '12345678', 'acardona@umg.edu.gt', 'acardonas', 'a1b2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico`
--

CREATE TABLE `tecnico` (
  `cod_tecnico` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET latin1 NOT NULL,
  `telefono` varchar(15) CHARACTER SET latin1 NOT NULL,
  `correo` varchar(50) CHARACTER SET latin1 NOT NULL,
  `usuario` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `clave` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `cod_supervisor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tecnico`
--

INSERT INTO `tecnico` (`cod_tecnico`, `nombre`, `telefono`, `correo`, `usuario`, `clave`, `cod_supervisor`) VALUES
(3, 'Juan Rosales', '12365488', 'jrosas@hotmail.com', 'jrosales', '2223', 3),
(5, 'Julio Iglesias', '20020020', 'jigles200@gmail.com', 'jiglesias', '111', 10),
(7, 'Abelardo', 'b', 'c', 'd', '3', 10),
(12, 'Andres', 'b', 'c', 'd', 'e', 10),
(13, 'Juliana Noj', '14714714', 'jnoo13@hotmail.com', 'jnojs', '123', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visita`
--

CREATE TABLE `visita` (
  `cod_visita` int(11) NOT NULL,
  `cod_tecnico` int(11) NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  `ingreso` varchar(25) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `egreso` varchar(25) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `coordenada` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `reporte` varchar(200) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `visita`
--

INSERT INTO `visita` (`cod_visita`, `cod_tecnico`, `cod_cliente`, `ingreso`, `egreso`, `coordenada`, `reporte`) VALUES
(3, 5, 1, '28/10/2023, 13:31:51', '28/10/2023, 13:31:55', '14.607795, -90.548253', 'dddddda'),
(5, 3, 1, '', '', '1', ''),
(7, 5, 16, '28/10/2023, 19:25:58', '28/10/2023, 19:26:49', ' 14.658569685325103,-90.51319923013305', 'Si se puede reparar el equipo'),
(12, 12, 2, NULL, NULL, '14.5755512,-90.7448564', NULL),
(13, 13, 1, '28/10/2023, 19:33:38', '28/10/2023, 19:34:06', '14.5560977,-90.731145', 'Funciona por favor');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Indices de la tabla `supervisor`
--
ALTER TABLE `supervisor`
  ADD PRIMARY KEY (`cod_supervisor`);

--
-- Indices de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  ADD PRIMARY KEY (`cod_tecnico`),
  ADD KEY `cod_supervisor` (`cod_supervisor`);

--
-- Indices de la tabla `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`cod_visita`),
  ADD KEY `cod_tecnico` (`cod_tecnico`),
  ADD KEY `cod_cliente` (`cod_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cod_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `supervisor`
--
ALTER TABLE `supervisor`
  MODIFY `cod_supervisor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  MODIFY `cod_tecnico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `visita`
--
ALTER TABLE `visita`
  MODIFY `cod_visita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tecnico`
--
ALTER TABLE `tecnico`
  ADD CONSTRAINT `tecnico_ibfk_1` FOREIGN KEY (`cod_supervisor`) REFERENCES `supervisor` (`cod_supervisor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `visita`
--
ALTER TABLE `visita`
  ADD CONSTRAINT `visita_ibfk_1` FOREIGN KEY (`cod_tecnico`) REFERENCES `tecnico` (`cod_tecnico`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `visita_ibfk_2` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
