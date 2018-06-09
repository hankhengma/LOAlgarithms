// User abstract class or interface to store the public used methods
public abstract class Shape {
	public void draw() {
		System.out.println();
	}
}

// each class is like a implement factories to do what is is supposed to do.
class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Draw a circle.");
	}
}

class Rectangle extends Shape {
	@Override
	public void draw() {
		System.out.println("Draw a rectangle");
	}
}

class Triagnle extends Shape {
	@Override
	public void draw() {
		System.out.println("Draw a triangle");
	}
}

// Shape factory -- like a management company to distribute the obj creation.
class ShapeFactory {
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}

		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("TRIANGLE")){
			return new Triagnle();
		}
		return null;
	}
}
