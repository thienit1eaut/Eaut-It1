-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 05, 2025 at 01:56 PM
-- Server version: 8.0.42
-- PHP Version: 8.3.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanly_doanvien_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `chidoan`
--

CREATE TABLE `chidoan` (
  `id` bigint NOT NULL,
  `macd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `donvi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `loai` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diachi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dienthoai` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `trangthai` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `makh` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `chidoan`
--

INSERT INTO `chidoan` (`id`, `macd`, `donvi`, `loai`, `diachi`, `dienthoai`, `email`, `trangthai`, `makh`) VALUES
(1, 'CDCNTTIT1', 'DCCNTT13.10.1 - Công nghệ thông tin', 'Lớp học', 'Trường Đại học công nghệ Đông Á', '', 'eaut.edu.vn', 'Đang hoạt động', 'KHCNTT'),
(2, 'CDCNTTIT2', 'DCCNTT13.10.2 - Công nghệ thông tin', 'Lớp học', 'Trường Đại học công nghệ Đông Á', '', 'eaut.edu.vn', 'Đang hoạt động', 'KHCNTT'),
(3, 'CDCNTTIT3', 'DCCNTT13.10.3 - Công nghệ thông tin', 'Lớp học', 'Trường Đại học công nghệ Đông Á', '', 'eaut.edu.vn', 'Đang hoạt động', 'KHCNTT'),
(4, 'CDCNTTIT4', 'DCCNTT13.10.4 - Công nghệ thông tin', 'Lớp học', 'Trường Đại học công nghệ Đông Á', '', 'eaut.edu.vn', 'Đang hoạt động', 'KHCNTT'),
(5, 'CDCNTTIT5', 'DCCNTT13.10.5 - Công nghệ thông tin', 'Lớp học', 'Trường Đại học công nghệ Đông Á', '', 'eaut.edu.vn', 'Đang hoạt động', 'KHCNTT');

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `id` bigint NOT NULL,
  `macv` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tencv` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`id`, `macv`, `tencv`, `note`) VALUES
(1, 'CVBT', 'Bí thư', ''),
(2, 'CVPBT', 'Phó bí thư', ''),
(3, 'CVUV', 'Ủy viên', ''),
(4, 'CVDV', 'Đoàn viên', '');

-- --------------------------------------------------------

--
-- Table structure for table `doanvien`
--

