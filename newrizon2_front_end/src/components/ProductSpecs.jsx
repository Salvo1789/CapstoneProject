import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { Container, Row, Col, Card, ListGroup, Button, Alert } from 'react-bootstrap';
import { useEffect } from "react";
import { getProductAction } from '../redux/actions';
import { addToCartAction } from '../redux/actions';

const ProductSpecs = () => {
  const product = useSelector((state) => state.product.content);
  const userCurrent = useSelector(state => state.auth.userData);
  const dispatch = useDispatch();
  const params = useParams();


  useEffect(() => {
    dispatch(getProductAction(params.productId));

    
  }, []);

  return (
    <>
      <Container>
        <Row>
          <Col md={6}>
            <Card style={{ border: "0" }}>
              <Card.Header style={{ backgroundColor: "white", border: "0" }}>{product.name}</Card.Header>
              <ListGroup variant="flush">
                <ListGroup.Item style={{ color: "orange", border: "0" }}>{product.display}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.cpu}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.ram}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.rom}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.battery}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.rapidRecharge}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.cam1}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.cam2}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.cam3}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.cam4}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}>{product.os}</ListGroup.Item>
                <ListGroup.Item style={{ color: "orange",border: "0" }}><strong>{product.price} €</strong></ListGroup.Item>
              </ListGroup>
              {userCurrent ? (
                  <Button
                  style={{ background: "linear-gradient(orange, yellow)", color: "black", border: "solid", borderRadius: "5px" }}
                    onClick={() => {
                      // dispatch({ type: ADD_TO_CART, payload: bookSelected });
                      dispatch(addToCartAction(product));
                      // sto dispatchando un'action creator
                      // è la stessa cosa che dispatchare l'action
                      // perchè l'action creator è una funzione che torna l'action
                    }}
                  >
                    ADD TO CART
                  </Button>
                ) : (
                  <Alert variant="warning">Loggati prima di procedere</Alert>
                )}
            </Card>
          </Col>
          <Col md={6}>
            <Card style={{ border: "0" }}>
              <Card.Img src={product.productPic} />
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
};

export default ProductSpecs;
