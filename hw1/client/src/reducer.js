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
		const generator = state.generators[index];
		
	if(state.counter >=generator.baseCost)
	{  
		 console.log(this,generator);// debugging
	   	 state.counter -=generator.baseCost;
		 generator.quantity ++;
		 
	   
	   return state;

	}else {
	   alert("not enough to purchase")
	   return state;
   }


   case  'CHECK_STORY':

   	for (var i = 0;i<state.story.length;i++)
   		{
	   	 var index = i;
   		}
   const story = new Story(state.story[index]);
   		if (story.isUnlockYet(state.counter))
  		 {
	  			 story.unlock();
	   
		   }
		   return state;
   case 'INCREMENT':

		   state.counter +=action.payload ;

		   return state;
	
	default:
		return state;
	}

}

