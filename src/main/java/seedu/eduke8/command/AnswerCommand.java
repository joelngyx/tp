package seedu.eduke8.command;

import seedu.eduke8.common.Displayable;
import seedu.eduke8.common.DisplayableList;
import seedu.eduke8.option.Option;
import seedu.eduke8.option.OptionList;
import seedu.eduke8.question.Question;
import seedu.eduke8.ui.Ui;

public class AnswerCommand extends Command {
    private Option option;
    private Question question;

    public AnswerCommand(Option option, Question question) {
        assert option != null && question != null;

        this.option = option;
        this.question = question;
    }

    @Override
    public void execute(DisplayableList optionList, Ui ui) {
        if (option.isCorrectAnswer()) {
            ui.printAnswerIsCorrect();
            question.markAsAnsweredCorrectly();
            assert question.wasAnsweredCorrectly();
        } else {
            Displayable correctOption = ((OptionList) optionList).findCorrectOption();
            ui.printAnswerIsWrong();
            assert !question.wasAnsweredCorrectly();
        }
    }
}
