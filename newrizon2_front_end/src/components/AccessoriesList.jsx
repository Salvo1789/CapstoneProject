import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { Container, Row, Col, Card, ListGroup, Alert, Button, Modal } from 'react-bootstrap';
import { useEffect, useState } from "react";
import { getAllProductsAction } from '../redux/actions';
import { addToCartAction } from "../redux/actions";

const AccessoriesList = () => {
  const products = useSelector((state) => state.products.avaiable);
  const dispatch = useDispatch();
  const params = useParams();

  const userCurrent = useSelector(state => state.auth.userData)
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  useEffect(() => {
    dispatch(getAllProductsAction(params.type));
    
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  

  
  return(
    
      <Container fluid className="min-vh-100">
        <Modal show={show} onHide={handleClose} >
        <Modal.Header closeButton style={{ background: "linear-gradient(orange, yellow)", border: "solid", borderRadius: "5px" }}>
          <Modal.Title>Prodotto aggiunto</Modal.Title>
        </Modal.Header>
      </Modal>
        <Row>

    {products && products.content.map( (prod) => (
      <>
            <Col md={2} className="px-auto">
              <Card style={{ border: "solid", borderColor: "orange", backgroundColor: "black", marginBottom: "2rem"}} key={prod.id}>
                <Card.Header style={{ backgroundColor: "black", color: "white", border: "0" }}>{prod.name}</Card.Header>
                <ListGroup variant="flush">
                  {prod.type === "charger" && (
                    <>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange", border: "0" }}><span className="text-light">Output: </span>{prod.output}</ListGroup.Item>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange",border: "0" }}><span className="text-light">Tecnologia RapidRecharge: </span>{prod.rapidRecharge ? ("Compatibile"):("Non compatibile")}</ListGroup.Item>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange",border: "0" }}><span className="text-light">Potenza: </span>{prod.power}</ListGroup.Item>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange",border: "0" }}><span className="text-light">Colore: </span>{prod.chargerColor}</ListGroup.Item>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange",border: "0" }}><span className="text-light">Prezzo: </span><strong>{prod.price} €</strong></ListGroup.Item>
                  </>
                  )}
                  {prod.type === "cover" && (
                    <>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange", border: "0" }}><span className="text-light">Materiale: </span>{prod.material}</ListGroup.Item>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange",border: "0" }}><span className="text-light">Resistente all'acqua: </span>{prod.waterproof ? ("Certificazione IP68"):("N/A")}</ListGroup.Item>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange",border: "0" }}><span className="text-light">Colore: </span>{prod.coverColor}</ListGroup.Item>
                  <ListGroup.Item style={{ backgroundColor: "black", color: "orange",border: "0" }}><span className="text-light">Prezzo: </span><strong>{prod.price} €</strong></ListGroup.Item>
                  </>
                  )}
                </ListGroup>
                {userCurrent ? (
                  <Button
                  style={{ background: "linear-gradient(orange, yellow)", color: "black", border: "solid", borderRadius: "5px" }}
                    onClick={() => {
                      // dispatch({ type: ADD_TO_CART, payload: bookSelected });
                      dispatch(addToCartAction(prod));
                      handleShow();
                      // sto dispatchando un'action creator
                      // è la stessa cosa che dispatchare l'action
                      // perchè l'action creator è una funzione che torna l'action
                    }}
                  >
                    ADD TO CART
                  </Button>
                ) : (
                  <Alert style={{ border: "solid", borderColor: "orange", backgroundColor: "black", color: "orange" }}>Loggati prima di procedere</Alert>
                )}
              </Card>
            </Col>
            <Col md={2} style={{display: "flex", justifyContent:"space-around", alignItems: "center" }}>
              <Card style={{ border: "0", height: "15rem", width: "10rem", background: "transparent"}}>
                <Card.Img src={prod.productPic}/>
              </Card>
            </Col>
            </>
    ))}
    </Row>
    </Container> 
)
};

export default AccessoriesList;