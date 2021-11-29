The SQL Library was implemented using Java Swing, MySQL, and MySQL Workbench. Also, this project was implemented on a Windows based OS.


In order to be able to run the application, first add all the .java files from the zip onto an existing or new project that was created on a Java IDE.
After adding all the .java files onto the project, install the MySQL Workbench version 8.0.27 and MySQL version 8.0.27 by following the instructions 
provided in the following link: https://www.youtube.com/watch?v=u96rVINbAUI. After you have installed MySQL and MySQL Workbench, create a connection 
on the workbench and set a password for the root account. After that is completed, open the .sql file on the connection, and before running the SQL script, 
add the query, SHOW VARIABLES LIKE "secure_file_priv";, anywhere on the SQL script. When you run the script, a results bar will pop up and one of the columns 
should be named Value. Copy the address that is under the Value column and paste it onto the documents address on File Explorer. The address should look like, C:\ProgramData\MySQL\MySQL Server 8.0\Uploads\. After going to that address in File Explorer, put the books.csv and borrowers.csv files onto that location on 
File Explorer. After the files have been uploaded, run the SQL script again and the records will be added to the database. After the records have been added,
in all the  DriverManager.getConnection() methods for all the .java files, make sure that the root password for MySQL has been set to the password that was 
created for the root on the last argument for the method call, i.e. DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true", "root", "Thecrow_69"); 
(password is in last argument). After setting the password on the method, make sure that the mysql-connector-java-8.0.27.jar file has been added onto the referenced
libraries on to java project. The .jar file can be added by going into the Add External Archives for the Build Path option for the Java project. Once the 
.jar file has been added, the application can be run by executing the Main.java file. If the MySQL does not want to connect or there is an issue with the
connection, go into the Services App on Windows to manually restart or start up the MYSQL.
