import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import newrizon_logo from '../newrizon_logo.png';
import NewrizonNavbarStyle from '../style/NewrizonNavbarStyle.css';
import { FaShoppingCart } from "react-icons/fa";

function NewrizonNavbar() {
  
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
              <NavDropdown.Item href="/products/efd36ada-9504-45f1-bbae-28f5b5b6878e" id="nav-item">Prime X1</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/products/d32f03ff-0652-44ff-96dc-85e5077cd935" id="nav-item">
                Wonder S1
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/products/8b27768b-1146-4ff5-ac92-5fbd8a903bbc" id="nav-item">Joyful M1</NavDropdown.Item>
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
            <Nav.Link href="/login" style={{ background: "linear-gradient(orange, yellow)", border: "solid", borderRadius: "5px" }}>Login</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NewrizonNavbar;