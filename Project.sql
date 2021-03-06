CREATE DATABASE library;
USE library;

CREATE TABLE book(
	isbn10 VARCHAR(10) NOT NULL,
    isbn13 BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    PRIMARY KEY(isbn10)
);

CREATE TABLE authors(
	author_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY(author_id)
);

CREATE TABLE book_authors(
	author_id INT NOT NULL,
    isbn VARCHAR(10) NOT NULL,
    FOREIGN KEY(author_id) REFERENCES authors(author_id),
    FOREIGN KEY(isbn) REFERENCES book(isbn10)
);

CREATE TABLE borrower(
	card_id INT NOT NULL,
    ssn VARCHAR(11) NOT NULL,
    bname VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    PRIMARY KEY(card_id)
);

CREATE TABLE book_loans(
	loan_id INT NOT NULL,
    isbn VARCHAR(10) NOT NULL,
    card_id INT NOT NULL,
    data_out DATETIME NOT NULL,
    due_date DATETIME NOT NULL,
    date_in DATETIME NOT NULL,
    PRIMARY KEY(loan_id),
    FOREIGN KEY(isbn) REFERENCES book(isbn10),
    FOREIGN KEY(card_id) REFERENCES borrower(card_id)
);

CREATE TABLE fines(
	loan_id INT NOT NULL,
    fine_amt DECIMAL NOT NULL, 
    paid BOOL NOT NULL, 
    FOREIGN KEY(loan_id) REFERENCES book_loans(loan_id)
);

/*import borrowers*/
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/borrowers.csv'
INTO TABLE borrower
COLUMNS TERMINATED BY ','
IGNORE 1 LINES
(@card_id, ssn, @first_name, @last_name, @dummy, @address, @city, @state, phone)
SET card_id = RIGHT(@card_id, CHAR_LENGTH(@card_id) - 2),
bname = CONCAT(@first_name, " ", @last_name),
address = CONCAT(@address, " ", @city, ",", @state);

/* import books */
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/books.csv'
INTO TABLE book
COLUMNS TERMINATED BY '	'
IGNORE 1 LINES
(isbn10, isbn13, title, @dummy, @dummy, @dummy, @dummy);