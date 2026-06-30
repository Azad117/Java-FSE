CREATE TABLE ErrorLogs (
    ErrorID INT PRIMARY KEY,
    ErrorMessage VARCHAR2(255),
    ErrorDate DATE
);

Select * from ErrorLogs;


CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    fromAccountID IN INT,
    toAccountID IN INT,
    amount IN DECIMAL
) IS
BEGIN
    DECLARE
        insufficientFunds EXCEPTION;
        PRAGMA EXCEPTION_INIT(insufficientFunds, -20001);

    BEGIN
        SAVEPOINT start_trans;

        DECLARE
            from_balance INT;
        BEGIN
            SELECT Balance INTO from_balance
            FROM Accounts
            WHERE AccountID = fromAccountID;
            
            IF from_balance < amount THEN
                DBMS_OUTPUT.PUT_LINE('Insufficient Funds Available');
                RAISE insufficientFunds;
            END IF;
        END;

        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = fromAccountID;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = toAccountID;
        DBMS_OUTPUT.PUT_LINE('Funds transferred safely..!!');
        COMMIT;
    EXCEPTION
        WHEN insufficientFunds THEN
            INSERT INTO ErrorLogs (ErrorMessage, ErrorDate)
            VALUES ('Insufficient funds for transfer from AccountID: ' || fromAccountID, SYSDATE);
            ROLLBACK TO start_trans;
        WHEN OTHERS THEN
            INSERT INTO ErrorLogs (ErrorMessage, ErrorDate)
            VALUES ('SQL Error during transfer from AccountID: ' || fromAccountID || ' to AccountID: ' || toAccountID, SYSDATE);
            ROLLBACK TO start_trans;
    END;
END SafeTransferFunds;
/


CREATE OR REPLACE PROCEDURE UpdateSalary(
    empID IN INT,
    percentageIncrease IN DECIMAL
) IS
BEGIN
    DECLARE
        empNotFound EXCEPTION;
        PRAGMA EXCEPTION_INIT(empNotFound, -20001);

    BEGIN
        SAVEPOINT start_trans;

        UPDATE Employees 
        SET Salary = Salary + (Salary * (percentageIncrease / 100))
        WHERE EmployeeID = empID;
        DBMS_OUTPUT.PUT_LINE('Employee salary increased by ' || percentageIncrease || ' percentage');
        IF SQL%ROWCOUNT = 0 THEN
            RAISE empNotFound;
        END IF;
        
        COMMIT;
    EXCEPTION
        WHEN empNotFound THEN
            INSERT INTO ErrorLogs (ErrorMessage, ErrorDate)
            VALUES ('Employee ID does not exist: ' || empID, SYSDATE);
            DBMS_OUTPUT.PUT_LINE('Employee ID does not exist!!');
            ROLLBACK TO start_trans;
        WHEN OTHERS THEN
            INSERT INTO ErrorLogs (ErrorMessage, ErrorDate)
            VALUES ('Error updating salary for EmployeeID: ' || empID, SYSDATE);
            ROLLBACK TO start_trans;
    END;
END UpdateSalary;
/


CREATE OR REPLACE PROCEDURE AddNewCustomer(
    CusID IN NUMBER,
    CusName IN VARCHAR2,
    CusDOB IN DATE,
    CusBalance IN NUMBER,
    CusLastModified IN DATE
)
IS
  Invalid_Customer_ID EXCEPTION;
  Customer_Count NUMBER;
BEGIN
  SELECT count(*) INTO Customer_Count FROM Customers WHERE CustomerID = CusID;
  
  IF Customer_Count > 0 THEN
    RAISE Invalid_Customer_ID;
  END IF;
  
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (CusID, CusName, CusDOB, CusBalance, CusLastModified);
  
  DBMS_OUTPUT.PUT_LINE('Customer registered Successfully!!');
  
EXCEPTION
  WHEN Invalid_Customer_ID THEN
    DBMS_OUTPUT.PUT_LINE('Invalid Customer ID');
END;
/



BEGIN
    SafeTransferFunds(1, 2, 100.00);
END;
/

BEGIN
    UpdateSalary(1, 10.00);
END;
/

BEGIN
    AddNewCustomer(CusID => 1, CusName => 'SAKTHIVEL', CusDOB => SYSDATE, CusBalance => 5000, CusLastModified => SYSDATE);
END;
/