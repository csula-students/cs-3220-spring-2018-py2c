export default function (store) {
	return class ButtonComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			// TODO: add click event to increment counter
			// hint: use "store.dispatch" method (see example component)
		}


		connectedCallback(){
			console.log('ButtonComponentt#onConnectedCallback');
			this.innerHTML = '<button>Click me</button>';
			this.addEventListener('click', () => {
				this.store.dispatch({
					type: 'BUTTON_CLICK'
				});
	
			});
			}
		
	
		disconnectedCallback () {
			console.log('ButtonComponent#onDisconnectedCallback');
			this.store.unsubscribe(this.onStateChange);
	}
	
		};

}
