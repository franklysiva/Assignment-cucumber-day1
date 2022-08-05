Feature: Leaftaps Lead Creation Functionality

Background: 
Given Open the Chrome Browser
And Load the URL
And Enter Username as 'Demosalesmanager'
And Enter Password as 'crmsfa'
And Click on Login Button
And Click on crmsfa Button
And Click on Leads Page

Scenario Outline: Test Create Lead Functionlity with various datas
Given Click on Create Lead Page
And Enter Company name as <CompanyName>
And Enter First name as <FirstName>
And Enter Last name as <LastName>
And Enter Phone number as <Phone>
And Click on Create Lead Submit Button
Then View Lead Page should be displayed
Given Close the Chrome Browser

Examples:
|CompanyName|FirstName|LastName|Phone|
|'Testleaf'|'Siva'|'S'|'986532'|
|'TCS'|'S_i_v_a'|'S'|'976542'|
|'Testleaf'|'Siva'|'SK'|'976431'|
|'Testleaf'|'SK'|'Siva'|'976430'|