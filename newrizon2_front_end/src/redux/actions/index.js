export const ADD_PRODUCT = "ADD_PRODUCT";
export const ADD_PRODUCTS = "ADD_PRODUCTS";
export const SET_ADMIN_NAME = "SET_ADMIN_NAME";
export const SET_USER_NAME = "SET_USER_NAME";
export const USER_LOGIN = "USER_LOGIN";
export const USER_LOGOUT = "USER_LOGOUT";
export const USER_REGISTER = "USER_REGISTER";
export const GET_USER_DATA = "GET_USER_DATA";
export const logout = () => ({ type: USER_LOGOUT });
export const ADD_TO_CART = "ADD_TO_CART";
export const REMOVE_FROM_CART = "REMOVE_FROM_CART";

//PRODUCTS ACTIONS

export const getProductAction = (productId) => {
  return async (dispatch) => {
    // const token = getState().auth.token;

    const endpoint = "http://localhost:3000/products/" + productId;
    const fetchOpt = {
      headers: {
        //'Bearer ' + token
        Authorization:
          "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJzYWx2by5tZXJjdXJpb0BuZXdyaXpvbi5pdCIsImlhdCI6MTY4OTYwNTY0MywiZXhwIjoxNjkwMjEwNDQzfQ._r46KuzVyK9OZlQTaLFDHGDjZtZREtBI2crZix-H-t9R4lCBtJGE9hQby9sL-22O",
      },
    };
    console.log(endpoint);
    try {
      const resp = await fetch(endpoint, fetchOpt);
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
    const fetchOpt = {
      headers: {
        Authorization:
          "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJzYWx2by5tZXJjdXJpb0BuZXdyaXpvbi5pdCIsImlhdCI6MTY4OTYwNTY0MywiZXhwIjoxNjkwMjEwNDQzfQ._r46KuzVyK9OZlQTaLFDHGDjZtZREtBI2crZix-H-t9R4lCBtJGE9hQby9sL-22O",
      },
    };
    console.log(endpoint);
    try {
      const resp = await fetch(endpoint, fetchOpt);
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
      let resp = await fetch("http://localhost:3000/user/me", {
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

//CART ACTIONS

export const addToCartAction = bookSelected => ({ type: ADD_TO_CART, payload: bookSelected });

export const removeFromCartAction = index => ({ type: REMOVE_FROM_CART, payload: index });