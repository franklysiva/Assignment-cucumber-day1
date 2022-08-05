Feature: Leaftaps Lead Merge functionality

Background:
Given Open the Chrome Browser
And Load the URL
And Enter Username as 'Demosalesmanager'
And Enter Password as 'crmsfa'
And Click on Login Button
And Click on crmsfa Button
And Click on Leads Page

Scenario Outline: Test Lead Merge functionality with various datas
Given Click on Merge Leads Page
And Click on From Lead Lookup Leads Image Button
Then Enter <fromFirstName> <fromLastName> and <fromCompanyName> in new window, search and select first LeadId and Click To Lead Lookup Image Button and Enter <toFirstName> <toLastName> and <toCompanyName> in new window, search and select first LeadId
And Click on Merge Button
Then Click Ok Button on alert
And View Lead Page should be displayed
Given Close the Browser

Examples:
|fromFirstName|fromLastName|fromCompanyName|toFirstName|toLastName|toCompanyName|
|'Siva'|'S'|'Testleaf'|'S_i_v_a'|'S'|'TCS'|
|'Sk'|'Siva'|'TestLeaf'|'S_i_v_a'|'SKS'|'Google'|