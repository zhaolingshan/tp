package seedu.address.model.util;

import java.util.List;

import seedu.address.model.module.Module;

/**
 * Supports the function to calculate the total number of MCs taken currently.
 */
public class McCalculator {

    /**
     * Calculates the total number of MCs from all modules in a module list.
     *
     * @param moduleList list of modules
     * @return sum of MCs of all modules in the list.
     */
    public static int calculateMc(List<Module> moduleList) {
        int totalMc = 0;
        for (Module m : moduleList) {
            totalMc += m.getModularCredit().modularCredit;
        }
        return totalMc;
    }
}
