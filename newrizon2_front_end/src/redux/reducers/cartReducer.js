import { ADD_TO_CART, REMOVE_FROM_CART, EMPTY_CART } from "../actions";

const initialState = {
  content: null
};

const cartReducer = (state = initialState, action) => {
  switch (action.type) {
    case ADD_TO_CART:
      return {
        ...state,
        content: [...state.content, action.payload]
      };
    case REMOVE_FROM_CART:
      return {
        ...state,
        content: state.content.filter((_, i) => i !== action.payload)
      };
    case EMPTY_CART:
      return {
        ...state,
        content: []
      };
    default:
      return state;
  }
};

export default cartReducer;