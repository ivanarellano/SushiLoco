package com.scrappile.sushiloco.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Shape;
import com.scrappile.sushiloco.Controller;
import com.scrappile.sushiloco.GameObject;
import com.scrappile.sushiloco.Level;
import com.scrappile.sushiloco.box2d.PhysicsObject;
import com.scrappile.sushiloco.object.Player;

public class PlayerController implements Controller {
	Player player;
	Fixture fixture;
	
	Shape.Type shapeType;
	Vector2 vecPosOffset = new Vector2();
	
	public PlayerController(Player player) {
		this.player = player;
	}
	
	public void rollObject(GameObject other) {
		other.body.setActive(false);
		other.isDead = true;
		
		// Remove object from any existing parent
		if (null != other.parent)
			other.parent.children.removeValue(other, true);
				
		// Add object to player rendering list
		player.children.add(other);
			
		// Store object pos relative to player's pos
		Vector2 otherWorldCenter = other.body.getWorldCenter().sub(player.pos);
		
		// Offset object position based off the rolling direction
		Vector2 newOffset = player.body.getLocalVector(otherWorldCenter);
		
		// Re-adjust position to half graphic's rep
		newOffset.sub(other.objRep.halfWidth/Level.PTM_RATIO, other.objRep.halfHeight/Level.PTM_RATIO);
		
		other.rolledPos.set(newOffset);
				
		// Convert object position from box2d space to screen space
		other.pos.mul(Level.PTM_RATIO);
		other.rolledPos.mul(Level.PTM_RATIO);
	}
	
	@Override
	public void jump(GameObject object, float velocity) {
		object.body.applyLinearImpulse(0, velocity, object.pos.x, object.pos.y);
	}
	
	public void grow() {
		player.forceYOffset = -(player.shape.getRadius() / 4.5f) * player.growthScale;
		scaleCircle(player, player.growthScale, 0.0f, 0.0f);
	}
	
	void scaleCircle(PhysicsObject object, float scale, float offsetX, float offsetY) {
		fixture = object.body.getFixtureList().get(0);
		shapeType = fixture.getType();
		
		if (shapeType == Shape.Type.Circle) {
			CircleShape shape = (CircleShape) fixture.getShape();
			float radius = shape.getRadius();
			
			vecPosOffset.set(offsetX, offsetY);
			radius *= scale;
			shape.setPosition(vecPosOffset);
			shape.setRadius(radius);
		}
	}
	
	public void keyDown(int keyCode) {
		if (keyCode == Keys.SPACE) {
			if (player.state != Player.STATE_JUMPING && player.state != Player.STATE_FALLING)
				jump(player, Player.MAX_JUMP);
		}
	}
	
	public void keyUp(int keyCode) {
	}
	
	public void touchDown() {
		if (player.state != Player.STATE_JUMPING && player.state != Player.STATE_FALLING)
			jump(player, Player.MAX_JUMP);
	}
	
	public void touchUp() {
	}
}
