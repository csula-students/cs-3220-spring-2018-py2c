export default function (store) {
	return class CounterComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			this.innerHTML = `
			<p id = "counts"> Rupee's : 0</p>
			<div class="actions">
					<button id = "click-me">Click Me</button>
			</div>				`

			this.onStateChange = this.handleStateChange.bind(this);




		}

		handleStateChange (newState) {
			console.log('CounterComponent#stateChange', this, newState);
			// TODO: update inner HTML based on the new state
			document.getElementById("counts").innerHTML = 'Rupees :  ' + windonw.store._state.counter;
		}

		connectedCallback () {
			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}
	};
}

