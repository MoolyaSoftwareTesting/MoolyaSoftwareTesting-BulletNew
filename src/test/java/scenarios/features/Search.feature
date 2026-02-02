Feature: Search Feature

  @BulletWallet @TC_092 @Search
  Scenario Outline: TES195 Verify user is able to see search icon on home page
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the OTP Number in the respective field
    Then User should click on Home navigation icon
    Then User should cancel the subscription preview
    Then User should click on Home navigation icon
    And User should See Search Icon


    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletWallet @TC_093 @Search
  Scenario Outline:TES196 Verify user is able to click on search icon
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    Then user should verify whether landed on search icon page


    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletWallet @TC_094 @Search
  Scenario Outline:TES197 Verify user can see and tap on search bar
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    And User should see Search Bar
    And User clicks on Search Bar


    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletWallet @TC_095 @Search
  Scenario Outline:TES198 Verify User can see Explore inside search bar
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    And User should see Search Bar
    And User clicks on Search Bar
    Then User should see Explore inside Search Bar

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletWallet @TC_096 @Search
  Scenario Outline:TES199 Verify on clicking search bar, keypad pops up
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    And User should see Search Bar
    And User clicks on Search Bar
    And User should see keypad is displayed



    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletWallet @TC_097 @Search
  Scenario Outline:TES200 Verify on searching any content user should get the searched content
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    Then user should verify whether landed on search icon page
    And User should see Search Bar
    And User clicks on Search Bar
    When User searches for <Content>
    Then User should see search results containing <Content>



    Examples:
      | Mobile Number |Content|
      | 7604913183    |Drama|


  @BulletWallet @TC_098 @Search
  Scenario Outline:TES201 Verify on clicking on search result user should be navigated to the searched content
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    Then user should verify whether landed on search icon page
    When User searches for <Content>
    And User clicks on the first search result
    Then User should be navigated to content page containing <Content>


    Examples:
      | Mobile Number |Content|
      | 7604913183    |Drama|



  @BulletWallet @TC_099 @Search
  Scenario Outline:TES202 Verify user sees "Last searched" below search bar if user searched anything
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    Then user should verify whether landed on search icon page
    And User should see Search Bar
    And User clicks on Search Bar
    When User searches for <Content>
    Then User should see Last Searched section <Content>



    Examples:
      | Mobile Number |Content|
      | 7604913183    |Drama|


  @BulletWallet @TC_100 @Search
  Scenario Outline:TES203 Verify user sees the search suggestion in the search page
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    Then user should verify whether landed on search icon page
    And User should see series listed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletWallet @TC_101 @Search
  Scenario Outline:TES204 Verify user can go back from search page
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    And User should See Search Icon
    Then User should click on search icon
    Then user should verify whether landed on search icon page
    And User should see Top Cross Icon
    And User clicks Cross Icon
    Then User redirected Home Page

    Examples:
      | Mobile Number |
      | 7604913183    |



