Feature: User Login

  As a registered user,
  I want to log in to the Sepatu Compass website,
  So that I can access my account and shop for products.
  
  Background: Open Page
  	Given User is on site "https://sepatucompass.com/"
  	
  	Scenario: Successful login with valid credentials
    	When User enters valid credentials for my account
	      | email              | password    |
	      | frans@antikode.com    | M4has!swa |
  	  And User clicks the "Login" button
    	Then User should be redirected to the homepage
    	
    	
    Scenario: 