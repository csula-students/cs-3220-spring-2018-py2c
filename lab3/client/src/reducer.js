import constants from './constants';
export default function reducer (state, action) {
	
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;

	case constants.actions.BUTTON_CLICK:
		state.counter++;
		return state;
		
	case 'BUY_GENERATOR':


		if (action.payload.name === state.generators[0].name && state.counter >= state.generators[0].baseCost)
		 {
			state.counter -= state.generators[0].baseCost;
			state.generators[0].quantity ++;
			
			return state;
		}else if ( (action.payload.name === state.generators[1].name && state.counter >= state.generators[1].baseCost)) {
			
			state.counter -= state.generators[1].baseCost;
			state.generators[1].quantity ++;
			return state;
		}else if ( (action.payload.name === state.generators[2].name && state.counter >= state.generators[2].baseCost)) {
			
			state.counter -= state.generators[2].baseCost;
			state.generators[2].quantity ++;
			return state;
	
		}else {
			alert("not enough to purchase")
			return state;
		}
	
	default:
		return state;
	}

}

