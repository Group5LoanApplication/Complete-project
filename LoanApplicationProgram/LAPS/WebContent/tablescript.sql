
CREATE TABLE CustomerDetails(
	ApplicationId number Primary Key,
	Applicant_Name VARCHAR2(20),
	Date_Of_Birth DATE,
	Martial_Status VARCHAR2(10),
	Phone_Number NUMBER,
	Mobile_Number NUMBER,
	CountOfDependents NUMBER,
	Email_Id VARCHAR2(20));

create table loanapplication(
	applicationId number REFERENCES CustomerDetails(applicationId) ,
	application_date date,
	loan_program varchar2(10),
	AmountOfLoan number,
	AddressOfProperty varchar2(30),
	AnnualFamilyIncome number,
	DocumentProofsAvailable varchar2(50),
	status varchar2(10),
	DateOfInterview date);
	

CREATE sequence seq_applicationId start with 1000;

CREATE TABLE userlogin(login_id varchar2(10),password varchar2(10),role varchar2(10));

CREATE TABLE LoanProgramsOffered(
	ProgramName VARCHAR2(5),
	Description VARCHAR2(20),
	types VARCHAR2(10),
	DurationInYears number,
	MinLoanAmount number,
	MaxLoanAmount number,
	RateOfInterest number,
	Proofs_Required VARCHAR2(50));
	
INSERT INTO LoanProgramsOffered values('HL01','Simple Home Loan','Renovation',15,1000000,5000000,8.5,'Aadhar Card,Pan Card');
INSERT INTO LoanProgramsOffered values('HL02','Simple Home Loan','Construct',10,1200000,5000000,9,'Aadhar Card,Passport');
INSERT INTO LoanProgramsOffered values('HL03','Simple Home Loan','Purchase',12,1300000,5000000,8,'Aadhar Card,Voterid');
INSERT INTO LoanProgramsOffered values('HL04','Simple Home Loan','Extension',16,100000,5000000,7,'Aadhar Card,Pan Card');