export default function (store) {
	return class StoryBookComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			// TODO: initial DOM rendering of story itself

			this.onStateChange = this.handleStateChange.bind(this);
		}

		handleStateChange (newState) {
	
			
			var keep_story =`<p>The story begins </p>`;
			this.store.state.stories.forEach(story => {
				if(story.state === 'visible'){
					console.log(story);

					keep_story = `<p>${story.description}</p>`;     //update storybox
				}
			});
					this.innerHTML = keep_story;
		
	
				// TODO: display story based on the state "resource" and "stories"
			}
	
			connectedCallback () {
				this.innerHTML = `<p>The story begins </p>`;
				this.store.subscribe(this.onStateChange);
			}
	
			disconnectedCallback () {
				this.store.unsubscribe(this.onStateChange);
			}
		};
}

