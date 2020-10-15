package seedu.eduke8.parser;

import seedu.eduke8.command.Command;
import seedu.eduke8.command.AboutCommand;
import seedu.eduke8.command.ExitCommand;
import seedu.eduke8.command.HelpCommand;
import seedu.eduke8.command.IncorrectCommand;
import seedu.eduke8.command.TextbookCommand;
import seedu.eduke8.command.TopicsCommand;
import seedu.eduke8.command.QuizCommand;
import seedu.eduke8.common.DisplayableList;
import seedu.eduke8.exception.Eduke8Exception;
import seedu.eduke8.topic.TopicList;
import seedu.eduke8.ui.Ui;

import static seedu.eduke8.exception.ExceptionMessages.ERROR_QUIZ_WRONG_FORMAT;
import static seedu.eduke8.exception.ExceptionMessages.ERROR_UNRECOGNIZED_COMMAND;

public class MenuParser implements Parser {

    public MenuParser() {
    }

    @Override
    public Command parseCommand(DisplayableList topicList, String userInput) throws Eduke8Exception {
        String[] commandArr = userInput.trim().split(" ", 0);

        Ui ui = new Ui();
        switch (commandArr[0]) {
        case "about":
            return new AboutCommand();
        case "help":
            return new HelpCommand();
        case "topics":
            return new TopicsCommand();
        case "textbook":
            return new TextbookCommand();
        case "quiz":
            int numOfQuestions = 0;
            String topicName = "";
            if (commandArr.length == 3) {
                try {
                    numOfQuestions = Integer.parseInt(commandArr[2].substring(2));
                    topicName = commandArr[1].substring(2);
                } catch (NumberFormatException nfe) {
                    return new IncorrectCommand("Please choose the answer by index");
                }
            } else if (commandArr.length < 3) {
                return new IncorrectCommand(ERROR_QUIZ_WRONG_FORMAT);
            }
            return new QuizCommand((TopicList) topicList, numOfQuestions, topicName, ui);
        case "exit":
            return new ExitCommand();
        default:
            break;
        }
        return new IncorrectCommand(ERROR_UNRECOGNIZED_COMMAND);
    }
}
