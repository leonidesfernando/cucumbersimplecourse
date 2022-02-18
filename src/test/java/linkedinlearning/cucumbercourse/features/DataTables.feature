Feature: Data Tables

  @ListOfStrings
  Scenario: Bill Amount Generation
    Given I placed an order for the following items
    |Cucucmber Sanduwich|2|20|
    When I generate the bill
    Then a bil for $40 should be generated
  @ListOfLisOfStrings
  Scenario: Bill Amount Generation
    Given I placed an order for the following items
    |Cucucmber Sanduwich|2|20|
    |Cucucmber Soup|1|15|
    When I generate the bill
    Then a bil for $55 should be generated

  @ListOfMaps
  Scenario: Bill Amount Generation
    Given I placed an order for the following items
      |ItemName           |Units  |UnitPrice|
      |Cucucmber Sanduwich|2      |20|
      |Cucucmber Soup     |1      |15|
    When I generate the bill
    Then a bil for $55 should be generated