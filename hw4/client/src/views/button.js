import constants from '../constants';
export default function (store) {
	return class ButtonComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			
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