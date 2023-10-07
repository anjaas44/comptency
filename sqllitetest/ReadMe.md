How to install SQLLITE3

• Step 1 − Go to SQLite download page, and download precompiled binaries from Windows section.
• Step 2 − Download sqlite-shell-win32-*.zip and sqlite-dll-win32-*.zip zipped files.
• Step 3 − Create a folder C:\>sqlite and unzip above two zipped files in this folder, which will give you sqlite3.def, sqlite3.dll and sqlite3.exe files.
• Step 4 − Add C:\>sqlite in your PATH environment variable and finally go to the command prompt and issue sqlite3 command, which should display the following result.


How to create Database
C:\Software\Sqllite>sqlite3.exe test.db
SQLite version 3.43.1 2023-09-11 12:01:27
Enter ".help" for usage hints.
sqlite> ./databases
Error: unknown command or invalid arguments:  "/databases". Enter ".help" for help
sqlite> .databases
main: C:\Software\Sqllite\test.db r/w
sqlite>

Basics

CREATE TABLE Employee (
	ID INTEGER PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	email TEXT NOT NULL UNIQUE,
	phone TEXT NOT NULL UNIQUE
);


sqlite> CREATE TABLE Employee (
(x1...> ID INTEGER PRIMARY KEY,
(x1...> first_name TEXT NOT NULL,
(x1...> last_name TEXT NOT NULL,
(x1...> email TEXT NOT NULL UNIQUE,
(x1...> phone TEXT NOT NULL UNIQUE
(x1...> );


sqlite> .tables
Employee

sqlite> insert into Employee values (1,'John','David','jDavid@gmail.com','45678934564');
sqlite> select * from Employee;
1|John|David|jDavid@gmail.com|45678934564


How to compile
C:\Satya\competency\sqllitetest>mvn clean install shade:shade
C:\Satya\competency\sqllitetest>java -cp .;target\sqllitetest-0.1.jar com.ercot.sqllite.sqllitetest.EmployeeData