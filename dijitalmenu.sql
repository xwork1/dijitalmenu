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

-- dijitalmenu.kampanyalar: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `kampanyalar` DISABLE KEYS */;
INSERT INTO `kampanyalar` (`id`, `kampanya_adi`, `kampanya_fiyati`, `kategori_id`) VALUES
	(5, 'USKUMRU %20', '20', 2),
	(6, 'KÖFTE %25', '15', 1),
	(7, 'BROWNİ %20', '12', 6),
	(8, 'CİĞER %10', '21.6', 1);
/*!40000 ALTER TABLE `kampanyalar` ENABLE KEYS */;

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

-- dijitalmenu.sepet: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `sepet` DISABLE KEYS */;
/*!40000 ALTER TABLE `sepet` ENABLE KEYS */;

-- dijitalmenu.yemekler: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yemekler` DISABLE KEYS */;
INSERT INTO `yemekler` (`id`, `yemekAdi`, `fiyati`, `kategori_id`) VALUES
	(1, 'HAMSİ', '20', 2),
	(26, 'KEBAB', '25', 1),
	(27, 'USKUMRU', '25', 2),
	(28, 'KOLA', '5', 4),
	(30, 'PİYAZ', '14', 3),
	(31, 'CİĞER', '24', 1),
	(32, 'KÖFTE', '20', 1),
	(49, 'BROWNİ', '15', 6),
	(51, 'SÜTLAÇ', '7', 6),
	(52, 'Mantar Graten', '16', 5),
	(53, 'Sigara Böreği', '12', 5),
	(54, 'Milföylü Biber Sarma', '10', 5);
/*!40000 ALTER TABLE `yemekler` ENABLE KEYS */;

-- dijitalmenu.yetkili: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yetkili` DISABLE KEYS */;
INSERT INTO `yetkili` (`id`, `username`, `password`, `logged`) VALUES
	(1, 'admin', '0000', 'giris onaylandi');
/*!40000 ALTER TABLE `yetkili` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
