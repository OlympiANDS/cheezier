import view from '../views/request.js';
import map from '../controllers/map.js';


function start() {
    view.render(map.getPosition());
}

export default {
    async start() {
        start();
    },
    hash: 'request',
    unload() {
        $('#map').empty();
    }
};