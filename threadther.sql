-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2018 at 02:21 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `threadther`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `user_id` int(10) NOT NULL COMMENT 'PK Admin',
  `address` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`user_id`, `address`) VALUES
(1, 'Jl. Sukamulya 32'),
(2, 'Jl. A'),
(3, 'Jl. B'),
(4, 'Jl. C');

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

CREATE TABLE `cashier` (
  `user_id` int(10) NOT NULL COMMENT 'FK Cashier',
  `address` varchar(200) DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '1 working, 0 stopped'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`user_id`, `address`, `hire_date`, `status`) VALUES
(11, 'Jl. A', '2018-03-16', 1),
(12, 'Jl. B', '2018-03-17', 1);

-- --------------------------------------------------------

--
-- Table structure for table `cinema`
--

CREATE TABLE `cinema` (
  `cinema_name` varchar(50) NOT NULL COMMENT 'PK Cinema',
  `address` varchar(200) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cinema`
--

INSERT INTO `cinema` (`cinema_name`, `address`, `city`, `province`) VALUES
('23 Paskal Shopping Center', 'Pasir Kaliki Bandung', 'Bandung', 'Jawa Barat'),
('BEC Mall', 'Jl. Purnawarman No. 7 - 11', 'Bandung', 'Jawa Barat'),
('Metro Indah Mall', 'Jl. Soekarno Hatta, Kawasan Niaga MTC, No. 590', 'Bandung', 'Jawa Barat'),
('Miko Mall', 'Jl. Kopo Cirangrang No. 599', 'Bandung', 'Jawa Barat'),
('Paris Van Java', 'Jl. Sukajadi 137-139', 'Bandung', 'Jawa Barat');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `user_id` int(10) NOT NULL COMMENT 'PK,FK Customer',
  `balance` int(10) DEFAULT NULL,
  `phone_number` int(16) DEFAULT NULL,
  `birth_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`user_id`, `balance`, `phone_number`, `birth_date`) VALUES
(101, NULL, 2147483647, '1997-01-01'),
(102, NULL, 2147483647, '1997-01-02'),
(103, NULL, 2147483647, '1997-01-03');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movie_id` int(10) NOT NULL COMMENT 'PK Movie AI',
  `title` varchar(100) DEFAULT NULL,
  `synopsis` varchar(1000) DEFAULT NULL,
  `rating` double DEFAULT '5',
  `duration` int(3) DEFAULT NULL,
  `poster` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0 expired, 1 available, 2 coming soon'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movie_id`, `title`, `synopsis`, `rating`, `duration`, `poster`, `status`) VALUES
(1, 'BLACK PANTHER', 'After the death of his father, T''Challa returns home to the African nation of Wakanda to take his rightful place as king. When a powerful enemy suddenly reappears, T''Challa''s mettle as king -- and as Black Panther -- gets tested when he''s drawn into a conflict that puts the fate of Wakanda and the entire world at risk. Faced with treachery and danger, the young king must rally his allies and release the full power of Black Panther to defeat his foes and secure the safety of his people.', 7.8, 135, 'poster/blackpanther.jpg', 1),
(2, 'TOMB RAIDER', 'Lara Croft is the fiercely independent daughter of an eccentric adventurer who vanished years earlier. Hoping to solve the mystery of her father''s disappearance, Croft embarks on a perilous journey to his last-known destination -- a fabled tomb on a mythical island that might be somewhere off the coast of Japan. The stakes couldn''t be higher as Lara must rely on her sharp mind, blind faith and stubborn spirit to venture into the unknown.', 7.3, 119, 'poster/tombraider.jpg', 1),
(3, 'RED SPARROW', 'Prima ballerina Dominika Egorova faces a bleak and uncertain future after she suffers an injury that ends her career. She soon turns to Sparrow School, a secret intelligence service that trains exceptional young people to use their minds and bodies as weapons. Egorova emerges as the most dangerous Sparrow after completing the sadistic training process. As she comes to terms with her new abilities, Dominika meets a CIA agent who tries to convince her that he is the only person she can trust.', 6.7, 138, 'poster/redsparrow.jpg', 1),
(4, 'AVENGERS: INFINITY WAR', 'Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment.', 5, 156, 'poster/avengersinfinitywar.jpg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `movie_start` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'PK Schedule',
  `studio_number` int(5) NOT NULL COMMENT 'PK,FK Schedule',
  `movie_id` int(10) DEFAULT NULL COMMENT 'FK Schedule',
  `price` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`movie_start`, `studio_number`, `movie_id`, `price`) VALUES
