import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.*;

public class GuessTest {

    @Test
    public void guess_return_right_string() {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
        CompareNumber compareNumber = mock(CompareNumber.class);
        when(compareNumber.compare("1234","1243")).thenReturn("2A2B");

        Guess guess = new Guess(answerGenerator, compareNumber);
        String result = guess.guess("1243");

        assertThat(result, is("2A2B"));
    }
}
