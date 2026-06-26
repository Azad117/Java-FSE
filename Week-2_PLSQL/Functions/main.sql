
CREATE OR REPLACE FUNCTION CalculateAge(dob DATE)
RETURN NUMBER
IS
    age NUMBER;
BEGIN
    SELECT FLOOR((SYSDATE - dob) / 365)
    INTO age
    FROM dual;
    RETURN age;
END CalculateAge;
/

CREATE OR REPLACE FUNCTION CalculateMontlyInterest
(
    loanAmount NUMBER,
    InterestRate NUMBER,
    months NUMBER
)
RETURN NUMBER
Is 

    monthlyInstallement NUMBER;
    numPayments NUMBER;
    monthlyRate NUMBER;
bEGIN

    monthlyrate := InterestRate / 12 / 100;
    numPayments := months / 12;
    monthlyInstallement := loanAmount * (monthlyRate * POWER(1 + monthlyRate, numPayments)) / (POWER(1 + monthlyRate, numPayments) - 1);

    RETURN monthlyInstallement;
END CalculateMontlyInterest;
/



CREATE OR REPLACE FUNCTION HasSufficientFunds(
    accountId NUMBER,
    amount NUMBER
)
RETURN BOOLEAN
IS 
    balance NUMBER;
BEGIN 
    SELECT Balance 
    INTO balance FROM Accounts
    WHERE AccountID = accountId;

    IF balance >= amount THEN
        RETURN TRUE;
    ELSE 
        RETURN FALSE;
    END IF;
END HasSufficientFunds;
/
SHOW ERRORS FUNCTION HasSufficientFunds;


DECLARE
    v_age NUMBER;
    v_monthlyInterest NUMBER;
    v_hasBalance BOOLEAN;
BEGIN
    
    v_age := CalculateAge(TO_DATE('1960-01-01', 'YYYY-MM-DD'));
    DBMS_OUTPUT.PUT_LINE('Age: ' || v_age);

    v_monthlyInterest := CalculateMontlyInterest(10000, 5, 60);
    DBMS_OUTPUT.PUT_LINE('Monthly Interest: ' || v_monthlyInterest);

    v_hasBalance := HasSufficientFunds(1, 500);
    IF v_hasBalance THEN
        DBMS_OUTPUT.PUT_LINE('Account has sufficient funds.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Account does not have sufficient funds.');
    END IF;
END;
