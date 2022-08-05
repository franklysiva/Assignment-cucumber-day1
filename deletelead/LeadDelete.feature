Feature: Leaftaps Lead Delete Functionality

Background:
Given Open the Chrome Browser
And Load the URL
And Enter Username as 'Demosalesmanager'
And Enter Password as 'crmsfa'
And Click on Login Button
And Click on crmsfa Button
And Click on Leads Page

Scenario Outline: Test Delete Lead Functionality with various datas
Given Click on Find Leads Page
And Click on Phone Tab under Find by
And Enter Phone number as <Phone>
And Click on Find Leads Button
And Click on First LeadID in the List
And Click on Delete Button
And Check Deleted Lead using LeadID
And Close the Browser
Examples:
|Phone|
|'976542'|
|'976431'|