('2018-03-19 03:00:00', 1, 1, 20000),
('2018-03-19 04:00:00', 2, 2, 20000),
('2018-03-19 06:00:00', 1, 2, 20000),
('2018-03-19 08:00:00', 2, 3, 20000);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `seat_position` varchar(5) NOT NULL COMMENT 'PK Seat',
  `studio_number` int(5) NOT NULL COMMENT 'PK,FK Seat'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`seat_position`, `studio_number`) VALUES
('A01', 1),
('A01', 2),
('A02', 1),
('A02', 2),
('A03', 1),
('A03', 2),
('A04', 1),
('A04', 2),
('A05', 1),
('A05', 2),
('A06', 1),
('A06', 2),
('A07', 1),
('A07', 2),
('B01', 1),
('B01', 2),
('B02', 1),
('B02', 2),
('B03', 1),
('B03', 2),
('B04', 1),
('B04', 2),
('B05', 1),
('B05', 2),
('B06', 1),
('B06', 2),
('B07', 1),
('B07', 2),
('C01', 1),
('C01', 2),
('C02', 1),
('C02', 2),
('C03', 1),
('C03', 2),
('C04', 1),
('C04', 2),
('C05', 1),
('C05', 2),
('C06', 1),
('C06', 2),
('C07', 1),
('C07', 2),
('D01', 1),
('D01', 2),
('D02', 1),
('D02', 2),
('D03', 1),
('D03', 2),
('D04', 1),
('D04', 2),
('D05', 1),
('D05', 2),
('D06', 1),
('D06', 2),
('D07', 1),
('D07', 2),
('E01', 1),
('E01', 2),
('E02', 1),
('E02', 2),
('E03', 1),
('E03', 2),
('E04', 1),
('E04', 2),
('E05', 1),
('E05', 2),
('E06', 1),
('E06', 2),
('E07', 1),
('E07', 2);

-- --------------------------------------------------------

--
-- Table structure for table `studio`
--

