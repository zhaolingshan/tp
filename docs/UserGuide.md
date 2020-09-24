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

### Start editing: `start`
Start editing modules to the semester.
\
Format: `start --sem SEMESTER`
\
Examples:
*   `start --sem Y2S1`

### Adding a module: `add`



### Updating a module: `update`



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
Format: `delete --mod MODULE_CODE [--grade]` \
 \
Examples:
*   `delete --mod CS1101S`
*   `delete --mod CS1101S --grade`


### Exit Semester:` exit`
Exit editing that semester. \
 \
Format: `exit --mod MODULE_CODE` \
 \
Examples:
*   `exit --sem Y2S1`
