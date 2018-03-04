export default function reducer (state, action) {
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;
	default:
		return state;

		case 'BUY_GENERATOR ':
		 if (action.payload === 'Potion')
		{
			state.counter = state.counter - 5;
			window.store.__state.counter= state.counter;
		}
		else if (action.payload === 'Pet')
		{	
			state.counter = state.counter - 10;
			window.store.__state.counter= state.counter;
		}
		else if (action.payload === 'Human')
	     {
			state.counter = state.counter - 15;
			window.store.__state.counter= state.counter;
		}
		 return window.store;
		 break;


		case 'Coins':
		window.store.__state.counter++;
		return window.store;
		break;


	}
}

