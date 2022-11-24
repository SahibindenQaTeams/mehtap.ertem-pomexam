# mehtap.ertem-pomexam

**Project Name**

This project includes different sub-scenarios.

2 refactoring cases for POM,
3 new scenarios login, get classified and search result.

**Project Detail**

**Login case:**

1-Enter username and password

2-Logging for username and password

3-Click submit button

4-Logging if  process is success 

**Get Classified Case**

1-Go to home page

2-Click get post classified button

3-Select shopping classified in category select page

4-Enter mandotary classified detail on classified detail page.

5-Enter product property on property page.

6-Add product price on next page.

7-Pass the preview page 

8-Do not select any doping 

9-Next page is success 

10-Assertion on success page


**Search Page**

1-Go to home page

2-Click search bar and enter search text

3-Click found button

4-Assert that there is any classified in classified list.

5-Go to search page (real estate in this project)

6-Enable some filters (price and city in this project)

7-Click found button

8-Get first classified title and go this classified detail.

9-Assert if it has the same title as the clicked classified.


**Test Criteria**

1-User Page Object Model

2-Test run in testbox

3-When the test fails, the console test fails as with a log.

4-Test fail screenshot is taken

5-Logging in tests

6-Paying attention to the actions before and after the test-locaters

7-Adding tag information to the test


**To run test with MAVEN**

*mvn clean install -Dgroup=‘POPULAR_SEARCH’

*mvn clean install -Dgroup=‘LOGIN’

*mvn clean install -Dgroup=‘GET SHOPPING CLASSIFIED’

*mvn clean install -Dgroup=‘REAL ESTATE SEARCH RESULT’

*mvn clean install -Dgroup=‘VEHICLE CLASSIFIED NUMBER ASSERTION’

mvn test -Dgroups=fast,slow

This project written by Junit5 testing framework.
