---
layout: page
title: User Guide
---

# 1. Product Overview <a name="Product_Overview"></a>
Welcome to **MyMods**! Let us guide you through the overview of **MyMods** in this section.

### 1.1 Table of Contents <a name="Table_of_Contents"></a>

* [1. Product Overview](#Product_Overview)
    * [1.1 Table of Contents](#Table_of_Contents)
    * [1.2 About](#About)
    * [1.3 Introduction](#Introduction)
    * [1.4 Glossaries](#Glossaries)
    * [1.5 Getting Started](#Getting_Started)
    
* [2. Key Features](#Key_Features)
    * [2.1 Summary of Key Features](#Summary_of_Key_Features)
    * [2.2 Edit Semester](#Edit_Semester)
    * [2.3 Add Module](#Add_Module)
    * [2.4 Update Module](#Update_Module)
    * [2.5 List all Modules](#List_all_Modules)
    * [2.6 Set Goals](#Set_Goals)
    * [2.7 Recommend S/U](#Recommend_S/U)
    * [2.8 S/U Module](#S/U_Module)
    * [2.9 Delete Module](#Delete_Module)
    * [2.10 Exit Semester](#Exit_Semester)
    * [2.11 Find Module](#Find_Module)
    * [2.12 Progress Report](#Progress_Report)
    * [2.13 Get Help](#Get_Help)
    * [2.14 Exit Application](#Exit_Application)

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
<div markdown="span" class="alert alert-primary">
:bulb: This symbol indicates good-to-know tips.
</div>

* Important information will be shown in a box:
<div markdown="span" class="alert alert-info">
:warning: This symbol indicates important information.
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

### 1.5 Getting Started <a name="Getting_Started"></a>

#### Installation

1. Grab a cup of coffee ☕.
2. Ensure you have Java 11 or above installed in your computer.
3. Download the last MyMods.jar file from [here](https://github.com/AY2021S1-CS2103T-T17-1/tp/releases/tag/v1.3.1).
4. Place the file in any folder that you want to be the home folder for **MyMods**.
5. Start the web application by double-clicking the file or run it with `java -jar
MyMods.jar`. The window (without any modules) similar to the interface shown below will appear.

<div markdown="block" class="alert alert-primary">
:bulb: Check your Java version by typing java -version in the Command Prompt<br>

<img src="images/UG SS/1.5 Getting Started 1.png">
</div>

The data of all of your modules can be found on your local disk. It is located in the “data” folder found at the 
home folder.

#### The Interface

This is what MyMods looks like: \
<img src="images/UG SS/1.5 Getting Started 2.png">

<div markdown="span" class="alert alert-primary">
:bulb: Default colours looking different? Fret not! The theme of MyMods is determined by the time of the day. 
You can change the colours using the tab “Theme”.
</div>

---

# 2. Key Features <a name="Key_Features"></a>

Below is information about the features and commands of `MyMods`.

<div markdown="span" class="alert alert-info">
:warning: <strong>Important information about the command format:</strong><br><br>

* Words in <strong>UPPER_CASE</strong> are the parameters to be supplied by the user. e.g. in add `m/MODULE_CODE`, `MODULE_CODE` is a parameter which can be used as `add m/CS2100`.<br><br>

* Items in <strong>SQUARE BRACKETS</strong> are optional input parameters. e.g `m/MODULE_CODE [g/GRADE]` can be used as `m/CS2100 g/A` or as `m/CS2100`.<br><br>

* Parameters are <strong>NOT case-sensitive</strong>. e.g. `add m/CS2100` is the same as `add m/cs2100`.<br><br>

</div>

### 2.1 Summary of Key Features <a name="Summary_of_Key_Features"></a>

Command | Format
--------|-------
`start` | `start SEMESTER`
`add` | `add m/MODULE_CODE [g/GRADE] [mc/MODULAR_CREDIT]`
`update` | `update m/MODULE_CODE [g/GRADE] [s/SEMESTER]`
`list` | `list`
`goal` | `goal set LEVEL` or `goal list`
`recommendSU` | `recommendSU`
`su` | `su MODULE_CODE`
`delete` | `delete MODULE_CODE`
`done` | `done`
`find` | `find KEYWORD`
`progress` | `progress [ddp]`
`help` | `help`
`exit` | `exit`

### 2.2 Edit Semester: `start` <a name="Edit_Semester"></a>
Can’t wait to add your modules into MyMods? You can start modifying the modules by starting a semester! \
\
Format: `start SEMESTER` \
\
Examples:
*   `start Y2S1` 

* Important information will be shown in a box:
<div markdown="span" class="alert alert-info">
:warning: You can only add, edit or delete modules after starting a particular semester.
</div>

To edit a Semester (e.g. Y2S1):

1. Type `start Y2S1` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.2 Edit Semester 1.png">

2. The result box will display the message: \
<img src="images/UG SS/2.2 Edit Semester 2.png">

<div markdown="span" class="alert alert-primary">
:bulb: You can check the current semester that you are editing at the bottom left corner of the interface:
</div>

### 2.3 Add module: `add` <a name="Add_Module"></a>
Yes! After starting a semester, we can now add a module to your list. \
\
Format: `add m/MODULE_CODE [g/GRADE]`\
\
Examples:
*   `add m/CS1101S`
*   `add m/CS1231 g/A`


To add a module (e.g. add CS1101S):

1. Type `add m/CS1101S g/A+` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.3 Add Module 1.png">

2. The result box will display the message: \
<img src="images/UG SS/2.3 Add Module 2.png">

3. You can check that the module is added in the list below: \
<img src="images/UG SS/2.3 Add Module 3.png">

<div markdown="span" class="alert alert-info">
:warning: Our database is valid up to modules in the AY19/20 academic year. So if the modules you are adding is 
new in AY20/21 academic year, the following message will be shown:<br><br>
</div>

To add a module that is not in our database(e.g. CS1101A): \
\
Type `add m/CS1101A mc/4` (with `mc/`) into the command box, and press Enter to execute it.<br>

<div markdown="span" class="alert alert-info">
:warning: Manually added modules will not be recommended to S/U for the command `recommendSU` and cannot be S/U-ed using the command `su`.

</div>

### 2.4 Update Module: `update` <a name="Update_Module"></a>
Oops, typed something wrong or want to change something? Use this update feature to change the module’s grade.
\
Format: `update m/MODULE_CODE [g/GRADE]` \
\
Examples:
*   `update m/CS1101S`
*   `update m/CS1101S g/A+`

To update a module (e.g. CS2030):

1. Type `update m/CS2030 g/A` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.4 Update Module 1.png">

2. The result box will display the message:
<img src="images/UG SS/2.4 Update Module 2.png">

3. You can check that the module is updated from the list below:
<img src="images/UG SS/2.4 Update Module 3.png">


### 2.5 List all Modules: `list` <a name="List_all_Modules"></a>
Displays the list of modules and their respective grades (if any). 
Narrow to specific semester if stated. If no semester is stated, the current semester you
are editing will be displayed.\
 \
Format: `list` \
 \
Examples:
*   `list`

<div markdown="span" class="alert alert-info">
:warning: <strong>If you are editing a semester</strong> (e.g. Y2S1), 
only modules from that semester(e.g. Y2S1) will be listed.
</div><br>
To view all the modules that you have taken:

1. Type `list` into the command box, and press Enter to execute it.
<img src="images/UG SS/2.5 List all Modules 1.png">

2. The result box will display the message:
<img src="images/UG SS/2.5 List all Modules 2.png">

3. You can check that all the modules are shown in the list below:
<img src="images/UG SS/2.5 List all Modules 3.png">


### 2.6 Set Goals: `goal` <a name="Set_Goals"></a>
Reach for the stars! Set your goal level according to NUS’ Honours Classification System 
or list to show the corresponding levels. \
 \
Format: `goal set LEVEL` or `goal list` \
 \
Examples:
*   `goal set 2`
*   `goal list`

<div markdown="span" class="alert alert-primary">
:bulb: Below is the NUS Honours Classification System with respect to the `LEVEL`:
</div><br>

* `6`: Highest Distinction (CAP **4.50 ~ 5.00**)
* `5`: Distinction (CAP **4.00 ~ 4.49**)
* `4`: Merit (CAP **3.50 ~ 3.99**)
* `3`: Honours (CAP **3.00 ~ 3.49**)
* `2`: Pass (CAP **2.00 ~ 2.99**)
* `1`: Fail (CAP **< 2.00**)<br><br>

<div markdown="span" class="alert alert-primary">
:bulb: You can also show the same list in MyMods using `goal list`:
</div>

To set your goal to 2 (CAP4.00 ~ 4.49):

1. Type `goal set 2` into the command box,  and press Enter to execute it. \
<img src="images/UG SS/2.6 Set Goals 1.png">

2. The result box will display the message: \
<img src="images/UG SS/2.6 Set Goals 2.png">

<div markdown="span" class="alert alert-primary">
:bulb: You can check your current goal using the command `progress`:

</div>


### 2.7 Recommend S/U: `recommendSU` <a name="Recommend_S/U"></a>
Having a headache on what module you should S/U? This feature will ease your headache by recommending which module(s) 
from your list to S/U based on your goal, grades and if the module can be S/U-ed. \
 \
Format: `recommendSU` \
 \
Example:
*   `recommendSU`

To get recommendations on which modules to S/U:
1. Type `recommendSU` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.7 Recommend SU 1.png">

2. The result box will display the message (if there are suitable modules to recommend): \
<img src="images/UG SS/2.7 Recommend SU 2.png">

3. Check the module(s) that are recommended to S/U in the list below: \
<img src="images/UG SS/2.7 Recommend SU 3.png">

<div markdown="span" class="alert alert-info">
:warning: If there are no modules for us to recommend you to S/U, the result box will show:<br><br>
</div>

<div>
:warning: Manually added modules will not be recommended to S/U for the command `recommendSU` and cannot be S/U-ed 
using the command `su`.
</div>

### 2.8 S/U module: `su` <a name="S/U_Module"></a>
Didn’t so very well for a module? S/U the module in your list using this feature! \
 \
Format: `su MODULE_CODE` \
 \
Examples:
*   `su CS1101S`
*   `su CS1231S`

To S/U a module (e.g. CS1231):
1. Type `su CS1231S` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.8 SU Module 1.png">

2. The result box will display the message (if the module can be S/U-ed): \
<img src="images/UG SS/2.8 SU Module 2.png">

3. Check if the module’s grade has been changed to “SU” in the list below: \
<img src="images/UG SS/2.8 SU Module 3.png">

<div markdown="span" class="alert alert-info">
:warning: If the module cannot be S/U-ed according to NUS’ guidelines or the module is manually added using parameter `mc/`, the command box will display:
<br>
<img src="images/UG SS/2.8 SU Module 4.png">
</div>

### 2.9 Delete Module: `delete` <a name="Delete_Module"></a>
If you want to remove a module from your list, use this feature to delete the module along with its grade 
from your list of modules. \
 \
Format: `delete MODULE_CODE` \
 \
Examples:
*   `delete CS1101S`

To delete a module (e.g. CS1231) from the list: \
<img src="images/UG SS/2.9 Delete Module 1.png">

1. Type `delete CS1231` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.9 Delete Module 2.png">

2. The result box will display the message: \
<img src="images/UG SS/2.9 Delete Module 3.png">

3. The module CS1231 will be deleted from the list below: \
<img src="images/UG SS/2.9 Delete Module 4.png">


### 2.10 Exit Semester: `done` <a name="Exit_Semester"></a>
Finally done with editing the semester? You will not be able to change any module in a particular 
semester until you start another semester. \
 \
Format: `done` \
 \
Examples:
*   `done`

To stop editing a semester (e.g. Y1S1):

1. Type `done` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.10 Exit Semester 1.png">

2. The result box will display the message: \
<img src="images/UG SS/2.10 Exit Semester 2.png">

<div markdown="span" class="alert alert-primary">
:bulb: You can check the current semester that you are editing at the bottom left corner of the interface:
</div>

### 2.11 Find Module: `find` <a name="Find_Module"></a>

Unable to find a module that you took? Search it using the find command. \
\
Format: find KEYWORD \
\
Examples:
* `find CS1101S`
*  `find MA`

<div markdown="span" class="alert alert-primary">
:bulb: Searching for part of the module code will work too. For example, you can `find CS1231` to find the 
module CS1231S or `find CS` to find all modules that contain the word ‘CS’.
</div>

To search for a module (e.g. CS):

1. Type `find CS` into the command box, and press Enter to execute it. 

2. The modules that contain the keyword ‘CS’ will be listed below: 

<div markdown="span" class="alert alert-primary">
:bulb: If there is no module that matches the keyword, the following message will be shown:
</div>

### 2.12 Progress Report: `progress` <a name="Progress_Report"></a>
Want to know how well you are doing relative to your goal? Use this feature for a progress report 
that calculates the average CAP required for your remaining modules to achieve your target CAP. 
It shows you your current goal that you have set as well.

Format: `progress [ddp]` 
 
Examples:
*   `progress`
*   `progress ddp`

<div markdown="span" class="alert alert-primary">
:bulb: ddp here refers to NUS’s Double Degree Programme. Include it if you are in a ddp.
</div>
 
To calculate the CAP required to achieve your goal:

1. Type `progress` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.11 Progress Report 1.png">

2. The result box will display the message: \
<img src="images/UG SS/2.11 Progress Report 2.png">


### 2.13 Get Help: `help` <a name="Get_Help"></a>
If you are lost, this command will be helpful. 

Format: `help` \
 \
Examples:
*   `help`

To seek help:

1. Type `help` in the command box, and press Enter to execute it. \
<img src="images/UG SS/2.12 Get Help 1.png">

2. The result box will display the message with an additional pop-up window: \
<img src="images/UG SS/2.12 Get Help 2.png">


### 2.14 Exit Application: `exit` <a name="Exit_Application"></a>
Exits the application. 

Format: `exit` \
 \
Examples:
*   `exit`

To exit the application:
1. Type `exit` into the command box, and press Enter to execute it. \
<img src="images/UG SS/2.13 Exit Application 1.png">



