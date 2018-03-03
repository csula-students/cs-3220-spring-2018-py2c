export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			this.init();
			
			// TODO: render generator initial view
			// TODO: subscribe to store on change event
			// TODO: add click event
		}

connectedCallback(){
console.log('Element Conected');

this.querySelector().addlistener('click',()=>{
	console.log(this)

});

}

disconectedCallback(){
	console.log('Element Disconecteed');
}

init(){
const id = this.dataset.id;
switch(id){

	case '1':
	this.innerHTML = `

<form class="card" action="">
	<div class ="form group">
			<div class = "rows">
		<label for="Potion">Potion</label>
		<p for "holding"> 0</p> 
		</div>
		<p>This potion increases yout attack and restores 
			.005 hp per second</p>
	</div>
	<br>
	<div class = "rows">
			<p id ="B_Potion">100/10000</p>
			<div class="actions">
				<button id 'change'>100 Rupees</button>
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
		   <p for "holding"> 0</p> 
		   </div>
		   <p>This pet companion picks up 10 Ruby's per second</p>
	   </div>
	   <br>
	   <div class = "rows">
			   <p id="B_Pet">500/10000</p>
			   <div class="actions">
				   <button id = 'change'> 500 Rupees</button>
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
			 <p for "holding"> 0</p> 
	 </div>
		 <p>This second human companion deals 10 dmg per second </p>
	 </div>
	 <br>
	 <div class = "rows">
			 <p id="B_Adventurer">1200/10000</p>
			 <div class="actions">
				 <button id = 'change'> 10000 Rupees</button>
			 </div>
	 </div>
 </form>
 `;break;



}

}
	};
}
