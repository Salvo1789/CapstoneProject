import { configureStore, combineReducers } from "@reduxjs/toolkit";
import productReducer from "../reducers/productReducer";
import productsReducer from "../reducers/productsReducer";
import userReducer from "../reducers/userReducer";
import adminReducer from "../reducers/adminReducer";
import cartReducer from "../reducers/cartReducer";
import productSelectedReducer from "../reducers/productSelectedReducer";

import storage from "redux-persist/lib/storage";

import { persistStore, persistReducer } from "redux-persist";
import { encryptTransform } from "redux-persist-transform-encrypt";
import authReducer from "../reducers/authReducer";
import orderReducer from "../reducers/orderReducer";

const persistConfig = {
  key: "root",
  storage,
  transforms: [
    encryptTransform({
      secretKey: process.env.REACT_APP_PERSIST_KEY
    })
  ]
};

const bigReducer = combineReducers({
  product: productReducer,
  products: productsReducer,
  productSelected: productSelectedReducer,
  user: userReducer,
  admin: adminReducer,
  auth: authReducer,
  cart: cartReducer,
  order: orderReducer
});

const persistedReducer = persistReducer(persistConfig, bigReducer);

const store = configureStore({
  reducer: persistedReducer,
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({ serializableCheck: false }),
});

export const persistor = persistStore(store);

export default store;