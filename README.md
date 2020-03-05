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
.
.
.
</details>