Feature: fill in the form of a credit card
Scenario: As a user I can fill in the form of a credit card

  Given I can see keyboard
  And Previous button should be disabled
  And Next button should be disabled
  Then I enter code "4276500123345423"
  And Next button should be enabled
  And I can see visa card icon
  Then I press the button Next
  And Previous button should be enabled
  And Next button should be disabled
  Then I enter data "2412"
  And Next button should be enabled
  Then I press the button Next
  And Previous button should be enabled
  And Next button should be disabled
  And I can see the back side of the card icon
  Then I enter CVV code "121"
  And OK button should be enabled
  Then I press the button OK
  And OK button renamed to Processing...
  And Processing... button should be disabled  
  Then I create a new record in the database
  And Processing... button renamed to Confirmed
  

  