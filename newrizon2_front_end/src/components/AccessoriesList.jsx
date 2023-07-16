import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { Container, Row, Col, Card, ListGroup } from 'react-bootstrap';
import { useEffect } from "react";
import { getAllProductsAction } from '../redux/actions';

const AccessoriesList = () => {
  const products = useSelector((state) => state.products.avaiable);
  const dispatch = useDispatch();
  const params = useParams();

  useEffect(() => {
    dispatch(getAllProductsAction(params.type));
    
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  

  
  return(
    
      <Container >
        <Row>

    {products && products.content.map( prod => (
      <>
            <Col md={2}>
              <Card style={{ border: "0" }}>
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