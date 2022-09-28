package behavioral;



 interface State
 {
	void changeState(Counter counter);
 }


 class Busy implements State
 { 
	 @Override
	 public void changeState(Counter counter)
	 {
		 System.out.println("Counter is busy .Going to be available now");
		 counter.setState(new Available());
	 }
 }
 
 class Available implements State
 {
	  @Override
	  public void changeState(Counter counter)
	  {
		 System.out.println("Counter is available .Going to be busy now");
		 counter.setState(new Busy());
	  }
 }
 
 class Counter
 {
	  private State state;
	  private int count=0;
	  
	  public Counter(State state)
	  {
		  this.state=state;
	  }
	  
	  public State getState() {
		  return state;
	  }
	  
	  public void setState(State state) {
		  this.state = state;
	  }
	  
	  public void addNew()
	  {
	  	if(count==0){
	  		count++;
			state.changeState(this);
	  	}
	  	else
	  		System.out.println("Counter is busy now. Please try again later");
	  }

	  public void remove()
	  {
	  	if(count>0){
	  		count--;
			state.changeState(this);
	  	}
	  	else
	  		System.out.println("Counter is free now. No one to remove");
	  }
	  
 }
 
 class Client
 {
	  public static void main(String[] args)
	  {
		  System.out.println("***State Pattern Demo***\n");
		  //Initially Counter is free
		  Available initialState = new Available();
		  Counter counter = new Counter(initialState);
		  //First time addNew
		  counter.addNew();
		  //Second time addNew
		  counter.addnew();
		  //First time remove
		  counter.remove();

	  }
 }



