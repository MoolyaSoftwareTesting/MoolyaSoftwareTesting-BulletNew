Feature: Profile Screen Feature

  @BulletWallet @TC_088
  Scenario Outline:TES191 Verify the profile screen
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the OTP Number in the respective field
    Then User should click on Home navigation icon
    Then User should cancel the subscription preview
    Then User should click on Home navigation icon
    And User should See Profile Icon
    Then User should click on Profile Icon
    And User should See User Name with ID
    And User should See Profile Picture
    And User should See Edit option
    And User should See Wallet info
    And User should see the Earn rewards Tab
    And User should see the My watchlist Tab
    And User should see the App settings Tab
    And User should see the Language Preference tab

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletWallet @TC_089
  Scenario Outline:TES192 Verify user is able to edit the profile
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Wallet icon
    And User should see the Bullet logo
    And User should See Profile Icon
    Then User should click on Profile Icon
    And User should See Edit option
    Then User clicks on edit option
    And User should enter <Full Name> in the particular field
    And User should select age group
    And User should select gender and click on save button

    Examples:
     | Mobile Number | Full Name   |
     | 7604913183    |  surendiran |



  @BulletWallet @TC_091
  Scenario Outline:TES194 Verify if user is able to deactivate the account
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Wallet icon
    And User should see the Bullet logo
    And User should See Profile Icon
    Then User should click on Profile Icon
    And User should see the App settings Tab
    Then User Clicks on App settings Tab
    And User should see Deactivate account Option
    Then User clicks on Deactivate Account
    And User should See Confirmation Popup with Yes No Buttons


    Examples:
      | Mobile Number |
      | 7604913183    |

