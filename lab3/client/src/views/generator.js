export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			
		
		}
	// TODO: subscribe to store on change event
 
	handleStateChange (newState) {
		this.innerHTML = this.init();
		console.log('GeneratorComponentt#stateChange', this, newState);
	}


connectedCallback(){	
	const id = this.dataset.id;
	this.innerHTML = this.init;
	console.log('GeneratorComponent#onConnectedCallBack');
	this.store.subscribe(this.onStageChange);	
 }
 disconnectedCallback(){
	 console.log('GeneratorComponent#onDisconnectedCallBack');
	 this.store.unsubscribe(this.onStageChange);
 }

 init()
 {
	switch(id){
	
		case '1':
		this.innerHTML = `
	
	<form class="card" action="">
		<div class ="form group">
				<div class = "rows">
			<label for="Potion">Potion</label>
			<p class = 'holding'> 0</p> 
			</div>
			<p>This potion increases yout attack and restores 
				.005 hp per second</p>
		</div>
		<br>
		<div class = "rows">
				<p id ="B_Potion">100/10000</p>
				<div class="actions">
					<button id =''>5 Rupees</button>
				</div>
		</div>
	</form>
	`;break;
	
	
	case '2':
	   this.innerHTML =`
	   <form class="card"action="">
	   <div class = "form group">
			   <div class = "rows">
			   <label for="Pet">Pet</label>
			   <p class = 'holding'> 0</p>  
			   </div>
			   <p>This pet companion picks up 10 Ruby's per second</p>
		   </div>
		   <br>
		   <div class = "rows">
				   <p id="B_Pet">500/10000</p>
				   <div class="actions">
					   <button id = 'change'> 10 Rupees</button>
				   </div>
		   </div>  
	</form>
	 `;break;
	
	
	 case '3':
	 this.innerHTML = `
	 <form class="card"action="">
	 <div class "form group">
		 <div class = "rows">
				 <label for="Adventurer">2nd Adventurer </label>
				 <p class = 'holding'> 0</p> 
		 </div>
			 <p>This second human companion deals 10 dmg per second </p>
		 </div>
		 <br>
		 <div class = "rows">
				 <p id="B_Adventurer">1200/10000</p>
				 <div class="actions">
					 <button id = 'change'> 15 Rupees</button>
				 </div>
		 </div>
	 </form>
	 `;break;
	}
 }
 }
};



