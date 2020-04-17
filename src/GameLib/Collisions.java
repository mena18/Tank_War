package GameLib;

public class Collisions {
	public static boolean rectangle(Sprite a,Sprite b) {
		if(b.bottom()>a.top() && b.top()<a.bottom() && b.left()<a.right()  &&  b.right() > a.left()) {
			return true;
		}
		return false;
	}
}
