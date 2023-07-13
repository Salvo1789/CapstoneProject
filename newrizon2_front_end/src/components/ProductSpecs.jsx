import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { Container, Row, Col, Card, ListGroup } from 'react-bootstrap';
import { useEffect } from "react";
import { getProductAction } from '../redux/actions';

const ProductSpecs = () => {
  const product = useSelector((state) => state.product.content);
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
              </ListGroup>
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
