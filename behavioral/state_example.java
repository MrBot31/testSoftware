package behavioral;



 interface SwitchState
 {
	void pressSwitch(Remote remote);
 }


 class Off implements SwitchState
 { 
	 @Override
	 public void pressSwitch(Remote remote){
		 System.out.println("I am Off .Going to be On now");
		 remote.setState(new On());
	 }
 }
 
 class On implements SwitchState
 {
	  @Override
	  public void pressSwitch(Remote remote)
	  {
		  System.out.println("I am already On .Going to be Off now");
		  remote.setState(new Off());
	  }
 }
 
 class Remote
 {
	  private SwitchState state;
	  
	  public Remote(SwitchState state)
	  {
		  this.state=state;
	  }
	  
	  public SwitchState getState() {
		  return state;
	  }
	  
	  public void setState(SwitchState state) {
		  this.state = state;
	  }
	  
	  public void pressButton()
	  {
		  state.pressSwitch(this);
	  }
	  
 }
 
 class Client
 {
	  public static void main(String[] args)
	  {
		  System.out.println("***State Pattern Demo***\n");
		  //Initially TV is Off
		  Off initialState = new Off();
		  Remote remote = new Remote(initialState);
		  //First time press
		  remote.pressButton();
		  //Second time press
		  remote.pressButton();
	  }
 }



