Feature: Compose feature

  
  #Scenario: To verify that validation message should displayed if user is sending mail without recipient
   #Given User is on login screen and user login to gmail.
   #When User send message without recipient
   #Then Validation message should displayed to user.
   
   Scenario: User logs into application and send email
   Given User is on login screen and user login to gmail.
   When User sends an email to "test@gmail.com" with subject "Incubyte" and boby "Hello World"
   Then Email appears in the sent folder of gmail with subject "Incubyte"