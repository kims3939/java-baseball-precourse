package baseball.domain.answer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Answer {
    private final Map<Integer, Integer> numbers = new HashMap<>();
    private final Set<Integer> valueSet = new HashSet<>();

    public void add(Integer position, Integer number) {
        numbers.put(position, number);
        valueSet.add(number);
    }

    public int size() {
        return valueSet.size();
    }

    public boolean isNewNumber(int number) {
        return !valueSet.contains(number);
    }

    public boolean contains(int number) {
        return valueSet.contains(number);
    }

    public int numberAt(int position) {
        return numbers.get(position);
    }

    public Map<Integer, Integer> getNumbers() {
        return numbers;
    }
}
