package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(HSP.geteHandStrength(),eHandStrength.FourOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TWO);
		assertEquals(HSP.getKickers().size(), 1);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.THREE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
	}
	@Test
	public void FourOfAKindTest2() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(HSP.geteHandStrength(),eHandStrength.FourOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.THREE);
		assertEquals(HSP.getKickers().size(), 1);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.TWO);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		
	}
	@Test
	public void ThreeOfAKindTest1() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(HSP.geteHandStrength(),eHandStrength.ThreeOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TWO);
		assertEquals(HSP.getKickers().size(), 2);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.ACE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		assertEquals(HSP.getKickers().get(1).geteRank(), eRank.THREE);
		assertEquals(HSP.getKickers().get(1).geteSuit(), eSuit.CLUBS);
		
	}
	
	@Test
	public void RoyalFlushTest1() {
		System.out.println("Royal Flush");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		
		
	}
	
	@Test
	public void ThreeOfAKindTest2() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(HSP.geteHandStrength(),eHandStrength.ThreeOfAKind);
		assertEquals(HSP.getHiCard().geteRank(), eRank.TWO);
		assertEquals(HSP.getKickers().size(), 2);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.FOUR);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.DIAMONDS);
		assertEquals(HSP.getKickers().get(1).geteRank(), eRank.THREE);
		assertEquals(HSP.getKickers().get(1).geteSuit(), eSuit.CLUBS);
		
	}
	
	@Test
	public void StraightTest1() {
		System.out.println("Straight A-5");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(HSP.geteHandStrength(),eHandStrength.Straight);
		assertEquals(HSP.getHiCard().geteRank(), eRank.FIVE);
		
		assertNull(HSP.getKickers());
	}
	
	@Test
	public void StraightTest2() {
		System.out.println("Straight 2-6");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		
		assertEquals(HSP.geteHandStrength(),eHandStrength.Straight);
		assertEquals(HSP.getHiCard().geteRank(), eRank.SIX);
		
		assertNull(HSP.getKickers());
	}
	
	@Test
	public void TwoPairTest1() {
		System.out.println("Two Pair");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HandScorePoker HSP = hp.getHSP();
		assertEquals(hp.isTwoPair(), true);
		assertEquals(HSP.geteHandStrength(),eHandStrength.TwoPair);
		assertEquals(HSP.getHiCard().geteRank(), eRank.FIVE);
		assertEquals(HSP.getKickers().get(0).geteSuit(), eSuit.CLUBS);
		assertEquals(HSP.getKickers().get(0).geteRank(), eRank.THREE);
	}
	
	@Test
	public void FullHouseTest1() {
		System.out.println("Full House");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(hp.isFullHouse(),true);
		
		HandScorePoker HSP = hp.getHSP();
		assertEquals(HSP.geteHandStrength(),eHandStrength.FullHouse);
		assertEquals(HSP.getHiCard().geteRank(), eRank.FIVE);
		assertNull(HSP.getKickers());
		
	}
	/*
	@Test
	public void ThreeOfAKindTest1() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	@Test
	public void TwoPairTest1() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest1() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		try {
			hp.ScoreHand();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(hp.isFullHouse(),true);
		
		System.out.println("");
	}
*/
}
