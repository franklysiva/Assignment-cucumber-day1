Feature: Leaftaps Lead Duplicate Functionality

Background:
Given Open the Chrome Browser
And Load the URL
And Enter Username as 'Demosalesmanager'
And Enter Password as 'crmsfa'
And Click on Login Button
And Click on crmsfa Button
And Click on Leads Page

Scenario Outline: Test Duplicate Lead Functionality with various datas
Given Click on Find Leads Page
And Click on Phone Tab under Find by
And Enter Phone number as <Phone>
And Click on Find Leads Button
And Click on First LeadID in the List
And Click on Duplicate Lead Button
And Click on Submit Button
And Close the Browser

Examples:
|Phone|
|'986532'|
|'976430'|