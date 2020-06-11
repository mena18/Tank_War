package GameLib;

import java.util.ArrayList;

public class SpriteGroup {
	private ArrayList<Sprite> sprites;
	
	public SpriteGroup() {
		sprites = new ArrayList<Sprite>();
	}
	
	public Sprite get(int index) {
		return sprites.get(index);
	}
	
	public void remove (Sprite sprite) {
		sprites.remove(sprite);
	}
	
	public void add(Sprite sprite) {
		sprites.add(sprite);
	}
	
	public void update() {
		for(int i=0;i<sprites.size();i++) {
			sprites.get(i).update();
		}
	}
	
	public void draw() {
		for(int i=0;i<sprites.size();i++) {
			sprites.get(i).draw();
		}
	}

	public int size() {
		return (int) this.sprites.size();
	}
	
	public void clear() {
		sprites.clear();
	}
	
	public void collisionGroup(SpriteGroup g,collisionAction act) {
		for(int i=0;i<this.size();i++) {
			for(int j=0;j<g.size();j++) {
				try {
					if(Collisions.rectangle(this.get(i),g.get(j)) ) {
						act.action(this.get(i),g.get(j));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
	}
}
