
Chocoholics Implelments the following nine Use Cases.  Revelvant codes to get 
started: 

	Admin password: Admin
	Provider code: 001861196
	Member code: 426094731
	Operator code: 123
	Manager code: 1234
------------------------------------------------------------------------------

For all menus, begin by entering the respective code shown above, or the admin 
password, which will bypass logins for the purpose of demonstration.


Provider
1. Validate Member
   1. To validate a member, simply click the ìValidate Member button and enter 
   their member number. The program will check if they are a valid member, and 
   if so, will tell you their member status.
2. Request Provider Directory
   1. To request the provider directory, click the ìRequest Provider Directory 
   button. You will then be presented with another menu to choose whether to 
   have the directory shown to you directly, or to have it emailed to you. If 
   the latter option is chosen, the email file will be stored in the folder:  
   /TheProject/alecservicecodes/Emails.
3. Bill for Health Care Services
   1. To bill for a health care service, click the Bill for Health Care 
   Services button. The program will ask you for all necessary information to 
   make a report, then store it in ENTER DIRECTORY HERE


Operator
4. Add Member/Provider
   1. To add a member or provider, simply click the ìAdd Member or ìAdd 
   Provider button, and the program will prompt you for all necessary 
   information, and store it in their respective files, both stored in the 
   directory ìì/TheProject/elleuser/Data/.
5. Remove Member/Provider
   1. To remove a member or provider, simply click the ìRemove Member or 
   ìRemove Provider button, then enter the number of the member or provider 
   you want to remove.
6. Edit Member/Provider Information
   1. To edit a member or provider, simply click the ìEdit Member Information 
   or ìRemove Provider Information button, then enter the number of the member
   or provider you want to edit. The program will then show you the information
    of the member or provider youíve entered the number of, then ask you which 
    piece of info to edit. Choose the info you want to change through the drop-
    down menu, then enter and confirm the data.

Manager
7. Make a Member Report
   1. To make a member report, click the ìRun Individual Member Report button 
   and enter the number of the member you want a report for. The program will 
   then generate an individual report and store it in the directory: 
   ì/TheProject/reportcodesryan/Member_Reports
8. Make a Provider Report
   1. To make a provider report, click the ìRun Individual Provider Report 
   button and enter the number of the Provider you want a report for. The 
   program will then generate an individual report and store it in the 
   directory:  ì/TheProject/reportcodesryan/Provider_Reports
9. Make a Summary Report
   1. To make a summary report, click the ìRun Current Summary Report button. 
   A summary report will be generated, and placed in the directory: 
   ì/TheProject/reportcodesryan/Summary_Reports


Automatic Processes
There are several automatic reports generated at a preset date and time every 
week. These reports will appear in each reportís respective directories as 
specified above. The Eft report will be in the directory:  
ì/TheProject/reportcodesryan/EFT_Reports and the date and time of these reportsí
generation can be changed on line 56 of the file AccountingProcedure. Further 
instructions on how to format these times is provided in the comments of the 
code.

-----------------------Locations (in case you get lost)------------------------
	provider code: src/elleuser/Data/providerDirectory.txt
	member code stored in /src/elleuser/Data/memberDirectory.txt
	operator code: /src/employee/records/employeelist.txt
	manager code: /src/employee/records/employeelist.txt