CREATE TABLE `doanvien` (
  `id` bigint NOT NULL,
  `madv` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hoten` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaysinh` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gioitinh` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diachi` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sdt` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngayvaodoan` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `trangthaihd` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ord` int DEFAULT '0',
  `act` int NOT NULL,
  `img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lib_img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `short_content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_at` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_at` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `macd` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `macv` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `masv` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `matk` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `doanvien`
--

INSERT INTO `doanvien` (`id`, `madv`, `hoten`, `ngaysinh`, `gioitinh`, `diachi`, `email`, `sdt`, `ngayvaodoan`, `trangthaihd`, `ord`, `act`, `img`, `lib_img`, `short_content`, `content`, `create_at`, `update_at`, `macd`, `macv`, `masv`, `matk`) VALUES
(1, 'DV20220062', 'Nguyễn Văn An', '2000-01-15', 'Nam', '12 Lê Lợi, TP.HCM', 'an.nguyen@example.com', '0909123456', '2018-03-26', 'Đang hoạt động', 1, 1, NULL, NULL, NULL, NULL, '2025-06-03 18:00:12', '2025-06-04 03:49:58', 'CDCNTTIT1', 'CVBT', '20220062', 'TKBVTADMIN'),
(2, 'DV20220063', 'Trần Thị Bình', '2001-07-20', 'Nữ', '45 Trần Hưng Đạo, Hà Nội', 'binh.tran@example.com', '0911222333', '2019-05-01', 'Tạm dừng', 2, 0, NULL, NULL, NULL, NULL, '2025-06-03 18:00:12', '2025-06-04 03:49:58', 'CDCNTTIT2', 'CVPBT', '20220063', 'TKBVTADMIN'),
(3, 'DV20220064', 'Lê Hoàng Nam', '1999-12-05', 'Nam', '78 Nguyễn Văn Cừ, Đà Nẵng', 'nam.le@example.com', '0988777666', '2017-09-15', 'Đang hoạt động', 3, 1, NULL, NULL, NULL, NULL, '2025-06-03 18:00:12', '2025-06-04 03:49:58', 'CDCNTTIT3', 'CVUV', '20220064', 'TKBVTADMIN'),
(4, 'DV20220065', 'Phạm Thị Hương', '2002-04-30', 'Nữ', '101 Pasteur, Cần Thơ', 'huong.pham@example.com', '0966888999', '2020-01-10', 'Đang hoạt động', 4, 1, NULL, NULL, NULL, NULL, '2025-06-03 18:00:12', '2025-06-04 03:49:58', 'CDCNTTIT4', 'CVBT', '20220065', 'TKBVTADMIN'),
(5, 'DV20220066', 'Đỗ Minh Quân', '2000-09-09', 'Nam', '30 Lý Tự Trọng, Huế', 'quan.do@example.com', '0933444555', '2018-08-22', 'Đã rời', 5, 0, NULL, NULL, NULL, NULL, '2025-06-03 18:00:12', '2025-06-04 03:49:58', 'CDCNTTIT5', 'CVPBT', '20220066', 'TKBVTADMIN'),
(7, 'DV20220067', NULL, '1999-08-07', 'on', NULL, '20220067@eaut.edu.vn', '0888940425', '2025-03-26', 'Đang hoạt động', 0, 0, NULL, NULL, NULL, 'Test thêm đoàn viên', NULL, NULL, 'CDCNTTIT1', 'CVBT', '20220067', 'TKBVTADMIN'),
(8, 'DV20220068', 'Bùi Văn Thiện 2', '2025-06-02', 'Nam', 'Hà nội', '20220068@eaut.edu.vn', '088940428', '2025-06-10', 'Đang hoạt động', 0, 0, NULL, NULL, NULL, 'Test lần 2', NULL, NULL, 'CDCNTTIT1', 'CVBT', '20220068', 'TKBVTADMIN'),
(9, 'DV20220069', 'Bùi Đức Hoàn', '2025-06-02', 'Nam', 'Hưng Yên', '20220069@eaut.edu.vn', '089452212555', '2025-06-08', 'Đang hoạt động', 0, 0, NULL, NULL, NULL, 'Test gửi form lần 3', NULL, NULL, 'CDCNTTIT1', 'CVBT', '20220069', 'TKBVTADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `khoa`
--

CREATE TABLE `khoa` (
  `id` bigint NOT NULL,
  `makh` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tenkh` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `khoa`
--

INSERT INTO `khoa` (`id`, `makh`, `tenkh`, `note`) VALUES
(1, 'KHCNTT', 'Công nghệ thông tin', ''),
(2, 'KHTCKT', 'Tài chính - kế toán', ''),
(3, 'KHCK', 'Cơ khí', ''),
(4, 'KHDTTDH', 'Điện tử - Tự động hóa', ''),
(5, 'KHCNOT', 'Công nghệ ô tô', ''),
(6, 'KHKL', 'Khoa luật', 'Test tạo khoa');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `parent` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `act` int NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_at` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `update_at` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `matk` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`, `parent`, `role`, `act`, `email`, `note`, `create_at`, `update_at`, `matk`) VALUES
(1, 'Bùi Văn Thiện', 'admin', '$2a$10$myOy7mOLaUz5GiQWPbQOieZrnYFMicthQd3Davm56BS0A8Zyk5ds2', NULL, NULL, 1, '20220062@eaut.edu.vn', '', NULL, NULL, 'TKBVTADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chidoan`
--
ALTER TABLE `chidoan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `macd` (`macd`),
  ADD KEY `fk_makh` (`makh`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `macv` (`macv`);

--
-- Indexes for table `doanvien`
--
ALTER TABLE `doanvien`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `madv` (`madv`),
  ADD KEY `fk_macd` (`macd`),
  ADD KEY `fk_macv` (`macv`),
  ADD KEY `fk_matkKKK` (`matk`);

--
-- Indexes for table `khoa`
--
ALTER TABLE `khoa`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `makh` (`makh`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `matk` (`matk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chidoan`
--
ALTER TABLE `chidoan`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `chucvu`
--
ALTER TABLE `chucvu`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `doanvien`
--
ALTER TABLE `doanvien`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `khoa`
--
ALTER TABLE `khoa`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chidoan`
--
ALTER TABLE `chidoan`
  ADD CONSTRAINT `fk_makh` FOREIGN KEY (`makh`) REFERENCES `khoa` (`makh`);

--
-- Constraints for table `doanvien`
--
ALTER TABLE `doanvien`
  ADD CONSTRAINT `fk_macd` FOREIGN KEY (`macd`) REFERENCES `chidoan` (`macd`),
  ADD CONSTRAINT `fk_macv` FOREIGN KEY (`macv`) REFERENCES `chucvu` (`macv`),
  ADD CONSTRAINT `fk_matkKKK` FOREIGN KEY (`matk`) REFERENCES `users` (`matk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
