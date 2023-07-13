import { configureStore, combineReducers } from "@reduxjs/toolkit";
import productReducer from '../reducers/productReducer';

const bigReducer = combineReducers({
    product: productReducer
  });
  
  const store = configureStore({
    reducer: bigReducer,
  });
  
  export default store;