CREATE OR REPLACE PROCEDURE GenerateMonthlyStatements AS
    
    CURSOR monthly_cursor IS

        SELECT a.CustomerID, t.TransactionDate, t.Amount
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

        v_customerID NUMBER;
        v_transactionDate DATE;
        v_amount DECIMAL(10, 2);
    BEGIN
        FOR record IN monthly_cursor LOOP
            v_customerID := record.CustomerID;
            v_transactionDate := record.TransactionDate;
            v_amount := record.Amount;
        
            DBMS_OUTPUT.PUT_LINE('CustomerID: ' ||
                v_customerID || ', TransactionDate: ' || v_transactionDate || ', Amount: ' || v_amount);
        
        END LOOP;
END;
/


CREATE OR REPLACE PROCEDURE ApplyAnnualFee AS
    CURSOR account_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_account_id NUMBER;
    v_balance DECIMAL(10,2);
    annual_fee DECIMAL(10,2) := 50.00;

BEGIN
    FOR record IN account_cursor LOOP
        v_account_id := record.AccountID;
        v_balance := record.Balance;

        Update Accounts 
        SET Balance = v_balance - annual_fee
        WHERE AccountID = v_account_id;

    DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id || ' - Annual Fee applied');
    END LOOP;
END;
/



CREATE OR REPLACE PROCEDURE UpdateLoanInterestRates AS
    CURSOR Loan_cursor IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loan_id NUMBER;
    v_current_rate DECIMAL(5,2);
    v_new_rate DECIMAL(5,2);

BEGIN
    FOR record IN Loan_cursor LOOP
        v_loan_id := record.LoanID;
        v_current_rate := record.InterestRate;

        v_new_rate := v_current_rate * 1.05;

        Update Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = v_loan_id;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ' - Updated Interest Rate is ' || v_new_rate);
    END LOOP;
END;
/


BEGIN
    GenerateMonthlyStatements;
END;

BEGIN
    ApplyAnnualFee;
END;

BEGIN
    UpdateLoanInterestRates;
END;