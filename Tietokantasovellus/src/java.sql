
CREATE TABLE `kirjat` (
  `ID` int(11) NOT NULL,
  `TeoksenNimi` varchar(255) CHARACTER SET utf8 NOT NULL,
  `TekijanNimi` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Julkaisuvuosi` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
--
--
INSERT INTO `kirjat` (`ID`, `TeoksenNimi`, `TekijanNimi`, `Julkaisuvuosi`) VALUES
(2, 'Beginning PyQt', 'Joshua Willman', '2020'),
(3, 'You Dont Know JS Yet: Get Started', 'Kyle Simpson', '2020'),
(4, 'JavaScript for Beginners', 'Matthew Python', '2020'),
(5, 'RESTful Web API Design with Node.js', 'Valentin Bojinov', '2015'),
(6, 'The Road to Learn React', 'Robin Wieruch', '2017');

--
-- Indexes for table `kirjat`
--
ALTER TABLE `kirjat`
  ADD PRIMARY KEY (`ID`);
--
-- AUTO_INCREMENT for table `kirjat`
--
ALTER TABLE `kirjat`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;
