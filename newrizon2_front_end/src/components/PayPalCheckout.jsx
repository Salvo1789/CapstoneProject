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
            createOrder: (data, actions, err) => {
                return actions.order.create({
                    intent: "CAPTURE",
                    purchase_units: [
                      
                        {
                          description:  "Newrizon",
                          amount: {
                            currency_code: "EUR",
                            value: 
                            cart.reduce((accumulator, currentValue) => accumulator + parseFloat(currentValue.price), 0).toFixed(2),
                          } 
                        }
                    ],
                    
                });
            },
            onApprove: async (data, actions) => {
                const order = await actions.order.capture();
      
                console.log("success", order);
                setTransactionStatus("success");
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