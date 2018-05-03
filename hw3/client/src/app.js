import '@webcomponents/webcomponentsjs';

import {loop} from './game';
import Store from './store';
import reducer from './reducer';

import ButtonComponent from './views/button';
import CounterComponent from './views/counter';
import ExampleComponent from './views/example';
import GeneratorComponent from './views/generator';
import StoryBookComponent from './views/story-book';

/**
 * Data flow diagram
 +----------------------------------------------------+
 | +------------------+          +------------------+ |
 | |                  |          |                  | |
++-|       Loop       |<---------|    Generator     | |
|| |                  |          |                  | |
|| +------------------+          +------------------+ |
||G          ^                                        |
||a          +-----------------------------+          |
||m                                        |          |
||e                                        |          |
||                               +------------------+ |
||                               |                  | |
||                               |     Stories      | |
||                               |                  | |
||                               +------------------+ |
|+----------------------------------------------------+
+------------------------------------------------------------+
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|       +----------------------------------------------------+----------+
|       | +------------------+                     +------------------+ |
|       | |                  |        Mutates      |                  | |
|       | |     Reducer      |-------------------->|      State       | |
|       | |                  |                     |                  | |
|       | +------------------+                     +------------------+ |
|       |S          ^                                        |          |
|       |t          |                                        |          |
|       |o          |                                        |          |
|       |r          | Triggers                     Notifies  |          |
|       |e          |                                        |          |
|       |           |                                        v          |
|       | +------------------+                     +------------------+ |
|       | |                  |                     |                  | |
+-------+>|      Action      |                     |    Listeners     | |
        | |                  |                     |                  | |
        | +------------------+                     +------------------+ |
        +-----------^----------------------------------------+----------+
                    |                                        |
                    |                                        |
                    |                                        |
                    |                                        |
                    | Dispatches                             |
                    |                                        |
                    |                                        |
          +------------------+                               |
          |                  |                               |
          |      Views       |              Notifies changes |
          |    Components    |<------------------------------+
          |                  |
          +------------------+
 */
main();

// main function wraps everything at top level
function main () {
	// TODO: fill the blank based on the theme you have choosen
	const initialState = {
		example: 'Hello custom element',
		counter: 0,
		generators: [
			{
				type: 'autonomous',
				name : 'Potion',
				description: "This Potion increases your attack",
				rate: 1,
				quantity : 0,
				baseCost: 10,
				ulockValue :10
			},




			{
				type: 'autonomous',
				name : 'Pet',
				description: " This pet helps you pick up rupee's",
				rate: 10,
				quantity : 0,
				baseCost: 15,
				ulockValue :10

			},
			{



				type: 'autonomous',
				name : 'Human',
				description: "This human companion helps you do leet dmg",
				rate: 20,
				quantity : 0,
				baseCost: 20,
				ulockValue :10
			}			


		],
		story: 
		
		[
		{   name: 'Waking up',
			description: 'Waking up in Dark Place',
			triggeredAt : 10,
			state:'hidden'
		}
		,
		{
			name: 'Exploring',
			description: 'You start to explore',
			triggeredAt : 50,
			state:'hidden'
		}
		,
		{
			name: 'Deep',
			description: 'Going deeeper and deeper',
			triggeredAt: 100,
			state:'hidden'

		}
		,
		{
			name: 'The way',
			description: 'Will you find your way',
			triggeredAt: 150,
			state: 'hidden'
		}
		,
		{	
			name: 'Perish',
			description: 'Or will you perish',
			triggeredAt : 200,
			state: 'hidden'
		}
		]
	};

	// initialize store
	const store = new Store(reducer, initialState);
	console.log(ExampleComponent(store));

	// define web components
	window.customElements.define('component-example', ExampleComponent(store));
	// no longer used
	window.customElements.define('game-button', ButtonComponent(store));
	window.customElements.define('game-counter', CounterComponent(store));
	// lab 3
	window.customElements.define('game-generator', GeneratorComponent(store));
	// homework 1
	window.customElements.define('game-story-book', StoryBookComponent(store));

	// For ease of debugging purpose, we will expose the critical store under window
	// ps: window is global
	window.store = store;

	// start game loop
	loop(store);
}
