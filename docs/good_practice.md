# Good Practice

In addition to the linter and the dependabot, here are some tips for a more maintainable and readable code

## Horizontal alignment of layouts

### Baseline : 
Force the alignment of the different elements
To do this, right-click on the layout and select `Show Baseline`

### Horizontal chains
Allows you to make the application responsive very easily.


More explanation and example [here](https://developer.android.com/training/basics/firstapp/building-ui)

## Add your resources to the values folder

by
  - string
  - color
  - themes
 
 to allow everyone to have the same base and to avoid duplication.

## Explicit error handling with logs

Each error should be accompanied by an explicit log to facilitate maintenance

## A lot of test

Read the documentation at this location : `/docs/unit_test.md`

## File naming

Since in the RES folder we cannot add new folders here are some naming rules for a better readability :

FOLDER-NAME_Sub-file_file-name

### Example :     
`HOMEPAGE_Settings_PrivacyPolicyFragment.xml`       
`ICON_NavBar_SearchIcon.svg`

## Variable naming

By convention, props sent from one activity to another are called this way:
`const val EXTRA_MESSAGE = "com.bouboulecorp.thurii.MESSAGE
`
## Additional documentation 

For more details go to the official [kotlin best practice page](https://kotlinlang.org/docs/coding-conventions.html)
