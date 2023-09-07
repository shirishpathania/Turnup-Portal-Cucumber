Feature: Via turnup portal, user should be able to create, edit and delete time and material records successfully

  Scenario Outline: Create time and material record with valid details
    Given I logged into turnup portal successfully
    When I navigate to time and material page
    And I create a new time and material record '<Code>' '<TypeCode>' '<Description>' '<Price>'
    Then The record should be created successfully '<Code>' '<TypeCode>' '<Description>' '<Price>'

    Examples:
      | Code     | TypeCode | Description      | Price |
      | Keyboard | M        | Unknown Material | 500    |

  Scenario Outline: Edit time and material record with valid details
    Given I logged into turnup portal successfully
    When I navigate to time and material page
    And I edit an existing time and material record '<Code>' '<TypeCode>' '<Description>' '<Price>'
    Then The record should be updated successfully '<Code>' '<TypeCode>' '<Description>' '<Price>'

    Examples:
      | Code  | TypeCode | Description    | Price |
      | Mouse | M        | Known Material | 100   |

  Scenario Outline: Delete time and material record with valid details
    Given I logged into turnup portal successfully
    When I navigate to time and material page
    And I delete an existing time and material record
    Then The record should be deleted successfully '<TypeCode>' '<Description>' '<Price>'

    Examples:
      | TypeCode | Description    | Price |
      | M        | Known Material | 100   |