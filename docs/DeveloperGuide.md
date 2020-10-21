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

### Dark/Light Mode:

### Start Semester:

### Show progress towards target CAP:

# Non-Functional Requirements



1. Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2. Should be able to hold up to 1000 modules without a noticeable sluggishness in performance for typical usage.
3. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.

_{More to be added}_


# Glossary



*   **Mainstream OS**: Windows, Linux, Unix, OS-X
