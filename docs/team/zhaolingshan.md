---
layout: page
title: Zhao Ling Shan's Project Portfolio Page
---

## Project: MyMod

MyMod is a desktop mod tracking application used for tracking mods in NUS.
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to start editing a semester.
  * What it does: allows the user to start editing a particular semester one at a time. The user can add, delete, upgrade the grade or semester, and S/U modules in a semester only after the user starts that specific semester.
  * Justification: This feature improves the product significantly because a user can edit the modules in a specific semester and keep track of the modules
  he is taking in a specific semester, and the changes he made to them. The app should provide a convenient way to segregate the modules in different semesters to keep it organised and enhance readability.
  * Highlights: This enhancement affects existing commands and commands to be added in the future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.

* **New Feature**: Added the ability to stop editing a semester.
  * What it does: allows the user to stop editing a particular semester one at a time. The user cannot add, delete, upgrade the grade or semester, and S/U modules in a semester after the user exits that specific semester.
  * Justification: This feature improves the product significantly because a user can stop editing the modules in a specific semester which allows the user to navigate to and make changes to the modules in a different semester.
  This allows users to make changes to the modules in different semesters. The app should provide a convenient way to segregate the modules in different semesters to keep it organised and enhance readability.
  Once the user is done editing a specific semester, he will be brought back to the main list of modules.
  * Highlights: This enhancement affects existing commands and commands to be added in the future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.

* **New Feature**: Added the ability to calculate and display the current CAP.
  * What it does: calculates the CAP automatically after every modification the user makes including adding a module, updating the grade of a module, and S/U-ing a module.
  * Justification: This feature improves the product significantly because a user can view how each change he makes will affect the CAP and see an instantaneous change in the CAP without having to do any manual calculations.
  * Highlights: This enhancement required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to the UI.

* **New Feature**: Added the ability to add a module by using the `add` command.
  * What it does: allows the user to add a module only after the user has started a semester by keying in a module code followed by a grade which is optional.
  * Justification: This feature improves the product significantly because a user can add modules he has taken or is taking in different semesters which allows him to keep track of the modules he has taken, and the modules
  he will be taking in the future. This feature provides a primary function and is one of the core features which build the foundation of our app.
  * Highlights: This enhancement affects existing commands and commands to be added in the future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
  
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=zhaolingshan&tabRepo=AY2021S1-CS2103T-T17-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

* **Enhancements to existing features**:
  * Updated and shortened the prefixes used to prioritise fast typists (Pull request [\#193](https://github.com/AY2021S1-CS2103T-T17-1/tp/pull/193))
  * Edited `done` command to omit user input of semester to prioritise fast typists (Pull request [\#96](https://github.com/AY2021S1-CS2103T-T17-1/tp/pull/96))
  * Sorted the main list of modules according to semester (Pull request [\#87](https://github.com/AY2021S1-CS2103T-T17-1/tp/pull/87))

* **Documentation**:
  * User Guide:
    * Added documentation for the features `delete`, `done` and `find` 
  * Developer Guide:
    * Added implementation details of the `start semester` feature
    
* **Community**:
  * Number of PRs reviewed: 28
  * Reported 9 bugs and suggestions with in-depth explanations and detailed annotated screenshots for other teams in PE-D