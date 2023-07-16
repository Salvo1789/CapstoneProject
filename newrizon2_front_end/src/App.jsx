import { BrowserRouter, Route, Routes } from "react-router-dom";
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import NewrizonNavbar from './components/NewrizonNavbar';
import NewrizonFooter from './components/NewrizonFooter';
import NewrizonHomepage from "./components/NewrizonHomepage";
import ProductSpecs from './components/ProductSpecs';
import AccessoriesList from './components/AccessoriesList';

function App() {
  return (
    <div >
      <BrowserRouter>
        <NewrizonNavbar />
        <Routes>
        <Route path="/" element={<NewrizonHomepage />} />
        <Route path="/products/:productId" element={<ProductSpecs />} />
        <Route path="/products/accessories/:type" element={<AccessoriesList />} />
        </Routes>
        <NewrizonFooter />
      </BrowserRouter>
    </div>
  );
}

export default App;
