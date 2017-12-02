-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 01, 2017 at 11:25 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.0.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `huy_nm`
--

-- --------------------------------------------------------

--
-- Table structure for table `accepted_orders`
--

CREATE TABLE `accepted_orders` (
  `id` int(11) NOT NULL,
  `id_employee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id_employee` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id_employee`, `user_name`, `password`) VALUES
(1, 'tranduyhung', 'tranhung'),
(2, 'tranhuy', 'tranhuy');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id_product` int(11) NOT NULL,
  `id_orders` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `costs_incurred`
--

CREATE TABLE `costs_incurred` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `total` int(11) NOT NULL,
  `paid_date` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `default_salary`
--

CREATE TABLE `default_salary` (
  `default_salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `birth_date` varchar(11) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone_no` varchar(20) NOT NULL,
  `coefficient_salary` int(11) NOT NULL,
  `position` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `sex`, `birth_date`, `address`, `phone_no`, `coefficient_salary`, `position`) VALUES
(1, 'Tran Duy Hung', 'women', '2017-11-09', 'Kieu Ki', '0362154256', 30, 'employee'),
(2, 'tranviethuy', 'nam', '1997-12-16', 'HungYen', '0973248051', 50, 'manager'),
(3, 'Nguyen Dinh Thang ', 'men', '2017-11-08', 'Chuong My', '0932536251', 32, 'manager');

-- --------------------------------------------------------

--
-- Table structure for table `employee_manager`
--

CREATE TABLE `employee_manager` (
  `id_manager` int(11) NOT NULL,
  `commission` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_manager`
--

INSERT INTO `employee_manager` (`id_manager`, `commission`) VALUES
(2, 25),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `export_receipt`
--

CREATE TABLE `export_receipt` (
  `id_receipt` int(11) NOT NULL,
  `id_employee` int(11) NOT NULL,
  `date` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `import_receipt`
--

CREATE TABLE `import_receipt` (
  `id_receipt` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `import_receipt`
--

INSERT INTO `import_receipt` (`id_receipt`, `id_product`, `amount`, `price`) VALUES
(1, 1, 50, 20000),
(1, 2, 30, 20000),
(2, 3, 30, 2000),
(2, 4, 10, 200000),
(2, 5, 5, 60000);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `title` text,
  `name` varchar(50) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `address1` varchar(100) NOT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `producer` varchar(200) NOT NULL,
  `produce_date` varchar(11) DEFAULT NULL,
  `expire_date` varchar(11) DEFAULT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `producer`, `produce_date`, `expire_date`, `total`) VALUES
(1, 'Banh My', 20000, 'HungYen', '2017-11-30', '2017-12-30', 50),
(2, 'Chocopie', 20000, 'Binh Dinh', '2017-11-30', '2017-12-30', 30),
(3, 'Bim Bim', 2000, 'HungYen', '2017-11-03', '2017-11-17', 30),
(4, 'Quan Bo', 200000, 'HungYen', '2017-11-03', '2017-11-17', 10),
(5, 'Ao Thun', 60000, 'HungYen', '2017-11-03', '2017-11-17', 5);

-- --------------------------------------------------------

--
-- Table structure for table `receipt_item`
--

CREATE TABLE `receipt_item` (
  `id_receipt` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `receipt_manager_supplier`
--

CREATE TABLE `receipt_manager_supplier` (
  `id_receipt` int(11) NOT NULL,
  `id_manager` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL,
  `date` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receipt_manager_supplier`
--

INSERT INTO `receipt_manager_supplier` (`id_receipt`, `id_manager`, `id_supplier`, `date`) VALUES
(1, 2, 1, '2017-11-29'),
(2, 2, 2, '2017-11-30'),
(3, 2, 3, '2017-11-30');

-- --------------------------------------------------------

--
-- Table structure for table `save`
--

CREATE TABLE `save` (
  `check_save` int(11) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `save`
--

INSERT INTO `save` (`check_save`, `user_name`, `password`, `id`) VALUES
(1, 'tranhuy', 'tranhuy', 2),
(2, 'tranduyhung', 'tranhung', 1);

-- --------------------------------------------------------

--
-- Table structure for table `success_order`
--

CREATE TABLE `success_order` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  `mail` varchar(200) NOT NULL,
  `phone_no` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `address`, `mail`, `phone_no`) VALUES
(1, 'Mr Hung', 'Kieu Ki', 'hungkute@gmail.com', '0973248051'),
(2, 'Mr Hung ', 'Kieu Ki', 'hungkute@gmail.com', '0935256525'),
(3, 'Mr Cuong', 'My Hao', 'cuong123@gmail.com', '0983245862');

-- --------------------------------------------------------

--
-- Table structure for table `userlogin_history`
--

CREATE TABLE `userlogin_history` (
  `id` int(11) NOT NULL,
  `Time` varchar(45) NOT NULL,
  `account` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userlogin_history`
--

INSERT INTO `userlogin_history` (`id`, `Time`, `account`) VALUES
(2, '2017-11-29 18:27:59', 'tranhuy'),
(2, '2017-11-29 18:28:43', 'tranhuy'),
(2, '2017-11-29 18:29:10', 'tranhuy'),
(2, '2017-11-29 18:29:31', 'tranhuy'),
(2, '2017-11-29 18:32:03', 'tranhuy'),
(2, '2017-11-29 18:38:40', 'tranhuy'),
(2, '2017-11-29 18:51:57', 'tranhuy'),
(2, '2017-11-29 18:53:57', 'tranhuy'),
(2, '2017-11-29 18:55:01', 'tranhuy'),
(2, '2017-11-29 18:55:33', 'tranhuy'),
(2, '2017-11-29 18:57:47', 'tranhuy'),
(2, '2017-11-29 19:00:52', 'tranhuy'),
(2, '2017-11-29 19:06:21', 'tranhuy'),
(2, '2017-11-29 19:06:49', 'tranhuy'),
(2, '2017-11-29 19:07:53', 'tranhuy'),
(2, '2017-11-30 02:13:46', 'tranhuy'),
(2, '2017-11-30 02:50:19', 'tranhuy'),
(2, '2017-11-30 02:53:47', 'tranhuy'),
(2, '2017-11-30 02:53:55', 'tranhuy'),
(2, '2017-11-30 02:58:03', 'tranhuy'),
(2, '2017-11-30 02:58:11', 'tranhuy'),
(2, '2017-11-30 03:04:10', 'tranhuy'),
(2, '2017-11-30 03:06:11', 'tranhuy'),
(2, '2017-11-30 03:19:28', 'tranhuy'),
(2, '2017-11-30 03:25:51', 'tranhuy'),
(2, '2017-11-30 03:27:18', 'tranhuy'),
(2, '2017-11-30 03:29:52', 'tranhuy'),
(2, '2017-11-30 03:31:55', 'tranhuy'),
(2, '2017-11-30 03:34:29', 'tranhuy'),
(2, '2017-11-30 03:34:59', 'tranhuy'),
(2, '2017-11-30 03:35:52', 'tranhuy'),
(2, '2017-11-30 03:37:52', 'tranhuy'),
(2, '2017-11-30 03:40:00', 'tranhuy'),
(2, '2017-11-30 03:41:25', 'tranhuy'),
(2, '2017-11-30 03:43:02', 'tranhuy'),
(2, '2017-11-30 09:19:43', 'tranhuy'),
(2, '2017-11-30 10:18:11', 'tranhuy'),
(2, '2017-11-30 10:22:36', 'tranhuy'),
(2, '2017-11-30 10:27:38', 'tranhuy'),
(2, '2017-11-30 10:33:56', 'tranhuy'),
(2, '2017-11-30 10:34:54', 'tranhuy'),
(2, '2017-11-30 10:37:01', 'tranhuy'),
(2, '2017-11-30 18:34:27', 'tranhuy'),
(2, '2017-11-30 21:14:14', 'tranhuy'),
(2, '2017-11-30 21:18:35', 'tranhuy'),
(2, '2017-11-30 21:27:51', 'tranhuy'),
(2, '2017-11-30 21:30:44', 'tranhuy'),
(2, '2017-11-30 21:31:05', 'tranhuy'),
(2, '2017-11-30 21:33:50', 'tranhuy'),
(2, '2017-11-30 21:34:29', 'tranhuy'),
(2, '2017-11-30 21:34:58', 'tranhuy'),
(2, '2017-11-30 21:36:55', 'tranhuy'),
(2, '2017-11-30 21:44:38', 'tranhuy'),
(2, '2017-11-30 21:46:35', 'tranhuy'),
(2, '2017-11-30 21:48:19', 'tranhuy'),
(2, '2017-11-30 21:48:50', 'tranhuy'),
(2, '2017-11-30 21:49:14', 'tranhuy'),
(2, '2017-11-30 21:51:03', 'tranhuy'),
(2, '2017-11-30 22:00:19', 'tranhuy'),
(2, '2017-11-30 22:02:35', 'tranhuy'),
(2, '2017-11-30 22:05:46', 'tranhuy'),
(2, '2017-11-30 22:07:07', 'tranhuy'),
(2, '2017-11-30 22:07:26', 'tranhuy'),
(2, '2017-11-30 22:10:17', 'tranhuy'),
(2, '2017-11-30 22:11:54', 'tranhuy'),
(2, '2017-11-30 22:13:40', 'tranhuy'),
(2, '2017-11-30 22:14:10', 'tranhuy'),
(2, '2017-11-30 22:14:25', 'tranhuy'),
(2, '2017-11-30 22:15:19', 'tranhuy'),
(2, '2017-11-30 22:16:26', 'tranhuy'),
(2, '2017-11-30 22:27:44', 'tranhuy'),
(1, '2017-12-01 06:38:46', 'tranhung'),
(2, '2017-12-01 06:41:38', 'tranhuy'),
(1, '2017-12-01 06:41:58', 'tranhung'),
(1, '2017-12-01 06:45:46', 'tranduyhung');

-- --------------------------------------------------------

--
-- Table structure for table `work_history`
--

CREATE TABLE `work_history` (
  `id_employee` int(11) NOT NULL,
  `paid_date` varchar(11) NOT NULL,
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accepted_orders`
--
ALTER TABLE `accepted_orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_employee` (`id_employee`);

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_employee`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id_orders`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `costs_incurred`
--
ALTER TABLE `costs_incurred`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `default_salary`
--
ALTER TABLE `default_salary`
  ADD PRIMARY KEY (`default_salary`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee_manager`
--
ALTER TABLE `employee_manager`
  ADD PRIMARY KEY (`id_manager`);

--
-- Indexes for table `export_receipt`
--
ALTER TABLE `export_receipt`
  ADD PRIMARY KEY (`id_receipt`),
  ADD KEY `employee_idx` (`id_employee`);

--
-- Indexes for table `import_receipt`
--
ALTER TABLE `import_receipt`
  ADD PRIMARY KEY (`id_receipt`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receipt_item`
--
ALTER TABLE `receipt_item`
  ADD PRIMARY KEY (`id_receipt`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Indexes for table `receipt_manager_supplier`
--
ALTER TABLE `receipt_manager_supplier`
  ADD PRIMARY KEY (`id_receipt`),
  ADD KEY `id_manager` (`id_manager`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `save`
--
ALTER TABLE `save`
  ADD PRIMARY KEY (`check_save`);

--
-- Indexes for table `success_order`
--
ALTER TABLE `success_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userlogin_history`
--
ALTER TABLE `userlogin_history`
  ADD KEY `id_idx` (`id`);

--
-- Indexes for table `work_history`
--
ALTER TABLE `work_history`
  ADD PRIMARY KEY (`id_employee`,`paid_date`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `costs_incurred`
--
ALTER TABLE `costs_incurred`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `export_receipt`
--
ALTER TABLE `export_receipt`
  MODIFY `id_receipt` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `receipt_manager_supplier`
--
ALTER TABLE `receipt_manager_supplier`
  MODIFY `id_receipt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `accepted_orders`
--
ALTER TABLE `accepted_orders`
  ADD CONSTRAINT `accepted_orders_ibfk_1` FOREIGN KEY (`id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `accepted_orders_ibfk_2` FOREIGN KEY (`id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `accepted_orders_ibfk_3` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`);

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `out_key` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`);

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`id_orders`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `employee_manager`
--
ALTER TABLE `employee_manager`
  ADD CONSTRAINT `employee_manager_ibfk_1` FOREIGN KEY (`id_manager`) REFERENCES `employee` (`id`);

--
-- Constraints for table `export_receipt`
--
ALTER TABLE `export_receipt`
  ADD CONSTRAINT `employee` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `import_receipt`
--
ALTER TABLE `import_receipt`
  ADD CONSTRAINT `import_receipt_ibfk_1` FOREIGN KEY (`id_receipt`) REFERENCES `receipt_manager_supplier` (`id_receipt`),
  ADD CONSTRAINT `import_receipt_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `receipt_item`
--
ALTER TABLE `receipt_item`
  ADD CONSTRAINT `receipt_item_ibfk_1` FOREIGN KEY (`id_receipt`) REFERENCES `export_receipt` (`id_receipt`),
  ADD CONSTRAINT `receipt_item_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Constraints for table `receipt_manager_supplier`
--
ALTER TABLE `receipt_manager_supplier`
  ADD CONSTRAINT `receipt_manager_supplier_ibfk_1` FOREIGN KEY (`id_manager`) REFERENCES `employee_manager` (`id_manager`),
  ADD CONSTRAINT `receipt_manager_supplier_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id`);

--
-- Constraints for table `success_order`
--
ALTER TABLE `success_order`
  ADD CONSTRAINT `success_order_ibfk_1` FOREIGN KEY (`id`) REFERENCES `accepted_orders` (`id`);

--
-- Constraints for table `userlogin_history`
--
ALTER TABLE `userlogin_history`
  ADD CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `work_history`
--
ALTER TABLE `work_history`
  ADD CONSTRAINT `work_history_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
