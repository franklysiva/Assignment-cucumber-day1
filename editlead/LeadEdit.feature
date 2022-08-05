Feature: Leaftaps Lead Edit Functioanlity

Background:
Given Open the Chrome Browser
And Load the URL
And Enter Username as 'Demosalesmanager'
And Enter Password as 'crmsfa'
And Click on Login Button
And Click on crmsfa Button
And Click on Leads Page

Scenario Outline: Test Edit Lead Functioanlity with various datas
Given Click on Find Leads Page
And Enter First name as <FirstName>
And Enter Last name as <LastName>
And Enter Company name as <CompanyName>
And Click on Find Leads Button
And Click on First LeadID in the Lead List
Given Click on Edit Button
And Edit Company name as <EditedCompanyName>
And Edit Last name as <EditedLastName>
And Click on Update Button
Then View Lead page should be displayed
Given Close the Chrome Browser

Examples: 
|FirstName|LastName|CompanyName|EditedCompanyName|EditedLastName|
|'Siva'|'S'|'Testleaf'|'Infosys'|'SS'|
|'S_i_v_a'|'S'|'TCS'|'Google'|'SKS'|