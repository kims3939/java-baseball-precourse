package baseball.controller;

public class InputValidator {

    public void validate(String input) {
        assertLength(input);
        assertNumeric(input);
    }

    private void assertLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자만 입력 가능합니다");
        }
    }

    private void assertNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
    }
}
