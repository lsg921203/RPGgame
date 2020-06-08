package Shop;

import java.util.Scanner;

import User.UserMainLobby;

public class ShopMain {
	private static ShopMain shopmain = new ShopMain();
	private jdbc.IDTable.Character character;
	//private jdbc.IDTable.Inventory inventory;
	private jdbc.IDTable.DAOImpl dao = new jdbc.IDTable.DAOImpl();

	private ShopMain() {
	}

	public static ShopMain getInstance() {
		return shopmain;
	}

	public void run(Scanner sc, jdbc.IDTable.Character c) {
		/*
		 * 아직 데이터 베이스하고 연결하지 않음.
		 */
		// TODO Auto-generated method stub
		character = c;

		String productSome = "";
		boolean shopCheck = false;
		boolean shCheck = false;
		int a = 0, b, c1;
		int tmp = 0;

		while (shopCheck == false) {
			System.out.println("============================");
			System.out.println("============================");
			System.out.println("============================");
			System.out.println("- 상점에 들어온 것을 환영합니다.");
			System.out.println();
			System.out.println("Q.구매할 물품의 번호를 고르세요.");

			System.out.println("============================");
			System.out.println("==1.빨간물약 구매(개당 100원)   ==");
			System.out.println("==2.파란물약 구매(개당 100원)   ==");
			System.out.println("==3.폭탄 구매(개당 100원)      ==");
			System.out.println("==4.상점 나가기                             ==");
			System.out.println("============================");

			while (shCheck == false) {
				System.out.print("-선택 : ");
				a = sc.nextInt();

				switch (a) {
				case 1:
					productSome = "빨간물약";

					shopCheck = false;
					shCheck = true;
					break;
				case 2:
					productSome = "파란물약";
					shopCheck = false;
					shCheck = true;
					break;
				case 3:
					productSome = "폭탄";
					shopCheck = false;
					shCheck = true;
					break;
				case 4:
					shopCheck = true;
					shCheck = true;

					break;
				default:
					System.out.println("제대로 선택하세요.");
					shopCheck = false;
					shCheck = false;
				}

			}
			if(shopCheck){
				break;
			}

			System.out.println(productSome + "을 선택하셨습니다. 몇 개 구매하시겠습니까?");
			System.out.print("-개수 : ");
			b = sc.nextInt();
			
			if(c.getInven().getMoney() > b*100){
				System.out.println(productSome + "을  " + b + "개 구매했습니다.");
				System.out.println();
				ShopBuy sb1 = new ShopBuy();
				sb1.buySome(a, b, c);
				dao.update(c);
			}else{
				System.out.println("돈이 부족합니다.");
				System.out.println();
			}
			

			
			//System.out.println("End");
			System.out.println("더 구매하시겠습니까?");
			System.out.println("1.Yes      2.No");
			// 예스라고 하는 순간 a 값을 저장해야 한다.
			// 그리고 나서 a는 다시 default

			c1 = sc.nextInt();

			if (c1 == 1) {

				
				a = 0;
				shopCheck = false;
				shCheck = false;

			} else {
				// shopCheck = true;
				
				a = 0;
				shopCheck = true;
				shCheck = true;

			}

		}

	}

}
