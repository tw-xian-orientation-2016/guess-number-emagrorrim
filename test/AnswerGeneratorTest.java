import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest {

    private Random random;

    @Before
    public void setUp() {
        random = mock(Random.class);
    }

    @Test
    public void generate_no_repeated_random_answer() {


        when(random.nextInt(10)).thenReturn(1,2,2,3,4);

        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        String answer = answerGenerator.generate();

        assertThat(answer, is("1234"));
    }

    @Test
    public void generate_random_four_digit_answer() {

        when(random.nextInt(10)).thenReturn(1,2,3,4);

        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        String answer = answerGenerator.generate();

        assertThat(answer, is("1234"));
    }
}
