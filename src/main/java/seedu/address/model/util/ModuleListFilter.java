package seedu.address.model.util;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.model.module.Module;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Supports the function to filter the modules by semester.
 * Displays the respective modules in a specific semester.
 */
public class ModuleListFilter {

    /**
     * Filters the module list according to semester.
     * @param moduleList the list of modules to be filtered.
     * @return the filtered list of modules by semester.
     */
    public static FilteredList<Module> filterModulesBySemester(FilteredList<Module> moduleList) {
        SemesterManager semesterManager = SemesterManager.getInstance();
        Semester currentSemester = semesterManager.getCurrentSemester();
        Predicate<Module> predicate = module -> module.getSemester().equals(currentSemester);
//        List<Module> filteredModuleList = new ObservableList<Module>();
//        for (Module m : moduleList) {
//            if (m.getSemester().equals(currentSemester)) {
//                filteredModuleList.add(m);
//            }
//        }
        return new FilteredList<Module>(moduleList, predicate);
    }
}
