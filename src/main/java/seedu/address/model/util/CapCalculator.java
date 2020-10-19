package seedu.address.model.util;

import java.util.List;

import seedu.address.model.module.Grade;
import seedu.address.model.module.Module;

/**
 * Supports the function to calculate CAP
 * given a list of modules.
 */
public class CapCalculator {

    /**
     * Calculates the CAP given a list of modules
     * by deriving the total sum of the grade points
     * of all the modules in the moduleList and
     * subsequently dividing the sum by the number
     * of modules in the moduleList.
     *
     * @param moduleList the list of modules to calculate CAP for.
     * @return the calculated CAP from the list of modules.
     */
    public static double calculateCap(List<Module> moduleList) {
        double totalPoints = 0.0;
        int numOfModsWithGrades = 0;
        for (Module m : moduleList) {
            if (m.hasGrade()) {
                Grade currentGrade = m.getGrade();
                double currentGradePoint = currentGrade.getGradePoint();
                totalPoints += currentGradePoint;
                numOfModsWithGrades++;
            }
        }
        double cap = totalPoints / numOfModsWithGrades;

        if (numOfModsWithGrades == 0) {
            return 0;
        }
        
        return cap;
    }
}
