Feature: Calculate the total price of the cart of telephone items for an identified professional or particulier client

  Scenario Template: Professional clients with more than 10 million in turnover
    Given the client is a Professional
    And the Professional client's turnover is 10000001
    And there are <high> high-end telephones in the shopping cart
    And there are <middle> middle-end telephones in the shopping cart
    And there are <laptop> laptops in the shopping cart
    When the price of the cart is calculated
    Then the total price of their cart will be <total> euros
    Examples:
      | high | middle | laptop | total |
      | 0    | 0      | 0      | 0     |
      | 1    | 0      | 0      | 1000  |
      | 2    | 0      | 0      | 2000  |
      | 0    | 1      | 0      | 550   |
      | 0    | 2      | 0      | 1100  |
      | 0    | 0      | 1      | 900   |
      | 0    | 0      | 2      | 1800  |