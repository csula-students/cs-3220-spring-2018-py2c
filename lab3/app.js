/*
class PubSub {
    constructor () {
        this.subscribers = [];
    }

    // subscribe allows a new subscriber to listen for changes by providing
    // callback function in the parameter
    subscribe (fn) {
        this.subscribers.push(fn);
    }

    // one can publish any data to subscribers
    publish (data) {
        this.subscribers.forEach(subscriber => {
            subscriber(data);
        });
    }
}


const pubSub = new PubSub();


const dom = document.querySelector('#click-me');
dom.addEventListener('click',()=> {

pubSub.publish(window.incrementalGame.state.counter);

});

pubSub.subscribe(counter => {
counter ++;
window.incrementalGame.state.counter = counter;
document.getElementById("counts").innerHTML = "Rupee's : " + counter ;
});
*/