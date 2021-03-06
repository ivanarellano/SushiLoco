package com.scrappile.sushiloco.object.decor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.utils.Array;
import com.scrappile.sushiloco.Assets;
import com.scrappile.sushiloco.GameObject;
import com.scrappile.sushiloco.Level;
import com.scrappile.sushiloco.box2d.BodyFactory;
import com.scrappile.sushiloco.box2d.JointFactory;
import com.scrappile.sushiloco.box2d.PhysicsObject;
import com.scrappile.sushiloco.box2d.PhysicsObject.Type;
import com.scrappile.sushiloco.object.ObjectFactory;

public class Boat implements ObjectFactory {
	Vector2 boatbodyVec1[] = {
		new Vector2(359.2f / Level.PTM_RATIO, 52.3f / Level.PTM_RATIO),		// 1
		new Vector2(192.3f / Level.PTM_RATIO, 55.2f / Level.PTM_RATIO),		// 2
		new Vector2(193.0f / Level.PTM_RATIO, 39.6f / Level.PTM_RATIO),		// 3
		new Vector2(336.6f / Level.PTM_RATIO, 17.0f / Level.PTM_RATIO),		// 12
		new Vector2(359.2f / Level.PTM_RATIO, 18.4f / Level.PTM_RATIO)		// 13
	};
	
	Vector2 boatbodyVec2[] = {
		new Vector2(336.6f / Level.PTM_RATIO, 17.0f / Level.PTM_RATIO),		// 12
		new Vector2(193.0f / Level.PTM_RATIO, 39.6f / Level.PTM_RATIO),		// 3
		new Vector2(-144.2f / Level.PTM_RATIO, 45.3f / Level.PTM_RATIO),	// 4
		new Vector2(-14.1f / Level.PTM_RATIO, -54.4f / Level.PTM_RATIO),	// 10
		new Vector2(314.0f / Level.PTM_RATIO, -53.0f / Level.PTM_RATIO)		// 11
	};
	
	Vector2 boatbodyVec3[] = {
		new Vector2(-144.2f / Level.PTM_RATIO, 45.3f / Level.PTM_RATIO),	// 4
		new Vector2(-145.0f / Level.PTM_RATIO, 55.9f / Level.PTM_RATIO),	// 5
		new Vector2(-163.3f / Level.PTM_RATIO, 55.9f / Level.PTM_RATIO),	// 6
		new Vector2(-162.6f / Level.PTM_RATIO, 46.0f / Level.PTM_RATIO)		// 7
	};
	
	Vector2 boatbodyVec4[] = {
		new Vector2(-162.6f / Level.PTM_RATIO, 46.0f / Level.PTM_RATIO),	// 7
		new Vector2(-359.9f / Level.PTM_RATIO, 54.4f / Level.PTM_RATIO),	// 8
		new Vector2(-304.1f / Level.PTM_RATIO, -43.1f / Level.PTM_RATIO),	// 9
		new Vector2(-14.1f / Level.PTM_RATIO, -54.4f / Level.PTM_RATIO)		// 10
	};
	
	Vector2 boatfrontVec[] = {
		new Vector2(74.5f / Level.PTM_RATIO, -92.5f / Level.PTM_RATIO),
		new Vector2(-32.0f / Level.PTM_RATIO, 93.5f / Level.PTM_RATIO),
		new Vector2(-74.5f / Level.PTM_RATIO, 94.5f / Level.PTM_RATIO),
		new Vector2(33.0f / Level.PTM_RATIO, -93.5f / Level.PTM_RATIO)
	};
	
	Vector2 boatflagVec1[] = {
		new Vector2(-21.0f / Level.PTM_RATIO, 144.0f / Level.PTM_RATIO),
		new Vector2(-31.5f / Level.PTM_RATIO, 144.5f / Level.PTM_RATIO),
		new Vector2(-31.5f / Level.PTM_RATIO, -144.0f / Level.PTM_RATIO),
		new Vector2(-21.0f / Level.PTM_RATIO, -143.5f / Level.PTM_RATIO)
	};
	
	Vector2 boatflagVec2[] = {
		new Vector2(30.5f / Level.PTM_RATIO, 121.0f / Level.PTM_RATIO),
		new Vector2(-19.5f / Level.PTM_RATIO, 121.5f / Level.PTM_RATIO),
		new Vector2(-19.5f / Level.PTM_RATIO, 20.0f / Level.PTM_RATIO),
		new Vector2(27.5f / Level.PTM_RATIO, 20.5f / Level.PTM_RATIO)
	};

	Vector2 boatnetVec1[] = {
		new Vector2(112.4f / Level.PTM_RATIO, 189.2f / Level.PTM_RATIO),
		new Vector2(105.4f / Level.PTM_RATIO, 188.4f / Level.PTM_RATIO),
		new Vector2(103.9f / Level.PTM_RATIO, -142.5f / Level.PTM_RATIO),
		new Vector2(114.6f / Level.PTM_RATIO, -141.1f / Level.PTM_RATIO)
	};
	
	Vector2 boatnetVec2[] = {
		new Vector2(11.3f / Level.PTM_RATIO, -30.8f / Level.PTM_RATIO),		// 1
		new Vector2(-33.9f / Level.PTM_RATIO, -83.8f / Level.PTM_RATIO),	// 2
		new Vector2(-75.7f / Level.PTM_RATIO, -95.1f / Level.PTM_RATIO),	// 3
		new Vector2(-6.4f / Level.PTM_RATIO, -124.8f / Level.PTM_RATIO)		// 11
	};
	
