# User Guide

MyMods is a **desktop app for tracking modules and grades, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, MyMods can get your module management tasks done faster than traditional GUI apps.



*   Features
    *   Adding a module: add
    *   View modules added up to date, and current CAP: list
    *   S/U a module: s/u
    *   Deleting a module: delete
    *   Start editing modules: start
    *   Exit editing semester: exit



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

1. Type add --mod CS2107 into the command box, and press Enter to execute it. \
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


### View modules: `list`
Displays the list of modules and their respective grades (if any). Narrow to specific semester if stated. \
 \
Format: `list [--sem SEMESTER]` \
 \
Examples:
*   `list`
*   `list --sem Y1S1`
*   `list --sem Y2S1 `
*   `list --sem y2s1 `

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
1. Type `recommendSU` into the command box, and press `Enter` to execute it. \
<img src="images/UG SS/2.7 Recommend SU 1.png" width="993px" height="131px">

2. The result box will display the message (if there are suitable modules to recommend): \
<img src="images/UG SS/2.7 Recommend SU 2.png" width="595px" height="220px">

3. Check the module(s) that are recommended to S/U in the list below:
<img src="images/UG SS/2.7 Recommend SU 3.png" width="595px" height="336px">


### S/U module:` s/u `
S/U a module in your modules list. \
 \
Format: `s/u --mod MODULE_CODE` \
 \
Examples:` `
*   `s/u --mod CS1101S`
*   `s/u --mod CS1231S`


### Deleting:` delete`
Deletes a module in your modules list. If a grade is provided, the grade of the mod will be deleted instead. \
 \
Format: `delete MODULE_CODE` \
 \
Examples:
*   `delete CS1101S`
*   `delete CS2103T`


### Done Semester:` done`
Done with editing that semester. \
 \
Format: `done SEMESTER` \
 \
Examples:
*   `exit Y2S1`
