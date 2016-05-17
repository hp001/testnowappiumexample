# :sparkles: TESTNOW APPIUM EXAMPLE :sparkles:
Contains mobile application testing suite for BookMyShow android application.

## Overview :eyes:

Appium code written in Java using Page Object Model design pattern.

Appium software testing tool is freeware mobile automation testing tool using which you can automate native, hybrid and mobile web software apps of android and IOS.

This suite runs scenarios related to following:

1. Login and Logout feature
2. Booking seat/s following various pages 

##Purpose :eyes:

Major purpose of this example automation is to understand how one can make maximum usage of [TestNow](https://opexsoftware/testnow) cross platform testing with minimum effort by following some best practices mentioned here. 
Few Best Practices are as follows:

1. How to initialize different platforms [Android and IOS]
2. How to write appropriate setup and teardown's
3. How to create html reports which helps TestNow to create consolidated reports for you.
4. and few more which you can relate to ... :)

## Application Under Test (AUT) :eyes:

__BookMyShow__ Offers showtimes, movie tickets, concert tickets and events calendar. Also features movie reviews, promotional offers and mobile applications.


##How To Use This For Your Application :eyes:

__A walk through the folder structure__

1. src/main/java/com/pack/pageobjects folder is the place where all the elements locator are kept in Page Object Model pattern. 
2. src/main/java/com/pack/utilities folder contain utility class which have all actoins and functions which repeatedly using
3. src/main/resources folder contain datafile.properties file which have input data for test
4. src/test/java/com/pack/tests folder contains test cases
4. src/test/resources/apps folder is the location where .apk file kept

## Requirements :eyes:

1. __Code__
  * TESTNOW JAVA EXAMPLE code 
2. __Programming Language__
  * Java
3. __Dependencies__
  * All mentioned in pom.xml file, no additional dependency installation required

## Setup :eyes:

__git clone https://github.com/opexsw/testnowappiumexample.git__

####NOTE: To avoid all the requirement and setup related extra work, use [TESTNOW](https://opexsoftware.com/testnow) :star2:

## Execution :eyes:

__Commmands__ 

1. __mvn clean__ -- This will clean the old compiled code
2. __mvn test__ -- This will recompile the code and execute the tests
3. __mvn clean test__ -- This will do 1 and 2 both

## Reporting :eyes:
Reports are created in following 2 types of format

1. __HTML__ : index.html
2. __JSON__ : index.json

Reports are created inside the test-output directory with above mentioned filenames

##Author :eyes:

* Name: __Ganesh Ransarje__ 
* Organization: __Opex Software__ 
* Email: __ganesh.ransarje@opexsoftware.com__

##Licence :eyes:
For Licence information, see [here](https://github.com/opexsw/testnowappiumexample/blob/master/LICENSE.txt)
