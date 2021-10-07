# * Why are we doing this?   

The purpose of this project is to demonstrate the ability to effectively use the technologies learned during the QA Dfe Bootcamp .  

# * How I expected the challenge to go.   

I expected the project to be quite easy for the most part as we have covered majority of topics during the training. I also anticipated to come across interesting cases that weren't demonstrated in the the course and would present a challenge.  

# * What went well? / What didn't go as planned?   

In the planning stage I found that I used wrong section of the Jira software to list my tasks which I quickly rectified.  

During the testing stage, I found testing the stretch goal cases slightly challenging.  

Lastly getting the correct dependencies in the POM file for .jar creation required some research as QA community material was outdated.  

Also, I deleted the below feature branch after merging it into Dev branch as per GitHub suggestion. I did not consider that feature branches would be looked at during marking. 

![first feat branch deleted](https://user-images.githubusercontent.com/89149294/135591721-0cb09fdd-f398-4e2b-8c37-8180d8323837.PNG) 
# * Possible improvements for future revisions of the project.  

I would like to introduce multiple tables in the database with more complex queries. 

# * Screenshots showing your postman requests and the output from the API.  

_Post Request Record is Created_
![Post Request Created](https://user-images.githubusercontent.com/89149294/135906359-bdfbf595-588a-446a-9f97-3d33a73030e7.PNG) 
_Get Request All Records Are Fetched_
![Get Request Read All](https://user-images.githubusercontent.com/89149294/135906384-4869b353-138b-44b1-af1b-44df1b74b24b.PNG) 
_Put Request Existing Record is Updated_
![Put Request Update Accepted](https://user-images.githubusercontent.com/89149294/135910242-44bd83ad-b7de-40a2-b2e4-14999df8cdad.PNG)
_Put Request Record Doesn't Exist Custom Exception Is Thrown_
![Put Request Update Record not found custom exception](https://user-images.githubusercontent.com/89149294/135907214-077cc03f-60b4-4727-abf6-3cbec6915d52.PNG) 
_Delete Request Existing Record is Deleted_
![Delete Request Succes No content](https://user-images.githubusercontent.com/89149294/135906510-9dffa39f-9adf-4aff-8393-a9db0055f737.PNG) 
_Delete Request Record Doesn't Exist Custom Exception Is Thrown_
![Delete Request Update Record not found custom exception](https://user-images.githubusercontent.com/89149294/135906980-d1ee28f7-e040-4d2c-a17a-cb32b2fadc0b.PNG) 
_Get Request Records With Matching Id Are Fetched_
![Get Request Read by id](https://user-images.githubusercontent.com/89149294/135907057-d8f5d552-2d77-4678-98b5-f863b13149a9.PNG) 
_Get Request Records With Matching Winner Name Are Fetched_
![Get Request Read by the winner name](https://user-images.githubusercontent.com/89149294/135907105-1f60ef48-2520-47eb-a055-ad56016a5499.PNG) 
_Post Request Record Without The Date Field is Created_
![Post Request Created using Dto](https://user-images.githubusercontent.com/89149294/135907121-843b3811-a1af-4acf-8d26-5e55ed32d5a0.PNG) 

# * Screenshots of your database to prove that data is being persisted. 
_Post Request Record is Created in the MySql Database_
![Record Created](https://user-images.githubusercontent.com/89149294/135907408-47eb8d2f-f2f6-4cd7-b00b-fb766668378b.PNG) 
_Database after Update , Delete And Create Dto Object_
![record updated deleted and created with DTO](https://user-images.githubusercontent.com/89149294/135907413-0dd7294a-1be9-408b-ad1c-0856ed7544e7.PNG) 

# * Screenshot of your test results, including coverage report.  
_Record Controller Class Unit Test_

![RecordController Unit Test](https://user-images.githubusercontent.com/89149294/135907576-ce91bedc-2ba3-4069-8839-5f8a9e150c4f.PNG) 

_Record Service Class Unit Test_

![RecordSerivce Unit Test](https://user-images.githubusercontent.com/89149294/135907660-a4e45511-18a3-46ff-821d-f2ee132afdbd.PNG) 

_Record Controller Class Integration Test_

![RecordController Intrgration Test](https://user-images.githubusercontent.com/89149294/135907673-9fbd9198-fa5e-49f2-b5e3-b7b45a3d972b.PNG) 

_Maven Test Report_

![Maven test](https://user-images.githubusercontent.com/89149294/136019288-f4e8a442-ab10-4981-ad89-9715b39e72e5.PNG)


# *Link to Jira Board - You must add both Pawel and Anoush as collaborators also.  

https://qalw.atlassian.net/jira/software/projects/QAP/boards/1
