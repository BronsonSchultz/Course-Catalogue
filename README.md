<details>
<summary>Milestone 6 Tests</summary>
All tests assume files are in working directory and testing environment is within the VM (Milestone_6/ of the repository)  

Tests for sqlite3 database
  - to launch sqlite3 and query our database run the following commands from the command line:

  $ sqlite3
  $ .open UofSPlanner.db
  $ SELECT * FROM Courses;

  - Any other query can be performed as well

Tests for JDK 11
  - to test the JDK is working:

    $ javac HelloWorld.java
    $ java HelloWorld

    - there is already a .class file in the directory, but a new one can be created if you want to test the compilation works

Tests for Tomcat9
  - to launch the tomcat server type:

    $ systemctl start tomcat9

  - the system will prompt to choose a profile and password, after that the server will be running on localhost port 8080, run:

    $ curl localhost:8080

  - this will use the terminal as a browser and show a default html file

Tests for Java Spring Boot

  - Spring had to be installed for each user, as permission was denied to install it in usr/local/bin. And also we were unable to access the marker's profile to install for that user as well.
  - So if spring does not work within the marker profile, install it with these lines:

    $ curl -s "https://get.sdkman.io" | bash  
    $ source "$HOME/.sdkman/bin/sdkman-init.sh"  
    $ sdk install springboot  

  - when installing spring boot we did not realize that it would also use a tomcat server, so tomcat may be installed twice independently. To show that spring is working:

    $ spring run app.groovy

  - Spring by default runs actively in the terminal unlike tomcat which ran in the background, so in order to view the output either run spring in the background or open a new terminal tab and run:

    $ curl localhost:8080
    
  - Also by default spring will start it's server on the same port as tomcat, so make sure to stop the tomcat server first before launching this one 

    
    

Tests For JDBC
  - Navigate to "connect" directory first
  - Run the following command to select the "CourseCode" column from the "Courses" table:

    $ java -cp .:.sqlite-jdbc-3.30.1.jar net.sqlitetest.TestQuery

  - Currently not working, but connection to database is fine
 
</details>

<details open>
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