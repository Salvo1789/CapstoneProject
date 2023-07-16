import { ADD_PRODUCTS } from "../actions";

const initialState = {
    avaiable: null
  };
  
  const productsReducer = (state = initialState, action) => {
    switch (action.type) {
      case ADD_PRODUCTS:
        return {
          ...state,
          avaiable: action.payload,
        };
      default:
        return state;
    }
  };
  
  export default productsReducer;