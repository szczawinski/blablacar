CREATE TABLE ride (
    id INTEGER IDENTITY PRIMARY KEY,
  arrivallocation VARCHAR(30),
  departurelocation VARCHAR(30),
  departuretime TIMESTAMP,
  price INTEGER NOT NULL,
  returntime TIMESTAMP);