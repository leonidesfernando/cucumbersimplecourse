Feature: Menu Management
  Background: Setup a menu item
    Given I have a menu item with a name "Chicken Sandwich" and price $15
    When I add that menu item
    Then Menu item with name "Chicken Sandwich" should be added
  @SmokeTest
  Scenario: Add a menu item
    Given I have a menu item with a name "Cucumber Sandwich" and price $20
    When I add that menu item
    Then Menu item with name "Cucumber Sandwich" should be added

  @RegularTest
  Scenario: Add another menu item
    Given I have a menu item with a name "Cucumber Salad" and price 10
    When I add that menu item
    Then Menu item with name "Cucumber Salad" should be added

  @NightlyBuildTest @RegularTest
  Scenario: Add third menu item
    Given I have a menu item with a name "Chicken Sandwich" and price $15
    When I add that menu item
    Then I should see an error message with value "Duplicate menu item"