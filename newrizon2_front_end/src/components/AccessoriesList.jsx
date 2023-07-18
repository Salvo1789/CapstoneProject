import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { Container, Row, Col, Card, ListGroup, Alert, Button } from 'react-bootstrap';
import { useEffect } from "react";
import { getAllProductsAction } from '../redux/actions';
import { addToCartAction } from "../redux/actions";

const AccessoriesList = () => {
  const products = useSelector((state) => state.products.avaiable);
  const dispatch = useDispatch();
  const params = useParams();

  const userCurrent = useSelector(state => state.auth.userData)

  useEffect(() => {
    dispatch(getAllProductsAction(params.type));
    
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  

  
  return(
    
      <Container >
        <Row>

    {products && products.content.map( (prod) => (
      <>
            <Col md={2}>
              <Card style={{ border: "0" }} key={prod.id}>
                <Card.Header style={{ backgroundColor: "white", border: "0" }}>{prod.name}</Card.Header>
                <ListGroup variant="flush">
                  {prod.type === "charger" && (
                    <>
                  <ListGroup.Item style={{ color: "orange", border: "0" }}>{prod.output}</ListGroup.Item>
                  <ListGroup.Item style={{ color: "orange",border: "0" }}>{prod.rapidRecharge}</ListGroup.Item>
                  <ListGroup.Item style={{ color: "orange",border: "0" }}>{prod.power}</ListGroup.Item>
                  <ListGroup.Item style={{ color: "orange",border: "0" }}>{prod.chargerColor}</ListGroup.Item>
                  </>
                  )}
                  {prod.type === "cover" && (
                    <>
                  <ListGroup.Item style={{ color: "orange", border: "0" }}>{prod.material}</ListGroup.Item>
                  <ListGroup.Item style={{ color: "orange",border: "0" }}>{prod.waterproof}</ListGroup.Item>
                  <ListGroup.Item style={{ color: "orange",border: "0" }}>{prod.coverColor}</ListGroup.Item>
                  </>
                  )}
                </ListGroup>
                {userCurrent ? (
                  <Button
                  style={{ background: "linear-gradient(orange, yellow)", border: "solid", borderRadius: "5px" }}
                    onClick={() => {
                      // dispatch({ type: ADD_TO_CART, payload: bookSelected });
                      dispatch(addToCartAction(prod));
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
            <Col md={2}>
              <Card style={{ border: "0"}}>
                <Card.Img src={prod.productPic} />
              </Card>
            </Col>
            </>
    ))}
    </Row>
    </Container> 
)
};

export default AccessoriesList;