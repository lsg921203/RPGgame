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
		 * ���� ������ ���̽��ϰ� �������� ����.
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
			System.out.println("- ������ ���� ���� ȯ���մϴ�.");
			System.out.println();
			System.out.println("Q.������ ��ǰ�� ��ȣ�� ������.");

			System.out.println("============================");
			System.out.println("==1.�������� ����(���� 100��)   ==");
			System.out.println("==2.�Ķ����� ����(���� 100��)   ==");
			System.out.println("==3.��ź ����(���� 100��)      ==");
			System.out.println("==4.���� ������                             ==");
			System.out.println("============================");

			while (shCheck == false) {
				System.out.print("-���� : ");
				a = sc.nextInt();

				switch (a) {
				case 1:
					productSome = "��������";

					shopCheck = false;
					shCheck = true;
					break;
				case 2:
					productSome = "�Ķ�����";
					shopCheck = false;
					shCheck = true;
					break;
				case 3:
					productSome = "��ź";
					shopCheck = false;
					shCheck = true;
					break;
				case 4:
					shopCheck = true;
					shCheck = true;

					break;
				default:
					System.out.println("����� �����ϼ���.");
					shopCheck = false;
					shCheck = false;
				}

			}
			if(shopCheck){
				break;
			}

			System.out.println(productSome + "�� �����ϼ̽��ϴ�. �� �� �����Ͻðڽ��ϱ�?");
			System.out.print("-���� : ");
			b = sc.nextInt();
			
			if(c.getInven().getMoney() > b*100){
				System.out.println(productSome + "��  " + b + "�� �����߽��ϴ�.");
				System.out.println();
				ShopBuy sb1 = new ShopBuy();
				sb1.buySome(a, b, c);
				dao.update(c);
			}else{
				System.out.println("���� �����մϴ�.");
				System.out.println();
			}
			

			
			//System.out.println("End");
			System.out.println("�� �����Ͻðڽ��ϱ�?");
			System.out.println("1.Yes      2.No");
			// ������� �ϴ� ���� a ���� �����ؾ� �Ѵ�.
			// �׸��� ���� a�� �ٽ� default

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
