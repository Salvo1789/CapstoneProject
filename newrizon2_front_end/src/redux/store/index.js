import { configureStore, combineReducers } from "@reduxjs/toolkit";
import productReducer from '../reducers/productReducer';
import productsReducer from '../reducers/productsReducer';

const bigReducer = combineReducers({
    product: productReducer,
    products: productsReducer
  });
  
  const store = configureStore({
    reducer: bigReducer,
  });
  
  export default store;