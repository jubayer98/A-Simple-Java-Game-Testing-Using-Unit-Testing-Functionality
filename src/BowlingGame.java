public class BowlingGame {
	public int score=0;
	private int[] rolls= new int [21];
	private int currentRoll=0;
	public void roll (int pins){   
		rolls [currentRoll++]=pins;
		}
	public int score(){
		int rollIndex = 0;
		for (int frame=0; frame<10; frame++, rollIndex+=2){
			if (isStrike(rollIndex)){
				score += 10+ strikeBonus(rollIndex);
				rollIndex--;
				}
			else if(isSpare(rollIndex))
				score += 10 + spareBonus(rollIndex);
			else
				score += sumOfRollsInFrame(rollIndex);
			}
		return score;
		}
	protected boolean isStrike(int rollIndex){
		return rolls[rollIndex]==10;
		}
	protected int strikeBonus(int rollIndex){
		return rolls[rollIndex+1] + rolls[rollIndex+2];
		}
	protected int sumOfRollsInFrame(int rollIndex){
		return rolls[rollIndex] + rolls[rollIndex+1];
		}
	protected int spareBonus(int rollIndex){
		return rolls[rollIndex +2];
		}
	protected boolean isSpare(int rollIndex) {
		return sumOfRollsInFrame(rollIndex)==10;
		}
	}