package behavioral;



 interface Strategy
 {
	int doAction(int a , int b);
 }


 class StrategyAdd implements Strategy
 { 
	 @Override
	 public int doAction(int a , int b){
		 
		 return a+b;
		 
	 }
 }
 
 class StrategySub implements Strategy
 {
	  @Override
	  public int doAction(int a , int b)
	  {
		  return a-b;
	  }
 }

 class StrategyMul implements Strategy
 {
	  @Override
	  public int doAction(int a , int b)
	  {
		  return a*b;
	  }
 }
 
 class OpContext
 {
	  private Strategy strategy;
	  
	  public int applyStrategy(int a, int b)
	  {
		  if(a<10 && b<10)
			  this.strategy=new StrategyAdd();
		  else if(a>100 && b>100)
			  this.strategy=new StrategySub();
		  else
			  this.strategy=new StrategyMul();
		  
		  strategy.doAction(a, b);
	  }
	  
	  
 }
 
 class Client
 {
	  public static void main(String[] args)
	  {
		  System.out.println("***Strategy Pattern Demo***\n");
		  
		 //First time add
		  OpContext context = new OpContext();
		  int res= context.applyStrategy(6, 7);
		  
		//Second time sub
		  
		  res= context.applyStrategy(150, 170);
		  
		//Third time mul
		  
		  res= context.applyStrategy(60, 70);
	  }
 }



