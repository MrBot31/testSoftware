package creational.pattern;


interface Shape
{
	void draw();
}


class Circle implements Shape
{
	 @Override
	 public void draw()
	 {
		 System.out.println("a circle drawn");
	 }
}


class Square implements Shape
{
	 @Override
	 public void draw()
	 {
		 System.out.println("a square drawn");
	 }
}


interface Color
{
	void fill();
}


class Red implements Color
{
	 @Override
	 public void fill()
	 {
		 System.out.println("Red color filled");
	 }
}


class Green implements Color
{
	 @Override
	 public void fill()
	 {
		 System.out.println("Green color filled");
	 }
}


abstract class AbstractFactory
{
	abstract Shape getShape(String type);
	abstract Color getColor(String type);
	
}

class PaintFactory extends AbstractFactory
{
	@Override
	 public Shape getShape(String type)
	 {
		 switch (type)
		 {
			 case "Circle":
				 return new Circle();
			 case "Square":
				 return new Square();
			 default:
				 System.out.println( "Shape type : "+type+" cannot be instantiated");
				 return null;
		 }
	 }

	@Override
	public Color getColor(String type)
	 {
		 switch (type)
		 {
			 case "Red":
				 return new Red();
			 case "Green":
				 return new Green();
			 default:
				 System.out.println( "Color name : "+type+" cannot be instantiated");
				 return null;
		 }
	 }
}



class AnimationFactory extends AbstractFactory
{
	 @Override
	 public Color getColor(String type)
	 {
		 switch (type)
		 {
			 case "Red":
				 return new Red();
			 case "Green":
				 return new Green();
			 default:
				 System.out.println( "Color name : "+type+" cannot be instantiated");
				 return null;
		 }
	 }

	@Override
	 public Shape getShape(String type)
	 {
		 switch (type)
		 {
			 case "Circle":
				 return new Circle();
			 case "Square":
				 return new Square();
			 default:
				 System.out.println( "Shape type : "+type+" cannot be instantiated");
				 return null;
		 }
	 }
}

class FactoryProducer
{
	public static AbstractFactory getFactory(String name) {
		if(name.equalsIgnoreCase("paint"))
			return new PaintFactory();
		else if(name.equalsIgnoreCase("animation"))
			return new AnimationFactory();
		return null;
	}
}


class Arts
{
	 public static void main(String[] args) throws Exception
	 {
		 
		 AbstractFactory paintFactory = FactoryProducer.getFactory("Paint");
		 Shape circle=paintFactory.getShape("Circle");
		 circle.draw();
		 
		 AbstractFactory animationFactory = FactoryProducer.getFactory("Animation");
		 Color red=animationFactory.getColor("Red");
		 red.fill();
	 }
}