import constants from './constants';
import Generator from '../src/models/generator';
export default function reducer (state, action) {
	
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;

	case constants.actions.BUTTON_CLICK:
		state.counter++;
		return state;
		
	case 'BUY_GENERATOR':
 
	for (var i = 0; i < state.generators.length; i++)

	 {
		 if (state.generators[i].name===action.payload.name)
		 {
			var index = i;
		 }
		}
		const generator = state.generators[index];
	if(state.counter >= generator.baseCost)
	{  
		 console.log(this,generator);// debugging
	   	 state.counter -= generator.baseCost;
	     generator.quantity ++;
	   
	   return state;

	}else {
	   alert("not enough to purchase")
	   return state;
   }

	
	default:
		return state;
	}

}

