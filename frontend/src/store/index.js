import {applyMiddleware, createStore} from 'redux';
import thunk from 'redux-thunk';
import {composeWithDevTools} from 'redux-devtools-extension';
import reducers from "../reducers";

const configureStore = (initialState) =>
    createStore(
        reducers,
        initialState,
        composeWithDevTools(applyMiddleware(thunk)),
    );

export default configureStore;
