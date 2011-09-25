package com.tinyrender.rollemup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

public abstract class PhysicsWorld implements ContactListener {	
	final static float UPDATE_INTERVAL = 1.0f / 60.0f;
	final static float MAX_CYCLES_PER_FRAME = 5.0f;
	static float timeAccumulator = 0.0f;
	
	public PhysicsWorld world;
	public World b2world;
	public Vector2 gravity;
	
	public PhysicsWorld() {
		gravity = new Vector2(0, -10.0f);
		world = this;
		b2world = new World(gravity, true);
		b2world.setContactListener(this);
	}

	public void physicsStep(float deltaTime) {
		b2world.step(Gdx.graphics.getDeltaTime(), 5, 2);
		
		timeAccumulator += deltaTime;
		if (timeAccumulator > (MAX_CYCLES_PER_FRAME * UPDATE_INTERVAL)) {
		    timeAccumulator = UPDATE_INTERVAL;
		}

		while (timeAccumulator >= UPDATE_INTERVAL) {
		    timeAccumulator -= UPDATE_INTERVAL;
		    b2world.step(UPDATE_INTERVAL, 3, 2);
		}
	}
	
	public void resumeWorld() {
		if(null == b2world)
			b2world = new World(gravity, true);
	}
	
	public void disposeWorld() {
		b2world.dispose();
		b2world = null;
	}
		
	@Override
	public void beginContact(Contact contact) {
		GameObject objectA = (GameObject) contact.getFixtureA().getBody().getUserData();
		GameObject objectB = (GameObject) contact.getFixtureB().getBody().getUserData();

		objectA.enterContact(objectB);
		objectB.enterContact(objectA);
	}

	@Override
	public void endContact(Contact contact) {
		GameObject objectA = (GameObject) contact.getFixtureA().getBody().getUserData();
		GameObject objectB = (GameObject) contact.getFixtureB().getBody().getUserData();

		objectA.leaveContact(objectB);
		objectB.leaveContact(objectA);
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {			
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {			
	}
}
