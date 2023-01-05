	  @CreateItemTest
	  Scenario: user is able to create an item or service
	    Given user is on the login page
	    And user navigates to Items tab
	    When user clicks on the Add Item button
	    And user should be on item input page
	    When user provides item information “name” and “price” and “unit” and “description”
	    And click Save Item button
	    Then the Item is added to the Item list table
	
		@UpdateItemTest
	  Scenario: user is able to update an item or service
	    Given user is on the login page
	    And user navigates to Items tab
	    When selects the item “Books”
	    And user should be on item details page
	    When user updates the item price to 30 dollars
	    And click Update Item button
 		  Then the Item price is updated to 30 dollars
