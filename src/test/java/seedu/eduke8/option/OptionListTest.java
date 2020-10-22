package seedu.eduke8.option;

import org.junit.jupiter.api.Test;
import seedu.eduke8.common.Displayable;
import seedu.eduke8.exception.Eduke8Exception;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionListTest {
    private static final String PLACEHOLDER_OPTION_ONE_DESCRIPTION = "Option one";
    private static final String PLACEHOLDER_OPTION_TWO_DESCRIPTION = "Option two";
    private static final int DEFAULT_OPTION_COUNT = 1;

    @Test
    void getCount_oneOption_returnsCountOfOne() {
        OptionList optionList = createOptionList();

        assertEquals(DEFAULT_OPTION_COUNT, optionList.getCount());
    }

    @Test
    void getInnerList_oneOption_expectsTrue() {
        OptionList optionList = createOptionList();
        ArrayList<Displayable> options = new ArrayList<>();

        Option optionOne = new Option(PLACEHOLDER_OPTION_ONE_DESCRIPTION);
        options.add(optionOne);
        OptionList optionListTest = new OptionList(options);

        String optionListDescription = optionList.getInnerList().get(0).getDescription();
        String optionListTestDescription = optionListTest.getInnerList().get(0).getDescription();

        assertEquals(optionListDescription, optionListTestDescription);
    }

    @Test
    void find_twoOptions_returnOptionOne() throws Eduke8Exception {
        OptionList optionList = createOptionList();
        Displayable optionOne = optionList.find(PLACEHOLDER_OPTION_ONE_DESCRIPTION);

        assertEquals(PLACEHOLDER_OPTION_ONE_DESCRIPTION, optionOne.getDescription());
    }

    private OptionList createOptionList() {
        ArrayList<Displayable> options = new ArrayList<>();
        Option optionOne = new Option(PLACEHOLDER_OPTION_ONE_DESCRIPTION);

        options.add(optionOne);
        OptionList optionList = new OptionList(options);

        return optionList;
    }
}
