package AVL_Tress;

public class AVLclient {

	public static void main(String[] args) {

		AVLTree at = new AVLTree();

		at.insert(20);
		at.insert(25);
		at.insert(30);
		at.insert(10);
		at.insert(5);
		at.insert(15);
		at.insert(27);
		at.insert(19);
		at.insert(16);
		
		at.display();

	}

}
