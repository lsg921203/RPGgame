package Shop;

public class ShopBuy {

	public void buySome(int a, int b, jdbc.IDTable.Character c){
		int n= a;
		int m= b;
		
		switch(a){
		case 1:
			//System.out.println("»¡°­¹°¾àÀ» »ò´Ù.");
			c.updateRP(b);
			c.updateMoney(-100*b);
			break;
		case 2:
			//System.out.println("ÆÄ¶õ¹°¾àÀ» »ò´Ù.");
			c.updateBP(b);
			c.updateMoney(-100*b);
			break;
		case 3:
			//System.out.println("ÆøÅºÀ» »ò´Ù.");
			c.updateBoom(b);
			c.updateMoney(-100*b);
			break;
		case 4:
			return;
		}
	}
}
