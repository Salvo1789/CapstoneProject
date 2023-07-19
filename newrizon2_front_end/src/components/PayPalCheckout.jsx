import React, { useRef, useEffect, useState } from "react";
import { useSelector } from "react-redux";
import PaymentSuccess from "./PaymentSuccess";
import PaymentFailure from "./PaymentFailure";

function PayPalCheckout(){
    const paypal = useRef();
    const cart = useSelector(state => state.cart.content);
    const [transactionStatus, setTransactionStatus] = useState(null);

    useEffect(() => {
        window.paypal
        .Buttons({
            createOrder: (cart, actions, err) => {
                return actions.order.create({
                    intent: "CAPTURE",
                    purchase_units: [
                      cart.length > 0 && (cart.map((product) => (
                        {
                          name:  `${product.name}`,
                          amount: {
                            currency_code: "USD",
                            value: 
                                `${product.price}`,
                          } 
                        }
                        )))
                    ]
                });
            },
            onApprove: async (cart, actions) => {
                const order = await actions.order.capture();
      
                console.log("success", order);
                setTransactionStatus("success");
              },
              onError: (err) => {
                console.log(err);
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