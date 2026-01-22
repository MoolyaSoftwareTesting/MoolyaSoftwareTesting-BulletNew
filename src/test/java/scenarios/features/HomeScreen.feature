Feature: Home Screen Feature

  @BulletTest @TC_021  @Home
  Scenario Outline: TES124 Verify Home tab in the bottom nav bar and watch banner of SFD series/season
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the OTP Number in the respective field
    Then User should click on Home navigation icon
    Then User should cancel the subscription preview
    Then User should click on Home navigation icon
    Then User should see the banners for SFD series

    Examples:
      | Mobile Number |
      | 7604913183    |

  @BulletTest @TC_022 @Home
  Scenario Outline: TES125 Verify user is redirected to SFD feed on clicking a banner
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    Then User should see the banners for SFD series
    Then User should click on a SFD series banner
    Then User should verify that he can able to see related series

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest @TC_024 @Home @P0
  Scenario Outline: TES127 Verify if user is able to scroll the different rails horizontally back and forth and all thumbnails are visible
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    Then User should see the banners for SFD series
    Then User should swipe the screen
    Then User should scroll the rails horizontally for thumbnails view <start>,<end>,<height>
    Then User should scroll the rails

    Examples:
      | Mobile Number | start | end | height |
      | 7604913183    | 20    | 10  | 30     |

  @BulletTest @TC_025 @Home
  Scenario Outline: TES128 Verify the bottom nav bar options and redirections
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the OTP Number in the respective field
    Then User should click on Home navigation icon
    Then User should see the banners for SFD series
    Then User should click on Explore navigation icon
    Then User should click on My List icon

    Examples:
      | Mobile Number |
      | 7604913183    |

  @BulletTest @TC_026 @Home
  Scenario Outline: TES129 Verify top nav bar options and redirections
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the OTP Number in the respective field
    Then User should click on Home navigation icon
    Then User should see the banners for SFD series
    Then User should click on search icon
    Then user should verify whether landed on search icon page
    Then User should click on cancel icon
    Then User should click on Profile Icon
    Then user should verify whether landed on profile icon page

    Examples:
      | Mobile Number |
      | 7604913183    |

  @BulletTest @TC_027  @Home
  Scenario Outline: TES130 Verify if user receive any error in home screen
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User should click on Home navigation icon
    Then User should see the banners for SFD series
    Then User should click on search icon
    Then user should verify whether landed on search icon page
    Then User should click on cancel icon
    Then User should click on Profile Icon
    Then user should verify whether landed on profile icon page
    Then User should click on cancel icon
    Then User should click on a SFD series banner
    Then User should click on back icon
    Then User click on close sheet
    Then User should swipe the screen
    Then User should scroll the rails horizontally for thumbnails view <start>,<end>,<height>
    Then User should scroll the rails

    Examples:
      | Mobile Number | start | end | height |
      | 7604913183    | 20    | 10  | 30     |



