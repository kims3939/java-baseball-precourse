package baseball.controller;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator 클래스")
class InputValidatorTest {

    InputValidator validator = new InputValidator();

    @ParameterizedTest
    @DisplayName("validate 메소드는 3자리 보다 짧은 문자열을 전달받으면 예외를 발생시킨다")
    @ValueSource(strings = {"", "1", "12"})
    void validate_throw_exception_with_short_string(String shortInput) {
        //when
        Throwable throwable = catchThrowable(() -> validator.validate(shortInput));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("validate 메소드는 3자리 보다 긴 문자열을 전달받으면 예외를 발생시킨다")
    @ValueSource(strings = {"1234", "12345", "123456", "12345678"})
    void validate_throw_exception_with_long_string(String longInput) {
        //when
        Throwable throwable = catchThrowable(() -> validator.validate(longInput));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("validate 메소드는 숫자가 아닌 문자를 전달받으면 예외를 발생시킨다")
    @ValueSource(strings = {"abc", "12a", "1a3", "12a", "!@#"})
    void validate_throw_exception_with_non_numeric_string(String nonNumericInput) {
        //when
        Throwable throwable = catchThrowable(() -> validator.validate(nonNumericInput));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}
