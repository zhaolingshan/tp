---
layout: page
title: User Guide
---

## 1. Product Overview <a name="Product Overview"></a>
Welcome to **MyMods**! Let us guide you through the overview of **MyMods** in this section.

### 1.1 Table of Contents <a name="Table of Contents"></a>

* [1. Product Overview](#Product Overview)
    * [1.1 Table of Contents](#Table of Contents)
    * [1.2 About](#About)
    * [1.3 Introduction](#Introduction)
    * [1.4 Glossaries](#Glossaries)
    * [1.5 Getting Started](#Getting Started)
    
* [2. Key Features](#Key Feature)
    * [2.1 Summary of Key Features](#Summary of Key Feature)
    * [2.2 Edit Semester](Edit Semester)
    * [2.3 Add Module](#Add Module)
    * [2.4 Update Module](#Update Module)
    * [2.5 List all Modules](#List all Modules)
    * [2.6 Set Goals](#Set Goals)
    * [2.7 Recommend S/U](#Recommend S/U)
    * [2.8 S/U Mobile](#S/U Module)
    * [2.9 Delete Module](#Delete Module)
    * [2.10 Exit Semester](#Exit Semester)
    * [2.11 Progress Report](#Progress Report)
    * [2.12 Exit Application](#Exit Application)

### 1.2 About <a name="About"></a>

Are you a NUS student who wants a clean Command Line Interface (CLI) to keep track of your modules and grades? 
If yes, then this user guide is for you!

Want to know the common use cases, how to get started or in-depth documentation of all of our 13 key features in MyMods? 
We got that all covered for you in this user guide. 

And yes, that is right! We have 13 key features in MyMods: `start`, `add`, `update`, `list`, `goal`, `recommendSU`, 
`su`, `delete`, `done`, `find`, `progress`, `help` and `exit` commands. 

You do not need any prior technical knowledge to understand this document, however, you will need to know how to read 
English though!

**Navigating this user guide:**
* Tips will be shown in a box:
<div markdown="block" class="alert alert-info">
:bulb: This symbol indicates good-to-know tips.
</div>

* Important information will be shown in a box:
<div markdown="span" class="alert alert-info">
:information_source: This symbol indicates important information.
</div>

* `start`: A grey highlight (called a mark-up) indicates that this is a command that can be typed into the command line 
and executed by the application.


### 1.3 Introduction <a name="Introduction"></a>

So what exactly is **MyMods**? It is a desktop app for tracking modules and grades, optimized for use for students who 
prefer typing via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). 
With **MyMods**, you are able to keep track of your module results efficiently, easily make S/U decisions, and view your 
academic progress. **MyMods** is available for the Linux, Unix, Windows XP and Mac OS X operating systems.

### 1.4 Glossaries <a name="Glossaries"></a>

If you do not understand any of the terms or short forms that we used, you can refer to this table:

Term | Description
-----|------------
CAP | Cumulative Average Point
ddp | Double Degree Programme
mod | Module
S/U | Satisfactory / Unsatisfactory option in NUS

### 1.5 Getting Started <a name="Getting Started"></a>

#### Installation

1. Grab a cup of coffee ☕.
2. Ensure you have Java 11 or above installed in your computer.
3. Download the last MyMods.jar file from [here](https://github.com/AY2021S1-CS2103T-T17-1/tp/releases/tag/v1.3.1).
4. Place the file in any folder that you want to be the home folder for **MyMods**.
5. Start the web application by double-clicking the file or run it with `java -jar
MyMods.jar`. The window (without any modules) similar to the interface shown below will appear.

<div markdown="block" class="alert alert-info">
:bulb: Tip: Check your Java version by typing java -version in the Command Prompt

<img src="images/UG SS/1.5 Getting Started 1.png">
</div>

The data of all of your modules can be found on your local disk. It is located in the “data” folder found at the 
home folder.

#### The Interface

This is what MyMods looks like: \
<img src="images/UG SS/1.5 Getting Started 2.png">

<div markdown="span" class="alert alert-primary">
:bulb: Tip: Default colours looking different? Fret not! The theme of MyMods is determined by the time of the day. 
You can change the colours using the tab “Theme”.
</div>

---

## Features

**Notes about the command format:**

*   Words in UPPER_CASE are the parameters to be supplied by the user. \
e.g. in add --mod MODULE_CODE, MODULE_CODE is a parameter which can be used as add --mod CS2100.
*   Items in square brackets are optional. \
e.g --mod MODULE_CODE [--grade GRADE] can be used as --mod CS2100 --grade A or as --mod CS2100.
*   Parameters are not case-sensitive. e.g. add --mod CS2100 is the same as add --mod cs2100

### Edit Semester: `start`
Start modifying the modules in a particular semester by adding, editing or deleting modules. 
You can only add, edit or delete modules after starting a particular semester. \
\
Format: `start SEMESTER` \
\
Examples:
*   `start Y2S1` 

To edit a Semester (e.g. Y2S1):

1. Type `start Y2S1` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.2 Edit Semester 1.png" width="990px" height="150px">

2. The result box will display the message: \
<img src="images/UG SS/2.2 Edit Semester 2.png" width="990px" height="282px">

### Add a module: `add`
Adds a module to your modules list. \
\
Format: `add --mod MODULE_CODE [--grade GRADE]`
\
Examples:
*   `add --mod CS1101S`
*   `add --mod CS1231S --grade A`

To add a module (e.g. add CS1101S):

1. Type `add --mod CS2107` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.3 Add Module 1.png" width="989px" height="133px">

2. The result box will display the message: \
<img src="images/UG SS/2.3 Add Module 2.png" width="991px" height="729px">

3. You can check that the module is added in the list below: \
<img src="images/UG SS/2.3 Add Module 3.png" width="990px" height="484px">

### Updating a module: `update`
Updates the module’s grade.
\
Format: `update --mod MODULE_CODE [--grade GRADE]` \
\
Examples:
*   `update --mod CS1101S`
*   `Update --mod CS1101S --grade A+`

To update a module (e.g. CS2030):

1. Type `update --mod CS2030 --grade A` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.4 Update Module 1.png" width="989px" height="133px">

2. The result box will display the message:
<img src="images/UG SS/2.4 Update Module 2.png" width="989px" height="133px">

3. You can check that the module is updated from the list below:
<img src="images/UG SS/2.4 Update Module 3.png" width="990px" height="484px">


### View modules: `list`
Displays the list of modules and their respective grades (if any). 
Narrow to specific semester if stated. If no semester is stated, the current semester you
are editing will be displayed.\
 \
Format: `list [SEMESTER]` \
 \
Examples:
*   `list`
*   `list Y1S1`
*   `list Y2S1 `

To view all the modules that you have taken:

1. Type `list` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.5 List all Modules 1.png" width="989px" height="133px">

2. The result box will display the message:
<img src="images/UG SS/2.5 List all Modules 2.png" width="990px" height="282px">

3. You can check that all the modules are shown in the list below:
<img src="images/UG SS/2.5 List all Modules 3.png" width="990px" height="484px">


### Setting goals: `goal`
Sets your goal level according to the Honour's Grading System or list to show the corresponding levels. \
 \
Format: `goal --set LEVEL` or `goal --list` \
 \
Examples:
*   `goal --set 2`
*   `goal --list`



To set your goal to 2 (CAP4.00 ~ 4.49):

1. Type `goal --set 2` into the command box,  and press Enter to execute it. \
<img src="images/UG SS/2.6 Set Goals 1.png" width="989px" height="125px">

2. The result box will display the message: 
<img src="images/UG SS/2.6 Set Goals 2.png" width="989px" height="253px">


### Recommend S/U: `recommendSU`
Recommend which module from your list to S/U based on your goal, grades and if the module can be S/U-ed. \
 \
Format: `recommendSU` \
 \
Example:
*   `recommendSU`

To get recommendations on which modules to S/U:
1. Type `recommendSU` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.7 Recommend SU 1.png" width="993px" height="131px">

2. The result box will display the message (if there are suitable modules to recommend): \
<img src="images/UG SS/2.7 Recommend SU 2.png" width="595px" height="220px">

3. Check the module(s) that are recommended to S/U in the list below:
<img src="images/UG SS/2.7 Recommend SU 3.png" width="595px" height="336px">


### S/U module: `su`
S/U a module in your modules list. \
 \
Format: `su --mod MODULE_CODE` \
 \
Examples:` `
*   `su --mod CS1101S`
*   `su --mod CS1231S`

To S/U a module (e.g. CS1231):
1. Type `su --mod CS1231` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.8 SU Module 1.png" width="643px" height="93px">

2. The result box will display the message (if the module can be S/U-ed):
<img src="images/UG SS/2.8 SU Module 2.png" width="641px" height="171px">

3. Check the module’s grade is changed to “SU” in the list below:
<img src="images/UG SS/2.8 SU Module 3.png" width="642px" height="471px">

### Deleting: `delete`
Deletes a module in your modules list. If a grade is provided, the grade of the mod will be deleted instead. \
 \
Format: `delete MODULE_CODE` \
 \
Examples:
*   `delete CS1101S`
*   `delete CS2103T`

To delete a module (e.g. CS1231) from the list:
<img src="images/UG SS/2.9 Delete Module 1.png" width="602px" height="347px">

1. Type `delete CS1231` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.9 Delete Module 2.png" width="605px" height="85px">

2. The result box will display the message:
<img src="images/UG SS/2.9 Delete Module 3.png" width="604px" height="152px">

3. The module CS1231 will be deleted from the list below:
<img src="images/UG SS/2.9 Delete Module 4.png" width="603px" height="445px">


### Exit Semester: `done`
Stops editing the semester you are currently editing.
You will not be able to change any module in a particular semester until you start another semester. \
 \
Format: `done SEMESTER` \
 \
Examples:
*   `done Y2S1`

To stop editing a semester (e.g. Y1S1):

1. Type `done` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.10 Exit Semester 1.png" width="605px" height="81px">

2. The result box will display the message:
<img src="images/UG SS/2.10 Exit Semester 2.png" width="603px" height="154px">


### Progress Report: `progress`
Calculates the average CAP required for your remaining modules to achieve your target CAP.

Format: `progress [--ddp]` 
 
Examples:
*   `progress`
*   `progress --ddp`
 
To calculate the CAP required to achieve your goal:

1. Type `progress` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.11 Progress Report 1.png" width="606px" height="74px">

2. The result box will display the message:
<img src="images/UG SS/2.11 Progress Report 2.png" width="607px" height="155px">


### Get Help: `help`
If you are lost, this command will be helpful. 

Format: `help` \
 \
Examples:
*   `help`

To seek help:

1. Type `help` in the command box, and press Enter to execute it.
<img src="images/UG SS/2.12 Get Help 1.png" width="642px" height="111px">

2. The result box will display the message with an additional pop-up window:
<img src="images/UG SS/2.12 Get Help 2.png" width="641px" height="468px">


### Exit Application: `exit`
Exits the application. 

Format: `exit` \
 \
Examples:
*   `exit`

To exit the application:
1. Type `exit` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.13 Exit Application 1.png" width="602px" height="74px">



