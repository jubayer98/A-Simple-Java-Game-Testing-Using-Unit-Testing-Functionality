import static org.junit.Assert.*;
import org.junit.Test;
public class BowlingGameTest {
	public BowlingGame game = new BowlingGame();
	@Test
	public void rollingOneScoresOne() throws Exception {
		game.roll(1); //rolling our ball
		assertEquals(1,game.score());
		}
	@Test
	public void rollingOneScoresTwo() throws Exception {
		game.roll(2); //rolling our ball
		assertEquals(2,game.score());
		}
	@Test
	public void rollingOneThenOneScoresTwo() throws Exception{
		rollMany(2,1);
		assertEquals(2,game.score());
		}
	protected void rollMany (int n, int pins ){
		for (int i=0; i<n; i++)
			game.roll(pins);
		}
	@Test
	public void rollingASpareThenAOneScoresTwelve() throws Exception{
		game.roll(5);
		game.roll(5);
		game.roll(1);
		assertEquals(12,game.score());
		}
	@Test
	public void rollingOneThenOneThenSpareThenOneScoresFourteen() throws Exception{
		rollMany(2,1);
		rollASpare();
		game.roll(1);
		assertEquals(14,game.score());
		}
	protected void rollASpare (){
		rollMany(2,5);
		}
	@Test
	public void rollingStrikeThenOneThenOneScoresFourteen() throws Exception{
		game.roll(10);
		rollMany(2,1);
		assertEquals(14,game.score());
		}
	@Test
	public void rollingOneThenOneThenStrikeThenOneScoresSixteen() throws Exception{
		rollMany(2,1);
		game.roll(10);
		rollMany(2,1);
		assertEquals(16,game.score());
		}
	}