import constants from './constants';
import Generator from './models/generator';
import Story from './models/story.js';
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
		const generator = new Generator (state.generators[index]);
	if(state.counter >=generator.getCost())
	{  
		
	   	 state.counter -=generator.getCost().toFixed(2);
		 state.generators[index].quantity ++;
		 
	   
	   return state;

	}else {
	   alert("not enough to purchase")
	   return state;
   }


   case  'CHECK_STORY':

   	for (var i = 0; i < state.story.length; i++) {
				const story = new Story(state.story[i]);
			
				if (story.isUnlockYet(state.counter)) {
					
					story.unlock(); 
					
					state.story[i].state = story.state;
					
				}
			}
			return state;
			
   case 'INCREMENT':
   
		   state.counter += action.payload ;

		   return state;
	
	default:
		return state;
	}

}