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
              <NavDropdown.Item href="/products/100ba2af-5325-42fb-8b53-c9996b9ee9b9" id="nav-item">Prime X1</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/products/509620d3-563b-47fb-ae8a-b212d01bf4ba" id="nav-item">
                Wonder S1
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/products/9c9f12e4-8956-48c7-937b-f34cdadd2ce6" id="nav-item">Joyful M1</NavDropdown.Item>
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