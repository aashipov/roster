import { applyMiddleware, combineReducers, createStore } from 'redux';
import thunk from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';
import reducers from "../reducers";

function configureStore(initialState) {
    return createStore(
        reducers,
        initialState,
        composeWithDevTools(applyMiddleware(thunk)),
    )
}

export default configureStore;