CREATE TABLE `studio` (
  `studio_number` int(5) NOT NULL COMMENT 'PK Studio AI',
  `cinema_name` varchar(50) DEFAULT NULL,
  `studio_name` varchar(20) DEFAULT NULL,
  `row_capacity` int(5) DEFAULT NULL,
  `col_capacity` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studio`
--

INSERT INTO `studio` (`studio_number`, `cinema_name`, `studio_name`, `row_capacity`, `col_capacity`) VALUES
(1, 'Paris Van Java', 'Studio 1', 5, 7),
(2, 'Paris Van Java', 'Studio 2', 5, 7),
(3, 'Miko Mall', 'Studio 1', 5, 7),
(4, 'Miko Mall', 'Studio 2', 5, 7),
(5, 'BEC Mall', 'Studio 1', 5, 7),
(6, 'BEC Mall', 'Studio 2', 5, 7),
(7, '23 Paskal Shopping Center', 'Studio 1', 5, 7),
(8, '23 Paskal Shopping Center', 'Studio 2', 5, 7),
(9, 'Metro Indah Mall', 'Studio 1', 5, 7),
(10, 'Metro Indah Mall', 'Studio 2', 5, 7);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `transaction_id` int(20) NOT NULL COMMENT 'PK,FK Transaction',
  `seat_position` varchar(5) NOT NULL COMMENT 'PK,FK Transaction'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`transaction_id`, `seat_position`) VALUES
(6, 'A01'),
(6, 'A02'),
(7, 'A03');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(20) NOT NULL COMMENT 'PK Transaction AI',
  `studio_number` int(5) NOT NULL COMMENT 'FK Transaction',
  `movie_start` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'FK Transaction',
  `user_id` int(10) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0 not printed, 1 printed',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `studio_number`, `movie_start`, `user_id`, `status`, `time`) VALUES
(6, 1, '2018-03-19 03:00:00', 11, 1, '2018-03-15 18:07:56'),
(7, 1, '2018-03-19 03:00:00', 101, 0, '2018-03-15 18:08:39');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `profile_picture` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `email`, `password`, `profile_picture`) VALUES
(1, 'Jovin', 'Angelico', 'jovin@mail.com', 'jovin', 'jovin.jpg'),
(2, 'Filipus', 'Handiyanto', 'filipus@mail.com', 'filipus', 'user_2.jpg'),
(3, 'Satria', 'Nugraha', 'satria@mail.com', 'satria', 'user_3.jpg'),
(4, 'Audric', 'Varian', 'audric@mail.com', 'audric', 'user_4.jpg'),
(11, 'Cashier', '1', 'cashier1@mail.com', 'cashier', 'user_11.jpg'),
(12, 'Cashier', '2', 'cashier2@mail.com', 'cashier', 'user_12.jpg'),
(101, 'Customer', '1', 'customer1@mail.com', 'customer', 'user_101.jpg'),
(102, 'Customer', '2', 'customer2@mail.com', 'customer', 'user_102.jpg'),
(103, 'Customer', '3', 'customer3@mail.com', 'customer', 'user_103.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `cashier`
--
ALTER TABLE `cashier`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `cinema`
--
ALTER TABLE `cinema`
  ADD PRIMARY KEY (`cinema_name`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movie_id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`movie_start`,`studio_number`),
  ADD KEY `fk_schedule_studio_number` (`studio_number`),
  ADD KEY `fk_schedule_movie_id` (`movie_id`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`seat_position`,`studio_number`),
  ADD KEY `fk_seat_studio_number` (`studio_number`);

--
-- Indexes for table `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`studio_number`),
  ADD KEY `fk_studio_cinema_name` (`cinema_name`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`transaction_id`,`seat_position`),
  ADD KEY `fk_ticket_seat_position` (`seat_position`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `fk_transaction_studio_number` (`studio_number`),
  ADD KEY `fk_transaction_user_id` (`user_id`),
  ADD KEY `fk_transaction_movie_start` (`movie_start`,`studio_number`);



--
-- AUTO_INCREMENT for dumped tables
--
ALTER TABLE `user` AUTO_INCREMENT = 104;
--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `movie_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'PK Movie AI', AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `studio`
--
ALTER TABLE `studio`
  MODIFY `studio_number` int(5) NOT NULL AUTO_INCREMENT COMMENT 'PK Studio AI', AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'PK Transaction AI', AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cashier`
--
ALTER TABLE `cashier`
  ADD CONSTRAINT `fk_cashier_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `fk_customer_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `fk_schedule_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_schedule_studio_number` FOREIGN KEY (`studio_number`) REFERENCES `studio` (`studio_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `fk_seat_studio_number` FOREIGN KEY (`studio_number`) REFERENCES `studio` (`studio_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `studio`
--
ALTER TABLE `studio`
  ADD CONSTRAINT `fk_studio_cinema_name` FOREIGN KEY (`cinema_name`) REFERENCES `cinema` (`cinema_name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `fk_ticket_transaction_id` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `fk_transaction_movie_start` FOREIGN KEY (`movie_start`,`studio_number`) REFERENCES `schedule` (`movie_start`, `studio_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_transaction_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
