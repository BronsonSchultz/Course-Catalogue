<details>
<summary>Milestone 6 Tests</summary>
All tests assume files are in working directory and testing environment is within the VM (Milestone_6/ of the repository)  

Tests for sqlite3 database
  - to launch sqlite3 and query our database run the following commands from the command line:
```
sqlite3
.open UofSPlanner.db
SELECT * FROM Courses;
```
  - Any other query can be performed as well

Tests for JDK 11
  - to test the JDK is working:
```
    $ javac HelloWorld.java
    $ java HelloWorld
```
    - there is already a .class file in the directory, but a new one can be created if you want to test the compilation works


Tests for Java Spring Boot

  - Spring had to be installed for each user, as permission was denied to install it in usr/local/bin. And also we were unable to access the marker's profile to install for that user as well.
  - So if spring does not work within the marker profile, install it with these lines:
```
    $ curl -s "https://get.sdkman.io" | bash  
    $ source "$HOME/.sdkman/bin/sdkman-init.sh"  
    $ sdk install springboot  
```
  - when installing spring boot we did not realize that it would also use a tomcat server, so tomcat may be installed twice independently. To show that spring is working:
```
    $ spring run app.groovy
```
  - Spring by default runs actively in the terminal unlike tomcat which ran in the background, so in order to view the output either run spring in the background or open a new terminal tab and run:
```
    $ curl localhost:8080
```
  - Also by default spring will start it's server on the same port as tomcat, so make sure to stop the tomcat server first before launching this one




Tests For JDBC
  - Navigate to "connect" directory first
  - Run the following command to select the "CourseCode" column from the "Courses" table:

    $ java -cp .:.sqlite-jdbc-3.30.1.jar net.sqlitetest.TestQuery

  - Currently not working, but connection to database is fine

</details>

<details>
<summary>Milestone 8 Tests</summary>

 ## Website tests

we don't have access to the marker's profile so there may be some setup required
first.
Hopefully maven is installed for the marker profile, test it with  
`mvn -version`

if it isn't:
`sudo apt-get install maven`

after that installs, spring boot should be on the system already:
(assuming your working from your home directory)
```
cd 370project
git fetch
git checkout alpha
git pull
```
This will get you up to date with our repository
```
cd webServer/complete
mvn spring-boot:run
```
This will launch the server on port 8081, it can be view in the browser at:
`http://10.81.40.175:8081/`
as long as your on a Usask machine or using the VPN

On the website you can navigate through the basic pages of our website.
I have created some stubs for any information that requires data from the
backend. Please refer to our storyboards for some of the functionality!

 ## Database tests


```
cd 370project/webServer/complete/src/main/query
(or from wherever you are to the end directory)
sqlite3
.open UofSPlanner.db
.tables
Courses             Degrees             TestFavouriteList
CreditConflicts     Prerequisites       Users
DegreeRequirements  TestCompletedList   test

.read db_upkeep/counCheck.sql
Should return:
360, number of distinct rows in Courses table
330, number of distinct rows in DegreeRequirements table
121, number of distinct rows in Credit Conflicts table
Should have 4 undergraduate degrees for computer science listedS
```

- Prerequisistes table is being reworked

 ## JDBC Tests
 again, working from you home directory
 ```
 cd 370project/webServer/complete/src/main/query
 ```
 there you can find a .txt file with a sample query fo the database
 running it:
 ```
 java -classpath sqlite-jdbc-3.8.11.2.jar db_query/src/db_query/CoursesQuery.java
 ```
 results in every single CMPT course being printed to the console from JDBC

 ## What User Stories did we implement?
 - As Alan Admin, I need a database to hold all of the classes and programs,
 so that the information is accessible for the rest of the application.
 - As Alan Admin, I want to be able to add and remove classes to and from the
 database, so that the catalogue of classes is up to date.

 ## What User stories are partially complete?
 - As Newman I want to see a list of first year CMPT courses so I know what
courses to take this years.
 - As Newman I want to see info about CMPT courses so I know what
the course will cover.
 -As Ember I’d like my favourited classes to show they are on that list when
looking at the course description. (star icon?)

**Right now these user stories have front end stubs, we will be working on
the communication of data to and from the back end**


</details>

<details>
<summary>Milestone 10 Progress</summary>

## To view our product progress on the vm:
Once logged in, make sure to clone our project into a directory of your choice.
using
```
git clone https://git.cs.usask.ca/tmg935/370project.git
```
you will need to provide your gitlab credentials.

once you have cloned our product, you should switch over to the beta branch
and make sure your working copy is up to date
```
cd 370project
git fetch
git checkout beta
```
now, to launch the server, we just need to use maven and spring boot
```
cd webServer/complete/
mvn spring-boot:run
```

if maven and spring are not already installed on your profile then the above
command should install them correctly (tested on clean user account in the VM)

after that the server will be running, so open up your web browser and head to
```
http://10.81.40.175:8081/home
```
(you need to be working on a UofS machine or connected to their VPN in order
to access it)


</details>

<details>
<summary>Final Product README</summary>

This is a course catalogue website created for CMPT 370: software engineering,
at the University of Saskatchewan in the winter term of 2020.

The goal of this project was to go through each step of the development process
Check out the [wiki](https://github.com/BronsonSchultz/Course-Catalogue/wiki) for development detais

## Database documentation
Look [here](Development_Process/DB_README.pdf) and [here](Development_Process/UofSPlannerDB_Documentation.pdf)

## To 
Once logged in, make sure to clone our project into a directory of your choice.
using
```
git clone https://git.cs.usask.ca/tmg935/370project.git
```
you will need to provide your gitlab credentials.

once you have cloned our product, you should switch over to the beta branch
and make sure your working copy is up to date
```
cd 370project
git fetch
git pull
```
now, to launch the server, we just need to use maven and spring boot
```
cd webServer/complete/
mvn spring-boot:run
```

if maven and spring are not already installed on your profile then the above
command should install them correctly (**tested on clean user account in the VM**)

after that the server will be running, so open up your web browser and head to
```
http://10.81.40.175:8081/home
```
(you need to be working on a UofS machine or connected to their VPN in order
to access it)

(there was a known permissions issue with the marker account, if that is still
the case please use the user account or dev5)

**Please refer to the product demo in a couple days to see a walkthrough of the website's features**

## Project Component Tests
By running the server, we verify all of the necessary pieces of the project
work together. However, if you would like to test each component on its own,
do the following:

I assume here that these commands are run in order one after another!

Tests for sqlite3 database
  - to launch sqlite3 and query our database run the following commands from the command line:
```
cd webServer/complete/
sqlite3
.open UofSPlanner.db
SELECT * FROM Courses;
```
  - Any other query can be performed as well

Tests for JDK 11
  - to test the JDK is working:
```
cd ../../Milestone_6
javac HelloWorld.java
java HelloWorld
```
    - there is already a .class file in the directory, but a new one can be created if you want to test the compilation works

Tests for Java Spring Boot

  - when installing spring boot we did not realize that it would also use a tomcat server, so tomcat may be installed twice independently. To show that spring is working:
```
spring run app.groovy
```
  - Spring by default runs actively in the terminal, so in order to view the output either run spring in the background or open a new terminal tab and run:
```
curl localhost:8080
```    

</details>

<details open>
<summary>Post Development README</summary>
## Running this project
  This website requires either Spring to be installed on your machine or can be run with Docker.
  
  If you're using Spring
</details>
