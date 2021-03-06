# Student Arrival System

##Quarantine Database

A *system* that provides the user:
- the ability to track number of students in quarantine
- to input incoming students onto the campus
- to see where the students are quarantining themselves in

This ***Arrival System*** is designed for any university (here UBC, Vancouver) which needs to track
how many students have arrived at the campus and where they are staying.

This can take in the name of the student, country of arrival, quarantine residence/hotel,
covid-19 tested (yes/no).

This project is of interest to me due to the situation we have ourselves in currently.
While there were other ideas in mind, I went with this one mostly because it felt fitting. 
Moreover, I thought the idea of filtering how many students are in quarantine, their number of 
days left and other factors interested me too.

##User Story
The user should be able to
- add new students to the database
- see a particular student's detail
- see names of all students quarantining on campus
- retrieve total number of international arrival
- total number of arrivals
- retrieve names of students with positive test report
- save details of students entered
- load previously saved details of students and add more to the same file


##Phase 4: Task 2
Established Bi-directional relationship between University and Student classes.

##Phase 4: Task 3
The UML Diagram has been included in pdf form. Given time, I would try to make a class which would have all properties 
required for a new window in an ongoing program like the project has in case of Positive and All Student window. Both 
share almost the same code, so I would try to have them extend that class and override appropriate methods.