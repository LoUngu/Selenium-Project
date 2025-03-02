Narrative: Register functionality
    As a user
    I want to register
    So that I can login

Scenario: The registration is not successful if captcha was not resolved
Given the user navigates to Registration page
When the user tries to register without resolving the captcha
Then the user will see an error message

Scenario: The user is taken to login page after clicking on Back to Login button
Given the user navigates to Registration page
When the user clicks on Go to login button
