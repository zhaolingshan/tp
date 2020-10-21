package seedu.address.model.util;

import java.util.Comparator;

import seedu.address.model.module.Module;

public class ModuleComparator implements Comparator<Module> {

    @Override
    public int compare(Module m1, Module m2) {
        return m1.getSemester().getSemStringToInt() - m2.getSemester().getSemStringToInt();
    }
}
