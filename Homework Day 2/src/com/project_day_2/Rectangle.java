package com.project_day_2;

public class Rectangle {
	
	  private int b;
	  private int h;

	  public Rectangle(int b, int h) {
	      this.b = b;
	      this.h = h;
	  }

	  public int getPerimeter() {
	      return (b + h)*2;
	  }

	  public int getArea() {
	      return b * h;
	  }
}
