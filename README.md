# mehtap.ertem-pomexam

Project Name

This project includes different sub-scenarios.

2 refactoring cases for POM,
3 new scenarios login, get classified and search result.

Project Detail

1- Login case:

-Enter username and password
-Logging for username and password
-Click submit button
-Logging if  process is success 

2-Get Classified Case

-Go to home page
-Click get post classified button
-Select shopping classified in category select page
-Enter mandotary classified detail on classified detail page.
-Enter product property on property page.
-Add product price on next page.
-Pass the preview page 
-Do not select any doping 
-Next page is success 
-Assertion on success page

3- Search Page

-Go to home page
-Click search bar and enter search text
-Click found button
 -Assert that there is any classified in classified list.
-Go to search page (real estate in this project)
-Enable some filters (price and city in this project)
-Click found button
-Get first classified title and go this classified detail.
-Assert if it has the same title as the clicked classified.

Test Criteria

User Page Object Model
Test run in testbox
When the test fails, the console test fails as with a log.
Test fail screenshot is taken
Logging in tests
Paying attention to the actions before and after the test-locaters
Adding tag information to the test

To run test with MAVEN

mvn clean install -Dgroup=‘POPULAR_SEARCH’
mvn clean install -Dgroup=‘LOGIN’
mvn clean install -Dgroup=‘GET SHOPPING CLASSIFIED’
mvn clean install -Dgroup=‘REAL ESTATE SEARCH RESULT’
mvn clean install -Dgroup=‘VEHICLE CLASSIFIED NUMBER ASSERTION’

mvn test -Dgroups=fast,slow

This project written by Junit5 testing framework.
