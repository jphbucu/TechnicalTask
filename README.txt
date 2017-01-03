*Selenium WebDriver TestFramework*
Follow these instructions to use the Test Automation Framework I have designed. This README is designed with non-technical users in mind to be using the framework

*Setting up the Framework*
-this framework does not need to be installed, and is executable in command prompt. The only requirement is to have JRE 8 and MS Excel 2010 (for .xlsx files) installed.
1) Download the Task_2 and save it to any location on your computer, preferably C:\
2) Make sure the following files and folders are present: TestFramework.jar; tests > SampleTest.xlsx; drivers > chromedriver.exe
3) If all files are present, then set up is done!

*Running a test*
-This test requires user-provided arguments and will not be executable using double click. It is best to execute it in command prompt or using a batch file.
1) open command prompt
2) in command prompt, got to the directory of the jar file (*\Task_2\)
3) in command prompt, type java -jar TestFramework.jar args1 args2
4) args1 is the location of Task_2 folder (if in C:\Task_2 then type only C:, or if C:\Users\username\Task_2, then type only C:\Users\username)
5) args2 is for the name of the xlsx file you wish to execute. For my example this is SampleTest.xlsx.
6) It should look like this: C:\Task_2>java -jar TestFramework.jar C: SampleTest.xlsx
7) Press enter and the test should start.

*How this framework works*
-this framework is both a keyword and data driven framework, or hybrid framework. the test will be written in an excel file by a tester, and the test script can be written by any non technical tester, and will not require any knowledge of automation testing.
-the test script (SampleTest.xlsx) has 3 columns: Action, Object, Input.

Action: this is where the user writes the type of action (keyword) they want the framework to do on an object (for example CLICK will click on an object, or TYPE will enter data on the object).
Object: this is where the user writes the target object's property and/or parameter.
Input: this is where the user writes any input they whish the framework to enter.

-For example, Action:LAUNCH | Object:Chrome | Input:https://www.amaysim.com.au/, the action keyword LAUNCH will launch google chrome browser with amaysim.com.au page.
-Another example Action:CLICK | Object:xpath|//*[@id="block-useraccountmenu"]/ul/li[2]/a/span | Input:  , the keyword will Click on the object with the property xpath with xpath parameter //*[@id="block-useraccountmenu"]/ul/li[2]/a/span (this is the Login link), click on a link does not need any input so Input is blank.