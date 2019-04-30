@Sanity
Feature: Perform basic sanity of Status Manager

  @SanityScript1
  Scenario Outline: Search a Request using different request parameters
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value              |
      | Customer Name      | Sanjay Kumar       |
      | Public User Id     |         2067222009 |
      | Workgroup          | SM-DOCS            |
      | Status             | Completed          |
      | Assigned To        | AB42590            |
      | Correlation Id     | sdwf3bcf610084d178 |
      | Offering Type      | PVM                |
      | Action             | CREATE             |
      | Territory Code     | T600               |

  @SanityScript2
  Scenario Outline: Search a Request using different microservice parameters
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "MicroService" as Search Type in Search slider
    And I search for request using microservice parameters "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam       | value              |
      | MicroService ID          |              15642 |
      | MicroService Name        | callerId           |
      | MicroService Status      | In Progress        |
      | MicroService Status Code |                404 |
      | MicroService Action      | POST               |
      | Correlation ID           | sdwf3bcf610084d178 |

  @SanityScript3
  Scenario Outline: Search for a Request using different Flag parameters
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Flag" as Search Type in Search slider
    And I search for request using Flag parameters "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value                            |
      | Flag Code          | E911Provision-sdwf27e75cee721609 |
      | Flag Type          | FOC_DUE_DATE_MISSING             |
      | Correlation ID     | sdwftesstt35125bnsd24-2          |

  @SanityScript4
  Scenario Outline: Verify Service summary section is displayed in the request details page
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    Then I verify the service summary section displayed in the request page
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value              |
      | Correlation Id     | sdwf3bcf610084d178 |
