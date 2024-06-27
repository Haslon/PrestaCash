CREATE DATABASE  IF NOT EXISTS `prestacash` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `prestacash`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: prestacash
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacen` (
  `cod_almacen` int NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` date NOT NULL,
  `fecha_salida` date DEFAULT NULL,
  `cod_artefacto` int NOT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`cod_almacen`),
  KEY `cod_artefacto` (`cod_artefacto`),
  CONSTRAINT `almacen_ibfk_1` FOREIGN KEY (`cod_artefacto`) REFERENCES `artefacto` (`cod_artefacto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES (1,'2024-04-01',NULL,1,_binary ''),(2,'2024-04-05','2024-04-10',2,_binary ''),(3,'2024-04-12',NULL,3,_binary ''),(4,'2024-04-15','2024-04-20',4,_binary ''),(5,'2024-04-22',NULL,5,_binary '');
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artefacto`
--

DROP TABLE IF EXISTS `artefacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artefacto` (
  `cod_artefacto` int NOT NULL AUTO_INCREMENT,
  `nom_artefacto` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `desc_artefacto` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `cantidad_artefacto` int NOT NULL,
  `precio_artefacto` int NOT NULL,
  `cod_tipo_artefacto` int NOT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`cod_artefacto`),
  KEY `cod_tipo_artefacto` (`cod_tipo_artefacto`),
  CONSTRAINT `artefacto_ibfk_1` FOREIGN KEY (`cod_tipo_artefacto`) REFERENCES `tipoartefacto` (`cod_tipo_artefacto`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artefacto`
--

LOCK TABLES `artefacto` WRITE;
/*!40000 ALTER TABLE `artefacto` DISABLE KEYS */;
INSERT INTO `artefacto` VALUES (1,'Televisor LED','Televisor de alta definición',50,1500,2,_binary '\0'),(2,'Lavadora','Lavadora de carga frontal',30,2000,1,_binary '\0'),(3,'Computadora portátil','Computadora portátil de última generación',100,2500,3,_binary '\0'),(4,'Licuadora','Licuadora de gran capacidad',20,100,4,_binary '\0'),(5,'Escritorio','Escritorio de madera',15,300,5,_binary '\0'),(6,'Guitarra Fender','Guitarra electrico roja, sin ningun tipo de quiñes con estuche',1,1000,1,_binary '\0'),(7,'Bateria Yamaha','Bateria completa con atriles, platillos azules',1,2400,2,_binary ''),(8,'Espejo led','Espejo cuerpo entero con luces led',1,400,3,_binary ''),(9,'Iphone 15','Iphone 15, como nuevo',1,5400,4,_binary ''),(10,'Laptop HP','Laptop hp i5',1,4400,5,_binary ''),(11,'a','a',2,2,14,_binary '\0'),(12,'b','b',8,20,15,_binary '\0'),(13,'Celular','Celular roto, muy roto',1,500,14,_binary '\0'),(14,'Micrófono','micrófono operativo',1,50,16,_binary '');
/*!40000 ALTER TABLE `artefacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `cod_cargo` int NOT NULL AUTO_INCREMENT,
  `nom_cargo` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`cod_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Asistente de empeño',_binary ''),(2,'Tasador',_binary ''),(3,'Cajero',_binary ''),(4,'Administradora',_binary ''),(5,'Comas',_binary '\0'),(6,'Comas',_binary '\0');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cod_cliente` int NOT NULL AUTO_INCREMENT,
  `nom_cliente` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `apell_paterno_cliente` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `apell_materno_cliente` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `doc_cliente` varchar(15) NOT NULL,
  `fecha_cliente` date NOT NULL,
  `dire_cliente` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `telefono_cliente` varchar(7) DEFAULT NULL,
  `celular_cliente` varchar(9) NOT NULL,
  `correo_cliente` varchar(60) NOT NULL,
  `sexo_cliente` varchar(10) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `cod_distrito` int NOT NULL,
  `cod_tipo_documento` int NOT NULL,
  PRIMARY KEY (`cod_cliente`),
  KEY `cod_distrito` (`cod_distrito`),
  KEY `cod_tipo_documento` (`cod_tipo_documento`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`cod_distrito`) REFERENCES `distrito` (`cod_distrito`),
  CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`cod_tipo_documento`) REFERENCES `tipodocumento` (`cod_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Diego','Garcia','Martinez','09123456','2024-08-12','Av. Los Rosales','7219348','946781234','dieguito@gmail.com','Masculino',_binary '',4,1),(2,'Juan','Lopez','Garcia','81234123','2024-08-15','Av. Los Pinos','7263419','935678234','juanito@gmail.com','Masculino',_binary '',4,1),(3,'Laura','Gomez','Perez','72136482','2024-09-20','Calle Los Rosales','7329148','945678123','laurita@gmail.com','Femenino',_binary '',1,1),(4,'Carlos','Sanchez','Diaz','64578123','2024-11-10','Av. Los Laureles','7249157','951687432','carlitos@gmail.com','Masculino',_binary '',2,1),(5,'Ana','Rodriguez','Fernandez','51238755','2024-11-25','Jr. Los Cipreses','7331412','975648231','anita@gmail.com','Femenino',_binary '',5,2),(6,'Lionel','Messi','Cuccitini','74517395','1997-06-10','Psj. las Rosas','7124357','941274168','Messi@gmail.com','M',_binary '',3,1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `nro_contrato` int NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `cod_cliente` int NOT NULL,
  `cod_empleado` int NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  PRIMARY KEY (`nro_contrato`),
  KEY `cod_cliente` (`cod_cliente`),
  KEY `cod_empleado` (`cod_empleado`),
  CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_cliente`),
  CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`cod_empleado`) REFERENCES `empleado` (`cod_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (1,'2024-04-01','2024-04-30',1,1,_binary ''),(2,'2024-04-05','2024-05-05',2,2,_binary ''),(3,'2024-04-10','2024-05-10',3,3,_binary ''),(4,'2024-04-15','2024-05-15',4,4,_binary ''),(5,'2024-04-20','2024-05-20',5,5,_binary ''),(6,'2024-06-12','2024-06-30',5,1,_binary ''),(7,'2024-06-14','2024-08-14',1,1,_binary '');
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecontrato`
--

DROP TABLE IF EXISTS `detallecontrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallecontrato` (
  `nro_detalle_contrato` int NOT NULL AUTO_INCREMENT,
  `cantidad_artefacto` int NOT NULL,
  `precio_artefacto` int NOT NULL,
  `nro_contrato` int NOT NULL,
  `cod_artefacto` int NOT NULL,
  PRIMARY KEY (`nro_detalle_contrato`),
  KEY `cod_artefacto` (`cod_artefacto`),
  KEY `nro_contrato` (`nro_contrato`),
  CONSTRAINT `detallecontrato_ibfk_1` FOREIGN KEY (`cod_artefacto`) REFERENCES `artefacto` (`cod_artefacto`),
  CONSTRAINT `detallecontrato_ibfk_2` FOREIGN KEY (`nro_contrato`) REFERENCES `contrato` (`nro_contrato`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecontrato`
--

LOCK TABLES `detallecontrato` WRITE;
/*!40000 ALTER TABLE `detallecontrato` DISABLE KEYS */;
INSERT INTO `detallecontrato` VALUES (1,1,1500,1,1),(2,1,2000,2,2),(3,2,2500,3,3),(4,1,100,4,4),(5,1,300,5,5);
/*!40000 ALTER TABLE `detallecontrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distrito` (
  `cod_distrito` int NOT NULL AUTO_INCREMENT,
  `nom_distrito` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`cod_distrito`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` VALUES (1,'Ancónn',_binary ''),(2,'Ate',_binary ''),(3,'Barranco',_binary ''),(4,'Breña',_binary ''),(5,'Carabayllo',_binary ''),(6,'Chaclacayo',_binary ''),(7,'Chorrillos',_binary ''),(8,'Cieneguilla',_binary ''),(9,'El Agustino',_binary ''),(10,'Jesús María',_binary ''),(11,'La Molina',_binary ''),(12,'La Victoria',_binary ''),(13,'Lima',_binary ''),(14,'Lince',_binary ''),(15,'Lurigancho',_binary ''),(16,'Lurín',_binary ''),(17,'Magdalena del Mar',_binary ''),(18,'Miraflores',_binary ''),(19,'Pachacámac',_binary ''),(20,'Pucusana',_binary ''),(21,'Pueblo Libre',_binary ''),(22,'Puente Piedra',_binary ''),(23,'Punta Hermosa',_binary ''),(24,'Punta Negra',_binary ''),(25,'Rímac',_binary ''),(26,'San Bartolo',_binary ''),(27,'San Borja',_binary ''),(28,'San Isidro',_binary ''),(29,'San Juan de Miraflores',_binary ''),(30,'San Luis',_binary ''),(31,'San Miguel',_binary ''),(32,'Santa Anita',_binary ''),(33,'Santa María del Mar',_binary ''),(34,'Santa Rosa',_binary ''),(35,'Santiago de Surco',_binary ''),(36,'Surquillo',_binary ''),(37,'Villa El Salvador',_binary ''),(38,'Villa María del Triunfo',_binary ''),(39,'Callao',_binary ''),(40,'Bellavista',_binary ''),(41,'Carmen de La Legua-Reynoso',_binary ''),(42,'La Perla',_binary ''),(43,'La Punta',_binary ''),(44,'Ventanilla',_binary ''),(45,'Mi Perú',_binary ''),(46,'Comas',_binary ''),(47,'tottus',_binary '\0'),(48,'Micrófono',_binary '\0');
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `cod_empleado` int NOT NULL AUTO_INCREMENT,
  `nom_empleado` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `apell_paterno_empleado` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `apell_materno_empleado` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `doc_empleado` varchar(15) NOT NULL,
  `fecha_empleado` date NOT NULL,
  `dire_empleado` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `telefono_empleado` varchar(7) DEFAULT NULL,
  `celular_empleado` varchar(9) NOT NULL,
  `correo_empleado` varchar(60) NOT NULL,
  `sexo_empleado` varchar(10) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `cod_distrito` int NOT NULL,
  `cod_tipo_documento` int NOT NULL,
  `cod_cargo` int NOT NULL,
  PRIMARY KEY (`cod_empleado`),
  KEY `cod_distrito` (`cod_distrito`),
  KEY `cod_tipo_documento` (`cod_tipo_documento`),
  KEY `cod_cargo` (`cod_cargo`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`cod_distrito`) REFERENCES `distrito` (`cod_distrito`),
  CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`cod_tipo_documento`) REFERENCES `tipodocumento` (`cod_tipo_documento`),
  CONSTRAINT `empleado_ibfk_3` FOREIGN KEY (`cod_cargo`) REFERENCES `cargo` (`cod_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Pedro','Lopez','Gutierrez','98765432','2024-04-25','Av. Los Girasoles 890',NULL,'945612378','pedrolopez@gmail.com','Masculino',_binary '',1,1,2),(2,'Carla','Rodriguez','Garcia','87654321','2024-04-28','Jr. Las Orquídeas 567',NULL,'932456781','carlarodriguez@yahoo.com','Femenino',_binary '',2,1,3),(3,'Raul','Santos','Fernandez','76543210','2024-05-01','Calle Los Tulipanes 345',NULL,'945671234','raulsantos@hotmail.com','Masculino',_binary '',3,1,2),(4,'Maria','Hernandez','Lopez','65432109','2024-05-05','Av. Los Cerezos 678',NULL,'978654321','mariahernandez@gmail.com','Femenino',_binary '',4,1,1),(5,'Juan','Garcia','Martinez','54321098','2024-05-08','Calle Las Acacias 901',NULL,'956781234','juangarcia@hotmail.com','Masculino',_binary '',5,1,2),(6,'Comas','Messi','Alvarado','74215482','2003-05-07','Psj. Emancipación','7124357','941274621','jose@gmail.com','Masculino',_binary '',46,1,1),(7,'Rosa','Jimenez','Alvarado','71245713','2003-04-02','Psj. las Rosas','7124654','941274168','Rosas@gmail.com','Femenino',_binary '',18,1,2),(8,'Ronaldo','Nazario','Alvarado','75394275','1996-08-22','Psj. Emancipación','7541283','941274168','ronaldo@gmail.com','Masculino',_binary '',18,1,2);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoartefacto`
--

DROP TABLE IF EXISTS `tipoartefacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoartefacto` (
  `cod_tipo_artefacto` int NOT NULL AUTO_INCREMENT,
  `nom_tipo_artefacto` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`cod_tipo_artefacto`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoartefacto`
--

LOCK TABLES `tipoartefacto` WRITE;
/*!40000 ALTER TABLE `tipoartefacto` DISABLE KEYS */;
INSERT INTO `tipoartefacto` VALUES (1,'Guitarras',_binary '\0'),(2,'Teclados',_binary ''),(3,'Bajos',_binary ''),(4,'Bateria',_binary ''),(5,'Amplificadores',_binary ''),(6,'Guitarras',_binary ''),(7,'Teclados',_binary ''),(8,'Bajos',_binary ''),(9,'Bateria',_binary ''),(10,'Amplificadores',_binary ''),(11,'Guitarra',_binary ''),(12,'Bateria',_binary ''),(13,'Espejo',_binary ''),(14,'Celular',_binary ''),(15,'laptop',_binary ''),(16,'Micrófono',_binary ''),(17,'Comas',_binary '\0'),(18,'Comas',_binary ''),(19,'Comas',_binary '\0'),(20,'Comas',_binary '\0'),(21,'Comas',_binary '\0'),(22,'Comas',_binary '\0'),(23,'Microfono',_binary '');
/*!40000 ALTER TABLE `tipoartefacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipodocumento` (
  `cod_tipo_documento` int NOT NULL AUTO_INCREMENT,
  `nom_tipo_documento` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`cod_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodocumento`
--

LOCK TABLES `tipodocumento` WRITE;
/*!40000 ALTER TABLE `tipodocumento` DISABLE KEYS */;
INSERT INTO `tipodocumento` VALUES (1,'DNI',_binary ''),(2,'Carné de extranjería',_binary ''),(3,'Pasaporte',_binary ''),(4,'RUC',_binary ''),(5,'Carné de conducir',_binary ''),(6,'Micrófono',_binary '\0');
/*!40000 ALTER TABLE `tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-14 10:12:06
