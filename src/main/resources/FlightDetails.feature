Feature: User is able to search for flight details and plan travel journey.
  @smokeTest
  Scenario Outline: Verify user is able to search flight details from ten origin to ten destinations one after another.
    Given User is on flight booking homepage
    And User enter source "<source>" and destination "<destination>" location
    Then User should be able to search flight details successfully
    Examples:
   |source|destination|
   | paris |  london  |
   | france|new delhi |
   |kolkata|new delhi |
   | france|hyderabad |
   | paris |new delhi |
   | new delhi|france |
   | bangalore|new delhi|
   | france|bangalore |
   | berlin|germany |
   | germany|new delhi |

  @smokeTest
  Scenario Outline: Verify user is able to get test data from excel file, fill out ticket details page and print data in console.
    Given User navigated to ticket booking page
    When User fill out the ticket details page with data in excelsheet "<SheetName>" and rownumber <RowNumber>
    Then User is able to navigate further in ticket booking journey

    Examples:
      |SheetName|RowNumber|
      | Sheet1  |    0     |
      | Sheet1  |    1     |
      | Sheet1  |    2     |
      | Sheet1  |    3     |
      | Sheet1  |    4     |



