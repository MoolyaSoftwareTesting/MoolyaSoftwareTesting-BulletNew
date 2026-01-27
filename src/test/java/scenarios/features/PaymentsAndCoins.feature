Feature: Payments and Coins Feature

  @BulletTest  @TC_104 @PaymentsAndCoins
  Scenario Outline: TES207 Verify wallet screen displays all sections (Free Coins, Buy Coins, Coin History)
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the OTP Number in the respective field
#    And User should See Profile Picture
#    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    Then User should see the Free Coins Tab
    Then User should click on Free coins tab
    Then User should see complete tasks and earn coins
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see coins present
    And User should see the Coin History  Tab
    And User should click on Coins History
    And User should see coin transactions

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_105 @PaymentsAndCoins
  Scenario Outline: TES208 Verify Buy Coins page lists all available coin packages correctly
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 150 coins present
    And User should see 300 coins present
    And User should see 389 coins present
    And User should see 600+60 coins present
    And User should see 750+113 coins present
    And User should see 1060+265 coins present
    And User should see 1515+530 coins present
    And User should see 2999+1500 coins present
    And User should see 5999+3600 coins present
    And User should see 8888+6666 coins present

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_107 @PaymentsAndCoins
  Scenario Outline: TES210 Verify correct package details appear before payment
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 150 coins present
    Then User should click any coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_124 @PaymentsAndCoins
  Scenario Outline: TES226 Verify ₹49 package displays correctly with 150 coins
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 150 coins present
    Then User should click any coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_125 @PaymentsAndCoins
  Scenario Outline: TES227 Verify ₹99 package displays correctly with 300 coins
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 300 coins present
    Then User should click 300 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |

  @BulletTest  @TC_126 @PaymentsAndCoins
  Scenario Outline: TES228 Verify ₹129 package displays correctly with 389 coins
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 389 coins present
    Then User should click 389 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |

  @BulletTest  @TC_128 @PaymentsAndCoins
  Scenario Outline: TES230 Verify ₹199 package displays correctly with 600 + 60 coins (10% bonus)
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 600+60 coins present
    Then User should click 600 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_129 @PaymentsAndCoins
  Scenario Outline: TES231 Verify ₹249 package displays correctly with 750 + 113 coins (15% bonus)
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 750+113 coins present
    Then User should click 750 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_130 @PaymentsAndCoins
  Scenario Outline: TES232 Verify ₹349 package displays correctly with 1060 + 265 coins (25% bonus)
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 1060+265 coins present
    Then User should click 1060 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_131 @PaymentsAndCoins
  Scenario Outline: TES233 Verify ₹499 package displays correctly with 1515 + 530 coins (35% bonus)
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 1515+530 coins present
    Then User should click 1515 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |

  @BulletTest  @TC_132 @PaymentsAndCoins
  Scenario Outline: TES234 Verify ₹999 package displays correctly with 2999 + 1500 coins (50% bonus)
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 2999+1500 coins present
    Then User should click 2999 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_133 @PaymentsAndCoins
  Scenario Outline: TES235 Verify ₹1999 package displays correctly with 5999 + 3599 coins (60% bonus)
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 5999+3600 coins present
    Then User should click 5999 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest  @TC_134 @PaymentsAndCoins
  Scenario Outline: TES236 Verify ₹2999 package displays correctly with 8888 + 6666 coins (75% bonus)
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    Then User is on home screen
    Then User tap on Wallet tab
    Then User should be redirected to Wallet Page
    And User should see the Bullet logo
    And User should see the Buy Coins Tab
    And User should click on Buy coins
    And User should see 8888+6666 coins present
    Then User should click 8888 coins payment
    Then User should see payment gateway screen
    Then User should verify correct package details is displayed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest @TC_137
  Scenario Outline:TES221 Verify Coin History and Data Persistence
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    And User Clicked  on the Explore Tab in Home
    And User Clicks on the Episodes Button
    Then Episodes PopUp should visible
    Then User should click on locked episode
    Then User should see unlock this video popup
    Then User should see watch ad & unlock for free
    Then User should click any coins payment
    Then User should see payment gateway screen
    Then User should select card status
    Then User should select the card status as "<Payment status>"
    Then User should click on Buy button
    Then User should check the video is resumed post payment

    Examples:
      | Mobile Number | Payment status |
      | 7604913183    |  Success       |
