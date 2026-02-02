Feature: Login Feature



  @BulletTest @TC_014 @P0 @login
  Scenario Outline:TES117 Verify if user is able to login with mobile number
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the OTP Number in the respective field

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest @TC_013 @P0 @login
  Scenario Outline: TES116 Verify whether user is able to sign up with email ID
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should select email icon
    Then User click on <EmailID> text box
    And User retrieve OTP from Gmail
    And User enter OTP in Bullet


    Examples:
      | EmailID                |
      |surendiran.n@moolya.com|


  @BulletTest @TC_015 @login
  Scenario Outline: TES118 Verify if user is able to login with email
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User should select email icon
    Then User click on <EmailID> text box
    And User retrieve OTP from Gmail
    And User enter OTP in Bullet

    Examples:
      | EmailID                |
      |surendiran.n@moolya.com|

  @BulletTest @TC_011  @login
  Scenario Outline: TES114 Verify sign-up with Google for India users
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User should select Google icon
    Then User should select the google account


    Examples:
      |
      |

  @BulletTest @TC_016 @login
  Scenario Outline: TES119 Verify if user is able to login with Google accounts
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User should select Google icon
    Then User should select the google account


    Examples:
      |
      |

  @BulletTest @TC_007 @login
  Scenario Outline: TES110 Verify whether user is able to click on Resend button for Mobile number
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User click on resend button
    Then User should verify the otp resent message

    Examples:
      | Mobile Number |
      | 7604913180    |

  @BulletTest @TC_019  @login
  Scenario Outline: TES122 Verify if user receives proper error message on entering invalid OTP for email login
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User should select email icon
    When User click on <EmailID> Text Box And Enter The Number
    Then User Enter the wrong OTP Number in the respective field

    Examples:
      | EmailID                 |
      | surendiran.n@moolya.com |


  @BulletTest @TC_020 @P0 @login
  Scenario Outline: TES123 Verify if "Resend" link is visible and working for email login
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User should select email icon
    Then User click on <EmailID> text box
    Then User click on resend button
    Then User should verify the otp resent message

    Examples:
      | EmailID                 |
      | surendiran.n@yahoo.com |


  @BulletTest @TC_006 @login
  Scenario Outline: TES109 Verify if user receives proper error message on entering invalid OTP with mobile number
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the wrong OTP Number in the respective field

    Examples:
      | Mobile Number |
      | 7604913171    |

  @BulletTest @TC_005 @login
  Scenario Outline: TES108 Verify proper mobile number validations
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User should check the mobile number is valid


    Examples:
      | Mobile Number |
      | 1234567807    |



  @BulletTest @TC_138 @login
  Scenario Outline: @TC_138 Verify proper mobile number validations by entering less than 10 digits and see arrow key is visible
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User click on <Mobile Number> Text Box
    Then User should not see the arrow key

    Examples:
      | Mobile Number |
      | 123456   |


  @BulletTest @TC_139 @login
  Scenario Outline: @TC_139 Verify proper email id validations by entering mail id without .com and see arrow key is visible
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User should select email icon
    Then User click on <EmailID> text field
    Then User should not see the arrow key

    Examples:
      | EmailID            |
      | surendiran.n@yahoo |


  @BulletTest @TC_140 @login
  Scenario Outline: @TC_140 Verify whether user able to see Terms of Use & Privacy Policy
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User click on <Mobile Number> Text Box
    Then User should not see the arrow key
    Then User should see the Terms of Use & Privacy Policy
    Then User should click the Terms of Use & Privacy Policy
#    Then User should see the terms displayed

    Examples:
      | Mobile Number |
      | 123456   |


  @BulletTest @TC_141 @login
  Scenario Outline: @TC_141 Verify whether user able to see sign up coin bonus
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User click on <Mobile Number> Text Box
    Then User should not see the arrow key

    Examples:
      | Mobile Number |
      | 123456   |


  @BulletTest @TC_142 @login
  Scenario Outline: @TC_142 Verify whether user able enter mobile number and navigates to otp screen and click on back arrow
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    Then User click on <Mobile Number> Text Box And Enter The Number
    When user should click on back button

    Examples:
      | Mobile Number |
      | 7604913183   |







