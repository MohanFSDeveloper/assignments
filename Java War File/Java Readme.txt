Technlogies Used
================ 
Java 1.7
Spring

About CSVUploader
=================
This app can be used to validate various knid of CSV files based on some predefined rules.

1) This app accepts csv file as input and validate the same with the help of custom annotation and diplays the validation results on the table.

Deployment Guidelines
=====================

1 ) Download the apache tomcat7 server
2 ) Extract the CustomerStatementProcessor.war and place it inside the webapps folder which is available inside apache tomcat server.
3 ) Then change the input file location property available in application property file(\WEB-INF\classes\application.properties).
4 ) Go to bin folder then start tomcat server
5 ) Access this URL http://localhost:<<8080>>/CustomerStatementProcessor/
6 ) Landing page will be opened where you can see option to process customer statement file.




