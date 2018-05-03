export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			this.onStateChange = this.handleStateChange.bind(this);

			// TODO: render generator initial view

			// TODO: subscribe to store on change event

			// TODO: add click event

		}

		
	handleStateChange (newState) {
		const generator = new Generator(newState.generators[this.dataset.id]);
		this.innerHTML = `<form class="card" action="">
		<div class ="form group">
				<div class = "rows">
			<label for="Potion">${generator.name}</label>
			<p class = 'holding'> ${generator.quantity}</p> 
			</div>
			<h5> ${generator.description}</h5>
		</div>
		<br>
		<div class = "rows">
				<p id ="B_Potion">${generator.rate}/10000</p>
				<div class="actions">
					<button type ="button">${generator.getCost()} Rupees</button>
				</div>
		</div>
	</form>`
		
	}

	connectedCallback (){	
		const generator = new Generator(this.store.state.generators[this.dataset.id]);
		this.innerHTML = `<form class="card" action="">
			<div class ="form group">
					<div class = "rows">
				<label for="Potion">${generator.name}</label>
				<p class = 'holding'> ${generator.quantity}</p> 
				</div>
				<h5> ${generator.description}</h5>
			</div>
			<br>
			<div class = "rows">
					<p id ="B_Potion">${generator.rate}/10000</p>
					<div class="actions">
						<button class = "generator_button"> ${generator.getCost()} Rupees</button>
					</div>
			</div>
		</form>`;
		
		this.queryselector('.generator_button').addEventListener('click', () => {
			this.store.dispatch({
				type: 'BUY_GENERATOR',
				payload: {
					name: this.store.state.generators[this.dataset.id].name,
					quantity: this.store.state.generators[this.dataset.id].quantity 
				}
			});
		});
		console.log(this,this.dataset.id);
		this.store.subscribe(this.onStageChange);	
	 }
		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
