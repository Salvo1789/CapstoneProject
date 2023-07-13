export const ADD_PRODUCT = "ADD_PRODUCT";

export const getProductAction = productId => {
    return async dispatch => {
      const endpoint = "http://localhost:3000/products/" + productId;
      const fetchOpt = {
        headers: {
          Authorization:
            "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJzYWx2by5tZXJjdXJpb0BuZXdyaXpvbi5pdCIsImlhdCI6MTY4ODk5NjMwMiwiZXhwIjoxNjg5NjAxMTAyfQ.ihU_-rx6BhaUi3mPAr1VqAgQJwdy1-avRL9Mt7ZaNDTN_EPN9Jiq2NCEh13Cdpl-",
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