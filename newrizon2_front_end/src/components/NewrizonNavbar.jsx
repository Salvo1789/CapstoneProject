import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import newrizon_logo from '../newrizon_logo.png';
import { FaShoppingCart } from "react-icons/fa";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { getUserDataAction } from '../redux/actions';

function NewrizonNavbar() {

  const userCurrent = useSelector(state => state.auth.userData)
  console.log(userCurrent);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getUserDataAction());

    
  }, []);
  
  return (
    <Navbar expand="lg" className="bg-body-dark">
      <Container >
        <Navbar.Brand href="/">
        <img src={newrizon_logo} alt="" width="100px"/>
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <NavDropdown title="Smartphone" id="basic-nav-dropdown">
              <NavDropdown.Item href="/products/19bdcda1-3bbd-4e3f-89a7-e7cef3a1c2b7" id="nav-item">Prime X1</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/products/450c81ab-70f9-4367-859e-17adc8fed615" id="nav-item">
                Wonder S1
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/products/adf1c408-107b-47c7-a6ec-f649d49b84b1" id="nav-item">Joyful M1</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Accessori" id="basic-nav-dropdown">
              <NavDropdown.Item href="/products/accessories/charger" id="nav-item">Alimentatori</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/products/accessories/cover" id="nav-item">
                Cover
              </NavDropdown.Item>
            </NavDropdown>
            <Nav.Link href="#home">Supporto</Nav.Link>
            <Nav.Link href="/cart">
            <FaShoppingCart style={{color: "orange"}}/>
            </Nav.Link>
            {userCurrent ? (
              <Nav.Link href="/profile/me" style={{ background: "linear-gradient(orange, yellow)", border: "solid", borderRadius: "5px" }}>Bentornato, {userCurrent.username}</Nav.Link>
            
            ) : (
              <Nav.Link href="/login" style={{ background: "linear-gradient(orange, yellow)", border: "solid", borderRadius: "5px" }}>Login</Nav.Link>
            )}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NewrizonNavbar;