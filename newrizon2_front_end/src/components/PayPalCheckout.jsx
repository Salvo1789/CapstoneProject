import React, { useRef, useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import PaymentSuccess from "./PaymentSuccess";
import PaymentFailure from "./PaymentFailure";
import { createOrderAction, emptyCartAction } from "../redux/actions";

function PayPalCheckout(){
    const paypal = useRef();
    let productOrders = [];
    const cart = useSelector(state => state.cart.content);
    const userCurrent = useSelector(state => state.auth.userData)
    const [transactionStatus, setTransactionStatus] = useState(null);
    const dispatch = useDispatch();
    
    useEffect(() => {
      window.paypal
      .Buttons({
        createOrder: (data, actions, err) => {
          return actions.order.create({
            intent: "CAPTURE",
            purchase_units: [
              
              {
                description:  "Newrizon",
                amount: {
                  currency_code: "EUR",
                  value: 
                  cart.reduce((accumulator, currentValue) => accumulator + parseFloat(currentValue.product.price*currentValue.quantity), 0).toFixed(2),
                } 
              }
            ],
            
          });
        },
        onApprove: async (data, actions) => {
          const order = await actions.order.capture();
          console.log("success", order);
          setTransactionStatus("success");
          const userId = userCurrent.id;
          cart.map(orderProd =>
            productOrders.push(orderProd)
            );
            const savedOrder = {productOrders, userId}
            console.log(savedOrder);
            dispatch(createOrderAction(savedOrder));
            // dispatch(emptyCartAction());
              },
              onError: (err) => {
                console.log(err);
                console.log(cart);
                setTransactionStatus("failure");
              },
            })
            .render(paypal.current);
        }, []);

        if (transactionStatus === "success") {
            return <PaymentSuccess />;
          }
        
          if (transactionStatus === "failure") {
            return <PaymentFailure />;
          }
        
          return (
            <div>
              <div ref={paypal}></div>
            </div>
          );
}

export default PayPalCheckout;