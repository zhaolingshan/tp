package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.CAP;
import seedu.address.model.module.Grade;
import seedu.address.model.module.Module;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class CalculateCAPCommand extends Command {

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Module> lastShownList = model.getFilteredModuleList();
        double capScore = calculateCAP(lastShownList);

        return null;
    }
    
    public double calculateCAP(List<Module> moduleList) {
        double totalPoints = 0.0;
        for (Module m : moduleList) {
            Grade currentGrade = m.getGrade();
            CAP currentCAP = currentGrade.getCap();
            double currentGradePoint = currentCAP.getGradePoint();
            totalPoints += currentGradePoint;
        }
        int totalNumberOfModules = moduleList.size();
        double cap = totalPoints / totalNumberOfModules;
        return cap;
    }
}
