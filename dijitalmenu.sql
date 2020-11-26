-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.5.8-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- tablo yapısı dökülüyor dijitalmenu.kategori
CREATE TABLE IF NOT EXISTS `kategori` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kategori_id` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- dijitalmenu.kategori: ~6 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `kategori` DISABLE KEYS */;
INSERT INTO `kategori` (`id`, `kategori_id`) VALUES
	(1, 'ET'),
	(2, 'DENIZ'),
	(3, 'SALATA'),
	(4, 'ICECEK'),
	(5, 'SICAK'),
	(6, 'TATLI');
/*!40000 ALTER TABLE `kategori` ENABLE KEYS */;

-- tablo yapısı dökülüyor dijitalmenu.yemekler
CREATE TABLE IF NOT EXISTS `yemekler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yemekAdi` varchar(255) NOT NULL,
  `fiyati` varchar(255) NOT NULL,
  `kategori_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- dijitalmenu.yemekler: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yemekler` DISABLE KEYS */;
INSERT INTO `yemekler` (`id`, `yemekAdi`, `fiyati`, `kategori_id`) VALUES
	(13, 'adana', '25', 1),
	(14, 'IZGARA', '30', 1),
	(15, 'KUSBASI', '33', 1),
	(16, 'sac kavurma', '40', 1),
	(17, 'bonfile', '40', 1);
/*!40000 ALTER TABLE `yemekler` ENABLE KEYS */;

-- tablo yapısı dökülüyor dijitalmenu.yetkili
CREATE TABLE IF NOT EXISTS `yetkili` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '0',
  `password` varchar(255) NOT NULL DEFAULT '0',
  `logged` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- dijitalmenu.yetkili: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yetkili` DISABLE KEYS */;
INSERT INTO `yetkili` (`id`, `username`, `password`, `logged`) VALUES
	(1, 'admin', '0000', 'giris onaylandi');
/*!40000 ALTER TABLE `yetkili` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
