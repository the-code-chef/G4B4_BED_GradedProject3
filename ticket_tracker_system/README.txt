This versions uses a POST for all form data. No data is displayed on the URL.

The button for "Update" makes use a form for POSTing data. The form passed employeeId as a hidden form field. The controller request mapping "/showFormForUpdate" was changed to use @PostMapping. All of the other code is the same.


To create a db, execute below command:

```create database if not exists ticket_management;
show databases;
use ticket_management;create table ticket_tracker(id int primary key AUTO_INCREMENT, tkt_title varchar(50) NOT NULL, tkt_short_desc varchar(50)  NOT NULL,
tkt_content varchar(50) NOT NULL,created_by date NOT NULL);
describe ticket_tracker;```