	Vector2 boatnetVec3[] = {
		new Vector2(-75.7f / Level.PTM_RATIO, -95.1f / Level.PTM_RATIO),	// 3
		new Vector2(-112.4f / Level.PTM_RATIO, -86.6f / Level.PTM_RATIO),	// 4
		new Vector2(-99.7f / Level.PTM_RATIO, -137.5f / Level.PTM_RATIO),	// 5
		new Vector2(-72.8f / Level.PTM_RATIO, -186.3f / Level.PTM_RATIO)	// 7
	};
	
	Vector2 boatnetVec4[] = {
		new Vector2(-6.4f / Level.PTM_RATIO, -124.8f / Level.PTM_RATIO),	// 11
		new Vector2(-72.8f / Level.PTM_RATIO, -186.3f / Level.PTM_RATIO),	// 7
		new Vector2(-41.7f / Level.PTM_RATIO, -183.5f / Level.PTM_RATIO),	// 8
		new Vector2(15.6f / Level.PTM_RATIO, -163.7f / Level.PTM_RATIO),	// 9
		new Vector2(21.2f / Level.PTM_RATIO, -153.8f / Level.PTM_RATIO)		// 10
	};
		
	Array<Vector2[]> verts = new Array<Vector2[]>();
	Filter filter = new Filter();
	
	TextureRegion boatTex = Assets.atlas.findRegion("boatbody");
	TextureRegion boatFrontTex = Assets.atlas.findRegion("boatfront");
	TextureRegion boatFlagTex = Assets.atlas.findRegion("boatflag");
	TextureRegion boatBackBarTex = Assets.atlas.findRegion("boatbackbar");
	
	@Override
	public GameObject build(float screenPosX, float screenPosY) {
		screenPosX /= Level.PTM_RATIO;
		screenPosY /= Level.PTM_RATIO;
		GameObject boatObj = new GameObject();
		
		boatObj.level = 4;
		boatObj.points = 10;
		
		filter.categoryBits = PhysicsObject.Category.OBJECT;
		filter.maskBits = PhysicsObject.Mask.OBJECT;
		
		boatObj.type = Type.ROLLABLE;
		boatObj.objRep.setTexture(boatTex);
		screenPosY += boatObj.objRep.texture.getRegionHeight() / 2.0f / Level.PTM_RATIO;
		
		// Boat body
		verts.clear();
		verts.add(boatbodyVec1); verts.add(boatbodyVec2);
		verts.add(boatbodyVec3); verts.add(boatbodyVec4);
		
		boatObj.body = BodyFactory.createPoly(verts, screenPosX, screenPosY, 4.5f, 1.0f, BodyType.DynamicBody, boatObj);
		boatObj.body.getFixtureList().get(0).setFilterData(filter);
				
		/*
		 *  Start creation of boat sub objects 
		 */
		GameObject boatFrontObj = new GameObject();
		GameObject boatFlagObj = new GameObject();
		GameObject boatBackBarObj = new GameObject();
		
		// Create box2d bodies
		verts.clear();
		verts.add(boatfrontVec);
		boatFrontObj.body = BodyFactory.createPoly(verts,
				screenPosX-(381.0f/Level.PTM_RATIO), screenPosY+(48.0f/Level.PTM_RATIO), 1.1f, 1.0f, BodyType.DynamicBody, boatFrontObj);
		
		verts.clear();
		verts.add(boatflagVec1);
		verts.add(boatflagVec2);
		boatFlagObj.body = BodyFactory.createPoly(verts,
				screenPosX+(237.0f/Level.PTM_RATIO), screenPosY+(185.0f/Level.PTM_RATIO), 1.1f, 1.0f, BodyType.DynamicBody, boatFlagObj);
		
		boatBackBarObj.body = BodyFactory.createBox(screenPosX+(304.0f/Level.PTM_RATIO), screenPosY+(86.0f/Level.PTM_RATIO),
				8.0f/Level.PTM_RATIO, 43.0f/Level.PTM_RATIO,
				1.1f, 1.0f, false, BodyType.DynamicBody, boatBackBarObj);
		
		/* 
		// Boat Net
		verts.add(boatnetVec1); verts.add(boatnetVec2);
		verts.add(boatnetVec3); verts.add(boatnetVec4);
		*/
		
		// Set textures
		boatFrontObj.objRep.setTexture(boatFrontTex);
		boatFlagObj.objRep.setTexture(boatFlagTex);
		boatBackBarObj.objRep.setTexture(boatBackBarTex);
		
		filter.categoryBits = PhysicsObject.Category.SUB_OBJECT;
		filter.maskBits = PhysicsObject.Mask.SUB_OBJECT;
		
		boatObj.children.add(boatFrontObj);
		boatObj.children.add(boatFlagObj);
		boatObj.children.add(boatBackBarObj);
		
		// Set joint, GameObjectType, collision data, user data
		for (int i = 0; i < boatObj.children.size; i++) {
			GameObject child = boatObj.children.get(i);
			
			child.level = 3;
			child.points = 4;
			child.type = Type.ROLLABLE;
			
			child.body.getFixtureList().get(0).setFilterData(filter);
			child.joint = JointFactory.weld(boatObj.body, child.body, boatObj.body.getWorldCenter());
			
			child.parent = boatObj;
		}
				
		return boatObj;
	}
}
