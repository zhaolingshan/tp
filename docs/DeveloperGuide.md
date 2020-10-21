---
layout: page
title: Developer Guide
---

# Developer Guide



*   **[Product scope](https://ay2021s1-cs2103t-t17-1.github.io/tp/DeveloperGuide.html#product-scope)**
    *   [User stories](https://ay2021s1-cs2103t-t17-1.github.io/tp/DeveloperGuide.html#user-stories)
    *   [Use cases](https://ay2021s1-cs2103t-t17-1.github.io/tp/DeveloperGuide.html#use-cases)
    *   [Non-Functional Requirements](https://ay2021s1-cs2103t-t17-1.github.io/tp/DeveloperGuide.html#non-functional-requirements)
    *   [Glossary](https://ay2021s1-cs2103t-t17-1.github.io/tp/DeveloperGuide.html#glossary)


# Product scope


## Target user profile:



*   NUS students

**Value proposition**: You type, We track.

Track and view your modules and grades efficiently, anytime anywhere.


## User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`


<table>
  <tr>
   <td><strong>Priority</strong>
   </td>
   <td><strong>As a …​</strong>
   </td>
   <td><strong>I want to …​</strong>
   </td>
   <td><strong>So that I can…​</strong>
   </td>
  </tr>
  <tr>
   <td><code>* * *</code>
   </td>
   <td>NUS student
   </td>
   <td>add the modules taken and grades attained
   </td>
   <td>view them anytime anywhere.
   </td>
  </tr>
  <tr>
   <td><code>* * *</code>
   </td>
   <td>NUS student
   </td>
   <td>add my modules taken to reflect my CAP, and be able to update those modules when I S/U it to reflect my updated CAP
   </td>
   <td> I can view my new CAP.
   </td>
  </tr>
  <tr>
   <td><code>* * *</code>
   </td>
   <td>NUS student
   </td>
   <td>view my current progress of my modules taken and my CAP
   </td>
   <td>have a gauge of how I am doing in school.
   </td>
  </tr>
  <tr>
   <td><code>* * *</code>
   </td>
   <td>impatient NUS student
   </td>
   <td>calculate my CAP as fast as possible without doing any calculations myself
   </td>
   <td>use the time that will be spent on doing manual calculations more productively.
   </td>
  </tr>
  <tr>
   <td><code>* *</code>
   </td>
   <td>NUS student
   </td>
   <td>delete a module taken or the grade attained in the event that I decide to drop the module
   </td>
   <td>I am able to view an updated list of the modules I am currently taking and view my CAP without the grade from the dropped module.
   </td>
  </tr>
</table>


_{More to be added}_

## Use cases

(For all use cases below, the **System** is the `MyMods` and the **Actor** is the `user`, unless specified otherwise)

####**Use case: Delete a module**

**MSS**



1. User requests to list modules
2. MyMods shows a list of modules he/she has taken
3. User requests to delete a specific module in the list
4. MyMods deletes the module \
Use case ends.


**Extensions**



*   2a. The list is empty. \
Use case ends.
*   3a. The given index is invalid.
    *   3a1. MyMods shows an error message.
    *   Use case resumes at step 3.

####**Use case: Add a module**

**MSS**



1. User enters academic semester to edit
2. MyMods shows the academic semester and a list of modules he/she has taken
3. User requests to add a specific module into the list
4. MyMods adds the module \
Use case ends.


**Extensions**



*   1a. Academic semester not found \
Use case ends.
*   3a. Module moduleName already exists.
    *   3a1. MyMods shows an error message.
    *   Use case resumes at step 3.

####**Use case: View CAP**

**MSS**



1. User requests to show CAP
2. MyMods shows CAP for the latest completed semester

**Extensions**



*   1a. No modules has been added, CAP is undefined
    *   1a1. MyMods shows an error message suggesting user to add modules \
Use case ends.



#Implementations 
This section describes some noteworthy details on how certain features are implemented.

### Obtaining module information automatically:
This feature is facilitated by ```ModuleInfoRetriever```, and is used to obtain the number of modular credits 
when you are adding a module, or the “su” status of the module when you are recommending S/U options. 

It implements the following operation:
```ModuleInfoRetriever#retrieve(String moduleName)``` - Returns a HashMap containing module-related information.

Given below is an example usage scenario and how obtaining module information is used and integrated into 
the ```add``` command.

Step 1: The users executes ```add --mod CS1101S --grade A+```, the add command executes 
```Logic#execute(“add --mod CS1101S --grade A+”)```

Step 2: Logic uses the ```AddCommandParser``` class to parse the command. 
```AddCommandParser#parse(“add --mod CS1101S --grade A+”)``` is executed, which then executes 
```(ModuleInfoRetriever#retrieve(“CS1101S”)``` to retrieve the number of modular credits CS1101S has.

Step 3: During the call of ```ModuleInfoRetriever#retrieve(“CS1101S”)``` , it parses the JSON file 
```moduleInfo.json```, and searches the file for “moduleCode” : “CS1101S”, retrieving the following information, 
returning it as a HashMap. 
\
\
Title: “Programming Methodology”
\
moduleCredit: 4
\
SU: True
An exception is thrown if the module is not found.

Step 4: The new module constructor is executed with the following arguments, 
```new Module(“CS1101S”, “A+”, Set<Tag>(), 4, Y2S1)```. An AddCommand object is then returned with the module, 
and the new module with modular credit information is saved to storage.

### Recommend S/U:
#### Implementation
The Recommend S/U feature works in conjunction with the goal-setting feature. 
MyMods will recommend modules to S/U based on the goal that the user has set and the user’s grade. \
\
The implementation of goal-setting is first done by introducing a new model class - ```GoalTarget```. 
The ```GoalTarget``` class models the 6 different levels following the Honours Classification in NUS. 
For the user to set their goal, there is a ```SetCommand``` class under the logic commands. 
There will be two different variants of the goal command, there is a ```SetCommandParser``` class under parser to 
handle the different user’s input: ```goal --set``` and ```goal --list```. 
The goal of the user will update a field under ```ModelManager```. \
\
User’s goal will be written to and can be read from the ```addressbook.json``` file under the attribute 
“```goalTarget```” which will store a default value of ```0```. \
\
To implement the command ```RecommendSU```, a class ```RecommendSuCommand``` is introduced in logic commands. 
To determine which module to recommend the user to S/U the method ```RecommendSuCommand#filterModule()``` will 
retrieve the user’s goal and modules and filter using the following three conditions:
1. ```RecommendSuCommand#isModSuAble()``` -- Checks if module can be S/U by NUS based on data 
file ```moduleInfo.json```. \
2. ```RecommendSuCommand#isGradeBelowGoal()``` -- Checks if the grade of the module is below the lower bound of the 
goal. \
3. ```RecommendSuCommand#isGradeAboveC()``` -- Checks if the grade of the module is C and above. \
\
#### Design Considerations:
Aspect: How to represent the different levels of goals (Highest Distinction, Distinction, Merit, Honours, Pass, Fail) \
* Alternative 1 (current choice): Labels each level with a number 1 to 6 and the user inputs the level number to 
set the goal. \
    * Pros: \
        1. Using number to label the goals is easier for the user to type 
        (eg: ```goal --set 2``` instead of ```goal --set distinction```) \
        2. Using an integer value is more efficient for comparison as compared to a String. \
    * Cons: \
        1. Difficult for the user to know which level represents which goal. \
* Alternative 2: User key in the full name of the goal level. \
    * Pros: \
        1. User knows what to key in without referring. \
    * Cons: \
        1. It is longer for the user to type. \
* Justification of choosing Alternative 1: Having a shorter command will be easier for the user. 
To solve the con of the user not sure on which level represents which goal, the command “```goal --list```” is 
provided.



### Dark/Light Mode:

####Implementation

The dark and light mode switch is part of the UI implementation that allows the user to instantly switch between two different styles of the application. It is facilitated by the ```MainWindow component``` in the UI component and the ```Scene``` object from the ```Stage``` object(private property in ```MainWindow```). **The stylesheet property in the ```Scene``` object is manipulated**. The two different stylings are supplied by two CSS files that contain CSS styling for both dark and light mode separately.

The following method in ```MainWindow``` facilitates the switching process:
- ```MainWindow#setStyleSheet(String cssFileName)``` - sets a specific CSS file to be the current stylesheet for UI.

Flow of method:
1. “Light” is selected
2. ```MainWindow``` calls ```setStyleSheet(“Light”)```
3. ```Scene``` object is obtain from ```Stage``` object
4. An ```ObservableList<String>``` of stylesheets is obtained from ```Scene``` object
5. File path to the “Light” CSS file is added as a string that overrides the current ```ObservableList<String>``` of stylesheets

**Default theme** is Dark theme supplied by DarkTheme.css

####User Interaction

Users have the ability to easily choose which mode under the “Theme” menu bar. Either “Dark” or “Light”.

### Start Semester:
Implementation

Start is a command which allows the user to start modifying the list of modules in the semester which the user 
specifies by adding, editing or deleting the modules in the specified semester. The user is unable to modify the list 
of modules before typing in start followed by the semester which the user wishes to edit the module list of.
A class StartCommand is added in the commands folder under logic to execute the command start. 
A class SemesterManager is added in the semester folder under model to retrieve the current semester the user is in 
and set the current semester to a specified semester. 

### Show progress towards target CAP:

####Implementation

The progress feature works in conjunction with the goal-setting feature. 
The user will first need to indicate their desired CAP using the `goal` command.
\
\
Users can then use the command `progress` to calculate the required average CAP 
they have to obtain in their remaining modules in order to achieve their 
target CAP. The user can include the string `--ddp` to indicate if they are taking 
a double degree programme (e.g. `progress --ddp`).
\
\
A `ProgressCommand class` is added to commands under logic to execute the required
CAP calculation. The calculation process is done as shown below:

 1. User enters their target CAP using `goal` command
 2. Info about current CAP and MCs taken are retrieved from the `ModelManager` class
 3. Total MCs required is determined by whether user is in double degree programme 
 or not (e.g. user input is `progress --ddp` or `just progress`) 
 4. Target CAP is retrieved from the `ModelManager` class
 5. Required CAP from remaining modules is calculated.

# Non-Functional Requirements



1. Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2. Should be able to hold up to 1000 modules without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

_{More to be added}_


# Glossary



*   **Mainstream OS**: Windows, Linux, Unix, OS-X
