import constants from './constants';
export default function reducer (state, action) {
	
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;

	case constants.actions.BUTTON_CLICK:
		state.counter++;
		return state;


	default:
		return state;
	}
}

