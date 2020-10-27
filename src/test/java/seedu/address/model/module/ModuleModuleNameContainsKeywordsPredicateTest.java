package seedu.address.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ModuleBuilder;

public class ModuleModuleNameContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        ModuleNameContainsKeywordsPredicate firstPredicate =
                new ModuleNameContainsKeywordsPredicate(firstPredicateKeywordList);
        ModuleNameContainsKeywordsPredicate secondPredicate =
                new ModuleNameContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        ModuleNameContainsKeywordsPredicate firstPredicateCopy =
                new ModuleNameContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different module -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        ModuleNameContainsKeywordsPredicate predicate =
                new ModuleNameContainsKeywordsPredicate(Collections.singletonList("CS2100"));
        assertTrue(predicate.test(new ModuleBuilder().withName("CS2100 Computer Organisation").build()));

        // Multiple keywords
        predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("CS2100", "Computer"));
        assertTrue(predicate.test(new ModuleBuilder().withName("CS2100 Computer Organisation").build()));

        // Only one matching keyword
        predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("CS2100", "Computing"));
        assertTrue(predicate.test(new ModuleBuilder().withName("CS2100 Computer Organisation").build()));

        // Mixed-case keywords
        predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("cS2100", "cOmPutEr"));
        assertTrue(predicate.test(new ModuleBuilder().withName("CS2100 Computer Organisation").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        ModuleNameContainsKeywordsPredicate predicate =
                new ModuleNameContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new ModuleBuilder().withName("CS2100 Computer Organisation").build()));

        // Non-matching keyword
        predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("Computing"));
        assertFalse(predicate.test(new ModuleBuilder().withName("CS2100 Computer Organisation").build()));

        // Keywords match grade, but does not match module name
         predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("CS2103", "A+"));
         assertFalse(predicate.test(new ModuleBuilder().withName("CS2100")
                 .withGrade("A+").build()));
    }
}
