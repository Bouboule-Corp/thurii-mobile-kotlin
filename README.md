# THURII  [![codecov](https://codecov.io/gh/Bouboule-Corp/thurii-mobile-kotlin/branch/master/graph/badge.svg?token=UVI9MFAXVK)](https://codecov.io/gh/Bouboule-Corp/thurii-mobile-kotlin)

**Thurii** is an outdoor sports application developped by the **BoubouleCorp**.  
This repository is for the mobile app based on [Kotlin](https://developer.android.com/kotlin)


## Introduction

To use this project, you first need to clone this repositository.

## Android Studio IDE setup

For development, the latest version of **Android Studio** is required. The latest version can be downloaded from [here](https://developer.android.com/studio/).   
Then open this project in Android Studio.

## Environment
If you want to be able to build the project you have to create an environement variable called MAPBOX_KEY as for the value of the key you have to ask one of the contributors.

#### Linux
  - for a temporary env variable type (you will have to do it each time you launch a terminal) : `export MAPBOX_KEY=key`
  - for a permanent env variable :
  1. To set permanent environment edit the .bashrc file:

    sudo nano ~/.bashrc

  2. Write a line for each variable you wish to add using the following syntax:

    export [VARIABLE_NAME]=[variable_value]
   ![image](https://user-images.githubusercontent.com/74605059/174965500-f75359ec-488c-4af3-825f-4a3380dc9a9a.png)

  3. Save and exit the file. The changes are applied after you restart the shell. If you want to apply the changes during the current session, use the source command:

    source ~/.bashrc

 #### Windows
 
  1. On the Windows taskbar, right-click the Windows icon and select System.
  2. In the Settings window, under Related Settings, click Advanced system settings.

  ![image](https://user-images.githubusercontent.com/74605059/174966076-af9b98dc-fac7-4a94-845e-c6713354fd63.png)
  
  3. On the Advanced tab, click Environment Variables.
 
  ![image](https://user-images.githubusercontent.com/74605059/174966168-d7ab09f5-7164-4443-813e-b28727f64643.png)
  
  4. Click New to create a new environment variable. Click Edit to modify an existing environment variable.
  5. After creating or modifying the environment variable, click Apply and then OK to have the change take effect.

## Getting started

### With your android phone (recommended)

To launch your application on your phone there are some settings to do so that the device is recognized and functional : 
  - Activate the **developer mode** ([i need help](https://developer.android.com/studio/debug/dev-options.html#enable))
  - Enable **usb debugging** ([i need help](https://developer.android.com/studio/run/device.html#setting-up))


Then select your device and lunch the application on your smartphone.   

<img alt="create emulateur" src="./docs/docs_imgs/select_phone.png">

### With an emulator

First, create your emulator by clicking on the **divice manager** button.   

<img alt="create emulateur" src="./docs/docs_imgs/create_emulateur.png">

Then select and launch the application on your emulator.   

<img alt="lunch emulateur" src="./docs/docs_imgs/lunch_emulateur.png">
 
### Additional documentation

For more resources on learning Android development, visit the [Developer Guides](https://developer.android.com/guide) at [developer.android.com](https://developer.android.com/).

## Launch Tests

Thanks to the github action your tests will be automatically launched when you make a pull request to dev or master.

To run your tests locally :        
  `gradle test`

## Libraries and Bots Used

  Dependabot used to update dependencies
  
  Testing:
  
    MockK for instrumented tests
    espresso for UI tests
    jUnit for unit tests

## Licences

Copyright 2022 BoubouleCorp, Inc.     
More details [here](https://youtu.be/dQw4w9WgXcQ)

## Support

Please contact us on this email address for anything to report     
**bouboulecorp@gmail.com**
