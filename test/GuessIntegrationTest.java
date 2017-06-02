import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessIntegrationTest {
    private Guess guess;

    @Before
    public void setUp() {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1,2,3,4);

        guess = new Guess(new AnswerGenerator(random), new CompareNumber());
    }

    @Test
    public void guess_return_0A0B_when_neither_matched_nor_contained() {

        assertThat(guess.guess("5678"), is("0A0B"));
    }

    @Test
    public void guess_return_0A4B_when_no_matched_but_all_contained() {

        assertThat(guess.guess("4321"), is("0A4B"));
    }

    @Test
    public void guess__return_4A0B_when_all_matched() {

        assertThat(guess.guess("1234"), is("4A0B"));
    }
}
