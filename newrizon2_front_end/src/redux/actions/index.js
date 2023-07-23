export const ADD_PRODUCT = "ADD_PRODUCT";
export const ADD_PRODUCTS = "ADD_PRODUCTS";
export const SELECT_PRODUCT = "SELECT_PRODUCT";
export const SET_ADMIN_NAME = "SET_ADMIN_NAME";
export const SET_USER_NAME = "SET_USER_NAME";
export const USER_LOGIN = "USER_LOGIN";
export const USER_LOGOUT = "USER_LOGOUT";
export const USER_REGISTER = "USER_REGISTER";
export const GET_USER_DATA = "GET_USER_DATA";
export const ADD_TO_CART = "ADD_TO_CART";
export const REMOVE_FROM_CART = "REMOVE_FROM_CART";
export const EMPTY_CART = "EMPTY_CART";
export const CREATE_ORDER = "CREATE_ORDER";

//PRODUCTS ACTIONS

export const getProductAction = (productId) => {
  return async (dispatch) => {
    

    const endpoint = "http://localhost:3000/products/" + productId;
    
    console.log(endpoint);
    try {
      const resp = await fetch(endpoint);
      if (resp.ok) {
        const dataProduct = await resp.json();
        dispatch({ type: ADD_PRODUCT, payload: dataProduct });
      } else {
        alert("Errore qualcosa è andato storto");
      }
    } catch (error) {
      console.log(error);
    }
  };
};

export const getAllProductsAction = (type) => {
  return async (dispatch) => {
    
    
    const endpoint = "http://localhost:3000/products?type=" + type;
   
    console.log(endpoint);
    try {
      const resp = await fetch(endpoint);
      if (resp.ok) {
        const dataProducts = await resp.json();
        dispatch({ type: ADD_PRODUCTS, payload: dataProducts });
      } else {
        alert("Errore qualcosa è andato storto");
      }
    } catch (error) {
      console.log(error);
    }
  };
};

export const selectProductAction = product => ({ type: SELECT_PRODUCT, payload: product });

//AUTH ACTIONS 

export const loginAction = (body) => {
  return async (dispatch) => {
    try {
      let resp = await fetch("http://localhost:3000/auth/login", {
        method: "POST",
        headers: {
          //Authorization: AUTHORIZATION,
          "Content-Type": "application/json",
        },
        body,
      });
      if (resp.ok) {
        let data = await resp.json();
        dispatch({ type: USER_LOGIN, payload: data.accessToken });
      } else {
        console.log("error");
      }
    } catch (error) {
      console.log(error);
    } finally {
      console.log("fetch loading finish");
    }
  };
};

export const registerAction = (body) => {
  return async (dispatch) => {
    try {
      let resp = await fetch("http://localhost:3000/auth/register", {
        method: "POST",
        headers: {
          //Authorization: AUTHORIZATION,
          "Content-Type": "application/json",
        },
        body,
      });
      if (resp.ok) {
        let data = await resp.json();
        dispatch({ type: USER_REGISTER, payload: data });
      } else {
        console.log("error");
      }
    } catch (error) {
      console.log(error);
    } finally {
      console.log("fetch loading finish");
    }
  };
};

export const getUserDataAction = () => {
  return async (dispatch, getState) => {
    const token = getState().auth.token;
    try {
      let resp = await fetch("http://localhost:3000/users/me", {
        //   method: "POST",
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
        //   body,
      });
      if (resp.ok) {
        let data = await resp.json();
        dispatch({ type: GET_USER_DATA, payload: data });
      } else {
        console.log("error");
      }
    } catch (error) {
      console.log(error);
    } finally {
      console.log("fetch loading finish");
    }
  };
};

export const logoutAction = () => ({ type: USER_LOGOUT });

//CART ACTIONS

export const addToCartAction = product => {
  return (dispatch, getState) => {
    const currentState = getState();

    console.log(
      "CHECK",
      currentState.cart.content.findIndex(order => order.product.id === product.id)
    );
    const checkProductInCart = currentState.cart.content.findIndex(order => order.product.id === product.id);
    let quantity = 1;
    if (checkProductInCart === -1) {
      const order = { quantity, product };
      dispatch({ type: ADD_TO_CART, payload: order });
    } else {
      quantity++;
      const order = { quantity, product };
      dispatch({type: REMOVE_FROM_CART, payload: checkProductInCart})
      dispatch({ type: ADD_TO_CART, payload: order });
    }
  };
};

export const removeFromCartAction = index => ({ type: REMOVE_FROM_CART, payload: index });

export const emptyCartAction = () => ({ type: EMPTY_CART });

//ORDER ACTIONS

export const createOrderAction = savedOrder => {
  return async (dispatch, getState) => {
    const token = getState().auth.token;
    try {
      let resp = await fetch("http://localhost:3000/orders", {
        method: "POST",
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
        body:JSON.stringify(savedOrder),
      });
      if (resp.ok) {
        let data = await resp.json();
        dispatch({ type: CREATE_ORDER, payload: data });
      } else {
        console.log("error");
      }
    } catch (error) {
      console.log(error);
    } finally {
      console.log("fetch loading finish");
    }
  };
}