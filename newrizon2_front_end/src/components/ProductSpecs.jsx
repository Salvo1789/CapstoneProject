import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import {
  Container,
  Row,
  Col,
  Card,
  ListGroup,
  Button,
  Alert,
  Modal
} from "react-bootstrap";
import { useEffect, useState } from "react";
import { getProductAction } from "../redux/actions";
import { addToCartAction } from "../redux/actions";

const ProductSpecs = () => {
  const product = useSelector((state) => state.product.content);
  const userCurrent = useSelector((state) => state.auth.userData);
  const dispatch = useDispatch();
  const params = useParams();
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  useEffect(() => {
    dispatch(getProductAction(params.productId));
  }, []);

  return (
    <>
      <Container>
      <Modal show={show} onHide={handleClose} >
        <Modal.Header closeButton style={{ background: "linear-gradient(orange, yellow)", border: "solid", borderRadius: "5px" }}>
          <Modal.Title>Prodotto aggiunto</Modal.Title>
        </Modal.Header>
      </Modal>
        <Row>
          <Col md={6}>
            <Card
              style={{
                border: "solid",
                borderColor: "orange",
                backgroundColor: "black",
              }}
            >
              <Card.Header style={{ color: "white", border: "0" }}>
                {product.name}
              </Card.Header>
              <ListGroup>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Display: </span>
                  {product.display}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Processore: </span>
                  {product.cpu}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">RAM: </span>
                  {product.ram}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">ROM: </span>
                  {product.rom}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Capacità batteria: </span>
                  {product.battery}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Tecnologia RapidRecharge: </span>
                  {product.rapidRecharge ? ("Compatibile"):("Non compatibile")}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Fotocamera principale: </span>
                  {product.cam1}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Fotocamera n°2: </span>
                  {product.cam2}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Fotocamera n°3: </span>
                  {product.cam3}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Fotocamera n°4: </span>
                  {product.cam4}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Sistema operativo: </span>
                  {product.os}
                </ListGroup.Item>
                <ListGroup.Item
                  style={{
                    backgroundColor: "black",
                    color: "orange",
                    border: "0",
                  }}
                >
                  <span className="text-light">Prezzo di vendita: </span>
                  <strong>{product.price} €</strong>
                </ListGroup.Item>
              </ListGroup>
              {userCurrent ? (
                <Button
                

                  style={{
                    background: "linear-gradient(orange, yellow)",
                    color: "black",
                    border: "solid",
                    borderRadius: "5px",
                  }}
                  onClick={() => {
                    // dispatch({ type: ADD_TO_CART, payload: bookSelected });
                    dispatch(addToCartAction(product));
                    handleShow();

                    // sto dispatchando un'action creator
                    // è la stessa cosa che dispatchare l'action
                    // perchè l'action creator è una funzione che torna l'action
                  }}
                >
                  ADD TO CART
                </Button>
                
              ) : (
                <Alert
                  style={{
                    border: "solid",
                    borderColor: "orange",
                    backgroundColor: "black",
                    color: "orange",
                  }}
                >
                  Loggati prima di procedere
                </Alert>
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
