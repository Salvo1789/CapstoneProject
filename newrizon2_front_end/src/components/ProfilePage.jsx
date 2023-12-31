import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { emptyCartAction, getUserDataAction, logoutAction } from '../redux/actions';
import { useNavigate } from "react-router-dom";
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import { FaPenSquare } from "react-icons/fa";

function ProfilePage(){

  const userCurrent = useSelector(state => state.auth.userData)
  const dispatch = useDispatch();
  const navigate = useNavigate();

  useEffect(() => {
    dispatch(getUserDataAction());

    
  }, []);

  return (
      
      <Container className="py-5 vh-100" >
        <Row className="justify-content-center align-items-center h-100">
          <Col lg="6" className="mb-4 mb-lg-0">
            <Card className="mb-3" style={{ borderRadius: '.5rem'}}>
              <Row className="g-0">
                <Col md="4" className="gradient-custom text-center text-white"
                  style={{ borderTopLeftRadius: '.5rem', borderBottomLeftRadius: '.5rem' }}>
                  <Card.Img src="https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg"
                    alt="Avatar" className="my-5" style={{ width: '80px' }} fluid />
                  <h5 className="text-dark">{userCurrent.name} {userCurrent.surname}</h5>
                  <FaPenSquare></FaPenSquare>
                </Col>
                <Col md="8">
                  <Card.Body className="p-4">
                    <h6>Information</h6>
                    <hr className="mt-0 mb-4" />
                    <Row className="pt-1">
                      <Col size="6" className="mb-3">
                        <h6>Email</h6>
                        <Card.Text className="text-muted">{userCurrent.email}</Card.Text>
                      </Col>
                      
                    </Row>
                    <hr className="mt-0 mb-4" />
                    <Row className="pt-1">
                    <Col size="12" className="mb-3">
                      <h6>Ordini</h6>
                      {userCurrent.ordersList.length > 0 ? ( userCurrent.ordersList.map((order) => (
                          <p>Num. ordine: {order.id} <br></br> Data acquisto:{order.orderDate}<br></br>Importo: {order.totalOrderPrice}</p>
                      ))):(
                        <p>Nessun ordine effettuato</p>
                      )}
                    </Col>
                    </Row>
                    <Button
                  style={{ background: "linear-gradient(orange, yellow)", border: "solid", borderRadius: "5px", color: "black" }}
                    onClick={() => {
                      dispatch(emptyCartAction());
                      dispatch(logoutAction());
                      navigate("/");
                      // sto dispatchando un'action creator
                      // è la stessa cosa che dispatchare l'action
                      // perchè l'action creator è una funzione che torna l'action
                    }}
                  >
                    LOG OUT
                  </Button>
                  </Card.Body>
                </Col>
              </Row>
            </Card>
          </Col>
        </Row>
      </Container> 
  );
}

export default ProfilePage;