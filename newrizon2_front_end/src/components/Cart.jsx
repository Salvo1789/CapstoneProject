import { Container, Col, Row, Button, ListGroup, Alert } from "react-bootstrap";
import { FaTrash, FaShoppingCart } from "react-icons/fa";
import { useDispatch, useSelector } from "react-redux";
import { removeFromCartAction } from "../redux/actions";
import PayPalCheckout from './PayPalCheckout';
import { useState } from "react";

const Cart = () => {
  const [checkout, setCheckOut] = useState(false);
  const userCurrent = useSelector(state => state.auth.userData)
  const cart = useSelector(state => state.cart.content);
  const dispatch = useDispatch();
  console.log(cart);
  // cart sarà l'array contenuto in state.cart.content

  return (
    <Container fluid className="min-vh-100">
    <Row>
      <Col sm={12} className="font-weight-bold mb-5 ms-3">
        TOTAL:{" "}
          {userCurrent ? (
        <span className="display-6" style={{color: "orange"}}>
          {cart.reduce((accumulator, currentValue) => accumulator + parseFloat(currentValue.product.price*currentValue.quantity), 0).toFixed(2)}€
          </span>
          ):(
            <span className="display-6" style={{color: "orange"}}>
              0.00 € 
            </span>
          )}
      </Col>
      <Col sm={12} className="mb-5">
        <ListGroup variant="flush">
          {cart.length > 0 && userCurrent ? (
            cart.map((order, i) => (
              <ListGroup.Item key={i} style={{ width: "50%", border: "solid", borderColor: "orange", backgroundColor: "black", marginBottom: "2rem"}}>
                <Button
                  variant="danger"
                  onClick={() => {
                    // dispatch({ type: REMOVE_FROM_CART, payload: i });
                    dispatch(removeFromCartAction(i));
                  }}
                >
                  <FaTrash />
                </Button>
                <img className="book-cover-small mx-5" src={order.product.productPic} alt="book selected" width="200rem" height="200rem"/>
                <span style={{color: "orange", fontWeight: "bold"}}>{order.product.name}</span>
                <p>Q.tà: {order.quantity}</p>
              </ListGroup.Item>
            ))
          ) : (
            <ListGroup.Item className="lead w-50">
              <span className="text-primary opacity-50 fs-1 me-2">
                {" "}
                <FaShoppingCart style={{color: "orange"}} />
              </span>
              Your cart is empty
            </ListGroup.Item>
          )}
        </ListGroup>
      </Col>
      <Col sm={12} className="mb-5">
      {userCurrent ?  (
      checkout && cart.length>0  ? (
            <PayPalCheckout  />
          ) : (
            <div className="Product">
              <button
                className="checkout text-dark"
                style={{background: "linear-gradient(orange, yellow)", border: "solid", borderRadius: "5px" }}
                onClick={() => {
                  setCheckOut(true);
                }}
              >
                Checkout
              </button>
            </div>
          )):(
            <Alert style={{ border: "solid", borderColor: "orange", backgroundColor: "black", color: "orange" }}>Loggati prima di procedere</Alert>
          )}
      </Col>
    </Row>
    </Container>
  );
};

export default Cart;