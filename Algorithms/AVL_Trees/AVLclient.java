package AVL_Trees;

public class AVLclient {

	public static void main(String[] args) {

		AVLTree at = new AVLTree();

		at.insert(34);
		at.insert(21);
		at.insert(10);
		at.insert(27);
		at.insert(24);
		at.insert(43);
		at.insert(15);
		at.insert(6);
		
		at.display();

	}

}
