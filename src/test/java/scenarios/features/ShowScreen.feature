Feature: Show Screen Feature


  @BulletTest @TC_035
  Scenario Outline:TES138 Verify the trailer screen
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter the OTP Number in the respective field
    Then User should click on Home navigation icon
    Then User should cancel the subscription preview
    And User Clicked  on the Explore Tab in Home
    And User should see the Start Button and Episodes Button
    And User should see The Watchlist buton
    And User should see the Like Button
    And User should see the Share Button


    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest @TC_036
  Scenario Outline:TES139 Verify auto scroll is happening once trailer playback is complete
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    And User Clicked  on the Explore Tab in Home
    And User should see the Start Button and Episodes Button
    Then Trailer should auto scroll once playback is completed

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest @TC_037
  Scenario Outline:TES140 Verify if user is able to unmute the trailer and audio is increasing and decreasing according to user actions
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    And User Clicked  on the Explore Tab in Home
    And User Clicks on the Start Button
    Then User should see MuteUnmute Icon
    And User Clicks on mute Icon
    And User increases the device volume
    Then User decreases the device volume

    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest @TC_038
  Scenario Outline:TES141 Verify user lands on episode feed and 1st episode playback happens on tapping "Start"
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    And User Clicked  on the Explore Tab in Home
    And User should see the Start Button and Episodes Button
    And User Clicks on the Start Button
    Then User should land on episode feed
    And The first episode should start playing


    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest @TC_039
  Scenario Outline:TES142 Verify if all episodes of the series season is displaying on clicking "Episodes" button
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    And User Clicked  on the Explore Tab in Home
    And User should see the Start Button and Episodes Button
    And User Clicks on the Episodes Button
    Then Episodes PopUp should visible
    And Verify All Episodes of the series season is displaying


    Examples:
     | Mobile Number |
     | 7604913183    |

  @BulletTest @TC_045
  Scenario Outline:TES148 Verify the UI on tapping "Episodes" button
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
    And User see First Episode


    Examples:
     | Mobile Number |
     | 7604913183    |

  @BulletTest @TC_047
  Scenario Outline:TES150  Verify trailer playback resumes on launching app to foreground
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    And User Clicked  on the Explore Tab in Home
    And User should see the Start Button and Episodes Button
    And User Clicks on the Start Button
    When User puts the app in background for 5 seconds
    And User brings the app to foreground
    Then Trailer playback should resume from where it left off


    Examples:
      | Mobile Number |
      | 7604913183    |


  @BulletTest @TC_048
  Scenario Outline:TES151  Verify if user is able to swipe shows in Trailer feed back and forth
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    And User Clicked  on the Explore Tab in Home
    And User should see the Start Button and Episodes Button
    And User scrolls down 4 times
    Then User scrolls Up 3 times


    Examples:
      | Mobile Number |
      | 7604913183    |

  @BulletTest @TC_049
  Scenario Outline:TES152  Verify if user lands on Home screen on tapping back from Trailer screen
    Given User should select the language preference for new user
    Then User should select add button after selecting the language
    Then User should click on Home navigation icon
    Then User should click on Profile Icon
    When User click on <Mobile Number> Text Box And Enter The Number
    Then User Enter The OTP Number
    And User should See Profile Picture
    And User click on profile cancel icon
    And User Clicked  on the Explore Tab in Home
    And User should see the Start Button and Episodes Button
    And User should see Back Icon
    Then User navigate back to Home


    Examples:
      | Mobile Number |
      | 7604913183    |


