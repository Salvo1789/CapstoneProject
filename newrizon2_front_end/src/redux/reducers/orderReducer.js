import { CREATE_ORDER } from "../actions";

const initialState = {
    content: []
  };
  
  const orderReducer = (state = initialState, action) => {
    switch (action.type) {
      case CREATE_ORDER:
        return {
          ...state,
          content: [...state.content, action.payload]
        };
  
      default:
        return state;
    }
  };
  
  export default orderReducer;