Feature: Build Computer

  Scenario:
    Given I am user on Building Computer page
    When I try to build computer with definite params
    Then I've added product with correct parameters to the Cart
