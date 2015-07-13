package com.grasp.customview.model;



public class Pointer {

	private float x ;
	
	private float y;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public static float getPointerDistance(Pointer pointer1, Pointer pointer2){
		return (float)Math.sqrt(Math.pow((pointer1.x - pointer2.x), 2)+Math.pow((pointer1.y - pointer2.y), 2)) ;
	}
	
	public static float getXDistance(Pointer pointer1, Pointer pointer2){
		return pointer1.x - pointer2.x;
	}
	
	public static float getYDistance(Pointer pointer1, Pointer pointer2){
		return pointer1.y - pointer2.y;
	}
}
