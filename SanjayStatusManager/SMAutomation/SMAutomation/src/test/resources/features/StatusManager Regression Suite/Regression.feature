@SM-Regression
Feature: Status Manager Regression Suite

  @tag1 @POSTService
  Scenario: StatusSubmitService: Submit Status Service request to SM successfully - commonInfo, originatorInfo & Customer details
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "Status Submit Service"
    And I read "sdwf Accepted" JSON Data
    And I fill the Status Submit Service form with "sdwf Accepted" test data
    And I click on Submit button to submit the request
    Then I validate the response received for "sdwf Accepted"
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    Then I validate the Request Details Page with "sdwf Accepted"
    And I logout from Application

  @tag2 @POSTService
  Scenario: StatusSubmitService: Submit Status Service request to SM successfully - commonInfo, originatorInfo, Customer details & Microservice details
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "Status Submit Service"
    And I read "microservice Invocation" JSON Data
    And I fill the Status Submit Service form with "microservice Invocation" test data
    And I click on Submit button to submit the request
    Then I validate the response received for "microservice Invocation"
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    Then I validate the Request Details Page with "microservice Invocation"
    And I logout from Application

  @tag3 @POSTService
  Scenario: StatusSubmitService: Submit Status Service request to SM successfully - commonInfo, originatorInfo, Customer details, Microservice details, Microservice Request details & Microservice Status link url's
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "Status Submit Service"
    And I read "microservice_update" JSON Data
    And I fill the Status Submit Service form with "microservice_update" test data
    And I click on Submit button to submit the request
    Then I validate the response received for "microservice_update"
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    Then I validate the Request Details Page with "microservice_update"
    And I logout from Application

  @tag4 @POSTService
  Scenario: Validate Log Notes Service functionality
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "Log Notes Service"
    And I fill Log Notes Service form
    And I validate the response received from Notes Service
    And I clicked on Search Link
    And I enter the CorrelationID used for Log Notes Service
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    Then I verify the comments displayed in the comments section of Request Details Page
    And I go to Log Details tab
    Then I validate the updated comments are captured in the Log table
    And I logout from Application

  @tag5 @POSTService
  Scenario: Validate Notify Service functionality
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "Notify Service"
    And I fill Notify Service form
    And I validate the response received from Notify Service
    Then I validate the newly added flag on request details page
    And I go to Log Details tab
    Then I validate the flag details are captured in the Log table
    And I logout from Application

  @tag6 @RMAService @AutoDemo
  Scenario: Validate ADD RMA functionality using RMA Service API
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "RMA Service"
    And I fill "ADD" RMA Service form
    And I validate the reponse received for "ADD" ActionType
    Then I validate the RMA details on request details page for "ADD" ActionType
    And I go to Log Details tab
    Then I verify "ADD" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

  @tag7 @RMAService
  Scenario: Validate UPDATE RMA functionality using RMA Service API
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "RMA Service"
    And I fill "UPDATE" RMA Service form
    And I validate the reponse received for "UPDATE" ActionType
    Then I validate the RMA details on request details page for "UPDATE" ActionType
    And I go to Log Details tab
    Then I verify "UPDATE" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

  @tag8 @RMAService
  Scenario: Validate DELETE RMA functionality using RMA Service API
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "RMA Service"
    And I fill "DELETE" RMA Service form
    And I validate the reponse received for "DELETE" ActionType
    Then I validate the RMA details on request details page for "DELETE" ActionType
    And I go to Log Details tab
    Then I verify "DELETE" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

  @tag9 @GETService
  Scenario Outline: Validate GetRequestByCorrelationID functionality
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "Get Request Details(Correlation ID)"
    And I enter "<Value>" in CorrelationID textbox and click on submit
    And I click on Submit button to submit the request
    Then I verify the response received for CorrID
    And I close the Get Request Details by CorrelationID tab
    And I logout from Application

    Examples: 
      | Value              |
      | sdwf1498d7608360f9 |

  @tag10 @GETService
  Scenario Outline: Validate GetRequestByPublicUserID functionality
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "Get Request Details (Public User ID)"
    # And I enter "2067222009" PublicUserID and click on submit
    And I enter "<Value>" in PublicUserID textbox and click on submit
    And I click on Submit button to submit the request
    Then I verify the response received for the TN used
    And I close the Get Request Details by PublicUserID tab
    And I logout from Application

    Examples: 
      | Value      |
      | 2067222009 |

  @tag11 @SearchUpdateScenario
  Scenario Outline: Validate Global search functionality
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I enter partial "<Param Type>" "<Value>" in the Global search
    Then I validate the request page with the input data
    And I logout from Application

    Examples: 
      | Param Type     | Value  |
      | PublicUserID   | 206722 |
      | CustomerName   | JASON  |
      | CorrelationID  | sdwf   |
      | MicroServiceID |   4253 |

  @tag12 @SearchUpdateScenario
  Scenario: Validate Query History link functionality
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on Query History link
    And I click on ViewMore link
    Then I verify request details page is launched when clicked on view icon of a CorrelationID
    And I logout from Application

  @tag13 @SearchUpdateScenario @AutoDemo
  Scenario Outline: Search Request by FLAG Code and remove that Flag from Request Page
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Flag" as Search Type in Search slider
    And I search for request using Flag parameters "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    Then I remove "<value>" Flag from the Request Flagged section
    And I verify success message is displayed
    And I go to Log Details tab
    Then I verify "DELETE FLAG" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value |
      | Flag Code          |     3 |

  @tag14 @SearchUpdateScenario
  Scenario Outline: Search for Request by FLAG Type and remove that Flag from Request Page
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Flag" as Search Type in Search slider
    And I search for request using Flag parameters "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    Then I remove "FOC Rejected" Flag from the Request Flagged section
    And I verify success message is displayed
    And I go to Log Details tab
    Then I verify "DELETE FLAG" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value        |
      | Flag Type          | FOC Rejected |

  @tag15 @SearchUpdateScenario
  Scenario: Validate search by Microservice Name functionality
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "MicroService" as Search Type in Search slider
    And I enter "Porting" in the MicroService Name dropdown
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    Then I verify "Porting" microservice is displayed under the Microservice table in the request details page
    #  Then I verify the microservice is displayed under the Microservice table in the request details page
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

  @tag16 @SearchUpdateScenario
  Scenario Outline: Search a Request and assign WorkGroup from Request Page
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I click on Assign button
    Then I assign "SM-NASDF" workgroup to the request
    And I go to Log Details tab
    Then I verify "ASSIGN WORKGROUP" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value              |
      | Correlation Id     | sdwf2c7fa450ec201c |

  @tag17 @SearchUpdateScenario
  Scenario Outline: Search a Request and remove WorkGroup from Request Page
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    Then I remove "SM-NASDF" workgroup from the request
    And I go to Log Details tab
    Then I verify "DELETE WORKGROUP" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    #sdwftesstt35125bnsd24-2
    Examples: 
      | searchrequestparam | value              |
      | Correlation Id     | sdwf2c7fa450ec201c |

  @tag18 @SearchUpdateScenario
  Scenario Outline: Search a Request and assign user from Request Page
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I click on Assign button
    And I select "User" radio button
    Then I assign "AB42590" ID to the request
    And I go to Log Details tab
    Then I verify "ASSIGN USER/WORKGROUP" log Action is captured in Logs Table
    And I logout from Application

    Examples: 
      | searchrequestparam | value              |
      | Correlation Id     | sdwf2c7fa450ec201c |

  @tag19 @SearchUpdateScenario @AutoDemo
  Scenario Outline: Verify warning message is displayed when clicked on assign workgroup button without entering workgroup name
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I click on Assign button
    And I select "WorkGroup" radio button
    Then I verify warning message is displayed when clicked on assign workgroup button
    And I logout from Application

    Examples: 
      | searchrequestparam | value              |
      | Correlation Id     | sdwf3b759a18499e20 |

  @tag20 @SearchUpdateScenario
  Scenario Outline: Verify warning message is displayed when clicked on assign user button without entering CUID
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I click on Assign button
    And I select "User" radio button
    Then I verify warning message is displayed when clicked on assign user button
    And I logout from Application

    Examples: 
      | searchrequestparam | value                   |
      | Correlation Id     | sdwftesstt35125bnsd24-2 |

  @tag21 @SearchUpdateScenario @AutoDemo
  Scenario Outline: Search a Request and assign FLAG to that ID from Request Page
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    Then I add "<FLAG Name>" Flag to the request
    And I go to Log Details tab
    Then I verify "SET FLAG" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value              | FLAG Name       |
      | Correlation Id     | sdwf5e73002934185e | Due Date Missed |

  @tag22 @SearchUpdateScenario
  Scenario: Verify User information is displayed when clicked on Profile link
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on the username link
    When I click on Profile link
    Then I should land on manage Users page
    Then Manage Users Page should be launched in a new tab
    And I close the Manage Users tab
    And I logout from Application

  @tag23 @ManualActionfromSM @AutoDemo
  Scenario Outline: Verify the response after performing FORCE COMPLETE action on a MicroService from Status Manager
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify "<Microservice>" microservice is displayed under the Microservice table in the request details page
    Then I validate "<MS Action>" action performed on the "<Microservice>" microservice
    And I go to Log Details tab
    Then I verify "FORCE_COMPLETE" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value              | Microservice  | MS Action      |
      | Correlation Id     | sdwf3bc470a4915490 | TN Management | FORCE COMPLETE |

  @tag24 @ManualActionfromSM1 @Retry-AINProvisioningService
  Scenario Outline: Verify the response after performing RETRY action on AINProvisioningService Microservice from Status Manager
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify "<Microservice>" microservice is displayed under the Microservice table in the request details page
    Then I validate "<MS Action>" action performed on the "<Microservice>" microservice
    And I go to Log Details tab
    Then I verify "RETRY" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    #  And I click on caret down icon to view Service info
    #  And I Verify "MS Action" button is displayed and enabled
    #  Then I click on "MS Action" button and verify the response received
    #  Then I verify the microservice is displayed under the Microservice table in the request details page
    Examples: 
      | searchrequestparam | value              | Microservice           | MS Action |
      | Correlation Id     | sdwf1c1cd8dbd30a42 | AINProvisioningService | RETRY     |

  @ManualActionfromSM1 @Retry-PortingService
  Scenario Outline: Verify the response after performing RETRY action on Porting Microservice from Status Manager
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify "<Microservice>" microservice is displayed under the Microservice table in the request details page
    # Then I validate "<MS Action>" action performed on the "<Microservice>" microservice
    Then I update the "<DesiredDueDate>" field and validate "<MS Action>" action performed on the "<Microservice>" microservice
    And I go to Log Details tab
    Then I verify "RETRY" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value                            | Microservice | DesiredDueDate | MS Action |
      | Correlation Id     | a74bcf1f37e1456abc9ce9bab6407326 | Portster     | 2018-05-23     | RETRY     |

  @ManualActionfromSM1 @Retry-E911Service
  Scenario Outline: Verify the response after performing RETRY action on E911 Microservice from Status Manager
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify "<Microservice>" microservice is displayed under the Microservice table in the request details page
    # Then I validate "<MS Action>" action performed on the "<Microservice>" microservice
    Then I update the "<Streetname>" field and validate "<MS Action>" action performed on the "<Microservice>" microservice
    And I go to Log Details tab
    Then I verify "RETRY" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value              | Microservice | Streetname          | MS Action |
      | Correlation Id     | sdwf3bb92bcb57c447 | E911         | 8126 S SYRACUSE ST1 | RETRY     |

  @VerifyComplete @ManualActionfromSM
  Scenario Outline: Verify the response after performing FORCE COMPLETE action on a Microservice from Status Manager
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify "<Microservice>" microservice is displayed under the Microservice table in the request details page
    Then I validate "<MS Action>" action performed on the "<Microservice>" microservice
    And I go to Log Details tab
    Then I verify "VERIFY_COMPLETE" log Action is captured in Logs Table
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value              | Microservice | MS Action       |
      | Correlation Id     | sdwf3bab60a9362e2e | E911         | Verify Complete |

  @PublishService
  Scenario: Validate Publish Service functionality
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I click on "Test Rest" and select "Publish Service"
    And I fill publish service form
    Then I validate the response received
    And I logout from Application

  @RMAComplete
  Scenario Outline: Verify RMAComplete button is not displayed when request action type is not RMA
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify ActionType of request
    Then I verify the visibility of RMAComplete button

    Examples: 
      | searchrequestparam | value          |
      | Correlation Id     | 399326a152842b |

  @RMAComplete1
  Scenario Outline: Verify the functionality of RMAComplete button when MS has an active RMA
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify ActionType of request
    Then I verify the visibility of RMAComplete button
    And I verify for any active RMA's present on MS
    Then I verify the error message recieved when clicked on RMAComplete button
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value          |
      | Correlation Id     | 2eb1d25d58ba09 |

  @RMAComplete2 @AutoDemo
  Scenario Outline: Verify the functionality of RMAComplete button when MS doesnt have any active RMA
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify ActionType of request
    Then I verify the visibility of RMAComplete button
    And I verify for any active RMA's present on MS
    Then I verify the success message recieved when clicked on RMAComplete button
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value                     |
      | Correlation Id     | autoscript-sdwfjl2baw12a1 |

  @RMAComplete3Pending
  Scenario Outline: Verify the functionality of RMAComplete button after clearing the active RMA on MS
    Given I launch Status Manager application
    And I login as a "Admin" user
    Then I should land on the HomePage
    And I clicked on Search Link
    And I select "Request" as Search Type in Search slider
    And I search for request using "<searchrequestparam>" "<value>"
    And I click on Search button
    And I click on view icon in Search Result page
    And I should see the "Request Details screen attributes" been displayed
    And I verify ActionType of request
    Then I verify the visibility of RMAComplete button
    And I verify for any active RMA's present on MS
    Then I verify the error message recieved when clicked on RMAComplete button
    And I close the search results page
    And I close the Request Details Page
    And I logout from Application

    Examples: 
      | searchrequestparam | value          |
      | Correlation Id     | 2eb1d25d58ba09 |
