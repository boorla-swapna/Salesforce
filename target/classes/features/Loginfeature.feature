Feature: Login feature
  Background:
  Given user launched login Page
  Then verify applicationPageOpened
  Scenario:"LoginErrorMessage_TC01"
   When user entered valid username
   Then verify userenteredUsername
   When password field is empty
   Then verifyPasswordFieldisEmpty
   When user clicks login button 
   Then password error message Is Displayed
    
  
  #Scenario:"LoginToSFDC_TC02"
   # When entered valid username password and clicked on Login
   # Then user should be Navigating to HomePage
    
  #Scenario:"Rememberuser_TC03"
   # When entered valid username password
    #And user selects the remember user check box
    #And user clicks login button
    #Then SalesForce Home Page is Displayed
    #And When user clicks Logout
    #Then  login Page launched with username populated and remember user checked
    
  #Scenario:"ForgotPassword_TC04"
    #When  user clicks on forgot password
    #Then salesforce forgot password page is displayed
    #When user enters username in forgotpassword page and clicks on continue Button
    #Then password reset message is Displayed
    #And email associated with <username> account is sent
    
    
    
    
   
  
