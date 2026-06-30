CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
); 

COMMIT;





CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    TransactionDate DATE,
    AccountID NUMBER,
    Amount NUMBER,
    TransactionType VARCHAR2(10)
);

CREATE SEQUENCE AuditLog_Seq START WITH 1 INCREMENT BY 1 NOCACHE;


SELECT * FROM Customers;
SELECT * FROM Accounts;
SELECT * FROM Transactions;
SELECT * FROM Loans;
SELECT * FROM Employees;



ALTER TABLE Customers ADD IsVIP CHAR(1);


SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER UpdateLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW 
BEGIN 
    :NEW.LastModified := SYSDATE;
END;
/
SHOW ERRORS TRIGGER UpdateLastModified;





CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN 
    INSERT INTO AuditLog(AuditID, TransactionID, TransactionDate, AccountID, Amount, TransactionType)
    VALUES (AuditLog_Seq.NEXTVAL, :NEW.TransactionID, :NEW.TransactionDate, :NEW.AccountID, :NEW.Amount, :NEW.TransactionType);
END;
/
SHOW ERRORS TRIGGER LogTransaction;



CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE 
    current_balance Decimal(15,2);
BEGIN
    IF :NEW.TransactionType = 'Withdrawl' THEN
        SELECT Balance INTO current_balance 
        FROM Accounts
        WHERE AccountID = :NEW.AccountID
        FOR UPDATE;
    

        IF current_balance < :NEW.Amount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for withdrawal.');
        END IF;
    END IF;

    IF :NEW.TransactionType = 'Deposit' THEN
        iF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Transaction amount must be greater than zero.');
        END IF;
    END IF;
END;
/
SHOW ERRORS TRIGGER CheckTransactionRules;



BEGIN

    UPdate Customers SET Name = 'JOHN DOE' WHERE CustomerID = 1;

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (3, 1, SYSDATE, 500, 'DEPOSIT');

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (4, 1, SYSDATE, 200, 'WITHDRAWAL');

    BEGIN
        
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (5, 1, SYSDATE, 2000, 'WITHDRAWAL');
    EXCEPTIOn
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('before insufficient funds error');
            DBMS_OUTPUT.PUT_LINE(SQLERRM);
            DBMS_OUTPUT.PUT_LINE('after insufficient funds error');
    END;
    BEGIN

        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (6, 1, SYSDATE, -100, 'DEPOSIT');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('before invalid amount error');
            DBMS_OUTPUT.PUT_LINE(SQLERRM);
            DBMS_OUTPUT.PUT_LINE('after invalid amount error');
    END;
END;





