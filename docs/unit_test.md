# Unit Test for Kotlin
We are using 2 test frameworks and an official api:
JUnit:  https://junit.org/junit5/
MockK:  https://mockk.io/
Espresso: https://developer.android.com/training/testing/espresso/

## Junit
JUnit is a unit test framework for the Android programming, also for kotlin. 

It's auto-included in the kotlin basic template, it tests all the function which has a return value.

### Implementation
As JUnit is a standard testing package for kotlin, it already exists in our dependencies of app.gradle file.
```kotlin
testImplementation 'junit:junit:4.+' //standard test plugin for java  
androidTestImplementation 'androidx.test.ext:junit:1.1.3'  
androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'//library for UI testing
```

Here we can find two types of implementations:

 - **testImplementation** : not reply on any android component such as context etc

 - **androidTestImplementation** : only run on the android emulator

But we do need to add one more package here which names **Truth**, this package is for making the test result more readable:
```kotlin
testImplementation "com.google.truth:truth:1.0.1"  
androidTestImplementation "com.google.truth:truth:1.0.1"
```

###  Test Example
```kotlin
@Test //annodate the test function  
fun `empty username returns false`() {  //to check whether the username is empty
    val res = RegistrationUtil.validateReistrationInput( //main function class name and funciton  
  username:"", //parameters  
  password:"123",  
  confirmed password: "123"  
  )  
    assertThat(res).isFalse() //the correct return value should return false  
}
```

## MockK

## Why use MockK

Classes usually depend on other classes to run properly. A Car class may depend on an Engine class. You need to provide these dependencies for the Car to work, but it’s hard to write tests in isolation if you’re also configuring the Engine at the same time. You can work around this problem by creating fake versions of the dependencies. These fake classes are called “mocks”. 

In kotlin, most of the classes and the methods are final, If a class is marked as final then no class can inherit any feature from the class by using only Junit to test our code that will be difficult, that's why we use also MockK.

### Implementation
To import mockK we need to add it to our build.gradle file.

```kotlin
dependencies {
  ...
  testImplementation "io.mockk:mockk:$mockk_version"
}
```

### Example

You can find examples of testing a class and explainations on MockK and JUnit in the following articles:

  https://codetoart.com/blog/unit-testing-using-mockk-io-in-kotlin

  https://sonique6784.medium.com/pure-kotlin-unit-testing-mocking-part-2-e13857014ea6

### Ressources

https://mockk.io/

https://notwoods.github.io/mockk-guidebook/

https://codetoart.com/blog/unit-testing-using-mockk-io-in-kotlin

https://sonique6784.medium.com/pure-kotlin-unit-testing-mocking-part-2-e13857014ea6

## Espresso

## Why use Espresso

Use Espresso to write concise, beautiful, and reliable Android UI tests. We will use espresso for front-end testing it's not a framework but an API included in the android package that we need to import as a kotlin dependency.

### Implementation

To import espresso add the following to your build.gradle check this link which is the offcial doc: 

https://developer.android.com/training/testing/espresso/setup#kts

```kotlin
dependencies {
  ...
  androidTestImplementation('androidx.test.espresso:espresso-core:3.4.0')
  androidTestImplementation('androidx.test:runner:1.4.0')
  androidTestImplementation('androidx.test:rules:1.4.0')
}
```
### Example

You can find an example of testing a class and explainations on espresso in the following article:

https://proandroiddev.com/pleasant-fun-painless-delightful-espresso-testing-with-kotlin-3ffeda58d45c

And by reading the official documentation here: 

https://developer.android.com/training/testing/espresso/
