package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedModule.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalModules.EFF_COM;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.module.Grade;
import seedu.address.model.module.ModuleName;

public class JsonAdaptedModuleTest {
    private static final String INVALID_MODULE_NAME = "S@ftware";
    private static final String INVALID_GRADE = " ";
    private static final String INVALID_TAG = "#friend";

    private static final int VALID_MODULAR_CREDIT = 4;
    private static final String VALID_MODULE_NAME = EFF_COM.getModuleName().toString();
    private static final String VALID_GRADE = EFF_COM.getGrade().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = EFF_COM.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validModuleDetails_returnsModule() throws Exception {
        JsonAdaptedModule module = new JsonAdaptedModule(EFF_COM);
        assertEquals(EFF_COM, module.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedModule module =
                new JsonAdaptedModule(INVALID_MODULE_NAME, VALID_GRADE, VALID_TAGS, VALID_MODULAR_CREDIT);
        String expectedMessage = ModuleName.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, module::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedModule module = new JsonAdaptedModule(null, VALID_GRADE, VALID_TAGS, VALID_MODULAR_CREDIT);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, ModuleName.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, module::toModelType);
    }

    @Test
    public void toModelType_invalidGrade_throwsIllegalValueException() {
        JsonAdaptedModule module =
                new JsonAdaptedModule(VALID_MODULE_NAME, INVALID_GRADE, VALID_TAGS, VALID_MODULAR_CREDIT);
        String expectedMessage = Grade.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, module::toModelType);
    }

    @Test
    public void toModelType_nullGrade_throwsIllegalValueException() {
        JsonAdaptedModule module = new JsonAdaptedModule(VALID_MODULE_NAME, null,
                VALID_TAGS, VALID_MODULAR_CREDIT);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Grade.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, module::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedModule module =
                new JsonAdaptedModule(VALID_MODULE_NAME, VALID_GRADE, invalidTags, VALID_MODULAR_CREDIT);
        assertThrows(IllegalValueException.class, module::toModelType);
    }

}
