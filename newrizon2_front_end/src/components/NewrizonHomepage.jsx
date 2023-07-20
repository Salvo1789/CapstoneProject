import Carousel from 'react-bootstrap/Carousel';
import { Container } from "react-bootstrap";
import NewrizonHomepageStyle from '../style/NewrizonHomepageStyle.css';

function NewrizonHomepage(){
return (
  <Container className='px-0'fluid>
    <Carousel>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="https://gagadget.com/media/cache/2f/c3/2fc39a09dc26273c43b6a6f8e404e011.png"
          alt="First slide"
          height="600rem"
        />
        <Carousel.Caption>
          <h3>Prime X1</h3>
          <p>Il Top della User Xperience</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="https://images.samsung.com/is/image/samsung/assets/it/smartphones/galaxy-s22/images/galaxy-s22_highlights_kv_bora_img.jpg"
          alt="Second slide"
          height="600rem"
        />

        <Carousel.Caption>
          <h3>Wonder S1</h3>
          <p>Una nuova definizione di Best Buy</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100"
          src="https://static.realme.net/v2/realme-10/images/banner/bg-7f35686c78.jpg"
          alt="Third slide"
          height="600rem"
        />

        <Carousel.Caption>
          <h3>Joyful M1</h3>
          <p>
            Bello e concreto
          </p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
    </Container>
);
}
export default NewrizonHomepage;