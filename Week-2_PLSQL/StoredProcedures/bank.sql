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



INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 10000, 5, SYSDATE, SYSDATE + 25);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));




CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_rows_updates NUMBER;
BEGIN
    UPDATE Accounts
    Set Balance = Balance * 1.01
    Where AccountType = 'Savings';

    v_rows_updates := SQL%ROWCOUNT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for ' || v_rows_updates || ' savings accounts.');
END ProcessMonthlyInterest;


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    EmployeeId Number,
    BonusPercentage Number
) IS
BEGIN
    Update Employees
    Set Salary = Salary + (Salary * (BonusPercentage / 100))
    Where EmployeeID = EmployeeId;
End UpdateEmployeeBonus;



CREATE Or REPLACE PROCEDURE TransferFunds(
    fromAccountId NUMBER,
    toAccountId NUMBER,
    amount NUMBER
)
IS
    fromBalance NUMBER;
    insufficientFunds EXCEPTION;
BEGIN
    Select Balance INTO fromBalance FROM Accounts Where AccountID = fromAccountId;

    IF fromBalance < amount THEN
        RAISE insufficientFunds;
    END IF;

    Update Accounts
    Set Balance = Balance - amount
    Where AccountID = fromAccountId;

    Update Accounts
    Set Balance = Balance + amount
    Where AccountID = toAccountId;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer of ' || amount || ' from Account ' || fromAccountId || ' to Account ' || toAccountId || ' completed successfully.');

EXCEPTION
    WHEN insufficientFunds THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds in Account ' || fromAccountId);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);

END TransferFunds;



BEGIN
    ProcessMonthlyInterest;
END;
/

BEGIN
    UpdateEmployeeBonus(1, 10.00);
END;
/

BEGIN
    TransferFunds(1, 2, 100.00);
END;