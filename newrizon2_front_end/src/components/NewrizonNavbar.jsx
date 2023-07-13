import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import newrizon_logo from '../newrizon_logo.png';
import NewrizonNavbarStyle from '../style/NewrizonNavbarStyle.css';

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
              <NavDropdown.Item href="/product/46408488-c8d0-444d-929b-bc5a0a14d550" id="nav-item">Prime X1</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/product/06ef9495-daa8-4945-bccc-4ba0441da898" id="nav-item">
                Wonder S1
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/product/d3509d27-beb1-414b-be28-36678c0b53aa" id="nav-item">Joyful M1</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Accessori" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1" id="nav-item">Alimentatori</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.2" id="nav-item">
                Cover
              </NavDropdown.Item>
            </NavDropdown>
            <Nav.Link href="#home">Supporto</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NewrizonNavbar;