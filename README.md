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

    - there is already a .class file in the directory, but a new one can be created if you want to test the comiplation works

Tests for Tomcat9
  - to launch the tomcat server type:

    $ systemctl start tomcat9

  - the system will prompt to choose a profile and password, after that the server will be running on localhost port 8080, run:

    $ curl localhost:8080

  - this will use the terminal as a browser and show a default html file

Tests for Java Spring Boot
  - when installing spring boot we did not realize that it would also use a tomcat server, so tomcat may be installed twice independently. To show that spring is working:

    $ spring run app.groovy

  - Spring by default runs actively in the terminal unlike tomcat which ran in the background, so in order to view the output either run spring in the background or open a new terminal tab and run:

    $ curl localhost:8080

Tests For JDBC
