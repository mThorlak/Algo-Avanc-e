public class Liste {

	private int val;
	private Liste suiv;

	public Liste() {
		suiv = null;
	}

	public boolean estVide() {
		return suiv == null;
	}

	public void ajoutTete(int x){
		Liste aux = new Liste();
		aux.val = val;
		aux.suiv = suiv;
		this.val = x;
		this.suiv = aux;
		}

	public void supprimeTete(){
		//sur liste non vide
		this. val = suiv. val;
		this.suiv = this.suiv.suiv;
		}

	public String toString() {
		return this.val + "," + this.suiv;
	}

	public int longueur() {
		if (this.estVide())
			return 1;
		else {
			return 1 + this.suiv.longueur();
		}
	}

	public boolean recherche(int x) {

		if (this.val == x)
			return true;

		if (this.estVide())
			return false;

		else {
			return this.suiv.recherche(x);
		}
	}

	public boolean croissant() {

		if (this.estVide())
			return true;

		if (this.val > this.suiv.val)
			return false;

		else
			return this.suiv.croissant();
	}
	
	public void ajoutFin (int x) {
		
		if(this.estVide()) {
			Liste l = new Liste();
			l.val = x;
			this.suiv = l;
		}
		
		else 
			this.suiv.ajoutFin(x);
	}
	
	public void concat (Liste l) {
		
		if (this.estVide())
			this.suiv = l;
		else 
			this.suiv.concat(l);
	}
	
	public int get (int i) {
		
		if (i == 0)
			return this.val;
		
		if(this.estVide()) 
			return 0;
		
		else 
			return this.suiv.get(i-1);
	}

	public static void main(String[] args) {
		Liste l1 = new Liste();
		Liste l2 = new Liste();
		Liste l3 = new Liste();
		Liste l4 = new Liste();
		Liste l5 = new Liste();
		l1.val = 2;
		l2.val = 2;
		l3.val = 3;
		l1.suiv = l2;
		l2.suiv = l3;
		l4.val = 20;
		l5.val = 30;
		l4.suiv = l5;

		System.out.println(l1.toString());
		System.out.println(l1.croissant());
		l1.concat(l4);
		System.out.println(l1.toString());
		System.out.println(l1.get(5));
	}

}
