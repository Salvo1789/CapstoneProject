import { SELECT_PRODUCT } from "../actions";

const initialState = {
  content: null
};

const productSelectedReducer = (state = initialState, action) => {
  switch (action.type) {
    case SELECT_PRODUCT:
      return {
        ...state,
        content: action.payload
      };

    default:
      return state;
  }
};

export default productSelectedReducer;