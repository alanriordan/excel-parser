DROP TABLE IF EXISTS EXCEL_DATA;

CREATE TABLE EXCEL_DATA (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  RATE_VALUE VARCHAR(250) NOT NULL,
  LIMITS VARCHAR(250) NOT NULL,
  AI VARCHAR(250) DEFAULT NULL
);
