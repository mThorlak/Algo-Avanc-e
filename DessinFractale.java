class DessinFractale {
	private final Turtle bob;

	private final static int LARGEUR = 800;
	private final static int HAUTEUR = 600;
	// taille de la fenetre graphique

	public DessinFractale() {
		bob = new Turtle();
		Turtle.setCanvasSize(LARGEUR, HAUTEUR);// à appeler APRES création de la tortue
	}

	public DessinFractale(int v) {
		// attention, plus v est grand, plus bob va lentement !
		this();
		bob.speed(v);
	}

	public void reset() {
		bob.clear();
		bob.up();
		bob.setPosition(0, 0);
		bob.setDirection(0);
		bob.down();

	}

	public void close() {
		bob.exit();
	}

	public void grillage(double l, int n) {
		bob.speed(50);

		if (n == 0) {
		bob.forward(200);
		bob.left(90);
		bob.forward(200);
		bob.left(90);
		bob.forward(200);
		bob.left(90);
		bob.forward(200);
		bob.left(90);
		}
		
		else {
			grillage(l/2, n-1);
			bob.forward(l/2);
			grillage(l/2, n-1);
			bob.left(90);
			bob.forward(l/2);
			bob.left(90);
			bob.forward(l/2);
			bob.left(180);
			grillage(l/2, n-1);
			bob.forward(l/2);
			grillage(l/2, n-1);
			bob.left(180);
			bob.forward(l/2);
			bob.left(90);
			bob.forward(l/2);
			bob.left(90);
		}
	}
	
	public void flocon (double l, int n) {
		
		if (n == 0)
			bob.forward(l);
		else {
			flocon(l/3, n-1);
			bob.left(60);
			flocon(l/3, n-1);
			bob.right(120);
			flocon(l/3, n-1);
			bob.left(60);
			flocon(l/3, n-1);
		}
	}
	
	public void arbre (double l, int n) {
		
		if (n==0)
			bob.forward(l);
		else {
			arbre(l, n-1);
			bob.left(30);
			arbre(l/3, n-1);
			bob.backward(l/3);
			bob.right(30);
			arbre(l/3, n-1);
			bob.backward(l/3);
			bob.right(30);
			arbre(l/3, n-1);
			bob.backward(l/3);
			bob.left(30);		
		}
	}
	
	public void triforce (double l, int n) {
		
		if (n == 0) {
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.left(120);
		}
		
		else {
			triforce(l/2, n-1);
			bob.forward(l/2);
			triforce(l/2, n-1);
			bob.left(120);
			bob.forward(l/2);
			bob.right(120);
			triforce(l/2, n-1);
			bob.right(120);
			bob.forward(l/2);
			bob.left(120);
			
		}
	}
	
	public void losange (double l, int n) {
		
		if (n == 0) {
			bob.left(45);
			bob.forward(l);
			bob.left(90);
			bob.forward(l);
			bob.left(90);
			bob.forward(l);
			bob.left(90);
			bob.forward(l);
			bob.left(90);
			bob.forward(l);
		}
		
		else {
			losange(l, n-1);
			bob.right(90);
			bob.forward(l);
			bob.left(45);
			losange(l, n-1);
			bob.left(90);
			bob.forward(l);
				
		}
	}

	public static void main(String[] args) {
		DessinFractale d = new DessinFractale(500);
		d.reset();
		d.losange(200, 1);
	}

}