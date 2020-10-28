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

To update a module (e.g. CS2030):

1. Type `update --mod CS2030 --grade A` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.4 Update Module 1.png" width="989px" height="133px">

2. The result box will display the message:
<img src="images/UG SS/2.4 Update Module 2.png" width="989px" height="133px">

3. You can check that the module is updated from the list below:
<img src="images/UG SS/2.4 Update Module 3.png" width="990px" height="484px">


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

To view all the modules that you have taken:

1. Type list into the command box, and press Enter to execute it.
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

To S/U a module (e.g. CS1231):
1. Type s/u --mod CS1231 into the command box, and press Enter to execute it.
<img src="images/UG SS/2.8 SU Module 1.png" width="603px" height="84px">

### Deleting:` delete`
Deletes a module in your modules list. If a grade is provided, the grade of the mod will be deleted instead. \
 \
Format: `delete MODULE_CODE` \
 \
Examples:
*   `delete CS1101S`
*   `delete CS2103T`

To delete a module (e.g. CS1231) from the list:
<img src="images/UG SS/2.9 Delete Module 1.png" width="602px" height="347px">

1. Type delete CS1231 into the command box, and press Enter to execute it.
<img src="images/UG SS/2.9 Delete Module 2.png" width="605px" height="85px">

2. The result box will display the message:
<img src="images/UG SS/2.9 Delete Module 3.png" width="604px" height="152px">

3. The module CS1231 will be deleted from the list below:
<img src="images/UG SS/2.9 Delete Module 4.png" width="603px" height="445px">


### Exit Semester:` done`
Stops editing the semester you are currently editing.
You will not be able to change any module in a particular semester until you start another semester. \
 \
Format: `done SEMESTER` \
 \
Examples:
*   `done Y2S1`

To stop editing a semester (e.g. Y1S1):

1. Type done into the command box, and press Enter to execute it.
<img src="images/UG SS/2.10 Exit Semester 1.png" width="605px" height="81px">

2. The result box will display the message:
<img src="images/UG SS/2.10 Exit Semester 2.png" width="603px" height="154px">


### Progress Report:` progress`
Calculates the average CAP required for your remaining modules to achieve your target CAP.

Format: `progress [--ddp]` 
 
Examples:
*   `progress`
*   `progress --ddp`
 
To calculate the CAP required to achieve your goal:

1. Type progress into the command box, and press Enter to execute it.
<img src="images/UG SS/2.11 Progress Report 1.png" width="606px" height="74px">

2. The result box will display the message:
<img src="images/UG SS/2.11 Progress Report 1.png" width="607px" height="155px">


### Get Help:` help`
If you are lost, this command will be helpful. 

Format: `help` \
 \
Examples:
*   `help`

To seek help:

1. Type help in the command box, and press Enter to execute it.
<img src="images/UG SS/2.12 Get Help 1.png" width="642px" height="111px">

2. The result box will display the message with an additional pop-up window:
<img src="images/UG SS/2.12 Get Help 2.png" width="641px" height="468px">


### Exit Application:` exit`
Exits the application. 

Format: `exit` \
 \
Examples:
*   `exit`

To exit the application:
1. Type exit into the command box, and press Enter to execute it.
<img src="images/UG SS/2.13 Exit Application 1.png" width="602px" height="74px">



